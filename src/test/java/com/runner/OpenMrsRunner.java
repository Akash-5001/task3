package com.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.listener.ExtendReport_Test;
import com.listener.ITestListenerClass;
import com.pom.LoginPageOpenMrs;
import com.properties.Frm;

@Listeners(ITestListenerClass.class)

public class OpenMrsRunner extends BaseClass{
	
	@BeforeTest
	public static void setUp() throws Exception {
		getBrowser(Frm.getInstancefrm().getInstanceConfigurationReader().getBrowser());
	}
	@Test
	public static void validLoginTest() {
		ExtendReport_Test.extenttest = extentReports.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Valid Email Id and Valid Password");
		LoginPageOpenMrs lp = new LoginPageOpenMrs();
		Assert.assertTrue(lp.validLogin(ExtendReport_Test.extenttest));	
	}
	
	@AfterTest
	public static void quit() {
		quit();
	}
    @BeforeSuite
    private void extendsStartup() {
    	extentReportstart("E:\\course\\TestNg\\Reports");
    }
    @AfterSuite
    private void ExtendReportEnd() throws IOException {
    extentReportTearDown("");
    }

    
    
    
    
    
    
    
    
    
    
}
