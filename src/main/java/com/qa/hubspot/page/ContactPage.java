package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class ContactPage extends BasePage {
	WebDriver driver;
	ElementUtil util;
	
	By createContactPrimary = By.xpath("//span[contains(text(),'Create contact')]");
	By email=By.xpath("//input[@data-field='email']");
	By firstname=By.xpath("//input[@data-field='firstname']");
	By lastname=By.xpath("//input[@data-field='lastname']");
	By createContactSecondary=By.xpath("(//span[contains(text(),'Create contact')])[last()]");
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		util=new ElementUtil(driver);
		
	}
	
	public String getPageTitle(){
		return util.doGetTitle();
	} 
	
		
	public void createContact(String emailId, String firstName, String lastName) {
		util.waitForPresenceOfElement(15, createContactPrimary);
		util.doClick(createContactPrimary);
		util.waitForPresenceOfElement(10, email);
		util.doSendKey(email, emailId);
		util.doSendKey(firstname, firstName);
		util.doSendKey(lastname, firstName);
		util.waitForPresenceOfElement(10, createContactSecondary);
		util.doClick(createContactSecondary);
	}
	
}
