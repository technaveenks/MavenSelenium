package com.learning.automation.mavenselenium.tests;

import org.apache.logging.log4j.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learning.automation.mavenselenium.pages.HomePage;
import com.learning.automation.mavenselenium.pages.MobilesPage;
import com.learning.automation.mavenselenium.utility.BaseTest;
import com.learning.automation.mavenselenium.utility.ExcelReader;

public class SmokeTests extends BaseTest {
	HomePage homePage;
	MobilesPage mobilesPage;

	private static final Logger log = LogManager.getLogger(SmokeTests.class);

	@DataProvider(name = "Locations")
	public static Object[][] Locations() {
		return new Object[][] { { "Bangalore", "560100" }, { "Chennai", "600123" }, { "New Delhi", "110110" } };
	}

	@DataProvider(name = "Search")
	public static Object[][] Search() throws Exception {
		return ExcelReader.getTestData();
	}

	@Test(dataProvider = "Locations")
	public void verifyHomePage(String location, String zipcode) {
		log.info(" Test case Execution Started");
		log.info("Current URL " + getDriver().getCurrentUrl());
		// getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click();

		log.info("Data Provider Location = " + location);
		log.info(" Zip Code " + zipcode);
		homePage.clickOnClose();
		mobilesPage = homePage.clickOnMobiles();
		mobilesPage.select6GBRam();

		// System.out.println(" Data provider "+location);
		// System.out.println(" Zip Code "+ zipcode);
		log.info(" Test case Execution Stopped");

	}

	@Test
	public void verifyData() throws Exception {
		log.info(" Test case Execution Started");
		ExcelReader.setExcelFile();
		System.out.println(ExcelReader.getCellData(1, 0));
		log.info(" Test case Execution Stopped");
	}

	@Test(dataProvider = "Search")
	public void verifySearchData(String searchData) throws Exception {
		log.info(" Test case Execution Started");
		System.out.println(" Search Data -- "+ searchData);
		log.info(" Test case Execution Stopped");
	}

	@BeforeClass
	public void setUp() {
		homePage = new HomePage(getDriver());
	}

}
