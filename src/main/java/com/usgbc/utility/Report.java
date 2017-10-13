package com.usgbc.utility;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {

	// extent report object
	public static ExtentReports extent;
	// extent test report
	public static ExtentTest test;
	// date formatter object
	public static Format formatter;
	// java util date object
	public static Date date;

	// config file to configure report path, extent-config file, and excel sheet
	// file

	public static void ExtentReportConfig() {

		try {
			// creating date format object
			formatter = new SimpleDateFormat("YYYY-MM-dd");
			// creating date class object
			date = new Date();
			// report file
			System.out.println("Report file Created");
			extent = new ExtentReports(System.getProperty("user.dir") + "/Report/UsgbcTest Report" + "_"
					+ formatter.format(date) + ".html", false);
			// config file
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
			// Hash Map interface to add the key, value pair in the system info to be
			// displayed
			Map<String, String> sysInfo = new HashMap<String, String>();
			sysInfo.put("Environment", "Testing");
			extent.addSystemInfo(sysInfo);

		} catch (Exception e) {
			System.out.println("File Not found");
			e.printStackTrace();
		}
	}

	// AfterMethod to create the report if the test case fails to satisfy the
	// condition  
	public static void afterMethod(WebDriver driver, ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "/Screenshot/UsgbcTest Report"+ "_" + formatter.format(date) + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Screenshot taken");
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.INFO, "Screenshot Taken");
			test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(System.getProperty("user.dir")
					+ "/Screenshot/UsgbcTest Report" + "_" + formatter.format(date) + ".png"));
			test.log(LogStatus.FAIL, "Test Failed");
		}

		extent.endTest(test);
		extent.flush();
		//driver.get(System.getProperty("user.dir") + "/Report/UsgbcTest Report" + "_" + formatter.format(date) + ".html");
	}
}
