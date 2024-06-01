package com.dataprovider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.utility.ExcelReader;

public class Dataprovider {
	ExcelReader exlreader=new ExcelReader();
	
	/**
	 * this method is used for reading both positive and negative test case in login
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "loginsenarious")
	public String[][] loginsenarious() throws IOException{
		String[][] exldata=exlreader.readxl("login_allcase_data");
		return exldata;
	}


	/*
	 * @DataProvider(name = "registerdata") public Object[][] registerdata() throws
	 * IOException{ String[][]regdata=exlreader.readxl("register_data"); Object[][]
	 * data = new Object[regdata.length-1][0]; System.out.println(regdata.length
	 * +"--row count"); System.out.println(regdata[0].length +"--cell count");
	 * for(int i=1;i<regdata.length-1;i++) { Map<String, String>hashmap= new
	 * HashMap<>(); for(int j=0;j<regdata[0].length;j++) {
	 * hashmap.put(regdata[0][j], regdata[i][j]); } data[i-1][0]=hashmap;
	 * 
	 * }
	 * 
	 * 
	 * return data; }
	 */

	/**
	 * this method will read the register data (as of now we have only one data
	 * @return
	 * @throws IOException
	 */
	  @DataProvider(name = "registerdata") 
	  public Object[][] registerdata() throws IOException{ 
		  String[][]regdata=exlreader.readxl("register_data"); 
		  return regdata; }
	  
	  @DataProvider(name="billingaddress")
	  public Object[][] billingaddress()throws IOException{
		  String[][] address=exlreader.readxl("Billing_Address");
		  return address;
	  }
	 
}
