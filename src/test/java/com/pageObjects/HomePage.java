package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilties.Testbase;



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
		browUtil.waitforElement(driver, home);
		 return home.isDisplayed();
	}
	
	public calculatorPage calButton() {
		browUtil.waitforElement(driver,calButton);
		browUtil.clickElement(calButton);
		return new calculatorPage(driver);
	}
	
	public alertPage alertfn() {
		browUtil.waitforElement(driver, switchTo);
		browUtil.clickElement(switchTo);
		browUtil.clickElement(alert);
		return new alertPage(driver);
	}
	
	public void logOut() {
		browUtil.waitforElement(driver, logout);
		browUtil.clickElement(logout);
		
	}
	
	
}
