package com.learning.automation.mavenselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
