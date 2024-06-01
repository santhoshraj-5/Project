package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;

public class ShippingAddressPage extends Base {
	//todo add the shipping address all elements 
	@FindBy(id = "shipping-address-select")WebElement previous_address_dropdown;
	@FindBy(xpath = "//div[@id='shipping-buttons-container']//p[@class='back-link']//a[@href='#']")
	WebElement back_btn;
	@FindBy(xpath = "//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Shipping.save()']")
	WebElement continue_btn;
	
//Initializing webelements and driver object 	
	public ShippingAddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented	
	Seleniumactions action=new Seleniumactions();
	
//actions need to be performed
	public ShippingMethodsPage ClickContinue() {
		action.click(continue_btn);
		action.waitTillInvisibleofElement(continue_btn);
		return new ShippingMethodsPage();

	}
	public BillingAddressPage ClickBack() {
		action.click(back_btn);
		return new BillingAddressPage();
	}

}
