package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil util;
	
	By welcomeText=By.cssSelector("h1.dashboard-selector__title");
	By contactHeader=By.cssSelector("//div[contains(text(),'Contacts')][1]");
	 
	By contactParentMenu=By.id("nav-primary-contacts-branch");
	By contactChildMenu=By.id("nav-secondary-contacts");
	By homePageIcon=By.id("nav-primary-home");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		util=new ElementUtil(driver);
	}
	
	public String getPageTitle() {
		return util.doGetTitle();
	}
	
	public String getWelcomeText() {
		if(util.doIsDispalyed(welcomeText)) {
			return util.doGetText(welcomeText);
		}
		return null;
	}
		
	public String getHeader() {
		return util.doGetText(contactHeader);
		}
	
	public ContactPage gotoContactsPage() {
		clickOnContacts();
		return new ContactPage(driver);
	}
	
	public void clickOnContacts() {
		util.waitForVisibilityOfElement(10, homePageIcon);
		util.doClick(homePageIcon);
		util.waitForPresenceOfElement(15, contactParentMenu);
		util.doClick(contactParentMenu);
		util.waitForPresenceOfElement(10, contactChildMenu);
		util.doClick(contactChildMenu);
		
	}
}
