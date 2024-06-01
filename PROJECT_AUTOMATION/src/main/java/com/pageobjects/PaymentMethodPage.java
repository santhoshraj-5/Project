package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;

public class PaymentMethodPage extends Base{
	@FindBy(id = "paymentmethod_0")WebElement Check_payment_radio;
	@FindBy(xpath = "//div[@class='payment-logo']//label[@for='paymentmethod_1']") WebElement creditcard_radio;
	@FindBy(xpath = "//div[@id='payment-method-buttons-container']//p[@class='back-link']//a[@href='#']")
	WebElement back_btn;
	@FindBy(xpath = "(//button[contains(text(),'Continue')])[4]")WebElement continue_btn;

//Initializing webelements and driver object 
	public PaymentMethodPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented
	Seleniumactions action= new Seleniumactions();
	
//actions to be performed 
	//to do add check method 
	public PaymentInfoPage ClickContinue() {
		action.click(continue_btn);
		action.waitTillInvisibleofElement(continue_btn);
		return new PaymentInfoPage();
	}
	public ShippingMethodsPage ClickBack() {
		action.click(back_btn);
		return new ShippingMethodsPage();
	}

}
