package com.sailotech.testautomation.ezscheduler.ConsumerFunctions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.ConsumerPage;

import ru.yandex.qatools.allure.annotations.Attachment;

public class Consumerlogout extends TestBase{

  @Attachment
  public byte[] EzHomePage(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void Consumer_Logout(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    // Actions action = new Actions(driver);
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.patientmenu)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(ConsumerPage.PatientLogout)).click();
    Thread.sleep(1000);
    EzHomePage(driver);
  }
}
