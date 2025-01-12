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
import Pages.dataStructureIntroductionPage;
import Pages.loginPage;
import TestBaseClass.TestBase;
import retryautomation.Retryautomationscripts;

public class dataStructuresIntroPage extends TestBase {
	loginPage lp;
	HomePage hp;
	dataStructureIntroductionPage dp;
	String SharedpageName;
	TryEditorPage tp;
	List<Map<String,String>> excelData;
	@BeforeSuite
	public void LoadList() throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
        excelData = reader.getData(configReader.getExcelDataPath(),"DataPage");
	}
	@BeforeMethod 
	public void BackgroundSetUp() {
		setUp();
		lp=new loginPage();
		hp=new HomePage();
		dp=new dataStructureIntroductionPage();
		tp=new TryEditorPage();
		lp.getStarted();
		lp.clkSignin();
		lp.enterLogin(configReader.getUserName(), configReader.getPassword());
		hp.click_dataGetStarted();
	}
	@DataProvider (name="datapage") 
	public Object[][] arraypage() throws Exception {
		Object[][] objArray=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
            objArray[i] = new Object[1];
            objArray[i][0] = excelData.get(i);
          } 
         return objArray;
	}
	@Test (dataProvider = "datapage",retryAnalyzer=Retryautomationscripts.class)

	public void checkListPageLinksTest(Map<String,String> data) {
			String pageName=data.get("Links");
			String expectedResult=data.get("Expected Result");
			dp.checkListPageLink(pageName);
			Assert.assertEquals(dp.validateListPageTitles(), expectedResult);		
	}
	
	@Test (dataProvider = "datapage",retryAnalyzer=Retryautomationscripts.class)

	public void checkListPageTryEditorLinkswithInvalidCodeTestforError(Map<String,String> data) {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(!(pageName.equalsIgnoreCase("practice questions"))) {
			dp.navigate_time_complexity();
			dp.click_TryEditor();
			tp.checkCode(invalidCode);
			Assert.assertEquals(tp.isAlertPresent(), true);
			tp.acceptAlert();
			}
	}
	
	@Test (dataProvider = "datapage",retryAnalyzer=Retryautomationscripts.class)

	public void checkListPageTryEditorLinksTest(Map<String,String> data) {
			String pageName=data.get("Links");
			if(!(pageName.equalsIgnoreCase("practice questions"))) {
			dp.navigate_time_complexity();
			dp.click_TryEditor();
			Assert.assertEquals(hp.validatePageTitle(),"Assessment");
			}
	}
	@Test (dataProvider = "datapage",retryAnalyzer=Retryautomationscripts.class)

			public void checkListPageTryEditorLinkswithNoScriptsTest(Map<String,String> data) {
		String pageName=data.get("Links");
		if(!(pageName.equalsIgnoreCase("practice questions"))) {
			dp.navigate_time_complexity();
			dp.click_TryEditor();			
			tp.checkCode(" ");
			Assert.assertEquals(tp.isAlertPresent(), false);
		}
	}
	
	@Test (dataProvider = "datapage",retryAnalyzer=Retryautomationscripts.class)

	public void checkListPageTryEditorLinkswithInvalidCodeTest(Map<String,String> data) {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(invalidCode!=null) {
				dp.navigate_time_complexity();
				dp.click_TryEditor();
		    	tp.checkCode(invalidCode);
			tp.acceptAlert();
			Assert.assertEquals(hp.validatePageTitle(), "Assessment");
			}
	}
	
	@Test (dataProvider = "datapage",retryAnalyzer=Retryautomationscripts.class)


	public void checkListPageTryEditorLinkswithValidCodeTest(Map<String,String> data) {
		String pageName=data.get("Links");
		String validCode=data.get("ValidCode");
		String expectedResult=data.get("Expected Result for Code");
		if(validCode!=null) {
			dp.navigate_time_complexity();
			dp.click_TryEditor();
			tp.checkCode(validCode);
			 Assert.assertEquals(tp.validateOutput(), expectedResult);
		}
	}

@AfterMethod
	 public void tearDownDriver() {
		tearDown();
		
 }
	
	

}
