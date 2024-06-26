package TestCase;

import org.testng.annotations.Test;

import CommonFunction.BrowserLanuch;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestPage.AddonPage;
import TestPage.BasePage;

public class AddonTC extends BrowserLanuch {
	//Logger logger = Logger.getLogger(AddonTC.class);

	@Test
	public void Addoncase() {
	//	logger.info("Application moved to Addonpage");
	//	testcase=extentReports.createTest("AddonPage");
		AddonPage addonPage = PageFactory.initElements(driver, AddonPage.class);
		addonPage.AddonContinuebutton();
	//	logger.info("Application moving to PaymentPage");
	//	testcase.info("Addon details");
	}
}
