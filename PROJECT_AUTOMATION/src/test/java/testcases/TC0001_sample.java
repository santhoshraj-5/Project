package testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
/*import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;*/
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.pageobjects.BillingAddressPage;
import com.pageobjects.Comp_NotebookPage;
import com.pageobjects.ComputersPage;
import com.pageobjects.ConfirmOrderPage;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.pageobjects.NoteBookProductPage;
import com.pageobjects.PaymentInfoPage;
import com.pageobjects.PaymentMethodPage;
import com.pageobjects.RegisterPage;
import com.pageobjects.ShippingAddressPage;
import com.pageobjects.ShippingMethodsPage;
import com.pageobjects.ShoppingCartPage;

public class TC0001_sample extends Base {
	HomePage home;
	RegisterPage regpg;
	LoginPage loginpage;
	ComputersPage computerpage;
	Comp_NotebookPage comp_notbook;
	NoteBookProductPage productpage;
	ShoppingCartPage cartpage;
	BillingAddressPage billingaddress;
	ShippingAddressPage shippingadrs;
	ShippingMethodsPage shippmethod;
	PaymentMethodPage paymethod;
	PaymentInfoPage Payinfo;
	ConfirmOrderPage conforder;

	@BeforeMethod
	public void before() {
		load_Config();
		launch_App();
	}

	@Test
	public void test() {

		home = new HomePage();
		System.out.println(home.ValidateLogo());
		
		  home.ClickRegisterButton(); regpg = new RegisterPage();
		  regpg.EnterFirstAndLastName("santhosh", "raj"); regpg.EnterDateOfBirth("5",
		  "March", "2000"); regpg.SelectGender("male");
		  regpg.EnterEmailId("santa@gmail.com"); regpg.EnterPassword("123456");
		  regpg.EnterConfirmPassword("123456"); regpg.ClickRegisterButton(); home =
		  regpg.ClickContinueButton();
		 
			/*
			 * loginpage = home.clickLoginPage();// if register success dont want login home
			 * = loginpage.login("santa@gmail.com", "123456");
			 */
		computerpage = home.clickcomputer();
		comp_notbook = computerpage.ClickNotebook();
		productpage = comp_notbook.ClickMacbook();
		System.out.println(productpage.CheckProductName());
		productpage.ClickAddToCart();
		cartpage = productpage.ClickShoppingCart();
		billingaddress = cartpage.ClickCheckout();
		
		
		  billingaddress.EnterFirstName("santhosh");
		  billingaddress.EnterLasttName("raj");
		  billingaddress.EnterEmail("santa@gmail.com");
		  billingaddress.Entercountry("India"); billingaddress.EnterCity("chennai");
		  billingaddress.EnterAddress("asdsaf"); billingaddress.EnterPincode("123456");
		  billingaddress.EnterPhoneNumber("123456789");//if already adress dont entry this
		 		 		  
		  shippmethod = billingaddress.ClickContinue_shipmethod();
		//shippmethod=shippingadrs.ClickContinue();
		paymethod = shippmethod.ClickContinue();
		Payinfo = paymethod.ClickContinue();
		conforder = Payinfo.ClickContinue();
		conforder.ClickConfirm();
		conforder.ClickContinue();

	}
	
	  @AfterMethod 
	  public void takescreenshot(ITestResult result) {
	  if(result.FAILURE==result.getStatus()) {
		  TakesScreenshot ss=(TakesScreenshot)getDriver(); 
		  File source=ss.getScreenshotAs(OutputType.FILE);
	  File destination=new File("./screenshots/"+result.getName()+".png"); 
	  try {
	  FileHandler.copy(source, destination); }
	  catch (IOException e) { // TODOAuto-generated catch block 
	  e.printStackTrace(); } } }
	 

}
