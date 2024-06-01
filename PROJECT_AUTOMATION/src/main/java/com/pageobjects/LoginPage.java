package com.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;

public class LoginPage extends Base {
	@FindBy(className = "email")WebElement email_field;
	@FindBy(className = "password")WebElement password_field;
	@FindBy(xpath = "//button[normalize-space()='Register']")WebElement register_btn;
	@FindBy(xpath = "//button[normalize-space()='Log in']")WebElement login_btn;
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")WebElement login_error;
	
	//Initializing webelements and driver object 
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//to access all the actions to perform created object for SeleniumactionsImplemented
	Seleniumactions action=new Seleniumactions();
	
	
	//actions to be performed 
	//todo add the guest loging button and there action,because it will come in without login buy flow
	public HomePage login(String email ,String password) {
		action.sendkeys(email_field, email);
		action.sendkeys(password_field, password);
		action.click(login_btn);
		action.switchtoalert();
		return new HomePage();
	}
	public RegisterPage register() {
		action.click(register_btn);
		return new RegisterPage();
	}
	public boolean errormsgDisplayed() {
		try {
			return action.isdisplayed(login_error);
		}
		catch (NoSuchElementException e) {
			System.err.println(e);
			return false;
		}
	}
	public String gettitle() {
		return action.gettitle();
	}
}
