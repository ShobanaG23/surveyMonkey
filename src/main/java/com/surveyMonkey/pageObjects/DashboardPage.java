package com.surveyMonkey.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
public WebDriver driver;
public Logger logger = LogManager.getLogger(this.getClass());

public DashboardPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

//locators
	@FindBy(linkText="Dashboard")
	WebElement lnkDashboard;
	
	public boolean dashboardLinkIsDisplayed() {
		boolean status = lnkDashboard.isDisplayed();
		logger.info("status of dashboard link is :"+status);
		return status;
		
	}




}
