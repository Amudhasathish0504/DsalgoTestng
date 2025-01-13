package TestBaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import DriverManager.DriverFactory;
import Utilities.LoggerLoad;


public class TestBase extends DriverFactory {

	@Parameters("browser")
	public void setUp(String browser) {
       	LoggerLoad.info("Loading the driver in  "+browser);

	
		LoggerLoad.info("-------------------------------------------------------");
		LoggerLoad.info("Scenario Name: ");
		LoggerLoad.info("-------------------------------------------------------");
	
		
        // Set the URL for navigation
        String url = configReader.getApplicationUrl();
        DriverFactory.createDriver(browser);
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
