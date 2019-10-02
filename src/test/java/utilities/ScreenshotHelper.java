package utilities;

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

public class ScreenshotHelper {

	private static String getTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MM_yy-HH_mm_ss");
		return df.format(date);
	}

	// selenium approach to capture the screenshot
	public static String screenCapture(WebDriver driver, String folderName, String fileName) {
		// convert WebDriver object reference to TakeScreenshot object reference
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(".\\" + folderName + "\\" + fileName + getTime() + ".png");
		try {
			BufferedImage bi = ImageIO.read(srcImg);
			ImageIO.write(bi, "png", destImg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destImg.getAbsolutePath();
	}

	// alert screenshot
	public static void alertScreenCapture(String folderName, String fileName) {
		try {
			Robot r = new Robot();
			BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			File destImg = new File(".\\" + folderName + "\\" + fileName + getTime() + ".png");
			ImageIO.write(bi, "png", destImg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// take multiple screenshot
	public static void takeMultipleScreenshots(WebDriver driver, String folderName, String fileName) {
		long scrollHeight = (Long) JavaScriptHelper.executeJavaScript(driver, "return document.documentElement.scrollHeight");
		long clientHeight = (Long) JavaScriptHelper.executeJavaScript(driver, "return document.documentElement.clientHeight");
		
//		System.out.println("scroll height = "+scrollHeight+"\nclient height = "+clientHeight);
		while(scrollHeight > 0) {
			ScreenshotHelper.screenCapture(driver, folderName, fileName);
			JavaScriptHelper.scrollPageBy(driver, (int)clientHeight);
			scrollHeight -= clientHeight;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
