package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoqa.util.Constants;
import com.demoqa.util.ElementUtil;

public class ProfilePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Locators
	By searchBox = By.id("searchBox");
	By goToStore = By.id("gotoStore");
	
	public String getProfilePageTitle() {
		return elementUtil.waitForGetPageTitle(Constants.PROFILE_PAGE_TITLE);
	}
	
	public void searchBook(String book) throws InterruptedException {
		elementUtil.doSendKeys(searchBox, book);
		Thread.sleep(5000);
		elementUtil.doClick(goToStore);
		Thread.sleep(5000);
	}
}
