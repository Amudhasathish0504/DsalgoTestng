package testcases;



import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DataProvider.ExcelReader;
import Pages.HomePage;
import Pages.TryEditorPage;
import Pages.loginPage;
import Pages.treePJava;
import TestBaseClass.TestBase;
import retryautomation.Retryautomationscripts;

@Test(retryAnalyzer = Retryautomationscripts.class) 
@Listeners(listeners.TestStatusListener.class)
public class TreePageTest extends TestBase{
	loginPage lp;
	HomePage hp;
	treePJava T;
	String SharedpageName;
	TryEditorPage tp;
	List<Map<String,String>> excelData;

	@Parameters("browser")
	@BeforeMethod 
	public void BackgroundSetUp(String browser) {
		setUp(browser);
		lp=new loginPage();
		hp=new HomePage();
		T=new treePJava();
		tp=new TryEditorPage();
		lp.getStarted();
		lp.clkSignin();
		lp.enterLogin(configReader.getUserName(), configReader.getPassword());
		hp.clickTreeLink();
	}

	@DataProvider (name="treePJava") 
	public Object[][] treePJava() throws Exception {
		ExcelReader reader=new ExcelReader();
		excelData = reader.getData(configReader.getExcelDataPath(),"TreePage");
		Object[][] objArray=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
			objArray[i] = new Object[1];
			objArray[i][0] = excelData.get(i);
		} 
		return objArray;
	}

	@Test (dataProvider="treePJava")
	public void checkTreePageLinksTest(Map<String,String> data) {
		String pageName=data.get("Links");
		String expectedResult=data.get("Expected Result");
		T.checkTreePageLinks(pageName);
		Assert.assertEquals(T.validateTreePageTitles(), expectedResult);

	}
	@Test (dataProvider = "treePJava")
	public void checkGraphPageTryEditorLinkswithInvalidCodeTestforError(Map<String,String> data) {
		String pageName=data.get("Links");
		String invalidCode=data.get("InvalidCode");
		if(!(pageName.equalsIgnoreCase("practice-questions"))) {
			T.checkTreePageLinks(pageName);
			T.checkTryEditorLink();
			tp.checkCode(invalidCode);
			Assert.assertEquals(tp.isAlertPresent(), true);
			tp.acceptAlert();
		}
	}

	@Test (dataProvider = "treePJava")
	public void checkTreePageTryEditorLinksTest(Map<String,String> data) {
		String pageName=data.get("Links");
		if(!(pageName.equalsIgnoreCase("practice-questions"))) {
			T.checkTreePageLinks(pageName);
			T.checkTryEditorLink();
			Assert.assertEquals(hp.validatePageTitle(),"Assessment");
		}
	}

	@Test (dataProvider = "treePJava")
	public void checkTreePageTryEditorLinkswithNoScriptsTest(Map<String,String> data) {
		String pageName=data.get("Links");
		if(!(pageName.equalsIgnoreCase("practice-questions"))) {
			T.checkTreePageLinks(pageName);
			T.checkTryEditorLink();
			tp.checkCode(" ");
			Assert.assertEquals(tp.isAlertPresent(), false);
		}
	}

	@Test (dataProvider = "treePJava")
	public void checkTreePageTryEditorLinkswithInvalidCodeTest(Map<String,String> data) {
		String pageName=data.get("Links");
		String invalidCode=data.get("InvalidCode");
		if(invalidCode!=null) {
			T.checkTreePageLinks(pageName);
			T.checkTryEditorLink();
			tp.checkCode(invalidCode);
			tp.acceptAlert();
			Assert.assertEquals(hp.validatePageTitle(), "Assessment");
		}
	}
	@Test (dataProvider = "treePJava")
	public void checkTreePageTryEditorLinkswithValidCodeTest(Map<String,String> data) {
		String pageName=data.get("Links");
		String validCode=data.get("ValidCode");
		String expectedResult=data.get("Expected Result for Code");
		if(validCode!=null) {
			T.checkTreePageLinks(pageName);
			T.checkTryEditorLink();
			tp.checkCode(validCode);
			Assert.assertEquals(tp.validateOutput(), expectedResult);
		}
	}

	@AfterMethod
	public void tearDownDriver() {
		tearDown();

	}


}






