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

public class Providergenerateslots_test extends TestBase {

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

  @TestCaseId("TC_05")
  @Severity(SeverityLevel.NORMAL)
  @Description("Navigate To Provider Login page")
  @Test(description = "Navigate To Provider Login page")
  public void TC_05_ProviderLogin() throws Exception {
    Providerlogin p5 = new Providerlogin();
    p5.ProviderLogin(driver);
  }

  @TestCaseId("TC_06")
  @Severity(SeverityLevel.NORMAL)
  @Description("Provider Generating slots")
  @Test(
      dependsOnMethods = {"TC_05_ProviderLogin"},
      description = "Provider Generating slots")
  public void TC_06_To_GenerateSlots() throws Exception {
    Providergeneratingslots p6 = new Providergeneratingslots();
    p6.GenerateSlots(driver);
  }

  @TestCaseId("TC_03")
  @Severity(SeverityLevel.NORMAL)
  @Description("Provider Logout from Ezscheduler Website")
  @Test(
      dependsOnMethods = {"TC_06_To_GenerateSlots"},
      description = "Provider Logout from Ezscheduler Website")
  public void TC_04_ProviderLogout() throws Exception {
    Providerlogout p4 = new Providerlogout();
    p4.Provider_Logout(driver);
  }

  @AfterTest
  public void stopRecording() throws Exception {
    screenRecord.stopRecording();
    driver.quit();
  }
}
