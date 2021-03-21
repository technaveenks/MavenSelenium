package com.learning.automation.mavenselenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learning.automation.mavenselenium.pages.HomePage;
import com.learning.automation.mavenselenium.pages.MobilesPage;
import com.learning.automation.mavenselenium.utility.BaseTest;
import com.learning.automation.mavenselenium.utility.ExcelReader;

public class RegressionTests extends BaseTest{
	HomePage homePage;
	MobilesPage mobilesPage;
	
	
	@DataProvider(name = "Locations")
	public static Object[][] Locations() {
		return new Object[][] { { "Bangalore","560100"}, { "Chennai","600123"}, { "New Delhi","110110"}};
	}
	
	@Test(dataProvider = "Locations")
	public void verifyHomeRegPage(String location, String zipcode) {
		System.out.println("Current URL " +getDriver().getCurrentUrl());
		//getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		homePage.clickOnClose();
		mobilesPage = homePage.clickOnMobiles();
		mobilesPage.select6GBRam();
		System.out.println(" Data provider "+location);
		System.out.println(" Zip Code "+ zipcode);
		
	}
	
	@Test
	public void verifyRegData() throws Exception {
		ExcelReader.setExcelFile();
	System.out.println(ExcelReader.getCellData(1, 0));
	}
	
	
	@BeforeClass
	public void setUp() {
		homePage= new HomePage(getDriver());
	}

}
