/* package com.qa.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	
	

	    private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            extent = createInstance();
	        }
	        return extent;
	    }

	    private static ExtentReports createInstance() {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/ExtentReport.html");
	        htmlReporter.config().setDocumentTitle("Cucumber Extent Report");
	        htmlReporter.config().setReportName("Cucumber Test Automation Report");
	        htmlReporter.config().setTheme(Theme.DARK);

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	        return extent;
	    }
	}


*/
