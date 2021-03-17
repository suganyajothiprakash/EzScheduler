package com.sailotech.testautomation.ezscheduler.AdminFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.AdminPage;
import com.sailotech.testautomation.ezscheduler.repositorypages.AdminRepositoryclass;

import ru.yandex.qatools.allure.annotations.Attachment;

public class AdminCreateProvider extends TestBase {
  int div;

  @Attachment
  public byte[] NavigatecreateDoctor(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void AdminCreateDoctor(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    AdminRepositoryclass Adminfunction = new AdminRepositoryclass(driver);
    Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Admin.xlsx");
    @SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet s = wb.getSheetAt(1);
    Thread.sleep(1000);

    for (int i = 1; i <= s.getLastRowNum(); i++) {
      System.out.println("\nTotal Row Count :" + s.getLastRowNum());
      System.out.println("\nTestcase_ID :" + s.getRow(i).getCell(0).getStringCellValue());
      System.out.println("\nInside for loop i value----->" + i);
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.AdminMenu)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DoctorQueue)).click();
      Thread.sleep(1000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.CreateDoctor))
          .click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DoctorName))
          .sendKeys(s.getRow(i).getCell(1).getStringCellValue());
      System.out.println("\nDoctor Name:" + s.getRow(i).getCell(1).getStringCellValue());
      Thread.sleep(1000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DoctorPhoneNumber))
          .sendKeys(s.getRow(i).getCell(2).getStringCellValue());
      Thread.sleep(1000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DoctorEmailAddress))
          .sendKeys(s.getRow(i).getCell(3).getStringCellValue());
      System.out.println("\nDoctor Email:" + s.getRow(i).getCell(3).getStringCellValue());
      Thread.sleep(1000);
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DocDegree)).click();
      Thread.sleep(1000);
      action.sendKeys(s.getRow(i).getCell(4).getStringCellValue());
      action.sendKeys(Keys.ARROW_DOWN).perform();
      action.sendKeys(Keys.ENTER).perform();
      Thread.sleep(1000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DocSpecializations))
          .click();
      action.sendKeys(s.getRow(i).getCell(5).getStringCellValue());
      action.sendKeys(Keys.ARROW_DOWN).perform();
      action.sendKeys(Keys.ENTER).perform();
      Thread.sleep(1000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DocConditionsTreated))
          .click();
      action.sendKeys(s.getRow(i).getCell(6).getStringCellValue());
      action.sendKeys(Keys.ARROW_DOWN).perform();
      action.sendKeys(Keys.ENTER).perform();
      Thread.sleep(1000);

      wait.until(
              ExpectedConditions.visibilityOfElementLocated(AdminPage.DocProcedurePerformed))
          .sendKeys(s.getRow(i).getCell(7).getStringCellValue());
      Thread.sleep(1000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DocLanguages))
          .click();
      action.sendKeys(s.getRow(i).getCell(8).getStringCellValue());
      action.sendKeys(Keys.ARROW_DOWN).perform();
      action.sendKeys(Keys.ENTER).perform();
      Thread.sleep(1000);

      wait.until(
              ExpectedConditions.visibilityOfElementLocated(AdminPage.DocBoardCertifications))
          .sendKeys(s.getRow(i).getCell(9).getStringCellValue());
      Thread.sleep(1000);
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                  AdminPage.DocawardsandRecognitions))
          .sendKeys(s.getRow(i).getCell(10).getStringCellValue());
      Thread.sleep(1000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.PracticestartDate))
          .click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.Years)).click();
      Thread.sleep(1000);

      int ExpDiv = 200;
      for (int k = 70; k <= ExpDiv; k++) {
        div = k;
        String Calanderyear = s.getRow(i).getCell(13).getStringCellValue();
        // System.out.println("Calanderyear:" + s.getRow(i).getCell(13).getStringCellValue());
        String practiceStartyear = Adminfunction.PracticeStartYearYear(div).getText();
        // System.out.println("year is  :" + practiceStartyear);
        if (practiceStartyear.equals(Calanderyear) == true) {
          System.out.println(practiceStartyear + " equals " + Calanderyear);
          Adminfunction.PracticeStartYearYear(div).click();
          break;
        }
      }
      String ExperiencemonthYear =
          s.getRow(i).getCell(14).getStringCellValue()
              + " "
              + s.getRow(i).getCell(13).getStringCellValue();
      boolean previous = false;
      @SuppressWarnings("unused")
      boolean next = true;
      System.out.println(ExperiencemonthYear);
      for (int m = 1; m <= 12; m++) {
        String monthYearCheck = Adminfunction.Practicemonthcheck(ExperiencemonthYear).getText();
        if (Adminfunction.PracticemonthCheck(ExperiencemonthYear)) break;
        else {
          String month[] = monthYearCheck.split(" ");
          if (month[0].equals("January")) {
            next = true;
            previous = false;
          } else if (month[0].equals("December")) {
            previous = true;
            next = false;
          }
        }
        if (previous)
         // action.moveToElement(Adminfunction.practicepreviousArrowButton).click().perform();
        	  wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.practicepreviousArrowButton))
              .click();
        else //action.moveToElement(Adminfunction.practiceNextArrowButton).click().perform();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.practiceNextArrowButton))
            .click();
      }
      boolean startFlag = false;
      for (int a = 1; a <= 5; a++) {
        for (int b = 1; b <= 7; b++) {
          div = b;
          System.out.println("Count is: " + b);
          String ExpDate = removeZero(s.getRow(i).getCell(15).getStringCellValue());
          // System.out.println("\nExpDate is: " + ExpDate);
          String calanderDate = Adminfunction.ExpDate(a, b).getText();
          // System.out.println("\nCalendar Date is: " + calanderDate);
          System.out.println(ExpDate + " equals " + calanderDate);
          if (ExpDate.equals(calanderDate) == true) {
            System.out.println("\nStartDate equals CalenderDate:" + calanderDate);
            Adminfunction.ExpDate(a, b).click();
            startFlag = true;
            break;
          }
        }
        if (startFlag) break;
      }

      Thread.sleep(5000);
      String VideoConsultation = s.getRow(i).getCell(11).getStringCellValue();
      switch (VideoConsultation) {
        case "Yes":
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                      AdminPage.PracticeVideoconsultationYes))
              .click();
          System.out.println("\nVideoConsultation: Yes");
          break;

        case "No":
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(AdminPage.VideoconsultationNo))
              .click();
          System.out.println("\nVideoConsultation: No");
          break;

        case "Default":
          System.out.println("\n" + "VideoConsultation not Found");
          break;
      }

      String Gender = s.getRow(i).getCell(12).getStringCellValue();
      switch (Gender) {
        case "Male":
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DocGenderMale))
              .click();
          // System.out.println("Gender: Male" );
          break;

        case "Female":
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DocGenderFeMale))
              .click();
          // System.out.println("Gender: female");
          break;

        case "Default":
          System.out.println("\n" + "Gender not Found");
          break;
      }
      Thread.sleep(3000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DocSaveProfile))
          .click();

      if (Adminfunction.Successfullmessage.isDisplayed()) {
        String SucccesMessage = Adminfunction.Successfullmessage.getText();
        Thread.sleep(2000);
        System.out.println("\nResults :" + SucccesMessage);
        String s1 = Adminfunction.AlertORPhysicianSavedMessage().getText();
        s.getRow(i).getCell(18).setCellValue(s1);
        FileOutputStream fout1 = new FileOutputStream(user_dir + "/inputFiles/Admin.xlsx");
        wb.write(fout1);
        Thread.sleep(3000);
      }

      /*wait.until(ExpectedConditions.visibilityOfElementLocated(AdminFunctions.AddProviderLocation))
          .click();

      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminFunctions.FacilityName))
          .sendKeys(s.getRow(i).getCell(16).getStringCellValue());
      System.out.println("Facility Name:" + s.getRow(i).getCell(16).getStringCellValue());
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminFunctions.AddALocation))
          .sendKeys(s.getRow(i).getCell(17).getStringCellValue());
      System.out.println("Location :" + s.getRow(i).getCell(17).getStringCellValue());
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminFunctions.SaveButton)).click();*/
     
    }
   
    Thread.sleep(5000);
    NavigatecreateDoctor(driver);
  }

  public static String removeZero(String str) {
    // Count leading zeros
    int i = 0;
    while (i < str.length() && str.charAt(i) == '0') i++;

    // Convert str into StringBuffer as Strings
    // are immutable.
    StringBuffer sb = new StringBuffer(str);

    // The StringBuffer replace function removes
    // i characters from given index (0 here)
    sb.replace(0, i, "");

    return sb.toString(); // return in String
  }
}
