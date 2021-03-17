package com.sailotech.testautomation.ezscheduler.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sailotech.testautomation.ezscheduler.ProviderFunctions.*;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.commonutilities.ScreenRecording;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class Providerrregistration_test extends TestBase {

  ScreenRecording screenRecord;
  TestBase testBase;
  ITestResult tr = null;

  @BeforeClass
  public void display() {
    System.out.println("\nI am before method");
  }

  @BeforeMethod
  public void setUp(ITestResult tr) {
    tr.setAttribute("class", getClass().getName());
    tr.setAttribute("toString", tr.toString());
    this.tr = tr;
  }

  @BeforeClass
  public void screenRecord() throws Exception {
    screenRecord = new ScreenRecording();
    screenRecord.startRecording();
    testBase = new TestBase();
  }

  @TestCaseId("TC_01")
  @Severity(SeverityLevel.NORMAL)
  @Description("Provider Registering in EzScheduler Website")
  @Test(description = "Provider Registering in EzScheduler Website")
  public void TC_01_ProviderRegistration() throws Exception {
    Providerregistration p1 = new Providerregistration();
    p1.Provider_Register(driver);
  }

  @TestCaseId("TC_02")
  @Severity(SeverityLevel.NORMAL)
  @Description("Reading Provider Credentials from mail")
  @Test(
      dependsOnMethods = {"TC_01_ProviderRegistration"},
      description = "Reading Provider Credentials from mail")
  public void TC_02_Providercredentials_frommail() throws Exception {
    Providercredentialsfrommail p2 = new Providercredentialsfrommail();
    p2.ProviderCredentialsfrommail(driver);
  }

  @TestCaseId("TC_03")
  @Severity(SeverityLevel.NORMAL)
  @Description(
      "After Admin Verfied , the provider Receives Login credentials from Ezscheduler Team")
  @Test(
      dependsOnMethods = {"TC_01_ProviderRegistration"},
      description =
          "After Admin Verfied , the provider Receives Login credentials from Ezscheduler Team")
  public void TC_03_Provider_LoginCredentials() throws Exception {
    ProviderRegistrationCredentials p3 = new ProviderRegistrationCredentials();
    p3.ProviderRegistration_LoginCredentials(driver);
  }

  @TestCaseId("TC_04")
  @Severity(SeverityLevel.NORMAL)
  @Description("Provider Logout from Ezscheduler Website")
  @Test(
      dependsOnMethods = {"TC_03_Provider_LoginCredentials"},
      description = "Provider Logout from Ezscheduler Website")
  public void TC_04_ProviderLogout() throws Exception {
    Providerlogout p4 = new Providerlogout();
    p4.Provider_Logout(driver);
  }

  @AfterTest
  public void stopRecording() throws Exception {
    screenRecord.stopRecording();
    // driver.quit();
  }
}
