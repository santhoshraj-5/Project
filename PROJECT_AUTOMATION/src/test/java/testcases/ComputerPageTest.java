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
	 HomePage homepage;
	ComputersPage computerpage;
	
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
		 homepage=new HomePage();
		 computerpage= homepage.clickcomputer();
		 boolean des_img=computerpage.CheckDesktopimg();
		 Assert.assertEquals(des_img, true);
		 Log.info("desktop image checked");
		 boolean des_text= computerpage.CheckDesktopText();
		 Assert.assertEquals(des_text, true);
		 boolean note_img= computerpage.CheckNotebookimg();
		 Assert.assertEquals(note_img, true);
		 boolean note_text= computerpage.CheckNotebookText();
		 Assert.assertEquals(note_text, true);
		 boolean soft_img =computerpage.CheckSoftwareimg();
		 Assert.assertEquals(soft_img, true);
		 boolean soft_text= computerpage.CheckSoftwareText();
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
		homepage=new HomePage();
		 computerpage= homepage.clickcomputer();
		computerpage.ClickDesktop();
		Assert.assertEquals(getDriver().getCurrentUrl(), prop.getProperty("desktop_url"));
		getDriver().navigate().back();
		computerpage.ClickNotebook();
		Assert.assertEquals(getDriver().getCurrentUrl(), prop.getProperty("notebook_url"));
		getDriver().navigate().back();
		computerpage.ClickSoftware();
		Assert.assertEquals(getDriver().getCurrentUrl(), prop.getProperty("software_url"));
		getDriver().navigate().back();
		Log.endTestCase("checkNavigation");
	}
}
