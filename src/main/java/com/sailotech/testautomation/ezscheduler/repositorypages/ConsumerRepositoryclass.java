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
import java.util.List;
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

public class ConsumerRepositoryclass {

  WebDriver driver;

  public ConsumerRepositoryclass(WebDriver d) {
    this.driver = d;
    PageFactory.initElements(d, this);
  }

  @FindBy(xpath = "//span[@class='app-notification-menu']")
  public WebElement PLoginRegister1;

  @FindBy(xpath = "//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/div[1]")
  public WebElement PatientName;

  @FindBy(
      xpath =
          "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/header[1]/div[1]/div[1]/*[local-name()='svg'][1]")
  public WebElement patientmenu;

  @FindBy(
      xpath =
          "//div[@class='card product-item-vertical hoverable animation comp-bg flipInX']/div[@class='row d-flex align-items-start']/div[@class='doctor-list-wrapper col-xl-5 col-lg-5 col-md-5 col-12']/div[@class='card-body doctor-content']/div[8]")
  public List<WebElement> DoctorLocation;

  @FindBy(xpath = "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/div/div[1]/b")
  public WebElement AppScheduled;

  @FindBy(xpath = "//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/div[1]/svg")
  public WebElement PatientMenu;

  @FindBy(xpath = "//span[starts-with(@class,'nav-text') and contains(text(),'Logout')]")
  public WebElement PatientLogout;
  
  public WebElement slotBooking(int row, int div) {
    return driver.findElement(
        By.xpath("//*[@id=" + row + "]/div/div[3]/div/div/div[" + div + "]/span"));
  }

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/span")
  public WebElement moreslots;

  public WebElement moreslots(int row, int div) // more slots contains span
      {
    return driver.findElement(
        By.xpath(
            "//*[@id="
                + row
                + "]/div/div[3]/div/div/div["
                + div
                + "]/span/b[contains(text(),'More')]"));
  }

  // *[@id="0"]/div/div[3]/div/div/div[3]/span[5]//moreslots
  public boolean moreslotsPresent(int row, int div) // more slots contains span
      {
    if (!driver
        .findElements(
            By.xpath(
                "//*[@id="
                    + row
                    + "]/div/div[3]/div/div/div["
                    + div
                    + "]/span/b[contains(text(),'More')]"))
        .isEmpty()) return true;
    else return false;
  }

  public WebElement nextavailability(int row) {
    return driver.findElement(By.xpath("//*[@id=" + row + "]/div/div[3]/div/span/div"));
  }

  public boolean nextavailabilitypresent(int row) {

    if (!driver.findElements(By.xpath("//*[@id=" + row + "]/div/div[3]/div/span/div")).isEmpty())
      return true;
    else return false;
  }

  public boolean officevisitradiobuttonpresent() {

    if (!driver.findElements(By.xpath("//span[contains(text(),'Office Visit')]")).isEmpty())
      return true;
    else return false;
  }

  public boolean videovisitradiobuttonpresent() {

    if (!driver.findElements(By.xpath("//span[contains(text(),'Video')]")).isEmpty()) return true;
    else return false;
  }

  public WebElement NoSlotsAvailable(int row) {
    return driver.findElement(By.xpath("//*[@id=" + row + "]/div/div[3]/div/span/div"));
  }

  @FindBy(xpath = "//*[@id=\"3\"]/div/div[3]/div/span/div")
  public WebElement Noslotsava;

  @FindBy(xpath = "/*[@id=\"2\"]/div/div[3]/div/span/div/span")
  public WebElement nextslot;

  // *[@id="2"]/div/div[3]/div/span/div//next available slots
  // *[@id="2"]/div/div[3]/div/span/div/span
  // *[@id="1"]/div/div[3]/div/span/div

  // body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[6]/span[1]/b[1]/i[1]
  @FindBy(xpath = "//*[@id=\"0\"]/div/div[3]/div/div/div[6]/span/b/i")
  public WebElement nextarrow;

