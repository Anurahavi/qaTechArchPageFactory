package com.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.alertPage;
import com.pageObjects.loginPage;
import com.resources.Testbase;

public class alertPagetc extends Testbase {
	
	
	 Logger log= Logger.getLogger(getClass().getSimpleName());
    public WebDriver driver;
    
    @BeforeTest
    public void beforeEach() throws IOException{
	    driver=launchUrl();
	    log.info("Launched the browser and entered the URL");
	}
    
    @Test
    public void windowAlert() throws IOException, InterruptedException {
    	loginPage l=new loginPage(driver);
		HomePage h=l.logintoApp();
		alertPage a=h.alertfn();
		a.winAlert();
		log.info("Alert accepted");
    }
    
    @AfterTest
	public void tearDown() {
    	log.info("Closing browser");
		driver.quit();
	}
}
