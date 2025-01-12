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
import org.testng.annotations.Test;

import DataProvider.ExcelReader;
import Pages.HomePage;
import Pages.TryEditorPage;
import Pages.arrayPage;
import Pages.loginPage;
import TestBaseClass.TestBase;
import retryautomation.Retryautomationscripts;

public class arraytest extends TestBase {
	loginPage lp;
	HomePage hp;
	arrayPage ap;
	String SharedpageName;
	TryEditorPage tp;
	List<Map<String,String>> excelData;
	@BeforeSuite
	public void LoadList() throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
        excelData = reader.getData(configReader.getExcelDataPath(),"ArrayPage");
	}
	@BeforeMethod 
	public void BackgroundSetUp() {
		setUp();
		lp=new loginPage();
		hp=new HomePage();
		ap=new arrayPage();
		tp=new TryEditorPage();
		lp.getStarted();
		lp.clkSignin();
		lp.enterLogin(configReader.getUserName(), configReader.getPassword());
		hp.click_btn_Arraygetstarted();
	}
	@DataProvider (name="arraypage") 
	public Object[][] arraypage() throws Exception {
		Object[][] objArray=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
            objArray[i] = new Object[1];
            objArray[i][0] = excelData.get(i);
          } 
         return objArray;
	}
	
		
	@Test (dataProvider = "arraypage",retryAnalyzer=Retryautomationscripts.class)


	public void checkArrayPageLinksTest(Map<String,String> data) {
			String pageName=data.get("Links");
			String expectedResult=data.get("Expected Result");
			ap.checkArrayPageLink(pageName);
			Assert.assertEquals(ap.validateArrayPageTitles(), expectedResult);
		
	}
	@Test (dataProvider = "arraypage",retryAnalyzer=Retryautomationscripts.class)
	public void checkArrayPageTryEditorLinkswithInvalidCodeTestforError(Map<String,String> data) {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(!(pageName.equalsIgnoreCase("practice questions"))) {
			ap.checkArrayPageLink(pageName);
			ap.click_TryEditor();
			tp.checkCode(invalidCode);
			Assert.assertEquals(tp.isAlertPresent(), true);
			tp.acceptAlert();
			}
	}
	
	@Test (dataProvider = "arraypage",retryAnalyzer=Retryautomationscripts.class)

	public void checkArrayPageTryEditorLinksTest(Map<String,String> data) {
			String pageName=data.get("Links");
			if(!(pageName.equalsIgnoreCase("practice questions"))) {
			ap.checkArrayPageLink(pageName);
			ap.checkTryEditorLink();
			Assert.assertEquals(hp.validatePageTitle(),"Assessment");
			}
	}
	@Test (dataProvider = "arraypage",retryAnalyzer=Retryautomationscripts.class)

		public void checkArrayPageTryEditorLinkswithNoScriptsTest(Map<String,String> data) {
		String pageName=data.get("Links");
		if(!(pageName.equalsIgnoreCase("practice questions"))) {
			ap.checkArrayPageLink(pageName);
			ap.checkTryEditorLink();
			tp.checkCode(" ");
			Assert.assertEquals(tp.isAlertPresent(), false);
		}
	}
	@Test (dataProvider = "arraypage",retryAnalyzer=Retryautomationscripts.class)

	public void checkArrayPageTryEditorLinkswithInvalidCodeTest(Map<String,String> data) {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(invalidCode!=null) {
		    ap.checkArrayPageLink(pageName);
		    ap.checkTryEditorLink();
			tp.checkCode(invalidCode);
			tp.acceptAlert();
			Assert.assertEquals(hp.validatePageTitle(), "Assessment");
			}
	}
	
	@Test (dataProvider = "arraypage",retryAnalyzer=Retryautomationscripts.class)
	public void checkArrayPageTryEditorLinkswithValidCodeTest(Map<String,String> data) {
		String pageName=data.get("Links");
		String validCode=data.get("ValidCode");
		String expectedResult=data.get("Expected Result for Code");
		if(validCode!=null) {
			ap.checkArrayPageLink(pageName);
		    ap.checkTryEditorLink();
			tp.checkCode(validCode);
			 Assert.assertEquals(tp.validateOutput(), expectedResult);
		}
	}

@AfterMethod
	 public void tearDownDriver() {
		tearDown();
		
 }

}
