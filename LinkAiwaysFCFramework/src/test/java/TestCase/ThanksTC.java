package TestCase;

import org.testng.annotations.Test;

import CommonFunction.BrowserLanuch;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestPage.BasePage;
import TestPage.ThanksPage;

public class ThanksTC extends BrowserLanuch {
	Logger logger = Logger.getLogger(ThanksTC.class);

	@Test
	public void Thankscase() {
		logger.info("Application moved to Thankspage");
		testcase = extentReports.createTest("Thankspage");
		ThanksPage thanksPage = PageFactory.initElements(driver, ThanksPage.class);
		testcase.info("Pnr creation");
		thanksPage.exit();
		logger.info("PNR created");
		logger.error("PNR is not Created");
		logger.info("Booking successfully");
		logger.error("Booking is not done successfully");
	}
}
