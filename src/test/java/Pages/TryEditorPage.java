
package Pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import DriverManager.DriverFactory;

public class TryEditorPage extends DriverFactory{
	WebDriver driver;
	public TryEditorPage() {
		this.driver=getDriver();
	}
	By textArea=By.xpath("//textarea[@tabindex='0']");
	By runBtn=By.xpath("//button[text()='Run']");
	By outputText=By.xpath("//*[@id='output']");

	public void checkCode(String code) {
		if(code!=" ") {
			Actions actions=new Actions(driver);
			WebElement textEditor=driver.findElement(textArea);
			actions.moveToElement(textEditor).click().sendKeys(code).build().perform();              
		}
		   driver.findElement(runBtn).click();
		}
	public String validateOutput() {
			if(!isAlertPresent()) {
			return driver.findElement(outputText).getText();
		}
			else
				return " ";

	}
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();  
			return true; 
		} catch (NoAlertPresentException e) {
			return false;  
		}
	}
	public void click_runBtn()
	{
		driver.findElement(runBtn).click();
	}
}
