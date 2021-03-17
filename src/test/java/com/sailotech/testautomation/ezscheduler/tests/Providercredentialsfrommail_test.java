package com.sailotech.testautomation.ezscheduler.tests;

import org.testng.annotations.Test;
import com.sailotech.testautomation.ezscheduler.ProviderFunctions.*;
import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class Providercredentialsfrommail_test extends TestBase {

 Providercredentialsfrommail page = new Providercredentialsfrommail();
	//ProviderCredentafrommaill page = new ProviderCredentafrommaill();

  @TestCaseId("TC_02")
  @Severity(SeverityLevel.NORMAL)
  @Description("Reading Provider crentials from mail")
  @Test(description = "Reading Provider crentials from mail")
  public void TC_02_Providercredentials_frommail() throws Exception {
    Providercredentialsfrommail p2 = new Providercredentialsfrommail();
    p2.ProviderCredentialsfrommail(driver);
  }
}
