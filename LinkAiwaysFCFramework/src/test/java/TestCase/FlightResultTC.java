package TestCase;

import org.testng.annotations.Test;

import CommonFunction.BrowserLanuch;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestPage.BasePage;
import TestPage.FlightResultPage;

public class FlightResultTC extends BrowserLanuch {
	//Logger logger = Logger.getLogger(FlightResultTC.class);

	@Test
	public void Flightresultcase() {
	//	testcase = extentReports.createTest("FlightSelected Page");
	//	logger.info("Element moved to FLight select Page");
		FlightResultPage flightResult = PageFactory.initElements(driver, FlightResultPage.class);
	//	testcase.info("Flightselect for selecting booking class ");
		flightResult.Fareselecting(excelProvider.getRoutedata("Routes", 11, 1));
	//	logger.info("Element has selected cabin class ");
		flightResult.FlightContiune();
	//	logger.info("Element moving to Passenger page");

	}
}
