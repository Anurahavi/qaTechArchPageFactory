package com.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.calculatorPage;
import com.pageObjects.loginPage;
import com.utilties.Testbase;


public class calculatorTc extends Testbase {
	
	Logger log= Logger.getLogger(getClass().getSimpleName());
	
	@BeforeTest
	public void beforeEach() throws IOException{
	    driver=launchUrl();
	    log.info("Launched the browser and entered the URL");
	}
	
	@Test
	public void calculatorAdd() throws IOException, InterruptedException {
		loginPage l=new loginPage(driver);
		HomePage h=l.logintoApp();
		log.info("Logged into App with valid credentials");
		calculatorPage c=h.calButton();
		c.calculator();
		log.info("Checked the addition operation of calculator");
		
	}
	
	@AfterTest
	public void tearDown() {
		log.info("Closing browser");
		driver.quit();
	}
	
	

}
