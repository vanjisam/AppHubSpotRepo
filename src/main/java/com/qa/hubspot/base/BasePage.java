package com.qa.hubspot.base;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	WebDriver driver;
	Properties p;
	OptionsManager om;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	/*
	 * this method is used to get the thread local WebDriver
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();   
	}
	
	public WebDriver init_driver(Properties prop) {
		om=new OptionsManager(prop);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(om.getChromeOptions()));
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tlDriver.set(new SafariDriver());
		}
		
		getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		getDriver().get("https://app.hubspot.com/login");
		return getDriver();
	}
	
	/**
	 * This method
	 * @return 
	 */
	public Properties int_prop() {
		p=new Properties();
		try {
			FileInputStream fp=new FileInputStream(".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			p.load(fp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	/*
	 * This method takes screen shot
	 */
	public String getScreenshot() {
		
	File src=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";//this create a folder in the current directory
	File destination=new File(path);//convert the string to file to save the screen shot file
	try {
		FileUtils.copyFile(src, destination);//copies the src to destination
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return path;
	}

}
