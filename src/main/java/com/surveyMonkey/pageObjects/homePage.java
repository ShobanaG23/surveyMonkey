package com.surveyMonkey.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	//step 1
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(this.getClass());

	//step 2
	//creating constructor---name same as class name, no void 
	public homePage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
		
		//step 3: creating locators
		@FindBy(linkText="Log in")
		WebElement lnkLogin;
		
	
		//step 4 : click on login
		public void clickOnLoginLink() {
			lnkLogin.click();
			logger.info("clicked on login link");
		}
		
		
		//step 5 signup free locator
		@FindBy(linkText="Sign up free")
		WebElement lnkSignUpFree;
		
		//step 6 verify link exists
		
		public boolean signUpFreeLinkStatus() {
			boolean status = lnkSignUpFree.isDisplayed();
		logger.info("status of signup free is :" +status);
		return status;
		
		
		
		}
		
	}


	
	
	
	
	
	
	

