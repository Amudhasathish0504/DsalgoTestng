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
import Pages.RegisterPO;
import Pages.loginPage;
import TestBaseClass.TestBase;

public class RegisterTS  extends  TestBase {
	static ConfigFileReader configReader;
	String url ;
	HomePage homeObj;
	loginPage loginObj;
	RegisterPO registerObj;
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
		registerObj=new RegisterPO();
		loginObj.getStarted();
		registerObj.click_register();
	}

	@Test(groups = { "register","smoke","regression"},  priority =1 ,dataProvider = "registerpage")
	public void testValidRegister(Map<String,String> data) {
		String username=data.get("UserName");
		String password=data.get("Password");
		String Cnf_password=data.get("cnfPassword");
		registerObj.EnterValues(username,password,Cnf_password);
		String expectedMessage=data.get("Message");
		String actualMessage = registerObj.getErrorMsg();
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	
	@Test(groups = { "register","regression"},  priority =3 )
	public void testRegisterEmpty() {
		String username="";
		String password="";
		String Cnf_password="";
		registerObj.EnterValues(username,password,Cnf_password);
		Assert.assertEquals("Registration", registerObj.validatePageTitle());
	}
	
	@Test(groups = { "register","regression"},  priority =2 ,dataProvider = "registerpage")
	public void testInValidRegister(Map<String,String> data) {
		String username=data.get("UserName");
		String password=data.get("Password");
		String Cnf_password=data.get("cnfPassword");
		registerObj.EnterValues(username,password,Cnf_password);
		String expectedMessage=data.get("Message");
		String actualMessage = registerObj.getErrorMsg();
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test(groups = { "register","regression"},  priority =5 ,dataProvider = "registerpage")
	public void testPwdGreaterThan8(Map<String,String> data) {
		String username=data.get("UserName");
		String password=data.get("Password");
		String Cnf_password=data.get("cnfPassword");
		if(password.length()>8)
		{
		registerObj.EnterValues(username,password,Cnf_password);
		String expectedMessage=data.get("Message");
		String actualMessage = registerObj.getErrorMsg();
		Assert.assertEquals(expectedMessage, actualMessage);
		}
		else
		{
			Assert.assertEquals("Registration",registerObj.validatePageTitle());
		}
		
	}

	@Test(groups = { "register","regression"},  priority =4 ,dataProvider = "registerpage")
	public void testMismatchedPwdCNF(Map<String,String> data) {
		String username=data.get("UserName");
		String password=data.get("Password");
		String Cnf_password=data.get("cnfPassword");
		registerObj.EnterValues(username,password,Cnf_password);
		String expectedMessage=data.get("Message");
		String actualMessage = registerObj.getErrorMsg();
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	
	
	
	@DataProvider (name="registerpage") 
	public Object[][] registerpage(ITestNGMethod testContext) throws Exception {
		ExcelReader reader=new ExcelReader();
		if((testContext.getMethodName().equals("testValidRegister"))||(testContext.getMethodName().equals("testSignout")))
		{
			excelData = reader.getData(configReader.getExcelDataPath(),"RegisterValid");
		}
		else
		{

			excelData = reader.getData(configReader.getExcelDataPath(),"RegisterInvalid");
		}
		Object[][] xlData=new Object[excelData.size()][];
		for(int i=0;i< excelData.size();i++){
			xlData[i] = new Object[1];
			xlData[i][0] = excelData.get(i);
		} 
		return xlData;
	}

	@Test(groups = "register",  priority =2 ,dataProvider = "registerpage")
	public void testExistingUser(Map<String,String> data) {
		String username=data.get("UserName");
		String password=data.get("Password");
		String Cnf_password=data.get("cnfPassword");
		registerObj.EnterValues(username,password,Cnf_password);
		String expectedMessage=data.get("Message");
		String actualMessage = registerObj.getErrorMsg();
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@AfterMethod
	public void tearDownDriver() {
		tearDown();

	}
}
