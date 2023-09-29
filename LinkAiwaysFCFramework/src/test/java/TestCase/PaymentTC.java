package TestCase;

import org.testng.annotations.Test;

import CommonFunction.BrowserLanuch;
import CommonFunction.ExcelDataProvider;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestPage.BasePage;
import TestPage.PaymentPage;

public class PaymentTC extends BrowserLanuch {
Logger logger=Logger.getLogger(PaymentTC.class);
	
	@Test
	public void Paymentcase() throws IOException {
		logger.info("Application moved to Paymentpage");
		testcase=extentReports.createTest("PaymentPage");
		ExcelDataProvider excelProvider=new ExcelDataProvider();
		PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);
		logger.info("Given Creditcard details");
		testcase.info("Given Payment details");
		paymentPage.SelectPayment();
		paymentPage.carddetails(excelProvider.getPaymentdata("Payment", 1, 1),
				excelProvider.getPaymentdata("Payment", 2, 1), excelProvider.getPaymentdata("Payment", 3, 1));
		paymentPage.expirydate();
		logger.info("Given Billing details");
		paymentPage.Billingdetails(excelProvider.getbillingdata("Payment", 5, 1),
				excelProvider.getbillingdata("Payment", 6, 1), excelProvider.getbillingdata("Payment", 7, 1),
				excelProvider.getbillingdata("Payment", 8, 1), excelProvider.getbillingdata("Payment", 9, 1),
				excelProvider.getbillingdata("Payment", 10, 1));
		paymentPage.selectCountry();
		paymentPage.checkbox();
		paymentPage.paymentcontinue();
		logger.info("Application moving to ThankstPage");
	}
}
