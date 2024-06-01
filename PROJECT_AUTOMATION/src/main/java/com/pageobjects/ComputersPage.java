package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Seleniumactions;
import com.base.Base;

public class ComputersPage extends Base  {
	@FindBy(className = "item-box") List<WebElement> computer_sub_category;
	@FindBy(className = "item-grid") List<WebElement> computer_sub_category_text;
	@FindBy(xpath = "//a[@title='Show products in category Desktops'][normalize-space()='Desktops']")
	WebElement Desktops_text;
	@FindBy(xpath = "//a[@title='Show products in category Notebooks'][normalize-space()='Notebooks']")
	WebElement Notebooks_text;
	@FindBy(xpath = "//a[@title='Show products in category Software'][normalize-space()='Software']")
	WebElement software_text;
	@FindBy(xpath = "//img[@title='Show products in category Software']")WebElement software_img;
	@FindBy(xpath = "//img[@title='Show products in category Notebooks']")WebElement Notebooks_img;
	@FindBy(xpath = "//img[@title='Show products in category Desktops']")WebElement Desktops_img;

//Initializing webelements and driver object 
	public ComputersPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
//to access all the actions to perform created object for SeleniumactionsImplemented
	Seleniumactions action = new Seleniumactions();
	
//actions to be performed 
	public int GetTotalSubCategory() {
		return computer_sub_category.size();
	}
	public String GetTextInSubCategory() {
		String cat=null;
		for(WebElement category:computer_sub_category_text) {
			  cat=category.getText();
		}
		return cat;
	}
	public boolean CheckDesktopText() {
		return action.isdisplayed(Desktops_text);
	}
	public boolean CheckNotebookText() {
		return action.isdisplayed(Notebooks_text);
	}
	public boolean CheckSoftwareText() {
		return action.isdisplayed(software_text);
	}
	public boolean CheckDesktopimg() {
		return action.isdisplayed(Desktops_img);
	}
	public boolean CheckNotebookimg() {
		return action.isdisplayed(Notebooks_img);
	}
	public boolean CheckSoftwareimg() {
		return action.isdisplayed(software_img);
	}
	public Comp_DesktopsPage ClickDesktop() {
		action.click(Desktops_img);
		return new Comp_DesktopsPage();
	}
	public Comp_NotebookPage ClickNotebook() {
		action.click(Notebooks_img);
		return new Comp_NotebookPage();
	}
	public Comp_softwarePage ClickSoftware() {
		action.click(software_img);
		return new Comp_softwarePage();
	}
}
