package com.sailotech.testautomation.ezscheduler.ProviderFunctions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderPage;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderRepositoryclass;

import ru.yandex.qatools.allure.annotations.Attachment;

public class Providerlogout extends TestBase {
 
  @Attachment
  public byte[] EzHomePage(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment
  public byte[] NavigateDoctorLogout(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void Provider_Logout(WebDriver driver) throws Exception {

    WebDriverWait wait = new WebDriverWait(driver, 5);
    //Actions action = new Actions(driver);
   // ProviderRepositoryclass page = new ProviderRepositoryclass(driver);
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.DoctorMenu)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.Doctorlogout)).click();
    EzHomePage(driver);
  }
}
