package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.Basetest;
import Pages.HomePage;
import Pages.arrayPage;

public class arraytest extends Basetest {
	HomePage hp=new HomePage();
	arrayPage ap=new arrayPage();

	
   @Test
	public void TestNavigationofArrayPage()
	{
	   

		hp.click_btn_Arraygetstarted();
		Assert.assertEquals(ap.validatePageTitle(),"Array") ;
		
	}

}
