package baseMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public static WebDriver driver = null;

	public Wait(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public static void waitForElementToBePresentByXpath(WebDriver driver, By locator) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
	}
	public static void waitForElementToBeVisibleByXpath(WebDriver driver, By locator) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
	}
	public static void waitForElementToBeClickableByXpath(WebDriver driver, By locator) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			
	}
	public static void waitForElementsToBeVisibleByXpath(WebDriver driver, By locator) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements((List<WebElement>) locator));
	}
	public static void waitForElementsToBePresentByXpath(WebDriver driver, By locator) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	} 
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public static void waitFortextToBePresentInElementLocated(WebDriver driver, By locator, String text) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}	
	public static void waitForTextToBePresentInElementValue(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElementValue(element,text));
	}
	public static void waitForTextToBePresentInElementValue(WebDriver driver, String xpath, String text) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath(xpath),text));
	}
	public static void waitForframeToBeAvailableAndSwitchToItByLocator(WebDriver driver, String Locator) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Locator));
	}
	public static void waitForframeToBeAvailableAndSwitchToItByXpath(WebDriver driver, String xpath) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(xpath)));
	}
	public static void waitForframeToBeAvailableAndSwitchToItByXpathByIndex(WebDriver driver, int index) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	public static void waitForinvisibilityOfElementLocated(WebDriver driver, String xpath) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
	public static void waitForinvisibilityOfElementWithText(WebDriver driver, String xpath, String text) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitForElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public static void waitForelementToBeSelected(WebDriver driver, By locator) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	public static void waitForAlertIsPresent(WebDriver driver, By locator) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	
	
	
	
	
	
	
	

}
