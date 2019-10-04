package banking.keyworddriven;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.print.DocFlavor.STRING;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.BrowserHelper;

public class Keywords extends BrowserHelper {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
//	openBrowser
	public void openBrowser(String locType, String locValue, String testdata) {
		driver = openBrowser(testdata);
		test.log(LogStatus.INFO, "browser launched successfully");
	}

//	navigate
	public void navigate(String locType, String locValue, String testdata) {
		this.driver.get(testdata);
		test.log(LogStatus.INFO, "navigate to "+testdata);
	}

//	setText
	public void setText(String locType, String locValue, String testdata) {
		test.log(LogStatus.INFO, "locating an element using "+locType+" = "+locValue);
		this.driver.findElement(LocatorHelper.locateElement(locType, locValue)).sendKeys(testdata);
		test.log(LogStatus.INFO, "element located and entered "+testdata);
		sleep(2000);
	}

//	click
	public void click(String locType, String locValue, String testdata) {
		test.log(LogStatus.INFO, "locating an element using "+locType+" = "+locValue);
		this.driver.findElement(LocatorHelper.locateElement(locType, locValue)).click();
		test.log(LogStatus.INFO, "clicking on element");
		sleep(2000);
	}

//	moveToElement
	public void moveToElement(String locType, String locValue, String testdata) {
		Actions actions = new Actions(this.driver);
		test.log(LogStatus.INFO, "locating an element using "+locType+" = "+locValue);
		actions.moveToElement(this.driver.findElement(LocatorHelper.locateElement(locType, locValue))).build()
				.perform();
		test.log(LogStatus.INFO, "moved to element");
		sleep(2000);
	}

//	moveToEleAndClick
	public void moveToEleAndClick(String locType, String locValue, String testdata) {
		Actions actions = new Actions(this.driver);
		test.log(LogStatus.INFO, "locating an element using "+locType+" = "+locValue);
		actions.moveToElement(this.driver.findElement(LocatorHelper.locateElement(locType, locValue))).click().build()
				.perform();
		test.log(LogStatus.INFO, "moved to element and clicked on it");
		sleep(2000);
	}

//	switchToFrame
	public void switchToFrame(String locType, String locValue, String testdata) {
		WebElement frameToSwitch = driver.findElement(LocatorHelper.locateElement(locType, locValue));
		this.driver.switchTo().frame(frameToSwitch);
		test.log(LogStatus.INFO, "switched to frame");
	}

//	select
	public void select(String locType, String locValue, String testdata) {
		test.log(LogStatus.INFO, "locating an element using "+locType+" = "+locValue);
		WebElement ele = this.driver.findElement(LocatorHelper.locateElement(locType, locValue));
		Select eleSelect = new Select(ele);
		eleSelect.selectByVisibleText(testdata);
		test.log(LogStatus.INFO, "selected option "+testdata);
		sleep(2000);
	}

//	switchToDefaultContent
	public void switchToDefaultContent(String locType, String locValue, String testdata) {
		this.driver.switchTo().defaultContent();
		test.log(LogStatus.INFO, "switched to default content i.e. main page");
	}

//	closeBrowser
	public void closeBrowser(String locType, String locValue, String testdata) {
		closeBroser();
	}

//	clear
	public void clear(String locType, String locValue, String testdata) {
		test.log(LogStatus.INFO, "locating an element using "+locType+" = "+locValue);
		this.driver.findElement(LocatorHelper.locateElement(locType, locValue)).clear();
		test.log(LogStatus.INFO, "existing data in text filed clered");
		sleep(2000);
	}

// switchToWindow
	/*
	 * specify the index number of the window you want to switch as testdata
	 */
	public void switchToWindow(String locType, String locValue, String testdata) {
		Set<String> windowHandles = this.driver.getWindowHandles();
		List<String> windowIDs = new ArrayList<String>(windowHandles);
		this.driver.switchTo().window(windowIDs.get(Integer.parseInt(testdata)));
		test.log(LogStatus.INFO, "switched to window "+driver.getTitle());
	}

//	@Test
//	public void testmethod() {
//		// Java reflection concept
//		Keywords keywords = new Keywords();
//		Method[] methods = keywords.getClass().getMethods();
//		for (Method method : methods) {
//			System.out.println(method.getName());
//		}
//	}
}
