package testcases;

//import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.dataprovider.Dataprovider;
import com.pageobjects.HomePage;
import com.pageobjects.RegisterPage;
import com.utility.Log;

public class RegisterTest extends Base {
	HomePage home;
	RegisterPage registerpage;

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void before() {
		load_Config();
		launch_App();
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	/** 
	 * this method will be used by hashmap arguments 
	 */
	/*
	 * @Test(dataProvider = "registerdata",dataProviderClass = Dataprovider.class)
	 * public void register(HashMap<String, String>map) {
	 * 
	 * registerpage=home.ClickRegisterButton();
	 * registerpage.CompleteRegister(map.get("Gender"), map.get("FirstName"),
	 * map.get("LastName"), map.get("Date"), map.get("Month"), map.get("Year"),
	 * map.get("Email"), map.get("Password"), map.get("Re-password")); }
	 */
	 
	
	/**
	 * this method will pass the full register flow using dataprovider
	 * @param Gender
	 * @param fname
	 * @param lname
	 * @param date
	 * @param month
	 * @param year
	 * @param email
	 * @param pass
	 * @param re_pass
	 */
	  @Test(dataProvider = "registerdata",dataProviderClass = Dataprovider.class,groups={"Regression","Sanity"})
	  public void register(String Gender,String fname,String lname, String
	  date,String month,String year, String email,String pass,String re_pass){
		  Log.startTestCase("register");
	  home=new HomePage(); 
	  registerpage=home.ClickRegisterButton();
	  registerpage.CompleteRegister(Gender,fname,lname,date,month,year,email,pass,
	  re_pass);
	  boolean registersuccess=registerpage.registersuccesstext();
	  Assert.assertEquals(registersuccess, true);
	  registerpage.ClickContinueButton();
	  Assert.assertEquals(registerpage.gettitle(), prop.getProperty("homepagetitle"));
	  Log.endTestCase("register");
	  }
	 

}
