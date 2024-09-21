package com.listener;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Base.BaseClass;
import com.aventstack.extentreports.ExtentTest;

public class ExtendReport_Test {
		
		public static ExtentTest extenttest;
		
		@BeforeSuite
		public void extentReportStartUp() {
			BaseClass base = new BaseClass();
			base.extentReportstart(null);
		}
		
		@AfterSuite
		public void extentReportEnd() throws IOException {
			BaseClass base = new BaseClass();
			base.extentReportTearDown(null);
		}
	}


