package helpers;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.BaseClass;

import java.util.ArrayList;
import java.util.List;


public class Wait extends BaseClass {

    private final int waitTime = 30;
    private static WebElement element;
    private final WebDriverWait webDriverWait = new WebDriverWait(driver, waitTime);


    @And("^I wait (\\d+) seconds for .*$")
    public void iWaitSecondsForPageToLoad(int seconds) throws Throwable {
        Thread.sleep(seconds*1000);
    }


    public void waitAndClick(WebDriver driver, By by) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public WebElement waitAndClick(WebElement element)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return element;
    }

    public void waitUntilPresent(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitUntilPresent(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public String waitUntilTextIs(By by, String text){
        webDriverWait.until(ExpectedConditions.textToBe(by, text));
        return text;
    }

    public void waitAndClickOnElement(WebDriver driver, WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilNotPresent(By by) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public String waitAndGetText(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String text = driver.findElement(by).getText();
        return text;
    }
    public String waitAndGetText(WebDriver driver, WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
         return element.getText();
    }


    public WebElement waitAndReturnElement(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        return element;
    }

    public void waitToGetTitle(WebDriver driver, String title) {
        webDriverWait.until(ExpectedConditions.titleIs(title));

    }

    public List<WebElement> waitAndReturnListElements(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        List<WebElement> elements = driver.findElements(by);
        return elements;
    }

    public void waitAndSendKeys(WebDriver driver, By by, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);
    }

    public void waitAndSendKeysByElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void waitAndSwitchToNewWindow(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        if (driver.findElement(by).isDisplayed()) {
            driver.switchTo().activeElement();
        }
    }
    public void waitAndSwitchToNewTab(){

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void waitAndSwitchToMainTab(){

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    public void waitUntilGridSpinnersNotPresent() {

        if (driver.findElements(By.id("gridSpinner")).size() != 0) {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("gridSpinner")));
        } else if (driver.findElements(By.cssSelector("div.loading:nth-child(1) > img:nth-child(1)")).size() != 0) {

            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated
                    (By.cssSelector("div.loading:nth-child(1) > img:nth-child(1)")));
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_jqGrid")));
        }
        else if (driver.findElements(By.id("load_jqGrid")).size() != 0) {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_jqGrid")));
        }

    }
    public void waitUntilSubjectLoadingNotPresent() {
        if (driver.findElements(By.cssSelector("[data-bind='visible: SubjectLoading']")).size() != 0) {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated
                    (By.cssSelector("[data-bind='visible: SubjectLoading']")));
        }
    }
    public void untilNumberOfWindows(int numberOfWindows){
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
    }
}