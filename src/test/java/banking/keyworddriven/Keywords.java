package banking.keyworddriven;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.print.DocFlavor.STRING;

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
	}

//	click
	public void click(String locType, String locValue, String testdata) {
		this.driver.findElement(LocatorHelper.locateElement(locType, locValue)).click();
	}

//	moveToElement
	public void moveToElement(String locType, String locValue, String testdata) {
		Actions actions = new Actions(this.driver);
		actions.moveToElement(this.driver.findElement(LocatorHelper.locateElement(locType, locValue))).build().perform();
	}

//	moveToEleAndClick
	public void moveToEleAndClick(String locType, String locValue, String testdata) {
		Actions actions = new Actions(this.driver);
		actions.moveToElement(this.driver.findElement(LocatorHelper.locateElement(locType, locValue))).click().build().perform();
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
	

}
