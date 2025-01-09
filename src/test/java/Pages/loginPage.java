
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class loginPage {
	
	WebDriver driver;
	By txt_UserName = By.name("username");
	By txt_Password = By.name("password");
	By btn_login = By.xpath("/html/body/div[2]/div/div[2]/form/input[4]");
		
	public void enterLogin(String username,String password) 
	{
		driver.findElement(txt_UserName).sendKeys(username);
		driver.findElement(txt_Password).sendKeys(password);
	    driver.findElement(btn_login).click();
	
	}
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
