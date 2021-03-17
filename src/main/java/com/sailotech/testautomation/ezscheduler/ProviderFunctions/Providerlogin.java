package com.sailotech.testautomation.ezscheduler.ProviderFunctions;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderPage;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderRepositoryclass;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Providerlogin extends TestBase {

  //WebDriverWait wait = new WebDriverWait(driver, 30);

  @Attachment
  public byte[] NavigateEzHomePage(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void ProviderLogin(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    ProviderRepositoryclass page = new ProviderRepositoryclass(driver);
    // Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Provider.xlsx");
    @SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet s = wb.getSheetAt(0);
    //Thread.sleep(1000);

    try {
     //page.HomeLoginRegister.click();
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.HomeLoginRegister))
         .click();
    } catch (Exception e) {
      System.out.println(
          "Error: Time out Exception: could not find Home Login/Register Link/Button , Waiting for that element to be clickable \n"
              + e.getMessage());
    }

    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorLoginButton))
          .click();
    } catch (Exception e) {
      System.out.println(
          "Error: Time out Exception: could not find Doctor Login/Register Link/Button , Waiting for that element to be clickable \n"
              + e.getMessage());
    }

    for (int i = 1; i <= s.getLastRowNum(); i++) {
      System.out.println("\nTotal Row Count :" + s.getLastRowNum());
      System.out.println("\n" + "Test Case_ID :" + s.getRow(i).getCell(0).getStringCellValue());
      System.out.println("\n" + "Inside for loop i value----->" + i);

      // driver.findElement(ProviderFunctions.DoctorUsername).clear();
      // wait.until(ExpectedConditions.elementToBeClickable(page.DoctorUsername))
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorUsername))
          .sendKeys(s.getRow(i).getCell(1).getStringCellValue());

      // page.Doctorpassword.clear();
      driver.findElement(ProviderPage.Doctorpassword).clear();
      // wait.until(ExpectedConditions.elementToBeClickable(page.Doctorpassword))
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.Doctorpassword))
          .sendKeys(s.getRow(i).getCell(2).getStringCellValue());

      // System.out.println("\nProvider Login Status : " + page.DoctorSigin.getText());
      assertEquals(ProviderPage.DoctorSignin().getText(), "Sign-In");
      Thread.sleep(1000);

      // wait.until(ExpectedConditions.elementToBeClickable(page.DoctorSigin)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorSigin)).click();
      Thread.sleep(2000);
      System.out.println("\nProvider Login Status :Successfully Logged In");

      String strurl = "https://demo.ezscheduler.io/myschedule";
      if (strurl.contains(driver.getCurrentUrl())) {
        String s1 = "successfully logged In";
        try {
          assertEquals(
              ProviderPage.DoctorName().getText(), s.getRow(i).getCell(3).getStringCellValue());
          System.out.println(
              "\nProvider Login Verify with Provider Name: successfully logged In ----  ProviderName Matched");
          s.getRow(i).getCell(4).setCellValue("Provider Name Match");
        } catch (AssertionError e) {
          System.out.println(
              "\nProvider Login Verify with Provider Name: successfully logged In ----  ProviderName MisMatch");
          s.getRow(i).getCell(4).setCellValue("Provider Name Mismatch");
          // throw e;
        }
        s.getRow(i).getCell(5).setCellValue(s1);
        FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Provider.xlsx");
        wb.write(fout);
      } else {
        String s2 = "Invalid Username/Password";
        s.getRow(i).getCell(5).setCellValue(s2);
        FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Provider.xlsx");
        wb.write(fout);
        System.out.println("\nProvider Login Status : Invalid Username/Password");
      }
    }
    NavigateEzHomePage(driver);
  }
}
