package com.demoqa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.base.BasePage;
import com.demoqa.pages.LoginPagePF;

public class LoginPFTest {

	WebDriver driver;
	Properties properties;
	BasePage basePage;
	LoginPagePF loginPagePF;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPagePF = new LoginPagePF(driver);
	}
	
	@Test
	public void loginTest() {
		loginPagePF.doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
	
}








