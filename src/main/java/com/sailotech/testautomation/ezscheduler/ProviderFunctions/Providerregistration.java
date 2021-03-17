package com.sailotech.testautomation.ezscheduler.ProviderFunctions;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.*;

import ru.yandex.qatools.allure.annotations.Attachment;

public class Providerregistration extends TestBase {
  int div;
  private static final Object Element = null;

  @Attachment
  public byte[] DoctorRegister(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void Provider_Register(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    ProviderRepositoryclass page = new ProviderRepositoryclass(driver);
    Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Provider.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    // Header Sheet
    XSSFSheet s = wb.getSheetAt(2);
    Thread.sleep(5000);
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.HomeLoginRegister))
          .click();
    } catch (Exception e) {
      System.out.println(
          "Error: Time out Exception: could not find Home Register Link/Button , Waiting for that element to be clickable \n"
              + e.getMessage());
    }
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.Doctorregister))
          .click();
    } catch (Exception e) {
      System.out.println(
          "Error: Time out Exception: could not find Doctor Register Link/Button , Waiting for that element to be clickable \n"
              + e.getMessage());
    }

    for (int i = 1; i <= s.getLastRowNum(); i++) {
      System.out.println("\nTotal Row Count :" + s.getLastRowNum());
      System.out.println("\n" + "DoctorName :" + s.getRow(i).getCell(0).getStringCellValue());
      System.out.println("\n" + "Inside for loop i value----->" + i);

      // wait.until(ExpectedConditions.elementToBeClickable(page.Doctorname))
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(ProviderPage.DocRegistrationDoctorname))
          .sendKeys(s.getRow(i).getCell(1).getStringCellValue());
      Thread.sleep(1000);
      System.out.println("\nDoctor Name:" + s.getRow(i).getCell(1).getStringCellValue());

      // wait.until(ExpectedConditions.elementToBeClickable(page.DoctorEmail))
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                  ProviderPage.DocRegistrationDoctorEmail))
          .sendKeys(s.getRow(i).getCell(2).getStringCellValue());
      Thread.sleep(1000);
      System.out.println("\nDoctor Email:" + s.getRow(i).getCell(2).getStringCellValue());

      // wait.until(ExpectedConditions.elementToBeClickable(page.Doctormobilenumber))
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                  ProviderPage.DocRegistrationDoctormobilenumber))
          .sendKeys(s.getRow(i).getCell(3).getStringCellValue());
      Thread.sleep(1000);
      System.out.println("\nDoctor MobileNumber:" + s.getRow(i).getCell(3).getStringCellValue());

      String Gender = s.getRow(i).getCell(4).getStringCellValue();

      switch (Gender) {
        case "Female":
          // wait.until(ExpectedConditions.elementToBeClickable(page.Genderfemale)).click();
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                      ProviderPage.RegistrationGenderfemale))
              .click();
          System.out.println("\nDoctor Gender:" + s.getRow(i).getCell(4).getStringCellValue());
          break;

        case "Male":
          // wait.until(ExpectedConditions.elementToBeClickable(page.Gendermale)).click();
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                      ProviderPage.RegistrationGendermale))
              .click();
          System.out.println("\nDoctor Gender:" + s.getRow(i).getCell(4).getStringCellValue());
          break;

        default:
          System.out.println("No gender match found");
      }

      action.sendKeys(Keys.TAB).build().perform();
      // wait.until(ExpectedConditions.elementToBeClickable(page.SpecializedIn))
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                  ProviderPage.DocRegistrationSpecializedIn))
          .sendKeys(s.getRow(i).getCell(5).getStringCellValue());
      action.sendKeys(Keys.ARROW_DOWN).perform();
      action.sendKeys(Keys.ENTER).perform();
      Thread.sleep(2000);

      // wait.until(ExpectedConditions.elementToBeClickable(page.Doctordegree))
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DocRegistrationdegree))
          .sendKeys(s.getRow(i).getCell(6).getStringCellValue());
      action.sendKeys(Keys.ARROW_DOWN).perform();
      action.sendKeys(Keys.ENTER).perform();
      Thread.sleep(2000);

      // wait.until(ExpectedConditions.elementToBeClickable(page.Doctorpracticestartdate)).click();
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                  ProviderPage.RegistrationDoctorpracticestartdate))
          .click();
      Thread.sleep(1000);

      // wait.until(ExpectedConditions.elementToBeClickable(page.yearselection)).click();
      wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                  ProviderPage.DocRegistrationyearselection))
          .click();
      Thread.sleep(1000);

      int ExpDiv = 200;
      for (int k = 70; k <= ExpDiv; k++) {
        div = k;
        String Calanderyear = s.getRow(i).getCell(7).getStringCellValue();
        String ExperienceYear = page.ExperienceYear(div).getText();
        // System.out.println("year is  :" + ExperienceYear);
        if (ExperienceYear.equals(Calanderyear) == true) {
          System.out.println("\n" + ExperienceYear + " equals " + Calanderyear);
          page.ExperienceYear(div).click();
          break;
        }
      }
      String ExperiencemonthYear =
          s.getRow(i).getCell(8).getStringCellValue()
              + " "
              + s.getRow(i).getCell(7).getStringCellValue();

      boolean previous = false;
      boolean next = true;
      System.out.println("\n" + ExperiencemonthYear);
      for (int m = 1; m <= 12; m++) {
        String monthYearCheck = page.monthCheckText(ExperiencemonthYear).getText();
        if (page.monthCheck(ExperiencemonthYear)) break;
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
        if (previous) action.moveToElement(page.PreviousArrowbtn).click().perform();
        else action.moveToElement(page.NextArrowBtn).click().perform();
      }
      boolean startFlag = false;
      for (int a = 1; a <= 5; a++) {
        for (int b = 1; b <= 7; b++) {
          div = b;
          System.out.println("\nCount is: " + b);
          String ExpDate = removeZero(s.getRow(i).getCell(9).getStringCellValue());
          System.out.println("\nExperienceDate is: " + ExpDate);
          String calanderDate = page.ExpDate(a, b).getText();
          System.out.println("\nCalendar Date is: " + calanderDate);
          System.out.println(ExpDate + " equals " + calanderDate);
          if (ExpDate.equals(calanderDate) == true) {
            System.out.println("\nExperienceDate equals CalenderDate:" + calanderDate);
            page.ExpDate(a, b).click();
            startFlag = true;
            break;
          }
        }
        if (startFlag) break;
      }
      Thread.sleep(1000);
      // wait.until(ExpectedConditions.elementToBeClickable(page.DoctorRegisterbutton)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorRegisterbutton))
          .click();
      Thread.sleep(2000);

      // if (page.emailAlert()) {
      if (page.DocRegistrationemailalert()) {

        System.out.println("\n" + "Results : " + page.DocRegistrationemailalert.getText());
        if (page.DocRegistrationemailalert.getText().contains("Email ID"))
          assertEquals(
              page.DocRegistrationemailalert.getText(),
              "Email ID Already used, please try to login with credentials or use another Email ID");
        else
          assertEquals(
              page.DocRegistrationemailalert.getText(),
              "Phone Number Already used, please try to login with credentials or use another Phone Number");
        Thread.sleep(1000);
        break;
      } else {
        System.out.println("\nRegistered Successfully");
      }
      Thread.sleep(1000);

      // String s1 = page.Alertmessage.getText();
      String s1 = "Registered Successfully";
      s.getRow(i).getCell(14).setCellValue(s1);
      FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Provider.xlsx");
      wb.write(fout);
      Thread.sleep(2000);
      DoctorRegister(driver);
      // break;
    }
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
