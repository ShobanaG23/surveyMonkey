package com.surveyMonkey.testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.surveyMonkey.pageObjects.DashboardPage;
import com.surveyMonkey.pageObjects.LoginPage;
import com.surveyMonkey.pageObjects.homePage;
import com.surveyMonkey.testBase.BaseClass;

public class TC003_UserLoginTestCase extends BaseClass {
	
	@Test
	public void verifyUserLoginTestCase() throws InterruptedException, IOException {
	
	homePage hp = new homePage(driver);
	hp.clickOnLoginLink();
	
	
	LoginPage lp =  new LoginPage(driver);
	captureSrceenshot(driver, "verifyUserLoginTestCase");
	lp.enterUsername(prop.getProperty("username"));
	lp.clickOnNextOrLogin("next");
	Thread.sleep(5000);
	lp.enterPassword(prop.getProperty("password"));
	lp.clickOnNextOrLogin("login");
	
	DashboardPage dp =new DashboardPage(driver);
	boolean val = dp.dashboardLinkIsDisplayed();
	
	//check if val is true
	Assert.assertEquals(val, true, "dashboard link is not dislayed");
	logger.info("dashboard link is displayed");
	
	}
}
