
package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;

public class dataStructureIntroductionPage extends DriverFactory  {
	WebDriver driver;
	public dataStructureIntroductionPage() {
		this.driver=DriverFactory.getDriver();
	}
	//locators
	By btn_dataGetStarted=By.xpath("//a[@href=\"data-structures-introduction\"]");
	By lnk_TimeComplexity =By.xpath("//a[@href='time-complexity']");
	By data_practicequestion=By.xpath("//a[@href=\"/data-structures-introduction/practice\"]");
	


	//Action Methods
	public void click_dataGetStarted()
	{
		driver.findElement(btn_dataGetStarted).click();
	}

    public void navigate_time_complexity()
    {
    	driver.findElement(lnk_TimeComplexity).click();
    }
    public void navigate_data_practice()
    {
    	driver.findElement(data_practicequestion).click();
    }
}
