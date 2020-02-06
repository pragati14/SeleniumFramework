package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;


public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Testcases should be separated --- independent this will avoid cache problem
	//before each test case --- launch the browser 
	//@test --- execute the test
	//after each test case --- close browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomepageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Homepage title not matched!");	
	}
	
	
	@Test(priority=2)
	public void verifyUsernameTest() {
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
