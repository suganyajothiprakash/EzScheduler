package com.sailotech.testautomation.ezscheduler.AdminFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.AdminPage;
import com.sailotech.testautomation.ezscheduler.repositorypages.AdminRepositoryclass;

import ru.yandex.qatools.allure.annotations.Attachment;

public class AdminVerifiedDoctors extends TestBase {

  WebDriverWait wait = new WebDriverWait(driver, 30);
  int rowvalue = 0;
  int tr;
  int div;

  @Attachment
  public byte[] NavigateAdminLogin(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void AdminCheckverifiedDoctor(WebDriver driver) throws Exception {
    // WebDriverWait wait = new WebDriverWait(driver, 5);
    AdminRepositoryclass Adminfunction = new AdminRepositoryclass(driver);
    Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Admin.xlsx");
    @SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet s = wb.getSheetAt(3);
    Thread.sleep(1000);
    for (int i = 1; i <= s.getLastRowNum(); i++) {
      System.out.println("\nTotal Row Count :" + s.getLastRowNum());
      System.out.println("\nTestcase_ID :" + s.getRow(i).getCell(0).getStringCellValue());
      System.out.println("\nInside for loop i value----->" + i);
      long start = System.currentTimeMillis();
      System.out.println("\nstart time:" + start);
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.AdminMenu)).click();
      zoomOutByZoomLevel("100");
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DoctorQueue)).click();
      zoomOutByZoomLevel("100");
      try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.verifieddoctors))
            .click();
      } catch (Exception e) {
        System.out.println(
            "Error: Time out Exception: could not find Home Login/Register Link/Button , Waiting for that element to be clickable \n"
                + e.getMessage());
      }

      boolean doctorCheckFlag = false;
      // Getting all the rows from verified doctors table
       List<WebElement> rowDetails =
       Adminfunction.verifieddoctortable.findElements(By.tagName("tr"));
      /*List<WebElement> rowDetails =
      AdminPage.verifieddoctortable1.findElements(By.tagName("tr"));*/
      int rowcount = rowDetails.size();
      System.out.println("\nRow count is:" + rowcount);
      for (int row = 0; row < rowcount; row++) {
        //System.out.println("\nCurrent row count is :" + row);
        // Getting all the Columns from verified doctors table
        Thread.sleep(2000);
        List<WebElement> colDetails = rowDetails.get(row).findElements(By.tagName("td"));
        int colcount = colDetails.size();
        System.out.println("\nColumn count  is:" + colcount);
        System.out.println(
            "\nCurrent Row Count is: " + row + " and Current Column Count is: " + colcount);
        for (int col = 0; col < colcount; col++) {
          String searchData = s.getRow(i).getCell(1).getStringCellValue();
          System.out.println("\nsearchData is :" + s.getRow(i).getCell(1).getStringCellValue());
          rowvalue = row;
          Thread.sleep(1000);
          //String DoctorData = Adminfunction.VerifiedDoctorData(row + 1, col + 1).getText();
           String DoctorData = AdminPage.VerifiedDoctorData1(row + 1 , col + 1).getText();
          // String DoctorData = driver.findElement(AdminFunctions.VerifiedDoctorData(row + 1, col +
          // 1)).getText();
          System.out.println("\nDoctordata is :" + DoctorData);
          if (searchData.equals(DoctorData) == true) {
            System.out.println("\nSearchData equals DoctorData :" + searchData);
            Thread.sleep(1000);
            // Adminfunction.verifieddoctoreditoption(rowvalue + 1).click();
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        AdminPage.verifieddoctoreditoption(rowvalue + 1)))
                .click();
            doctorCheckFlag = true;
            break;
          }
        }
        Thread.sleep(3000);
        if (!doctorCheckFlag) {
          if (row == rowcount - 1) {
            System.out.println("Next Set of records");
            Thread.sleep(1000);
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        AdminPage.VerifiedDoctorNextArrowButton))
                .click();
            Thread.sleep(4000);
            rowDetails = Adminfunction.verifieddoctortable.findElements(By.tagName("tr"));
            rowcount = Adminfunction.verifieddoctortable.findElements(By.tagName("tr")).size();
            row = -1;
          }
        } else break;
      }
      if (!doctorCheckFlag) {
        System.out.println("No Search Records found");
      }

      /* doctorCheckFlag = false;
      {
        System.out.println("No Records Available");
      }*/

      Thread.sleep(1000);
      String VerifiedData = s.getRow(i).getCell(2).getStringCellValue();

      switch (VerifiedData) {
        case "ProviderPhoneNumber":
          System.out.println("Verifying Provider PhoneNumber");
          Thread.sleep(1000);
          try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        AdminPage.VerifiedDoctorphoneNumber))
                .click();
          } catch (Exception e) {
            System.out.println(
                "Error:Time out Exception: could not find verified Provider Phone Number"
                    + "\n"
                    + e.getMessage());
          }
          Thread.sleep(2000);
          //driver.findElement(AdminPage.VerifiedDoctorphoneNumber).sendKeys(Keys.DELETE);
           wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                  AdminPage.VerifiedDoctorphoneNumber))
          .clear();
          Thread.sleep(4000);
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                      AdminPage.VerifiedDoctorphoneNumber))
              .sendKeys(s.getRow(i).getCell(3).getStringCellValue());
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.saveprofile)).click();
          Thread.sleep(2000);

          // if (Adminfunction.PhoneNumberAlertORPhysicianSavedMessage().isDisplayed()) {
          if (AdminPage.PhoneNumberAlertORPhysicianSavedMessage().isDisplayed()) {
            String SucccesMessage = AdminPage.PhoneNumberAlertORPhysicianSavedMessage().getText();
            // String SucccesMessage =
            // driver.findElement(AdminFunctions.AlertORPhysicianSavedMessage()).getText();
            System.out.println("Results :" + SucccesMessage);
            String s1 = AdminPage.PhoneNumberAlertORPhysicianSavedMessage().getText();
            // String s1 =
            // driver.findElement(AdminFunctions.AlertORPhysicianSavedMessage()).getText();
            s.getRow(i).getCell(4).setCellValue(s1);
            FileOutputStream fout1 = new FileOutputStream(user_dir + "/inputFiles/Admin.xlsx");
            wb.write(fout1);
            Thread.sleep(2000);
          }
          break;

        case "ProviderEmailId":
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.VerifiedDoctorEmailID))
              .click();
          Thread.sleep(2000);
          // driver.findElement(AdminFunctions.VerifiedDoctorEmailID).clear();
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.VerifiedDoctorEmailID))
              .clear();
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.VerifiedDoctorEmailID))
              .sendKeys(s.getRow(i).getCell(3).getStringCellValue());
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.saveprofile)).click();
          Thread.sleep(2000);

          // if (Adminfunction.EmailAlertORPhysicianSavedMessage().isDisplayed()) {
          if (AdminPage.EmailAlertORPhysicianSavedMessage().isDisplayed()) {
            String successmessage = AdminPage.EmailAlertORPhysicianSavedMessage().getText();
            // String successmessage =
            // driver.findElement(AdminFunctions.AlertORPhysicianSavedMessage()).getText();
            System.out.println("\nResults :" + successmessage);
            String s2 = AdminPage.EmailAlertORPhysicianSavedMessage().getText();
            // String s2 =
            // driver.findElement(AdminFunctions.AlertORPhysicianSavedMessage()).getText();
            s.getRow(i).getCell(4).setCellValue(s2);
            FileOutputStream fout2 = new FileOutputStream(user_dir + "/inputFiles/Admin.xlsx");
            wb.write(fout2);
          }
          long end = System.currentTimeMillis();
          System.out.println("End Time:" + end);
          break;
      }
    }
    Thread.sleep(3000);
    NavigateAdminLogin(driver);
  }

  public static String removeZero(String str) {
    int i = 0;
    while (i < str.length() && str.charAt(i) == '0') i++;
    StringBuffer sb = new StringBuffer(str);
    sb.replace(0, i, "");
    return sb.toString();
  }
}
