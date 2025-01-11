package Utilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import DriverManager.DriverFactory;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

	public class ScreenshotUtil {

	    public static void captureScreenshot(ITestResult result) {
	    	WebDriver driver = DriverFactory.getDriver();
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            // Save the screenshot with the scenario name
	            FileUtils.copyFile(screenshot, new File("target/screenshots/" + result.getName() + ".png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}




