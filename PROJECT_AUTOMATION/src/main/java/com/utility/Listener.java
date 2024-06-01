package com.utility;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.actiondriver.Seleniumactions;


public class Listener implements ITestListener{

	public void onTestStart(ITestResult result) {
		//during every test start
	    System.out.println("on test start listner");
	  }
	public void onTestSuccess(ITestResult result) {
		//after one test method pass
		 System.out.println("on test success listner");
	  }
	public void onTestFailure(ITestResult result) {
		//after one test method fail
		 System.out.println("on test fail listner");
		 Seleniumactions action=new Seleniumactions();
		 try {
			action.take_screenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		  }
	public void onTestSkipped(ITestResult result) {
		//after one test is skipped
		 System.out.println("on test skip listner");
		  }
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 System.out.println("on test failbut listner");
		  }
	public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		    System.out.println("on test fail with tim e out listner");
		  }
	public void onStart(ITestContext context) {
		//very beginning of the test before launch
		 System.out.println("on  start listner");
		  }
	public void onFinish(ITestContext context) {
		//after very last line code ends
		 System.out.println("on finish listner");
		  }
}
