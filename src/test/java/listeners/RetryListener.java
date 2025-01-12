package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.xml.XmlTest;

import retryautomation.Retryautomationscripts;

public class RetryListener implements IAnnotationTransformer {
	
	public void transform(ITestAnnotation annotation, Class testClass, java.lang.reflect.Method testMethod,   
			Class<?>[] params, XmlTest xmlTest )
	{
		annotation.setRetryAnalyzer(Retryautomationscripts.class);
	}

}
