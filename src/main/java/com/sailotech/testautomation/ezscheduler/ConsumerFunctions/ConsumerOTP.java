package com.sailotech.testautomation.ezscheduler.ConsumerFunctions;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.repositorypages.ConsumerPage;
import com.sailotech.testautomation.ezscheduler.repositorypages.ConsumerRepositoryclass;

import io.qameta.allure.Attachment;

public class ConsumerOTP {

  WebDriver driver;

  public ConsumerOTP(WebDriver d) {
    this.driver = d;
    PageFactory.initElements(d, this);
  }

  @Attachment
  public byte[] ConsumerFetchingOTP(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void Consumer_OTP(WebDriver Driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    ConsumerRepositoryclass ConsumerFunction = new ConsumerRepositoryclass(driver);
    // Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Consumer.xlsx");
    @SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    // Header Sheet
    XSSFSheet s = wb.getSheetAt(2);
    Thread.sleep(5000);
    
    //for (int i = 1; i <= s.getLastRowNum(); i++) {
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.PatientOTP))
          .sendKeys(s.getRow(1).getCell(6).getStringCellValue());
      System.out.println("\nPatientOTP: " +s.getRow(1).getCell(6).getStringCellValue());
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.VerifyOTP))
          .click();
      if (ConsumerFunction.InvalidOTP.isDisplayed()) {
        System.out.println("\nResults :" + ConsumerFunction.InvalidOTP.getText());
      
    }
    Thread.sleep(2000);
    ConsumerFetchingOTP(driver);
  }
}
