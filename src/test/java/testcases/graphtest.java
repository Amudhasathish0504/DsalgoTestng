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
	import org.testng.annotations.Test;

	import DataProvider.ExcelReader;
	import Pages.HomePage;
	import Pages.TryEditorPage;
	import Pages.loginPage;
	import Pages.Graph;
	import TestBaseClass.TestBase;
import retryautomation.Retryautomationscripts;

	@Listeners(listeners.TestStatusListener.class)
	public class graphtest extends TestBase{
		loginPage lp;
		HomePage hp;
		Graph gp;
		String SharedpageName;
		TryEditorPage tp;
		List<Map<String,String>> excelData;
		@BeforeSuite
		public void LoadList() throws InvalidFormatException, IOException {
			ExcelReader reader=new ExcelReader();
	        excelData = reader.getData(configReader.getExcelDataPath(),"GraphPage");
		}
		@BeforeMethod 
		public void BackgroundSetUp() {
			setUp();
			lp=new loginPage();
			hp=new HomePage();
			gp=new Graph();
			tp=new TryEditorPage();
			lp.getStarted();
			lp.clkSignin();
			lp.enterLogin(configReader.getUserName(), configReader.getPassword());
			hp.clickGraphLink();
		}
		
		@DataProvider (name="Graph") 
		public Object[][] Graph() throws Exception {
			Object[][] objArray=new Object[excelData.size()][];
			for(int i=0;i< excelData.size();i++){
	            objArray[i] = new Object[1];
	            objArray[i][0] = excelData.get(i);
	          } 
	         return objArray;
		}
		
		@Test (dataProvider="Graph",retryAnalyzer=Retryautomationscripts.class)
		public void checkGraphPageLinksTest(Map<String,String> data) {
				String pageName=data.get("Links");
				String expectedResult=data.get("Expected Result");
				gp.checkGraphPageLink(pageName);
				Assert.assertEquals(gp.validateGraphPageTitles(), expectedResult);
			
		}
		@Test (dataProvider = "Graph")
		public void checkGraphPageTryEditorLinkswithInvalidCodeTestforError(Map<String,String> data) {
				String pageName=data.get("Links");
				String invalidCode=data.get("InvalidCode");
				if(!(pageName.equalsIgnoreCase("practice-questions"))) {
				gp.checkGraphPageLink(pageName);
				gp.checkTryEditorLink();
				tp.checkCode(invalidCode);
				Assert.assertEquals(tp.isAlertPresent(), true);
				tp.acceptAlert();
				}
		}
		
		@Test (dataProvider = "Graph")
		public void checkGraphPageTryEditorLinksTest(Map<String,String> data) {
				String pageName=data.get("Links");
				if(!(pageName.equalsIgnoreCase("practice-questions"))) {
				gp.checkGraphPageLink(pageName);
				gp.checkTryEditorLink();
				Assert.assertEquals(hp.validatePageTitle(),"Assessment");
				}
		}
		
		@Test (dataProvider = "Graph")
		public void checkGraphPageTryEditorLinkswithNoScriptsTest(Map<String,String> data) {
			String pageName=data.get("Links");
			if(!(pageName.equalsIgnoreCase("practice-questions"))) {
				gp.checkGraphPageLink(pageName);
				gp.checkTryEditorLink();
				tp.checkCode(" ");
				Assert.assertEquals(tp.isAlertPresent(), false);
			}
		}
		
		@Test (dataProvider = "Graph")
		public void checkGraphPageTryEditorLinkswithInvalidCodeTest(Map<String,String> data) {
				String pageName=data.get("Links");
				String invalidCode=data.get("InvalidCode");
				if(invalidCode!=null) {
				gp.checkGraphPageLink(pageName);
				gp.checkTryEditorLink();
				tp.checkCode(invalidCode);
				tp.acceptAlert();
				Assert.assertEquals(hp.validatePageTitle(), "Assessment");
				}
		}
		@Test (dataProvider = "Graph")
		public void checkGraphPageTryEditorLinkswithValidCodeTest(Map<String,String> data) {
			String pageName=data.get("Links");
			String validCode=data.get("ValidCode");
			String expectedResult=data.get("Expected Result for Code");
			if(validCode!=null) {
				gp.checkGraphPageLink(pageName);
				gp.checkTryEditorLink();
				tp.checkCode(validCode);
				 Assert.assertEquals(tp.validateOutput(), expectedResult);
			}
		}
		
		@AfterMethod
		 public void tearDownDriver() {
			tearDown();
			
	   }

		
	}



