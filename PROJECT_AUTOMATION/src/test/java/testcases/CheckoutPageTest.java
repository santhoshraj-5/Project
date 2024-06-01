package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.dataprovider.Dataprovider;
import com.pageobjects.BillingAddressPage;
import com.pageobjects.Comp_NotebookPage;
import com.pageobjects.ConfirmOrderPage;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.pageobjects.NoteBookProductPage;
import com.pageobjects.PaymentInfoPage;
import com.pageobjects.PaymentMethodPage;
import com.pageobjects.ShippingMethodsPage;
import com.pageobjects.ShoppingCartPage;
import com.utility.Log;

public class CheckoutPageTest extends Base {
	HomePage home_page;
	LoginPage login_page;
	Comp_NotebookPage notebook_page;
	NoteBookProductPage product;
	ShoppingCartPage cart_page;
	BillingAddressPage bill_address;
	ShippingMethodsPage shipping_method;
	PaymentMethodPage payment_method;
	PaymentInfoPage payment_info;
	ConfirmOrderPage order_conf_page;
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
	 * this test will login and add a product o cart and complete full order process
	 * @param firstname
	 * @param lastname
	 * @param emailid
	 * @param country
	 * @param city
	 * @param address
	 * @param pincode
	 * @param phone
	 */
	@Test(dataProvider = "billingaddress",dataProviderClass = Dataprovider.class,groups = "Regression")
	public void completeOrder(String firstname,String lastname,String emailid,String country,String city,String address,
			String pincode,String phone) {
		Log.startTestCase("completeOrder");
		LoginTest login=new LoginTest();
		login.loginTestpostive();
		home_page=new HomePage();
		notebook_page=home_page.clickNotebook();
		product=notebook_page.ClickMacbook();
		product.ClickAddToCart();
		cart_page=product.ClickShoppingCart();
		bill_address=cart_page.ClickCheckout();
		bill_address.completeBilling(firstname,lastname,emailid,country,city,address,pincode,phone);
		Log.info("billing address is filled");
		shipping_method=bill_address.ClickContinue_shipmethod();
		payment_method=shipping_method.ClickContinue();
		Log.info("shipping method is clicked");
		payment_info=payment_method.ClickContinue();
		Log.info("payment method is complete");
		order_conf_page=payment_info.ClickContinue();
		order_conf_page.ClickConfirm();
		Log.endTestCase("completeOrder");
		
	}
}
