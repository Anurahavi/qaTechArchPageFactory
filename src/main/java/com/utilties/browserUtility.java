package com.utilties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browserUtility {
	public static WebDriver driver;
	String projectpath =System.getProperty("user.dir");
	
public WebDriver initializeDriver(String Browser){
	
		if(Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath+"\\driver\\chromedriver\\chromedriver.exe");
   			driver= new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", projectpath+"\\driver\\geckodriver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

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

public void waitforAlert(WebDriver driver) {
	WebDriverWait wait= new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.alertIsPresent());
}

}
