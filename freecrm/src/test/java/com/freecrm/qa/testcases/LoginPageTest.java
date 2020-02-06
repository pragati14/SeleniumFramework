package com.freecrm.qa.testcases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("title"));
	}
	
	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		new WebDriverWait(driver, 20);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

