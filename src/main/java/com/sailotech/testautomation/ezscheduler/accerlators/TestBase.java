package com.sailotech.testautomation.ezscheduler.accerlators;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.sailotech.testautomation.ezscheduler.commonutilities.PropertiesReaderUtility;
import com.sailotech.testautomation.ezscheduler.commonutilities.SendMail;
import com.sailotech.testautomation.ezscheduler.commonutilities.TestUtil;

// public class TestBase extends TestListenerAdapter {
public class TestBase {

  public static WebDriver driver;
  public static Properties locatorsProp;
  public static WebDriverWait wait;

  public static Logger log = Logger.getLogger(TestBase.class);
  // public static String user_name, password;

  String chrome = "chrome";
  String firefox = "firefox";
  String ie = "ie";

  static String user_dir = System.getProperty("user.dir");
  protected static PropertiesReaderUtility prop =
      new PropertiesReaderUtility(user_dir + "//resources//selenium.properties");

  /// inputFiles/Admin.xlsx
  @Parameters("browser")
  @BeforeClass
  public void beforeClass() throws Exception {
    startSession();
    // loadCredentails();
  }

  @AfterClass
  public void afterClass() {
    stopSession();
  }

  /* public static void initialization() {
  log.info("launching browser");

  String browserName = prop.getProperty("browser");
  String chromeDriverPath = "/drivers/Linux/chromedriver_87"
  		: "\\drivers\\chromedriver.exe";
  if (browserName.equalsIgnoreCase("chrome")) {
  	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromeDriverPath);
  	ChromeOptions options = new ChromeOptions();
  	// options.setPageLoadStrategy(PageLoadStrategy.NONE);
  	options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770

  	// close the pop-ups
  	options.addArguments("--disable-notifications");

  	// to enable screenShot and fix timeouts received from renderer
  	options.addArguments("--disable-features=VizDisplayCompositor");
  	driver = new ChromeDriver(options);
  	// driver = new ChromeDriver();
  	log.info("launching chrome browser");
  } else if (browserName.equalsIgnoreCase("firefox")) {
  	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
  	driver = new FirefoxDriver();
  	log.info("launching firefox browser");
  } else {
  	System.out.println("no proper browser initialized");
  }*/

  @AfterMethod // AfterMethod annotation - This method executes after every test execution
  public void screenShot(ITestResult result) {
    // using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
    if (ITestResult.FAILURE == result.getStatus()) {
      try {
        // To create reference of TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        filesMovetoFolder();
        // Copy files to specific location
        // result.getName() will return name of test case so that screenshot name will be same as
        // test case name

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date dt = new Date();

        FileUtils.copyFile(
            src,
            new File(
                user_dir
                    + "\\FailedScreens\\"
                    + result.getName()
                    + dateFormat.format(dt)
                    + ".png"));
        System.out.println("Successfully captured a screenshot");
        FileUtils.copyFile(src, new File(user_dir + "\\FailedScreens\\" + "errorscreen.png"));
        System.out.println("Successfully captured an error screenshot");
        SendMail sm = SendMail(driver);
        sm.main(null);
        sm.sendEmail_attachment(result);
        System.out.println("Error ScreenShot sent");
      } catch (Exception e) {
        System.out.println("Exception while taking screenshot: " + e.getMessage());
      }
    }
  }

  public void clickUsingJavascriptExecutor(By locator, String locatorName, WebDriver driver)
      throws Throwable {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    try {
      log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
      log.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
      log.info("Method : " + getCallerMethodName() + "  ::  Locator : " + locatorName);
      WebElement element = driver.findElement(locator);
      isElementPresent(locator, locatorName);
      js.executeScript("arguments[0].click();", element);
      log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
      log.info("clicked : " + locatorName);
    } catch (Exception e) {
      log.info(
          "++++++++++++++++++++++++++++Catch Block Start+++++++++++++++++++++++++++++++++++++++++++");
      log.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
      log.info(
          "++++++++++++++++++++++++++++Catch Block End+++++++++++++++++++++++++++++++++++++++++++");
    }
  }

