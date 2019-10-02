package banking.keyworddriven;

import org.openqa.selenium.By;

public class LocatorHelper {
	
	public static By locateElement(String locType, String locValue) {
		By loc = null;
		locType = locType.toLowerCase();
		switch (locType) {
		case "id":
			loc = By.id(locValue);
			break;
		case "name":
			loc = By.name(locValue);
			break;
		case "linktext":
			loc = By.linkText(locValue);
			break;
		case "partiallinktext":
			loc = By.partialLinkText(locValue);
			break;
		case "cssselector":
			loc = By.cssSelector(locValue);
			break;
		case "xpath":
			loc = By.xpath(locValue);
			break;
		case "classname":
			loc = By.className(locValue);
			break;
		case "tagname":
			loc = By.tagName(locValue);
			break;
		default:
			throw new RuntimeException("invlaid locator type");
		}
		return loc;
	}

}
