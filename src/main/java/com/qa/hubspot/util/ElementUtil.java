package com.qa.hubspot.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	private long timeOut;
	private long interval;
	private By locator;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public List<WebElement> getFindElements(By locator) {
		return driver.findElements(locator);					
	}
	
	public WebElement getFindElement(By locator) {
		WebElement element=null;
		try{
			 element = driver.findElement(locator);
		}
		catch(Exception e) {
			System.out.println("some exception while creating the webelement");
			System.out.println(e.getMessage());
		}
		return element;
			
	}
	
	public void doSendKey(By locator, String value) {
		getFindElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getFindElement(locator).click();
	}
	
	public String doGetTitle() {
		return driver.getTitle();
	}
		
	public String doGetText(By locator) {
		return getFindElement(locator).getText();
}
	
	public boolean doIsDispalyed(By locator) {
		return getFindElement(locator).isDisplayed();
		
	}
	
	public void doActionSendKeys(By locator, String value) {
		Actions actions=new Actions(driver);
		actions.sendKeys(getFindElement(locator), value).build().perform();
	}
	
	public void doActionsClick() {
		Actions actions = new Actions(driver);
		actions.click(getFindElement(locator)).perform();
	}
	
	
	
	//************** Drop down Utils****
	
	public void doSelectVisibleText(By locator, String value) {
		Select select=new Select(getFindElement(locator));
		select.selectByVisibleText(value);
	}
	
	public void doSelectByIndex(By locator, int index) {
		Select select=new Select(getFindElement(locator));
		select.selectByIndex(index);
	}
	
	public void doSelectByValue(By locator, String value) {
		Select select=new Select(getFindElement(locator));
		select.selectByValue(value);
	}
	
	public int getDropDownOptionsCount() {
		Select select=new Select(getFindElement(locator));
		List<WebElement> optionsList=select.getOptions();
		return optionsList.size();
	}
	
	public ArrayList<String> getDropDownOptionValues() {
		Select select=new Select(getFindElement(locator));
		List<WebElement> optionsList=select.getOptions();
		 ArrayList<String> arrayList=new ArrayList<String>();
		 
		for(int i=0;i<optionsList.size();i++) {
			arrayList.add(optionsList.get(i).getText());
		}
		return arrayList;
	}

	/**
	 * This method is used to select drop down values with out using select clause
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public static void selectDropDownFindElements(WebDriver driver, String locator, String value) {
		List<WebElement> lists=driver.findElements(By.xpath(locator));
		
		System.out.println(lists.size());
		
		for (int i=0;i<lists.size();i++) {
			String text=lists.get(i).getText();
			System.out.println(text);
			if (text.equals(value)){
				lists.get(i).click();
				break;
			}
			}
	}
	
	//*********WebDriver Wait***********
	
	public WebElement waitForPresenceOfElement(int timeout, By locator) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
			
	public WebElement waitForVisibilityOfElement(int timeout, By locator) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeClickable(int timeout, WebElement locator) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void clickWhenElementClickable(int timeout, By locator) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void  waitForTitleIs(String title, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.titleIs(title));
		System.out.println(title);
	}
	
	public void waitForTitleContains(String title, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.titleContains(title));
		System.out.println(title);
	}
	
	public Boolean waitforUrlContains(String url, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.urlContains(url));
	}
	
	public Alert waitForAlertToBePresent(int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public WebElement waitForFluentWait() {
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(timeOut))
						.pollingEvery(Duration.ofSeconds(interval))
						.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
								
						
	}
}
