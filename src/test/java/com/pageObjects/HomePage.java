package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.Testbase;

public class HomePage extends Testbase {
     
public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement home;
	@FindBy(xpath="//a[contains(text(),'Calculator')]")
	WebElement calButton;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	@FindBy(xpath="//button[contains(text(),'Switch To')]")
	WebElement switchTo;
	@FindBy(xpath="//a[contains(text(),'Alert')]")
	WebElement alert;
	
	public boolean home() {
		comUtil.waitforElement(driver, home);
		 return home.isDisplayed();
	}
	
	public calculatorPage calButton() {
		comUtil.waitforElement(driver,calButton);
		comUtil.clickElement(calButton);
		return new calculatorPage(driver);
	}
	
	public alertPage alertfn() {
		comUtil.waitforElement(driver, switchTo);
		comUtil.clickElement(switchTo);
		comUtil.clickElement(alert);
		return new alertPage(driver);
	}
	
	public void logOut() {
		comUtil.waitforElement(driver, logout);
		comUtil.clickElement(logout);
		
	}
	
	
}
