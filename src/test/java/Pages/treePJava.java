
package Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManager.DriverFactory;
import Utilities.LoggerLoad;

public class treePJava extends DriverFactory{
	//private static final By OverviewofTrees = null;
	//private static final By ApplicationsofBinaryTrees = null;
	WebDriver driver;

	public treePJava() {
		this.driver=DriverFactory.getDriver();
	}

	By OverviewofTrees1=By.xpath("//a[@href='overview-of-trees']");
	By Terminologies=By.xpath("//a[@href='terminologies']");
	By TypesofTrees=By.xpath("//a[@href='types-of-trees']");
	By TreeTraversals=By.xpath("//a[@href='tree-traversals']");
	By TraversalsIllustration=By.xpath("//a[@href='traversals-illustration']");
	By BinaryTrees=By.xpath("//a[@href='binary-trees']");
	By TypesofBinaryTrees=By.xpath("//a[@href='types-of-binary-trees']");
	By ImplementationinPython=By.xpath("//a[@href='implementation-in-python']");
	By BinaryTreeTraversals=By.xpath("//a[@href='binary-tree-traversals']");
	By ImplementationofBinaryTrees=By.xpath("//a[@href='implementation-of-binary-trees']");
	By ApplicationOfBinaryTrees=By.xpath("//a[@href='applications-of-binary-trees']");
	By BinarySearchtrees=By.xpath("//a[@href='binary-search-trees']");
	By ImplementationOfBST=By.xpath("//a[@href='implementation-of-bst']");
	By practice=By.xpath("//a[@href='/tree/practice']");

	
	public void checkTreePageLinks(String pageName) {
		if(pageName.equalsIgnoreCase("Overview of Trees")) {
			driver.findElement(OverviewofTrees1).click();
			LoggerLoad.info("Clicking the Overview of Trees link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Terminologies")) {
			driver.findElement(Terminologies).click();
			LoggerLoad.info("Clicking the Terminologies link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Types of Trees")) {
			driver.findElement(TypesofTrees).click();
			LoggerLoad.info("Clicking the Types of Trees link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Tree Traversals")) {
			driver.findElement(TreeTraversals).click();
			LoggerLoad.info("Clicking the Tree Traversals link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Traversals-Illustration")) {
			driver.findElement(TraversalsIllustration).click();
			LoggerLoad.info("Clicking the Traversals-Illustration link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Binary Trees")) {
			driver.findElement(BinaryTrees).click();
			LoggerLoad.info("Clicking the Binary Trees link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Types of Binary Trees")) {
			driver.findElement(TypesofBinaryTrees).click();
			LoggerLoad.info("Clicking the Types of Binary Trees link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Implementation in Python")) {
			driver.findElement(ImplementationinPython).click();
			LoggerLoad.info("Clicking the Implementation in Python link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Binary Tree Traversals")) {
			driver.findElement(BinaryTreeTraversals).click();
			LoggerLoad.info("Clicking the Binary Tree Traversals link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Implementation of Binary Trees")) {
			driver.findElement(ImplementationofBinaryTrees).click();
			LoggerLoad.info("Clicking the Implementation of Binary Trees link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Binary Search trees")) {
			driver.findElement(BinarySearchtrees).click();
			LoggerLoad.info("Clicking the Binary Search trees link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Applications of Binary Trees")) {
			driver.findElement(ApplicationOfBinaryTrees).click();
			LoggerLoad.info("Clicking the Applications of Binary Trees link of tree page");
		}
		else if(pageName.equalsIgnoreCase("Implementation Of BST")) {
			driver.findElement(ImplementationOfBST).click();
			LoggerLoad.info("Clicking the Implementation Of BST link of tree page");
		}
		else if(pageName.equalsIgnoreCase("practice-questions"))
			clickPracticeLink();
		
	}
	
	public void checkTryEditorLink() {
		By tryeditor=By.xpath("//a[@href='/tryEditor']");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(tryeditor)).click().build().perform();    
		LoggerLoad.info("Clicking the tryEditor link");
	}
	
	public void clickPracticeLink() {
		driver.findElement(ImplementationOfBST).click();
		driver.findElement(practice).click();
		LoggerLoad.info("Clicking the practice questions link of tree page");

	}
	public String validateTreePageTitles() {
		List<WebElement> list=driver.findElements(By.xpath("//a[@href='/tryEditor']"));
		if(list.size()>0)
		return driver.getTitle();
		return null;
	}
	public String getExcelPath() {
		return configReader.getTreeDataPath();
	}
}
