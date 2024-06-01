package com.pageobjects;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;

public class ConfirmOrderPage extends Base {
	@FindBy(xpath = "//div[@id='confirm-order-buttons-container']//p[@class='back-link']//a[@href='#']")
	WebElement back_btn;
	@FindBy(xpath = "//button[normalize-space()='Confirm']")WebElement confirm_btn;
	@FindBy(xpath = "//a[normalize-space()='Click here for order details.']")WebElement order_detail_btn;
	@FindBy(xpath = "//button[normalize-space()='Continue']")WebElement continue_btn;

	
//Initializing webelements and driver object 	
	public ConfirmOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented	
	Seleniumactions action =new Seleniumactions();

//methods to perform 	
	public PaymentInfoPage ClickBack() {
		action.click(back_btn);
		return new PaymentInfoPage();
	}
	public void ClickConfirm() {
		action.click(confirm_btn);
	}
	//this button will display after order is confirmed 
	//todo we are getting sil error something that happen when js will refresh the element at the time of clicking handle this
	public HomePage ClickContinue() {
		//we are getting StaleElementException so used wait and the performed js click
		action.waitTillvisible(continue_btn);
		//JavascriptExecutor js= (JavascriptExecutor)getDriver();
		//js.executeScript("arguments[0].click();", continue_btn);//just a try with jsexecuter
		action.click(continue_btn);
		return new HomePage();
	}



}
