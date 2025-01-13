package testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DataProvider.ConfigFileReader;
import DataProvider.ExcelReader;
import Pages.HomePage;
import Pages.loginPage;
import TestBaseClass.TestBase;

public class HomewithoutSignin  extends  TestBase {
	static ConfigFileReader configReader;
	String url ;
	HomePage homeObj;
	loginPage loginObj;
	List<Map<String,String>> excelData;

	@BeforeSuite
	public void beforeSuite() throws InvalidFormatException, IOException {
		System.out.println("BeforeSuite: Setting up the config reader");
		configReader=new ConfigFileReader();
		ExcelReader reader=new ExcelReader();
		excelData = reader.getData(configReader.getExcelDataPath(),"LoginValid");

	}

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		setUp(browser);
		loginObj= new loginPage();
		loginObj.getStarted();
		loginObj.clkSignin();
	}

	@Test(groups = {"home","smoke","regression"},  priority =1 ,dataProvider = "homepage")
	public void testValidLogin(Map<String,String> data) {
		System.out.println("Test (login): Executing testLogin valid.");	       
		String username=data.get("Username");
		String password=data.get("Password");
		String message=data.get("Message");
		loginObj.enterLogin(username,password);
		String actualMessage = loginObj.getErrorMsg();
		System.out.println(actualMessage);
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@Test(dependsOnMethods = "testValidLogin",groups =  {"home","regression"} ,priority =2, dataProvider = "homepage")
	public void testDSSignin(Map<String,String> data )
	{
		System.out.println("Test (home): Executing testArrayDSSignin.");
		loginObj.clkSignin();
		String username=data.get("Username");
		String password=data.get("Password");
		String ds_ListItem="Data Structures-Introduction";
		loginObj.enterLogin(username,password);
		loginObj.homeGetStarted("DS");
		Assert.assertEquals(ds_ListItem, loginObj.validatePageTitle());
	}
	
	@Test(dependsOnMethods = "testValidLogin",groups =  {"home","regression"} ,priority =3, dataProvider = "homepage")
	public void testArraySignin(Map<String,String> data )
	{
		System.out.println("Test (home): Executing testArrayDSSignin.");
		loginObj.clkSignin();
		String username=data.get("Username");
		String password=data.get("Password");
		String ds_ListItem="Array";
		loginObj.enterLogin(username,password);
		loginObj.homeGetStarted("array");
		Assert.assertEquals(ds_ListItem, loginObj.validatePageTitle());
	}
	
	@Test(dependsOnMethods = "testValidLogin",groups =  {"home","regression"} ,priority =3, dataProvider = "homepage")
	public void testListSignin(Map<String,String> data )
	{
		System.out.println("Test (home): Executing testListDSSignin.");
		loginObj.clkSignin();
		String username=data.get("Username");
		String password=data.get("Password");
		String ds_ListItem="Linked List";
		loginObj.enterLogin(username,password);
		loginObj.homeGetStarted("List");
		Assert.assertEquals(ds_ListItem, loginObj.validatePageTitle());
	}
	
	@Test(dependsOnMethods = "testValidLogin",groups =  {"home","regression"} ,priority =4, dataProvider = "homepage")
	public void testQueueSignin(Map<String,String> data )
	{
		System.out.println("Test (home): Executing testQueueDSSignin.");
		loginObj.clkSignin();
		String username=data.get("Username");
		String password=data.get("Password");
		String ds_ListItem="Queue";
		loginObj.enterLogin(username,password);
		loginObj.homeGetStarted("queue");
		Assert.assertEquals(ds_ListItem, loginObj.validatePageTitle());
	}
	
	@Test(dependsOnMethods = "testValidLogin",groups = "home" ,priority =5, dataProvider = "homepage")
	public void testStackSignin(Map<String,String> data )
	{
		System.out.println("Test (home): Executing testStackDSSignin.");
		loginObj.clkSignin();
		String username=data.get("Username");
		String password=data.get("Password");
		String ds_ListItem="Stack";
		loginObj.enterLogin(username,password);
		loginObj.homeGetStarted("stack");
		Assert.assertEquals(ds_ListItem, loginObj.validatePageTitle());
	}
	
	@Test(dependsOnMethods = "testValidLogin",groups =  {"home","regression"} ,priority =6, dataProvider = "homepage")
	public void testTreeSignin(Map<String,String> data )
	{
		System.out.println("Test (home): Executing testTreeDSSignin.");
		loginObj.clkSignin();
		String username=data.get("Username");
		String password=data.get("Password");
		String ds_ListItem="Tree";
		loginObj.enterLogin(username,password);
		loginObj.homeGetStarted("tree");
		Assert.assertEquals(ds_ListItem, loginObj.validatePageTitle());
	}
	
	@Test(dependsOnMethods = "testValidLogin",groups = "home" ,priority =7, dataProvider = "homepage")
	public void testGraphSignin(Map<String,String> data )
	{
		System.out.println("Test (home): Executing testGraphDSSignin.");
		loginObj.clkSignin();
		String username=data.get("Username");
		String password=data.get("Password");
		String ds_ListItem="Graph";
		loginObj.enterLogin(username,password);
		loginObj.homeGetStarted("graph");
		Assert.assertEquals(ds_ListItem, loginObj.validatePageTitle());
	}
	
	
	@DataProvider (name="homepage") 
	public Object[][] homepage(ITestNGMethod testContext) throws Exception {
		ExcelReader reader=new ExcelReader();
		excelData = reader.getData(configReader.getExcelDataPath(),"LoginValid");
		Object[][] xlData=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
			xlData[i] = new Object[1];
			xlData[i][0] = excelData.get(i);
		} 
		return xlData;
	}

	@AfterMethod
	public void tearDownDriver() {
		tearDown();

	}
}
