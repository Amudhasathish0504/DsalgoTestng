package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.Basetest;
import Pages.HomePage;
import Pages.arrayPage;

public class arraytest extends Basetest {
	HomePage hp=new HomePage();
	arrayPage ap=new arrayPage();

	
   @Test(priority=2)
	public void TestNavigationofArrayPage()
	{
	   

		hp.click_btn_Arraygetstarted();
		Assert.assertEquals(ap.validatePageTitle(),"Array") ;
		
	}
   @Test(priority=1)
   public void testNavigationofArraysinPythonPage() 
   {
	   hp.click_btn_Arraygetstarted();
	   ap.navigate_arraysinPythonPage();
	   
	   Assert.assertEquals("Arrays in Python", ap.validatePageTitle());
   }

}
