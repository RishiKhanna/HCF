package com.hcf.pages.locators;

import java.util.Properties;

import org.openqa.selenium.By;

import com.hcf.propertymgr.PropertyManager;

public class ConfirmationPageLocators {

	private final static Properties homeProperties = PropertyManager
			.loadApplicationPropertyFile("confirmation.properties");

	public static By confirmMessage = By.cssSelector(homeProperties.getProperty("confirmMessage"));
}

