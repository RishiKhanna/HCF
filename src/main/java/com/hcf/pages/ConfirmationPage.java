package com.hcf.pages;

import static com.hcf.pages.locators.ConfirmationPageLocators.*;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.hcf.exceptions.WaitException;

public class ConfirmationPage extends PageBase {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateConfirmationMessage(String confirmationMsg) throws TimeoutException, WaitException {
		String actual = action.getText(VISIBILITY, confirmMessage);
		return compare.comparePartialText(actual, confirmationMsg);
	}
}

