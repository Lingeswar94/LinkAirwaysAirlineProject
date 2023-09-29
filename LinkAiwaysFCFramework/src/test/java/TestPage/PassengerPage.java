package TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonFunction.ExcelDataProvider;

public class PassengerPage {

	static WebDriver driver;
	
	public PassengerPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy (xpath="//input[@id='ucPassenger1_lstPassenger_FIRSTNAME_0_txtFName_0']")
	public static WebElement firstname;
	
	@FindBy (xpath="//input[@id='ucPassenger1_lstPassenger_LASTNAME_0_txtLName_0']")
	public static WebElement lastname;
	
	
	@FindBy (xpath="//input[@id='ucPassenger1_lstPassenger_PAXMOBILENO_0_txtPaxMobileNo_0']")
	public static WebElement mobileno;
	
	@FindBy (xpath="//input[@id='ucPassenger1_lstPassenger_EMAIL_0_txtEmail_0']")
	public static WebElement email;
	
	@FindBy (xpath="//input[@id='ucPassenger1_lstPassenger_ConfirmEmail_0_txtConfirmEmail_0']")
	public static WebElement confrmemail;
	
	@FindBy (xpath="//input[@id='ucPassenger1_lstPassenger_COUNTRYPOSTCODE_0_txtResPostCode_0']")
	public static WebElement Residential;
	 
	@FindBy (xpath="//input[@id='btnConfirmPassenger']")
	public static WebElement Passctn;
	
	
	
	
	public void AdultPassengername(String fname,String lname,String mobile, String mailid ,String conemail,String Res) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		mobileno.sendKeys(mobile);
		email.sendKeys(mailid);
		confrmemail.sendKeys(conemail);
		Residential.sendKeys(Res);
		
	}
	public void Passengercontinue() {
		Passctn.click();
	}
}
