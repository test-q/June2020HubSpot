package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utils.ConstantUtil;
import com.qa.hubspot.utils.ElementUtils;

public class HomePage {

	private WebDriver driver;
	ElementUtils elementUtil;

	// By Locators - OR
	By header = By.tagName("h1");
	By accountName = By.cssSelector("span.account-name");
	By settingsIcon = By.id("navSetting");

	// Constructor of the page:
	public HomePage(WebDriver driver) {
		elementUtil = new ElementUtils(driver);
		this.driver = driver;
	}

	// Page Actions:
	public String getHomePageTitle() {
		return elementUtil.waitForTitlePresent(ConstantUtil.HOMEPAGE_TITLE.trim(), 10);
	}

	public String getHeaderValue() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public String getAccountName() {
		if (elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}

	public boolean isSettingIconExist() {
		return elementUtil.doIsDisplayed(settingsIcon);
	}

}
