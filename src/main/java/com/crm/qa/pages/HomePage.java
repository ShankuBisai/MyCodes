package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	//Page Factory Or Object Repository	
	@FindBy(xpath="//td[contains(text(),'User')]")
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
