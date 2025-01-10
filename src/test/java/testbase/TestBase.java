package testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import Utilities.LoggerLoad;

public class TestBase extends DriverFactory {
	public void setUp() {
       	LoggerLoad.info("Loading the driver in  "+configReader.getBrowser());
		LoggerLoad.info("-------------------------------------------------------");
		LoggerLoad.info("Scenario Name: ");
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

   
    public void tearDown() {
    	LoggerLoad.info("-------------------------------------------------------");
    	DriverFactory.quitDriver();
    	
    }
}
