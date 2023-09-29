package TestCase;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CommonFunction.BrowserLanuch;
import CommonFunction.ExcelDataProvider;
import TestPage.BasePage;
import TestPage.PassengerPage;

public class PassengerTC extends BrowserLanuch {
	Logger logger = Logger.getLogger(PassengerTC.class);

	@Test
	public void Passengercase() throws IOException {
		logger.info("Appilcation moved to Passgener page");
		testcase=extentReports.createTest("PassengerPage");
		ExcelDataProvider excelProvider = new ExcelDataProvider();
		PassengerPage passengerPage = PageFactory.initElements(driver, PassengerPage.class);
		logger.info("Element give detail for AdultPassgener");
		testcase.info("Passegner details");
		System.out.println(excelProvider.getAdultdata("Adult", 5, 1));
		System.out.println(excelProvider.getAdultdata("Adult", 4, 1));
		System.out.println(excelProvider.getAdultdata("Adult", 2, 1));
		passengerPage.AdultPassengername(excelProvider.getAdultdata("Adult", 1, 1),
				excelProvider.getAdultdata("Adult", 2, 1), excelProvider.getAdultdata("Adult", 3, 1),
				excelProvider.getAdultdata("Adult", 4, 1), excelProvider.getAdultdata("Adult", 5, 1),
				excelProvider.getAdultdata("Adult", 6, 1));
		passengerPage.Passengercontinue();
		logger.info("Application moving to AddonPage");

	}
}