  public static void filesMovetoFolder() {
    File destinationFolder = new File(user_dir + "\\OldFailedScreens");
    File sourceFolder = new File(user_dir + "\\FailedScreens");
    if (!destinationFolder.exists()) {
      destinationFolder.mkdirs();
    }
    // Check weather source exists and it is folder.
    if (sourceFolder.exists() && sourceFolder.isDirectory()) {
      // Get list of the files and iterate over them
      File[] listOfFiles = sourceFolder.listFiles();
      if (listOfFiles != null) {
        for (File child : listOfFiles) {
          // Move files to destination folder
          child.renameTo(new File(destinationFolder + "\\" + child.getName()));
          System.out.println("Files Moved Successfully");
        }
        // Add if you want to delete the source folder
        // sourceFolder.delete();
      }
    } else {
      System.out.println(sourceFolder + "Folder does not exists");
    }
  }

  private SendMail SendMail(WebDriver driver2) {
    // TODO Auto-generated method stub
    return null;
  }

  public static void zoomOutByZoomLevel(String zoomLevelIncrease) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.body.style.zoom='" + zoomLevelIncrease + "%'");
    System.out.println("Zoom level is set to " + zoomLevelIncrease);
  }

  public void startSession() {
    if (prop.getProperty("remoteWebdriver").equalsIgnoreCase("false")) {
      if (prop.getProperty("browser").equalsIgnoreCase(firefox)) {
        System.setProperty("webdriver.gecko.driver", user_dir + "\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        // log.info("launching browser");
      } else if (prop.getProperty("browser").equals(chrome)) {
        System.setProperty("webdriver.chrome.driver", user_dir + "\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        /*String downloadFilepath = user_dir + "\\Warehouse_xls";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        options.setExperimentalOption("prefs", chromePrefs);*/
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(cap);
        // log.info("launching browser");
      } else if (prop.getProperty("browser`").equals(ie)) {
        System.setProperty("webdriver.ie.driver", user_dir + "\\drivers\\IEDriverServer_32.exe");
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(
            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(ieCapabilities);
        // log.info("launching browser");
      }
    } else {
      URL gridUrl = null;
      try {
        gridUrl = new URL(prop.getProperty("gridHubURL"));
      } catch (MalformedURLException e) {
      }
      if (prop.getProperty("browser").equalsIgnoreCase(firefox)) {
        FirefoxProfile fp = new FirefoxProfile();
        // set something on the profile...
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, fp);
        driver = new RemoteWebDriver(gridUrl, dc);
      } else if (prop.getProperty("browser").equals(chrome)) {
        System.setProperty("webdriver.chrome.driver", user_dir + "\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // set some options
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new RemoteWebDriver(gridUrl, dc);
      } else if (prop.getProperty("browser").equals(ie)) {
        System.setProperty("webdriver.ie.driver", user_dir + "\\drivers\\IEDriverServer_32.exe");
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(
            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(ieCapabilities);
      }
    }
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.get(prop.getProperty("baseurl_qa"));
    // driver.manage().window.Size = new size(1024, 768);
    driver.manage().window().maximize();
    // driver.manage().deleteAllCookies();
  }
  
  protected static String getCallerClassName() {
		StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
		return stElements[3].getClassName();
	}
  
  protected static String getCallerMethodName() {
		StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
		return stElements[3].getMethodName();
	}
  
  public void dynamicWait(By locator) {
		try {
			log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			log.info("Class name : " + getCallerClassName() + "Method name : " + getCallerMethodName());
			log.info("Method : " + getCallerMethodName() + "  ::  Locator : " + locator);
			WebDriverWait wait = new WebDriverWait(driver, TestUtil.explicit_wait);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			log.info(locator + ":: displayed succussfully");
			log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		} catch (Exception e) {
			log.info(e.toString());

		}
	}
  
  public boolean isElementPresent(By by, String locatorName) throws Throwable {
		boolean status;
		try {
			log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			dynamicWait(by);
			driver.findElement(by);
			log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			status = true;
		} catch (Exception e) {
			status = false;
			log.info(e.toString());
		}
		return status;
	}

  public void closeBrowser() {
    // driver.close();
    driver.quit();
  }

  public void stopSession() {
    driver.close();
  }
}
