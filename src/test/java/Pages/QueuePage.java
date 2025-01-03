
package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManager.DriverFactory;
import Utilities.LoggerLoad;

public class QueuePage extends DriverFactory{
	WebDriver driver; 
	public QueuePage() {
		this.driver=DriverFactory.getDriver();
	}
	
	By implementationList=By.xpath("//a[@href='implementation-lists']");
	By implementationCollections=By.xpath("//a[@href='implementation-collections']");
	By implementationarray=By.xpath("//a[@href='Implementation-array']");
	By queueOperation=By.xpath("//a[@href='QueueOp']");
	By practiceQuestion=By.xpath("//a[@href='/queue/practice']");
	
	public void checkQueuePageLink(String pageName) {
		if(pageName.equalsIgnoreCase("implementation-lists")) {
			driver.findElement(implementationList).click();
			LoggerLoad.info("Clicking the implementation-lists link of queue page");
		}
		else if(pageName.equalsIgnoreCase("implementation-collections.deque")) {
			driver.findElement(implementationCollections).click();
			LoggerLoad.info("Clicking the implementation-collections.deque link of queue page");
		}
		else if(pageName.equalsIgnoreCase("implementation-array")) {
			driver.findElement(implementationarray).click();
			LoggerLoad.info("Clicking the implementation-array link of queue page");
		}
		else if(pageName.equalsIgnoreCase("queue operations")) {
			driver.findElement(queueOperation).click();
			LoggerLoad.info("Clicking the queue operations link of queue page");
		}
		else if(pageName.equalsIgnoreCase("practice questions")) {
			clickPracticeLink();
			LoggerLoad.info("Clicking the practice questions link of queue page");
		}
		
	}
	public String validateQueuePageTitles() {
		List<WebElement> list=driver.findElements(By.xpath("//a[@href='/tryEditor']"));
		if(list.size()>0)
		return driver.getTitle();
		return null;
	}
	public String getExcelPath() {
		return configReader.getQueueDataPath();
	}
	public void checkTryEditorLink() {
		LoggerLoad.info("clicking the tryEditor link");
		By tryeditor=By.xpath("//a[@href='/tryEditor']");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(tryeditor)).perform();
		driver.findElement(tryeditor).click();
	}
	public void clickPracticeLink() {
		checkQueuePageLink("queue operations");
		driver.findElement(practiceQuestion).click();
		LoggerLoad.info("Clicking the practice questions link of queue page");
	}


}
