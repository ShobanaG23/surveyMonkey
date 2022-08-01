package com.surveyMonkey.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.surveyMonkey.pageObjects.homePage;
import com.surveyMonkey.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_validateSignupFree extends BaseClass  {




@Test
public void SignupFreeTestCase() throws IOException {


	
	
	homePage hp = new homePage(driver);
	boolean val = hp.signUpFreeLinkStatus();
	
	captureSrceenshot(driver, "SignupFreeTestCase");
	
	
	Assert.assertEquals(val,  true,"Sign up free link is not dispalyed");
	logger.info("Sign up free link is dispalyed");
}








}













