package com.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;
import com.utility.Log;

public class BillingAddressPage extends Base {
//if initially we dont have any address we need to fill the all required field 
	@FindBy(id = "BillingNewAddress_FirstName")WebElement firstname_field;
	@FindBy(id="BillingNewAddress_LastName")WebElement lastname_field;
	@FindBy(id = "BillingNewAddress_Email")WebElement email_field;
	@FindBy(id="BillingNewAddress_CountryId")WebElement country_dropdown;
	@FindBy(id="BillingNewAddress_City")WebElement city_field;
	@FindBy(id="BillingNewAddress_Address1")WebElement adrdress_field;
	@FindBy(id="BillingNewAddress_ZipPostalCode")WebElement postalcod_field;
	@FindBy(id="BillingNewAddress_PhoneNumber")WebElement ph_no_field;

//if already we have address we will be showing this 2 buttons edit and delete 
	@FindBy(id = "edit-billing-address-button")WebElement edit_address_btn;
	@FindBy(id = "delete-billing-address-button")WebElement delete_address_btn;
	//dropdown element is missing missing

//this continue button and ship to same address drop down will be common for all scenario 
	@FindBy(xpath = "(//button[contains(text(),'Continue')])[1]")
	WebElement continue_btn;
	@FindBy(xpath ="//input[@type='checkbox']")WebElement ship_same_addr_checkbox;

//Initializing webelements and driver object 
	public BillingAddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

//to access all the actions to perform created object for SeleniumactionsImplemented
	Seleniumactions action=new Seleniumactions();
//this is for getting the same shipping address should come or not
	boolean same_shipping=true;

//methods to perform 
	//todo -validate if already address present or not handle that error
	//-handle direction to shipping address or not
	public void EnterFirstName(String firstname) {
		action.sendkeys(firstname_field, firstname);
	}
	public void EnterLasttName(String lastname) {
		action.sendkeys(lastname_field, lastname);
	}
	public void EnterEmail(String emailid) {
		action.sendkeys(email_field, emailid);
	}
	public void Entercountry(String country) {
		action.SelectDropdown(country_dropdown, country);
	}
	public void EnterAddress(String address) {
		action.sendkeys(adrdress_field, address);
	}
	public void EnterPincode(String pincode) {
		action.sendkeys(postalcod_field, pincode);
	}
	public void EnterPhoneNumber(String phone) {
		action.sendkeys(ph_no_field, phone);
	}
	public void EnterCity(String city) {
		action.sendkeys(city_field, city);
	}
	
	private boolean isaddresspresent() {
		boolean editbutton = false;
		try {
		editbutton= action.isdisplayed(edit_address_btn);}
		catch (NoSuchElementException e) {
			System.err.println(e);
		}
		
		return editbutton;
	}
	
	public void completeBilling(String firstname,String lastname,String emailid,String country,String city,String address,String pincode
			,String phone) {
		if(!isaddresspresent()) {
		EnterFirstName(firstname);
		Log.info("firstname entered");
		EnterLasttName(lastname);
		Log.info("lastname entered");
		EnterEmail(emailid);
		Log.info("emailid entered");
		Entercountry(country);
		Log.info("country entered");
		EnterAddress(address);
		Log.info("address entered");
		EnterPincode(pincode);
		Log.info("pincode");
		EnterPhoneNumber(phone);
		Log.info("phone");
		EnterCity(city);
		Log.info("city");
		}
	}

	/*
	 * public void ClickContinue1() { if(same_shipping) {
	 * action.click(continue_btn); return new ShippingMethodsPage();//if check box
	 * is selected it will jump to shipping method } else {
	 * action.click(continue_btn); return new ShippingAddressPage();//if check box
	 * is selected it will jump to shipping method } }
	 */
	public ShippingAddressPage ClickContinue() {
		action.click(continue_btn);
		action.waitTillInvisibleofElement(continue_btn);
		return new ShippingAddressPage();//if check box is not selected it will jump to shipping address
	}
	public ShippingMethodsPage ClickContinue_shipmethod() {
		action.click(continue_btn);
		action.waitTillInvisibleofElement(continue_btn);
		return new ShippingMethodsPage();//if check box is selected it will jump to shipping method
	}

}
