package com.learning.automation.mavenselenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learning.automation.mavenselenium.pages.HomePage;
import com.learning.automation.mavenselenium.pages.MobilesPage;
import com.learning.automation.mavenselenium.utility.BaseTest;

public class SmokeTests extends BaseTest{
	HomePage homePage;
	MobilesPage mobilesPage;
	
	@Test
	public void verifyHomePage() {
		System.out.println("Current URL " +getDriver().getCurrentUrl());
		//getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		homePage.clickOnClose();
		mobilesPage = homePage.clickOnMobiles();
		mobilesPage.select6GBRam();
	
	}
	
	@BeforeClass
	public void setUp() {
		homePage= new HomePage(getDriver());
	}

}
