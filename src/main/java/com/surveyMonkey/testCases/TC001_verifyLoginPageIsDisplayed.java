package com.surveyMonkey.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.surveyMonkey.pageObjects.homePage;
import com.surveyMonkey.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_verifyLoginPageIsDisplayed extends BaseClass {

	
	
	@Test
	public void loginTestCase() throws IOException {
		
		
		homePage hp = new homePage(driver);
		hp.clickOnLoginLink();
		
		//capturing title
		
	String pageTitle = driver.getTitle();
	//capture screenshot
	captureSrceenshot(driver,"loginTestCase");
	
	Assert.assertEquals(pageTitle, "SurveyMonkey - Log in","survey monkey log in page is not displayed");
	logger.info("survey monkey log in page is displayed");
		
	}
	
	
}
