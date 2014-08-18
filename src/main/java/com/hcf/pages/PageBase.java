package com.hcf.pages;

import org.openqa.selenium.WebDriver;

import com.hcf.actions.BrowserActions;
import com.hcf.actions.Comparator;
import com.hcf.utilities.Utilities;

public class PageBase {

	protected static final String VISIBILITY = "visibility";
	protected static final String PRESENCE = "presence";
	protected static final String CLICKABILITY = "clickability";

	protected BrowserActions action;
	protected Utilities util;
	protected Comparator compare;
	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver=driver;
		this.action= new BrowserActions(driver);
		util = new Utilities();
		compare = new Comparator();
	}

}
