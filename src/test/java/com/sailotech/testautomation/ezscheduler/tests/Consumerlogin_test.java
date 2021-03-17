package com.sailotech.testautomation.ezscheduler.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sailotech.testautomation.ezscheduler.ConsumerFunctions.*;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.commonutilities.ScreenRecording;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class Consumerlogin_test extends TestBase {

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

  @TestCaseId("TC_12")
  @Severity(SeverityLevel.NORMAL)
  @Description("Navigate To Patient Login page")
  @Test(description = "Navigate To Patient Login page")
  public void TC_12_ConsumerLogin() throws Exception {
    Consumerlogin c5 = new Consumerlogin();
    c5.ConsumerLogin(driver);
  }

  @AfterTest
  public void stopRecording() throws Exception {
    screenRecord.stopRecording();
    driver.quit();
  }

  /*@AfterMethod
  public void appendFinalHTMLReport(ITestResult result){
      if(result.getStatus() == ITestResult.FAILURE)
      {
         driver.close();
         }
      }*/
}
