
package Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManager.DriverFactory;
import Utilities.LoggerLoad;

public class dataStructureIntroductionPage extends DriverFactory  {
	WebDriver driver;
	public dataStructureIntroductionPage() {
		this.driver=DriverFactory.getDriver();
	}
	//locators
	
	By lnk_TimeComplexity =By.xpath("//a[@href='time-complexity']");
	By data_practicequestion=By.xpath("//a[@href=\"/data-structures-introduction/practice\"]");
	By tryeditor=By.xpath("//a[@href='/tryEditor']");

	


	//Action Methods
	public void checkListPageLink(String pageName) {
		if(pageName.equalsIgnoreCase("Time Complexity")) {
			driver.findElement(lnk_TimeComplexity).click();
			LoggerLoad.info("Clicking the Arrays in Python link of array page");
		}
		else if(pageName.equalsIgnoreCase("Arrays Using List")) {
			driver.findElement(data_practicequestion).click();
			LoggerLoad.info("Clicking the Arrays Using List link of array page");
		}}
	
	public String validateListPageTitles() {
		List<WebElement> list=driver.findElements(By.xpath("//a[@href='/tryEditor']"));
		if(list.size()>0)
		return driver.getTitle();
		return null;
	}


	

    public void navigate_time_complexity()
    {
    	driver.findElement(lnk_TimeComplexity).click();
    }
    public void navigate_data_practice()
    {
    	driver.findElement(data_practicequestion).click();
    }
public void click_TryEditor() {
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(tryeditor)).perform();
		driver.findElement(tryeditor).click();
		LoggerLoad.info("Clicking the tryEditor link");
	}
	
}
