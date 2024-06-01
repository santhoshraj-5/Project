package com.actiondriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;

public class SeleniumactionsImplemented extends Base implements SeleniumactionInterface {
	Actions action;
	WebDriverWait wait;

	/**
	 * @param element this method will be used to click the webelement we pass
	 */
	@Override
	public void click(WebElement element) {
		boolean flag = false;
		try {
			if (isdisplayed(element)) {
				element.click();
				flag = true;
			}
		}
		/*
		 * catch(Exception error) { System.err.println(error.getMessage()); }
		 */
		finally {
			if (!flag) {
				System.out.println("The element is Not Clicked");
			}
			// for this if we use flag true means we are getting more sysout for every
			// success so i use not a flag in if condition
			/*
			 * else { System.out.println("The element is Not Clicked"); }
			 */
		}
	}

	
	/**
	 * @param element
	 * @param value   this method will be used to type text in the field we give
	 */

	@Override
	public void sendkeys(WebElement element, String value) {
		boolean flag = false;
		try {
			if (isdisplayed(element)) {
				element.clear();
				element.sendKeys(value);
				flag = true;
			}
		}
		/*
		 * catch(Exception error ) { System.err.println(error.getMessage()); }
		 */
		finally {
			if (!flag) {
				System.out.println("Unable to enter value");
			}
			/*
			 * else { System.out.println("Unable to enter value"); }
			 */
		}
	}

	
	/**
	 * @param element
	 * @param value   this method will be used to type text without clearing
	 *                previous text in the field we give
	 */
	@Override
	public void appendtext(WebElement element, String value) {
		boolean flag = false;
		try {
			if (isdisplayed(element)) {
				element.sendKeys(value);
				flag = true;
			}
		}
		/*
		 * catch(Exception error ) { System.err.println(error.getMessage()); }
		 */
		finally {
			if (!flag) {
				System.out.println("Unable to enter value");
			}
			/*
			 * else { System.out.println("Unable to enter value"); }
			 */
		}
	}

	
	/**
	 * this method will be used to get the currentpage url
	 */
	@Override
	public String geturl() {
		return getDriver().getCurrentUrl();
	}

	
	/**
	 * this method will be used to get the title of the current page
	 */
	@Override
	public String gettitle() {
		return getDriver().getTitle();
	}

	
	/**
	 * @param screenshotname this method will be used to take screenshot
	 */
	@Override
	public void take_screenshot(String screenshotname) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File screen_path = ss.getScreenshotAs(OutputType.FILE);
		File destinatio = new File("./screenshots/" + screenshotname+".png");
		FileHandler.copy(screen_path, destinatio);
	}

	
	/**
	 * @param element this method will give boolean of a specified element is
	 *                displayed or not
	 */
	//need to remove explicitly wait because for display method some time we dont want to see error only for negative case we check
	@Override
	public boolean isdisplayed(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {
				flag = true;
			}
		}
		
		 // catch (Exception error) { System.err.println(error.getMessage()); }
		 
		finally {
			if (!flag) {
				System.out.println("The element is Not Displayed");
			}
			/*
			 * else { System.out.println("The element is Not Displayed"); }
			 */
		}
		return flag;
	}

	
	/**
	 * @param element
	 * @param value   here we used only select by visible text method s
	 */
	@Override
	public void SelectDropdown(WebElement element, String value) {
		boolean flag=false;
		try {
			if(isdisplayed(element)) {
				Select sc = new Select(element);
				sc.selectByVisibleText(value);
				flag=true;
			}
		}
		finally {
			if(!flag) {
				System.out.println("The Dropdown is not selected");
			}
		}
	}

	
	/**
	 * @param element
	 * this method will wait till the given element is present within specified time
	 */
	@Override
	public boolean waitTillvisible(WebElement element) {
		boolean flag=false;
			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			wait.withMessage("The element is Not visible").until(ExpectedConditions.visibilityOf(element));
			flag=true;
			return flag;
		}
		

	/**
	 * @param element this method will perform mouse over operation to the specified
	 *                element
	 */
	@Override
	public void mouseover(WebElement element) {
		boolean flag=false;
		try {
			if(isdisplayed(element)) {
				action = new Actions(getDriver());
				action.moveToElement(element).perform();
				flag=true;
			}
		}
		finally {
			if(!flag) {
				System.out.println("The mouseover is not selected");
			}
		}
	}
		

	/**
	 * this method will check the alert is present or not and the switch to alert
	 * tab
	 */
	@Override
	public void switchtoalert() {
		if (isAlertPresent()) // wait.until(ExpectedConditions.alertIsPresent()) != null
		{
			Alert alt = getDriver().switchTo().alert();
			alt.accept();
		}
	}
	private boolean isAlertPresent() {
		try {
			getDriver().switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	} // isAlertPresent()


	@Override
	public String gettext(WebElement element) {
		String text;
		if(isdisplayed(element)) {
			text=element.getText();
		}
		else {
			text="element not present";
		}
		return text;
		
		
		
	}


	@Override
	public boolean waitTillInvisibleofElement(WebElement element) {
		boolean flag=false;
	    wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
		flag=true;
		return flag;
	}

}