  public WebElement nextarrowbutton(int row) {

    return driver.findElement(By.xpath("//*[@id=" + row + "]/div/div[3]/div/div/div[6]/span/b/i"));
  }

  public boolean nextarrowbuttonPresent(int row) {

    if (!driver
        .findElements(By.xpath("//*[@id=" + row + "]/div/div[3]/div/div/div[6]/span/b/i"))
        .isEmpty()) return true;
    else return false;
    // return driver.findElement(By.xpath("//*[@id=" + row +
    // "]/div/div[3]/div/div/div[6]/span/b/i"));
  }
  // *[@id="2"]/div/div[3]/div/div/div[6]/span/b/i//next arrow button in slots
  // *[@id="2"]/div/div[3]/div/div/div[6]/span/b/i
  // *[@id="2"]/div/div[3]/div/div/div[6]/span/b/i

  @FindBy(
      xpath =
          "//div[@class='col-xl-5 col-lg-5 col-md-5 col-12 d-flex flex-row align-items-center justify-content-center']/div[@class='doctor-slots-wrapper d-flex flex-column']/div[@class='doctor-slots-wrapper d-flex flex-row']/div[@class='slots-nav mt-3']/div[@class='doctor-slots-day  align-items-center'/div[5]]")
  public List<WebElement> Slottimings;

  public WebElement slottime(int row, int div, int span) {

    return driver.findElement(
        By.xpath("//*[@id=" + row + "]/div/div[3]/div/div/div[" + div + "]/span[" + span + "]"));
  }

  public boolean slottimePresent(int row, int div, int span) {

    if (!driver
        .findElements(
            By.xpath("//*[@id=" + row + "]/div/div[3]/div/div/div[" + div + "]/span[" + span + "]"))
        .isEmpty()) return true;
    else return false;
  }

  // *[@id="0"]/div/div[3]/div/div/div[3]/span[5]

  public WebElement moretime(int row, int div, int span) {

    return driver.findElement(By.xpath("//*[@id=" + row + "]/div/div[3]/div/div/div[" + div + "]"));
  }

  @FindBy(xpath = "//h5[contains(text(),'Patient')]")
  public WebElement PatientLogin1;

  @FindBy(xpath = "//input[@name='email']")
  public WebElement PatientID;

  @FindBy(xpath = "//header/div[1]/div[1]/*[1]")
  public WebElement Patientmenu;

  @FindBy(xpath = "//span[contains(text(),'Home')]")
  public WebElement patientHome;

  @FindBy(xpath = "//span[starts-with(@class,'doctor-slots-items') and contains(text(),'More')]")
  public WebElement moreslotsbutton;
  
  @FindBy(xpath="//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[2]/button/span[1]")
  public WebElement VerifyOTP;
  
  @FindBy(xpath="//div[starts-with(@class,'MuiAlert-message')]")
  public WebElement InvalidOTP;
 // MuiAlert-message
  @FindBy(xpath = "span[starts-with(@class,'MuiTab-wrapper')]")
  public WebElement Allappointments;

  @FindBy(
      xpath =
          "div[starts-with(@class,'d-flex flex-row slot-navigation-empty justify-content-center align-items-center')]")
  public WebElement nextavailableslots;

  /*
   * @FindBy(
   * xpath="//div[@class='card product-item-vertical hoverable animation comp-bg flipInX']/div[@class='row d-flex align-items-start']/div[@class='doctor-list-wrapper col-xl-5 col-lg-5 col-md-5 col-12']/div[@class='card-body doctor-content']/div[8]"
   * ) public List<WebElement> DoctorLocation;
   */

  @FindBy(xpath = "//input[@name='password']")
  public WebElement PatientPassword1;

  @FindBy(
      xpath =
          "//span[starts-with(@class,'MuiTab-wrapper') and contains(text(),'All Appointments')]")
  public WebElement AllAppointments;

  @FindBy(xpath = "//span[starts-with(@class,'MuiTab-wrapper') and contains(text(),'In-person')]")
  public WebElement InPersonAppointments;
  
  

