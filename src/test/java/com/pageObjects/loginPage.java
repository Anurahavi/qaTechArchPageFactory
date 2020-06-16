package com.pageObjects;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilties.Testbase;



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
		browUtil.waitforElement(driver, username);
		return username.isDisplayed();
	}
	
	 
	public HomePage logintoApp() throws IOException, InterruptedException{
		System.out.println(comUtil.getproperty("username"));
		browUtil.sendkeys(username,comUtil.getproperty("username"));
		browUtil.sendkeys(password,comUtil.getproperty("password"));
		browUtil.clickElement(login);
		return new HomePage(driver);
		}
	
	public String invalidLogin() throws IOException, InterruptedException{
		browUtil.sendkeys(username,comUtil.getproperty("user"));
		browUtil.sendkeys(password,comUtil.getproperty("password"));
		browUtil.clickElement(login);
		browUtil.waitforAlert(driver);	
		Alert alert=driver.switchTo().alert();
		String alertText= alert.getText();
		alert.accept();
		return alertText;
		
		}

}
