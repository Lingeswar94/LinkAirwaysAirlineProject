package CommonFunction;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import TestPage.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class BrowserLanuch {

	public static WebDriver driver;
	public static ExcelDataProvider excelProvider;
	public static ConfigDataProvider config;
	public static Properties properties;
	public static ExtentSparkReporter Reporter;
	public static ExtentReports extentReports;

	public static ExtentTest testcase;
	// public static ExtentHtmlReporter html;
	Logger logger = Logger.getLogger(BrowserLanuch.class);

	public static Properties loadbrowser() throws IOException {

		FileInputStream fileInputStream = new FileInputStream("./Config/config.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		return properties;

	}

	@BeforeMethod
	public void Datafunction() throws IOException {
		excelProvider = new ExcelDataProvider();
		Reporter = new ExtentSparkReporter(new String(
				System.getProperty("user.dir") + "./Reports/FCReports " + Helper.getCurrenttime() + ".html"));
		Reporter.config().setDocumentTitle("Automation Test Report");
		Reporter.config().setReportName("FC Normal Flow Project");
		Reporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(Reporter);
		extentReports.setSystemInfo("Environment", "QA");
	}

	@BeforeSuite
	public void launchBrowser() throws IOException {

		loadbrowser();

		String Browser = properties.getProperty("Browser");
		String Url = properties.getProperty("URL");
		 ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		if (Browser.equalsIgnoreCase("Chrome")) {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.driver.chrome", properties.getProperty("Path"));
			driver = new ChromeDriver(option);

		} else if (Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Not Supporting");
		}

		driver.navigate().to(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeTest
	public void ExcelProvider() throws IOException {
		excelProvider = new ExcelDataProvider();
	}

	@AfterMethod
	public void teardownmethod(ITestResult result) throws AWTException, IOException {
		if (testcase != null) {
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenshotPath = Helper.getscreenshotcapture(driver, result.getTestName());
				testcase.log(Status.PASS, "Test Passed: Screenshot capture",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			} else if (result.getStatus() == ITestResult.SUCCESS) {
				String screenshotPath = Helper.getscreenshotcapture(driver, result.getTestName());
				testcase.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			} else if (result.getStatus() == ITestResult.SKIP) {
				String screenshotPath = Helper.getskipScreenshot(driver, result.getTestName());
				testcase.log(Status.SKIP, "Test Skiped: Screenshot capture",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			} else {
				System.out.println("Not generted");
			}
			extentReports.flush();
		}
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		logger.info("Closing Application");
	}

}
