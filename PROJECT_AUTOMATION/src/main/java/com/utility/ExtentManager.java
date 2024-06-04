package com.utility;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	//static method should always have static variables
	public static ExtentReports extent;
	public static ExtentSparkReporter spark_reporter;
	
	
	public static void setupReport() throws IOException{
		if(extent==null) {
	  extent= new ExtentReports(); 
	  final File conf = new File(System.getProperty("user.dir")+"\\configurations\\extent-config.xml"); 
	  spark_reporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html"); 
	  spark_reporter.loadXMLConfig(conf);
	  extent.attachReporter(spark_reporter);
	}}
	
	public static void endReport() {
		extent.flush();
	}
	
	
	
}
