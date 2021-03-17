package com.sailotech.testautomation.ezscheduler.repositorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;

public class ProviderPage extends TestBase {

  public ProviderPage(WebDriver d) {
    TestBase.driver = d;
    PageFactory.initElements(d, this);
  }

  public static By HomeLoginRegister = By.xpath("//*[starts-with(text(),'Login/Register')]");

  public static By DoctorLoginButton =
      By.xpath(
          "//header/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/h5[1]/a[1]");

  public static By DoctorSigin = By.xpath("//span[contains(text(),'Sign-In')]");

  public static WebElement DoctorSignin() {
    return driver.findElement(By.xpath("//span[contains(text(),'Sign-In')]"));
  }

  public static By DoctorUsername =
      By.xpath(
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

  public static WebElement DoctorName() {
    return driver.findElement(
        By.xpath("//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/div[1]"));
  }

  public static By Doctorpassword = By.name("password");

  public static By DoctorName =
      By.xpath("//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/div[1]");

  public static By DoctorMenu =
      By.xpath(
          "//body[@id='body']/div[@id='app-site']/div/div/div/div/header/div/div[1]//*[local-name()='svg']");

  public static By Doctorlogout = By.xpath("//*[contains(text(),'Logout')]");

  public static By Doctorregister =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/ul/li/div/div/div/div[1]/ul/li[2]/div/h5/a[2]");

  public static By DocRegistrationDoctorname =
      By.xpath(
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]");

  public static By DocRegistrationDoctorEmail =
      By.xpath(
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]");

  public static By DocRegistrationDoctormobilenumber =
      By.xpath(
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[1]");

  public static By DocRegistrationSpecializedIn =
      By.xpath("//input[contains(@name,'specializations')]");

  public static By DocRegistrationdegree =
      By.xpath(
          "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[6]/div[1]/div[1]/input[1]");

  public static By RegistrationGenderfemale = By.xpath("//span[contains(text(),'Female')]");

  public static By RegistrationGendermale = By.xpath("//span[contains(text(),'Male')]");

  public static By RegistrationDoctorpracticestartdate =
      By.xpath(
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[7]/div[1]/input[1]");

  public static By DocRegistrationyearselection =
      By.xpath("//body/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]/h6[1]");

  public static By DoctorRegisterbutton =
      By.xpath(
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/button[1]/span[1]");

  public static By DocRegistrationemailalert =
      By.xpath("//div[starts-with(@class,'shadow-lg alert alert-danger fade show')]");

  public static By clickheretoSignIn =
      By.xpath("//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/p/a");
  
  public static By ResetPassword = By.xpath("span[starts-with(@class,'nav-text') and contains(text(),'Reset Password')]");

  public static By monthorder = By.xpath("//button[contains(text(),'Month')]");

  public static By Dateone = By.linkText("1");

  public static By Datetwo = By.linkText("2");

  public static By DateThree = By.linkText("3");

  public static By DateFour = By.linkText("4");

  public static By DateFive = By.linkText("5");

  public static By DateSix = By.linkText("6");

  public static By DateSeven = By.linkText("7");

  public static By DateEight = By.linkText("8");

  public static By DateNine = By.linkText("9");

  public static By DateTen = By.linkText("10");

  public static By DateEleven = By.linkText("11");

  public static By DateTweleve = By.linkText("12");

  public static By DateThirteen = By.linkText("13");

  public static By DateFourteen = By.linkText("14");

  public static By DateFifteen = By.linkText("15");

  public static By DateSixteen = By.linkText("16");

  public static By DateSeventeen = By.linkText("17");

  public static By DateEighteen = By.linkText("18");

  public static By DateNineteen = By.linkText("19");

  public static By DateTwenty = By.linkText("20");

  public static By DateTwentyone = By.linkText("21");

  public static By DateTwentytwo = By.linkText("22");

  public static By DateTwentythree = By.linkText("23");

  public static By DateTwentyFour = By.linkText("24");

  public static By DateTwentyFive = By.linkText("25");

  public static By DateTwentySix = By.linkText("26");

  public static By DateTwentySeven = By.linkText("27");

  public static By DateTwentyEight = By.linkText("28");

  public static By DateTwentyNine = By.linkText("29");

  public static By DateThirty = By.linkText("30");

  public static By DateThirtyone = By.linkText("31");

  public static By openslots = By.xpath("//h6[contains(text(),'Open Slots')]");

  public static By BlockAll =
      By.xpath(
          "//span[starts-with(@class,'MuiChip-label MuiChip-labelSmall') and contains(text(),'Block All')]");

  public static By YesCancelAll =
      By.xpath("//span[starts-with(@class,'MuiButton-label') and contains(text(),'Yes')]");

  public static By openslotscount =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[2]/button/div/div[2]");

  public static By generateSlotsMenu =
      By.xpath("//div[contains(@class,'scrollbar')]//div[3]//a[1]");

  public static By AllLocations =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[1]/div[1]/div/div/div");

  public static By Alllocationsdropdown = By.xpath("//svg(@class,'MuiSvgIcon-root')");

  public static By Dayorder =
      By.xpath(
          "//button[starts-with(@class,'fc-dayGridMonth-button fc-button fc-button-primary') and contains (text(),'Day')]");

  public static By ListOrder =
      By.xpath(
          "//button[starts-with(@class,'fc-dayGridMonth-button fc-button fc-button-primary') and contains (text(),'List')]");

  public static By location = By.name("facility");

  public static By selectedlocation = By.xpath("//input[@id='mui-32785']");

  public static By videoSlotType =
      By.xpath("//*[contains(@name,'consultType') and contains(@value,'Video')]");

  public static By atOfficeSlotType =
      By.xpath("//*[contains(@name,'video') and contains(@value,'At Office')]");

  public static By fromDate = By.name("fromDate");

  public static By toDate =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[2]/div[3]/div/div/input");

  public static By fromTime =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[3]/div[2]/div/div/input");

  public static By toTime =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[3]/div[3]/div/div/input");

  public static By slotduration =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[5]/div[2]/div/div/input");

  public static By Sunday = By.xpath("//*[contains(text(),'Sun')]");

  public static By Monday = By.xpath("//*[contains(text(),'Mon')]");

  public static By Tuesday = By.xpath("//*[contains(text(),'Tue')]");

  public static By Wednesday = By.xpath("//*[contains(text(),'Wed')]");

  public static By Thursday = By.xpath("//*[contains(text(),'Thu')]");

  public static By Friday = By.xpath("//*[contains(text(),'Fri')]");

  public static By Saturday = By.xpath("//*[contains(text(),'Sat')]");

  public static By Daily = By.xpath("//*[contains(text(),'Daily')]");

  public static By Generateslots =
      By.xpath("//span[starts-with(@class,'nav-text') and contains (text(),'Generate Slots')]");

  public static By Doctorlocations = By.name("facility");

  public static By slottype =
      By.xpath(
          "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]");

  public static By SlotType = By.xpath("//input[@id='mui-19752']");

  public static By consultationFee = By.name("price");

   public static By generateSlotButton =
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[7]/div[2]/button/span[1]");
  
  public static By Myschedule = By.xpath("//span[contains(text(),'My Schedule')]");

  public static By weekorder = By.xpath("//button[contains(text(),'Week')]");

  public static WebElement ConsultationFeeAlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Fee should be numeric  (in Rupees.)')]"));
  }

  public static Boolean ConsultationFeeAlertmessage() {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Fee should be numeric  (in Rupees.)')]"))
        .isEmpty()) {
      // THEN CLICK ON THE SUBMIT BUTTON
      return true;

    } else {

      return false;

      // DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
    }
  }

  public static WebElement SlotDurationAlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Min Slot duration should be 10 mins')]"));
  }

  public static Boolean SlotDurationAlertmessage() {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Min Slot duration should be 10 mins')]"))
        .isEmpty()) {
      // THEN CLICK ON THE SUBMIT BUTTON
      return true;

    } else {

      return false;

      // DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
    }
  }

