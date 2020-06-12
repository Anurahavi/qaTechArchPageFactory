package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.Testbase;

public class calculatorPage extends Testbase {
	
public WebDriver driver;
	
	public calculatorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(xpath="//body//input[10]")
	WebElement num1;
	@FindBy(xpath="//body//input[5]")
	WebElement add;
	@FindBy(xpath="//body//input[11]")
	WebElement num2;
	@FindBy(xpath="//body//input[16]")
	WebElement equals;
	
	public void calculator() {
		comUtil.clickElement(num1);
		comUtil.clickElement(add);
		comUtil.clickElement(num2);
		comUtil.clickElement(equals);
	}
	
	
	
}
