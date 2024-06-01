package testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.Base;
import com.dataprovider.Dataprovider;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.utility.Log;

public class LoginTest extends Base {
	HomePage home_page;
	LoginPage login_page;
	
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
	 * in this below test we will be passing both positive and negative test case
	 * for login page this application will destroy the existing email password so
	 * always first register method should be called and then this method
	 * 
	 * @param Email
	 * @param Password
	 */

	@Test(dataProvider = "loginsenarious", dataProviderClass = Dataprovider.class,groups = "Sanity")
	public void loginTest(String Email, String Password) {
		Log.startTestCase("loginTest");
		home_page = new HomePage();
		login_page = home_page.clickLoginPage();
		home_page = login_page.login(Email, Password);
		Log.info("user password and email is entered");
		String actualtitle = login_page.gettitle();
		String expectedtitle = prop.getProperty("homepagetitle");
		boolean error = login_page.errormsgDisplayed();

		/**
		 * we will we having only two scenario 1,successful login and the title of the
		 * page will be changed 2,unsuccessful login and the error msg should come so we
		 * fist check the error is true and validate the test , if not we check whether
		 * the title has be changed and validate the test
		 */
		if (error) {
			Assert.assertTrue(error);
		} else {
			Assert.assertEquals(actualtitle, expectedtitle);
		}
		Log.endTestCase("loginTest");

	}
	
	/*
	 * this is only the positive mailid
	 */
	  @Test(groups="Regression")
	   public void loginTestpostive() { 
		  Log.startTestCase("loginTestpostive");
		  home_page = new HomePage(); 
		  login_page = home_page.clickLoginPage();
		  home_page =login_page.login("santa@gmail.com", "123456"); 
		  Log.info("user password and email is entered");
		  String actualtitle = login_page.gettitle();
		  System.out.println(actualtitle); 
		  String expectedtitle =prop.getProperty("homepagetitle"); 
		  Assert.assertEquals(actualtitle, expectedtitle);
		  Log.endTestCase("loginTestpostive");
	  }


}
