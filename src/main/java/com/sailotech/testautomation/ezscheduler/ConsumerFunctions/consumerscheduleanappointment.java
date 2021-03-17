package com.sailotech.testautomation.ezscheduler.ConsumerFunctions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
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

import com.sailotech.testautomation.ezscheduler.repositorypages.*;

import ru.yandex.qatools.allure.annotations.Attachment;

public class consumerscheduleanappointment {
  WebDriver driver;
  int rowvalue;
  int div;

  public consumerscheduleanappointment(WebDriver d) {
    this.driver = d;
    PageFactory.initElements(d, this);
  }

  @Attachment
  public byte[] EzHomePage(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  /**
   * @param driver
   * @throws Exception
   */
  /**
 * @param driver
 * @throws Exception
 */
public void patient_schedule_an_appointment(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    ConsumerRepositoryclass ConsumerFunction = new ConsumerRepositoryclass(driver);
    Actions action = new Actions(driver);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Consumer.xlsx");
    @SuppressWarnings("resource")
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    // Header sheet
    XSSFSheet s = wb.getSheetAt(1);
    Thread.sleep(1000);
    System.out.println("\n" + "count is : " + s.getLastRowNum());
    Thread.sleep(1000);
    for (int i = 1; i <= s.getLastRowNum(); i++) {
      System.out.println("Total Row Count :" + s.getLastRowNum());
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.Patientmenu))
          .click();
      Thread.sleep(1000);

      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.patientHome))
          .click();
      Thread.sleep(1000);

      System.out.println("\n" + "Inside for loop i value----->" + i);
      System.out.println("\n" + "TestCase: " + s.getRow(i).getCell(0).getStringCellValue());

      // wait.until(ExpectedConditions.elementToBeClickable(page.searchbydoctor))
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.searchbydoctor))
          .click();
      Thread.sleep(1000);
      driver.findElement(ConsumerPage.searchbydoctor).clear();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.searchbydoctor))
          .sendKeys(s.getRow(i).getCell(1).getStringCellValue());
      System.out.println("\nDoctor Name :" + s.getRow(i).getCell(1).getStringCellValue());
      Thread.sleep(4000);
      // wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerFunctions.searchbylocation)).click();
      // driver.findElement(ConsumerFunctions.searchbylocation).clear();

      if (null != s.getRow(i).getCell(2).getStringCellValue()
          && !s.getRow(i).getCell(2).getStringCellValue().isEmpty()) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(ConsumerPage.searchbylocation))
            .click();
        Thread.sleep(1000);
        driver.findElement(ConsumerPage.searchbylocation).clear();
        Thread.sleep(1000);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(ConsumerPage.searchbylocation))
            .sendKeys(s.getRow(i).getCell(2).getStringCellValue());
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
      }

      wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.searchbutton))
          .click();
      System.out.println("Search button");
      Thread.sleep(4000);

      String AppointmentType = s.getRow(i).getCell(11).getStringCellValue();
      switch (AppointmentType) {
        case "office":
          // action.moveToElement(ConsumerFunction.InPersonAppointments).click().perform();
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                      ConsumerPage.InPersonAppointments))
              .click();
          System.out.println("\n" + "Appointment Type: Inperson");
          break;

        case "video":
          // action.moveToElement(ConsumerFunction.videovisit).click().perform();
          wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.videovisit))
              .click();
          System.out.println("\n" + "Appointment Type: video");
          break;

        case "AllAppointments/Both":
          // action.moveToElement(ConsumerFunction.AllAppointments).click().perform();
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(ConsumerPage.AllAppointments))
              .click();
          System.out.println("\n" + "Appointment Type: AllAppointments");
          break;

        default:
          System.out.println("consultation type mismatch");
          break;
      }

       if (null != s.getRow(i).getCell(5).getStringCellValue()
          && !s.getRow(i).getCell(5).getStringCellValue().isEmpty()) {
        action.moveToElement(ConsumerFunction.slotsavailability).click();
        /*
        wait.until(
                   ExpectedConditions.visibilityOfElementLocated(ConsumerFunctions.slotsavailability))
               .click();*/
        Thread.sleep(1000);
        action.sendKeys(Keys.BACK_SPACE).perform();
       // driver.findElement(ConsumerFunctions.slotsavailability).clear();
        Thread.sleep(1000);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(ConsumerPage.slotsavailability))
            .sendKeys(s.getRow(i).getCell(5).getStringCellValue());
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
      }

      if (null != s.getRow(i).getCell(6).getStringCellValue()
          && !s.getRow(i).getCell(6).getStringCellValue().isEmpty()) {
        action.moveToElement(ConsumerFunction.specialities).click();
        Thread.sleep(1000);
        action.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.specialities))
            .sendKeys(s.getRow(i).getCell(6).getStringCellValue());
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
      }
      Thread.sleep(2000);

       if (null != s.getRow(i).getCell(7).getStringCellValue()
          && !s.getRow(i).getCell(7).getStringCellValue().isEmpty()) {
        action.moveToElement(ConsumerFunction.conditions).click();
        /*  wait.until(
            ExpectedConditions.visibilityOfElementLocated(ConsumerFunctions.conditions))
        .click();*/
        Thread.sleep(1000);
        action.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.conditions))
            .sendKeys(s.getRow(i).getCell(7).getStringCellValue());
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
      }
      Thread.sleep(2000);

      if (null != s.getRow(i).getCell(8).getStringCellValue()
          && !s.getRow(i).getCell(8).getStringCellValue().isEmpty()) {
        action.moveToElement(ConsumerFunction.gender).click();
        /*wait.until(
            ExpectedConditions.visibilityOfElementLocated(ConsumerFunctions.gender))
        .click();*/
        Thread.sleep(1000);
        //driver.findElement(ConsumerFunctions.gender).clear();
        action.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.gender))
            .sendKeys(s.getRow(i).getCell(8).getStringCellValue());
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
      }
      Thread.sleep(2000);

      if (null != s.getRow(i).getCell(9).getStringCellValue()
          && !s.getRow(i).getCell(9).getStringCellValue().isEmpty()) {
       action.moveToElement(ConsumerFunction.languages).click();
        /* wait.until(
            ExpectedConditions.visibilityOfElementLocated(ConsumerFunctions.languages))
        .click();*/
        Thread.sleep(1000);
        action.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.languages))
            .sendKeys(s.getRow(i).getCell(9).getStringCellValue());
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
      }
      Thread.sleep(2000);

      /* if (null != s.getRow(i).getCell(10).getStringCellValue()
                && !s.getRow(i).getCell(9).getStringCellValue().isEmpty()) {
              wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerFunctions.nearby)).click();
              Thread.sleep(1000);
              driver.findElement(ConsumerFunctions.nearby).clear();
              Thread.sleep(1000);
              wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerFunctions.nearby))
                  .sendKeys(s.getRow(i).getCell(10).getStringCellValue());
              action.sendKeys(Keys.ARROW_DOWN).perform();
              action.sendKeys(Keys.ENTER).perform();
            }
      */
      for (int j = 0; j < ConsumerFunction.DoctorLocation.size(); j++) {
        String str = ConsumerFunction.DoctorLocation.get(j).getText();
        {
          System.out.println(str);
        }
      }

      Thread.sleep(2000);

      for (int k = 0; k < ConsumerFunction.DoctorLocation.size(); k++) {
        String[] locationDetails = ConsumerFunction.DoctorLocation.get(k).getText().split(":");

        if (locationDetails.length == 2
            && locationDetails[1].trim().contains(s.getRow(i).getCell(2).getStringCellValue())) {

          System.out.println("\n" + locationDetails[1]);
          rowvalue = k;
          break;
        } else if (locationDetails[0]
            .trim()
            .contains(s.getRow(i).getCell(2).getStringCellValue())) {

          System.out.println("\n" + locationDetails[0]);
          rowvalue = k;
          break;
        }
      }

      boolean slotTimeFlag = true;
      boolean noSearchTimeFlag = true;
      boolean searchTimeFlag = false;

      for (int m = 0; m < 10 && !searchTimeFlag; m++) {
        for (int l = 2; l <= 5; l++) {
          String SearchDate = s.getRow(i).getCell(3).getStringCellValue();
          System.out.println("\n" + s.getRow(i).getCell(3).getStringCellValue());
          java.util.Date date1 = null;
          SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
          SimpleDateFormat sdf2 = new SimpleDateFormat("E\n" + "dd-MMM", Locale.ENGLISH);
          try {
            date1 = sdf1.parse(SearchDate);
            SearchDate = sdf2.format(date1);
            System.out.println("\nSearchDate is : \n" + SearchDate);
          } catch (java.text.ParseException e) {
            e.printStackTrace();
          }
          String slotdate = ConsumerFunction.slotBooking(rowvalue, l).getText();
          System.out.println("\nslot date is  : \n" + slotdate);
          if (slotdate.equals(SearchDate) == true) {
            System.out.println("\nSearchDate equals Slot Date : " + SearchDate);
            if (ConsumerFunction.moreslotsPresent(rowvalue, l)) {
              searchTimeFlag = true;
              ConsumerFunction.moreslots(rowvalue, l).click();
              div = l;
              break;
            } else {
              searchTimeFlag = true;
              div = l;
            }
            /*searchTimeFlag = false;
            System.out.println("No Slots Available");
            break;*/

          } else if (ConsumerFunction.nextavailabilitypresent(rowvalue)) {
            String NextAvailable = ConsumerFunction.nextavailability(rowvalue).getText();
            if (NextAvailable.contains("\nNext Available") == true) {
              System.out.println("\nNext Available:" + NextAvailable);
              if (ConsumerFunction.moreslotsPresent(rowvalue, l)) {
                searchTimeFlag = true;
                ConsumerFunction.moreslots(rowvalue, l).click();
                div = l;
                break;
              } else /*{
                       searchTimeFlag = true;
                       div = l;
                     }*/ searchTimeFlag = true;
              ConsumerFunction.nextavailability(rowvalue).click();
              if (ConsumerFunction.moreslotsPresent(rowvalue, l)) {
                searchTimeFlag = true;
                ConsumerFunction.moreslots(rowvalue, l).click();
                div = l;
                break;
              }
              System.out.println("\nResult for Next available: " + NextAvailable);
              break;
            } else {
              String NoSlots = ConsumerFunction.Noslotsava.getText();
              if (NoSlots.contains("\nNo Slots Available") == true) {

                {
                  searchTimeFlag = true;
                  slotTimeFlag = false;
                  System.out.println("\nNo Slots Available");
                  break;
                }
              }
            }
          }
        }

        Thread.sleep(1000);
        if (!searchTimeFlag) {
          if (ConsumerFunction.nextarrowbuttonPresent(rowvalue)) {
            System.out.println("next date slots");
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                        ConsumerFunction.nextarrowbutton(rowvalue)))
                .click();
          } else System.out.println("No More rows");
        }
      }

      String SearchTime = s.getRow(i).getCell(4).getStringCellValue();
      String slottime;
      if (slotTimeFlag)
        for (int o = 2; o <= 100; o++) {
          System.out.println("\nSearch time : " + SearchTime);
          if (ConsumerFunction.slottimePresent(rowvalue, div, o)) {
            slottime = ConsumerFunction.slottime(rowvalue, div, o).getText(); // contains span
            System.out.println("\nSlot Time :" + slottime);
            if (slottime.equals(SearchTime) == true) {
              System.out.println(SearchTime + " equals " + slottime);
              ConsumerFunction.slottime(rowvalue, div, o).click();
              break;
            }
          } else {
            System.out.println(SearchTime + ": is not available");
            noSearchTimeFlag = false;
            break;
          }
        }

      String ConsultationType = s.getRow(i).getCell(23).getStringCellValue();
      switch (ConsultationType) {
        case "office":
          if (null != s.getRow(i).getCell(23).getStringCellValue()
              && !s.getRow(i).getCell(23).getStringCellValue().isEmpty()) {

            if (ConsumerFunction.officevisitradiobuttonpresent()) {
              // action.moveToElement(ConsumerFunction.officevisitradiobutton).click().perform();
              wait.until(
                      ExpectedConditions.visibilityOfElementLocated(
                          ConsumerPage.officevisitradiobutton))
                  .click();

              System.out.println("\n" + "Consultation Type: office");
            } else System.out.println("\nNo Radio button for Consultation Type: office");
          }

        case "video":
          if (null != s.getRow(i).getCell(23).getStringCellValue()
              && !s.getRow(i).getCell(23).getStringCellValue().isEmpty()) {

            if (ConsumerFunction.videovisitradiobuttonpresent()) {
              // action.moveToElement(ConsumerFunction.videovisitradiobutton).click().perform();
              wait.until(
                      ExpectedConditions.visibilityOfElementLocated(
                          ConsumerPage.videovisitradiobutton))
                  .click();
              System.out.println("\n" + "Consultation Type: video");
            } else System.out.println("\nNo Radio button for Consultation Type: video");
          }
          break;

        default:
          System.out.println("No consultation  found");
      }
      Thread.sleep(2000);
      String Appointmentfor = s.getRow(i).getCell(12).getStringCellValue();
      if (noSearchTimeFlag) {
        switch (Appointmentfor) {
          case "self":
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        ConsumerPage.selfradiobutton))
                .click();
            System.out.println("\nAppointment for: self");
            break;

          case "others":
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        ConsumerPage.othersradiobutton))
                .click();
            System.out.println("\nAppointment for: others");
            break;

          default:
            System.out.println("No Appointments found");
        }
        Thread.sleep(1000);
        if (Appointmentfor.equalsIgnoreCase("others")) {
          wait.until(
                  ExpectedConditions.visibilityOfElementLocated(
                      ConsumerPage.relationwithpatient))
              .sendKeys(s.getRow(i).getCell(13).getStringCellValue());
          Thread.sleep(1000);

          wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.nameofpatient))
              .sendKeys(s.getRow(i).getCell(14).getStringCellValue());
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.reasonforvisit))
            .sendKeys(s.getRow(i).getCell(15).getStringCellValue());
        Thread.sleep(2000);

        String TermsandConditions = s.getRow(i).getCell(16).getStringCellValue();
        switch (TermsandConditions) {
          case "I Agree":
            // ConsumerFunction.iagreeradiobutton.click();
            driver.findElement(ConsumerPage.iagreeradiobutton).click();
            // wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerFunctions.iagreeradiobutton)).click();
            System.out.println("\nTerms and Conditions: I Agree");
            break;

          case "I do not agree":
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        ConsumerPage.idisgreeradiobutton))
                .click();
            System.out.println("\nTerms and Conditions: I do not agree");
            break;
          default:
            System.out.println("No Terms and Conditions found");
        }

        Thread.sleep(4000);

        String PaymentMethod = s.getRow(i).getCell(17).getStringCellValue();
        switch (PaymentMethod) {
          case "confirmandpayaftervisit":
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        ConsumerPage.confirmandpayaftervisit))
                .click();
            System.out.println("\n" + "payment status: Not paid");
            Thread.sleep(20000);
            break;

          case "confirmandcontinue":
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                        ConsumerPage.confirmandcontinueforpayment))
                .click();
            System.out.println("\n" + "payment status: paid");
            break;

          default:
            System.out.println("No Payment Method found");
        }
        Thread.sleep(4000);

        if (PaymentMethod.equalsIgnoreCase("confirmandcontinue")) {
          Thread.sleep(1000);

          String PaymentType = s.getRow(i).getCell(18).getStringCellValue();
          switch (PaymentType) {
            case "Card":
              Thread.sleep(4000);
              driver.switchTo().frame(0);
              wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.Card))
                  .click();
              System.out.println("\n" + "Payment Type : Card");
              wait.until(
                      ExpectedConditions.visibilityOfElementLocated(ConsumerPage.cardnumber))
                  .sendKeys(s.getRow(i).getCell(19).getStringCellValue());
              wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.expiry))
                  .sendKeys(s.getRow(i).getCell(20).getStringCellValue());
              wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.cvv))
                  .sendKeys(s.getRow(i).getCell(21).getStringCellValue());
              Thread.sleep(1000);
              wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.paybutton))
                  .click();
              Thread.sleep(2000);
              wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.Skipcard))
                  .click();
              Thread.sleep(2000);

              try {
                if (ConsumerFunction.Skipcard.isDisplayed()) {
                  // ConsumerFunction.Skipcard.click();
                  wait.until(
                          ExpectedConditions.visibilityOfElementLocated(ConsumerPage.Skipcard))
                      .click();
                }
              } catch (Exception e) {
                System.out.println("\n" + "Payment Successful");
              }
              break;

            case "NetBanking":
              Thread.sleep(4000);
              driver.switchTo().frame(0);
              wait.until(
                      ExpectedConditions.visibilityOfElementLocated(ConsumerPage.netbanking))
                  .click();
              System.out.println("\nPayment Type:Netbanking");
              Thread.sleep(4000);

              String bankName = s.getRow(i).getCell(22).getStringCellValue();
              switch (bankName) {
                case "SBI":
                  wait.until(
                          ExpectedConditions.visibilityOfElementLocated(ConsumerPage.SBIBank))
                      .click();
                  System.out.println("\n" + "Payment Type: Netbanking SBI Bank");
                  wait.until(
                          ExpectedConditions.visibilityOfElementLocated(
                              ConsumerPage.paybutton))
                      .click();
                  Thread.sleep(1000);
                  break;

                case "HDFC":
                  wait.until(
                          ExpectedConditions.visibilityOfElementLocated(ConsumerPage.HDFCBank))
                      .click();
                  System.out.println("\n" + "Payment Type: Netbanking HDFC Bank");
                  driver.findElement(ConsumerPage.paybutton).click();
                  System.out.println("Paid");
                  Thread.sleep(1000);
                  break;

                case "ICCI":
                  wait.until(
                          ExpectedConditions.visibilityOfElementLocated(ConsumerPage.ICCIBank))
                      .click();
                  System.out.println("\n" + "Payment Type: Netbanking ICCI Bank");
                  Thread.sleep(1000);
                  break;

                case "Kotak":
                  wait.until(
                          ExpectedConditions.visibilityOfElementLocated(
                              ConsumerPage.KotakBank))
                      .click();
                  System.out.println("\n" + "Payment Type: Netbanking Kotak Bank");
                  Thread.sleep(1000);
                  break;

                case "Yes":
                  wait.until(
                          ExpectedConditions.visibilityOfElementLocated(ConsumerPage.YesBank))
                      .click();
                  System.out.println("\n" + "Payment Type: Netbanking Yes Bank");
                  Thread.sleep(1000);
                  break;

                default:
                  System.out.println("No Bank found");
              }
          }

          ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
          System.out.println("\ncurrently opened tabs are : " + tabs.size());
          driver.switchTo().window(tabs.get(0));
          wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.successbutton))
              .click();
          if (ConsumerFunction.AppScheduled.isDisplayed()) {
            System.out.println(
                "\nResults for Appointment : " + ConsumerFunction.AppScheduled.getText());
            String s1 = " Appointment Scheduled Successfully";
            s.getRow(i).getCell(24).setCellValue(s1);
            FileOutputStream fout = new FileOutputStream(user_dir + "/inputFiles/Consumer.xlsx");
            wb.write(fout);
            Thread.sleep(5000);
          }
        }
      }
    }
    Thread.sleep(7000);
    EzHomePage(driver);
  }
}
