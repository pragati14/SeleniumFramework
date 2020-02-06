package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath= "//span[contains(text(),'p ajnlkr')]")
	WebElement USerNameLabel;
	
	@FindBy(xpath= "//span[text() ='Contacts']")
	WebElement contacklink;
	
	@FindBy(xpath= "//span[text() ='Deals']")
	WebElement dealslink;
	
	@FindBy(xpath= "//span[text() ='Tasks']")
	WebElement taskslink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername() {
		return USerNameLabel.isDisplayed();
	}
	
	public ContactsPage clickonContactlink() {
		contacklink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealslink() {
		dealslink.click();
		return new DealsPage();
	}
	
	public TaskPage clickonTasklink() {
		taskslink.click();
		return new TaskPage();
	}
	
}