  @FindBy(
      xpath =
          "//button[starts-with(@class,'MuiButtonBase-root MuiTab-root MuiTab-textColorInherit customtab MuiTab-labelIcon')]")
  public WebElement videovisit;

  @FindBy(
      xpath =
          "//body//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[3]//div[1]//div[1]//div[2]//span[1]//div[1]//span[1])")
  public WebElement Thrusdayslots;

  @FindBy(
      xpath =
          "//body//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[3]//div[1]//div[1]//div[3]//span[1]//div[1]//span[1]")
  public WebElement Fridayslots;

  @FindBy(
      xpath =
          "//body//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[3]//div[1]//div[1]//div[4]//span[1]//div[1]//span[1]")
  public WebElement saturdayslots;

  @FindBy(
      xpath =
          "//body//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[3]//div[1]//div[1]//div[5]//span[1]//div[1]//span[1]")
  public WebElement sundayslots;

  @FindBy(xpath = "//*[name()='path' and contains(@d,'M10.09 15.')]")
  public WebElement Login;

  @FindBy(xpath = "//body/div/div/div/div/main/div/div/div/div/div/div/div/div/button[1]")
  public WebElement searchbutton;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div/div/input")
  public WebElement PatientOTP;

  @FindBy(
      xpath =
          "//body//div//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[1]//div[1]//div[1]//input[1]")
  public WebElement searchbydoctor;
  // body//div//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[1]//div[1]//div[1]//input[1]
  @FindBy(xpath = "//div//div[2]//div[1]//div[1]//div[1]//div[1]//input[1]")
  public WebElement searchbylocation;
  // div//div[2]//div[1]//div[1]//div[1]//div[1]//input[1]
  @FindBy(xpath = "//div[@name='slotsAvailable']//button[2]//span[1]//*[local-name()='svg']")
  public WebElement slotsavailabilitydropdown;

  @FindBy(
      xpath =
          "//div//div[2]//div[1]//div[1]//div[1]//div[1]//button[2]//span[1]//*[local-name()='svg']")
  public WebElement specialitiesdropdown;

  @FindBy(
      xpath =
          "//div[@name='selectedCondtionsTreated']//button[@class='MuiButtonBase-root MuiIconButton-root MuiAutocomplete-popupIndicator']//span[@class='MuiIconButton-label']//*[local-name()='svg']")
  public WebElement conditionsdropdown;

  @FindBy(
      xpath =
          "//div[@name='selectedLocation']//button[@class='MuiButtonBase-root MuiIconButton-root MuiAutocomplete-popupIndicator']//span[@class='MuiIconButton-label']//*[local-name()='svg']")
  public WebElement nearbydropdown;

  @FindBy(
      xpath =
          "//div[@name='selectedGender']//button[@class='MuiButtonBase-root MuiIconButton-root MuiAutocomplete-popupIndicator']//span[@class='MuiIconButton-label']//*[local-name()='svg']")
  public WebElement genderdropdown;

  @FindBy(
      xpath =
          "//div[@name='selectedLanguages']//button[@class='MuiButtonBase-root MuiIconButton-root MuiAutocomplete-popupIndicator']//span[@class='MuiIconButton-label']//*[local-name()='svg']//*[name()='path' and contains(@d,'M7 10l5 5 ')]")
  public WebElement languagesdropdown;

  @FindBy(
      xpath =
          "//body//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[3]//div[1]//div[1]//div[6]//span[1]//b[1]//i[1]")
  public WebElement nextweekslotsarrowbutton;

  @FindBy(
      xpath =
          "//body/div/div/div/div/main/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/input[1]")
  public WebElement specialities;

  @FindBy(xpath = "//input[@name='slotsAvailable']")
  public WebElement slotsavailability;

  @FindBy(
      xpath =
          "//div//div//div//div//div//div//div//div//div//div//div//div[3]//div[1]//div[1]//div[1]//input[1]")
  public WebElement conditions;

  @FindBy(xpath = "//div[4]//div[1]//div[1]//div[1]//input[1]")
  public WebElement nearby;

