package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;
	
	By username=By.id("username");
	By password=By.id("password");
	By loginButton=By.id("loginBtn");
	By signUp=By.linkText("Sign up");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
			
	
	public HomePage login(String s1, String s2) {
		driver.findElement(username).sendKeys(s1);
		driver.findElement(password).sendKeys(s2);
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean checkSignUpLink() {
		return driver.findElement(signUp).isDisplayed();
		
	}
	
	
}
