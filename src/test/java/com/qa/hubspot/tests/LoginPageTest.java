package com.qa.hubspot.tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		basePage  = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 4)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, "HubSpot Login");	
	}
	
	@Test(priority = 1)
	public void verifyLoginPageURLTest() {
		String url = loginPage.getLoginPageURL();
		System.out.println(url);
		Assert.assertEquals(url, "https://app.hubspot.com/login");
	}
	
	@Test(priority = 3)
	public void verifyLoginPageSignupLinkTest() {
		Assert.assertTrue(loginPage.isSignUpLinkExist());
	}
	
	@Test(priority = 2)
	public void verifyLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
