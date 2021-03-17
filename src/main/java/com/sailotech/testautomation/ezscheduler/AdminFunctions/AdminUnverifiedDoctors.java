package com.sailotech.testautomation.ezscheduler.AdminFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
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

public class AdminUnverifiedDoctors extends TestBase {

  WebDriverWait wait = new WebDriverWait(driver, 30);
  int rowvalue = 0;
  int m = 0;
  int tr;
  int div;

  @Attachment
  public byte[] NavigateAdminLogin(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void AdminverifyDoctor(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    AdminRepositoryclass Adminfunction = new AdminRepositoryclass(driver);
    Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Admin.xlsx");
    @SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet s = wb.getSheetAt(2);
    Thread.sleep(1000);

    for (int i = 1; i <= s.getLastRowNum(); i++) {
      System.out.println("\nTotal Row Count :" + s.getLastRowNum());
      System.out.println("\nTestcase_ID :" + s.getRow(i).getCell(0).getStringCellValue());
      System.out.println("\nInside for loop i value----->" + i);
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.unverifiedDoctors))
          .click();
      System.out.println("\nVerifying Unverified Doctors");

      boolean doctorCheckFlag = false;
      List<WebElement> rowDetails = Adminfunction.UnverifiedTable.findElements(By.tagName("tr"));
      // List<WebElement> rowDetails = ((WebElement)
      // AdminPage.UnverifiedTable()).findElements(By.tagName("tr"));
      int rowcnt = rowDetails.size();
      System.out.println("\nRow count size is:" + rowcnt);
      for (int row = 0; row < rowcnt; row++) {
        //System.out.println("\nCurrent row is :" + row);
        Thread.sleep(2000);
        List<WebElement> colDetails = rowDetails.get(row).findElements(By.tagName("td"));
        int colcnt = colDetails.size();
        System.out.println("\nColumn count size is:" + colcnt);
        for (int col = 0; col < colcnt; col++) {
          String searchData = s.getRow(i).getCell(1).getStringCellValue();
          System.out.println("\nsearchData is :" + s.getRow(i).getCell(1).getStringCellValue());
          rowvalue = row;
          Thread.sleep(2000);
          String DoctorData = AdminPage.UnverifiedDoctorData1(row + 1, col + 1).getText();
          // String DoctorData = driver.findElement(AdminFunctions.UnverifiedDoctorData(row + 1, col
          // + 1)).getText();
          System.out.println("\nDoctordata is :" + DoctorData);
          if (searchData.equals(DoctorData) == true) {
            System.out.println("\nSearchData equals DoctorData :" + searchData);
            // Adminfunction.unverifieddoctorEditOption(rowvalue + 1).click();
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        AdminPage.unverifieddoctorEditOption(rowvalue + 1)))
                .click();
            doctorCheckFlag = true;
            break;
          }
        }
        Thread.sleep(3000);
        if (!doctorCheckFlag) {
          if (row == rowcnt - 1) {
            System.out.println("Next Set of records");
            Thread.sleep(3000);
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        AdminPage.UnVerifiedDoctorNextArrowButton))
                .click();
            Thread.sleep(4000);
            rowDetails = Adminfunction.UnverifiedTable.findElements(By.tagName("tr"));
            // rowDetails =  ((WebElement)
            // AdminPage.UnverifiedTable()).findElements(By.tagName("tr"));
            rowcnt = Adminfunction.UnverifiedTable.findElements(By.tagName("tr")).size();
            row = -1;
          }
        } else break;
      }
      if (!doctorCheckFlag) {
        System.out.println("No Search Records found");
      }

      doctorCheckFlag = false;
      {
        System.out.println("No Search Records found");
      }

      String videoconsultation = s.getRow(i).getCell(2).getStringCellValue();
      System.out.println("\nvideoconsultation:" + s.getRow(i).getCell(2).getStringCellValue());
      switch (videoconsultation) {
        case "Yes":
          // action.moveToElement(page.Videoconsultationyes).click().perform();
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.Videoconsultationyes))
              .click();
          System.out.println("\n" + "Results for videoconsultation : Yes");
          break;
        case "No":
          // action.moveToElement(page.VideoconsultationNo).click().perform();
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.VideoconsultationNo))
              .click();

          Thread.sleep(1000);
          System.out.println("\n" + "Results for videoconsultation: No");
          break;
      }

      String VerifyDoctor = s.getRow(i).getCell(3).getStringCellValue();
      System.out.println("\nVerifyDoctor:" + s.getRow(i).getCell(3).getStringCellValue());
      switch (VerifyDoctor) {
        case "Yes":
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.verifydoctorYes))
              .click();

          // action.moveToElement(page.verifydoctorYes).click().perform();
          Thread.sleep(1000);
          System.out.println("\n" + "Results for Verify Doctor : Yes");
          break;
        case "No":
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.verifydoctorNo))
              .click();

          // action.moveToElement(page.verifydoctorNo).click().perform();
          System.out.println("\n" + "Results for Verify Doctor : No");
          break;
      }
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.TrialStartDate)).click();

      Thread.sleep(2000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.Years)).click();
      int yearDiv = 120;
      for (int k = 120; k <= yearDiv + 10; k++) {
        div = k;
        String startyear = s.getRow(i).getCell(4).getStringCellValue();
        // String calanderyear = Adminfunction.TrialYear(div).getText();
        String calanderyear = driver.findElement(AdminPage.TrialYear(div)).getText();
        System.out.println("\nCalenderYear is : " + calanderyear);
        System.out.println("\nStartyear is : " + startyear);
        if (startyear.equals(calanderyear) == true) {
          System.out.println(startyear + " equals " + calanderyear);
          // Adminfunction.TrialYear(div).click();
          driver.findElement(AdminPage.TrialYear(div)).click();

          break;
        }
      }

      String StartTrialmonthYear =
          s.getRow(i).getCell(5).getStringCellValue()
              + " "
              + s.getRow(i).getCell(4).getStringCellValue();
      boolean previous = false;
      @SuppressWarnings("unused")
      boolean next = true;
      System.out.println(StartTrialmonthYear);
      for (int m = 1; m <= 12; m++) {
        // String monthYearCheck = Adminfunction.monthCheckText(StartTrialmonthYear).getText();
        String monthYearCheck =
            driver.findElement(AdminPage.monthCheckText(StartTrialmonthYear)).getText();
        // System.out.println("Year :" +monthYearCheck);
        if (Adminfunction.monthCheck(StartTrialmonthYear)) break;
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
          wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.PreviousArrowbtn))
              .click();
        // action.moveToElement(page.PreviousArrowbtn).click().perform();
        else // action.moveToElement(page.NextArrowBtn).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.NextArrowBtn)).click();
      }
      boolean startFlag = false;
      for (int a = 1; a <= 5; a++) {
        for (int b = 1; b <= 7; b++) {
          div = b;
          System.out.println("Count is: " + b);
          String startDate = removeZero(s.getRow(i).getCell(6).getStringCellValue());
          System.out.println("\nstartDate is: " + startDate);
           //String calanderDate = Adminfunction.TrialDate(a, b).getText();
          String calanderDate = AdminPage.TrialDate(a, b).getText();
          System.out.println("\nCalendar Date is: " + calanderDate);
          System.out.println(startDate + " equals " + calanderDate);
          if (startDate.equals(calanderDate) == true) {
            System.out.println("\nStartDate equals CalenderDate:" + calanderDate);
            // Adminfunction.TrialDate(a, b).click();
            AdminPage.TrialDate(a, b).click();
            startFlag = true;
            break;
          }
        }
        if (startFlag) break;
      }

      Thread.sleep(3000);
      try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.TrialEndDate)).click();
      } catch (Exception e) {
        System.out.println(
            "Error: Time out Exception: could not find Home TRial End Date , Waiting for that element to be clickable \n"
                + e.getMessage());
      }
      // wait.until(ExpectedConditions.visibilityOfElementLocated(AdminFunctions.TrialEndDate))
      // .click();
      Thread.sleep(1000);
      // wait.until(ExpectedConditions.visibilityOfElementLocated(AdminFunctions.TrialYears)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.Years)).click();
      int yearDiv1 = 120;
      for (int k = 120; k <= yearDiv1 + 20; k++) {
        div = k;
        String Endyear = s.getRow(i).getCell(7).getStringCellValue();
        // String calanderyear = Adminfunction.TrialYear(div).getText();
        String calanderyear = driver.findElement(AdminPage.TrialYear(div)).getText();
       // System.out.println("\nEndyear is  :" + Endyear);
        if (Endyear.equals(calanderyear) == true) {
          System.out.println(Endyear + " equals " + calanderyear);
          // Adminfunction.TrialYear(div).click();
          driver.findElement(AdminPage.TrialYear(div)).click();
          break;
        }
      }
      String EndTrialmonthYear =
          s.getRow(i).getCell(8).getStringCellValue()
              + " "
              + s.getRow(i).getCell(7).getStringCellValue();
      boolean previousEnd = false;
      @SuppressWarnings("unused")
      boolean nextEnd = true;
      System.out.println(EndTrialmonthYear);
      for (int m = 1; m <= 12; m++) {
        // String monthYearCheckEnd = Adminfunction.monthCheckTextEnd(EndTrialmonthYear).getText();
        String monthYearCheckEnd =
            driver.findElement(AdminPage.monthCheckTextEnd(EndTrialmonthYear)).getText();
        Thread.sleep(2000);
        if (Adminfunction.monthCheck(EndTrialmonthYear)) break;
        else {
          String month[] = monthYearCheckEnd.split(" ");
          if (month[0].equals("January")) {
            nextEnd = true;
            previousEnd = false;
          } else if (month[0].equals("December")) {
            previousEnd = true;
            nextEnd = false;
          }
        }
        if (previousEnd) // action.moveToElement(page.PreviousArrowbtn).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.PreviousArrowbtn))
              .click();
        else // action.moveToElement(page.NextArrowBtn).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.NextArrowBtn)).click();
      }
      boolean startFlag1 = false;
      for (int l = 1; l <= 5; l++) {
        for (int j = 1; j <= 7; j++) {
          div = j;
          System.out.println("Count is " + j);
          String EndDate = removeZero(s.getRow(i).getCell(9).getStringCellValue());
          System.out.println("\nEndDate is  :" + EndDate);
          // String calanderDate = Adminfunction.TrialDate1(l, j).getText();
          String calanderDate = AdminPage.TrialDate1(l, j).getText();
          System.out.println("\nCalendar Date is: " + calanderDate);
          System.out.println(EndDate + " equals " + calanderDate);
          if (EndDate.equals(calanderDate) == true) {
            System.out.println("\nEndDate equals calanderDate: " + calanderDate);
            // Adminfunction.TrialDate1(l, j).click();
            AdminPage.TrialDate1(l, j).click();
            startFlag1 = true;
            break;
          }
        }
        if (startFlag1) break;
      }

      Thread.sleep(3000);
      // action.moveToElement(page.saveprofile).click().build().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.saveprofile)).click();
      if (AdminPage.AlertMessage().isDisplayed()) {
        String AlertMessage = AdminPage.AlertMessage().getText();
        System.out.println("\n" + "Results Are: " + AlertMessage);
        Thread.sleep(1000);

        String s1 = "Physician saved";
        s.getRow(i).getCell(11).setCellValue(s1);
        FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Admin.xlsx");
        wb.write(fout);
        System.out.println("\n" + "Results Are: " + AlertMessage);
      }

      // action.moveToElement(page.AdminMenu).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.AdminMenu)).click();
      Thread.sleep(1000);
      // action.moveToElement(page.DoctorQueue).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.DoctorQueue)).click();
      Thread.sleep(1000);
      // action.moveToElement(page.verifieddoctors).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.verifieddoctors)).click();
      Thread.sleep(9000);

      boolean doctorCheckFlag1 = false;
      // Getting all the rows from verified doctors table
      List<WebElement> rowDetails1 =
          Adminfunction.verifieddoctortable.findElements(By.tagName("tr"));

      int rowcount = rowDetails1.size();
      System.out.println("\nRow count size is:" + rowcount);

      for (int row = 0; row < rowcount; row++) {
        // System.out.println("\nCurrent row count is :" + row);
        Thread.sleep(1500);
        // Getting all the Columns from verified doctors table
        List<WebElement> colDetails = rowDetails1.get(row).findElements(By.tagName("td"));
        int colcount = colDetails.size();
        // System.out.println("\nColumn count size is:" + colcount);
        System.out.println(
            "\nCurrent Row Count is: " + row + " and Current Column Count is: " + colcount);
        for (int col = 0; col < colcount; col++) {
          String VerifyDoctorEmail = s.getRow(i).getCell(10).getStringCellValue();
          System.out.println("\nsearchData is :" + s.getRow(i).getCell(10).getStringCellValue());
          rowvalue = row;
          Thread.sleep(1000);
          String DoctorEmail = AdminPage.VerifiedDoctorData1(row + 1, col + 1).getText();
          // String DoctorEmail = driver.findElement(AdminFunctions.VerifiedDoctorData(row + 1, col
          // + 1)).getText();
          System.out.println("\nDoctordata is :" + DoctorEmail);
          if (VerifyDoctorEmail.equals(DoctorEmail) == true) {
            System.out.println("\n" + VerifyDoctorEmail + " equals " + DoctorEmail);
            System.out.println("\nVerified Doctor email :yes " + VerifyDoctorEmail);
            Thread.sleep(1000);
            // Adminfunction.verifieddoctoreditoption(rowvalue + 1).click();
            doctorCheckFlag1 = true;
            break;
          }
        }

        if (!doctorCheckFlag1) {
          if (row == rowcount - 1) {
            System.out.println("Next Set of records");
            Thread.sleep(1000);
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        AdminPage.VerifiedDoctorNextArrowButton))
                .click();
            Thread.sleep(4000);
            rowDetails1 = Adminfunction.verifieddoctortable.findElements(By.tagName("tr"));
            rowcount = Adminfunction.verifieddoctortable.findElements(By.tagName("tr")).size();
            row = -1;
            break;
          }
        }
      }
    }
    Thread.sleep(2000);
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
