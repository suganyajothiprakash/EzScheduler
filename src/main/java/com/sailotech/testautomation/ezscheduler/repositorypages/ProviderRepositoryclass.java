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

public class ProviderRepositoryclass {

  WebDriver driver;

  public ProviderRepositoryclass(WebDriver d) {
    this.driver = d;

    PageFactory.initElements(d, this);
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
  
  @FindBy(xpath="//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-marginDense') and contains (text(),'Please select a location for Visit')]")
  public WebElement DoctorLocationAlertMessage;
  
  @FindBy(xpath="//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-marginDense') and contains (text(),'Slot Type is required')]")
  public WebElement SlotTypeAlertMessage;
  
  @FindBy(xpath="//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Slot End Time cannot be less than or equal to slot Start time')]")
  public WebElement FromTimeAlertMessage;
  
  @FindBy(xpath="//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Date should not be before minimal date')]")
  public WebElement FromDateAlertMessage; 

  @FindBy(xpath="//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Date should not be before minimal date')]")
  public WebElement ToDateAlertMessage;
  
  @FindBy(xpath="//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Slot End Time cannot be less than or equal to slot Start time')]")
  public WebElement ToTimeAlertmessage;
  
  @FindBy(xpath="//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Min Slot duration should be 10 mins')]")
  public WebElement SlotDurationAlertmessage;
  
  @FindBy(xpath="//*[starts-with(@class,'MuiFormHelperText-root MuiFormHelperText-contained Mui-error MuiFormHelperText-filled Mui-required MuiFormHelperText-marginDense') and contains (text(),'Fee should be numeric  (in Rupees.)')]")
  public WebElement ConsultationFeeAlertMessage;

  public WebElement monthCheckText(String month) {
    return driver.findElement(By.xpath("//div/div/p"));
  }

  @FindBy(
      xpath = "//*[@id='body']/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[1]/span[1]")
  public WebElement PreviousArrowbtn;

  @FindBy(xpath = "//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/div[1]")
  public WebElement DoctorName;

  @FindBy(
      xpath =
          "//button[starts-with(@class,'MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton')]")
  public WebElement NextArrowButton;

  @FindBy(
      xpath =
          "//button[starts-with(@class,'MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton')]")
  public WebElement PreviousArrowButton;

  @FindBy(xpath = "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/p/a")
  public WebElement clickheretoSignIn;

  
  @FindBy(
      xpath = "//*[@id='body']/div[3]/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/button[2]/span[1]")
  public WebElement NextArrowBtn;

  @FindBy(
      xpath =
          "//button[starts-with(@class,'MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton')]")
  public WebElement ArrowButton;

  @FindBy(xpath = "//*[starts-with(text(),'Login/Register')]")
  public WebElement HomeLoginRegister;

  @FindBy(xpath = "//*[contains(text(),'Logout')]")
  public WebElement Doctorlogout;

  @FindBy(
      xpath =
          "//span[starts-with(@class,'MuiChip-label MuiChip-labelSmall') and contains(text(),'Block All')]")
  public WebElement BlockAll;

  @FindBy(xpath = "//span[starts-with(@class,'MuiButton-label') and contains(text(),'Yes')]")
  public WebElement YesCancelAll;

  @FindBy(xpath = "//input[@id='cancel']")
  public WebElement ReasonForCancel;

  @FindBy(
      xpath = "//span[starts-with(@class,'MuiButton-label') and contains(text(),'Yes , Cancel')]")
  public WebElement YESCANCEL;
  
  @FindBy(xpath = "//span[contains(text(),'Male')]")
 	public WebElement  RegistrationGendermale;
   
   @FindBy(xpath = "//span[contains(text(),'Female')]")
	public WebElement  RegistrationGenderfemale;

  @FindBy(
      xpath =
          "//header/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/h5[1]/a[1]")
  public WebElement DoctorLoginButton;

  @FindBy(xpath = "//span[contains(text(),'Sign-In')]")
  public WebElement DoctorSigin;

  @FindBy(xpath = "//span[starts-with(@class,'nav-text') and contains (text(),'Generate Slots')]")
  public WebElement Generateslots;
  // *[@id="body"]/div[3]/div[3]/div[3]/div[1]/nav/div[3]/a/span

  @FindBy(xpath = "//*[contains(text(),'Slot Type')]")
  public WebElement SlotType;
//*[contains(@name,'consultType')]
  @FindBy(name = "facility")
  public WebElement Doctorlocations;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div[2]/div/div[2]/b")
  public WebElement Alertmessage;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
  public WebElement DoctorUsername;

  @FindBy(xpath = "//*[contains(text(),'My Schedule')]")
  public WebElement Myschedule1;
  // *[@id="body"]/div[3]/div[3]/div[3]/div[1]/nav/div[1]/a

  @FindBy(
      xpath =
          "//div[starts-with(@class,''MuiCardContent-root myschedule-card myschedule-card-highlight)]")
  public WebElement upcomingappointmentscount;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[1]/button")
  public WebElement upcomingappointments;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[4]/button")
  public WebElement pastappointments;

  @FindBy(
      xpath =
          "//div[starts-with(@class,''MuiCardContent-root myschedule-card myschedule-card-highlight)]")
  public WebElement pastappointmentscount;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[3]/button")
  public WebElement BlockedSlots;

  @FindBy(
      xpath =
          "//div[starts-with(@class,''MuiCardContent-root myschedule-card myschedule-card-highlight)]")
  public WebElement Blockedcount;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[3]/div[2]/button/div")
  public WebElement openSlots;

  @FindBy(
      xpath =
          "//div[starts-with(@class,''MuiCardContent-root myschedule-card myschedule-card-highlight)]")
  public WebElement openslotscount;

  @FindBy(
      xpath =
          "span[starts-with(@class,'MuiChip-label MuiChip-labelSmall') and contains(text(),'View All')]")
  public WebElement Viewall;

  @FindBy(xpath = "span[starts-with(@class,'nav-text') and contains(text(),'Logout')]")
  public WebElement Logout;

  @FindBy(name = "password")
  public WebElement Doctorpassword;

  @FindBy(xpath = "//*[name()='path' and contains(@d,'M10.09 15.')]")
  public WebElement loginArrow;

  @FindBy(xpath = "//*[contains(text(),'')]")
  public WebElement doctorName;

  @FindBy(
      xpath =
          "//body[@id='body']/div[@id='app-site']/div/div/div/div/header/div/div[1]//*[local-name()='svg']")
  public WebElement DoctorMenu;

  @FindBy(xpath = "//div[contains(@class,'scrollbar')]//div[3]//a[1]")
  public WebElement generateSlotsMenu;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div/div[1]/div[1]/div/div/div")
  public WebElement AllLocations;

  @FindBy(xpath = "//svg(@class,'MuiSvgIcon-root')")
  public WebElement Alllocationsdropdown;

  @FindBy(
      xpath =
          "//button[starts-with(@class,'fc-dayGridMonth-button fc-button fc-button-primary') and contains (text(),'Month')]")
  public WebElement monthorder1;

  @FindBy(
      xpath =
          "//button[starts-with(@class,'fc-dayGridMonth-button fc-button fc-button-primary') and contains (text(),'Week')]")
  public WebElement weekorder1;

  @FindBy(
      xpath =
          "//button[starts-with(@class,'fc-dayGridMonth-button fc-button fc-button-primary') and contains (text(),'Day')]")
  public WebElement Dayorder;

  @FindBy(
      xpath =
          "//button[starts-with(@class,'fc-dayGridMonth-button fc-button fc-button-primary') and contains (text(),'List')]")
  public WebElement ListOrder;

  @FindBy(xpath = "span[starts-with(@class,'fc-icon fc-icon-chevron-right')]")
  public WebElement nextarrowbutton;

  @FindBy(xpath = "span[starts-with(@class,'fc-icon fc-icon-chevron-left')]")
  public WebElement leftarrowbutton;

  @FindBy(name = "facility")
  public WebElement location;

  @FindBy(xpath = "//input[@id='mui-32785']")
  public WebElement selectedlocation;

  @FindBy(xpath = "//*[contains(@name,'consultType') and contains(@value,'Video')]")
  public WebElement videoSlotType;

  @FindBy(xpath = "//*[contains(@name,'video') and contains(@value,'At Office')]")
  public WebElement atOfficeSlotType;

  @FindBy(name = "fromDate")
  public WebElement fromDate;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[2]/div[3]/div/div/input")
  public WebElement toDate;
  //// *[contains(text(),'To Date') and contains(name(),'fromDate')]

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[3]/div[2]/div/div/input")
  public WebElement fromTime;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[3]/div[3]/div/div/input")
  public WebElement toTime;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[5]/div[2]/div/div/input")
  public WebElement slotduration;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'1')]")
  public WebElement oneClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'2')]")
  public WebElement twoClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'3')]")
  public WebElement threeClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'4')]")
  public WebElement fourClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'5')]")
  public WebElement fiveClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'6')]")
  public WebElement sixClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'7')]")
  public WebElement sevenClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'8')]")
  public WebElement eightClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'9')]")
  public WebElement nineClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'10')]")
  public WebElement tenClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'11')]")
  public WebElement elevenClk;

  @FindBy(
      xpath =
          "//[contains(@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1') and contains(text(),'12')]")
  public WebElement twelveClk;

  @FindBy(xpath = "//*[contains(text(),'00')]")
  public WebElement zeroMin;

  @FindBy(xpath = "//*[contains(text(),'05')]")
  public WebElement fiveMin;

  @FindBy(xpath = "//*[contains(text(),'10')]")
  public WebElement tenMin;

  @FindBy(xpath = "//*[contains(text(),'15')]")
  public WebElement fifteenMin;

  @FindBy(xpath = "//*[contains(text(),'20')]")
  public WebElement twentyMin;

  @FindBy(xpath = "//*[contains(text(),'25')]")
  public WebElement twentyfiveMin;

  @FindBy(xpath = "//*[contains(text(),'30')]")
  public WebElement thirtyMin;

  @FindBy(xpath = "//*[contains(text(),'35')]")
  public WebElement thirtyfievMin;

  @FindBy(xpath = "//*[contains(text(),'40')]")
  public WebElement fourtyMin;

  @FindBy(xpath = "//*[contains(text(),'45')]")
  public WebElement fourtyfiveMin;

  @FindBy(xpath = "//*[contains(text(),'50')]")
  public WebElement fiftyMin;

  @FindBy(xpath = "//*[contains(text(),'55')]")
  public WebElement fiftyfiveMin;

  @FindBy(xpath = "//h6[contains(text(),'AM')]")
  public WebElement amAMorPM;

  @FindBy(xpath = "//h6[contains(text(),'PM')]")
  public WebElement pmAMorPM;

  @FindBy(xpath = "//*[contains(text(),'Mon')]")
  public WebElement Monday;

  @FindBy(xpath = "//*[contains(text(),'Tue')]")
  public WebElement Tuesday;

  @FindBy(xpath = "//*[contains(text(),'Wed')]")
  public WebElement Wednesday;

  @FindBy(xpath = "//*[contains(text(),'Thu')]")
  public WebElement Thursday;

  @FindBy(xpath = "//*[contains(text(),'Fri')]")
  public WebElement Friday;

  @FindBy(xpath = "//*[contains(text(),'Sat')]")
  public WebElement Saturday;

  @FindBy(xpath = "//*[contains(text(),'Sun')]")
  public WebElement Sunday;

  @FindBy(xpath = "//*[contains(text(),'Daily')]")
  public WebElement Daily;

  @FindBy(name = "slotTime")
  public WebElement slotTime;

  @FindBy(name = "price")
  public WebElement consultationFee;

  @FindBy(linkText = "1")
  public WebElement Dateone;

  @FindBy(linkText = "2")
  public WebElement Datetwo;

  @FindBy(linkText = "3")
  public WebElement DateThree;

  @FindBy(linkText = "4")
  public WebElement DateFour;

  @FindBy(linkText = "5")
  public WebElement DateFive;

  @FindBy(linkText = "6")
  public WebElement DateSix;

  @FindBy(linkText = "7")
  public WebElement DateSeven;

  @FindBy(linkText = "8")
  public WebElement DateEight;

  @FindBy(linkText = "9")
  public WebElement DateNine;

  @FindBy(linkText = "10")
  public WebElement DateTen;

  @FindBy(linkText = "11")
  public WebElement DateEleven;

  @FindBy(linkText = "12")
  public WebElement DateTweleve;

  @FindBy(linkText = "13")
  public WebElement DateThirteen;

  @FindBy(linkText = "14")
  public WebElement DateFourteen;

  @FindBy(linkText = "15")
  public WebElement DateFifteen;

  @FindBy(linkText = "16")
  public WebElement DateSixteen;

  @FindBy(linkText = "17")
  public WebElement DateSeventeen;

  @FindBy(linkText = "18")
  public WebElement DateEighteen;

  @FindBy(linkText = "19")
  public WebElement DateNineteen;

  @FindBy(linkText = "20")
  public WebElement DateTwenty;

  @FindBy(linkText = "21")
  public WebElement DateTwentyone;

  @FindBy(linkText = "22")
  public WebElement DateTwentytwo;

  @FindBy(linkText = "23")
  public WebElement DateTwentythree;

  @FindBy(linkText = "24")
  public WebElement DateTwentyFour;

  @FindBy(linkText = "25")
  public WebElement DateTwentyFive;

  @FindBy(linkText = "26")
  public WebElement DateTwentySix;

  @FindBy(linkText = "27")
  public WebElement DateTwentySeven;

  @FindBy(linkText = "28")
  public WebElement DateTwentyEight;

  @FindBy(linkText = "29")
  public WebElement DateTwentyNine;

  @FindBy(linkText = "30")
  public WebElement DateThirty;

  @FindBy(linkText = "31")
  public WebElement DateThirtyone;

  @FindBy(
      xpath =
          "h2[starts-with(@class,'fc-toolbar-title') and contains (text(),'Sun, Nov 01 – Mon, Nov 30')]")
  public WebElement NovemberMonth;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[7]/div[2]/button/span[1]")
  public WebElement generateSlotButton;

  // span[starts-with(@class,'MuiButton-label') and contains (text(),'Generate Slots')]
  // *[@id=\"app-site\"]/div/div/div[3]/main/div/div/div[1]/div/div/div/div[2]/form/div/div[7]/div[2]/button/span[1]

  @FindBy(xpath = "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[114]")
  public WebElement ExperienceYear1;

  public WebElement ExperienceYear(int div) {
    return driver.findElement(
        By.xpath("//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[" + div + "]"));
  }

  public WebElement ExpDate(int row, int col) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div["
                + row
                + "]/div["
                + col
                + "]/button/span[1]/p"));
  }

  @FindBy(
      xpath =
          "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[3]/div[5]/button/span[1]/p")
  public WebElement ExperienceDate;

  public WebElement ExperienceDate(int div) {
    return driver.findElement(
        By.xpath(
            "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[3]/div["
                + div
                + "]/button/span[1]/p"));
  }

  // return
  // driver.findElement(By.xpath("//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[1]/div["+ div +"]/button/span[1]/p"));
  @FindBy(xpath = "//span[@class='app-notification-menu']")
  public WebElement HomeLoginRegisterLink; //

  @FindBy(xpath = "//h5[contains(text(),'Doctor')]")
  public WebElement DoctorLogin;

  @FindBy(xpath = "//*[@id=\"body\"]/div[3]/div[3]/div/div[1]/div/div[2]/div/div[106]")
  WebElement y2004;

  @FindBy(xpath = "//input[@name='email']")
  public WebElement DoctorUserName;

  @FindBy(xpath = "//input[@name='password']")
  public WebElement DoctorPassword;

  @FindBy(xpath = "//span[contains(text(),'Sign-In')]")
  public WebElement LoginButton;

  @FindBy(
      xpath =
          "//body[@id='body']/div[@id='app-site']/div/div/div/div/header/div/div[1]//*[local-name()='svg']")
  public WebElement Doctormenu;

  @FindBy(xpath = "//span[contains(text(),'Logout')]")
  public WebElement Doclogout;

  @FindBy(xpath = "//span[@class='nav-text'][contains(text(),'Generate Slots')]")
  public WebElement GenerateSlots;

  @FindBy(
      xpath =
          "//body//div//div//div//div//div//div//div//div//div//div//div//div[2]//div[2]//div[1]//div[1]//input[1]")
  public WebElement fromdate;

  @FindBy(
      xpath =
          "//div//div//div//div//div//div//div//div//div//div//div//div[2]//div[3]//div[1]//div[1]//input[1]")
  public WebElement Todate;

  @FindBy(xpath = "//a[@class='app-logo mr-2 d-none d-sm-block col-sm-12 col-md-6']//img")
  public WebElement Image;

  @FindBy(xpath = "//span[contains(text(),'My Schedule')]")
  public WebElement Myschedule;

  @FindBy(xpath = "//a[contains(text(),'Click here to SignIn')]")
  public WebElement signinlink;

  @FindBy(xpath = "//li[3]//div[1]//h5[1]//a[1]")
  public WebElement Adminlogin1;

  @FindBy(xpath = "//span[contains(text(),'UnVerified Doctors')]")
  public WebElement unverifiedDoctors;

  @FindBy(xpath = "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]")
  public WebElement adminscrolldown;

  @FindBy(xpath = "//div[starts-with(@class,'user-name')]")
  public WebElement sugi;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div/div[2]/div/div/div[2]/div/div/table/tbody/tr[42]/td[7]/a[1]/button/svg/path")
  public WebElement unverifiedEditopt;

  @FindBy(xpath = "//span[contains(text(),'Save Profile')]")
  public WebElement saveprofile;

  @FindBy(xpath = "//header/div[1]/div[1]/*[1]")
  public WebElement Adminmenu;

  @FindBy(xpath = "//body/div[3]/div[3]/div[3]/div[1]/nav[1]/div[3]/a[1]")
  public WebElement AdminLogout;

  /* @FindBy(
      xpath =
          "//span[starts-with(@class,'app-notification-menu') and contains(text(),'Login/Register')]")
  public WebElement Homeloginregister;*/

  @FindBy(xpath = "//h3[contains(text(),'Doctors Queue')]")
  public WebElement Doctorqueue;

  @FindBy(xpath = "//input[@placeholder='Username']")
  public WebElement Adminusername;

  @FindBy(xpath = "//input[@placeholder='Password']")
  public WebElement Adminpassword;

  @FindBy(xpath = "//span[contains(text(),'Sign In')]")
  public WebElement Signin;

  @FindBy(xpath = "//div[contains(text(),'Phone Number Already used, please try to login wit')]")
  public WebElement phonenumberalertmsg;

  @FindBy(xpath = "//div//div//div//div//div//div//div//div//div//div//div//div[2]//div[1]//div[2]")
  public WebElement slotswithgivencombinationalreadyexists;

  @FindBy(xpath = "//body/div/div/div/div/main/div/div/div/div/div/div/div/form/div[2]/div[1]")
  public WebElement slotsgeneratesuccessfully;

  @FindBy(xpath = "//b[contains(text(),'No slots created with given Combination.Please che')]")
  public WebElement noslotscreatedwithgivencombinationpleasecheck;

  @FindBy(xpath = "//button[contains(text(),'Month')]")
  public WebElement monthorder;

  @FindBy(xpath = "//button[contains(text(),'Week')]")
  public WebElement weekorder;

  @FindBy(xpath = "//button[contains(text(),'Day')]")
  public WebElement dayorder;

  @FindBy(xpath = "//button[contains(text(),'List')]")
  public WebElement Listorder;
  // body//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[3]//div[1]//div[1]//div[2]//span[2]//span[1]
  // @FindBy(xpath = "//h6[contains(text(),'Upcoming Appointments')]")
  // public WebElement upcomingappointments;

  // @FindBy(xpath = "//div[@class='MuiCardContent-root myschedule-card
  // myschedule-card-highlight']")
  // public WebElement upcomingappointmentscount;

  @FindBy(
      xpath =
          "//body[@id='body']/div[@id='app-site']/div/div/div/main/div/div/div/div/div/div/div/div/div/span[1]")
  public WebElement viewall;

  @FindBy(
      xpath =
          "//body[@id='body']/div[@id='app-site']/div/div/div/main/div/div/div/div/div/div/div/div/div/div/b[1]")
  public WebElement viewcalendaricon;

  @FindBy(xpath = "//h6[contains(text(),'Open Slots')]")
  public WebElement openslots;

  @FindBy(xpath = "//div[@class='MuiCardContent-root myschedule-card myschedule-card-highlight']")
  public WebElement openslotcount;

  @FindBy(xpath = "//body/div/div/div/div/main/div/div/div/div/div/div/div/div/button[1]")
  public WebElement searchbutton;

  @FindBy(xpath = "//h6[contains(text(),'Blocked')]")
  public WebElement Blockledslots;

  @FindBy(xpath = "//div[@class='MuiCardContent-root myschedule-card myschedule-card-highlight']")
  public WebElement blockedslotscount;

  // @FindBy(xpath = "//h6[contains(text(),'Past Appointments')]")
  // public WebElement pastappointments;

  // @FindBy(xpath = "//div[@class='MuiCardContent-root myschedule-card
  // myschedule-card-highlight']")
  // public WebElement pastappointmentscount;

  @FindBy(xpath = "//b[contains(text(),'Sep 06 - Sep 12')]")
  public WebElement calendar;

  @FindBy(
      xpath =
          "//body/div/div/div/div/main/div/div/div/div/div/div/div/div/div/div/div/div/div/button[2]/span[1]")
  public WebElement Nextarrowbotton;

  @FindBy(
      xpath =
          "//body/div/div/div/div/main/div/div/div/div/div/div/div/div/div/div/div/div/div/button[1]/span[1]")
  public WebElement previousarrowbutton;

  @FindBy(
      xpath =
          "//body/div/div/div/div/main/div/div/div/div/div/div/div/div/div/div/div/div/div/button[1]/span[1]")
  public WebElement Alllocationonmyschedule;

  @FindBy(xpath = "//*[name()='path' and contains(@d,'M7 10l5 5 ')]")
  public WebElement allLocationdropdownmenu;

  @FindBy(xpath = "//label[1]//span[1]//span[1]//input[1]")
  public WebElement maleradiobutton;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/ul/li/div/div/div/div[1]/ul/li[2]/div/h5/a[2]")
  public WebElement Doctorregister;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
  public WebElement RegistrationDoctorname;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")
  public WebElement DocRegistrationDoctorEmail;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[1]")
  public WebElement DocRegistrationDoctormobilenumber;

  @FindBy(xpath = "//input[contains(@name,'specializations')]")
  public WebElement DocRegistrationSpecializedIn;

  @FindBy(
      xpath =
          "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[6]/div[1]/div[1]/input[1]")
  public WebElement degree;

  @FindBy(xpath = "//div[starts-with(@class,'MuiAutocomplete-endAdornment')]")
  public WebElement DoctorSpecialized;

  @FindBy(
      xpath =
          "//*[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiAutocomplete-input MuiAutocomplete-inputFocused MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd MuiInputBase-inputMarginDense MuiOutlinedInput-inputMarginDense')]")
  public WebElement Doctordegree;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[4]/label[1]/span[1]/span[1]/input[1]")
  public WebElement Doctorgendermalerb;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[4]/label[2]/span[1]/span[1]/input[1]")
  public WebElement Doctorgenderfemalerb;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/form[1]/div[7]/div[1]/input[1]")
  public WebElement RegistrationDoctorpracticestartdate;

  @FindBy(
      xpath =
          "//body/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[2]/span[1]/*[1])")
  public WebElement nextpracticearrowbutton;

  // @FindBy(xpath="//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[2]")
  // public WebElement Alertmessage;

  @FindBy(
      xpath =
          "//body/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/span[1]/*[1]")
  public WebElement backpracticearrowbutton;

  @FindBy(xpath = "//div[contains(text(),'2019')]")
  public WebElement year2019;

  @FindBy(xpath = "//body/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]/h6[1]")
  public WebElement Registrationyearselection;

  @FindBy(
      xpath =
          "//body/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/button[1]/span[1]/p[1]")
  public WebElement date3rd;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/button[1]/span[1]")
  public WebElement DoctorRegisterbutton;

  @FindBy(xpath = "//div[starts-with(@class,'shadow-lg alert alert-danger fade show')]")
  public WebElement DocRegistrationemailalert;

  public Boolean emailAlert() {
    if (!driver
        .findElements(
            By.xpath("//div[starts-with(@class,'shadow-lg alert alert-danger fade show')]"))
        .isEmpty()) {
      // THEN CLICK ON THE SUBMIT BUTTON
      return true;
    } else {

        return false;
    }}
    
      public Boolean DocRegistrationemailalert() {
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

  @FindBy(
      xpath =
          "//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//label[2]//span[1]//span[1]//input[1]")
  public WebElement femaleradiobutton;

  @FindBy(
      xpath =
          "//body//div//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[1]//textarea[1]")
  public WebElement Boardcertifications;

  @FindBy(
      xpath =
          "//body/div/div/div/div/main/div/div/div/fieldset/div/div/div/div/form/div/div/div/label[2]/span[1]/span[1]/input[1]")
  public WebElement videoconyesradiobutton;

  @FindBy(xpath = "//label[3]//span[1]//span[1]//input[1]")
  public WebElement videoconnoradiobutton;

  @FindBy(
      xpath =
          "//body/div/div/div/div/main/div/div/div/fieldset/div/div/div/div/form/div/div/div/textarea[1]")
  public WebElement about;

  @FindBy(xpath = "//div//div[2]//div[1]//div[1]//textarea[1]")
  public WebElement Awardsandrecognizations;

  /*
   * @FindBy(
   * xpath="driver.findElement(By.xpath(\"//div[@name='Location']//button[@class='MuiButtonBase-root MuiIconButton-root MuiAutocomplete-popupIndicator']//span[@class='MuiIconButton-label']//*[local-name()='svg']\"))"
   * ) WebElement Locations;
   *
   * @FindBy(
   * xpath="driver.findElement(By.xpath(\"//div[@name='Location']//button[@class='MuiButtonBase-root MuiIconButton-root MuiAutocomplete-popupIndicator']\"))"
   * ) WebElement WaterlooLocations;
   *
   * @FindBy(
   * xpath="driver.findElement(By.xpath(\"//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot Mui-error Mui-error MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd MuiInputBase-marginDense MuiOutlinedInput-marginDense']//div[@class='MuiAutocomplete-endAdornment']\"))"
   * ) WebElement SlotType;
   *
   * @FindBy(
   * xpath="driver.findElement(By.xpath(\"//div[@name='video']//fieldset[@class='jss83 MuiOutlinedInput-notchedOutline']\"))"
   * ) WebElement Video;
   *
   *
   */
  @FindBy(
      xpath =
          "//div[@class='app-main-container']//div[3]//div[2]//div[1]//div[1]//div[1]//button[1]//span[1]//*[local-name()='svg']")
  public WebElement Clock;

  @FindBy(
      xpath =
          "//div[@class='app-main-container']//div[3]//div[3]//div[1]//div[1]//div[1]//button[1]//span[1]//*[local-name()='svg']")
  public WebElement Clock1;

  @FindBy(xpath = "//span[contains(text(),'9')]")
  public WebElement nineoclk;

  @FindBy(xpath = "//span[contains(text(),'30')]")
  public WebElement thirtyminutes;

  @FindBy(xpath = "//h6[contains(text(),'AM')]")
  public WebElement am;

  @FindBy(xpath = "/html[1]/body[1]/div[3]/div[3]/div[1]/div[2]/button[2]/span[1]")
  // span[contains(text(),'OK')]
  public WebElement okbutton;

  @FindBy(xpath = "//span[contains(text(),'5')]")
  public WebElement fiveoclock;

  @FindBy(xpath = "//span[contains(text(),'00')]")
  public WebElement zerominutes;

  @FindBy(xpath = "//span[contains(text(),'9')]")
  public WebElement nineoclk1;

  @FindBy(xpath = "//body/div/div/div/div/div/div/div[2]/button[2]")
  public WebElement pm;

  @FindBy(xpath = "//span[contains(text(),'Mon')]")
  public WebElement monday;

  @FindBy(xpath = "//body[@id='body']/div/div/div/div/div/div/div/div/span[1]")
  public WebElement oneoclock;

  @FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[2]")
  public WebElement twooclock;

  @FindBy(xpath = "//span[contains(text(),'3')]")
  public WebElement threeoclock;

  @FindBy(xpath = "//span[contains(text(),'4')]")
  public WebElement fouroclock;

  @FindBy(xpath = "//span[contains(text(),'25')]")
  public WebElement twentyfiveminutes;

  @FindBy(xpath = "//span[contains(text(),'35')]")
  public WebElement thirtyFiveminutes;

  @FindBy(xpath = "//span[contains(text(),'40')]")
  public WebElement fourtyminutes;

  @FindBy(xpath = "//span[contains(text(),'45')]")
  public WebElement fourtyfiveminutes;

  @FindBy(xpath = "//span[contains(text(),'50')]")
  public WebElement fiftyminutes;

  @FindBy(xpath = "//span[contains(text(),'55')]")
  public WebElement fiftyfiveminutes;

  @FindBy(xpath = "//span[contains(text(),'6')]")
  public WebElement sixoclock;

  @FindBy(xpath = "//span[contains(text(),'7')]")
  public WebElement sevenoclock;

  @FindBy(xpath = "//span[contains(text(),'8')]")
  public WebElement eightoclock;

  @FindBy(xpath = "//body/div/div/div/div/div/div/div/div/span[10]")
  public WebElement tenoclock;

  @FindBy(xpath = "//span[contains(text(),'11')]")
  public WebElement elevenoclock;

  @FindBy(xpath = "//span[contains(text(),'12')]")
  public WebElement tweleveoclock;

  @FindBy(xpath = "//span[contains(text(),'05')]")
  public WebElement fiveMinutes;

  @FindBy(xpath = "//span[contains(text(),'10')]")
  public WebElement tenminutes;

  @FindBy(xpath = "//span[contains(text(),'15')]")
  public WebElement fifteenminutes;

  @FindBy(
      xpath =
          "//body[@id='body']//div//div//div//div//div//div//div//div//span[contains(text(),'20')]")
  public WebElement twentyminutes;

  @FindBy(xpath = "//span[contains(text(),'Tue')]")
  public WebElement tuesday;

  @FindBy(xpath = "//span[contains(text(),'Wed')]")
  public WebElement wednesday;

  @FindBy(xpath = "//span[contains(text(),'Thu')]")
  public WebElement thursday;

  @FindBy(xpath = "//span[contains(text(),'Fri')]")
  public WebElement friday;

  @FindBy(xpath = "//span[contains(text(),'Sat')]")
  public WebElement saturday;

  @FindBy(xpath = "//span[contains(text(),'Sun')]")
  public WebElement sunday;

  @FindBy(xpath = "//span[contains(text(),'Daily')]")
  public WebElement daily;

  @FindBy(xpath = "//span[contains(text(),'Generate Slots')]")
  public WebElement genslotbutton;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[2])")
  public WebElement alertmsg;

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
      //new PropertiesReaderUtility(user_dir + "\\selenium.properties");
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
