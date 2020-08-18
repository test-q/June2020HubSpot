package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage{
	private WebDriver driver;
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	By forgotPswLink = By.linkText("Forgot my password");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean isSignUpLinkExist() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPswLink).isDisplayed();
	}
	
	public void doLogin(String un, String pwd) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
	}
}