  @FindBy(xpath = "//div[6]//button[1]//span[1]")
  public WebElement clear;

  @FindBy(xpath = "//span[starts-with(@class ,'doctor-slots-items')]")
  public WebElement availslots;

  @FindBy(xpath = "/html/body/form")
  public WebElement successframe;

  @FindBy(xpath = "/html[1]/body[1]/div[1]/iframe[1]")
  public WebElement frame;

  @FindBy(
      xpath =
          "//input[starts-with(@class,'input svelte-43m0zu no-focus no-blur no-validate') and contains(@id,'card_number')]")
  public WebElement cardnumber;

  @FindBy(
      xpath =
          "//input[starts-with(@class,'input svelte-43m0zu no-focus no-blur no-validate') and contains(@id,'card_expiry')]")
  public WebElement expiry;

  @FindBy(
      xpath =
          "//input[starts-with(@class,'input svelte-43m0zu no-focus no-blur no-validate cvv-input') and contains(@id,'card_cvv')]")
  public WebElement cvv;

  @FindBy(xpath = "//div[contains(text(),'Instant payment using UPI App')]")
  public WebElement UPICARD;
  // div[starts-with(@slot,'subtitle') and contains (text(),'Google Pay, BHIM, PhonePe & more)]'
  // input[starts-with(@class,'input svelte-43m0zu') and contains (@id,'vpa-upi')]
  // *[@id=\"upi-collect-list\"]/button/div
  // *[@id="form-common"]/div[1]/div/div/div[2]/div[2]/div/button[2]/div/div/div[2]

  @FindBy(xpath = "//*[@id=\"top-left\"]/i")
  public WebElement UPIBack;

  // div[starts-with(@id,'tab-title') and contains(text(),'UPI')]

  @FindBy(xpath = "//span[starts-with(@id,'footer-cta') and contains (text(),'proceed')]")
  public WebElement proceed;

  @FindBy(xpath = "//*[starts-with(text(),'Skip saving card')]")
  public WebElement Skipcard;

  @FindBy(xpath = "//div[starts-with(@class,'svelte-ly2ugt') and contains(text(),'Netbanking')]")
  public WebElement netbanking;

  @FindBy(xpath = "//*[starts-with(text(),'SBI')]")
  public WebElement SBIBank;

  @FindBy(xpath = "//div[contains(text(),'HDFC')]")
  public WebElement HDFCBank;

  @FindBy(xpath = "//*[starts-with(text(),'ICICI')]")
  public WebElement ICCIBank;
  
  @FindBy(xpath="//*[starts-with(text(),'Yes')]")
  public WebElement YesBank;
  
  @FindBy(xpath="//*[starts-with(text(),'Kotak')]")
  public WebElement KotakBank; 
 
  @FindBy(xpath = "//*[starts-with(text(),'Axis')]")
  public WebElement AxisBank;

  @FindBy(xpath = "//div[contains(text(),'Netbanking - ICICI Bank')]")
  public WebElement netbankingICCIBank;

  @FindBy(xpath = "//div[contains(text(),'Netbanking - HDFC Bank')]")
  public WebElement netbankingHDFCBank;

  @FindBy(xpath = "//div[contains(text(),'Netbanking - State Bank of India')]")
  public WebElement netbankingSBIBank;
  
  @FindBy(xpath = "//*[contains(text(),'Visa, MasterCard, RuPay & More')]")
  public WebElement Card;
  //// *[contains(text(),'Visa, MasterCard, RuPay & More')]
  // *[@id=\"form-common\"]/div[1]/div/div/div[2]/div[2]/div/button[1]/div/div/div[2]
  // button[starts-with(@type,'button') and contains(@class,'new-method svelte-13rsokc')]

  @FindBy(xpath = "//label[@class, 'radio-label mfix']")
  public WebElement bank;
  // *[@id="bank-item-SBIN"]/label
  // label[starts-with(@class, 'radio-label mfix')]
  // div[starts-with(@class,'mchild item-inner svelte-xjs2xa')]

