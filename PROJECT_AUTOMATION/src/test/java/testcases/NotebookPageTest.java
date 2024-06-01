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
import com.utility.Log;

public class NotebookPageTest extends Base {
	HomePage home_page;
	ComputersPage computer_page;
	Comp_NotebookPage notebook;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void before(String browser) {
		load_Config();
		launch_App(browser);}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	/**
	 * this method will verify the notebook page have all product image and price 
	 */
	
	@Test(groups="Smoke")
	public void computerTest() {
		Log.startTestCase("computerTest");
		home_page= new HomePage();
		computer_page=home_page.clickcomputer();
		String subcategory=computer_page.GetTextInSubCategory();
		System.out.println("subcategory of computers are-"+subcategory);
		System.out.println("count of sub category-"+computer_page.GetTotalSubCategory());
		notebook=computer_page.ClickNotebook();
		boolean allimagepresent=notebook.CheckallProductIMGDiaplayed();
		Assert.assertTrue(allimagepresent);
		boolean allpricedisplay=notebook.CheckallProductpriceDisplayed();
		Assert.assertTrue(allpricedisplay);
		Log.info("notebook page all image is present and text are present");
		Log.endTestCase("computerTest");
		}
}
