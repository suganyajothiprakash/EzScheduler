package com.sailotech.testautomation.ezscheduler.accerlators;

import java.awt.event.AWTEventListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.sailotech.testautomation.ezscheduler.commonutilities.SendMail;
import com.sailotech.testautomation.ezscheduler.commonutilities.TestUtil;
import com.sun.istack.internal.logging.Logger;

public class TestBase1 {

  public static WebDriver driver;
  String chrome = "chrome";
  String firefox = "firefox";
  String ie = "ie";
  public static Properties prop;
  public static Logger log = Logger.getLogger(TestBase.class);
  public static EventFiringWebDriver e_driver;
  public static AWTEventListener eventListener;
  private static String EXECUTION_ENV = System.getProperty("os.name");
  private static String LINUX_ENV = "Linux";

  //	static String user_dir = System.getProperty("user.dir");
  // protected  static  PropertiesReaderUtility prop = new PropertiesReaderUtility(user_dir +
  // "\\selenium.properties");

  public static SoftAssert softAssert = new SoftAssert();

  public static String envRelativePath(String windowsPath) {
    if (EXECUTION_ENV.equals(LINUX_ENV)) {
      return windowsPath.replaceAll("\\\\", "/");
    }
    return windowsPath;
  }

  public TestBase1() {
    prop = new Properties();
    FileInputStream fis = null;
    try {
      fis =
          new FileInputStream(
              System.getProperty("user.dir") + envRelativePath("\\resources\\selenium.properties"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    try {
      prop.load(fis);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void initialization() {
    log.info("launching browser");

    String browserName = prop.getProperty("browser");
    String chromeDriverPath =
        (EXECUTION_ENV.equals(LINUX_ENV))
            ? "/drivers/Linux/chromedriver_87"
            : "\\drivers\\chromedriver.exe";
    if (browserName.equalsIgnoreCase("chrome")) {
      System.setProperty(
          "webdriver.chrome.driver", System.getProperty("user.dir") + chromeDriverPath);
      ChromeOptions options = new ChromeOptions();
      //	options.setPageLoadStrategy(PageLoadStrategy.NONE);
      options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770

      // close the pop-ups
      options.addArguments("--disable-notifications");

      // to enable screenShot and fix timeouts received from renderer
      options.addArguments("--disable-features=VizDisplayCompositor");
      //	options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
      //	options.addArguments("--headless"); // only if you are ACTUALLY running headless
      //	options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
      //	options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
      //	options.addArguments("--disable-dev-shm-usage");
      // //https://stackoverflow.com/a/50725918/1689770
      //	options.addArguments("--disable-browser-side-navigation");
      // //https://stackoverflow.com/a/49123152/1689770
      options.addArguments(
          "--disable-gpu"); // https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
      driver = new ChromeDriver(options);
      //	driver = new ChromeDriver();
      log.info("launching chrome browser");
    } else if (browserName.equalsIgnoreCase("firefox")) {
      System.setProperty(
          "webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
      driver = new FirefoxDriver();
      log.info("launching firefox browser");
    } else {
      System.out.println("no proper browser initialized");
    }
    e_driver = new EventFiringWebDriver(driver);
    // eventListener = new AWTEventListener();
    e_driver.register((WebDriverEventListener) eventListener);
    driver = e_driver;

    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);

    ////// driver.get(AquilaParamUtils.getAppURL(prop.getProperty("baseurl_qa")));
    log.info("entering into application URL");
  }

  @AfterMethod // AfterMethod annotation - This method executes after every
  // test execution
  public void screenShot(ITestResult result) {
    // using ITestResult.FAILURE is equals to result.getStatus then it enter
    // into if condition
    if (ITestResult.FAILURE == result.getStatus() || ITestResult.SUCCESS == result.getStatus()) {
      try {
        // To create reference of TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        filesMovetoFolder();

        // Copy files to specific location
        // result.getName() will return name of test case so that
        // screenshot name will be same as test case name

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date dt = new Date();

        FileUtils.copyFile(
            src,
            new File(
                System.getProperty("user.dir")
                    + envRelativePath("\\FailedScreens\\")
                    + "PassedScreenshot"
                    + dateFormat.format(dt)
                    + ".png"));
        System.out.println("Successfully captured a screenshot");

        FileUtils.copyFile(
            src,
            new File(
                System.getProperty("user.dir")
                    + envRelativePath("\\FailedScreens\\")
                    + "errorscreen.png"));
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

  public void screenShot(ITestResult result, String screenshotName) {
    try {
      Thread.sleep(5000);
      // To create reference of TakesScreenshot
      TakesScreenshot screenshot = (TakesScreenshot) driver;
      // Call method to capture screenshot
      File src = screenshot.getScreenshotAs(OutputType.FILE);

      FileUtils.copyFile(src, new File(screenshotName));
    } catch (Exception e) {
      System.out.println("Exception while taking screenshot: " + e.getMessage());
    }
  }

  public String getScreenShot(ITestResult result, String fileName) {
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
    Date dt = new Date();
    String fileNameDt = fileName + dateFormat.format(dt) + ".png";
    String relitiveath = "Screens/" + fileNameDt;
    String filePath = System.getProperty("user.dir") + envRelativePath("\\Screens\\") + fileNameDt;

    if (ITestResult.FAILURE == result.getStatus() || ITestResult.SUCCESS == result.getStatus()) {
      try {
        // To create reference of TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src, new File(filePath));
        System.out.println("Successfully captured a screenshot");

        return relitiveath;
      } catch (Exception e) {
        System.out.println("Exception while taking screenshot: " + e.getMessage());
      }
    }
    return relitiveath;
  }

  public String getScreenShot(String fileName) {
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
    Date dt = new Date();
    String fileNameDt = fileName + dateFormat.format(dt) + ".png";
    String relitiveath = "Screens/" + fileNameDt;
    String filePath = System.getProperty("user.dir") + envRelativePath("\\Screens\\") + fileNameDt;

    try {
      // To create reference of TakesScreenshot
      TakesScreenshot screenshot = (TakesScreenshot) driver;
      // Call method to capture screenshot
      File src = screenshot.getScreenshotAs(OutputType.FILE);
      //			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(src, new File(filePath));
      System.out.println("Successfully captured a screenshot");

      return relitiveath;
    } catch (Exception e) {
      System.out.println(
          "Exception while taking screenshot: "
              + e.getMessage()
              + " StackTrace: "
              + e.getStackTrace());
    }

    return relitiveath;
  }

  public static void filesMovetoFolder() {
    File destinationFolder =
        new File(System.getProperty("user.dir") + envRelativePath("\\OldFailedScreens"));
    File sourceFolder =
        new File(System.getProperty("user.dir") + envRelativePath("\\FailedScreens"));

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
          child.renameTo(new File(destinationFolder + envRelativePath("\\") + child.getName()));

          System.out.println("Files Moved Successfully");
        }

        // Add if you want to delete the source folder
        // sourceFolder.delete();
      }
    } else {
      System.out.println(sourceFolder + "Folder does not exists");
    }
  }

  public static void deleteTempScreensFiles() {
    File sourceFolder =
        new File(System.getProperty("user.dir") + envRelativePath("\\FailedScreens"));

    // Check weather source exists and it is folder.
    if (sourceFolder.exists() && sourceFolder.isDirectory()) {
      // Get list of the files and iterate over them
      File[] listOfFiles = sourceFolder.listFiles();

      if (listOfFiles != null) {
        for (File child : listOfFiles) {
          // Move files to destination folder
          child.delete();

          System.out.println("Files deleted Successfully");
        }

        // Add if you want to delete the source folder
        // sourceFolder.delete();
      }
    } else {
      System.out.println(sourceFolder + "Folder does not exists");
    }
  }

  public String getScreenShots(String fileName) {
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
    Date dt = new Date();
    String fileNameDt = fileName + dateFormat.format(dt) + ".png";
    String relitiveath = "Screens/" + fileNameDt;
    String filePath = System.getProperty("user.dir") + envRelativePath("\\Screens\\") + fileNameDt;

    try {
      {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src, new File(filePath));
      }
      System.out.println("Successfully captured a screenshot");

      return relitiveath;
    } catch (Exception e) {
      System.out.println("Exception while taking screenshot: " + e.getMessage());
    }

    return relitiveath;
  }

  private SendMail SendMail(WebDriver driver2) {
    // TODO Auto-generated method stub
    return null;
  }

  public static String generateRandomNumber(int length) {
    String randomNumber = "1";
    int retryCount = 1;
    while (retryCount > 0) {
      String number = Double.toString(Math.random());
      number = number.replace(".", "");
      if (number.length() > length) {
        randomNumber = number.substring(0, length);
      } else {
        int remainingLength = length - number.length() + 1;
        randomNumber = generateRandomNumber(remainingLength);
      }
      if (randomNumber.length() < length) {
        retryCount++;
      } else {
        retryCount = 0;
      }
    }
    return randomNumber;
  }

  public void enterinputValues(By locator, String locatorName, WebDriver driver, String strData1) {
    WebElement l = driver.findElement(locator);
    // input text
    // sending Ctrl+a by Keys.Chord()
    String s = Keys.chord(Keys.CONTROL, "a");
    l.sendKeys(s);
    // sending DELETE key
    l.sendKeys(Keys.DELETE);
    l.clear();
    l.sendKeys(strData1);
    l.sendKeys(Keys.TAB);
  }

  public static boolean isElementExist(WebDriver driver, By by) {

    boolean result = false;
    try {

      if (driver.findElement(by).isDisplayed()) {
        result = true;
      }

    } catch (Exception e) {
      result = false;
      // webDriver.quit();
    }
    return result;
  }

  public void closeBrowser() {
    driver.quit();
  }

  public static void continuousScrollbyJS(int count, WebDriver driver) throws InterruptedException {
    System.out.println(
        "<<<<< In continuousScrollbyJS done in BuildNAR using control END button>>>>");
    Actions actions = new Actions(driver);

    int i = 1;
    while (i <= count) {
      actions.click();
      actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
      System.out.println("i=" + i);
      i++;
      Thread.sleep(6000);
    }
    System.out.println("continuousScrollbyJS done using control END button");
  }

  public static void continuousScrollUPbyJS(int count, WebDriver driver)
      throws InterruptedException {
    System.out.println(
        "<<<<< In continuousScrollbyJS done in BuildNAR using control UP button>>>>");
    Actions actions = new Actions(driver);

    int i = 1;
    while (i <= count) {
      actions.click();
      actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
      System.out.println("i=" + i);
      i++;
      Thread.sleep(6000);
    }
    System.out.println("continuousScrollbyJS done in BuildNAR using control UP button");
  }

  public void scrollbyConfiguratorJS(By by) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement scr1 = driver.findElement(by);
    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(by));
    System.out.println("scrollbyJS using BY");
  }

  public void scrollbyConfiguratorJS(WebElement wEle) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", wEle);
    System.out.println("scrollbyJS using WEBELEMENT");
  }

  public static void zoomIn() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String zoomInJS = "document.body.style.zoom='50%'";
    js.executeScript(zoomInJS);
  }

  public static void zoomOutNOL(String zoomLevelIncrease) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.body.style.zoom='" + zoomLevelIncrease + "%'");
    System.out.println("Zoom level is set to " + zoomLevelIncrease);
  }
}
