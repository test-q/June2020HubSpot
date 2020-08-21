package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ConstantUtil;
import com.qa.hubspot.utils.ElementUtils;

public class LoginPage extends BasePage{
	private WebDriver driver;
	ElementUtils elementUtil;
	
	// Constructor of the page:
	public LoginPage(WebDriver driver) {
		elementUtil = new ElementUtils(driver);
		this.driver = driver;
	}
	
	// By Locators - OR
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	By forgotPswLink = By.linkText("Forgot my password");
	
	// Page Actions:
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return elementUtil.waitForTitlePresent(ConstantUtil.LOGINPAGE_TITLE.trim(), 10);
	}
	
	public boolean getLoginPageURL() {
		//return driver.getCurrentUrl();
		return elementUtil.waitForUrl(ConstantUtil.LOGINPAGE_URL.trim(), 2);
	}
	
	public boolean isSignUpLinkExist() {
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	public boolean isForgotPasswordLinkExist() {
		//return driver.findElement(forgotPswLink).isDisplayed();
		return elementUtil.doIsDisplayed(forgotPswLink);
	}
	
	public HomePage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		//Page Chaining
		return new HomePage(driver);
	}
}
