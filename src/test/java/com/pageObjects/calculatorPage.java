package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilties.Testbase;



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
		browUtil.clickElement(num1);
		browUtil.clickElement(add);
		browUtil.clickElement(num2);
		browUtil.clickElement(equals);
	}
	
	
	
}
