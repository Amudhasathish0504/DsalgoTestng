package testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DataProvider.ExcelReader;
import Pages.HomePage;
import Pages.TryEditorPage;
import Pages.linkedListPage;
import Pages.loginPage;
import TestBaseClass.TestBase;
import retryautomation.Retryautomationscripts;

public class LinkedListPageTest extends TestBase {
	loginPage lp;
	HomePage hp;
	linkedListPage Lp;
	String SharedpageName;
	TryEditorPage tp;
	List<Map<String,String>> excelData;
	@Parameters("browser")
	@BeforeMethod 
	public void BackgroundSetUp(String browser) {
		setUp(browser);
		lp=new loginPage();
		hp=new HomePage();
		Lp=new linkedListPage();
		tp=new TryEditorPage();
		lp.getStarted();
		lp.clkSignin();
		lp.enterLogin(configReader.getUserName(), configReader.getPassword());
		hp.navigate_linkedlistPage();
	}
	@DataProvider (name="listpage") 
	public Object[][] listpage() throws Exception {
		ExcelReader reader=new ExcelReader();
        excelData = reader.getData(configReader.getExcelDataPath(),"ListPage");
		Object[][] objArray=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
            objArray[i] = new Object[1];
            objArray[i][0] = excelData.get(i);
          } 
         return objArray;
	}
	@Test (dataProvider = "listpage",retryAnalyzer=Retryautomationscripts.class)

	public void checkListPageLinksTest(Map<String,String> data) {
			String pageName=data.get("Links");
			String expectedResult=data.get("Expected Result");
		    Lp.checkListPageLink(pageName);
			Assert.assertEquals(Lp.validateListPageTitles(), expectedResult);
		
	}
	@Test (dataProvider = "listpage",retryAnalyzer=Retryautomationscripts.class)
	public void checkListPageTryEditorLinkswithInvalidCodeTestforError(Map<String,String> data) {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(!(pageName.equalsIgnoreCase("practice questions"))) {
			Lp.checkListPageLink(pageName);
			Lp.checkTryEditorLink();
			tp.checkCode(invalidCode);
			Assert.assertEquals(tp.isAlertPresent(), true);
			tp.acceptAlert();
			}
	}
	
	@Test (dataProvider = "listpage",retryAnalyzer=Retryautomationscripts.class)

	public void checkListPageTryEditorLinksTest(Map<String,String> data) {
			String pageName=data.get("Links");
			if(!(pageName.equalsIgnoreCase("practice questions"))) {
				Lp.checkListPageLink(pageName);
				Lp.checkTryEditorLink();
			Assert.assertEquals(hp.validatePageTitle(),"Assessment");
			}
	}
	@Test (dataProvider = "listpage",retryAnalyzer=Retryautomationscripts.class)

		public void checkListPageTryEditorLinkswithNoScriptsTest(Map<String,String> data) {
		String pageName=data.get("Links");
		if(!(pageName.equalsIgnoreCase("practice questions"))) {
			Lp.checkListPageLink(pageName);
			Lp.checkTryEditorLink();
			tp.checkCode(" ");
			Assert.assertEquals(tp.isAlertPresent(), false);
		}
	}
	@Test (dataProvider = "listpage",retryAnalyzer=Retryautomationscripts.class)

	public void checkListPageTryEditorLinkswithInvalidCodeTest(Map<String,String> data) {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(invalidCode!=null) {
				Lp.checkListPageLink(pageName);
				Lp.checkTryEditorLink();
			tp.checkCode(invalidCode);
			tp.acceptAlert();
			Assert.assertEquals(hp.validatePageTitle(), "Assessment");
			}
	}
	
	@Test (dataProvider = "listpage",retryAnalyzer=Retryautomationscripts.class)
	public void checkListPageTryEditorLinkswithValidCodeTest(Map<String,String> data) {
		String pageName=data.get("Links");
		String validCode=data.get("ValidCode");
		String expectedResult=data.get("Expected Result for Code");
		if(validCode!=null) {
			Lp.checkListPageLink(pageName);
			Lp.checkTryEditorLink();
			tp.checkCode(validCode);
			 Assert.assertEquals(tp.validateOutput(), expectedResult);
		}
	}
	@AfterMethod
	 public void tearDownDriver() {
		tearDown();
		
}


	

}
