package com.sailotech.testautomation.ezscheduler.ConsumerFunctions;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.ConsumerPage;
import com.sailotech.testautomation.ezscheduler.repositorypages.ConsumerRepositoryclass;

import ru.yandex.qatools.allure.annotations.Attachment;

public class Consumerlogin extends TestBase {

  @Attachment
  public byte[] NavigateEzHomePage(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void ConsumerLogin(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    ConsumerRepositoryclass ConsumerFunction = new ConsumerRepositoryclass(driver);
    // Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Consumer.xlsx");
    @SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet s = wb.getSheetAt(0);
    Thread.sleep(5000);

    try {
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.HomeLoginRegister))
         .click();
    } catch (Exception e) {
      System.out.println(
          "Error: Time out Exception: could not find Home Login/Register Link/Button , Waiting for that element to be clickable \n"
              + e.getMessage());
    }

    try {
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.PatientLogin))
         .click();
    } catch (Exception e) {
      System.out.println(
          "Error: Time out Exception: could not find Consumer Login/Register Link/Button , Waiting for that element to be clickable \n"
              + e.getMessage());
    }
    for (int i = 1; i <= s.getLastRowNum(); i++) {
      System.out.println("Total Row Count :" + s.getLastRowNum());
      System.out.println("\n" + "Patient ID  :" + s.getRow(i).getCell(0).getStringCellValue());
      System.out.println("\n" + "Inside for loop i value----->" + i);

     //driver.findElement(ConsumerFunctions.PatientUserName).clear();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.PatientUserName))
          .sendKeys(s.getRow(i).getCell(1).getStringCellValue());

      driver.findElement(ConsumerPage.PatienPassword).clear();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.PatienPassword))
          .sendKeys(s.getRow(i).getCell(2).getStringCellValue());
      // System.out.println("\nConsumer Login Status : " + page.PatientSignIn.getText());
      // assertEquals(page.PatientSignIn.getText(), "Sign-In");
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.PatientSignIn)).click();
      Thread.sleep(2000);
      System.out.println("\nConsumer Login Status :Successfully Logged In");

      String strurl = "https://demo.ezscheduler.io/";
      if (strurl.contains(driver.getCurrentUrl())) {
        String s1 = "successfully logged In";
        try {
          assertEquals(ConsumerFunction.PatientName.getText(), s.getRow(i).getCell(3).getStringCellValue());       	
          System.out.println(
              "\nConsumer Login Verify with Consumer Name: successfully logged In ----  ConsumerName Matched");
          s.getRow(i).getCell(4).setCellValue("Consumer Name Match");
        } catch (AssertionError e) {
          System.out.println(
              "\nConsumer Login Verify with Consumer Name: successfully logged In ----  ConsumerName MisMatched");
          s.getRow(i).getCell(4).setCellValue("Consumer Name Mismatch");
          // throw new AssertionError("", e);
        }
        s.getRow(i).getCell(5).setCellValue(s1);
        FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Consumer.xlsx");
        wb.write(fout);
      } else {

        String s2 = "Invalid Username/Password";
        s.getRow(i).getCell(5).setCellValue(s2);
        FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Consumer.xlsx");
        wb.write(fout);
        System.out.println("\nConsumer Login Status : Invalid Username/Password");
      }
    }
    NavigateEzHomePage(driver);
  }
}
