package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManager.DriverFactory;

import Utilities.LoggerLoad;

public class arrayPage extends DriverFactory{
	WebDriver driver;
	public arrayPage() {
		this.driver=DriverFactory.getDriver();
	}
	HomePage hp=new HomePage();
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
	
	public void checkArrayPageLink(String pageName) {
		if(pageName.equalsIgnoreCase("Arrays in Python")) {
			driver.findElement(lnk_ArraysinPython).click();
			LoggerLoad.info("Clicking the Arrays in Python link of array page");
		}
		else if(pageName.equalsIgnoreCase("Arrays Using List")) {
			driver.findElement(lnk_ArraysUsingList).click();
			LoggerLoad.info("Clicking the Arrays Using List link of array page");
		}
		else if(pageName.equalsIgnoreCase("Basic Operations in Lists"))
			driver.findElement(lnk_BasicOperationsinLists).click();
		else if(pageName.equalsIgnoreCase("Applications of Array"))
			driver.findElement(lnk_ApplicationsofArray).click();
		else if(pageName.equalsIgnoreCase("Practice Questions"))
		{
			driver.findElement(lnk_ArraysinPython).click();
            driver.findElement(lnk_PracticeQuestions).click();
        }}
	public String validateArrayPageTitles() {
		List<WebElement> list=driver.findElements(By.xpath("//a[@href='/tryEditor']"));
		if(list.size()>0)
		return driver.getTitle();
		return null;
	}
	
	public void click_TryEditor() {
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(tryeditor)).perform();
		driver.findElement(tryeditor).click();
		LoggerLoad.info("Clicking the tryEditor link");
	}
	public void checkTryEditorLink() {
		By tryeditor=By.xpath("//a[@href='/tryEditor']");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(tryeditor)).perform();
		driver.findElement(tryeditor).click();
		LoggerLoad.info("Clicking the tryEditor link");
	}
	public void navigate_arrayPracticePage()
	{
		hp.click_btn_Arraygetstarted();
		driver.findElement(lnk_ArraysinPython).click();
        driver.findElement(lnk_PracticeQuestions).click();
	}
	public void checkArrayPracticePageLink(String pageName) {
		if(pageName.equalsIgnoreCase("Search the array")) {
			driver.findElement(lnk_SearchtheArray).click();
			LoggerLoad.info("Clicking the Search the array link of array page");
		}
		else if(pageName.equalsIgnoreCase("Max Consecutive Ones")) {
			driver.findElement(lnk_MaxConsecutiveOnes).click();
			LoggerLoad.info("Clicking the Max Consecutive Ones link of array page");
		}
		else if(pageName.equalsIgnoreCase("Find Numbers with Even Number of Digits"))
			driver.findElement(lnk_FindNumbers).click();
		else if(pageName.equalsIgnoreCase("Squares of a Sorted Array"))
			driver.findElement(lnk_SquaresofaSortedArray).click();
		}
	
	public String validateArrayPracticePageTitles() {
		List<WebElement> list=driver.findElements(By.xpath("//input[@type='submit']"));
		if(list.size()>0)
		return driver.getTitle();
		return null;
	}



}




	