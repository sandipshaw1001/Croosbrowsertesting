package test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static WebDriver driver = null;
	public static String url = null;

	public static void befortest() throws IOException {
		FileReader file = new FileReader("CBT.properties");

		Properties prop = new Properties();

		prop.load(file);

		String Browser = prop.getProperty("Browser");

		url = prop.getProperty("url");
		if (Browser.contains("chrome")) {
			startChromeBrowser();
			setSize();
			maximize();

		} else if (Browser.contains("edge")) {
			startEdgeBrowser();
			setSize();
			maximize();

		} else if (Browser.contains("firefox")) {
			startFirefoxBrowser();
			setSize();
			maximize();

		} else {
			System.out.println("Not correct browser specified");
		}

	}

	protected static void maximize() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	protected static void setSize() {
		driver.manage().window().setSize(new Dimension(1024, 300));
	}

	public static void startChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		driver = new ChromeDriver(options);

	}

	public static void startFirefoxBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		driver = new ChromeDriver(options);

	}

	public static void startEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\firefoxdriver.exe");
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.setExperimentalOption("useAutomationExtension", false);
		edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		driver = new EdgeDriver(edgeOptions);

	}
}
