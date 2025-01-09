package testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProvider.ExcelReader;
import DriverManager.DriverFactory;
import Pages.HomePage;
import Pages.TryEditorPage;
import Pages.loginPage;
import Pages.stackPage;
import testbase.TestBase;

public class StackPageTest extends TestBase{
	loginPage lp;
	HomePage hp;
	stackPage sp=new stackPage();
	TryEditorPage tp=new TryEditorPage();
	List<Map<String,String>> excelData;
	@BeforeClass
	public void LoadList() throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
        excelData = reader.getData(configReader.getExcelDataPath(),"StackPage");
	}
	@BeforeMethod 
	public void BackgroundSetUp() {
		setUp();
		lp=new loginPage(DriverFactory.getDriver());
		hp=new HomePage();
		lp.getStarted();
		lp.clkSignin();
		lp.enterLogin(configReader.getUserName(), configReader.getPassword());
		hp.clickStackLink();
	}
	
	@Test (dataProvider = "StackPage")
	public void checkStackPageLinksTest(String pageName,String expectedResult) {
			sp.checkStackPageLink(pageName);
			Assert.assertEquals(sp.validateStackPageTitles(), expectedResult);
		
	}
	@Test (dataProvider = "StackTryEditorPage")
	public void checkStackPageTryEditorLinksTest(String pageName) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			Assert.assertEquals(hp.validatePageTitle(),"Assessment");
		
	}
	
	@Test (dataProvider = "StackTryEditorPage")
	public void checkStackPageTryEditorLinkswithNoScriptsTest(String pageName) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			tp.checkCode(" ");
			Assert.assertEquals(tp.isAlertPresent(), false);
	}
	
	@Test (dataProvider = "StackTryEditorInvalidCode")
	public void checkStackPageTryEditorLinkswithInvalidCodeTestforError(String pageName,String invalidCode) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			tp.checkCode(invalidCode);
			Assert.assertEquals(tp.isAlertPresent(), true);
			tp.acceptAlert();
	}
	
	@Test (dataProvider = "StackTryEditorInvalidCode")
	public void checkStackPageTryEditorLinkswithInvalidCodeTest(String pageName,String invalidCode) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			tp.checkCode(invalidCode);
			tp.acceptAlert();
			Assert.assertEquals(hp.validatePageTitle(), "Assessment");
	}
	@Test (dataProvider = "StackTryEditorValidCode")
	public void checkStackPageTryEditorLinkswithValidCodeTest(String pageName,String validCode,String expectedResult) {
			sp.checkStackPageLink(pageName);
			sp.checkTryEditorLink();
			tp.checkCode(validCode);
			 Assert.assertEquals(tp.validateOutput(), expectedResult);
	}
	@DataProvider
    public Object[][] StackTryEditorPage() throws Exception{
		Object [][] objArray = new Object[excelData.size()-1][];
         for(int i=0;i< excelData.size()-1;i++){
            objArray[i] = new Object[1];
            objArray[i][0] = excelData.get(i).get("Links");
          } 
         return objArray;

		}
	@DataProvider
    public Object[][] StackPage() throws Exception{
		 Object [][] objArray = new Object[excelData.size()][];
         for(int i=0;i< excelData.size();i++){
            objArray[i] = new Object[2];
            objArray[i][0] = excelData.get(i).get("Links");
            objArray[i][1] = excelData.get(i).get("Expected Result");
         } 
         return objArray;

		}
	@DataProvider
    public Object[][] StackTryEditorInvalidCode() throws Exception{
		 Object [][] objArray = new Object[excelData.size()-1][];
         for(int i=0;i< excelData.size()-1;i++){
            objArray[i] = new Object[2];
            objArray[i][0] = excelData.get(i).get("Links");
            objArray[i][1] = excelData.get(i).get("InvalidCode");
         } 
         return objArray;

		}
	@DataProvider
    public Object[][] StackTryEditorValidCode() throws Exception{
		 Object [][] objArray = new Object[excelData.size()-1][];
         for(int i=0;i< excelData.size()-1;i++){
            objArray[i] = new Object[3];
            objArray[i][0] = excelData.get(i).get("Links");
            objArray[i][1] = excelData.get(i).get("ValidCode");
            objArray[i][2] = excelData.get(i).get("Expected Result for Code");
         } 
         return objArray;

		}
	
	@AfterClass
	 public void tearDownDriver() {
   		tearDown();
   }

	
}
