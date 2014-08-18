package com.hcf.validateorders;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hcf.pages.ConfirmationPage;
import com.hcf.pages.HomePage;
import com.hcf.testbase.TestBase;
import com.hcf.utilities.Reporter;

public class ApplicationTest extends TestBase {


	@BeforeClass
	public void beforeClass(ITestContext context) throws InterruptedException {
		//homePage = new HomePage(driver);
	}

	@Test()
	public void enterUniversityData() throws Exception {
		try {
		System.out.println("hello");
		} catch (Exception exception) {
			logErrorMessage(exception);
			Reporter.sendStatusToReport("UniversityForm", "134",
					"Validate confirmation message", "Fail",
					exception.getLocalizedMessage());
			throw exception;
		} 
	}
}
