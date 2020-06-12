package com.utilties;


import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonUtility {
              
	public void clickElement(WebElement ele) {
		ele.click();
	}
	
	public void sendkeys(WebElement ele,String keys) {
		ele.sendKeys(keys);
	}
	
	public void waitforElement(WebDriver driver,final WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
}
