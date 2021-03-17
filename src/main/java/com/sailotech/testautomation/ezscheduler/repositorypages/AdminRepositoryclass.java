package com.sailotech.testautomation.ezscheduler.repositorypages;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sailotech.testautomation.ezscheduler.commonutilities.*;

public class AdminRepositoryclass {

  WebDriver driver;

  public AdminRepositoryclass(WebDriver d) {
    this.driver = d;
    PageFactory.initElements(d, this);
  }

  // *[@id="body"]/div[4]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[row]/div[1]/button/span[1]/p
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

  public boolean PracticemonthCheck(String month) {
    if (!driver
        .findElements(
            By.xpath(
                "//*[starts-with(@class,'MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter') and contains(text(),'"
                    + month
                    + "')]"))
        .isEmpty()) return true;
    else return false;
  }

  public WebElement practicemonthCheckText(String month) {
    return driver.findElement(By.xpath("//div/div/p"));
  }

  @FindBy(
      xpath =
          "//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]/span[1]")
  public WebElement NextArrowbutton;

  @FindBy(
      xpath =
          "//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[1]/span[1]")
  public WebElement previousArrowbutton;

  @FindBy(
      xpath =
          "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]/span[1]")
  public WebElement practiceNextArrowButton;

  @FindBy(
      xpath =
          "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[1]/span[1]")
  public WebElement practicepreviousArrowButton;

  /* public WebElement monthCheckText(String month) {

        return driver.findElement(
            By.xpath(
                "//*[starts-with(@class,'MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter') and contains(text(),'"
                    + month
                    + "')]"));
      }
  */

  public WebElement monthCheckText(String month) {
    return driver.findElement(By.xpath("//div/div/p"));
  }

  public WebElement Practicemonthcheck(String month) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]/span[1]"));
  }

  public WebElement monthCheckTextEnd(String month) {
    return driver.findElement(By.xpath("//div/div/p"));
  }

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tfoot/tr/td/div/div[3]/button[2]/span[2]")
  public WebElement VerifiedDoctorNextArrowButton;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tfoot/tr/td/div/div[3]/button[2]/span[1]")
  public WebElement UnVerifiedDoctorNextArrowButton;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tfoot/tr/td/div/div[3]/button[2]")
  public WebElement Nextarrowbutt;
  // "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tfoot/tr/td/div/div[3]/button[2]/span[1]/")

  @FindBy(xpath = "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[1]/button[1]/span[1]/h6")
  public WebElement years;

  @FindBy(xpath = "//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[1]/button[1]/span[1]/h6")
  public WebElement Practicestartyears;

  public WebElement ExperienceYear(int div) {
    return driver.findElement(
        By.xpath("//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[" + div + "]"));
  }

  public WebElement PracticeStartYearYear(int div) {
    return driver.findElement(
        By.xpath("//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[" + div + "]"));
  }

  @FindBy(xpath = "//div[4]/div[3]/div/div[1]/div/div[2]/div/div[123]")
  public WebElement PracticeSY;
  // *[@id="body"]/div[4]/div[3]/div/div[1]/div/div[2]/div/div[119]
  // *[@id="body"]/div[4]/div[3]/div/div[1]/div/div[1]/button[1]/span[1]/h6

  @FindBy(xpath = "//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[1]/button[1]/span[1]/h6")
  public WebElement Years;

  @FindBy(xpath = "//span[contains(text(),'Yes')]")
  public WebElement Videoconsultationyes;
  // /html/body/div[2]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[6]/div/div/label[2]/span[2]

  @FindBy(xpath = "//span[@class='app-notification-menu']")
  public WebElement HomeLoginregister;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[6]/div/div/label[3]/span[1]")
  public WebElement VideoconsultationNo;

  @FindBy(xpath = "//td[contains(text(),'thomase@gmail.com')]")
  public WebElement verifieddoctoremail;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[2]/div[2]/div/div/input")
  public WebElement VerifiedDoctorEmailID;

  @FindBy(xpath = "//div[1]/div/div/div/form/div[1]/div[3]/div/div/input")
  public WebElement VerifiedDoctorphoneNumber;

  @FindBy(xpath = "//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p")
  public WebElement monthchk;

  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[1]/td[3]

  public WebElement verifieddoctoremail(int row) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["
                + row
                + "]/td[3]"));
  }
  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr[1]/td[3]
  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr[1]/td[3]

  public WebElement unverifieddoctoremail(int row) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr["
                + row
                + "]/td[3]"));
  }

  public WebElement DoctorRow(int row) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr["
                + row
                + "]"));
  }

  public WebElement Doctorcolumn(int Col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[1]/td["
                + Col
                + "]"));
  }

  public WebElement UnverifiedDoctorData(int row, int col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr["
                + row
                + "]/td["
                + col
                + "]"));
  }

  public WebElement VerifiedDoctorData(int row, int col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["
                + row
                + "]/td["
                + col
                + "]"));
  }
  
 
  public WebElement AlertORPhysicianSavedMessage() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b"));
  }
  
