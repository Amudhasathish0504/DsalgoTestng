
package testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DataProvider.ExcelReader;
import Pages.HomePage;
import Pages.TryEditorPage;
import Pages.loginPage;
import Pages.stackPage;
import TestBaseClass.TestBase;
import retryautomation.Retryautomationscripts;

public class StackPageTest extends TestBase{
	loginPage lp;
	HomePage hp;
	stackPage sp;
	String SharedpageName;
	TryEditorPage tp;
	List<Map<String,String>> excelData;
	
	@Parameters("browser")
	@BeforeMethod 
	public void BackgroundSetUp(@Optional("chrome")String browser) {
		setUp(browser);
		lp=new loginPage();
		hp=new HomePage();
		sp=new stackPage();
		tp=new TryEditorPage();
		lp.getStarted();
		lp.clkSignin();
		lp.enterLogin(configReader.getUserName(), configReader.getPassword());
		hp.clickStackLink();
	}
	
	@DataProvider (name="stackpage") 
	public Object[][] stackpage() throws Exception {
		ExcelReader reader=new ExcelReader();
        excelData = reader.getData(configReader.getExcelDataPath(),"StackPage");
		Object[][] objArray=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
            objArray[i] = new Object[1];
            objArray[i][0] = excelData.get(i);
          } 
         return objArray;
	}
	
	@Test (dataProvider="stackpage",retryAnalyzer=Retryautomationscripts.class)
	public void checkStackPageLinksTest(Map<String,String> data) {
			String pageName=data.get("Links");
			String expectedResult=data.get("Expected Result");
			sp.checkStackPageLink(pageName);
			Assert.assertEquals(sp.validateStackPageTitles(), expectedResult);
		
	}
	@Test (dataProvider = "stackpage",retryAnalyzer=Retryautomationscripts.class)
	public void checkStackPageTryEditorLinkswithInvalidCodeTestforError(Map<String,String> data) {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(!(pageName.equalsIgnoreCase("practice-questions"))) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			tp.checkCode(invalidCode);
			Assert.assertEquals(tp.isAlertPresent(), true);
			tp.acceptAlert();
			}
	}
	
	@Test (dataProvider = "stackpage",retryAnalyzer=Retryautomationscripts.class)
	public void checkStackPageTryEditorLinksTest(Map<String,String> data) {
			String pageName=data.get("Links");
			if(!(pageName.equalsIgnoreCase("practice-questions"))) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			Assert.assertEquals(hp.validatePageTitle(),"Assessment");
			}
	}
	
	@Test (dataProvider = "stackpage",retryAnalyzer=Retryautomationscripts.class)
	public void checkStackPageTryEditorLinkswithNoScriptsTest(Map<String,String> data) {
		String pageName=data.get("Links");
		if(!(pageName.equalsIgnoreCase("practice-questions"))) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			tp.checkCode(" ");
			Assert.assertEquals(tp.isAlertPresent(), false);
		}
	}
	
	@Test (dataProvider = "stackpage",retryAnalyzer=Retryautomationscripts.class)
	public void checkStackPageTryEditorLinkswithInvalidCodeTest(Map<String,String> data) {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(invalidCode!=null) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			tp.checkCode(invalidCode);
			tp.acceptAlert();
			Assert.assertEquals(hp.validatePageTitle(), "Assessment");
			}
	}
	
	
	@Test (dataProvider = "stackpage",retryAnalyzer=Retryautomationscripts.class)
	public void checkStackPageTryEditorLinkswithValidCodeTest(Map<String,String> data) {
		String pageName=data.get("Links");
		String validCode=data.get("ValidCode");
		String expectedResult=data.get("Expected Result for Code");
		if(validCode!=null) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			tp.checkCode(validCode);
			 Assert.assertEquals(tp.validateOutput(), expectedResult);
		}
	}
	
	@AfterMethod
	 public void tearDownDriver() {
		tearDown();
		
   }

	
}
