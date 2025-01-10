package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import DriverManager.DriverFactory;

public class loginPage extends DriverFactory{
	
	WebDriver driver;
	public String excelPath=configReader.getExcelDataPath();
	By txt_UserName = By.name("username");
	By txt_Password = By.name("password");
	By btn_login = By.xpath("//input[@value='Login']");
	
	// First page
	
	By btn_getStarted = By.xpath("//button[@class='btn']");
	By link_signin = By.xpath("//a[normalize-space()='Sign in']");
	By btn_signout =  By.xpath("//*[contains(text(), 'sign out')]");
	
	
	//home screen get started button
	By getStartedDS=By.xpath("//a[@href='data-structures-introduction']");
	By getStartedArray=By.xpath("//a[@href='array']");
	By getStartedQueue=By.xpath("//a[@href='queue']");	
	By getStartedStack=By.xpath("//a[@href='stack']");
	By getStartedLL=By.xpath("//a[@href='linked-list']");
	By getStartedTree=By.xpath("//a[@href='tree']");
	By getStartedGraph=By.xpath("//a[@href='graph']");	
	
	//home screen dropdown list links
	By datastructuresLink=By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/a");
	By stackdropdown=By.xpath("//a[@href='/stack']");
	By queuedropdown=By.xpath("//a[@href='/queue']");
	By treedropdown=By.xpath("//a[@href='/tree']");
	By Graphdropdown=By.xpath("//a[@href='/graph']");
	By arrayDropdown=By.xpath("//a[normalize-space()='Arrays']");
	By LLdropDown=By.xpath("//a[normalize-space()='Linked List']");
	
	public String clk_signout()
	{
	WebElement profileText = driver.findElement(btn_signout);
	return profileText.getText();
	}
	
	public String chk_signin()
	{
	WebElement profileText = driver.findElement(link_signin);
	return profileText.getText();
	}
	
	public void getStarted()
	{
		driver.findElement(btn_getStarted).click();
	}
	
	public void clkSignin()
	{
		driver.findElement(link_signin).click();
		
	}
	
	public String getErrorMsg()
	{
	WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));
	return errorMessage.getText();
	}
	

	public void enterLogin(String username,String password) 

	{
		driver.findElement(txt_UserName).sendKeys(username);
		driver.findElement(txt_Password).sendKeys(password);
	    driver.findElement(btn_login).click();
	
	}
	
	public loginPage()
	{
		this.driver = DriverFactory.getDriver();
	}
	
	public void homeGetStarted(String listname)
	{
		if(listname.equalsIgnoreCase("DS"))
		{
			System.out.println("inside login");
			System.out.println(getStartedDS.toString());
			driver.findElement(getStartedDS).click();
		}
		else if(listname.equalsIgnoreCase("array"))
		{
			driver.findElement(getStartedArray).click();
		}
		else if(listname.equalsIgnoreCase("list"))
		{
			driver.findElement(getStartedLL).click();
		}
		else if(listname.equalsIgnoreCase("queue"))
		{
			driver.findElement(getStartedQueue).click();
		}
		else if(listname.equalsIgnoreCase("stack"))
		{
			driver.findElement(getStartedStack).click();
		}
		else if(listname.equalsIgnoreCase("tree"))
		{
			driver.findElement(getStartedTree).click();
		}
		else if(listname.equalsIgnoreCase("graph"))
		{
			driver.findElement(getStartedGraph).click();
		}
	}
	
	
		
	//home screen profile name
		By profileName=By.xpath("//*[contains(text(), 'sign')]");
		
		public String validatePageTitle() {
			
			
			return driver.getTitle();
		}
		
		
		public void homeDropDown(String listname)
		{
			driver.findElement(datastructuresLink).click();
			 if(listname.equalsIgnoreCase("array"))
			{
				driver.findElement(arrayDropdown).click();
			}
			else if(listname.equalsIgnoreCase("list"))
			{
				driver.findElement(LLdropDown).click();
			}
			else if(listname.equalsIgnoreCase("queue"))
			{
				driver.findElement(queuedropdown).click();
			}
			else if(listname.equalsIgnoreCase("stack"))
			{
				driver.findElement(stackdropdown).click();
			}
			else if(listname.equalsIgnoreCase("tree"))
			{
				driver.findElement(treedropdown).click();
			}
			else if(listname.equalsIgnoreCase("graph"))
			{
				driver.findElement(Graphdropdown).click();
			}
		}
		

}

