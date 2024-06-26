package TestPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import CommonFunction.ConfigDataProvider;

public class SearchPage {

	static WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='ucMiniSearch_rdoJourneyType']/tbody/tr")
	public static List<WebElement> Trip;

	@FindBy(xpath = "//select[@id='ucMiniSearch_depCity']")
	public static WebElement departurecity;

	@FindBy(xpath = "//select[@id='ucMiniSearch_arrCity']")
	public static WebElement arrivalcity;

	@FindBy(xpath="//select[@id='ucMiniSearch_ddlAdult']")
	public static WebElement AdultPax;
	
	@FindBy(xpath = "//select[@id='ucMiniSearch_ddlChild']")
	public static WebElement Child;

	@FindBy(xpath = "//select[@id='ucMiniSearch_ddlInfant']")
	public static WebElement Infant;
	
	@FindBy(xpath="//input[@id='btnminiSearch']")
	public static WebElement searchagin;
	
	
	public  void Tripselection(String trip) {
		for (WebElement selectedtrip : Trip) {
			String triptext = selectedtrip.getText();
			if (triptext.contains(trip)) {
				WebElement oneway = driver.findElement(By.id("ucMiniSearch_rdoJourneyType_0"));
				oneway.click();
			} 
			 else {
				System.out.println("No trip");
			}
		}
	}

	public void departureroute(String departurecity) {
		Select select = new Select(SearchPage.departurecity);
		select.selectByValue(departurecity);
		
	}

	public void arrivalroute(String arrivalcity) {
		Select select2 = new Select(SearchPage.arrivalcity);
		select2.selectByValue(arrivalcity);
	}

	public void DataSelection(String Month, String Date) {
		while (true) {
			String Daytext = driver.findElement(By.xpath("//th[@class='datepicker-switch']")).getText();
			if (Daytext.equalsIgnoreCase(Month)) {
				break;
			} else {
				driver.findElement(By.xpath("//th[@class='next']")).click();
			}
		}

		driver.findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[contains(text()," + Date + ")]"))
				.click();
		
	}

	public void ReturnDateselection(String returnmonth, String redate) {
		if (driver.findElement(By.xpath("//input[@id='ucMiniSearch_rdoJourneyType_1']")).isSelected()) {
		while (true) {
			String returndate = driver.findElement(By.xpath("//th[@class='datepicker-switch']")).getText();
			if (returndate.equalsIgnoreCase(returnmonth)) {
				break;
			} else {
				driver.findElement(By.xpath("//th[@class='next']")).click();
			}
		}
		driver.findElement(
				By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[contains(text()," + redate + ")]")).click();
	}else {
		System.out.println("Oneway Trip");
	}
	}
	
	public void Adultcount(String ADTcount) {
		Select Adult=new Select(SearchPage.AdultPax);
		Adult.selectByValue(ADTcount);
	}
	public void childpax(String Chcount) {
		Select selectChild = new Select(SearchPage.Child);
		selectChild.selectByValue(Chcount);
	}

	public void infantpax(String InFcount) {
		Select selectInfant = new Select(SearchPage.Infant);
		selectInfant.selectByValue(InFcount);
	}
	
	public void Searchbutton() {
		searchagin.click();
	}

}
