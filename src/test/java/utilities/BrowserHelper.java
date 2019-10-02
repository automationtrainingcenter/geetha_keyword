package utilities;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper extends GenericHelper{

	WebDriver driver;

	
	/*
	 * openBrowser will lauch the browser based on the browser name we specified and
	 * returns WebDriver object reference
	 */
	public WebDriver openBrowser(String browserName, String url) {
		if (System.getProperty("os.name").toLowerCase().contains("windows") && browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getPath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		} else if (System.getProperty("os.name").toLowerCase().contains("windows")
				&& browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getPath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getPath("drivers", "chromedriver"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", getPath("drivers", "geckodriver"));
			driver = new FirefoxDriver();

		} else {
			throw new RuntimeException("Invalid browser Name, Browser name must be either chrome or firefox");
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	/*
	 * closeBrowser will close browser windows or window opened by the driver
	 * instance
	 */
	public void closeBroser() {
		if (driver.getWindowHandles().size() > 1) {
			driver.quit();
		} else {
			driver.close();
		}
	}

	/*
	 * sleep(long timeInMillis) it will wait for the time we specified
	 */
	public static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testMethdo() {
		System.out.println(getPath("drivers", "chromedriver.exe"));
	}
}
