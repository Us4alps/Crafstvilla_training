package com.craftsvilla.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class iTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
			String name = result.getMethod().getMethodName(); // gets the method name as the screenshots should be saved according to testcase name
			EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver); // ??? helps handle events on a webelement
						
			try {
				File src = event.getScreenshotAs(OutputType.FILE); // captures image
				FileUtils.copyFile(src, new File("./Screenshots/" +name + ".png")); // copies the image on the Screenshots folder with.png extension
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	} 

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
