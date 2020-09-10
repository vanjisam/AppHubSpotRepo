package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;
	
	By welcomeText=By.cssSelector("h1.dashboard-selector__title");
	By contactHeader=By.cssSelector("//div[contains(text(),'Contacts')][1]");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getWelcomeText() {
		if(driver.findElement(welcomeText).isDisplayed()) {
			return driver.findElement(welcomeText).getText();
		}
		return null;
	}
	
	
	public String getHeader() {
		return driver.findElement(contactHeader).getText();
	}
}
