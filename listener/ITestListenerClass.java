package com.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.akash.testing.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ITestListenerClass extends BaseClass implements ITestListener {
public String testName;
public String methodName;

	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
		
	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			ExtendReport_Test.extenttest.pass(result.getMethod()+" : " + "Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtendReport_Test.extenttest.fail(result.getMethod()+" : " + "Test fail",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
