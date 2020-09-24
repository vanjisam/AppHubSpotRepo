package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePageTest;
import com.qa.hubspot.page.ContactPage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.ExcelUtil;
import com.qa.hubspot.util.constants;

public class ContactPageTest extends BasePageTest{
	
	//LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	
	@BeforeClass
	public void contactsSetup() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=homePage.gotoContactsPage();
			}
	
	@Test(priority=1)
	public void GetPageTitleTest() {
		String title=contactPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, constants.CONTACTS_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][]=ExcelUtil.getTestDataFromExcel(constants.CONTACTS_SHEET_NAME);
		return data;
	}
	
	@Test(priority=2,dataProvider="getTestData")
	public void createContactTest(String email, String firstName, String lastName) {
	contactPage.createContact( email, firstName, lastName);
	homePage.clickOnContacts();
	}
	
}
	