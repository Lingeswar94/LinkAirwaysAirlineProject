package TestCase;

import org.testng.annotations.Test;

import CommonFunction.BrowserLanuch;
import CommonFunction.ConfigDataProvider;
import CommonFunction.ExcelDataProvider;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import TestPage.BasePage;
import TestPage.SearchPage;

public class SearchTC extends BrowserLanuch {
	
	
	//Logger logger=Logger.getLogger(SearchTC.class);
	@Test
	public void SearchpageTestcase() throws IOException {
		//logger.info("Application moved to Searchpage");
		//testcase=extentReports.createTest("Login to Appication");
		 excelProvider = new ExcelDataProvider();
		SearchPage page = PageFactory.initElements(driver, SearchPage.class);
		//testcase.info("Searchpage Starting");
		page.Tripselection(excelProvider.getRoutedata("Routes", 0, 1));
		page.departureroute(excelProvider.getRoutedata("Routes", 1, 1));
		page.arrivalroute(excelProvider.getRoutedata("Routes", 2, 1));
		page.DataSelection(excelProvider.getRoutedata("Routes", 3, 1), excelProvider.getRoutedata("Routes", 4, 1));
		page.ReturnDateselection(excelProvider.getRoutedata("Routes", 5, 1), excelProvider.getRoutedata("Routes", 6, 1));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		page.Adultcount(excelProvider.getRoutedata("Routes", 7, 1));
		page.childpax(excelProvider.getRoutedata("Routes", 8, 1));
		page.infantpax(excelProvider.getRoutedata("Routes", 9, 1));
		page.Searchbutton();
		//logger.info("Element moving to FlightResultpage");

		
		/*
		 * FlightResultPage flightResult = PageFactory.initElements(driver,
		 * FlightResultPage.class); flightResult.selectcabinclass();
		 * flightResult.Resultcontinuebutton();
		 * 
		 * 
		 * PassengerPage passengerPage = PageFactory.initElements(driver,
		 * PassengerPage.class); System.out.println(excelProvider.getAdultdata("Adult",
		 * 5, 1)); System.out.println(excelProvider.getAdultdata("Adult", 4, 1));
		 * System.out.println(excelProvider.getAdultdata("Adult", 2, 1));
		 * passengerPage.AdultPassengername(excelProvider.getAdultdata("Adult", 1, 1),
		 * excelProvider.getAdultdata("Adult", 2, 1),
		 * excelProvider.getAdultdata("Adult", 3, 1),
		 * excelProvider.getAdultdata("Adult", 4, 1),
		 * excelProvider.getAdultdata("Adult", 5, 1),
		 * excelProvider.getAdultdata("Adult", 6, 1));
		 * passengerPage.Passengercontinue();
		 * 
		 * AddonPage addonPage = PageFactory.initElements(driver, AddonPage.class);
		 * addonPage.AddonContinuebutton();
		 * 
		 * PaymentPage paymentPage = PageFactory.initElements(driver,
		 * PaymentPage.class); paymentPage.SelectPayment();
		 * paymentPage.carddetails(excelProvider.getPaymentdata("Payment", 1, 1),
		 * excelProvider.getPaymentdata("Payment", 2, 1),
		 * excelProvider.getPaymentdata("Payment", 3, 1)); paymentPage.expirydate();
		 * 
		 * paymentPage.Billingdetails(excelProvider.getbillingdata("Payment", 5, 1),
		 * excelProvider.getbillingdata("Payment", 6, 1),
		 * excelProvider.getbillingdata("Payment", 7, 1),
		 * excelProvider.getbillingdata("Payment", 8, 1),
		 * excelProvider.getbillingdata("Payment", 9, 1),
		 * excelProvider.getbillingdata("Payment", 10, 1)); paymentPage.selectCountry();
		 * paymentPage.checkbox(); paymentPage.paymentcontinue();
		 * 
		 * ThanksPage thanksPage= PageFactory.initElements(driver,ThanksPage.class);
		 * thanksPage.exit();
		 */
	}
}
