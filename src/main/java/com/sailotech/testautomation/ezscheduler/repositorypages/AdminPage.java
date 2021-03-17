package com.sailotech.testautomation.ezscheduler.repositorypages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;

public class AdminPage extends TestBase {

  public AdminPage(WebDriver d) {
    TestBase.driver = d;
    PageFactory.initElements(d, this);
  }
  
  public final static String ID = "id";
	public final static String NAME = "name";
	public final static String CLASSNAME = "classname";
	public final static String TAGNAME = "tagname";
	public final static String LINKTEXT = "linktext";
	public final static String PARTIALLINKTEXT = "partiallinktext";
	public final static String XPATH = "xpath";
	public final static String CSS = "css";
  public static String LOCTYPESTRING = "_locType";
  public static By Homeloginregister =
      By.xpath("//span[starts-with(@class,'app-notification-menu')]");

  public static By CreateDoctor = By.xpath("//*[contains(@type,'button')]");

  public static By DoctorPhoneNumber = By.xpath("//*[contains(@name,'mobileNo')]");

  public static By DoctorEmailAddress = By.xpath("//*[contains(@name,'email')]");

  public static By DocDegree = By.xpath("//*[contains(@name,'education')]");

  public static By DocSpecializations = By.xpath("//*[contains(@name,'specializations')]");

  public static By DocConditionsTreated = By.xpath("//*[contains(@name,'treatment')]");

  public static By DocProcedurePerformed = By.xpath("//*[contains(@name,'procedurePerformed')]");

  public static By DocLanguages = By.xpath("//*[contains(@name,'LanguagesSpoken')]");

  public static By DocBoardCertifications = By.xpath("//*[contains(@name,'certifications')]");

  public static By DocawardsandRecognitions = By.xpath("//*[contains(@name,'awards')]");

  public static By Docprice = By.xpath("//*[contains(@name,'price')]");

  public static By DocSaveProfile =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/div[3]/button[1]/span[1]");

  public static By DocGenderMale =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[2]/div[1]/div/div/label[1]/span[2]");

  public static By DocGenderFeMale =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[2]/div[1]/div/div/label[2]/span[2]");

  public static By DocVideoConsultationNo =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[6]/div[1]/div/label[3]/span[2]");

  public static By DocVideoConsultationyes =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[6]/div[1]/div/label[2]/span[2]");

  public static By Successfullmessage =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b");

  public static By PracticestartDate =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[4]/div[2]/div/div/input");

  public static By Alertessage = By.xpath("//b[contains (text(),'Physician Saved')]");

  public static By AddProviderLocation =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/div[2]/div/div/div[1]/button/span[1]");

  public static By FacilityName =
      By.xpath("//*[@id=\"body\"]/div[4]/div[3]/div/div[2]/div/div[1]/div/div/input");

  public static By AddALocation = By.xpath("//*[@id=\"mui-13450\"]");

  public static By SaveButton =
      By.xpath("//*[@id=\"body\"]/div[4]/div[3]/div/div[3]/button[2]/span[1]");

  public static By UnVerifiedDoctorNextArrowButton =
      By.xpath("//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[1]/button[1]/span[1]/h6");

  public static By Years =
      By.xpath("//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[1]/button[1]/span[1]/h6");

  public static By TrialYears =
      By.xpath("//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[1]/button[1]/span[1]/h6");

  public static By Videoconsultationyes =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[6]/div[1]/div/label[2]/span[2]");

  public static By HomeLoginregister = By.xpath("//span[@class='app-notification-menu']");

  public static By VideoconsultationNo =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[6]/div/div/label[3]/span[1]");

  public static By PracticeVideoconsultationYes =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[6]/div/div/label[2]/span[2]");

  public static By verifieddoctoremail = By.xpath("//td[contains(text(),'thomase@gmail.com')]");

  public static By practicepreviousArrowButton =
      By.xpath(
          "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[1]/span[1]");
  // *[@id="body"]/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]/span[1]/svg
  public static By practiceNextArrowButton =
      By.xpath(
          "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[1]/span[1]");

  public static By VerifiedDoctorNextArrowButton =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tfoot/tr/td/div/div[3]/button[2]/span[1]");

  public static By VerifiedDoctorEmailID =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[2]/div[2]/div/div/input");

  public static By VerifiedDoctorphoneNumber =
      By.xpath("//div[1]/div/div/div/form/div[1]/div[3]/div/div/input");

  public static By monthchk =
      By.xpath("//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p");

  public static By DoctorEyeButton =
      By.xpath(
          "//*[@id=\\\"app-site\\\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr[129]/td[7]/a[2]/button/svg/path");

  public static By year =
      By.xpath("//*[@id=\\\"body\\\"]/div[3]/div[3]/div/div[1]/div/div[1]/button[1]/span[1]/h6");

  public static By Adminlogin = By.xpath("//li[3]//div[1]//h5[1]//a[1]");

  public static By VerDocphoneNumber =
      By.xpath(
          "//*[@id=\\\"app-site\\\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[1]/div[3]/div/div/input");

  public WebElement VerDocEmailAlert =
      driver.findElement(By.xpath("//div[starts-with(@class,'MuiAlert-message')]"));

  public WebElement VerDocPhoneNumberAlert =
      driver.findElement(By.xpath("//div[starts-with(@class,'MuiAlert-message')]"));

  public static By Adminusername = By.xpath("//input[@placeholder='Username']");

  public static By Adminpassword = By.xpath("//input[@placeholder='Password']");

  public static By AdminSignin = By.xpath("//span[contains(text(),'Sign In')]");

  public WebElement AlertMessage =
      driver.findElement(By.xpath("//b[contains (text(),'Physician Saved')]"));