//*[@id="app-site"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b
  public WebElement EmailAlertORPhysicianSavedMessage() {
	    return driver.findElement(
	        By.xpath(
	            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b"));
	  }
  
//*[@id="app-site"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]
  
  public WebElement PhoneNumberAlertORPhysicianSavedMessage() {
	    return driver.findElement(
	        By.xpath(
	            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]"));
	  }

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody")
  public WebElement UnverifiedTable;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody")
  public WebElement verifieddoctortable;

  // List<WebElement> elementName = driver.findElements(By.LocatorStrategy("LocatorValue"));
  // List<WebElement>verifieddoctortable1 =
  // driver.findElements(By.xpath("//*[@id=\\\"app-site\\\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody"));

  public WebElement unverifieddoctorEmail(int row) {
    return driver.findElement(By.xpath("//div[2]/div/div/table/tbody[1]/tr[" + row + "]/td[3]"));
  }

  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[2]/td[3]

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr[1]/td[7]/a[1]/button")
  public WebElement verifieddoctoreditoption1;

  /* public WebElement verifieddoctoreditoption(int row) {
  return driver.findElement(
      By.xpath(
          "//body/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["
              + row
              + "]/td[7]/a[1]/button[1]"));
   }*/
  // return
  // driver.findElement(By.xpath("//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["+ row +"]/td[7]/a[1]/button"));
  // body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]/button[1]

  public WebElement unverifieddoctorEditOption(int row) {
    return driver.findElement(
        By.xpath(
            "//body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr["
                + row
                + "]/td[7]/a[1]/button[1]"));
  }

  // *[@id="body"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[122]

  public boolean videovisitradiobuttonpresent() {

    if (!driver.findElements(By.xpath("//span[contains(text(),'Video')]")).isEmpty()) return true;
    else return false;
  }

  public WebElement TrialYear(int div) {
    return driver.findElement(
        By.xpath("//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[" + div + "]"));
  }

  // *[@id="body"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[3]/div[6]//date16

  @FindBy(
      xpath =
          "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[3]/div[5]/button/span[1]/p")
  public WebElement Traildate1;

  public WebElement TrialDate(int div) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[3]/div["
                + div
                + "]/button/span[1]/p"));
  }

  public WebElement TrialDate(int row, int col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div["
                + row
                + "]/div["
                + col
                + "]/button/span[1]/p"));
  }

  public WebElement TrialDate1(int row, int col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div["
                + row
                + "]/div["
                + col
                + "]/button/span[1]/p"));
  }

  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr[129]/td[7]/a[2]/button/svg

  public WebElement DoctorEyebutton(int row) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["
                + row
                + "]/td[7]/a[2]/button/svg"));
  }

  public WebElement verifieddoctoreditoption(int row) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr["
                + row
                + "]/td[7]/a[1]/button"));
  }
  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr[1]/td[7]/a[1]/button/svg
  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr[129]/td[7]/a[2]/button/svg/path")
  public WebElement DoctorEyeButton1;

  @FindBy(xpath = "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[1]/button[1]/span[1]/h6")
  WebElement year;

  @FindBy(xpath = "//li[3]//div[1]//h5[1]//a[1]")
  public WebElement Adminlogin;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[1]/div[3]/div/div/input")
  public WebElement VerDocphoneNumber;

  @FindBy(xpath = "//div[starts-with(@class,'MuiAlert-message')]")
  public WebElement VerDocEmailAlert;

  @FindBy(
      xpath =
          "//div[starts-with(@class,'MuiAlert-message') and contains (text(),'Physician Saved']")
  public WebElement VerDocPhoneNumberAlert;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div[2]/div/div[2]/b")
  public WebElement Alertmessage;

  // @FindBy(xpath="//h3[contains(text(),'Doctors Queue')]")
  // public WebElement Doctorqueue;

  @FindBy(xpath = "//input[@placeholder='Username']")
  public WebElement Adminusername;

  @FindBy(xpath = "//input[@placeholder='Password']")
  public WebElement Adminpassword;

  @FindBy(xpath = "//span[contains(text(),'Sign In')]")
  public WebElement AdminSignin;

  public WebElement AlertMessage() {
    return driver.findElement(By.xpath("//b[contains (text(),'Physician Saved')]"));
  }

  public WebElement PhoneNumberAlertMessage() {
    return driver.findElement(By.xpath("//b[contains (text(),'Phone Number already used')]"));
  }

  public WebElement EmailAlertMessage() {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div"));
  }

  @FindBy(xpath = "//b[contains (text(),'Physician Saved')]")
  public WebElement AlertMessage;

  @FindBy(xpath = "//span[@class='app-notification-menu']")
  public WebElement HomeLoginRegister;

  @FindBy(xpath = "//span[starts-with(@class,'nav-text') and contains (text(),'Patient Queue')]")
  public WebElement patientqueue;

  @FindBy(xpath = "//span[starts-with(@class,'nav-text') and contains (text(),'Doctor Queue')]")
  public WebElement DoctorQueue;

  @FindBy(xpath = "//span[contains(text(),'Invalid Credentials')]")
  public WebElement Invalidcredentials;

  @FindBy(xpath = "//span[contains(text(),'UnVerified Doctors')]")
  public WebElement unverifiedDoctors;

  @FindBy(xpath = "//span[contains(text(),'Verified Doctors')]")
  public WebElement verifieddoctors;

  @FindBy(xpath = "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]")
  public WebElement adminscrolldown;

  @FindBy(
      xpath =
          "//button[starts-with(@class,'MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton')]")
  public WebElement PreviousArrowButton;

  @FindBy(
      xpath = "//*[@id='body']/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]/span[1]")
  public WebElement NextArrowBtn;

  @FindBy(
      xpath = "//*[@id='body']/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[1]/span[1]")
  public WebElement PreviousArrowbtn;

  @FindBy(
      xpath =
          "//button[starts-with(@class,'MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton')]")
  public WebElement NextArrowButton;

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement january;
  // p[contains(text(),'January 2012')]

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement Febrauary;
  // p[contains(text(),'February 2012')]

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement March;
  // p[contains(text(),'March 2012')]

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement April;
  // p[contains(text(),'April 2012')]

  @FindBy(xpath = "//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/p[1]")
  public WebElement May;
  // p[contains(text(),'May 2012')]

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement june;
  // p[contains(text(),'June 2012')]

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement july;
  // p[contains(text(),'July 2012')]

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement August;
  // p[contains(text(),'August 2012')]

  @FindBy(xpath = "//p[contains(text(),'September 2011')]")
  public WebElement September;
  // p[contains(text(),'September 2012')]

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement October;
  // p[contains(text(),'October 2012')]

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement November;
  // p[contains(text(),'October 2012')]

  @FindBy(xpath = "//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
  public WebElement December;
  // p[contains(text(),'December 2012')]

  @FindBy(xpath = "//*[contains(@type,'button')]")
  public WebElement CreateDoctor;

  @FindBy(xpath = "//*[contains(@name,'mobileNo')]")
  public WebElement DoctorPhoneNumber;

  @FindBy(xpath = "//*[contains(@name,'email')]")
  public WebElement DoctorEmailAddress;

  @FindBy(xpath = "//*[contains(@name,'education')]")
  public WebElement DocDegree;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b")
  public WebElement Successfullmessage;
  
//*[@id="app-site"]/div/div/div[3]/main/div/div/div/fieldset/div[2]/div/div/div/div/div[2]/b

  @FindBy(
      xpath =
          "//*[@id=\\\"app-site\\\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[4]/div[2]/div/div/input")
  public WebElement PracticestartDate;

  @FindBy(xpath = "//*[contains(@name,'specializations')]")
  public WebElement DocSpecializations;

  @FindBy(xpath = "//*[contains(@name,'treatment')]")
  public WebElement DocConditionsTreated;

  @FindBy(xpath = "//*[contains(@name,'procedurePerformed')]")
  public WebElement DocProcedurePerformed;

  @FindBy(xpath = "//*[contains(@name,'LanguagesSpoken')]")
  public WebElement DocLanguages;

  @FindBy(xpath = "//*[contains(@name,'certifications')]")
  public WebElement DocBoardCertifications;

  @FindBy(xpath = "//*[contains(@name,'awards')]")
  public WebElement DocawardsandRecognitions;

  @FindBy(xpath = "//*[contains(@name,'price')]")
  public WebElement Docprice;

  @FindBy(
      xpath =
          "//[starts-with(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained jr-btn text-white doctor-onboarding-button MuiButton-containedPrimary'),(type='button')]")
  public WebElement DocSaveProfile;

  @FindBy(
      xpath =
          "//[starts-with(@class,'MuiTypography-root MuiFormControlLabel-label MuiTypography-body1'),(text(),'Male')]")
  public WebElement DocGenderMale;

  @FindBy(
      xpath =
          "//[starts-with(@class,'MuiTypography-root MuiFormControlLabel-label MuiTypography-body1'),(text(),'Female')]")
  public WebElement DocGenderFeMale;

  // [starts-with(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained jr-btn text-white
  // doctor-onboarding-button MuiButton-containedPrimary'),(type='button')]

  @FindBy(
      xpath =
          "//button[starts-with(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained jr-btn bg-green text-white')]")
  public WebElement Addlocation;
  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[2]/td[7]/a[1]/button/svg
  // @FindBy(xpath =

  @FindBy(
      xpath =
          "//span[starts-with(@class,'MuiTypography-root MuiFormControlLabel-label MuiTypography-body1') and contains (text(),'No')]")
  public WebElement verifydoctorNo;

  @FindBy(xpath = "//div[8]/div[1]/div[1]/label[2]/span[contains(text(),'Yes')]")
  public WebElement verifydoctorYes;
  // span[starts-with(@class,'MuiTypography-root MuiFormControlLabel-label MuiTypography-body1') and
  // contains(text(),'Yes')]
  // input[starts-with(@class,'jss81') and  contains(name()='adminVerified')]
  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[8]/div/div/label[2]/span[2]
  // /html/body/div[2]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[8]/div/div/label[2]/span[2]
  // span[contains(text(),'Yes')]
  // span[starts-with(@class,'MuiTypography-root MuiFormControlLabel-label MuiTypography-body1') and
  // div[8]/div[1]/div[1]/label[2]/span[contains(text(),'Yes')]
  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[8]/div/div/label[2]/span[1]/span[1]/input
  // "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[8]/div/div/label[2]/span[1]/span[1]/input")

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/button")
  public WebElement saveprofile;

  public boolean TrialYear1(int div) {
    if (!driver
        .findElements(
            By.xpath("//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[" + div + "]"))
        .isEmpty()) return true;
    else return false;
  }

  @FindBy(
      xpath =
          "//body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[1]/div[1]/input[1]")
  public WebElement TrialStartDate;

  public boolean TrialStartDate1() {
    if (!driver
        .findElements(
            By.xpath(
                "//body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[1]/div[1]/input[1]"))
        .isEmpty()) return true;
    else return false;
  }

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/fieldset/div[1]/div/div/div/form/div[9]/div[2]/div/div/input")
  public WebElement TrialEndDate;

  public WebElement ExpDate(int row, int col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div["
                + row
                + "]/div["
                + col
                + "]/button/span[1]/p"));
  }

  public WebElement PracticeStartDate(int row, int col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"body\"]/div[4]/div[3]/div/div[1]/div/div[2]/div[2]/div/div["
                + row
                + "]/div["
                + col
                + "]/button/span[1]"));
  }
  // *[@id="body"]/div[4]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[3]/div[7]/button/span[1]/p
  @FindBy(xpath = "//*[name()='trailEndDate']")
  public WebElement TrialEndDate1;

  @FindBy(xpath = "//span[contains(text(),'Logout')]")
  public WebElement Logout;

  @FindBy(xpath = "//*[name()='path' and contains(@d,'M3 18h18v-')]")
  public WebElement AdminMenu;
  // *[@id="app-site"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[2]/td[7]/a[1]/button/svg
  // @FindBy(xpath =
  // "//body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]/button[1]")
  // public WebElement unverifiedEditopt;

  private ScreenRecorder screenRecorder;

  public void startRecording() throws Exception {
    GraphicsConfiguration gc =
        GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .getDefaultConfiguration();
    this.screenRecorder =
        new ScreenRecorder(
            gc,
            new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
            new Format(
                MediaTypeKey,
                MediaType.VIDEO,
                EncodingKey,
                ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                CompressorNameKey,
                ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                DepthKey,
                24,
                FrameRateKey,
                Rational.valueOf(50),
                QualityKey,
                5.0f,
                KeyFrameIntervalKey,
                50 * 60),
            new Format(
                MediaTypeKey,
                MediaType.VIDEO,
                EncodingKey,
                "black",
                FrameRateKey,
                Rational.valueOf(30)),
            null);
    this.screenRecorder.start();
  }

  static String user_dir = System.getProperty("user.dir");
  protected static PropertiesReaderUtility prop =
      new PropertiesReaderUtility(user_dir + "//resources//selenium.properties");

  public void stopRecording() throws Exception {
    this.screenRecorder.stop();
  }

  public void SwitchTab() throws Exception {
    Actions act = new Actions(driver);
    {
      act.sendKeys(Keys.TAB).build().perform();
    }
  }
}

// @FindBy(xpath="//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div/table/tbody/tr[129]/td[7]/a[1]/button")
// public WebElement verifieddoctoreditoption1;

// @FindBy(xpath =
// "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[25]/td[3]")
// public WebElement VerifyDoctor1;

// @FindBy(xpath="//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[122]")
// public WebElement Trailyear1;

// @FindBy(xpath="//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[3]/div[5]/button/span[1]/p")
// public WebElement Traildate1;
