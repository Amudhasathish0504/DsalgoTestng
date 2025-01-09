package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.Basetest;
import Pages.HomePage;
import Pages.TryEditorPage;
import Pages.arrayPage;

public class arraytest extends Basetest {
	@BeforeMethod
	public void setup()  {
		hp = new HomePage();
        ap=new arrayPage();
        tp=new TryEditorPage();
}
	HomePage hp=new HomePage();
	arrayPage ap=new arrayPage();
	TryEditorPage tp=new TryEditorPage();

	
   @Test
	public void TestNavigationofArrayPage()
	{
	   

		hp.click_btn_Arraygetstarted();
		Assert.assertEquals(ap.validatePageTitle(),"Array") ;
		
	}
      @Test
      public void testNavigationofArraysinPythonPage() 
   {
	   hp.click_btn_Arraygetstarted();
	   ap.navigate_arraysinPythonPage();
	   
	   Assert.assertEquals("Arrays in Python", ap.validatePageTitle());
   }
   @Test   
  public void testNavigationofTryeditorPageofArraysinPythonPage()
  {
	  hp.click_btn_Arraygetstarted();
	  ap.navigate_arraysinPythonPage();
	  ap.click_TryEditor();
	  Assert.assertEquals(ap.validatePageTitle(), "Assessment");    
	  
  }
  
   @Test

      public void testTryeditorWithoutCode()
      {
    	  hp.click_btn_Arraygetstarted();
    	  ap.navigate_arraysinPythonPage();
    	  ap.click_TryEditor();
    	  tp.click_runBtn();
    	  Assert.assertEquals(tp.isAlertPresent(), false);
      }
   
  


}
