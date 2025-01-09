package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import DriverManager.DriverFactory;

import Utilities.LoggerLoad;

public class arrayPage extends DriverFactory{
	WebDriver driver;
	public arrayPage() {
		this.driver=DriverFactory.getDriver();
	}
	By lnk_ArraysinPython =By.xpath("//a[@href='arrays-in-python']");
	By lnk_ArraysUsingList=By.xpath("//a[text()='Arrays Using List']");
	By lnk_BasicOperationsinLists=By.xpath("//a[text()=\"Basic Operations in Lists\"]");
	By lnk_ApplicationsofArray=By.xpath("//a[text()=\"Applications of Array\"]");
	By lnk_PracticeQuestions=By.xpath("//a[text()=\"Practice Questions\"]");
	By lnk_SearchtheArray=By.xpath("//a[text()='Search the array']");
	By lnk_MaxConsecutiveOnes=By.xpath("//a[text()='Max Consecutive Ones']");
	By lnk_FindNumbers=By.xpath("//a[text()='Find Numbers with Even Number of Digits']");
	By lnk_SquaresofaSortedArray=By.xpath("//a[text()='Squares of  a Sorted Array']");
	By tryeditor=By.xpath("//a[@href='/tryEditor']");
	
	public void navigate_arraysinPythonPage() {
	 driver.findElement(lnk_ArraysinPython).click();
	 LoggerLoad.info("Clicking the Arrays in Python link of Array page");
		}
	public String validatePageTitle() {
		return driver.getTitle();
	}
	public String getExcelPath() {
		return configReader.getDataStructuresPath();
		
	}


    public void navigate_ArraysUsingListPage() {
    	
    	driver.findElement(lnk_ArraysUsingList).click();
    	LoggerLoad.info("Clicking the Arrays Using List link of Array page");
		
	}
    public void navigate_BasicOperationsinListsPage() {
    	driver.findElement(lnk_BasicOperationsinLists).click();
    	LoggerLoad.info("Clicking the Basic operations in Lists of Array page");

		
	}
   public void navigate_ApplicationsofArrayPage() {
	   driver.findElement(lnk_ApplicationsofArray).click();
	   LoggerLoad.info("Clicking the Applications of Array of array page");
	   
		
	}
   public void navigate_PracticeQuestionsPage() {
	   driver.findElement(lnk_PracticeQuestions).click(); 
	   LoggerLoad.info("Clicking the practice questions page of array page");
		
	
}
   public void click_searchthearray()
	{
		driver.findElement(lnk_SearchtheArray).click();
		LoggerLoad.info("Clicking the Search the array link of array practice questions page");
	}
	public void click_max()
	{
		driver.findElement(lnk_MaxConsecutiveOnes).click();
		LoggerLoad.info("Clicking the Max consecutive ones link of array practice questions page");

	}
	public void click_findnumbers()
	{
		driver.findElement(lnk_FindNumbers).click();
		LoggerLoad.info("Clicking the Find numbers with even number of digits link of array practice questions page");

	}
	public void click_squares()
	{
		driver.findElement(lnk_SquaresofaSortedArray).click();
		LoggerLoad.info("Clicking the Squares of a sorted array link of array practice questions page");

}
	public void click_TryEditor() {
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(tryeditor)).perform();
		driver.findElement(tryeditor).click();
		LoggerLoad.info("Clicking the tryEditor link");
	}


}




	