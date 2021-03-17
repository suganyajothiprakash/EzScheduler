package com.sailotech.testautomation.ezscheduler.ProviderFunctions;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderPage;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderRepositoryclass;

import net.bytebuddy.asm.Advice.Exit;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Providergeneratingslots extends TestBase {

  @Attachment
  public byte[] ToGenerateSlots(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
  /**
   * @param driver
   * @throws Exception
   */
  public void GenerateSlots(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    ProviderRepositoryclass page = new ProviderRepositoryclass(driver);
    Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Provider.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet s = wb.getSheetAt(1);
    Thread.sleep(1000);

    for (int i = 1; i <= s.getLastRowNum(); i++) {
      // action.moveToElement(page.DoctorMenu).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorMenu)).click();
      Thread.sleep(2000);

      // action.moveToElement(page.Generateslots).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.Generateslots)).click();
      Thread.sleep(1000);
      System.out.println("\nTestcase_ID :" + s.getRow(i).getCell(0).getStringCellValue());
      System.out.println("\nInside for loop i value----->" + i);
      System.out.println("\nTotal Row Count :" + s.getLastRowNum());

      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.Doctorlocations))
          .sendKeys(s.getRow(i).getCell(1).getStringCellValue());
      action.sendKeys(Keys.ARROW_DOWN).perform();
      action.sendKeys(Keys.ENTER).perform();
      Thread.sleep(1000);
      System.out.println("\nDoctorLocation is: " + s.getRow(i).getCell(1).getStringCellValue());

      if (ProviderPage.DoctorLocationAlertmessage()) {
        if (ProviderPage.DoctorLocationAlertMessage()
            .getText()
            .contains("Please select a location for Visit"))
          /* assertEquals(
          (ProviderPage.DoctorLocationAlertMessage().getText()),
          "Please select a location for Visit");*/
          System.out.println(
              "\nAlert Message for DoctorLocation: "
                  + ProviderPage.DoctorLocationAlertMessage().getText());
      }
      Thread.sleep(1000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.slottype))
          .sendKeys(s.getRow(i).getCell(2).getStringCellValue());
      action.sendKeys(Keys.ARROW_DOWN).perform();
      action.sendKeys(Keys.ENTER).perform();
      Thread.sleep(1000);
      System.out.println("\nSlotType is: " + s.getRow(i).getCell(2).getStringCellValue());

      if (ProviderPage.SlotTypeAlertmessage()) {
        // System.out.println("\n" + "Results : " + ProviderPage.FromDateAlertMessage().getText());
        if (ProviderPage.SlotTypeAlertMessage().getText().contains("Slot Type is required"))
          assertEquals((ProviderPage.SlotTypeAlertMessage().getText()), "Slot Type is required");
        System.out.println(
            "\nAlert Message for SlotType: " + ProviderPage.SlotTypeAlertMessage().getText());
      }
      Thread.sleep(1000);

      // page.fromDate.clear();
      driver.findElement(ProviderPage.fromDate).clear();
      // page.fromDate.sendKeys(s.getRow(i).getCell(3).getStringCellValue());
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.fromDate))
          .sendKeys(s.getRow(i).getCell(3).getStringCellValue());
      Thread.sleep(1000);
      System.out.println("\nFromDate: " + s.getRow(i).getCell(3).getStringCellValue());

      if (ProviderPage.FromDateAlertmessage()) {
        // System.out.println("\n" + "Results : " + ProviderPage.FromDateAlertMessage().getText());
        if (ProviderPage.FromDateAlertMessage()
            .getText()
            .contains("Date should not be before minimal date"))
          assertEquals(
              (ProviderPage.FromDateAlertMessage().getText()),
              "Date should not be before minimal date");
        System.out.println(
            "\nAlert Message for FromDate: " + ProviderPage.FromDateAlertMessage().getText());
      }
      Thread.sleep(1000);

      // page.toDate.clear();
      driver.findElement(ProviderPage.toDate).clear();
      // page.toDate.sendKeys(s.getRow(i).getCell(4).getStringCellValue());
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.toDate))
          .sendKeys(s.getRow(i).getCell(4).getStringCellValue());
      Thread.sleep(1000);
      System.out.println("\nToDate: " + s.getRow(i).getCell(4).getStringCellValue());

      if (ProviderPage.ToDateAlertmessage()) {
        // System.out.println("\n" + "Results : " + ProviderPage.ToDateAlertMessage().getText());
        if (ProviderPage.ToDateAlertMessage()
            .getText()
            .contains("Date should not be before minimal date"))
          assertEquals(
              (ProviderPage.ToDateAlertMessage().getText()),
              "Date should not be before minimal date");
        System.out.println(
            "\nAlert Message for ToDate: " + ProviderPage.ToDateAlertMessage().getText());
      }
      Thread.sleep(1000);

      // page.fromTime.clear();
      driver.findElement(ProviderPage.fromTime).clear();
      // page.fromTime.sendKeys(s.getRow(i).getCell(5).getStringCellValue());
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.fromTime))
          .sendKeys(s.getRow(i).getCell(5).getStringCellValue());
      Thread.sleep(1000);
      System.out.println("\nFromTime: " + s.getRow(i).getCell(5).getStringCellValue());

      if (ProviderPage.FromTimeAlertmessage()) {
        if (ProviderPage.FromTimeAlertMessage()
            .getText()
            .contains("Slot End Time cannot be less than or equal to slot Start time"))
          assertEquals(
              (ProviderPage.FromTimeAlertMessage().getText()),
              "Slot End Time cannot be less than or equal to slot Start time");
        System.out.println(
            "\nAlert Message for FromTime: " + ProviderPage.FromTimeAlertMessage().getText());
      }
      Thread.sleep(1000);

      // page.toTime.clear();
      driver.findElement(ProviderPage.toTime).clear();
      // page.toTime.sendKeys(s.getRow(i).getCell(6).getStringCellValue());
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.toTime))
          .sendKeys(s.getRow(i).getCell(6).getStringCellValue());
      Thread.sleep(1000);
      System.out.println("\nToTime: " + s.getRow(i).getCell(6).getStringCellValue());

      if (ProviderPage.ToTimeAlertmessage()) {
        // System.out.println("\n" + "Results : " + ProviderPage.ToTimeAlertMessage().getText());
        if (ProviderPage.ToTimeAlertMessage()
            .getText()
            .contains("Slot End Time cannot be less than or equal to slot Start time"))
          assertEquals(
              (ProviderPage.ToTimeAlertMessage().getText()),
              "Slot End Time cannot be less than or equal to slot Start time");
        System.out.println(
            "\nAlert Message for ToTime: " + ProviderPage.ToTimeAlertMessage().getText());
      }
      Thread.sleep(1000);

      String Days = s.getRow(i).getCell(7).getStringCellValue();
      String[] Day = Days.split(",");
      // System.out.println(Day.length);
      for (int k = 0; k < Day.length; k++) {
        // System.out.println(Day[k]);
        switch (Day[k]) {
          case "Sunday":
            // action.moveToElement(page.Sunday).click().perform();
            driver.findElement(ProviderPage.Sunday).click();
            Thread.sleep(1000);
            System.out.println("\n" + "Day is : Sunday");
            break;

          case "Monday":
            // action.moveToElement(page.Monday).click().perform();
            driver.findElement(ProviderPage.Monday).click();
            Thread.sleep(1000);
            System.out.println("\n" + "Day is : Monday");
            break;

          case "Tuesday":
            // action.moveToElement(page.Tuesday).click().perform();
            driver.findElement(ProviderPage.Monday).click();
            Thread.sleep(1000);
            System.out.println("\n" + "Day is : Tuesday");
            break;

          case "Wednesday":
            // action.moveToElement(page.Wednesday).click().perform();
            driver.findElement(ProviderPage.Wednesday).click();
            Thread.sleep(1000);
            System.out.println("\n" + "Day is : Wednesday");
            break;

          case "Thursday":
            // action.moveToElement(page.Thursday).click().perform();
            driver.findElement(ProviderPage.Thursday).click();
            Thread.sleep(1000);
            System.out.println("\n" + "Day is : Thrusday");
            break;

          case "Friday":
            // action.moveToElement(page.Friday).click().perform();
            driver.findElement(ProviderPage.Friday).click();
            Thread.sleep(1000);
            System.out.println("\n" + "Day is : Friday");
            break;

          case "Saturday":
            // action.moveToElement(page.Saturday).click().perform();
            driver.findElement(ProviderPage.Saturday).click();
            Thread.sleep(1000);
            System.out.println("\n" + "Day is : Saturday");
            break;

          case "Default":
            System.out.println("\n" + "Day is : Days not Found");
            break;
        }
      }
      // page.slotduration.clear();
      driver.findElement(ProviderPage.slotduration).clear();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.slotduration))
          .sendKeys(s.getRow(i).getCell(8).getStringCellValue());
      // page.slotduration.sendKeys(s.getRow(i).getCell(8).getStringCellValue());
      Thread.sleep(1000);

      if (ProviderPage.SlotDurationAlertmessage()) {
        // System.out.println("\n" + "Results : " +
        // ProviderPage.SlotDurationAlertMessage().getText());
        if (ProviderPage.SlotDurationAlertMessage()
            .getText()
            .contains("Min Slot duration should be 10 mins"))
          /*assertEquals(
          (ProviderPage.SlotDurationAlertMessage().getText()),
          "Min Slot duration should be 10 mins");*/
          System.out.println(
              "\nAlert Message for SlotDuration: "
                  + ProviderPage.SlotDurationAlertMessage().getText());
      }
      Thread.sleep(1000);

      // page.consultationFee.clear();
      driver.findElement(ProviderPage.consultationFee).clear();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.consultationFee))
          .sendKeys(s.getRow(i).getCell(9).getStringCellValue());
      // page.consultationFee.sendKeys(s.getRow(i).getCell(9).getStringCellValue());
      Thread.sleep(1000);

      if (ProviderPage.ConsultationFeeAlertmessage()) {
        // System.out.println("\n" + "Results : " + ProviderPage.FromDateAlertMessage().getText());
        if (ProviderPage.ConsultationFeeAlertMessage()
            .getText()
            .contains("Fee should be numeric  (in Rupees.)"))
          /*assertEquals(
          (ProviderPage.ConsultationFeeAlertMessage().getText()),
          "Fee should be numeric  (in Rupees.)");*/
          System.out.println(
              "\nAlert Message for Consultation fee: "
                  + ProviderPage.ConsultationFeeAlertMessage().getText());
      }
      Thread.sleep(1000);

      String FromDate = (s.getRow(i).getCell(3).getStringCellValue());
      String ToDate = (s.getRow(i).getCell(4).getStringCellValue());

      java.util.Date Date1 = null;
      java.util.Date Date2 = null;

      SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
      SimpleDateFormat sdf2 = new SimpleDateFormat("E, MMM dd");

      SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
      SimpleDateFormat sdf4 = new SimpleDateFormat("E, MMM dd");

      try {

        Date1 = sdf1.parse(FromDate);
        FromDate = sdf2.format(Date1);
        System.out.println("\n" + "FromDate is :" + FromDate);
        Date2 = sdf3.parse(ToDate);
        ToDate = sdf4.format(Date2);
        System.out.println("\n" + "ToDate is :" + ToDate);
      } catch (java.text.ParseException e) {
        e.printStackTrace();
        System.out.println("Error: from/to date is not formatting" + e.getMessage());
        // throw new AssertionError("From/To Date is not formatting", e);
      }
      Thread.sleep(1000);
      
      try {
      // Assert.AreEqual(false, button.Enabled);
      if (ProviderPage.generateSlotbutton()) {
        if (ProviderPage.generateSlotButton().getText().contains("Generate Slots") && ProviderPage.generateSlotButton().isEnabled())
          ProviderPage.generateSlotButton().click();
        System.out.println(
            "\nResult for Generate slots: " + ProviderPage.generateSlotButton().getText());
      } else {
        // ProviderPage.DisableGenerateSlotsButton().isDisplayed();
        System.out.println("\nResults for generate slots Button :Disabled");
      }
      }
      catch(WebDriverException we)
      {
          System.out.println("\nResults for generate slots Button :Disabled");
    	  System.exit(0);
    	  
      }
      // System.out.println("\n" + ProviderPage.AlertMessage().getText());
      String AlertMessage = ProviderPage.AlertMessage().getText();
      s.getRow(i).getCell(12).setCellValue(AlertMessage);
      FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Provider.xlsx");
      wb.write(fout);

      /* if (ProviderPage.generateSlotButton.isDisplayed()) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.generateSlotButton))
            .click();
      } else {
        System.out.println("Generateslot Button:Not Found/Disabled");
      }*/

      // action.moveToElement(page.DoctorMenu).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorMenu)).click();
      Thread.sleep(1000);

      // action.moveToElement(page.Myschedule).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.Myschedule)).click();
      Thread.sleep(2000);

      // action.moveToElement(page.monthorder).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.monthorder)).click();
      Thread.sleep(2000);

      System.out.println("\nDate:" + s.getRow(i).getCell(14).getStringCellValue());
      Thread.sleep(1000);

      String Date = s.getRow(i).getCell(14).getStringCellValue();

      switch (Date) {
        case "1":
          // action.moveToElement(page.Dateone).click().perform();
          driver.findElement(ProviderPage.Dateone).click();
          Thread.sleep(1000);
          break;

        case "02":
          // action.moveToElement(page.Datetwo).click().perform();
          driver.findElement(ProviderPage.Datetwo).click();
          Thread.sleep(1000);
          break;

        case "03":
          //  action.moveToElement(page.DateThree).click().perform();
          driver.findElement(ProviderPage.DateThree).click();
          Thread.sleep(1000);
          break;

        case "04":
          // action.moveToElement(page.DateFour).click().perform();
          driver.findElement(ProviderPage.DateFour).click();
          Thread.sleep(1000);
          break;

        case "05":
          // action.moveToElement(page.DateFive).click().perform();
          driver.findElement(ProviderPage.DateFive).click();
          Thread.sleep(1000);
          break;

        case "06":
          // action.moveToElement(page.DateSix).click().perform();
          driver.findElement(ProviderPage.DateSix).click();
          Thread.sleep(1000);
          break;

        case "07":
          // action.moveToElement(page.DateSeven).click().perform();
          driver.findElement(ProviderPage.DateSeven).click();
          Thread.sleep(1000);
          break;

        case "08":
          // action.moveToElement(page.DateEight).click().perform();
          driver.findElement(ProviderPage.DateEight).click();
          Thread.sleep(1000);
          break;

        case "09":
          // action.moveToElement(page.DateNine).click().perform();
          driver.findElement(ProviderPage.DateNine).click();
          Thread.sleep(1000);
          break;

        case "10":
          // action.moveToElement(page.DateTen).click().perform();
          driver.findElement(ProviderPage.DateTen).click();
          Thread.sleep(1000);

        case "11":
          // action.moveToElement(page.DateEleven).click().perform();
          driver.findElement(ProviderPage.DateEleven).click();
          Thread.sleep(1000);
          break;

        case "12":
          // action.moveToElement(page.DateTweleve).click().perform();
          driver.findElement(ProviderPage.DateTweleve).click();
          Thread.sleep(1000);
          break;

        case "13":
          // action.moveToElement(page.DateThirteen).click().perform();
          driver.findElement(ProviderPage.DateThirteen).click();
          Thread.sleep(1000);
          break;

        case "14":
          // action.moveToElement(page.DateFourteen).click().perform();
          driver.findElement(ProviderPage.DateFourteen).click();
          Thread.sleep(1000);
          break;

        case "15":
          // action.moveToElement(page.DateFifteen).click().perform();
          driver.findElement(ProviderPage.DateFifteen).click();
          Thread.sleep(1000);
          break;

        case "16":
          // action.moveToElement(page.DateSixteen).click().perform();
          driver.findElement(ProviderPage.DateSixteen).click();
          Thread.sleep(1000);
          break;

        case "17":
          // action.moveToElement(page.DateSeventeen).click().perform();
          driver.findElement(ProviderPage.DateSeventeen).click();
          Thread.sleep(1000);
          break;

        case "18":
          // action.moveToElement(page.DateEighteen).click().perform();
          driver.findElement(ProviderPage.DateEighteen).click();
          Thread.sleep(1000);
          break;

        case "19":
          // action.moveToElement(page.DateNineteen).click().perform();
          driver.findElement(ProviderPage.DateNineteen).click();
          Thread.sleep(1000);
          break;

        case "20":
          // action.moveToElement(page.DateTwenty).click().perform();
          driver.findElement(ProviderPage.DateTwenty).click();
          Thread.sleep(1000);
          break;

        case "21":
          //  action.moveToElement(page.DateTwentyone).click().perform();
          driver.findElement(ProviderPage.DateTwentyone).click();
          Thread.sleep(1000);
          break;

        case "22":
          // action.moveToElement(page.DateTwentytwo).click().perform();
          driver.findElement(ProviderPage.DateTwentytwo).click();
          Thread.sleep(1000);
          break;

        case "23":
          // action.moveToElement(page.DateTwentythree).click().perform();
          driver.findElement(ProviderPage.DateTwentythree).click();
          Thread.sleep(1000);
          break;

        case "24":
          //  action.moveToElement(page.DateTwentyFour).click().perform();
          driver.findElement(ProviderPage.DateTwentyFour).click();
          Thread.sleep(1000);
          break;

        case "25":
          // action.moveToElement(page.DateTwentyFive).click().perform();
          driver.findElement(ProviderPage.DateTwentyFive).click();
          Thread.sleep(1000);
          break;

        case "26":
          //  action.moveToElement(page.DateTwentySix).click().perform();
          driver.findElement(ProviderPage.DateTwentySix).click();
          Thread.sleep(1000);
          break;

        case "27":
          //  action.moveToElement(page.DateTwentySeven).click().perform();
          driver.findElement(ProviderPage.DateTwentySeven).click();
          Thread.sleep(1000);
          break;

        case "28":
          // action.moveToElement(page.DateTwentyEight).click().perform();
          driver.findElement(ProviderPage.DateTwentyEight).click();
          Thread.sleep(1000);
          break;

        case "29":
          // action.moveToElement(page.DateTwentyNine).click().perform();
          driver.findElement(ProviderPage.DateTwentyNine).click();
          Thread.sleep(1000);
          break;

        case "30":
          // action.moveToElement(page.DateThirty).click().perform();
          driver.findElement(ProviderPage.DateThirty).click();
          Thread.sleep(1000);
          break;

        case "31":
          // action.moveToElement(page.DateThirtyone).click().perform();
          driver.findElement(ProviderPage.DateThirtyone).click();
          Thread.sleep(1000);
          break;
      }

      // action.moveToElement(page.upcomingappointments).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.upcomingappointments))
          .click();
      System.out.println("\n" + ProviderPage.upcomingappointments().getText());
      Thread.sleep(1000);

      // action.moveToElement(page.BlockedSlots).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.BlockedSlots)).click();
      System.out.println("\n" + ProviderPage.BlockedSlots().getText());
      Thread.sleep(1000);

      // action.moveToElement(page.pastappointments).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.pastappointments))
          .click();
      System.out.println("\n" + ProviderPage.pastappointments().getText());
      Thread.sleep(1000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.openSlots)).click();
      // action.moveToElement(page.openSlots).click().perform();
      System.out.println("\n" + ProviderPage.openSlots().getText());
      Thread.sleep(1000);

      String Order = s.getRow(i).getCell(10).getStringCellValue();
      switch (Order) {
        case "Month":
          // action.moveToElement(page.monthorder).click().perform();
          driver.findElement(ProviderPage.monthorder).click();
          System.out.println("\n" + "Order is : Month");
          break;

        case "Week":
          // action.moveToElement(page.weekorder).click().perform();
          driver.findElement(ProviderPage.weekorder).click();
          System.out.println("\n" + "Order is : Week");
          break;

        case "Day":
          // action.moveToElement(page.Dayorder).click().perform();
          driver.findElement(ProviderPage.Dayorder).click();
          System.out.println("\n" + "Order is : Day");
          break;

        case "List":
          // action.moveToElement(page.ListOrder).click().perform();
          driver.findElement(ProviderPage.ListOrder).click();
          System.out.println("\n" + "Order is : List");
          break;
      }

      Thread.sleep(4000);
      /* action
      .moveToElement(page.AllLocations)
      .click()*/
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.AllLocations)).click();
      action.sendKeys(s.getRow(i).getCell(11).getStringCellValue());
      action.sendKeys(Keys.ARROW_DOWN).perform();
      action.sendKeys(Keys.ENTER).perform();
      System.out.println("\n" + "Location is : " + s.getRow(i).getCell(11).getStringCellValue());
      Thread.sleep(3000);
      ToGenerateSlots(driver);
    }
  }

  public static boolean isClickable(WebElement el, WebDriver driver) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.elementToBeClickable(el));
      return true;
    } catch (TimeoutException  e) {
      return false;
    }
  }
}
