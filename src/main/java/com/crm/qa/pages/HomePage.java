package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	//Page Factory Or Object Repository	
	@FindBy(xpath="//td[contains(text(),'User')]")
	@CacheLookup   //its available in selenium this annotation will store userNameLabel in cache so instead of loading 
	//from page it will load from cache so it will improve the performance.
	//but if the element is refreshed than the element would be stale so if the property of the element is not
	//changing than we should @CacheLookup.
	WebElement userNameLabel;
	

	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactLink;
	
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	
	
	
	
	//Initializing the Page Objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);			
	}
	
	
	public String verifyHomePageTitle() 
	{
		return driver.getTitle();		
	}
	
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();		
	}
	
	public ContactsPage clickOnContactsLink() 	
	{
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealLinks()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLinks()
	{
		tasksLink.click();
		return new TasksPage();//it should return the next landing page always
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		
	}
	
	
	

}
