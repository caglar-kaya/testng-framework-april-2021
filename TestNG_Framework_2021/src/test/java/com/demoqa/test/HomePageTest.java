package com.demoqa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.util.Constants;

public class HomePageTest {

	WebDriver driver;
	Properties properties;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1, description = "verify home page title")
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE,  "Home page title is in-correct");
	}
	
	@Test(priority = 2, description = "verify home page elements section text")
	public void verifyHomePageElementsSection() {
		String text = homePage.getHomePageElementsSection();
		System.out.println("Home page element section text : " + text);
		Assert.assertEquals(text, Constants.HOME_PAGE_ELEMENTS_SECTION);
	}
	
	@Test(priority = 3, description = "verify logged in user name")
	public void verifyLoggedInUserName() {
		String userName = homePage.getLoggedInUserName();
		System.out.println("Home page user name : " + userName);
		Assert.assertEquals(userName, Constants.USER_NAME);
	}
	
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		basePage.quitBrowser();
	}

}
