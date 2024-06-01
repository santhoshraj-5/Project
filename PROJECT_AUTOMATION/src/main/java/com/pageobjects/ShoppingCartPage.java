package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.SeleniumactionsImplemented;
import com.base.Base;

public class ShoppingCartPage extends Base{
	@FindBy(id = "checkout_attribute_1")WebElement gift_wrapping_dropdown;
	@FindBy(xpath = "//input[@id='termsofservice']")WebElement terms_checkbox;
	@FindBy(id = "checkout")WebElement checkout_btn;
	@FindBy(xpath = "//table[@class='cart']//tbody//tr[1]//span[@class='product-unit-price']")WebElement unit_price;
	@FindBy(xpath = "//table[@class='cart']//tbody//tr[1]//input[@type='text']")WebElement quantity_first;
	@FindBy(xpath = "//table[@class='cart']//tbody//tr[1]//span[@class='product-subtotal']")WebElement total_price;
	
//Initializing webelements and driver object
	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented
	SeleniumactionsImplemented action=new SeleniumactionsImplemented();

	//todo- add remove edit functionality of cart page using table ....only first product is done we need to for dynamic product
	public BillingAddressPage ClickCheckout() {
		action.click(terms_checkbox);
		action.click(checkout_btn);
		return new BillingAddressPage();//if there is no login send page to login page
	}
	private double priceConverter(String price,String type) {
		double finalprice;
		String filtered_price=price.replaceAll("[^a-zA-Z0-9]", "");
		double Double_Price=Double.parseDouble(filtered_price);
		if(type.equalsIgnoreCase("price")) {
			finalprice =Double_Price/100;
		}
		else{
			finalprice =Double_Price;
		}
		
		return finalprice;
	}
	public double getFirstProductPrice() {
		String unitprice=action.gettext(unit_price);
		return priceConverter(unitprice,"price");
		
	}
	public double getQuantityOfFirstProduct() {
		String quantity=quantity_first.getAttribute("value");
		return priceConverter(quantity,"quantity");
	}
	public double getTotalPrice() {
		String totalprice=action.gettext(total_price);
		return priceConverter(totalprice,"price");
	}

}
