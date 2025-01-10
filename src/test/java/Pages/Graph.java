
package Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import DriverManager.DriverFactory;
import Utilities.LoggerLoad;
public class Graph extends DriverFactory {
	WebDriver driver;
	public Graph() {
		this.driver=DriverFactory.getDriver();
		}
	By GraphLink=By.xpath("//a[@href='graph']");
	By GraphRepresentation=By.xpath("//a[@href='graph-representations']");
	By practice=By.xpath("//a[@href='/graph/practice']");
	
	public void checkGraphPageLink(String pageName) {
		if(pageName.equalsIgnoreCase("Graph Representation")) {
			driver.findElement(GraphRepresentation).click();
			LoggerLoad.info("Clicking the Graph representation link of graph page");
		}
		else if(pageName.equalsIgnoreCase("Graph")) {
			driver.findElement(GraphLink).click();
			LoggerLoad.info("Clicking the Graph link of graph page");
		}
		else if(pageName.equalsIgnoreCase("practice-questions"))
			clickPracticeLink();
		
	}
	public void checkTryEditorLink() {
		By tryeditor=By.xpath("//a[@href='/tryEditor']");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(tryeditor)).perform();
		driver.findElement(tryeditor).click();
		LoggerLoad.info("Clicking the tryEditor link");
	}
	
	public void clickPracticeLink() {
		driver.findElement(GraphLink).click();
		driver.findElement(practice).click();
		LoggerLoad.info("Clicking the practice questions link of graph page");
	}
	public String validateGraphPageTitles() {
		List<WebElement> list=driver.findElements(By.xpath("//a[@href='/tryEditor']"));
		if(list.size()>0)
		return driver.getTitle();
		return null;
	}
	public String getExcelPath() {
		return configReader.getExcelDataPath();
	}
	
	}
	
	

	
	
