package com.actiondriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebElement;

public interface Seleniumaction {
	void click(WebElement element);
	void sendkeys(WebElement element, String value);
	void appendtext(WebElement element,String value);
	String geturl();
	String gettitle();
	File take_screenshot(String path) throws IOException;
	boolean isdisplayed(WebElement element);
	void SelectDropdown(WebElement element,String value);
	void mouseover(WebElement element);
	boolean waitTillvisible(WebElement element);
	boolean waitTillInvisibleofElement(WebElement element);
	void switchtoalert();
	String gettext(WebElement element);
}
