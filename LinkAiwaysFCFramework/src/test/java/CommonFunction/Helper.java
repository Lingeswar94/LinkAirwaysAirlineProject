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

import org.openqa.selenium.WebDriver;

public class Helper {

	public static String getscreenshot(WebDriver driver) throws AWTException, IOException {

		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String screenshot=System.getProperty("user.dir")+"/Screenshot/Link"+getcurrentdate()+".png";
		File file = new File(screenshot);
		ImageIO.write(bufferedImage, "png", file);
		return screenshot;

	}

	public static String getcurrentdate() {

		DateFormat dateFormat = new SimpleDateFormat("_MM_dd_yyyy_ss_mm_HH");
		Date date = new Date();
		String currentdate = dateFormat.format(date);
		return currentdate;
	}
}
