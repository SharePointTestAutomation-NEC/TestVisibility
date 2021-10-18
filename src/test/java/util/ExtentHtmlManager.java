package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentHtmlManager {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;

	// Code to fetch object of ExtentReports
	public static ExtentReports getExtentReportsInstance() {
		System.out.println("Beginning of getExtentReportsInstance method in ExtentHtmlManager class...");
		// if (extent == null) is required to ensure that all test case results are updated in same Extent report 
		if (extent == null) {
//			System.out.println(System.getProperty("user.dir"));

			// Steps to create a unique Extent report name
			SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");  
		    Date date = new Date();  
		    String report_name = formatter.format(date);
		    
		    //Create object of ExtentHtmlReporter
		    System.out.println("Report name = " + report_name+".html");
			htmlReporter = new ExtentHtmlReporter(report_name+".html");
			
			// Load configuration file in xml format
			//htmlReporter.loadConfig("html-config.xml");
			
			
			// To automatically create relative paths from the report
			htmlReporter.config().setAutoCreateRelativePathMedia(true);
			
			// Sets the value for /html/head/title
			htmlReporter.config().setDocumentTitle("Sharepoint Automation Testing Report "); 
			htmlReporter.config().setTheme(Theme.STANDARD);
			
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			System.out.println("End of getExtentReportsInstance method in ExtentHtmlManager class...");
		}
		return extent;
	}
}
