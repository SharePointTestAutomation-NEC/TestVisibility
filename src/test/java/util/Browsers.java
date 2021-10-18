package util;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by titudatta on 1/10/17.
 */
public class Browsers {
//    private static String USERNAME = ""; // Your username
//    private static String ACCESS_KEY = "02486554-c03f-4e0a-8659-548230c55c7a";  // Your authkey
   public static WebDriver driver;
    public static Properties prop;
    private static final String driverDirectory = System.getProperty("user.dir") + "/webDrivers/usr/bin";
    private static final DesiredCapabilities caps = new DesiredCapabilities();
    public static WebDriver getPJSMacDriver() throws Exception {
        String[] cli_args = new String[]{"--ignore-ssl-errors=true"};
        System.out.println("Getting ready to start with Phantom JS Mac");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/macPJS/phantomjs"));
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "javascriptEnabled", true);
        WebDriver driver = new PhantomJSDriver(caps);
        driver.manage().window().setSize(new Dimension(1280, 1024));
        return driver;
    }


    public static WebDriver getHTMLDriver() throws Exception {
        String[] cli_args = new String[]{"--ignore-ssl-errors=true"};
        System.out.println("Getting ready to start with Phantom JS Mac");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/macPJS/phantomjs"));
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "javascriptEnabled", true);
        WebDriver driver = new PhantomJSDriver(caps);
        driver.manage().window().setSize(new Dimension(1280, 1024));
        return driver;
    }

    public static WebDriver getPJSLinux() throws Exception {

        System.out.println("Getting ready to start with Phantom JS Linux");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/linuxPJS/phantomjs"));
        WebDriver driver = new PhantomJSDriver(caps);
        return driver;
    }


    public static WebDriver getpjsWindows() throws Exception {

        System.out.println("Getting ready to start with Phantom JS Windows");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/WindowsPJS/phantomjs.exe"));
        WebDriver driver = new PhantomJSDriver(caps);
        return driver;
    }


    public static WebDriver getIEGrid() throws Exception {
        String nodesURL = "http://10.211.55.3:5555/wd/hub";
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setBrowserName("internet explorer");
        cap.setPlatform(Platform.WINDOWS);
        WebDriver driver = new RemoteWebDriver(new URL(nodesURL), cap);
        return driver;

    }

    public static WebDriver getChromeDriver(){
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("no-sandbox");
        //Fix for cannot get automation extension
        options.addArguments("disable-extensions");
        options.addArguments("start-maximized");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("disable-plugins");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("disable-infobars");
        options.setExperimentalOption("useAutomationExtension", false);
			options.setBinary(prop.getProperty("chromeexepath"));
			System.setProperty("webdriver.chrome.driver", prop.getProperty(driverDirectory+"chromedriverpath"));
			driver = new ChromeDriver(options);
        return driver;
    }




    private static WebDriver getBrowser(final String browser, final DesiredCapabilities capabilities) {
        switch (browser) {
            case "BROWSER_HTMLUNIT":
                return new HtmlUnitDriver(capabilities);
            case "BROWSER_CHROME":
                  // getChromeDriver();
                //return new initChromeDriver();
        }
        throw new RuntimeException("No browser specified! Use " + browser + " parameter.");
    }

}






























