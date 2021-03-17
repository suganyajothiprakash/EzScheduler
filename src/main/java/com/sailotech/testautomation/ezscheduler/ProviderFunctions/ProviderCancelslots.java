package com.sailotech.testautomation.ezscheduler.ProviderFunctions;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderPage;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderRepositoryclass;

import ru.yandex.qatools.allure.annotations.Attachment;

public class ProviderCancelslots extends TestBase {
 // WebDriver driver;
  int rowvalue = 0;
  int tr;
  int div;
  /*
    public ProviderCancelslots(WebDriver d) {
      this.driver = d;
      PageFactory.initElements(d, this);
    }
  */
  @Attachment
  public byte[] EzHomePage(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void ProvidercancelAppointments(WebDriver driver) throws Exception {

    WebDriverWait wait = new WebDriverWait(driver, 5);
    Actions action = new Actions(driver);
    ProviderRepositoryclass page = new ProviderRepositoryclass(driver);
    Thread.sleep(1000);
    String user_dir = System.getProperty("user.dir");
    FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Provider.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet s = wb.getSheetAt(4);
    Thread.sleep(1000);

    for (int i = 1; i <= s.getLastRowNum() + 1; i++) {
      wait.until(ExpectedConditions.elementToBeClickable(page.HomeLoginRegister)).click();
      wait.until(ExpectedConditions.elementToBeClickable(page.DoctorLoginButton)).click();
      System.out.println("\nTotal Row count is " + s.getLastRowNum());
      System.out.println("\n" + "Test Case_ID :" + s.getRow(i).getCell(0).getStringCellValue());
      System.out.println("\n" + "Inside for loop i value----->" + i);

      //page.DoctorUsername.clear();
      driver.findElement(ProviderPage.DoctorUsername).clear();
      //wait.until(ExpectedConditions.elementToBeClickable(page.DoctorUsername))
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorUsername))
          .sendKeys(s.getRow(i).getCell(1).getStringCellValue());

      //page.DoctorPassword.clear();
      driver.findElement(ProviderPage.Doctorpassword).clear();
     // wait.until(ExpectedConditions.elementToBeClickable(page.DoctorPassword))
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.Doctorpassword))
          .sendKeys(s.getRow(i).getCell(2).getStringCellValue());

      System.out.println("\n" + "Doctor Login Status : " + page.DoctorSigin.getText());
      assertEquals(page.DoctorSigin.getText(), "Sign-In");
      Thread.sleep(1000);

      //wait.until(ExpectedConditions.elementToBeClickable(page.DoctorSigin)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorSigin)).click();
      Thread.sleep(3000);

     // wait.until(ExpectedConditions.elementToBeClickable(page.monthorder)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.monthorder)).click();
      Thread.sleep(5000);
      
      System.out.println("\nSlot Cancel Date:" + s.getRow(i).getCell(3).getStringCellValue());
      String Date = s.getRow(i).getCell(3).getStringCellValue();
      
      switch (Date) {
        case "1":
          //action.moveToElement(page.Dateone).click().perform();
        	driver.findElement(ProviderPage.Dateone).click();
          Thread.sleep(1000);
          break;

        case "02":
          //action.moveToElement(page.Datetwo).click().perform();
        	driver.findElement(ProviderPage.Datetwo).click();
          Thread.sleep(1000);
          break;

        case "03":
          //action.moveToElement(page.DateThree).click().perform();
        	driver.findElement(ProviderPage.DateThree).click();
          Thread.sleep(1000);
          break;

        case "04":
          //action.moveToElement(page.DateFour).click().perform();
        	driver.findElement(ProviderPage.DateFour).click();
          Thread.sleep(1000);
          break;

        case "05":
         // action.moveToElement(page.DateFive).click().perform();
        	driver.findElement(ProviderPage.DateFive).click();
          Thread.sleep(1000);
          break;

        case "06":
          //action.moveToElement(page.DateSix).click().perform();
        	driver.findElement(ProviderPage.DateSix).click();
          Thread.sleep(1000);
          break;

        case "07":
          //action.moveToElement(page.DateSeven).click().perform();
        	driver.findElement(ProviderPage.DateSeven).click();
          Thread.sleep(1000);
          break;

        case "08":
         // action.moveToElement(page.DateEight).click().perform();
        	driver.findElement(ProviderPage.DateEight).click();
          Thread.sleep(1000);
          break;

        case "09":
          //action.moveToElement(page.DateNine).click().perform();
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
          //action.moveToElement(page.DateTweleve).click().perform();
        	driver.findElement(ProviderPage.DateTweleve).click();
          Thread.sleep(1000);

          break;

        case "13":
          //action.moveToElement(page.DateThirteen).click().perform();
        	driver.findElement(ProviderPage.DateThirteen).click();
          Thread.sleep(1000);

          break;

        case "14":
          //action.moveToElement(page.DateFourteen).click().perform();
        	driver.findElement(ProviderPage.DateFourteen).click();
          Thread.sleep(1000);
          break;

        case "15":
          //action.moveToElement(Page.DateFifteen).click().perform();
        	driver.findElement(ProviderPage.DateFifteen).click();
          Thread.sleep(1000);
          break;

        case "16":
          //action.moveToElement(page.DateSixteen).click().perform();
        	driver.findElement(ProviderPage.DateSixteen).click();
          Thread.sleep(1000);
          break;

        case "17":
         // action.moveToElement(page.DateSeventeen).click().perform();
        	driver.findElement(ProviderPage.DateSeventeen).click();
          Thread.sleep(1000);
          break;

        case "18":
          //action.moveToElement(page.DateEighteen).click().perform();
        	driver.findElement(ProviderPage.DateEighteen).click();
          Thread.sleep(1000);
          break;

        case "19":
          //action.moveToElement(page.DateNineteen).click().perform();
        	driver.findElement(ProviderPage.DateNineteen).click();
          Thread.sleep(1000);
          break;

        case "20":
          //action.moveToElement(page.DateTwenty).click().perform();
        	driver.findElement(ProviderPage.DateTwenty).click();
          Thread.sleep(1000);
          break;

        case "21":
         // action.moveToElement(page.DateTwentyone).click().perform();
        	driver.findElement(ProviderPage.DateTwentyone).click();
          Thread.sleep(1000);
          break;

        case "22":
          //action.moveToElement(page.DateTwentytwo).click().perform();
        	driver.findElement(ProviderPage.DateTwentytwo).click();
          Thread.sleep(1000);
          break;

        case "23":
         // action.moveToElement(page.DateTwentythree).click().perform();
        	driver.findElement(ProviderPage.DateTwentythree).click();
          Thread.sleep(1000);
          break;

        case "24":
          //action.moveToElement(page.DateTwentyFour).click().perform();
        	driver.findElement(ProviderPage.DateTwentyFour).click();
          Thread.sleep(1000);
          break;

        case "25":
          //action.moveToElement(page.DateTwentyFive).click().perform();
        	driver.findElement(ProviderPage.DateTwentyFive).click();
          Thread.sleep(1000);
          break;

        case "26":
          //action.moveToElement(page.DateTwentySix).click().perform();
        	driver.findElement(ProviderPage.DateTwentySix).click();
          Thread.sleep(1000);
          break;

        case "27":
          //action.moveToElement(page.DateTwentySeven).click().perform();
        	driver.findElement(ProviderPage.DateTwentySeven).click();
          Thread.sleep(1000);
          break;

        case "28":
          //action.moveToElement(page.DateTwentyEight).click().perform();
        	driver.findElement(ProviderPage.DateTwentyEight).click();
          Thread.sleep(1000);
          break;

        case "29":
         // action.moveToElement(page.DateTwentyNine).click().perform();
        	driver.findElement(ProviderPage.DateTwentyNine).click();
          Thread.sleep(1000);
          break;

        case "30":
        //  action.moveToElement(page.DateThirty).click().perform();
        	driver.findElement(ProviderPage.DateThirty).click();
          Thread.sleep(1000);
          break;

        case "31":
          //action.moveToElement(page.DateThirtyone).click().perform();
        	driver.findElement(ProviderPage.DateThirtyone).click();
          Thread.sleep(1000);
          break;
      }

      Thread.sleep(3000);
     // wait.until(ExpectedConditions.elementToBeClickable(page.openslots)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.openslots)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.openslotscount)).click();
      System.out.println("\nopen Slots: " + driver.findElement(ProviderPage.openslotscount).getText());
      // if(page.BlockAll.isDisplayed()) {
      //action.moveToElement(page.BlockAll).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.BlockAll)).click();
      //action.moveToElement(page.YesCancelAll).click().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.YesCancelAll)).click();
      Thread.sleep(2000);
      /* else
      {
       System.out.println("\nResults:No open slots are available" );
      }*/
    //  wait.until(ExpectedConditions.elementToBeClickable(page.DoctorMenu)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorMenu)).click();
     // wait.until(ExpectedConditions.elementToBeClickable(page.Doctorlogout)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.Doctorlogout)).click();
      Thread.sleep(3000);
      /*action
      .moveToElement(page.ReasonForCancel)
      .click()
      .sendKeys(s.getRow(i).getCell(4).getStringCellValue());*/
      // action.moveToElement(page.YESCANCEL).click().perform();
    }
    EzHomePage(driver);
  }
}
