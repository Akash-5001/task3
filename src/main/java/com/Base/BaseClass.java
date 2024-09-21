package com.Base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static WebDriver driver;

	public static ExtentReports extentReports;
	public static File file;

	public static WebDriver getBrowser(String browserName) throws Exception {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--ignore-certificate-errors");
		opt.addArguments("chrome.switches", "--disable-extensions");
		opt.addArguments("--disable-notifications");
		opt.addArguments("enable-automation");

		try {
			if (browserName.equalsIgnoreCase("chrome")) {

				driver = new ChromeDriver(opt);

			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();

			} else {
				// throw new Exception("Browser Name is invalid");
				System.out.println("Browser Name is invalid");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		// maximum window
		driver.manage().window().maximize();
		return driver;
	}

	// get text
	public static void text(String text) {
		try {
			driver.get("text");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// geturl
	public static void urlLaunch(String url) {

		try {
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// click
	public static void clickElement(WebElement element) {

		try {
			element.click();
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}

	}

	// sendkeys
	public static void inputValues(WebElement element, String Value) {

		try {
			element.sendKeys(Value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// takeScreenshot
	public static void takeScreenshot(WebDriver driver, String FileName, String Format) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File des = new File("E:\\course\\akash.testing\\screenshot" + "\\" + FileName + ".");
		FileHandler.copy(src, des);
	}

	// dropdown
	protected static void selectDropDownOption(WebDriver driver, WebElement element, String options, String value) {

		Select select = new Select(element);
		try {
			if (options.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			} else if (options.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (options.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// frames
	protected static void frame(WebDriver driver, WebElement element) {
		try {

			driver.switchTo().frame(element);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Actions
	protected static void action(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// alerts
	protected static void alerts(WebDriver driver, String type) {

		try {
			driver.switchTo().alert();

			if (type.equalsIgnoreCase("accept")) {
				driver.switchTo().alert().accept();
			} else if (type.equalsIgnoreCase("dismiss")) {
				driver.switchTo().alert().dismiss();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Navigate Forward/back/Refresh
	protected static void navigateMethods(String navigateMethod, String NavigateUrl) {
		if (navigateMethod.equalsIgnoreCase("Base")) {
			driver.navigate().back();
		} else if (navigateMethod.equalsIgnoreCase("Forward")) {
			driver.navigate().forward();
		} else if (navigateMethod.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		} else {
			System.out.println("Invalid Option");
		}
	}

	// isenable,isdisplay,isselect
	protected static void isMethods(WebDriver driver, WebElement element, String option) {
		if (option.equalsIgnoreCase("enabled")) {
			boolean enable = element.isEnabled();
			System.out.println("element enabled" + enable);
		} else if (option.equalsIgnoreCase("displayed")) {
			boolean display = element.isDisplayed();
			System.out.println("element displayed" + display);
		} else if (option.equalsIgnoreCase("selected")) {
			boolean select = element.isSelected();
			System.out.println("element selected" + select);
		}
	}

	protected static void isSelected(WebDriver driver, WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element selected");
			} else {
				System.out.println("Element not selected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void geturl(WebDriver driver, WebElement element, String value) {
		try {
			String url = driver.getCurrentUrl();
			System.out.println(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// getattribute
	protected static void getattribute(WebDriver driver, WebElement element, String value) {
		try {
			String text = element.getAttribute(value);
			System.out.println(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// implicitwait
	protected static void wait(WebDriver driver, int sec) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// explicitwait
	protected static void explicitWait(WebDriver driver, WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// quit
	protected static void quit() {
		driver.quit();
	}

	// close
	protected static void close() {
		driver.close();
	}

	public static void extentReportstart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public static void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}
	public static void validation(WebDriver act,String ect) {  //40
		Assert.assertEquals(act.getTitle(),ect);
	}
}
