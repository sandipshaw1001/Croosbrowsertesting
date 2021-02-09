package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	
	public static WebDriver driver=null;
	
	public  Login(WebDriver driver) {
		this.driver=driver;
	}
	public static void login() {
		
		driver.findElement(By.xpath("")).sendKeys("username");
		
		
		
		
	}
}
