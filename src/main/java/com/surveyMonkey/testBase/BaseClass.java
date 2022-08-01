package com.surveyMonkey.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public WebDriver driver;
public Logger logger = LogManager.getLogger(this.getClass());

public Properties prop;


@BeforeClass
@Parameters("browsername")
public void setup(String br) throws IOException {
	
	if (br.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info(br +"is opeened succesfully");
	} else if (br.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	} else if (br.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	} else {
		logger.info("enter correct driver name: chrome/edge/firefox");
	}
	
	
	
	
	prop = new Properties();
	FileInputStream fis =  new FileInputStream("C:\\Users\\rarav\\eclipse-workspace\\SurveyMonkey\\resources\\config.properties");
	prop.load(fis);
	
	driver.get(prop.getProperty("url"));
	logger.info("surveymonkey application homepage is displayed");
	
}

@AfterClass
public void teardown() {
	driver.quit();
	logger.info("surveymonkey application  is closed");
	
}

public void captureSrceenshot(WebDriver driver, String testName) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source =  ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+testName+".png");
	//to copy and paste
	
	FileUtils.copyFile(source, target);
	logger.info("screenshots captured succesfully");
	
}


}
