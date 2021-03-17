package com.sailotech.testautomation.ezscheduler.AdminFunctions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.AdminPage;

import ru.yandex.qatools.allure.annotations.Attachment;

public class Adminlogout extends TestBase {

  @Attachment
  public byte[] EzHomePage(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  public void AdminLogout(WebDriver driver) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    // AdminRepositoryclass Adminfunction = new AdminRepositoryclass(driver);
    // AdminRepositoryclass page = new AdminRepositoryclass(driver);
    // Actions action = new Actions(driver);
    Thread.sleep(1000);

    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.AdminMenu)).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(AdminPage.AdminLogout)).click();
    } catch (Exception e) {
      System.out.println(
          "Error: Time out Exception: could not find Admin Login Button , Waiting for that element to be clickable \n"
              + e.getMessage());
    }
    EzHomePage(driver);
  }
}
