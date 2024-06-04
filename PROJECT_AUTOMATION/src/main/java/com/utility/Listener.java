package com.utility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.actiondriver.Seleniumactions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listener extends ExtentManager implements ITestListener{
	public  ExtentTest report_test;
	
	//we have added thread safety for parallel run and mainly during crossbrowser parallel run we got mismatch logs  
	ThreadLocal<ExtentTest>extenttest= new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		//during every test start
	    System.out.println("on test start listner");
	    report_test=extent.createTest(result.getName());
	    extenttest.set(report_test);
	  }
	public void onTestSuccess(ITestResult result) {
		//after one test method pass
		 System.out.println("on test success listner");
		 if (result.getStatus() == ITestResult.SUCCESS) {
			 extenttest.get().log(Status.PASS, "Pass Test case is: " + result.getName());//extenttest.get()
			}
	  }
	public void onTestFailure(ITestResult result) {
		//after one test method fail
		 System.out.println("on test fail listner");
		 
		 if (result.getStatus() == ITestResult.FAILURE) {
			 extenttest.get().log(Status.FAIL, "fail Test case is: " + result.getName());
			 extenttest.get().fail(result.getThrowable());
			}
		 Seleniumactions action=new Seleniumactions();
		 try {
			String screenshootpath=action.take_screenshot(result.getName());
			//String path= FileUtils.readFileToString(screenshootpath);
			extenttest.get().addScreenCaptureFromPath(screenshootpath, "fail Test case is: " + result.getName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		  }
	public void onTestSkipped(ITestResult result) {
		//after one test is skipped
		 System.out.println("on test skip listner");
		 if (result.getStatus() == ITestResult.SKIP) {
			 extenttest.get().log(Status.SKIP, "Skipped Test case is: " + result.getName());
			}
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
