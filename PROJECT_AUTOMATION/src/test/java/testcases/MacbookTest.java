package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.pageobjects.Comp_NotebookPage;
import com.pageobjects.ComputersPage;
import com.pageobjects.HomePage;
import com.pageobjects.NoteBookProductPage;
import com.utility.Log;

public class MacbookTest extends Base{
	HomePage home_page;
	ComputersPage computer_page;
	Comp_NotebookPage notebook;
	NoteBookProductPage product_page;
	
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
	 * this method will click macbook product and then enter quantity and verify the page title and success msg
	 */
	@Test(groups="Regression")
	public void addProductToCart() {
		Log.startTestCase("addProductToCart");
		home_page= new HomePage();
		notebook=home_page.clickNotebook();
		product_page=notebook.ClickMacbook();
		String productPage_title=product_page.gettitle();
		Assert.assertEquals(productPage_title,prop.getProperty("productpagetitle"));
		String Actual_productname=product_page.CheckProductName();
		product_page.EnterQuantity("2");
		Log.info("product quantity is entered");
		product_page.ClickAddToCart();
		String success_msg=product_page.ProdutAddedSuccessfully();
		Assert.assertEquals(success_msg, "The product has been added to your shopping cart");
		Assert.assertEquals(Actual_productname,prop.getProperty("productname")); 
		//productpage.ClickShoppingCart();
		Log.endTestCase("addProductToCart");
		
	}
}
 