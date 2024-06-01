package com.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.SeleniumactionsImplemented;
import com.base.Base;

public class RegisterPage extends Base{
	@FindBy(id = "gender-male")WebElement maleradio_btn;
	@FindBy(id = "gender-female")WebElement femailradio_btn;
	@FindBy(id = "FirstName")WebElement firstname_field;
	@FindBy(id = "LastName")WebElement lastname_field;
	@FindBy(name = "DateOfBirthDay")WebElement dob_date;
	@FindBy(name = "DateOfBirthMonth")WebElement dob_month;
	@FindBy(name = "DateOfBirthYear")WebElement dob_year;
	@FindBy(id = "Email")WebElement email_field;
	@FindBy(id = "Password")WebElement password_field;
	@FindBy(id = "ConfirmPassword")WebElement confirmpassword_field;
	@FindBy(id = "register-button")WebElement registeruser_btn;
	@FindBy(xpath = "//a[normalize-space()='Continue']")WebElement continue_btn;
	@FindBy(className = "result")WebElement register_success_text;
	@FindBy(xpath = "//li[contains(text(),'email already exists')]")WebElement email_exist_popup;
	@FindBy(xpath = "//img[contains(@alt,'nopCommerce demo store')]/parent::a")WebElement logo;

//Initializing webelements and driver object 
	public RegisterPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented
	SeleniumactionsImplemented action = new SeleniumactionsImplemented();
	/** 
	 * @param gender-enter male or female
	 */
	public void SelectGender(String gender) {
		if(gender.equalsIgnoreCase("male")) {
			action.click(maleradio_btn);
		}
		else if (gender.equalsIgnoreCase("female")){
			action.click(femailradio_btn);
		}
		else { 
			System.out.println("check the gender your are given");
		}
	}
	/**
	 * @param first-enter the first name
	 * @param last-enter the last name
	 */
	public void EnterFirstAndLastName(String first,String last) {
		action.sendkeys(firstname_field, first);
		action.sendkeys(lastname_field, last);
	}
	/**
	 * @param date
	 * @param month
	 * @param year
	 */
	public void EnterDateOfBirth(String date, String month,String year ) {
		action.SelectDropdown(dob_date, date);
		action.SelectDropdown(dob_month, month);
		action.SelectDropdown(dob_year, year);
	}
	public void EnterEmailId(String email) {
		action.sendkeys(email_field, email);
	}
	public void EnterPassword(String pass) {
		action.sendkeys(password_field, pass);
	}
	public void EnterConfirmPassword(String re_pass) {
		action.sendkeys(confirmpassword_field, re_pass);
	}
	public void ClickRegisterButton() {
		action.click(registeruser_btn);
		action.switchtoalert();
	}
	
	public HomePage CompleteRegister(String Gender,String fname,String lname,
			String date,String month,String year,
			String email,String pass,String re_pass) {
		SelectGender(Gender);
		EnterFirstAndLastName(fname,lname);
		EnterDateOfBirth(date,month,year);
		EnterEmailId(email);
		EnterPassword(pass);
		EnterConfirmPassword(re_pass);
		ClickRegisterButton();
		return new HomePage();
		
	}
	public HomePage ClickContinueButton() {
		try {
			if(register_success_text.getText().equalsIgnoreCase("Your registration completed")) {
				action.click(continue_btn);
				return new HomePage();
			}}
		catch(NoSuchElementException noele){
			noele.getMessage();
			action.click(logo);
			return new HomePage();
		}
		return null;
	}
	public boolean registersuccesstext() {
		return action.isdisplayed(register_success_text);
	}
	public String gettitle() {
		return action.gettitle();
	}
}
