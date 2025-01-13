package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverManager.DriverFactory;

public class RegisterPO extends DriverFactory{

	WebDriver driver;
	public String excelPath=configReader.getExcelDataPath();
	public RegisterPO()
	{
		this.driver = DriverFactory.getDriver();
	}
	
		By link_register =By.xpath("//a[normalize-space()='Register']") ;
	 By userName=By.xpath("//input[@id='id_username']");
	 By passWord=By.xpath("//input[@id='id_password1']");
	 By confirmPwd=By.xpath("//input[@id='id_password2']");
	 By btn_register=By.xpath("//input[@value='Register']");
	 By error_msg=By.xpath("//div[@role='alert']");
	 
	 public void click_register()
	 {
		 driver.findElement(link_register).click();
	 }

	 public void EnterValues( String user_name,String pass_word, String confirm_Pwd)
	 { 
		 driver.findElement(userName).sendKeys(user_name);
		 driver.findElement(passWord).sendKeys(pass_word);
		 driver.findElement(confirmPwd).sendKeys(confirm_Pwd);
		 driver.findElement(btn_register).click();
	 }
	 public String getErrorMsg()
		{
		WebElement errorMessage = driver.findElement(error_msg);
		return errorMessage.getText();
		}
	 
	 public String validatePageTitle() {
			return driver.getTitle();
		}
}