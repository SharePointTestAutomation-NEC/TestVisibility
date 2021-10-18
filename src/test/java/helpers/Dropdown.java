package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;

import java.util.List;


public class Dropdown extends BaseClass {

    public void selectValueFromUnorderedList(WebElement driver, final String value) {
        List<WebElement> options = driver.findElements(By.tagName("select"));
        for (WebElement option : options) {
            if (value.equalsIgnoreCase(option.getText())) {
                option.click();
                break;
            }
        }
    }

    public void selectValueFromUnorderedListWithCheckbox(WebDriver driver, WebElement optionlistdiv, WebElement button, final String value) {
        button.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> inputs = optionlistdiv.findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            js.executeScript("arguments[0].setAttribute('style', 'display:none;')",input);
        }
        List<WebElement> options = optionlistdiv.findElements(By.tagName("label"));
        for (WebElement option : options) {
            if (value.equalsIgnoreCase(option.getText())) {
                option.click();
                break;
            }
        }
        button.click();
    }

    public void selectValueFromInput(WebElement optionlistdiv, WebElement button, final String value) {
        button.click();
        List<WebElement> options = optionlistdiv.findElements(By.tagName("select"));
        for (WebElement option : options) {
            if (value.equalsIgnoreCase(option.getAttribute("value"))) {
                option.click();
                break;
            }
        }
        button.click();
    }
}
