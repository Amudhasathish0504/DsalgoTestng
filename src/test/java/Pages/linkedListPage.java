package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManager.DriverFactory;
import Utilities.LoggerLoad;

public class linkedListPage extends DriverFactory {
	WebDriver driver;
	public linkedListPage() {
		this.driver=DriverFactory.getDriver();
	}
	//Locators
	
	By lnk_Introduction=By.xpath("//a[@href='introduction']");
	By lnk_CreatingLinkedLIst=By.xpath("//a[@href=\"creating-linked-list\"]");
	By lnk_TypesofLinkedList=By.xpath("//a[text()=\"Types of Linked List\"]");
	By lnk_ImplementLinkedListinPython=By.xpath("//a[text()=\"Implement Linked List in Python\"]");
	By lnk_Traversal=By.xpath("//a[text()=\"Traversal\"]");
	By lnk_Insertion=By.xpath("//a[text()=\"Insertion\"]");
	By lnk_Deletion=By.xpath("//a[text()=\"Deletion\"]");
	By lnk_practice=By.xpath("//a[text()=\"Practice Questions\"]");

	//Action Methods
	
	public void checkListPageLink(String pageName) {
		if(pageName.equalsIgnoreCase("Introduction")) {
			driver.findElement(lnk_Introduction).click();
			LoggerLoad.info("Clicking the Introduction link of linked list page");
		}
		else if(pageName.equalsIgnoreCase("Creating Linked List")) {
			driver.findElement(lnk_CreatingLinkedLIst).click();
			LoggerLoad.info("Clicking the Creating Linked List  link of linked list page");
		}
		else if(pageName.equalsIgnoreCase("Types of Linked List"))
		{
		driver.findElement(lnk_TypesofLinkedList).click();
		LoggerLoad.info("Clicking the Types of Linked List   link of linked list page");
		}
		else if(pageName.equalsIgnoreCase("Implement Linked List in Python"))
		{
			driver.findElement(lnk_ImplementLinkedListinPython).click();
			LoggerLoad.info("Clicking the Implement Linked List in Python   link of linked list page");
		}
		
		else if(pageName.equalsIgnoreCase("Traversal"))
		{
			driver.findElement(lnk_Traversal).click();
			LoggerLoad.info("Clicking the Traversal link of linked list page");
		}
		
		else if(pageName.equalsIgnoreCase("Insertion"))
		{
			driver.findElement(lnk_Insertion).click();
			LoggerLoad.info("Clicking the Insertion link of linked list page");
		}
		
		else if(pageName.equalsIgnoreCase("Deletion"))
		{
			driver.findElement(lnk_Deletion).click();
			LoggerLoad.info("Clicking the Deletion link of linked list page");
		}
       else if(pageName.equalsIgnoreCase("Practice Questions"))
		{
			driver.findElement(lnk_Introduction).click();
            driver.findElement(lnk_practice).click();
            LoggerLoad.info("Clicking the Practice page  link of linked list page");
        }}
	public String validateListPageTitles() {
		List<WebElement> list=driver.findElements(By.xpath("//a[@href='/tryEditor']"));
		if(list.size()>0)
		return driver.getTitle();
		return null;
	}
	
		public void checkTryEditorLink() {
		By tryeditor=By.xpath("//a[@href='/tryEditor']");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(tryeditor)).perform();
		driver.findElement(tryeditor).click();
		LoggerLoad.info("Clicking the tryEditor link");
	}

	

}