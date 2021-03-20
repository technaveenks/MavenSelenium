package com.learning.automation.mavenselenium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib//chromedriver_89.exe");
		driver = new ChromeDriver();
		driver.get("Http://flipkart.com");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
