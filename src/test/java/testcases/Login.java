package testcases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
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


public class Login extends  TestBase {
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

	@Test(groups = {"login","smoke","regression"},  priority =1 ,dataProvider = "loginpage")
	public void testValidLogin(Map<String,String> data) {
		System.out.println("Test (login): Executing testLogin valid.");	       
		String username=data.get("Username");
		String password=data.get("Password");
		String message=data.get("Message");
		System.out.println(username + "_____"+ password);
		loginObj.enterLogin(username,password);
		String actualMessage = loginObj.getErrorMsg();
		System.out.println(actualMessage);
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, actualMessage);
	}
//
	@Test(groups = {"login","regression"}, priority =2 ,dataProvider = "loginpage")
	public void testInValidLogin(Map<String,String> data) {
		System.out.println("Test (login): Executing testLogin invalid.");	        
		String username=data.get("Username");
		String password=data.get("Password");
		String message=data.get("Message");
		loginObj.enterLogin(username,password);
		String actualMessage = loginObj.getErrorMsg();
		System.out.println(actualMessage);
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	@Test(groups = {"login"}, priority =3)
	public void testEmptyLogin() {
		System.out.println("Test (login): Executing testLogin invalid.");	        
		String username="";
		String password="";
		String message="Login";
		loginObj.enterLogin(username,password);
		String title = loginObj.validatePageTitle();
		System.out.println(title);
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, title);
	}
	
	@Test(groups = {"login","smoke","regression"}, priority =4 ,dataProvider = "loginpage")
	public void testInValidUserName(Map<String,String> data) {
		System.out.println("Test (login): Executing testLogin invalid.");	        
		String username=data.get("Username");
		String password=data.get("Password");
		String message=data.get("Message");
		loginObj.enterLogin(username,password);
		String actualMessage = loginObj.getErrorMsg();
		System.out.println(actualMessage);
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test(groups = {"login","smoke","regression"}, priority =5,dataProvider = "loginpage")
	public void testSignout(Map<String,String> data) {
		System.out.println("Test (login): Executing testLogin invalid.");	        
		String username=data.get("Username");
		String password=data.get("Password");
		String message="NumpyNinja";
		loginObj.enterLogin(username,password);
		loginObj.clk_signout();
		String title = loginObj.validatePageTitle();
		System.out.println(title);
		String expectedMessage= message;
		Assert.assertEquals(expectedMessage, title);
	}

	@DataProvider (name="loginpage") 
	public Object[][] loginpage(ITestNGMethod testContext) throws Exception {
		ExcelReader reader=new ExcelReader();
		if((testContext.getMethodName().equals("testValidLogin"))||(testContext.getMethodName().equals("testSignout")))
		{
			excelData = reader.getData(configReader.getExcelDataPath(),"LoginValid");
		}
		else
		{

			excelData = reader.getData(configReader.getExcelDataPath(),"LoginInvalid");
		}
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
