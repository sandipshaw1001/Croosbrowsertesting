package baseMethods;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImages extends BaseSeleniumMethod {

	private WebDriver driver;
	public void CompareImages(WebDriver driver) {
		this.driver=driver;
	}
	public static ImageDiff doCompare(String Name, String name2, String DiffImageName) throws IOException {
		ImageDiffer imgDiff = new ImageDiffer();
		BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + "//" + Name + ".png"));
		BufferedImage ActualImage = ImageIO.read(new File(System.getProperty("user.dir") + "//" + name2 + ".png"));
		ImageDiff diff = imgDiff.makeDiff(expectedImage, ActualImage);
		ImageIO.write(diff.getMarkedImage(), "PNG",
				new File(System.getProperty("user.dir") + "//" + DiffImageName + ".png"));

		if (diff.hasDiff() == true) {
			System.out.println("Images are Not Same");

		} else {
			System.out.println("Images are Same");

		}
		return diff;
		
	}
}
