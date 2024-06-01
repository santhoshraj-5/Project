package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;

public class ShippingMethodsPage extends Base{

	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']//p[@class='back-link']//a[@href='#']")
	WebElement back_btn;
	@FindBy(xpath = "(//button[contains(text(),'Continue')])[3]")WebElement continue_btn;
	@FindBy(id = "shippingoption_0")WebElement ground_radio_btn;
	@FindBy(id = "shippingoption_1")WebElement nextday_air_radio_btn;
	@FindBy(id = "shippingoption_2")WebElement day2_air_radio_btn;
	
//Initializing webelements and driver object
	public ShippingMethodsPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented
	Seleniumactions action=new Seleniumactions();
	
//actions to be performed 
	//todo add other modes of shipping methods
	public PaymentMethodPage ClickContinue() {
		action.click(continue_btn);
		action.waitTillInvisibleofElement(continue_btn);
		return new PaymentMethodPage();
	}
	public ShippingAddressPage ClickBack() {
		action.click(back_btn);
		return new ShippingAddressPage();
	}
}
