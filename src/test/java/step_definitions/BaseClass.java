package step_definitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Environments;
import util.ExtentHtmlManager;

import java.util.Properties;

public class BaseClass {
	public static Properties prop;
	public WebDriver driver = Hooks.driver;
	public ExtentReports rep = ExtentHtmlManager.getExtentReportsInstance();
	public ExtentTest test;

	public void navigateToSharePointProject() {
		Environments env = new Environments();
	}

	public void waitForPageToLoad(WebElement xpath){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(xpath));
	}
}