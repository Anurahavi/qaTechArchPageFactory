package com.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.Testbase;

public class alertPage extends Testbase {
	
	public WebDriver driver;
	
	public alertPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'login')]//button[@class='bootbutton'][contains(text(),'Window Alert')]")
	WebElement winAlert;
	@FindBy(xpath="//button[contains(text(),'Promt Alert')]")
	WebElement proAlert;
	
	public void winAlert() {
		comUtil.clickElement(winAlert);
		Alert alert= driver.switchTo().alert();
		alert.accept();		
		
	}
	

}
