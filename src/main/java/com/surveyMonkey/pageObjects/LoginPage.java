package com.surveyMonkey.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class LoginPage {
//1
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(this.getClass());
//2 constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
//3 locators
	@FindBy(xpath = "//input[@aria-label='Email address']")
	WebElement txtusername;
	
	//locator for next button and login button
	@FindBy(xpath ="(//button[@type = 'submit'])[2]")
	WebElement btnNextOrLogin;
	
	//locator for password
	@FindBy(xpath = "//input[@aria-label='Password']")
	WebElement txtpassword;
	
	
//4 enter value
	
	public void enterUsername(String uname) {
		txtusername.clear();
		txtusername.sendKeys(uname);
		String username = txtusername.getAttribute("value"); //verify the value entered
		logger.info("value entered in the username field is :"+username);
	}
	public void enterPassword(String pwd) {
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
		String password = txtpassword.getAttribute("value"); //verify the value entered
		logger.info("value entered in the username field is :"+password);
	}
	
	public void clickOnNextOrLogin(String btnName) {
		if(btnName.equalsIgnoreCase("next")) {
			btnNextOrLogin.isEnabled();
			logger.info(btnName+" is enabled");
			btnNextOrLogin.click();
			logger.info("button "+btnName+" is clicked");
		}else if (btnName.equalsIgnoreCase("login")) {
			btnNextOrLogin.isEnabled();
			logger.info(btnName+" is enabled");
			btnNextOrLogin.click();
			logger.info("button "+btnName+" is clicked");
		}else {
			System.out.println("please enter a valid button name");
		}
		
		
	
	
}
}