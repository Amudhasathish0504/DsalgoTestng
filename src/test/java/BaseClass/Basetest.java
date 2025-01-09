package BaseClass;

	import DriverManager.DriverFactory;
import Pages.loginPage;
import Utilities.LoggerLoad;

	import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

	
	public class Basetest extends DriverFactory {
		
		@BeforeMethod
		    public void setUp()  {
		       	/*LoggerLoad.info("Loading the driver in  "+configReader.getBrowser());
				LoggerLoad.info("-------------------------------------------------------");
				LoggerLoad.info("Scenario Name: "+scenario.getName());
				LoggerLoad.info("-------------------------------------------------------");*/
				
		        // Set the URL for navigation
			
			
		       String url = configReader.getApplicationUrl();
		       
		       
		       
		        WebDriver driver = DriverFactory.getDriver();
		       
		       
		        driver.get(url);
		        driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(configReader.getImplicitlyWait()));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		        By getStartedBtn=By.className("btn");
				By loginBtn=By.xpath("//a[@href='/login']");
				driver.findElement(getStartedBtn).click();
				driver.findElement(loginBtn).click();
				loginPage lp=new loginPage(driver);
				lp.enterLogin(configReader.getUserName(), configReader.getPassword());
}
				
		        
			

		    @AfterClass
		    public void tearDown() {
		    	  WebDriver driver = DriverFactory.getDriver();
		    	
		    	DriverFactory.quitDriver();
		    	//driver.quit();
		    }
	}



