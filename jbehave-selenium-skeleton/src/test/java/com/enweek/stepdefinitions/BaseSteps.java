package com.enweek.stepdefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseSteps {

	private static Properties properties;
	private static String browser;
	protected static WebDriver driver;

	static {
		populateProperties();
		if (browser.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.toLowerCase().contains("ie")) {
			driver = new InternetExplorerDriver();
		} else if (browser.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();
		}
	}

	private static void initializeProperties() {
		properties = new Properties();
		try {
			FileReader fileResource = new FileReader("test.properties");

			try {
				properties.load(fileResource);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		browser = properties.getProperty("browser");

	}

	private static void populateProperties() {

		if (properties == null) {
			initializeProperties();
		}

	}

	/**
	 * Add some formatting and extra info to an exception message to ease
	 * debugging and highlight exact point of failure
	 * 
	 * @param e
	 * @param message
	 */
	protected String decorateException(Exception e, String message) {
		String retVal;

		retVal = "\n\t----------------------------------------------------------------------------------------\n\n\t"
				+ e.getMessage()
				+ " \n\t"
				+ message
				+ " \n"
				+ "\n\t----------------------------------------------------------------------------------------\n";

		return retVal;
	}
}
