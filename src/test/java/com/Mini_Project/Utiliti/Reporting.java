package com.Mini_Project.Utiliti;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter html_report;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {

		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//Time Stamp
		String repName="Test-Report-"+timestamp+".html";
		html_report=new ExtentHtmlReporter("G:\\seleniumWorkspace\\Mini_Project_Selenium\\OutPut"+repName);//location of report
		extent=new ExtentReports();
		extent.attachReporter(html_report);
		html_report.config().setDocumentTitle("Automation Report");//title of report 
		html_report.config().setReportName("Sharaths report");//name of the report
		html_report.config().setTheme(Theme.DARK);
		
		extent.setSystemInfo("Host name", "local host");
		extent.setSystemInfo("os", "Windows 10");
		extent.setSystemInfo("tester name", "Sharath");
		extent.setSystemInfo("Browser","Chrome");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		logger=extent.createTest(tr.getName());// Create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));// send the passed information
		
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		logger=extent.createTest(tr.getName());// Create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));// send the passed information
		logger.log(Status.FAIL, "The test got failed is"+tr.getThrowable());
		
		String file_Output="G:\\seleniumWorkspace\\Mini_Project_Selenium\\ScreenShot"+tr.getName()+".png";
		
		File f=new File(file_Output);
		
		if(f.exists()) {
			
			try {
				
				logger.fail((Markup) (logger.addScreenCaptureFromPath(file_Output)));
			}
			catch (IOException e){
				
			}
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
		logger=extent.createTest(tr.getName());// Create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));// send the passed information
		
		
	
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
		
	}



}
