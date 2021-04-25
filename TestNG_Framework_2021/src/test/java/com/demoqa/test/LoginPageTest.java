package com.demoqa.test;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoqa.base.BasePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.util.Constants;

@Listeners(com.demoqa.listeners.ExtentReportListener.class)
public class LoginPageTest {
	
	/* M2E : Maven To Eclipse plugin problem solution!!!
	 * Open Eclipse -> Click on Help -> Click on Installation details 
	 * -> Search for TestNg M2E(optional) -> Select that and click on Uninstall.
	 * Restart your eclipse and rerun your testNg file.
	 */

	Logger log = Logger.getLogger("LoginPageTest");
	WebDriver driver;
	Properties properties;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		log.info("Browser is launching...");
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 2, description = "Login test using correct username and correct password.")
	public void loginTest1() {
		log.info("loginTest1 is starting...");
		loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		log.info("loginTest1 is ending...");
	}
	
	@Test(priority = 3, description = "Login test using in-correct username and correct password.")
	public void loginTest2() {
		loginPage.doLogin(properties.getProperty("incorrectuser"), properties.getProperty("password"));
	}
	
	@Test(priority = 4, description = "Login test using correct username and in-correct password.")
	public void loginTest3() {
		loginPage.doLogin(properties.getProperty("username"), properties.getProperty("incorrectpass"));
	}
	
	@Test(priority = 5, description = "Login test using in-correct username and in-correct password.")
	public void loginTest4() {
		loginPage.doLogin(properties.getProperty("incorrectuser"), properties.getProperty("incorrectpass"));
	}
	
	@Test(priority = 1, enabled = true, description = "Get title from ToolsQA  Login page and assert it.")
	public void verifyLoginPageTitle() {
		String title = loginPage.getPageTitle();
		System.out.println("Login page title : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Page title is in-correct");
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












