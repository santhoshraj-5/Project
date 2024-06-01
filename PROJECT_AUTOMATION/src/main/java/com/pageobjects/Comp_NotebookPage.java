package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;

public class Comp_NotebookPage extends Base{
//product sorting
	@FindBy(id = "products-orderby")WebElement sort_product_dropdown;
	@FindBy(id = "products-pagesize")WebElement page_sort_dropdown;
//filter by attribute- core
	@FindBy(id = "attribute-option-6")WebElement intelcore_i5_checkbox;
	@FindBy(id="attribute-option-7")WebElement intelcore_i7_checkbox;
//filter by attribute- memory
	@FindBy(id = "attribute-option-8")WebElement gb_4_memory;
	@FindBy(id = "attribute-option-9")WebElement gb_8_memory;
	@FindBy(id = "attribute-option-10")WebElement gb_16_memory;
//Products 
	//todo- still 5 product is pending
	@FindBy(xpath = "//div[@class='product-item' and @data-productid='4']/descendant::a")WebElement macbook_btn;
	
	@FindBy(xpath = "//div[@class='products-container']/descendant::img")List<WebElement> allproduct_img;
	@FindBy(xpath = "//div[@class='products-container']/descendant::div[@class='product-item']/descendant::div[@class='prices']/child::*")List<WebElement> allproduct_price;
	
//Initializing webelements and driver object
	public Comp_NotebookPage() {
	PageFactory.initElements(getDriver(), this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented
	Seleniumactions action=new Seleniumactions();
	
//actions to perform
	public NoteBookProductPage ClickMacbook() {
		action.click(macbook_btn);
		return new NoteBookProductPage();
	}
	public boolean CheckallProductIMGDiaplayed() {
		Boolean imagedisplayed;
		int totalIMG=allproduct_img.size();
		int shownIMG=0;
		int defectIMg=0;
		for(WebElement produt_img:allproduct_img) {
			if(action.isdisplayed(produt_img)) {
				shownIMG++;
			}
			else {
				defectIMg++;
			}
		}
		if(totalIMG==shownIMG&&defectIMg==0) {
			imagedisplayed=true;
		}
		else {
			imagedisplayed=false;
		}
		return imagedisplayed;
	}
	public boolean CheckallProductpriceDisplayed() {
		Boolean pricedisplayed;
		int totalprice=allproduct_price.size();
		int shownIMG=0;
		int defectIMg=0;
		for(WebElement produt_price:allproduct_price) {
			if(action.isdisplayed(produt_price)) {
				shownIMG++;
			}
			else {
				defectIMg++;
			}
		}
		if(totalprice==shownIMG&&defectIMg==0) {
			pricedisplayed=true;
		}
		else {
			pricedisplayed=false;
		}
		return pricedisplayed;
	}
	
	
}
