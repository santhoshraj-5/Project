package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.pageobjects.ComputersPage;
import com.pageobjects.HomePage;
import com.utility.Log;

//@Listeners(com.utility.Listener.class)
public class ComputerPageTest extends Base {
	 HomePage home_page;
	ComputersPage computer_page;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	//String browser
	public void before(String browser) {
		load_Config();
		launch_App(browser);
		
	} 
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	/**
	 * this method will check the computer page 3 sub category images and text are present
	 */
	
	@Test(groups = "Smoke")
	public void checkImageAndTextPresent() {
		Log.startTestCase("checkImageAndTextPresent");
		 home_page=new HomePage();
		 computer_page= home_page.clickcomputer();
		 boolean des_img=computer_page.CheckDesktopimg();
		 Assert.assertEquals(des_img, true);
		 Log.info("desktop image checked");
		 boolean des_text= computer_page.CheckDesktopText();
		 Assert.assertEquals(des_text, true);
		 boolean note_img= computer_page.CheckNotebookimg();
		 Assert.assertEquals(note_img, true);
		 boolean note_text= computer_page.CheckNotebookText();
		 Assert.assertEquals(note_text, true);
		 boolean soft_img =computer_page.CheckSoftwareimg();
		 Assert.assertEquals(soft_img, true);
		 boolean soft_text= computer_page.CheckSoftwareText();
		 Assert.assertEquals(soft_text, true);
		 Log.info("all Image and text is checked");
		 Log.endTestCase("checkImageAndTextPresent");
	}
	
	/**
	 * this method we check the navigation of the 3 sub category and compare with the page urls
	 */
	@Test(groups = "Smoke")
	public void checkNavigation() {
		Log.startTestCase("checkNavigation");
		home_page=new HomePage();
		 computer_page= home_page.clickcomputer();
		computer_page.ClickDesktop();
		Assert.assertEquals(getDriver().getCurrentUrl(), prop.getProperty("desktop_url"));
		getDriver().navigate().back();
		computer_page.ClickNotebook();
		Assert.assertEquals(getDriver().getCurrentUrl(), prop.getProperty("notebook_url"));
		getDriver().navigate().back();
		computer_page.ClickSoftware();
		Assert.assertEquals(getDriver().getCurrentUrl(), prop.getProperty("software_url"));
		getDriver().navigate().back();
		Log.endTestCase("checkNavigation");
	}
}
