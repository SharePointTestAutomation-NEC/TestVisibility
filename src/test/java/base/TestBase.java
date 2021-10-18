package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import util.ExtentHtmlManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Properties BidOperationsPageprop;
	public static EventFiringWebDriver e_driver;
	public static String testDataSheetPath;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public ExtentReports rep = ExtentHtmlManager.getExtentReportsInstance();
	public ExtentTest test;

//	public static XLS_POI xlsx;

	public TestBase() {
		System.out.println("Beginning of TestBase Constructor in TestBase Class...");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * try { Properties BidOperationsPageprop = new Properties(); FileInputStream ip
		 * = new FileInputStream( System.getProperty("user.dir") + "/src/main/java" +
		 * "/com/sharepoint/qa/config/BidOperationsPage.properties");
		 * BidOperationsPageprop.load(ip); System.out.println("CreateNewBid xpath = " +
		 * BidOperationsPageprop.get("CreateNewBid"));
		 * System.out.println("CreateNewBidFrame xpath = " +
		 * BidOperationsPageprop.get("CreateNewBidFrame")); } catch
		 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */

		System.out.println("End of TestBase Constructor in TestBase Class...");
	}

	public static void initialization() {
		System.out.println("Beginning of initialization method in TestBase Class...");
		String browserName = prop.getProperty("browser");
		testDataSheetPath = "\\src\\main\\java\\com\\sharepoint\\qa\\testdata\\"
				+ prop.getProperty("testDataSheetName");
		System.out.println("testDataSheetPath in initialization method in TestBase = " + testDataSheetPath);

		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setBinary(prop.getProperty("chromeexepath"));
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
			driver = new ChromeDriver(options);
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverdriverpath"));
			
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("Jigar");
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(myprofile);
//			options.setBinary(prop.getProperty("firefoxexepath"));
//			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

			driver = new FirefoxDriver(options);
		} else if (browserName.equals("IE")) {
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			driver = new InternetExplorerDriver(ieOptions);
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver

		//eventListener = new WebEventListener();
		//e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		if (browserName.equals("FF")) {
			/*
			 * String url = (String) prop.get("url"); String username = (String)
			 * prop.get("username"); String password = (String) prop.get("password");
			 * String[] splitstring = url.split("//"); String newurl = splitstring[0] + "//"
			 * + username + ":" + password + "@" + splitstring[1];
			 * System.out.println("newurl = " + newurl);
			 */

			try {
				driver.navigate().to(prop.getProperty("url"));
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				System.out.println("Error occured..........");
				e.printStackTrace();
			}

			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				System.out.println("Error occured..........");
				e.printStackTrace();
			}

		} else if (browserName.equals("chrome") || browserName.equals("IE")) {
			try {
				driver.navigate().to(prop.getProperty("url"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("End of initialization method in TestBase Class...");
	}
}
