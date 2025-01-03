
package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManager.DriverFactory;
import Utilities.LoggerLoad;

public class TryEditorArrayPage extends DriverFactory {
	WebDriver driver;
	public TryEditorArrayPage() {
		this.driver=DriverFactory.getDriver();
	}
	//locators
		By btn_tryEditor=By.xpath("//a[@href=\"/tryEditor\"]");
		By textArea=By.xpath("//textarea[@tabindex='0']");
		By runBtn=By.xpath("//button[text()='Run']");
		By outputText=By.xpath("//*[@id='output']");
		
		//Action Methods
		public void enter_input(String code)
		{
			
			Actions actions=new Actions(driver);
			WebElement textEditor=driver.findElement(textArea);
			actions.moveToElement(textEditor).click().sendKeys(code).build().perform(); 
		}
		public void click_run()
		{
			driver.findElement(runBtn).click();
		}
		public void click_tryEditor()
		{
		   By tryeditor=By.xpath("//a[@href='/tryEditor']");
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(tryeditor)).perform();
			driver.findElement(tryeditor).click();
			LoggerLoad.info("Clicking the try editor link of array page");

		}
		
		public boolean isAlertPresent(){
		    try{
		        driver.switchTo().alert();
		        return true;
		    }
		    catch (NoAlertPresentException e){
		        return false;
		    }
		}

		public void capture_alert()
		{
			Alert alert = driver.switchTo().alert(); // switch to alert

			String alertMessage= driver.switchTo().alert().getText(); // capture alert message
	        System.out.println(alertMessage); // Print Alert Message
		
		}
		
		
		public String get_outputText() 
		{
			
			String consoleOutput=driver.findElement(outputText).getText();
			return consoleOutput;
		}
		
	}
		


