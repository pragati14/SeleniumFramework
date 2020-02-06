package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//Page Factory  - OR
	@FindBy(xpath = "//ul[@class='rd-navbar-nav']/a/span")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement emailId;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement password; 
	
	@FindBy(xpath = "//div[text() = 'Login']")
	WebElement login;
	
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a/svg/image")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		this.loginButton.click();
		emailId.sendKeys(un);
		password.sendKeys(pwd);
		login.click();	
		return new HomePage();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	
}