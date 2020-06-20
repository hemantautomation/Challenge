package com.cldcvr.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class UIChallenge {
	
	{
		System.setProperty("webdriver.gecko.driver", 
		System.getProperty("user.dir")+"/src/test/resources/drivers/geckodriver");
	}
	
	@Test
	public void challenge1UI() throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://cpsatexam.org/");
		driver.findElement(By.xpath("//*[@id=\"menu-primary-spacious\"]/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-item-207\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"elementor-popup-modal-298\"]/div[2]/i")).click();
		List<WebElement> all = driver.findElements(By.xpath("//div[@id='eael-adv-accordion-cf8d59b']/div//p[2]"));
		List<String> allText = new ArrayList<String>();
		for(WebElement we:all) {
			allText.add(we.getText());
			System.out.println(we.getText());
		}
		System.out.println(allText);
		driver.get("https://translate.google.com/");
		for(String we:allText) {
			driver.findElement(By.id("source")).sendKeys(we);
			System.out.println(driver.findElement(By.xpath("//span[@class='tlid-translation']")).getText());
		}
		
	}
	
	
	
	

	
}
