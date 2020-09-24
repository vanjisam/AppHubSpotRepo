package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;

public class BasePageTest {

	public WebDriver driver;
	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public Properties prop;
	
	
	@BeforeTest
	public void setup() {
	basePage=new BasePage();
	prop=basePage.int_prop();
	driver=basePage.init_driver(prop);
	loginPage=new LoginPage(driver);
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
