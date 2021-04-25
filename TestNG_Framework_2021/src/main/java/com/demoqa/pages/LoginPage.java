package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoqa.base.BasePage;
import com.demoqa.util.Constants;
import com.demoqa.util.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	// Locators
	By emailId = By.id("userName");
	By password = By.id("password");
	By loginBtn = By.id("login");
	
	// Constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Page Actions
	public String getPageTitle() {
		// return driver.getTitle();
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public HomePage doLogin(String username, String pwd) {
//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		
		return new HomePage(driver);
	}
}
