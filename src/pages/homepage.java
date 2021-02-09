package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class homepage {


	public static WebDriver driver=null;
	
	public  homepage(WebDriver driver) {
		this.driver=driver;
	}
	
	public static void takescreenshot() throws IOException {
		TakesScreenshot scrshot=((TakesScreenshot)driver);
		File SrcFile=scrshot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("E:\\Sandip\\Screen shot\\homepage1.png");
		
		FileUtils.copyFile(SrcFile, DestFile);
		
	}
}
