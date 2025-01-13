package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import DriverManager.DriverFactory;
import Pages.HomePage;
import Pages.loginPage;
import TestBaseClass.TestBase;
import retryautomation.Retryautomationscripts;
@Test(retryAnalyzer = Retryautomationscripts.class) 
public class HomePageTest extends TestBase{
	HomePage hp;
	loginPage lp;
	@Parameters("browser")
	@BeforeMethod
	public void InitialSetUp(@Optional("chrome")String browser) {
		setUp(browser);
		 hp=new HomePage();
		 lp=new loginPage();
		
		lp.getStarted();
		lp.clkSignin();
		lp.enterLogin(configReader.getUserName(), configReader.getPassword());
	}
	@Test
	public void clickStackLinkTest() {
		hp.clickStackLink();
		Assert.assertEquals(hp.validatePageTitle(), "Stack");
	}
	
	@Test
	public void clickQueueDropDownTest() {
		hp.clickQueueFromDropDown();
		Assert.assertEquals(hp.validatePageTitle(), "Queue");
	}
	@Test
	public void clickTreeDropDownTest() {
		hp.clickTreeFromDropDown();
		Assert.assertEquals(hp.validatePageTitle(), "Tree");
	}
	@Test
	public void clickGraphLinkTest() {
		hp.clickGraphLink();
		Assert.assertEquals(hp.validatePageTitle(), "Graph") ;
	}

	
	@AfterMethod
	 public void tearDownDriver() {
    		tearDown();
    }

}
