package com.learning.automation.mavenselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilesPage extends BasePage{
	
	public MobilesPage(WebDriver driver) {
		super(driver);
	}
	//Constructor
	//Elements
	//Actions	
		
	//getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	
	//Filter section RAM
	@FindBy(xpath="//label/div[contains(@class,'_24_Dny')]/../div[2][contains(text(),'6 GB')]")
	private WebElement _chkBk6GB;
		
	
	public void select6GBRam() {
		_chkBk6GB.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
