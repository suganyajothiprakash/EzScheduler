package com.sailotech.testautomation.ezscheduler.repositorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;

public class ConsumerPage extends TestBase {

 // WebDriver driver;

  public ConsumerPage(WebDriver d) {
    this.driver = d;
    PageFactory.initElements(d, this);
  }

  public static By HomeLoginRegister = By.xpath("//span[@class='app-notification-menu']");
  
  public static By PatientLogin =
      By.xpath(
          "//header/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/h5[1]/a[1]");
  
  public static By PatientUserName =
      By.xpath(
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
  public static By PatienPassword =
      By.xpath(
          "//body/div[@id='app-site']/div[1]/div[1]/div[3]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/fieldset[1]/div[1]/div[2]/div[1]/div[1]/input[1]");
  public static By PatientSignIn = By.xpath("//span[contains(text(),'Sign-In')]");
  
  public static By patientmenu =
      By.xpath(
          "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/header[1]/div[1]/div[1]/*[local-name()='svg'][1]");
  
  public static By PatientLogout =
      By.xpath("//span[starts-with(@class,'nav-text') and contains(text(),'Logout')]");
  
  public static By PatientOTP =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div/div/input");
  
  public static By VerifyOTP =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[2]/button/span[1]");
  
  public static By patientregister =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/ul/li/div/div/div/div[1]/ul/li[1]/div/h5/a[2]");
  
  public static By patientName =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[1]/div/div/input");
  
  public static By PatientEmail =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[2]/div/div/input");
  
  public static By PatientMobilenumber =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[3]/div/div/input");
  public static By Gendermale =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[4]/div[1]/label[1]/span[2]");
  
  public static By genderFemale =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[1]/div[4]/div[1]/label[2]/span[2]");
  
  public static By gender = By.xpath("//input[@name='selectedGender']");
  
  public static By languages = By.xpath("//input[@name='selectedLanguages']");
  
  public static By Registerbutton =
      By.xpath(
          "//*[@id=\"app-site\"]/div/div/div[3]/main/div/div/div/div/div[2]/form/fieldset/div/div[2]/button/span[1]");
  
  public static By nearby = By.xpath("//div[4]//div[1]//div[1]//div[1]//input[1]");
  
 public static By conditions =By.xpath("//div//div//div//div//div//div//div//div//div//div//div//div[3]//div[1]//div[1]//div[1]//input[1]");
 
  public static By searchbydoctor =
      By.xpath(
          "//body//div//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[1]//div[1]//div[1]//input[1]");
  
  public static By searchbutton =
      By.xpath("//body/div/div/div/div/main/div/div/div/div/div/div/div/div/button[1]");
  
  public static By Patientmenu = By.xpath("//header/div[1]/div[1]/*[1]");
  
  public static By patientHome = By.xpath("//span[contains(text(),'Home')]");
  
  public static By searchbylocation =
      By.xpath("//div//div[2]//div[1]//div[1]//div[1]//div[1]//input[1]");
  
  public static By InPersonAppointments =
      By.xpath("//span[starts-with(@class,'MuiTab-wrapper') and contains(text(),'In-person')]");
  
  public static By videovisit =
      By.xpath( 
          "//header/div[1]/div[2]/div[1]/button[3]/span[1]");
  
  public static By AllAppointments =
      By.xpath(
          "//span[starts-with(@class,'MuiTab-wrapper') and contains(text(),'All Appointments')]");
  
  public static By slotsavailability = By.xpath("//input[@name='slotsAvailable']");
  
  public static By specialities = By.xpath("//body/div/div/div/div/main/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/input[1]");
  
  public static By PatientName() {
	  return By.xpath("//*[@id=\"app-site\"]/div/div/div[3]/div/header/div/div[1]");
  }
  
  public static By officevisitradiobutton = By.xpath("//span[contains(text(),'Office Visit')]");
  
  public static By videovisitradiobutton = By.xpath("//span[contains(text(),'Video')]");
  
  public static By selfradiobutton = By.xpath("//span[contains(text(),'Self')]");
  
  public static By othersradiobutton = By.xpath("//span[contains(text(),'Others')]");
  
  public static By relationwithpatient = By.xpath("//input[@id='relation']");
  
  public static By nameofpatient = By.xpath("//input[@placeholder='Name of Patient']");
  
  public static By reasonforvisit = By.xpath("//textarea[@placeholder='Reason cannot be more than 200 characters']");
  
  public static By iagreeradiobutton = By.xpath("//body/div/div/div/div/main/div/div/div/div/div/div/div/div/div/div/div/label[1]/span[1]/span[1]/input[1]");
  
  public static By idisgreeradiobutton = By.xpath("//body[@id='body']/div[@id='app-site']/div/div/div/main/div/div/div/div/div/div/div/div/div/div/div/label[1]/span[1]/span[1]/input[1]");

  public static By confirmandpayaftervisit = By.xpath("//button[3]//span[1]");
  
  public static By confirmandcontinueforpayment = By.xpath("//button[2]//span[1]");
  
  public static By cardnumber = By.xpath("//input[starts-with(@class,'input svelte-43m0zu no-focus no-blur no-validate') and contains(@id,'card_number')]");

  public static By expiry = By.xpath("//input[starts-with(@class,'input svelte-43m0zu no-focus no-blur no-validate') and contains(@id,'card_expiry')]");

  public static By cvv = By.xpath("//input[starts-with(@class,'input svelte-43m0zu no-focus no-blur no-validate cvv-input') and contains(@id,'card_cvv')]");
  
  public static By paybutton = By.xpath("//*[@id=\"footer\"]");
  
  public static By Skipcard = By.xpath("//*[starts-with(text(),'Skip saving card')]");
  
  public static By Card = By.xpath("//*[contains(text(),'Visa, MasterCard, RuPay & More')]");
  
  public static By netbanking = By.xpath("//*[starts-with(text(),'All Indian banks')]");
  
  public static By SBIBank = By.xpath("//*[starts-with(text(),'SBI')]");
  
  public static By HDFCBank = By.xpath("//*[starts-with(text(),'HDFC')]");
  
  public static By ICCIBank = By.xpath("//*[starts-with(text(),'ICICI')]");
  
  public static By AxisBank = By.xpath("//*[starts-with(text(),'Axis')]");
  
  public static By YesBank = By.xpath("//*[starts-with(text(),'Yes')]");
  
  public static By KotakBank = By.xpath("//*[starts-with(text(),'Kotak')]");
  
  public static By netbankingHDFC = By.xpath("//div[contains(text(),'Netbanking - HDFC Bank')");
  
  public static By netbankingSBI = By.xpath("//div[contains(text(),'Netbanking - State Bank of India')]");
  
  public static By netbankingICCI = By.xpath("//div[contains(text(),'Netbanking - ICICI Bank')]");
  
  public static By successbutton = By.xpath("//button[contains (@class,'success')]");
  
  public static WebElement DoctorLocation() {
  return driver.findElement(By.xpath("//div[@class='card product-item-vertical hoverable animation comp-bg flipInX']/div[@class='row d-flex align-items-start']/div[@class='doctor-list-wrapper col-xl-5 col-lg-5 col-md-5 col-12']/div[@class='card-body doctor-content']/div[8]"));
  }
  
}
