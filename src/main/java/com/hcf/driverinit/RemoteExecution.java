package com.hcf.driverinit;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.hcf.utilities.Logg;

public class RemoteExecution {

	private static Logger log = Logg.createLogger();

	private RemoteExecution() {
	}

	public static WebDriver getRemoteDriver(Server server) {
		WebDriver driver = null;
		DesiredCapabilities capabilities = Capabilities.setAppiumCapability();
		try {
			driver = new RemoteWebDriver(new URL("http://"+server.getGridAddress()+":"+server.getPortNumber()+"/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
		
}
