package test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.ProcessStarter;
import org.im4java.process.StandardStream;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;

import baseMethods.CompareImages;
import baseMethods.PdfWriterTable;
import baseMethods.ScreenShot;
import pages.Login;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

public class Cbt1 extends TestBase {

	
	public static void main(String args[]) throws IOException, InterruptedException, DocumentException {
		befortest();
		driver.get(url);
		ScreenShot.doScreenShot(driver,"ScreenshotChrm");
		driver.quit();
		startEdgeBrowser();
		maximize();
		driver.get(url);
		ScreenShot.doScreenShot(driver, "ScreenshotEdge");
		
		driver.quit();
		CompareImages.doCompare("ScreenshotChrm", "ScreenshotEdge", "DiffImage");
		
		PdfWriterTable.writeTable("ScreenshotChrm", "ScreenshotEdge", "DiffImage", "CBTversion1",3);
		assertEquals(CompareImages.doCompare("ScreenshotChrm", "ScreenshotEdge", "DiffImage").hasDiff(), false, "Images are not same");

	}
}
