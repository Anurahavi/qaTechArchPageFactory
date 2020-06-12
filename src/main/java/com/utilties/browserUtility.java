package com.utilties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

}
