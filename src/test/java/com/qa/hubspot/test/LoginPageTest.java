package com.qa.hubspot.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.constants;

public class LoginPageTest {
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;

	
	@BeforeTest
	public void setup() {
		basePage=new BasePage();
		driver= basePage.init_driver("chrome");
		loginPage=new LoginPage(driver);
			}
	
	@Test(priority=1)
	public void verifyLoginPageTest() throws InterruptedException {
		Thread.sleep(5000);
		String pageTitle=loginPage.getPageTitle();
		Assert.assertEquals(pageTitle, constants.PAGE_TITLE);
	}
	
	
	@Test(priority=2)
	public void verifySignUpLink() {
	Assert.assertTrue(loginPage.checkSignUpLink());
	}
	
	
	@Test(priority=3)
	public void verifyLoginTest() {
		loginPage.login("learnselenium999@gmail.com", "Nai12345!");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
