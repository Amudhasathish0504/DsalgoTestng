package retryautomation;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryautomationscripts implements IRetryAnalyzer {
	
	private int retrycount = 0;
    private static final int maxcount = 3;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retrycount<maxcount)
		{
			retrycount++;
			System.out.println( "Retrying test " + result.getName() + "for the" + retrycount + "time(s).");
			return true;
		}
		System.out.println("Test" + result.getName() + "failed after" + retrycount + "attempts.");
				return false;
	}
	

}
