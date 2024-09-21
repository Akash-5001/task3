package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.properties.Frm;


public class LoginPageOpenMrs extends BaseClass implements OpenMrsInterface {
	
	@FindBy(id = username_id)
	private WebElement username;

	@FindBy(id = password_id)
	private WebElement password;
	
	@FindBy(xpath = Location_xpath)
	private WebElement location;
	
	@FindBy(id = Login_id)
	private WebElement login;

	
	public LoginPageOpenMrs() {
		PageFactory.initElements(driver,this);
	}
	public boolean validLogin(ExtentTest extenttest) {
		
		try {
			urlLaunch(Frm.getInstancefrm().getInstanceConfigurationReader().getUrl());
			inputValues(username,Frm.getInstancefrm().getInstanceConfigurationReader().getUsername());
			inputValues(password,Frm.getInstancefrm().getInstanceConfigurationReader().getPassword());
			clickElement(location);
			clickElement(login);
			validation(driver,Frm.getInstancefrm().getInstanceConfigurationReader().getTitle());
			extenttest.log(Status.PASS,"Login Sucessfull");
		} catch (AssertionError e) {
			
			extenttest.log(Status.FAIL,"Login Failed" + e.getMessage());
			return false;
		}
			return true;
	 		
	}
	
	}
	
	
