package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			String exePath = "C:\\Users\\SHANKU\\eclipse-workspace\\FreeCRMTest\\Browser Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
		    driver = new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			String exePath = "C:\\Users\\SHANKU\\eclipse-workspace\\FreeCRMTest\\Browser Drivers\\geckodriver.exe";
			System.setProperty("webdriver.firefox.marionette",exePath);
			driver = new FirefoxDriver();
			
		}
		
		else if(browserName.equals("IE"))
		{
			String exePath = "C:\\Users\\SHANKU\\eclipse-workspace\\FreeCRMTest\\Browser Drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",exePath);
			driver = new InternetExplorerDriver(); 
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
		

}
