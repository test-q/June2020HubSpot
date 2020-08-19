package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	// By Locators - OR
	By header = By.tagName("h1");
	By accountName = By.cssSelector("span.account-name");
	By settings = By.id("navSetting");
}
