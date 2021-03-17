package com.sailotech.testautomation.ezscheduler.ConsumerFunctions;

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

public class Consumerregistration extends TestBase {

  @Attachment
  public byte[] EzHomePage(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment
  public byte[] PatientRegister(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void ConsumerRegister(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    @SuppressWarnings("unused")
    ConsumerRepositoryclass ConsumerFunction = new ConsumerRepositoryclass(driver);
    // Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Consumer.xlsx");
    @SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    // Header Sheet
    XSSFSheet s = wb.getSheetAt(2);
    Thread.sleep(5000);

    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.HomeLoginRegister))
          .click();
    } catch (Exception e) {
      System.out.println(
          "Error: Time out Exception: could not find Home Login/Register Link/Button , Waiting for that element to be clickable \n"
              + e.getMessage());
    }
    // throw new AssertionError("Time out Exception: could not find Patient Register Link/Button ,
    // Waiting for that element to be clickable", e )
    wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.patientregister))
        .click();

    for (int i = 1; i <= s.getLastRowNum(); i++) {
      System.out.println("Total Row Count :" + s.getLastRowNum());
      System.out.println("\n" + "Inside for loop i value----->" + i);
      System.out.println("\n" + "PatientName :" + s.getRow(i).getCell(1).getStringCellValue());
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.patientName))
          .sendKeys(s.getRow(i).getCell(1).getStringCellValue());
      Thread.sleep(1000);

      System.out.println("\n" + "PatientEmail :" + s.getRow(i).getCell(2).getStringCellValue());
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.PatientEmail))
          .sendKeys(s.getRow(i).getCell(2).getStringCellValue());
      Thread.sleep(1000);

      System.out.println("\n" + "PatientMobileNo :" + s.getRow(i).getCell(3).getStringCellValue());
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(ConsumerPage.PatientMobilenumber))
          .sendKeys(s.getRow(i).getCell(3).getStringCellValue());
      Thread.sleep(1000);

      String Gender = s.getRow(i).getCell(4).getStringCellValue();
      switch (Gender) {
        case "Male":
          wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.Gendermale))
              .click();
          System.out.println("\n" + "Gender : Male");
          break;
        case "Female":
          wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.genderFemale))
              .click();
          System.out.println("\n" + "Gender : Female");
          break;
      }
      // String s1= page.Registerbutton.getText();
      String s1 = "Registered Successfully";
      s.getRow(i).getCell(7).setCellValue(s1);
      FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Consumer.xlsx");
      wb.write(fout);
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.Registerbutton))
          .click();
      Thread.sleep(1000);
     break;
    }
    PatientRegister(driver);
  }
}
