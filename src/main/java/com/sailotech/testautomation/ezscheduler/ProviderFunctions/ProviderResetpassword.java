package com.sailotech.testautomation.ezscheduler.ProviderFunctions;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sailotech.testautomation.ezscheduler.accerlators.TestBase;
import com.sailotech.testautomation.ezscheduler.repositorypages.ProviderPage;

import ru.yandex.qatools.allure.annotations.Attachment;

public class ProviderResetpassword extends TestBase{
	
	
	@Attachment
	public byte[] Provider_ResetPassword(WebDriver driver)  {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	public void ProviderResetPassword(WebDriver driver) throws Exception {
		WebDriverWait wait= new WebDriverWait(driver,5);
		Actions action=new Actions(driver);
		String user_dir =System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(user_dir + "/inputFiles/Provider.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		XSSFSheet s= wb.getSheetAt(5);
		Thread.sleep(5000);
	
	for(int i=0;i<s.getLastRowNum();i++) {
		System.out.println("\nTotal Row Count :" + s.getLastRowNum());
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderPage.ResetPassword)).click();
		
		
	}
		
		
		
		
	}
}
	
	