  public static By patientqueue =
      By.xpath("//span[starts-with(@class,'nav-text') and contains (text(),'Patient Queue')]");

  public static By DoctorQueue =
      By.xpath("//span[starts-with(@class,'nav-text') and contains (text(),'Doctor Queue')]");

  public static By Invalidcredentials = By.xpath("//span[contains(text(),'Invalid Credentials')]");

  public static By unverifiedDoctors = By.xpath("//span[contains(text(),'UnVerified Doctors')]");

  public static By verifieddoctors = By.xpath("//span[contains(text(),'Verified Doctors')]");

  public static By adminscrolldown =
      By.xpath("//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]");

  public static By PreviousArrowButton =
      By.xpath(
          "//button[starts-with(@class,'MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton')]");

  public static By NextArrowBtn =
      By.xpath(
          "//*[@id='body']/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]/span[1]");

  public static By PreviousArrowbtn =
      By.xpath(
          "//*[@id='body']/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[1]/span[1]");

  public static By NextArrowButton =
      By.xpath(
          "//button[starts-with(@class,'MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton')]");

  public static By january =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By Febrauary =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By March =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By April =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1" + "]");

  public static By May =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By June =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By July =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By August =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By september =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By october =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By November =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By December =
      By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]");

  public static By Addlocation =
      By.xpath(
          "//button[starts-with(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained jr-btn bg-green text-white')]");

  public static By verifydoctorNo =
      By.xpath(
          "//span[starts-with(@class,'MuiTypography-root MuiFormControlLabel-label MuiTypography-body1') and contains (text(),'No')]");

  public static By verifydoctorYes =
      By.xpath("//div[8]/div[1]/div[1]/label[2]/span[contains(text(),'Yes')]");

  public static By saveprofile =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/button");

  public static By TrialStartDate =
      By.xpath(
          "//body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[1]/div[1]/input[1]");

  public static By TrialEndDate =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[9]/div[2]/div/div/input");

  public static By TrialEndDate1 = By.xpath("//*[name()='trailEndDate']");

  public static By AdminLogout = By.xpath("//span[contains(text(),'Logout')]");

  public static By AdminMenu = By.xpath("//*[name()='path' and contains(@d,'M3 18h18v-')]");

  public static By AlertORPhysicianSavedMessag() {
    return By.xpath(
        "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b");
  }

  public static By PhoneNumberAlertMessage() {
    return By.xpath("//b[contains (text(),'Phone Number already used')]");
  }

  public static WebElement AlertORPhysicianSavedMessage() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b"));
  }

  public static WebElement PhoneNumberAlertORPhysicianSavedMessage() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]"));
  }

  public static WebElement EmailAlertORPhysicianSavedMessage() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b"));
  }

  public static WebElement AlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b"));
  }

  public static By EmailAlertMessage() {
    return By.xpath(
        "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div");
  }

  public boolean monthCheck(String month) {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter') and contains(text(),'"
                    + month
                    + "')]"))
        .isEmpty()) return true;
    else return false;
  }

  public static By verifieddoctoreditoption(int row) {
    return By.xpath(
        "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["
            + row
            + "]/td[7]/a[1]/button");
  }

  public static WebElement verifieddoctoreditoption1(int row) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["
                + row
                + "]/td[7]/a[1]/button"));
  }

  public WebElement unverifieddoctoremail(int row) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr["
                + row
                + "]/td[3]"));
  }

  public WebElement unverifieddoctorEmail(int row) {
    return driver.findElement(By.xpath("//div[2]/div/div/table/tbody[1]/tr[" + row + "]/td[3]"));
  }

  public static By unverifieddoctorEditOption(int row) {
    return By.xpath(
        "//body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr["
            + row
            + "]/td[7]/a[1]/button[1]");
  }

  public static By TrialYear(int div) {
    return By.xpath("//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[" + div + "]");
  }

  public static WebElement TrialDate1(int row, int col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div["
                + row
                + "]/div["
                + col
                + "]/button/span[1]/p"));
  }

  public static By TrialDate(int div) {
    return By.xpath(
        "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[3]/div["
            + div
            + "]/button/span[1]/p");
  }

  public static WebElement TrialDate(int row, int col) {
	    return driver.findElement(
	        By.xpath(
	            "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div["
	                + row
	                + "]/div["
	                + col
	                + "]/button/span[1]/p"));
	  }
  
 

  public static By DoctorEyebutton(int row) {
    return By.xpath(
        "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["
            + row
            + "]/td[7]/a[2]/button/svg");
  }

  public static By UnverifiedTable =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody");

  public static By verifieddoctortable() {
    return By.xpath(
        "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody");
  }

  public static WebElement UnverifiedDoctorData1(int row, int col) {
	    return driver.findElement(
	        By.xpath(
	            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr["
	                + row
	                + "]/td["
	                + col
	                + "]"));
	  }

  public static By monthCheckText(String month) {
    return (By.xpath("//div/div/p"));
  }

  public static By monthCheckTextEnd(String month) {
    return (By.xpath("//div/div/p"));
  }


  public static WebElement VerifiedDoctorData1(int row, int col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["
                + row
                + "]/td["
                + col
                + "]"));
  }
  
  public static Boolean ToDateAlertMessage() {
	    if (!driver
	        .findElements(
	            By.xpath("//div[starts-with(@class,'shadow-lg alert alert-danger fade show')]"))
	        .isEmpty()) {
	      // THEN CLICK ON THE SUBMIT BUTTON
	      return true;


} else {

return false;

// DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
}
}

  public static List<WebElement> UnverifiedTable() {
    return driver.findElements(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody"));
  }

  public static By DoctorName =
      By.xpath(
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]");
}
