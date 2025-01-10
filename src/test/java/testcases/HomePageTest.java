package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import DriverManager.DriverFactory;
import Pages.HomePage;
import Pages.loginPage;
import testbase.TestBase;

public class HomePageTest extends TestBase{
	HomePage hp;
	loginPage lp;
	@BeforeMethod
	public void InitialSetUp() {
		setUp();
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
	@AfterMethod
	 public void tearDownDriver() {
    		tearDown();
    }

}
