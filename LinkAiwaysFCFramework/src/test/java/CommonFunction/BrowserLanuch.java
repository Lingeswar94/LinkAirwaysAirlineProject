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
import org.openqa.selenium.devtools.v114.browser.Browser;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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
	public static ExtentReports extentReports;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest testcase;
	public static ExtentHtmlReporter html;
	Logger logger = Logger.getLogger(Browser.class);

	public static Properties loadbrowser() throws IOException {

		FileInputStream fileInputStream = new FileInputStream("./Config/config.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		return properties;

	}

	@BeforeSuite
	public void launchBrowser() throws IOException {

		PropertyConfigurator.configure("./Config/Log4j.properties");
		logger.info("Automation Script for LinkAirways Project");
		excelProvider = new ExcelDataProvider();
		extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir") +"\\Reports\\LinkAirways" + Helper.getcurrentdate() +".html"));
		extentReports.attachReporter(sparkReporter);
		sparkReporter.config().setReportName("LinkAirways Test Reports");
		sparkReporter.config().setTheme(Theme.DARK);
		
		loadbrowser();
		logger.info("Lanching the Application");
		String Browser = properties.getProperty("Browser");
		String Url = properties.getProperty("URL");
		if (Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Open Application with Chrome Browser");
			logger.error("ChromeBrowser is not open ");
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Open Application with Firefox Browser");
			logger.error("FireBrowser is not open ");
		} else if (Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
			logger.info("Open Application with IE Browser");
			logger.error("IEBrowser is not open ");
		} else {
			System.out.println("Not Supporting");
		}

		driver.navigate().to(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterTest
	public void teardownmethod(ITestResult result) throws AWTException, IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Helper.getscreenshot(driver);
			testcase.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.getscreenshot(driver)).build());
			logger.error("Testcase Failed and screenshot attached ");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			testcase.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.getscreenshot(driver)).build());
			logger.info("Testcase Passed and screenshot attached");
		} else if (result.getStatus() == ITestResult.SKIP) {
			testcase.skip("Test Skip",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.getscreenshot(driver)).build());
			logger.info("Testcase Skiped and screenshot attached");
		} else {
			System.out.println("Not generted");
		}

		extentReports.flush();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();

		logger.info("Closing Application");
	}

}