  @FindBy(xpath = "//button[contains(@class.'danger')]")
  public WebElement failurebutton;

  @FindBy(xpath = "//button[contains (@class,'success')]")
  public WebElement successbutton;

  // div[starts-with(@class,'d-flex flex-column flex-md-row col-md-12 col-sm-12
  // justify-content-center')]

  @FindBy(xpath = "//span[starts-with(@id,'footer-cta') and contains(text(),'Pay')]")
  public WebElement paybutton;

  /* /html/body/div[2]/div[3]/div/div[8]/div[2]/form/div[2]/span */
  // *[@id="form-common"]/div[1]/div/div/div[2]/div/div/button[3]/div
  // *[@id="footer-cta"]
  // *[starts-with(@id,'footer-cta')
  // button[starts-with(@id,'footer-cta' and contains(text(),'Pay')]

  @FindBy(xpath = "//span[starts-with(@id,'footer-cta')]")
  public WebElement paybutton1;
  // button[starts-with(@type,'button') and contains (@class,'hc_border svelte-aqbldb')]

  @FindBy(xpath = "//input[@name='selectedGender']")
  public WebElement gender;

  @FindBy(xpath = "//span[contains(text(),'Self')]")
  public WebElement selfradiobutton;

  @FindBy(xpath = "//span[contains(text(),'Others')]")
  public WebElement othersradiobutton;

  @FindBy(xpath = "//input[@id='relation']")
  public WebElement relationwithpatient;

  @FindBy(xpath = "//input[@placeholder='Name of Patient']")
  public WebElement nameofpatient;

  @FindBy(xpath = "//textarea[@placeholder='Reason cannot be more than 200 characters']")
  public WebElement reasonforvisit;

  @FindBy(
      xpath =
          "//body/div/div/div/div/main/div/div/div/div/div/div/div/div/div/div/div/label[1]/span[1]/span[1]/input[1]")
  public WebElement iagreeradiobutton;

  @FindBy(
      xpath =
          "//body[@id='body']/div[@id='app-site']/div/div/div/main/div/div/div/div/div/div/div/div/div/div/div/label[1]/span[1]/span[1]/input[1]")
  public WebElement idisgreeradiobutton;

  @FindBy(xpath = "//button[3]//span[1]")
  public WebElement confirmandpayaftervisit;

  @FindBy(xpath = "//button[2]//span[1]")
  public WebElement confirmandcontinueforpayment;

  @FindBy(xpath = "//input[@name='selectedLanguages']")
  public WebElement languages;

  @FindBy(xpath = "//span[contains(text(),'Office Visit')]")
  public WebElement officevisitradiobutton;

  @FindBy(xpath = "//span[contains(text(),'Video')]")
  public WebElement videovisitradiobutton;

  @FindBy(
      xpath =
          "//header/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/h5[1]/a[2]")
  public WebElement patientregister;

  @FindBy(xpath = "//span[@class='app-notification-menu']")
  public WebElement HomeLoginRegister;

  @FindBy(xpath = "//input[@name='password']")
  public WebElement PatientPassword;

  @FindBy(
      xpath =
          "//header/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/h5[1]/a[1]")
  public WebElement PatientLogin;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
  public WebElement PatientUserName;

  @FindBy(
      xpath =
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/fieldset[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
  public WebElement PatienPassword;

  @FindBy(xpath = "//span[contains(text(),'Sign-In')]")
  public WebElement PatientSignIn;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/ul/li/div/div/div/div[1]/ul/li[1]/div/h5/a[2]")
  public WebElement PatientRegister;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[1]/div/div/input")
  public WebElement patientName;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[2]/div/div/input")
  public WebElement PatientEmail;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[3]/div/div/input")
  public WebElement PatientMobilenumber;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[4]/div[1]/label[1]/span[2]")
  public WebElement Gendermale;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[4]/div[1]/label[2]/span[2]")
  public WebElement genderFemale;

  @FindBy(
      xpath =
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[2]/button/span[1]")
  public WebElement Registerbutton;

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
