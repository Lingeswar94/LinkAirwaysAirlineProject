package CommonFunction;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	public static WebDriver driver;
	public static String getscreenshot(WebDriver driver, String Screenshotname) throws AWTException, IOException {
		String screenshotdir = System.getProperty("user.dir")+"/Screenshot/FCProject"+"_"+getCurrenttime()+".png";
		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String screenshot = System.getProperty("user.dir") + screenshotdir + "_" + getCurrenttime() + ".png";
		File file = new File(screenshot);
		ImageIO.write(bufferedImage, "png", file);
		return screenshot;

	}
	public static String getFailscreenshot(WebDriver driver, String screenshotName) {

		String screenshotDir = System.getProperty("user.dir") + "/Screenshot/FCfailTest" + "_" + getCurrenttime()
				+ ".png";

		File directory = new File(screenshotDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {

			System.out.println(e.getMessage());
		}
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String screenshot = screenshotDir;
		File file = new File(screenshotDir);

		try {
			ImageIO.write(bufferedImage, "png", file);
			System.out.println("Fail Screenshot captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshot;
	}

	public static String getskipScreenshot(WebDriver driver, String screenshotName) throws IOException, AWTException {

		String screenshotDir = System.getProperty("user.dir") + "/Screenshot/FCskipTest" + "_" + getCurrenttime()
				+ ".png";

		File directory = new File(screenshotDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {

			System.out.println(e.getMessage());
		}
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String screenshot = screenshotDir;
		File file = new File(screenshotDir);

		try {
			ImageIO.write(bufferedImage, "png", file);
			System.out.println("Skip Screenshot captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshot;
	}

	public static String getscreenshotcapture(WebDriver driver, String screenshotName) {

		String screenshotDir = System.getProperty("user.dir") + "/Screenshot/FCsuccessTest" + "_" + getCurrenttime()
				+ ".png";

		File directory = new File(screenshotDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {

			System.out.println(e.getMessage());
		}
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String screenshot = screenshotDir;
		File file = new File(screenshotDir);

		try {
			ImageIO.write(bufferedImage, "png", file);
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshot;

	}

	public static String getscreenshotbase64() {
		return	((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		 
	}

	public static String getCurrenttime() {

		DateFormat dateFormat = new SimpleDateFormat("_MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		String currentdate = dateFormat.format(date);
		return currentdate;
	}
	
	
}
