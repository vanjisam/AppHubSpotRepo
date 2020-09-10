package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.constants;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	Properties prop;
	
	@BeforeTest
	public void setup() {
	basePage=new BasePage();
	prop=basePage.int_prop();
	driver=basePage.init_driver(prop);
	loginPage=new LoginPage(driver);
	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void getWelcomeTest() {
		
		String text=homePage.getWelcomeText();
		System.out.println(text);
		Assert.assertEquals(text, constants.WELCOME_TEXT);
	}
	@Test(priority=2)
	
	public void getPageTitleTest() {
		String title=homePage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, constants.HOME_PAGE_TITLE);
	}
	
	@Test(enabled=false)
	public void getHeaderText() {
		String headerText=homePage.getHeader();
		System.out.println(headerText);
		Assert.assertEquals(headerText, "Contacts");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
