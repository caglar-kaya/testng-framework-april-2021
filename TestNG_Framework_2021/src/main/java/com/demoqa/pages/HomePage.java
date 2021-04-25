package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoqa.base.BasePage;
import com.demoqa.util.Constants;
import com.demoqa.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	// Locators
	By elementsSection = By.xpath("//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[1]/span[1]/div[1]/div[1]");
	By userName = By.cssSelector("#userName-value");
	// By contactMainTab = By.id("aaa");
	// By contactChildTab = By.id("bbb");
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Page Actions
	public String getHomePageTitle() {
		// return driver.getTitle();
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public String getHomePageElementsSection() {
		// return driver.findElement(elementsSection).getText();
		return elementUtil.doGetText(elementsSection);
	}
	
	public String getLoggedInUserName() {
		// return driver.findElement(userName).getText();
		return elementUtil.doGetText(userName);
	}
	
	private void clickOnContacts() {
		// elementUtil.doClick(contactMainTab);
		// elementUtil.doClick(contactChildTab);
	}
	
	public ProfilePage goToProfilePage() {
		clickOnContacts();
		return new ProfilePage(driver);
	}
}




