  public static WebElement ToTimeAlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Slot End Time cannot be less than or equal to slot Start time')]"));
  }

  public static Boolean ToTimeAlertmessage() {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Slot End Time cannot be less than or equal to slot Start time')]"))
        .isEmpty()) {
      // THEN CLICK ON THE SUBMIT BUTTON
      return true;

    } else {

      return false;

      // DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
    }
  }

  public static WebElement FromDateAlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Date should not be before minimal date')]"));
  }

  public static Boolean FromDateAlertmessage() {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Date should not be before minimal date')]"))
        .isEmpty()) {
      // THEN CLICK ON THE SUBMIT BUTTON
      return true;

    } else {

      return false;

      // DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
    }
  }

  public static WebElement ToDateAlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Date should not be before minimal date')]"));
  }

  public static Boolean ToDateAlertmessage() {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Date should not be before minimal date')]"))
        .isEmpty()) {
      // THEN CLICK ON THE SUBMIT BUTTON
      return true;

    } else {

      return false;

      // DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
    }
  }

  public static WebElement FromTimeAlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Slot End Time cannot be less than or equal to slot Start time')]"));
  }

  public static Boolean FromTimeAlertmessage() {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Slot End Time cannot be less than or equal to slot Start time')]"))
        .isEmpty()) {
      // THEN CLICK ON THE SUBMIT BUTTON
      return true;

    } else {

      return false;

      // DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
    }
  }

  public static WebElement SlotTypeAlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-marginDense') and contains (text(),'Slot Type is required')]"));
  }

  public static Boolean SlotTypeAlertmessage() {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-marginDense') and contains (text(),'Slot Type is required')]"))
        .isEmpty()) {
      // THEN CLICK ON THE SUBMIT BUTTON
      return true;

    } else {

      return false;

      // DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
    }
  }

  public static WebElement DoctorLocationAlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-marginDense') and contains (text(),'Please select a location for Visit')]"));
  }

  public static Boolean DoctorLocationAlertmessage() {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-marginDense') and contains (text(),'Please select a location for Visit')]"))
        .isEmpty()) {
      // THEN CLICK ON THE SUBMIT BUTTON
      return true;

    } else {

      return false;

      // DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
    }
  }

  public static WebElement generateSlotButton() {
    return driver.findElement(By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[7]/div[2]/button/span[1]"));
  }
  
  public static Boolean generateSlotbutton() {
	    if (!driver
	        .findElements(
	            By.xpath(
	                "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[7]/div[2]/button/span[1]"))
	        .isEmpty()) {	      
	      return true;
	    } else {
	      return false;
	    }
	  }
  
  public static By BlockedSlots =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[3]/button");

  public static WebElement BlockedSlots() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[3]/button"));
  }

  public static By pastappointments =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[4]/button");

  public static WebElement pastappointments() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[4]/button"));
  }

  public static By upcomingappointments =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[1]/button");

  public static WebElement upcomingappointments() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[1]/button"));
  }

  public static By openSlots =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[2]/button/div");

  public static WebElement openSlots() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[2]/button/div"));
  }

  public static WebElement AlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div[2]/div/div[2]/b"));
  }
  
  public static Boolean Alertmessage() {
	    if (!driver
	        .findElements(
	            By.xpath(
	                "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div[2]/div/div[2]/b"))
	        .isEmpty()) {	      
	      return true;
	    } else {
	      return false;
	    }
	  }
  
  public static WebElement DisableGenerateSlotsButton() {
	  return driver.findElement(By.xpath("//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[7]/div[2]"));
  }
  
}
