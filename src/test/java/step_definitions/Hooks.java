package step_definitions;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import util.Browsers;

import java.net.URL;
import java.util.Arrays;
import java.util.logging.Level;

public class Hooks {

    public static WebDriver driver;
    private static final String driverDirectory = System.getProperty("user.dir") + "/webDrivers/usr/bin";

    private final ChromeOptions chromeOptions = new ChromeOptions();
    private final InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
    private DesiredCapabilities capabilities;
    @Before
    public void openBrowser() throws Exception {

        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        String browser = System.getProperty("BROWSER");
        if (browser == null) {
            browser = System.getenv("BROWSER");
            if (browser == null) {
                browser = "chromeheadless";
            }

        }
        switch (browser.toLowerCase()) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                String os = System.getProperty("os.name").toLowerCase();
                if (os.contains("win")) {
                    chromeOptions.addArguments("test-type");
                    chromeOptions.addArguments("no-sandbox");
                    //Fix for cannot get automation extension
                    chromeOptions.addArguments("disable-extensions");
                    chromeOptions.addArguments("start-maximized");
                    chromeOptions.addArguments("--js-flags=--expose-gc");
                    chromeOptions.addArguments("disable-plugins");
                    chromeOptions.addArguments("--enable-precise-memory-info");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--disable-default-apps");
                    chromeOptions.addArguments("test-type=browser");
                    chromeOptions.addArguments("disable-infobars");
                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    //driver.get("http://tc3-v-devsp06:9999/SitePages/Home.aspx");
                }
                else{
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("test-type");
                    chromeOptions.addArguments("no-sandbox");
                    //Fix for cannot get automation extension
                    chromeOptions.addArguments("disable-extensions");
                    chromeOptions.addArguments("start-maximized");
                    chromeOptions.addArguments("--js-flags=--expose-gc");
                    chromeOptions.addArguments("disable-plugins");
                    chromeOptions.addArguments("--enable-precise-memory-info");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--disable-default-apps");
                    chromeOptions.addArguments("test-type=browser");
                    chromeOptions.addArguments("disable-infobars");
                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    driver = new ChromeDriver();
                    driver.manage().window().setSize(new Dimension(1280, 1024));
                }
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", driverDirectory + "/geckoFirefox/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "chromeheadless":
                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1200x600");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "chromeheadlesswindows":
                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1200x600");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "ie":
                System.setProperty("webdriver.ie.driver", driverDirectory + "/IE/IEDriverServer.exe");
                driver = new InternetExplorerDriver(internetExplorerOptions);
                internetExplorerOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                internetExplorerOptions.setCapability("unexpectedAlertBehaviour", "accept");
                internetExplorerOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver.manage().window().maximize();
                break;

            case "ieWindows":
                InternetExplorerOptions ieOptions = new InternetExplorerOptions()
                        .destructivelyEnsureCleanSession();
                capabilities.setCapability("se:ieOptions", ieOptions);
                driver = new InternetExplorerDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

//          This can be only run from an windows machine.
            case "iegrid":
                String nodesURL = "http://10.211.55.3:5555/wd/hub";
                DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
                cap.setBrowserName("internet explorer");
                cap.setPlatform(Platform.WINDOWS);
                WebDriver driver = new RemoteWebDriver(new URL(nodesURL), cap);
                break;
        }

//        driver.manage().window().setSize(new Dimension(1280, 1024));
        System.out.println("The Browser used for this test is: " + browser.toUpperCase());
//        driver.manage().deleteAllCookies();
    }


    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + new URL(driver.getCurrentUrl()));
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }
}


