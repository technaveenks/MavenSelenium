package com.learning.automation.mavenselenium.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners implements ITestListener {
	protected static ExtentReports reports;
	protected static ExtentTest test;
	protected ExtentSparkReporter spark;
	protected ExtentKlovReporter klov;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(" Test Started ");
		test = reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(" Test Success ");
		test.log(Status.PASS, result.getMethod().getMethodName() + "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" Test Failure ");
		// test screen shot code here
		WebDriverHelper.captureScreenshot(result.getMethod().getMethodName());
		test.log(Status.FAIL, "Test Failed");
		test.addScreenCaptureFromPath("C:\\Users\\navee\\OneDrive\\Documents\\GitHub\\MavenSelenium\\screenshot\\"
				+ result.getMethod().getMethodName() + ".png");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(" Test Skipped ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" Test failed with success pecentage ");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(" Test failed with timeout ");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(" On start of Test ");
		reports = new ExtentReports();
		//klov = new ExtentKlovReporter("mavenselenium").initWithDefaultSettings();

		spark = new ExtentSparkReporter(
				"target/" + new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms").format(new Date()) + "-reports.html");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" On FInish of test ");
		// reports.attachReporter(spark);
		reports.attachReporter(spark);
		reports.flush();
	}

}
