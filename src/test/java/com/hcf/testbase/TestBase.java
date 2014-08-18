package com.hcf.testbase;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.hcf.driverinit.Server;
import com.hcf.driverinit.RemoteExecution;
import com.hcf.propertymgr.PropertyManager;
import com.hcf.utilities.ExcelRead;
import com.hcf.utilities.Logg;
import com.hcf.utilities.Reporter;
import com.hcf.utilities.Utilities;

public class TestBase {
	protected WebDriver driver;
	private final Properties frameworkProperty = PropertyManager
			.loadFrameworkPropertyFile("framework.properties");
	protected static Reporter report = new Reporter();
	protected final Logger log = Logg.createLogger();
	protected final static Utilities util = new Utilities();
	protected static String[][] strorage = null;
	private final Properties applicationProperty = PropertyManager
			.loadApplicationPropertyFile("application.properties");

	protected void logErrorMessage(Throwable ex) {
		StringWriter stw = new StringWriter();
		PrintWriter pw = new PrintWriter(stw);
		ex.printStackTrace(pw);
		log.error(stw.toString());
	}

	@DataProvider(name = "ReadExcel")
	public String[][] readDataFromExcel(Method m) {
		log.info(Utilities.getCurrentThreadId() + "Data Provider: Read Excel");
		log.info(Utilities.getCurrentThreadId()
				+ "Data Provider: Running for Method: " + m.getName());
		if ("enterUniversityData".equals(m.getName())) {
			strorage = ExcelRead.readTestData("Customer");
			log.info(Utilities.getCurrentThreadId()
					+ "Data Provider: Retrieved data from the Customer Sheet of Test Data Excel");
		} else if ("".equals(m.getName())) {
			strorage = ExcelRead.readTestData("Sheet2");
		}
		return strorage;
	}

	@BeforeTest
	public void beforeTest(ITestContext context) {
		Server server = new Server("127.0.0.1", "4723");
		driver = RemoteExecution.getRemoteDriver(server);
	}

	@AfterTest
	public void afterMethod(ITestContext context) throws InterruptedException {
	}
}