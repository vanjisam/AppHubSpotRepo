package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePageTest;
import com.qa.hubspot.util.constants;

public class LoginPageTest extends BasePageTest{
		
	
	@Test(priority=1)
	public void verifyLoginPageTest() {
		String pageTitle=loginPage.getPageTitle();
		Assert.assertEquals(pageTitle, constants.LOGIN_PAGE_TITLE);
	}
	
	
	@Test(priority=2)
	public void verifySignUpLink() {
	Assert.assertTrue(loginPage.checkSignUpLink());
	}
	
	
	@Test(priority=3)
	public void verifyLoginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

}
