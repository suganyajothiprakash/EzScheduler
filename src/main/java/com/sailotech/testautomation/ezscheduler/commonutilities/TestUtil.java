package com.sailotech.testautomation.ezscheduler.commonutilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sailotech.testautomation.ezscheduler.accerlators.*;

public class TestUtil extends TestBase{
	
	public	static long page_load_timeout=3500;
	public static long implicit_wait=60;
	public static long explicit_wait=180;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yy-HH-mm-ss");
		Calendar calendar = Calendar.getInstance();
		String timeStamp = simpleDateFormat.format(calendar.getTime());
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + timeStamp + "_TestFAILED.png"));
	}

}
