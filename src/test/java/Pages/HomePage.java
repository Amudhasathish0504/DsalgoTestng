
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import DriverManager.DriverFactory;
import Utilities.LoggerLoad;

public class HomePage extends DriverFactory{
	WebDriver driver;
	public HomePage() {
		this.driver=DriverFactory.getDriver();
	}
	By graph=By.xpath("//a[@href='graph']");
	By stack=By.xpath("//a[@href='stack']");
	By queue=By.xpath("//a[@href='queue']");
	By tree=By.xpath("//a[@href='tree']");
	By datastructuresLink=By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/a");
	By stackdropdown=By.xpath("//a[@href='/stack']");
	By queuedropdown=By.xpath("//a[@href='/queue']");
	By graphdropdown=By.xpath("//a[@href='/graph']");
	By treedropdown=By.xpath("//a[@href='/tree']");
	By btn_ArraygetStarted=By.xpath("//a[@href='array']");
	By dropdown=By.xpath("//a[text()=\"Data Structures\"]");
	By listdropdown=By.xpath("//a[text()=\"Linked List\"]");
	By btn_dataGetStarted=By.xpath("//a[@href=\"data-structures-introduction\"]");
	
	public void clickStackLink() {
		driver.findElement(stack).click();
	}
	public String validatePageTitle() {
		return driver.getTitle();
	}
	public void clickStackFromDropDown() {
		driver.findElement(datastructuresLink).click();
		driver.findElement(stackdropdown).click();
	}
	public void clickQueueLink() {
		driver.findElement(queue).click();
	}
	public void clickQueueFromDropDown() {
		driver.findElement(datastructuresLink).click();
		driver.findElement(queuedropdown).click();
	}
	public void click_btn_Arraygetstarted()
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(btn_ArraygetStarted)).perform();
		driver.findElement(btn_ArraygetStarted).click();
		
	}
	public void clickGraphLink() {
		driver.findElement(graph).click();
		
	}
	public void clickGraphFromDropDown() {
		driver.findElement(datastructuresLink).click();
		driver.findElement(graphdropdown).click();
	}
	public void clickTreeLink() {
		driver.findElement(tree).click();
		
	}
	public void clickTreeFromDropDown() {
		driver.findElement(datastructuresLink).click();
		driver.findElement(treedropdown).click();
	}
	public void navigate_linkedlistPage() 
	{
		//Thread.sleep(2000);
		driver.findElement(dropdown).click();

		driver.findElement(listdropdown).click();
		LoggerLoad.info("Selecting the Linked List option from dropdown");
	}
	public void click_dataGetStarted()
	{
		driver.findElement(btn_dataGetStarted).click();
	}

	
}
