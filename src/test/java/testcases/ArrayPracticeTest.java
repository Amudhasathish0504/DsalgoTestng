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
import Pages.ArrayEditorPage;
import Pages.HomePage;
import Pages.TryEditorPage;
import Pages.arrayPage;
import Pages.loginPage;
import TestBaseClass.TestBase;
import retryautomation.Retryautomationscripts;

public class ArrayPracticeTest {
	public class arraytest extends TestBase {
		loginPage lp;
		HomePage hp;
		arrayPage ap;
		ArrayEditorPage ae;
		String SharedpageName;
		TryEditorPage tp;
		List<Map<String,String>> excelData;
		@Parameters("browser")
		@BeforeMethod 
		public void BackgroundSetUp(String browser) {
			setUp(browser);
			lp=new loginPage();
			hp=new HomePage();
			ap=new arrayPage();
			ae=new ArrayEditorPage();
			tp=new TryEditorPage();
			lp.getStarted();
			lp.clkSignin();
			lp.enterLogin(configReader.getUserName(), configReader.getPassword());
			ap.navigate_arrayPracticePage();
			
		}
		@DataProvider (name="arrayPracticepage") 
		public Object[][] arrayPracticepage() throws Exception {
			ExcelReader reader=new ExcelReader();
	        excelData = reader.getData(configReader.getExcelDataPath(),"PracticePage");
			Object[][] objArray=new Object[excelData.size()][];
			for(int i=0;i< excelData.size();i++){
	            objArray[i] = new Object[1];
	            objArray[i][0] = excelData.get(i);
	          } 
	         return objArray;
		}
		@Test (dataProvider = "arrayPracticepage",retryAnalyzer=Retryautomationscripts.class)		
		public void checkArrayPracticePageLinksTest(Map<String,String> data) {
				String pageName=data.get("Links");
				String expectedResult=data.get("Expected Result");
				ap.checkArrayPracticePageLink(pageName);
				Assert.assertEquals(ap.validateArrayPracticePageTitles(), expectedResult);
			
		}
		
		@Test (dataProvider = "arrayPracticepage",retryAnalyzer=Retryautomationscripts.class)		    
		public void checkArrayPracticePageTryEditorLinkswithInvalidCodeandClickRun(Map<String,String> data) throws InterruptedException {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(invalidCode!=null) {
		    ap.checkArrayPracticePageLink(pageName);
		    ae.Enter_inputCode(invalidCode);
			ae.click_run();
			Assert.assertEquals(tp.isAlertPresent(), true);
			}
	}
		
		    @Test (dataProvider = "arrayPracticepage",retryAnalyzer=Retryautomationscripts.class)			
		    public void checkArrayPracticePageTryEditorLinkswithInvalidCodeandClickSubmit(Map<String,String> data) throws InterruptedException {
			String pageName=data.get("Links");
			String invalidCode=data.get("InvalidCode");
			if(invalidCode!=null) {
		    ap.checkArrayPracticePageLink(pageName);
		    ae.Enter_inputCode(invalidCode);
			ae.click_submit();
			Thread.sleep(2000);
			Assert.assertEquals(ae.get_outputText(), "Error occurred during submission");
			
			}
	}
		
		    
			@Test (dataProvider = "arrayPracticepage",retryAnalyzer=Retryautomationscripts.class)
	
		public void checkArrayPageTryEditorLinkswithValidCodeTestandClickRunBTn(Map<String,String> data)   {
			String pageName=data.get("Links");
			String validCode=data.get("ValidCode");
			String expectedResult=data.get("Expected Result for Code");
			if(validCode!=null) {
				
				ap.checkArrayPracticePageLink(pageName);
				
				 ae.Enter_inputCode(validCode);
				
				//ae.Enter_inputCode("validCode");
			    ae.click_run();
			    
				Assert.assertEquals(ae.get_outputText(), expectedResult);
			}
		}
		
		@Test (dataProvider = "arrayPracticepage",retryAnalyzer=Retryautomationscripts.class)
		public void checkArrayPageTryEditorLinkswithValidCodeandClickSubmitBtn(Map<String,String> data) throws InterruptedException  {
			String pageName=data.get("Links");
			String validCode=data.get("ValidCode");
		
			if(validCode!=null) {
				ap.checkArrayPracticePageLink(pageName);
				ae.Enter_inputCode(validCode);
				ae.click_run();
				Thread.sleep(2000);
				ae.click_submit();
				Assert.assertEquals(ae.get_outputText(), "Submission successful");
			}
		}
		

		
		
		
		@AfterMethod
		 public void tearDownDriver() {
			tearDown();
			
	 }

		

}}
