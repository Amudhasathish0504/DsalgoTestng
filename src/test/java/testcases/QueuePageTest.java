
package testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProvider.ExcelReader;
import Pages.HomePage;
import Pages.QueuePage;
import Pages.TryEditorPage;
import Pages.loginPage;
import testbase.TestBase;

public class QueuePageTest extends TestBase{
	loginPage lp;
	HomePage hp;
	QueuePage qp;
	TryEditorPage tp;
	List<Map<String,String>> excelData;
	@BeforeClass
	public void LoadList() throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
        excelData = reader.getData(configReader.getExcelDataPath(),"QueuePage");
	}
	@BeforeMethod 
	public void BackgroundSetUp() {
		setUp();
		lp=new loginPage();
		hp=new HomePage();
		qp=new QueuePage();
		tp=new TryEditorPage();
		lp.getStarted();
		lp.clkSignin();
		lp.enterLogin(configReader.getUserName(), configReader.getPassword());
		hp.clickQueueFromDropDown();
	}
	
	@DataProvider (name="queuepage") 
	public Object[][] queuepage() throws Exception {
		Object[][] objArray=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
            objArray[i] = new Object[1];
            objArray[i][0] = excelData.get(i);
          } 
         return objArray;
	}
	
	@Test (dataProvider="queuepage")
	public void checkqueuepageLinksTest(Map<String,String> data) {
			String pageName=data.get("links");
			String expectedResult=data.get("Expected Result");
			qp.checkQueuePageLink(pageName);
			Assert.assertEquals(qp.validateQueuePageTitles(), expectedResult);
		
	}
	@Test (dataProvider = "queuepage")
	public void checkqueuepageTryEditorLinkswithInvalidCodeTestforError(Map<String,String> data) {
			String pageName=data.get("links");
			String invalidCode=data.get("InvalidCode");
			if(!(pageName.equalsIgnoreCase("practice questions"))) {
			qp.checkQueuePageLink(pageName);
			qp.checkTryEditorLink();
			tp.checkCode(invalidCode);
			Assert.assertEquals(tp.isAlertPresent(), true);
			tp.acceptAlert();
			}
	}
	
	@Test (dataProvider = "queuepage")
	public void checkqueuepageTryEditorLinksTest(Map<String,String> data) {
			String pageName=data.get("links");
			if(!(pageName.equalsIgnoreCase("practice questions"))) {
			qp.checkQueuePageLink(pageName);
			qp.checkTryEditorLink();
			Assert.assertEquals(hp.validatePageTitle(),"Assessment");
			}
	}
	
	@Test (dataProvider = "queuepage")
	public void checkqueuepageTryEditorLinkswithNoScriptsTest(Map<String,String> data) {
		String pageName=data.get("links");
		if(!(pageName.equalsIgnoreCase("practice questions"))) {
			qp.checkQueuePageLink(pageName);
			qp.checkTryEditorLink();
			tp.checkCode(" ");
			Assert.assertEquals(tp.isAlertPresent(), false);
		}
	}
	
	@Test (dataProvider = "queuepage")
	public void checkqueuepageTryEditorLinkswithInvalidCodeTest(Map<String,String> data) {
			String pageName=data.get("links");
			String invalidCode=data.get("InvalidCode");
			if(invalidCode!=null) {
			qp.checkQueuePageLink(pageName);
			qp.checkTryEditorLink();
			tp.checkCode(invalidCode);
			tp.acceptAlert();
			Assert.assertEquals(hp.validatePageTitle(), "Assessment");
			}
	}
	@Test (dataProvider = "queuepage")
	public void checkqueuepageTryEditorLinkswithValidCodeTest(Map<String,String> data) {
		String pageName=data.get("links");
		String validCode=data.get("ValidCode");
		String expectedResult=data.get("Expected Result for Code");
		if(validCode!=null) {
			qp.checkQueuePageLink(pageName);
			qp.checkTryEditorLink();
			tp.checkCode(validCode);
			 Assert.assertEquals(tp.validateOutput(), expectedResult);
		}
	}
	
	@AfterMethod
	 public void tearDownDriver() {
		tearDown();
		
   }

	
}
