package com.pageObjects;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.resources.Testbase;

public class loginPage extends Testbase{
	
	public WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email_field")
	WebElement username;
	@FindBy(id="password_field")
	WebElement password;
	@FindBy(xpath="//button[contains(text(),'Login to Account')]") 
	WebElement login;
	
	public boolean username() {
		comUtil.waitforElement(driver, username);
		return username.isDisplayed();
	}
	
	 
	public HomePage logintoApp() throws IOException, InterruptedException{
		System.out.println(getproperty("username"));
		comUtil.sendkeys(username,getproperty("username"));
		comUtil.sendkeys(password,getproperty("password"));
		comUtil.clickElement(login);
		return new HomePage(driver);
		}
	
	public String invalidLogin() throws IOException, InterruptedException{
		comUtil.sendkeys(username,getproperty("user"));
		comUtil.sendkeys(password,getproperty("password"));
		comUtil.clickElement(login);
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());	
		Alert alert=driver.switchTo().alert();
		String alertText= alert.getText();
		alert.accept();
		return alertText;
		
		}

}
