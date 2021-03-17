package com.sailotech.testautomation.ezscheduler.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sailotech.testautomation.ezscheduler.AdminFunctions.*;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.commonutilities.ScreenRecording;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class Adminfullflow_test extends TestBase {
  ScreenRecording screenRecord;
  TestBase testbase;
  ITestResult tr = null;

  @BeforeClass
  public void display() {
    System.out.println("\nI am Before Method");
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
    testbase = new TestBase();
  }

  @TestCaseId("TC_08")
  @Severity(SeverityLevel.NORMAL)
  @Description("Navigate to Admin Login page")
  @Test(description = "Navigate to Admin Login page")
  public void TC_08_Navigate_to_AdminLogin() throws Exception {
    Adminlogin a1 = new Adminlogin();
    a1.AdminLogin(driver);
  }

  @TestCaseId("TC_09")
  @Severity(SeverityLevel.NORMAL)
  @Description("After Registration Admin is Verifying the Unverified Doctors")
  @Test(
      dependsOnMethods = {"TC_08_Navigate_to_AdminLogin"},
      description =
          "After Provider Registered in EzScheduler Admin is Verifying the Unverified Doctors")
  public void TC_09_AdminVerifyDoctor() throws Exception {
    AdminFullFlow a2 = new AdminFullFlow();
    a2.AdminverifyDoctor(driver);
  }

  @TestCaseId("TC_10")
  @Severity(SeverityLevel.NORMAL)
  @Description("Admin Logout from EzScheduler Website")
  @Test(
      dependsOnMethods = {"TC_09_AdminVerifyDoctor"},
      description = "Admin Logout from EzScheduler Website")
  public void TC_10_AdminLogout() throws Exception {
    Adminlogout a3 = new Adminlogout();
    a3.AdminLogout(driver);
  }

  @AfterTest
  public void stopRecording() throws Exception {
    screenRecord.stopRecording();
    driver.quit();
  }
}
