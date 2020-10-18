package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePageTest;
import com.qa.hubspot.util.constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)

@Epic("Epic -101")
@Story("User Story - 1.101")
public class LoginPageTest extends BasePageTest{
		
	@Description("Login Page Test #2")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyLoginPageTest() {
		String pageTitle=loginPage.getPageTitle();
		Assert.assertEquals(pageTitle, constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Login Page Test #1")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=2)
	public void verifySignUpLink() {
	Assert.assertTrue(loginPage.checkSignUpLink());
	}
	
	@Description("Login Page Test #3")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void verifyLoginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

}
