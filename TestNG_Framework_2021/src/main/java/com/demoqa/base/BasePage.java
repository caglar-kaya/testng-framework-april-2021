package com.demoqa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author User
 *
 */
public class BasePage {

	public WebDriver driver;
	public Properties properties;
	public static String flash;
	
	/**
	 * 
	 * @return
	 */
	public WebDriver initialize_driver(Properties properties) {
		
		// String browser = "chrome";
		String browser = properties.getProperty("browser");
		String headless = properties.getProperty("headless");
		flash = properties.getProperty("elementflash");
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (headless.equals("yes")) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("headless");
				driver = new ChromeDriver(chromeOptions);
			} else {
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (headless.equals("yes")) {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--headless");
				driver = new FirefoxDriver(firefoxOptions);
			} else {
				driver = new FirefoxDriver();
			}
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		// driver.get("https://demoqa.com/login");
		driver.get(properties.getProperty("url"));
		
		return driver;
	}
	
	/**
	 * 
	 * @return
	 */
	public Properties initialize_properties() {
		
		properties = new Properties();
		
		try {
			FileInputStream inputStream = new FileInputStream("C:\\Users\\User\\workspace\\"
					+ "TestNG_Framework_2021\\src\\main\\java\\com\\demoqa\\config\\"
					+ "config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
	
	/**
	 * 
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("some exception occured while quitting the browser");
		}
	}
	
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("some exception occured while closing the browser");
		}
	}
	
}
















