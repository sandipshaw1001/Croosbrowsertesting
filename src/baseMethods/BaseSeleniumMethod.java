package baseMethods;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseSeleniumMethod {
	private WebDriver driver;

	public void BaseSeleniumMethod(WebDriver driver) {
		this.driver=driver;
	}

	
	
	
	public static void clickByXpath(WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).click();;
	}
	public static void clickByCssSelector(WebDriver driver,String cssselector) {
		driver.findElement(By.cssSelector(cssselector)).click();
	}
	public static void clickById(WebDriver driver,String id) {
		driver.findElement(By.id(id)).click();
	}
	public static void clickLinkText(WebDriver driver,String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}
	public static void clearByXpath(WebDriver driver,String xpath) {
		driver.findElement(By.xpath(xpath)).clear();;
	}
	public static void clickAndWait(WebDriver driver, String xpath,long timeunit) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(timeunit);
	}
	public static boolean elementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	public static boolean elementSelected(WebElement element) {
		return element.isSelected();
	}
	public static void selectByIndex(WebDriver driver, String xpath, int i) {
		Select select= new Select( driver.findElement(By.xpath(xpath)));
		select.selectByIndex(i);
	}
	public static void switchToFrameByFrameName(WebDriver driver, String framename) {
		driver.switchTo().frame(framename);
	}
	public static void switchToFrameByIndex(WebDriver driver, int id) {
		driver.switchTo().frame(id);
	}
	public static void switchToFrameByElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public static void switchToParentFrame(WebDriver driver, WebElement element) {
		driver.switchTo().parentFrame();
	}
	public static void switchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}
	public static void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public static void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public static void switchToAlertAndSendText(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	public static String switchToAlertAndGetText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	public static void switchToWindowByWindowHandles(WebDriver driver, String handle) {
		driver.switchTo().window(handle);
	}
	public static void switchToWindowByWindowName(WebDriver driver, String windowname) {
		driver.switchTo().window(windowname);
	}
	public static void switchToParentWindow(WebDriver driver, String windowname) {
		driver.switchTo().defaultContent();
	}
	public static void selectByVisibleText(WebDriver driver, String xpath, String text) {
		Select select= new Select( driver.findElement(By.xpath(xpath)));
		select.selectByVisibleText(text);
	}
	public static void selectByValue(WebDriver driver, String xpath, String value) {
		Select select= new Select( driver.findElement(By.xpath(xpath)));
		select.selectByValue(value);
	}
	public static void deSelectByVisibleText(WebDriver driver, String xpath, String text) {
		Select select= new Select( driver.findElement(By.xpath(xpath)));
		select.deselectByVisibleText(text);
	}
	public static void navigateTo(WebDriver driver, String text) {
		driver.navigate().to(text);
	}
	public static void navigateToForward(WebDriver driver) {
		driver.navigate().forward();
	}
	public static void navigateToBack(WebDriver driver) {
		driver.navigate().back();
	}
	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	public static void navigateToUrl(WebDriver driver, URL url) {
		driver.navigate().to(url);
	}
	public static void clearTextByElement(WebDriver driver,WebElement element) {
		element.clear();
	}
	public static String getCssValueByElement(WebDriver driver,WebElement element, String propertyName) {
		return element.getCssValue(propertyName);
	}
	public static void checkCheckBoxByXpath(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		
		
	}
	public static void checkCheckBoxByCheckBoxElement(WebDriver driver, WebElement element) {
		element.click();
		
		
	}
	
	public static void checkCheckBoxIfNotChecked(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).isSelected();
	}
	public static void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	//test
	public static String getCurrentUrl(WebDriver driver, String url) {
		return driver.getCurrentUrl();
	}
	public static String getWindowTitleInString(WebDriver driver, String url) {
		return driver.getTitle();
	}
	public static WebElement switchToActiveElement(WebDriver driver, String url) {
		return driver.switchTo().activeElement();
	}
	
	
	
	
	
	
	
	
	
	

	
}
