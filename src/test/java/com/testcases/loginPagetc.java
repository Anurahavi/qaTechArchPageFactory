package com.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.loginPage;
import com.utilties.Testbase;


public class loginPagetc extends Testbase {
	
	
    Logger log= Logger.getLogger(getClass().getSimpleName());
    public WebDriver driver;
	
    
   

	@BeforeMethod
	public void beforeEach() throws IOException{
	    driver=launchUrl();
	    log.info("Launched the browser and entered the URL");
	}
	
	@Test(priority=0)
	public void logintoApp() throws IOException, InterruptedException {
		loginPage l=new loginPage(driver);
		HomePage h=l.logintoApp();
		log.info("Logged in to the application by entering valid credential");
		Assert.assertEquals(h.home(),true);
		
	}
	
	@Test(priority=1)
	public void invalidlog() throws IOException, InterruptedException {
		loginPage l=new loginPage(driver);
		String error=l.invalidLogin();
		log.info(error);
		log.info("Invalid login error message is displayed");
	}
	
	@Test
	public void logoutApp() throws IOException, InterruptedException {
		loginPage l=new loginPage(driver);
		HomePage h=l.logintoApp();
		h.logOut();
		Assert.assertEquals(l.username(), true);
		log.info("Logged out of the application");
	}
	
	@AfterMethod
	public void tearDown() {
		log.info("Closing browser");
		driver.quit();
	}
	

}
