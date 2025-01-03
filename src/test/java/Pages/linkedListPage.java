package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import DriverManager.DriverFactory;
import Utilities.LoggerLoad;

public class linkedListPage extends DriverFactory {
	WebDriver driver;
	public linkedListPage() {
		this.driver=DriverFactory.getDriver();
	}
	//Locators
	By dropdown=By.xpath("//a[text()=\"Data Structures\"]");
	By listdropdown=By.xpath("//a[text()=\"Linked List\"]");
	By lnk_Introduction=By.xpath("//a[@href='introduction']");
	By lnk_CreatingLinkedLIst=By.xpath("//a[@href=\"creating-linked-list\"]");
	By lnk_TypesofLinkedList=By.xpath("//a[text()=\"Types of Linked List\"]");
	By lnk_ImplementLinkedListinPython=By.xpath("//a[text()=\"Implement Linked List in Python\"]");
	By lnk_Traversal=By.xpath("//a[text()=\"Traversal\"]");
	By lnk_Insertion=By.xpath("//a[text()=\"Insertion\"]");
	By lnk_Deletion=By.xpath("//a[text()=\"Deletion\"]");
	By lnk_practice=By.xpath("//a[text()=\"Practice Questions\"]");

	//Action Methods
	public void click_dropdown()
	{
		driver.findElement(dropdown).click();
		
	}
	public void navigate_linkedlistPage() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(listdropdown).click();
		LoggerLoad.info("Selecting the Linked List option from dropdown");
	}
    public void navigate_IntroductionPage() {
    	driver.findElement(lnk_Introduction).click();
    	LoggerLoad.info("Clicking the Introduction link of Linked List page");
    	
		
	}
    public void navigate_CreatingLinkedListPage() {
    	driver.findElement(lnk_CreatingLinkedLIst).click();
    	LoggerLoad.info("Clicking the Creating Linked list link of Linked List page");
		
	}
    public void navigate_TypesofLinkedListPage() {
		driver.findElement(lnk_TypesofLinkedList).click();
		LoggerLoad.info("Clicking the Types of Linked list link of Linked List page");
	}
   public void navigate_ImplementLinkedListinPythonPage() {
	   driver.findElement(lnk_ImplementLinkedListinPython).click();
	   LoggerLoad.info("Clicking the Implement Linked list in python link of Linked List page");
		
	}
   public void navigate_TraversalPage() {
	   driver.findElement(lnk_Traversal).click();
	   LoggerLoad.info("Clicking the Traversal link of Linked List page");
		
	}
   public void navigate_InsertionPage() {
	   driver.findElement(lnk_Insertion).click();
	   LoggerLoad.info("Clicking the Insertion link of Linked List page");
		
	}
   public void navigate_DeletionPage() {
	   driver.findElement(lnk_Deletion).click();
	   LoggerLoad.info("Clicking the Deletion link of Linked List page");
		
	}
   public void navigate_prcticePage() {
	   driver.findElement(lnk_practice).click();
	   LoggerLoad.info("Clicking the Practice Questions link of Linked List page");
		
	}

	

}