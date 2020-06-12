package com.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.utilties.browserUtility;
import com.utilties.commonUtility;

public class Testbase {
	
	public WebDriver driver;
	public Properties prop;
	public String projectpath =System.getProperty("user.dir");
	public browserUtility browUtil= new browserUtility();
	public commonUtility comUtil=new commonUtility();
	
	
	public WebDriver launchUrl() throws IOException {
		System.out.println(getproperty("browser"));	
		driver=browUtil.initializeDriver(getproperty("browser"));
		driver.get(prop.getProperty("url"));
		return driver;
		
		
	}
	
	public String getproperty(String value) throws IOException {
		prop=new Properties(); 
	   	FileInputStream fis=new FileInputStream(projectpath+"\\src\\main\\java\\Properties\\data.properties");
		prop.load(fis);	
		return prop.getProperty(value);
		
	}
	
	public void log4jproperty() throws IOException {
		FileInputStream fi= new FileInputStream(projectpath+"\\src\\main\\java\\Properties\\log4j.properties");
		prop=new Properties();
		prop.load(fi);
		PropertyConfigurator.configure(prop);
		
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}

}
