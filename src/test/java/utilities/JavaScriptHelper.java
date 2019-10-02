package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
	
	// bring an element text
	public static String getElementText(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return arguments[0].value", element).toString();
	}
	
	// bring an element into view
	public static void bringElementToView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	// scroll a page either up or down
	public static void scrollPageBy(WebDriver driver, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.documentElement.scrollBy(0, arguments[0])", y);
	}
	
	// execute any javascript code
	public static Object executeJavaScript(WebDriver driver, String arg, Object... args) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(arg, args);
	}

}
