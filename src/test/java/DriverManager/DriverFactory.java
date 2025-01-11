package DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import DataProvider.BrowserConfig;
import DataProvider.ConfigFileReader;




public class DriverFactory {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ConfigFileReader configReader;
	
	public DriverFactory()
	{
		configReader=new ConfigFileReader();
		

	}
	
	public static void SetBrowser(String browser) {
		BrowserConfig.setBrowserType(browser);
	}

	public static WebDriver getDriver() {
		 if(driver.get()==null) {
			 createDriver(configReader.getBrowser());
			 }
		 	
		        return driver.get();
	    }

	    public static void createDriver(String browser) {
	        WebDriver webDriver = null;
	        switch (browser.toLowerCase()) {
	            case "chrome":
	                webDriver = new ChromeDriver();
	                break;
	            case "firefox":
	                webDriver = new FirefoxDriver();
	                break;
	            case "edge":
	                webDriver = new EdgeDriver();
	                break;
	            default:
	                throw new IllegalArgumentException("Unsupported browser: " + browser);
	        }
	       
	        driver.set(webDriver);
	    }
	    public static void quitDriver() {
	        WebDriver webDriver = driver.get();
	        if (webDriver != null) {
	            webDriver.quit();
	            driver.remove();
	        }
	    }
	    

}