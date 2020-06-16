package com.utilties;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonUtility {
	
	public Properties prop;
	public String projectpath =System.getProperty("user.dir");
	
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
	
	public void deleteScreenshot() {
	try {
	    Files.deleteIfExists(Paths.get(System.getProperty("user.dir")+"reports"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	}
              
	
}
