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

import utilities.BrowserHelper;

public class Keywords extends BrowserHelper {
	WebDriver driver;

//	openBrowser
	public void openBrowser(String locType, String locValue, String testdata) {
		driver = openBrowser(testdata);
	}

//	navigate
	public void navigate(String locType, String locValue, String testdata) {
		this.driver.get(testdata);
	}

//	setText
	public void setText(String locType, String locValue, String testdata) {
		this.driver.findElement(LocatorHelper.locateElement(locType, locValue)).sendKeys(testdata);
		sleep(2000);
	}

//	click
	public void click(String locType, String locValue, String testdata) {
		this.driver.findElement(LocatorHelper.locateElement(locType, locValue)).click();
		sleep(2000);
	}

//	moveToElement
	public void moveToElement(String locType, String locValue, String testdata) {
		Actions actions = new Actions(this.driver);
		actions.moveToElement(this.driver.findElement(LocatorHelper.locateElement(locType, locValue))).build()
				.perform();
		sleep(2000);
	}

//	moveToEleAndClick
	public void moveToEleAndClick(String locType, String locValue, String testdata) {
		Actions actions = new Actions(this.driver);
		actions.moveToElement(this.driver.findElement(LocatorHelper.locateElement(locType, locValue))).click().build()
				.perform();
		sleep(2000);
	}

//	switchToFrame
	public void switchToFrame(String locType, String locValue, String testdata) {
		WebElement frameToSwitch = driver.findElement(LocatorHelper.locateElement(locType, locValue));
		this.driver.switchTo().frame(frameToSwitch);
	}

//	select
	public void select(String locType, String locValue, String testdata) {
		WebElement ele = this.driver.findElement(LocatorHelper.locateElement(locType, locValue));
		Select eleSelect = new Select(ele);
		eleSelect.selectByVisibleText(testdata);
		sleep(2000);
	}

//	switchToDefaultContent
	public void switchToDefaultContent(String locType, String locValue, String testdata) {
		this.driver.switchTo().defaultContent();
	}

//	closeBrowser
	public void closeBrowser(String locType, String locValue, String testdata) {
		closeBroser();
	}

//	clear
	public void clear(String locType, String locValue, String testdata) {
		this.driver.findElement(LocatorHelper.locateElement(locType, locValue)).clear();
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
