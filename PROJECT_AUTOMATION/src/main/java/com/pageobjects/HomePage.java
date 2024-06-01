package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;

public class HomePage extends Base {
//Repeated element in all tab
	@FindBy(css = "img[alt='nopCommerce demo store']") WebElement logo;
	@FindBy(xpath = "//input[@id='small-searchterms']") WebElement search_bar;
	@FindBy(css = "button[type='submit']") WebElement search_bar_btn;
	@FindBy(className="ico-cart")  WebElement cart_btn;
	@FindBy(className="ico-wishlist")WebElement wishlist_btn;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")WebElement computer_btn;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Notebooks']")
	WebElement notebook_btn;

//before login extra buttons
	@FindBy(className="ico-register") WebElement register_btn;
	@FindBy(className="ico-login") WebElement login_btn;
	
//after login buttons
	@FindBy(className = "ico-account")WebElement accounts_btn;
	@FindBy(className = "ico-logout")WebElement logout_btn;
	
//Initializing webelements and driver object 
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented
	 Seleniumactions action=new Seleniumactions();
	
//actions to perform 
	public RegisterPage ClickRegisterButton() {
		action.click(register_btn);
		return new RegisterPage();
	}
	public LoginPage clickLoginPage() {
		action.click(login_btn);
		return new LoginPage();
	}
	public WhishListPage ClickWhisList() {
		action.click(wishlist_btn);
		return new WhishListPage();
	}
	public  ShoppingCartPage ClickMyCart() {
			action.click(cart_btn);
		return new ShoppingCartPage();
	}
	public void EnterProductToSearch(String product) {
		action.sendkeys(search_bar, product);
		action.click(search_bar_btn);
	}
	public MyAccountsPage ClickAccount() {
		action.click(accounts_btn);
		return new MyAccountsPage();
	}
	public void Clicklogout() {
		action.click(logout_btn);
	}
	public boolean ValidateLogo() {
		return action.isdisplayed(logo);
	}
	public String GetTitleOfHomePage() {
		return action.gettitle();
	}
	public ComputersPage clickcomputer(){
		action.click(computer_btn);
		return new ComputersPage();
	}
	public String gettitle() {
		return action.gettitle();
	}
	public Comp_NotebookPage clickNotebook() {
		action.mouseover(computer_btn);
		action.click(notebook_btn);
		return new Comp_NotebookPage();
	}
}
