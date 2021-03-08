package com.learning.automation.mavenselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	//Constructor
	//Elements
	//Actions	
		
	//getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	
	// Close button in the popup
	@FindBy(xpath ="/html/body/div[2]/div/div/button")
	private WebElement _btnClose;
	
	public void clickOnClose() {
		_btnClose.click();
	}

}
