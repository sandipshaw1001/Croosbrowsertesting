package baseMethods;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.itextpdf.text.DocumentException;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot {

	public static WebDriver driver = null;

	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * public void dofullScreenShot() throws IOException {
	 * 
	 * Screenshot screenshot= new
	 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).
	 * takeScreenshot(driver); ImageIO.write(screenshot.getImage(), "PNG", new
	 * File(System.getProperty("user.dir")+"\\screenshots\\fullpagescrn.png"));
	 * 
	 * }
	 */

	public static void doScreenShot( WebDriver driver,String ScreenShotname) throws IOException, DocumentException {

		Screenshot screenshot = new AShot().takeScreenshot(driver);

		ImageIO.write(screenshot.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "\\"+ScreenShotname+".png"));

	}

	public static void doFullPageScreenShot(WebDriver driver,String ScreenShotname) throws IOException, DocumentException {

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "\\screenshots\\"+ScreenShotname+".png"));

	}

	
}
