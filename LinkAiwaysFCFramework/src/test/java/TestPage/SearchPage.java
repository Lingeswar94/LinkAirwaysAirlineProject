package TestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import CommonFunction.ConfigDataProvider;



public class SearchPage {
	 
	
	static WebDriver driver;
	public SearchPage(WebDriver driver) {
	this.driver=driver;
	}
	
	@FindBy(id="ucMiniSearch_rdoJourneyType_0")
	public static WebElement oneway;
	
	@FindBy(xpath = "//div[@class='btn-group bootstrap-select form-control deptCitysearch']")
	public static WebElement depart;
	
	@FindBy(xpath = "//input[@class='form-control']/following::select[1]")
	public static WebElement departdropdown;
	
	@FindBy(xpath = "//select[@id='ucMiniSearch_arrCity']")
	public static WebElement arrival;
	
	@FindBy(xpath = "//*[@class='next']")
	public static WebElement month;
	
	@FindBy(xpath = "//td[@class='day dt-highlight'][normalize-space()='20']")
	public static WebElement departdte;

	@FindBy(xpath = "//select[@id='ucMiniSearch_ddlAdult']")
	public static WebElement Adult;

	@FindBy(xpath = "//select[@id='ucMiniSearch_ddlChild']")
	public static WebElement Child;

	@FindBy(xpath = "//select[@id='ucMiniSearch_ddlInfant']")
	public static WebElement Infant;

	@FindBy(xpath = "//input[@id='btnminiSearch']")
	public static WebElement searchbtn;
	
	
	public void trip() {
		oneway.click();
	}
	
	public void departurebutton() {
		depart.click();
	}

	public void departurecity(String Departurecity) {
		Select select1 = new Select(SearchPage.departdropdown);
		select1.selectByValue(Departurecity);
	}

	public void arrivalcity(String Arrivalcity) {
		Select select2 = new Select(SearchPage.arrival);
		select2.selectByValue(Arrivalcity);
		
	}

	public void monthselect() {
		month.click();
	}
	public void nextdate() {
		departdte.click();
	}

	public void adultpax() {
		Select selectadult = new Select(SearchPage.Adult);
		selectadult.selectByIndex(0);
	}

	public void childpax() {
		Select selectChild = new Select(SearchPage.Child);
		selectChild.selectByIndex(1);
	}

	public void infantpax() {
		Select selectInfant = new Select(SearchPage.Infant);
		selectInfant.selectByIndex(1);
	}
	
	public void searchcon() {
		searchbtn.click();
	}
}
