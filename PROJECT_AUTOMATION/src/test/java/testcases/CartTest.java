package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.pageobjects.NoteBookProductPage;
import com.pageobjects.ShoppingCartPage;
import com.utility.Log;

public class CartTest extends Base {
	
	NoteBookProductPage productpage;
	ShoppingCartPage cartpage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		load_Config();
		launch_App(browser);
	} 
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	/**
	 * this method will check the price of the product with quantity and then move to checkout page
	 * this will use the macbook test method ,because we use the same procedure 
	 */
	@Test(groups = "Regression")
	public void checkCartProductprice() {
		Log.startTestCase("checkCartProductprice");
		MacbookTest macktest=new MacbookTest();
		macktest.producttest();
		productpage=new NoteBookProductPage();
		cartpage=productpage.ClickShoppingCart();
		Log.info("entered shopping cart");
		double price=cartpage.getFirstProductPrice();
		double quantity=cartpage.getQuantityOfFirstProduct();
		double expected_total=price*quantity;
		double actual_total=cartpage.getTotalPrice();
		System.out.println("product price -"+price+" quantity -"+quantity+" expected_total- "+expected_total);
		Log.info("got all the values and price in cart page");
		Assert.assertEquals(actual_total, expected_total);
		cartpage.ClickCheckout();
		Log.endTestCase("checkCartProductprice");
		
	}
}
