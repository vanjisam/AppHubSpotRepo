package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;
import com.qa.hubspot.util.constants;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil util;
	
	By username=By.id("username");
	By password=By.id("password");
	By loginButton=By.id("loginBtn");
	By signUp=By.linkText("Sign up");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		util=new ElementUtil(driver);
	}
			
	@Step("username is {0} and password is {1}")
	public HomePage login(String s1, String s2) {
	util.doSendKey(username, s1);
	util.doSendKey(password,s2);
	util.doClick(loginButton);
		return new HomePage(driver);
	}
	
	@Step("This is used to GetPageTitle in LoginPage Test")
	public String getPageTitle() {
		util.waitForTitleContains(constants.LOGIN_PAGE_TITLE, 10);
		return util.doGetTitle();
		}
	
	@Step("This is used to verify signup link in LoginPage Test")
	public boolean checkSignUpLink() {
		return util.doIsDispalyed(signUp);
		}
	
	}
	

