package com.sailotech.testautomation.ezscheduler.ProviderFunctions;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderPage;

import io.qameta.allure.Attachment;

public class ProviderRegistrationCredentials extends TestBase {
  /* WebDriver driver;

  public ProviderRegistrationCredentials(WebDriver d) {
    this.driver = d;
    PageFactory.initElements(d, this);
  }*/

  @Attachment
  public byte[] Registration_ProviderLoginCredentials(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void ProviderRegistration_LoginCredentials(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    //ProviderRepositoryclass page = new ProviderRepositoryclass(driver);
    //Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Provider.xlsx");
    @SuppressWarnings("resource") XSSFWorkbook wb = new XSSFWorkbook(fis);
    // Header Sheet
    XSSFSheet s = wb.getSheetAt(2);
    Thread.sleep(5000);
    
    for (int i = 1; i <= s.getLastRowNum(); i++) {
    	 System.out.println("\nTotal Row Count :" + s.getLastRowNum());
     // wait.until(ExpectedConditions.elementToBeClickable(page.clickheretoSignIn)).click();
    	 //wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.clickheretoSignIn)).click();
    	 driver.findElement(ProviderPage.clickheretoSignIn).click();
      //wait.until(ExpectedConditions.elementToBeClickable(page.DoctorUsername))
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorUsername))
          .sendKeys(s.getRow(i).getCell(12).getStringCellValue());
      Thread.sleep(1000);
      System.out.println("\nDoctor ID:"+s.getRow(i).getCell(12).getStringCellValue());
      
     // wait.until(ExpectedConditions.elementToBeClickable(page.Doctorpassword))
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.Doctorpassword))
          .sendKeys(s.getRow(i).getCell(13).getStringCellValue());
      Thread.sleep(1000);
      System.out.println("\nDoctor Password:"+s.getRow(i).getCell(12).getStringCellValue());
      
      //wait.until(ExpectedConditions.elementToBeClickable(page.DoctorSigin)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorSigin)).click();
      Thread.sleep(1000);
      System.out.println("\nSign-in Successfully");
      break;
    }
    Registration_ProviderLoginCredentials(driver);
    
  }  
}
