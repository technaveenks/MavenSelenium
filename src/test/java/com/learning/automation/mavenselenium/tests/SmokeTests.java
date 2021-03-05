package com.learning.automation.mavenselenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.learning.automation.mavenselenium.utility.BaseTest;

public class SmokeTests extends BaseTest{
	
	
	@Test
	public void verifyHomePage() {
		System.out.println("Current URL " +getDriver().getCurrentUrl());
		getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	}

}
