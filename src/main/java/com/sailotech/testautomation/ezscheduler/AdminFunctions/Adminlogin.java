package com.sailotech.testautomation.ezscheduler.AdminFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.AdminPage;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Adminlogin extends TestBase {

  @Attachment
  public byte[] NavigateAdminLogin(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
	
  
  public void AdminLogin(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 88)", "");
    // AdminRepositoryclass page = new AdminRepositoryclass(driver);
    // Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Admin.xlsx");
    @SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    // Header Sheet
    XSSFSheet s = wb.getSheetAt(0);
    Thread.sleep(1000);
    try {
      /*isElementPresent(locators.getElement(AdminPage.Homeloginregister), "loginbutton");
      .clickElemetUsingJavascriptExecutor(AdminPage.Homeloginregister);*/
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.HomeLoginregister)).click();
    } catch (Exception e) {
        System.out.println(
            "Error: Time out Exception: could not find Home Login/Register Link/Button , Waiting for that element to be clickable \n"
                + e.getMessage());
      }
    //wait.until(ExpectedConditions.visibilityOfElementLocated(AdminFunctions.Adminlogin)).click();
    try {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.Adminlogin)).click();
      } catch (Exception e) {
        System.out.println(
            "Error: Time out Exception: could not find Admin Login Button , Waiting for that element to be clickable \n"
                + e.getMessage());
      }
    for (int i = 1; i <= s.getLastRowNum(); i++) {
      System.out.println("\nTotal Row Count:" + s.getLastRowNum());
      System.out.println("\n" + "Testcase_ID :" + s.getRow(i).getCell(0).getStringCellValue());
      System.out.println("\n" + "Inside for loop i value----->" + i);
      driver.findElement(AdminPage.Adminusername).clear();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.Adminusername))
          .sendKeys(s.getRow(i).getCell(1).getStringCellValue());
      driver.findElement(AdminPage.Adminpassword).clear();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.Adminpassword))
          .sendKeys(s.getRow(i).getCell(2).getStringCellValue());
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.AdminSignin)).click();
      Thread.sleep(1000);
      System.out.println("\nAdmin Login Status : Sign-In");
      // checks Url
      String strurl = "https://demo.ezscheduler.io/doctorQueue";
      if (strurl.contains(driver.getCurrentUrl())) {
        System.out.println("successfully logged In");
        // Writing AdminLogin Results in Excel
        String s1 = "successfully logged In";
        s.getRow(i).getCell(3).setCellValue(s1);
        FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Admin.xlsx");
        wb.write(fout);
        Thread.sleep(1000);
      } /*else {
        System.out.println("Invalid Credentials");
        String s2 = "Invalid Credentials";
        s.getRow(i).getCell(3).setCellValue(s2);
        FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Admin.xlsx");
        Thread.sleep(1000);*/
      // System.out.println("\n" + "Admin Login Status : " + page.Invalidcredentials.getText());
      // assertEquals(page.Invalidcredentials.getText(), "Invalid Credentials");
      // }
    }
    NavigateAdminLogin(driver);
  }
}
