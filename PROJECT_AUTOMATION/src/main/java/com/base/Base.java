package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static Properties prop;
	//public static WebDriver driver;
	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	/**
	 * in this below method we will be accessing the configurations of properties
	  files 1,create object for the properties file to access its key value
	  2,fileinputstream and property load method may have chance to throw error so
	  use try catch
	 */ 

	public void load_Config()  {
		prop=new Properties();
		System.out.println("super constructor invoked");
		FileInputStream ip;
		try {
			ip = new FileInputStream(".\\configurations\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			Log.error("FileNotFoundException");
		}
		catch (IOException e) {
			e.printStackTrace();
			Log.error("IOException");
		}	 
	} 
	/**
	 * this will get the driver instance 
	 * @return driver
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}

	/**in below method we will check which browser should launch our app
	 * here also we use property object to access the browser name, in this method itself we will send the url
	 * and maximize the browser 
	 */
	public void launch_App() {
		Log.info("------getting driver------");
		String browser_name=prop.getProperty("browsername");
		if(browser_name.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			driver.set(new ChromeDriver());
			System.out.println("driver- "+getDriver());
		}
		else if(browser_name.contains("firefox")){
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			driver.set(new FirefoxDriver());
			System.out.println("driver- "+getDriver());
		}
		else if(browser_name.contains("ie")){
			WebDriverManager.iedriver().setup();
			//driver=new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
			System.out.println("driver- "+getDriver());
		}
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
	}
	/**
	 * same as above method but we overloading with the parameter
	 * @param browsername
	 */
	public void launch_App(String browsername) {
		Log.info("------getting driver------");
		if(browsername.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			driver.set(new ChromeDriver());
			System.out.println("driver- "+getDriver());
		}
		else if(browsername.contains("firefox")){
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			driver.set(new FirefoxDriver());
			System.out.println("driver- "+getDriver());
		}
		else if(browsername.contains("ie")){
			WebDriverManager.iedriver().setup();
			//driver=new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
			System.out.println("driver- "+getDriver());
		}
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
	}

}

