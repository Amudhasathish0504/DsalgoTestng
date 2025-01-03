package Utilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

	public class ScreenshotUtil {

	    public static void captureScreenshot(WebDriver driver, String scenarioName) {
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            // Save the screenshot with the scenario name
	            FileUtils.copyFile(screenshot, new File("target/screenshots/" + scenarioName + ".png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}




