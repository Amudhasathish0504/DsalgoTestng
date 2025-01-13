package listeners;


	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import DataProvider.ConfigFileReader;

import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	public class ExtentReportListener implements ITestListener {

		private ExtentReports extent;
	    private ExtentTest test;
	    ConfigFileReader configReader=new ConfigFileReader();

	    
	    @Override
	    public void onStart(ITestContext context) {
	        // Initialize ExtentReports and configure Spark report path
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(configReader.getExtentReportPath());
	        sparkReporter.config().setReportName("Test Automation Report");
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        
	        test.pass("Test passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        
	        test.fail("Test failed");
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        
	        test.skip("Test skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        
	        extent.flush();
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        
	    }
	}


