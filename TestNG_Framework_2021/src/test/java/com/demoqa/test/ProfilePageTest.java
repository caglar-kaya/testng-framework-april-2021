package com.demoqa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoqa.base.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.util.Constants;
import com.demoqa.util.ExcelUtil;

public class ProfilePageTest {

	WebDriver driver;
	Properties properties;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		profilePage = homePage.goToProfilePage();
	}
	
	@Test(priority = 1)
	public void verifyProfilePageTitle() {
		String expextedTitle = Constants.PROFILE_PAGE_TITLE;
		String actualTitle = profilePage.getProfilePageTitle();
		System.out.println("Profile page title : " + actualTitle);
		Assert.assertEquals(actualTitle, expextedTitle);
	}
	
	@DataProvider
	public Object[][] getBookData() {
		Object data[][] = ExcelUtil.getTestData("Sayfa1");
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getBookData")
	public void searchBookTest(String book) throws InterruptedException {
		profilePage.searchBook(book);
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
	
	
}















