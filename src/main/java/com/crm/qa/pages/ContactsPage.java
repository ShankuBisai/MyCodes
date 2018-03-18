package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	//Page Factory Or Object Repository	
	
    @FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
    
    @FindBy(xpath="//input[@id='first_name']")
  	WebElement firstName;
    
    @FindBy(xpath="//input[@id='surname']")
  	WebElement lastName;
    
    @FindBy(xpath="//input[@name='client_lookup']")
  	WebElement company;
    
    @FindBy(xpath="//input[@value='Save']")
  	WebElement saveBtn;
    
  
    
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);			
	}
	
		
	//Actions
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void createNewContact(String title,String ftName,String ltName,String comp)
	{
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();

		
		
	}
	
	
	
	
		

}
