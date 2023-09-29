package TestPage;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightResultPage {

	static WebDriver driver;

	public FlightResultPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//li[@class='pro select_out']//span[@data-html='true']")
	public static WebElement baseclass;
	
	 @FindBy (xpath="//ul[@class='class four']/li")
	 public static List<WebElement> basesssclass;

	@FindBy(xpath = "//button[@id='btnContinue']")
	public static WebElement flightresultctn;

	public void selectcabinclass() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	for (WebElement webElement : basesssclass) {
		if (webElement.getAttribute("class").equalsIgnoreCase("pro select_out")
				|| webElement.getAttribute("class").equalsIgnoreCase("eco select_out")
				|| webElement.getAttribute("class").equalsIgnoreCase("bus select_out")
				|| webElement.getAttribute("class").equalsIgnoreCase("busfx select_out"))

		{
			webElement.click();
			break;
		}
	}
	/*
	 * PageFactory.initElements(driver, FlightResultPage.class); List<WebElement>
	 * cabinclass=baseclass.findElements((By.xpath("//ul[@class='class four']/li")))
	 * ;
	 * 
	 * WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); for
	 * (WebElement webElement : cabinclass) {
	 * 
	 * if (webElement.getAttribute("class").equalsIgnoreCase("pro select_out") ||
	 * webElement.getAttribute("class").equalsIgnoreCase("eco select_out") ||
	 * webElement.getAttribute("class").equalsIgnoreCase("bus select_out") ||
	 * webElement.getAttribute("class").equalsIgnoreCase("busfx select_out"))
	 * 
	 * { webElement.click(); break; }
	 */
			/*
			 * if(webElement.getAttribute("class").equalsIgnoreCase("pro select_out")) {
			 * webElement.click(); break; }else
			 * if(webElement.getAttribute("class").equalsIgnoreCase("eco select_out")){
			 * webElement.click(); break; }else
			 * if(webElement.getAttribute("class").equalsIgnoreCase("bus select_out")){
			 * webElement.click(); break; }else
			 * if(webElement.getAttribute("class").equalsIgnoreCase("busfx select_out")) {
			 * webElement.click(); break; }else{ System.out.println("No Booking class"); }
			 */
		
	}

	public void Resultcontinuebutton() {
		flightresultctn.click();
	}
}
