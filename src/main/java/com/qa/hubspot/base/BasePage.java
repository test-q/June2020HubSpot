package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author rupal
 *
 */
public class BasePage {

	WebDriver driver;
	Properties prop;
	
/**
 * This method is used to initialize the WebDriver on the basis og given browser name
 * @param browserName
 * @return This method return driver
 */
	public WebDriver init_driver(String browserName) {
		System.out.println("Browser Name is: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please Pass The Correct Browser Name : " + browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/login");
		return driver;
	}
	
	/**
	 * This method is used to get properties value form Config.properties file
	 * @return it return prop
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream finput = new FileInputStream("D:\\Rupali\\Workspace\\June2020HubSpot\\src\\main\\java\\com\\qa\\hubspot\\config\\Config.properties");
			prop.load(finput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
