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
	HomePage homepage;
	ComputersPage computerpage;
	Comp_NotebookPage notebook;
	NoteBookProductPage productpage;
	
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
	public void producttest() {
		Log.startTestCase("producttest");
		homepage= new HomePage();
		notebook=homepage.clickNotebook();
		productpage=notebook.ClickMacbook();
		String productPage_title=productpage.gettitle();
		Assert.assertEquals(productPage_title,prop.getProperty("productpagetitle"));
		String Actual_productname=productpage.CheckProductName();
		productpage.EnterQuantity("2");
		Log.info("product quantity is entered");
		productpage.ClickAddToCart();
		String success_msg=productpage.ProdutAddedSuccessfully();
		Assert.assertEquals(success_msg, "The product has been added to your shopping cart");
		Assert.assertEquals(Actual_productname,prop.getProperty("productname")); 
		//productpage.ClickShoppingCart();
		Log.endTestCase("producttest");
		
	}
}
 