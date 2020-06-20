package com.cldcvr.junit;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest {
	
	WebDriver driver;
	WebDriverWait wait;
	String AppURL = "http://Optimum.net";

	@Before
	public void setup() throws MalformedURLException {

		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "RZ8M83GYSYR");
//		caps.setCapability("udid", "ENUL6303030010"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
//		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", true);
		
		//Set ChromeDriver location
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver");
		//Instantiate Appium Driver
		AppiumDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		
	}
	}

	@Test
	public void testSearchAppium() {
		driver.get(AppURL);
		WebElement titleElement = driver.findElement(By.cssSelector("#site-name>a"));
		String homePageTitle = titleElement.getText();
		Assert.assertEquals(homePageTitle, "page title");

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
