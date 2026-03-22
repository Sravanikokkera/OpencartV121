package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{  
		// ExtentSparkReporter configuration all about the UI
		
	 /*	SimpleDateFormat df = new SimpleDateFormat("yyyy.mm.dd.GG.mms.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);  */
		
		//Report creation with timestamp (Creates new report every execution & Maintains report history)		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
	    repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter= new ExtentSparkReporter(".\\reports\\"+repName); // to specify location
         
		// Report UI configuration 
		
		sparkReporter.config().setDocumentTitle("OpenCart Automation Report");// title of the report
		sparkReporter.config().setReportName("Functional Testing");// name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		// System information
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
       
		extent.setSystemInfo("Application","OpenCart");
        extent.setSystemInfo("Tester","Automation");
        extent.setSystemInfo("Module","Admin ");
        extent.setSystemInfo("Sub Module","Customers");
        extent.setSystemInfo("User Name ",System.getProperty("user.name"));
        
        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);
        
        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);
        
        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty())
        {
        	extent.setSystemInfo("Groups", includedGroups.toString());
        }
	}  
	   //Test Success logging(Shows PASS status)
	
        public void onTestSuccess(ITestResult result) {
        
        	test=extent.createTest(result.getTestClass().getName());
        	test.assignCategory(result.getMethod().getGroups()); // to display groups in reports
        	test.log(Status.PASS,result.getName() + " got Successfully executed");
        	
         }
        //Test Failure with Screenshot(Captures screenshot,Attaches screenshot in report,Screenshot labelled with test name.)
        
        public void onTestFailure(ITestResult result)
        {
        	test = extent.createTest(result.getTestClass().getName());
        	test.assignCategory(result.getMethod().getGroups());
        	
        	test.log(Status.FAIL,result.getName() + " got failed");
        	test.log(Status.INFO, result.getThrowable().getMessage());
        	
        	try {
        		String imgPath=new BaseClass().captureScreen(result.getName());
        		test.addScreenCaptureFromPath(imgPath,result.getName());
        		
        	}catch(IOException e1)
        	{
        		e1.printStackTrace();
        		
        	}
         }
        
          // Skipped test logging(Shows skipped tests)
          public void onTestSkipped(ITestResult result) {

        	
        		test=extent.createTest(result.getTestClass().getName());
        		test.assignCategory(result.getMethod().getGroups());
            	
            	test.log(Status.SKIP,result.getName() + " got Skipped");
            	test.log(Status.INFO, result.getThrowable().getMessage());
        	}
        	//Report closing and auto-open(Saves report,Opens automatically after execution.)
           public void onFinish(ITestContext testContext)
           {
        	extent.flush();
        	
        	String pathOfExtentReport=System.getProperty("user.dir") + "\\reports\\"+repName;
        	File extentReport = new File(pathOfExtentReport);
        	
        	try {
        		Desktop.getDesktop().browse(extentReport.toURI());
        	} catch(IOException e)
        	{
        		e.printStackTrace();
        	}
        	
        }
           
	 
      }
	


