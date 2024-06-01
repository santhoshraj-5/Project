package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.actiondriver.SeleniumactionsImplemented;
import com.base.Base;

public class NoteBookProductPage extends Base  {
	/*
	 * for most of the product page this is common so in future we may change the name as general product page */

	//this is generic locator for all product ,add tocart and quantity
	@FindBy(css = "div[class='product-name'] h1")WebElement product_name;
	@FindBy(xpath = "//div[@class='add-to-cart']/descendant::input")WebElement product_quantity;
	@FindBy(xpath = "(//button[contains(text(),'Add to cart')])[1]")WebElement addtocart_btn;
	@FindBy(xpath = "//div[@class='product-price']/span")WebElement product_price;
	@FindBy(xpath = "//p[@class='content']")WebElement product_success_text;
	@FindBy(xpath = "//div[@class='bar-notification success']")WebElement notification;

//Initializing webelements and driver object
	public NoteBookProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented
	SeleniumactionsImplemented action=new SeleniumactionsImplemented();
	
//actions to be performed 
	//to-do handle when popup appear for some checkbox is not selected 
	public void EnterQuantity(String quantity) {
		action.sendkeys(product_quantity, quantity);
	}
	public void ClickAddToCart() {
		action.click(addtocart_btn); 
	}
	public String CheckProductName() {
		return action.gettext(product_name);
	}
	public ShoppingCartPage ClickShoppingCart() {
		HomePage product_home=new HomePage();
		action.waitTillInvisibleofElement(notification);
		product_home.ClickMyCart();
		return new ShoppingCartPage();
	}
	public String ProdutAddedSuccessfully() {
		return action.gettext(product_success_text);
	}
	public String gettitle() {
		return action.gettitle();
	}

}
