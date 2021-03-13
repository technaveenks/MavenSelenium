package com.learning.automation.mavenselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	//Constructor
	//Elements
	//Actions	
		
	//getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	
	// Close button in the popup
	@FindBy(xpath ="/html/body/div[2]/div/div/button")
	private WebElement _btnClose;
	
	// Mobile menu section
	@FindBy(xpath="(//*[contains(text(),'Mobiles')])[2]")
	private WebElement _menuMobiles;
			
	public void clickOnClose() {
		_btnClose.click();
	}
	
	public MobilesPage clickOnMobiles() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		_menuMobiles.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MobilesPage(driver);
	}
	
}
