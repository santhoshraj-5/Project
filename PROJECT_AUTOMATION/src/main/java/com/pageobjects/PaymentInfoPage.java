package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.SeleniumactionsImplemented;
import com.base.Base;

public class PaymentInfoPage extends Base {
	@FindBy(xpath = "(//button[contains(text(),'Continue')])[5]")WebElement continue_btn;
	@FindBy(xpath = "//div[@id='payment-info-buttons-container']//p[@class='back-link']//a[@href='#']")WebElement back_btn;
	
//Initializing webelements and driver object 
	public PaymentInfoPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//Initializing webelements and driver object 
	SeleniumactionsImplemented action= new SeleniumactionsImplemented();
	
	//actions to be performed 
	//To-do get the info text and validate 
	public PaymentMethodPage ClickBack() {
		action.click(back_btn);
		return new PaymentMethodPage();
	}
	public ConfirmOrderPage ClickContinue() {
		action.click(continue_btn);
		action.waitTillInvisibleofElement(continue_btn);
		return new ConfirmOrderPage();
	}

}
