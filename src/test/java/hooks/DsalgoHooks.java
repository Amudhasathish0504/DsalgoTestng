package hooks;
import DriverManager.DriverFactory;
import Utilities.LoggerLoad;
import Utilities.ScreenshotUtil;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class DsalgoHooks extends DriverFactory {
		
	@Before
	    public void setUp(Scenario scenario) {
	       	LoggerLoad.info("Loading the driver in  "+configReader.getBrowser());
			LoggerLoad.info("-------------------------------------------------------");
			LoggerLoad.info("Scenario Name: "+scenario.getName());
			LoggerLoad.info("-------------------------------------------------------");
			
	        // Set the URL for navigation
	        String url = configReader.getApplicationUrl();
	        WebDriver driver = DriverFactory.getDriver();
	        driver.get(url);
	        driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(configReader.getImplicitlyWait()));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}

	    @After
	    public void tearDown(Scenario scenario) {
	    	  WebDriver driver = DriverFactory.getDriver();
	    	if (scenario.isFailed()) {

	    		 String screenshotName = scenario.getName().replace(" ", "_");
	    		 ScreenshotUtil.captureScreenshot(driver, screenshotName);
	    		}
	    	LoggerLoad.info("-------------------------------------------------------");
	    	DriverFactory.quitDriver();
	    }
}

