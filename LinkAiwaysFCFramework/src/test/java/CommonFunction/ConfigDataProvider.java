package CommonFunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigDataProvider {

	static Properties properties;

	public ConfigDataProvider() throws IOException {

		FileInputStream fileInputStream = new FileInputStream("./Config/config.properties");
		properties = new Properties();
		properties.load(fileInputStream);
	}

	public static String geturl() {
		return	 properties.getProperty("URL");
		
	}

	public static String getbrowser() {
		return properties.getProperty("Browser");
		 
	}
}
