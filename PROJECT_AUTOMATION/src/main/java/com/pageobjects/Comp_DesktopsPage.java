package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;

public class Comp_DesktopsPage extends Base {
//product sorting (this is same for all sub product page)
	@FindBy(id = "products-orderby")WebElement sort_product_dropdown;
	@FindBy(id = "products-pagesize")WebElement page_sort_dropdown;
//product list buttons , 
	//todo-in this i added individual product button but use effesient way 
	@FindBy(xpath = "//div[@class='product-item' and @data-productid='1']/descendant::a")
	WebElement build_own_pc_btn;
	@FindBy(xpath = "//div[@class='product-item' and @data-productid='2']/descendant::a")
	WebElement vanquish_pc_btn;
	@FindBy(xpath = "//div[@class='product-item' and @data-productid='3']/descendant::a")
	WebElement lenovo_pc_btn;

//Initializing webelements and driver object 
	public Comp_DesktopsPage() {
		PageFactory.initElements(getDriver(), this);
	}
//to access all the actions to perform created object for SeleniumactionsImplemented
	Seleniumactions action=new Seleniumactions();

//actions to be performed 
	public void SortProduct(String sorttype) {
		action.SelectDropdown(sort_product_dropdown, sorttype);
	}
	public void PagenationCount(String pagecount) {
		action.SelectDropdown(page_sort_dropdown, pagecount);
	}
	public void ClickOwnComputer() {
		action.click(build_own_pc_btn);
	}
	public void ClickVanquishComputer() {
		action.click(vanquish_pc_btn);
	}
	public void ClickLenovoComputer() {
		action.click(lenovo_pc_btn);
	}
}

