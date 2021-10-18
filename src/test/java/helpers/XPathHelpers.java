package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;

public class XPathHelpers extends BaseClass {

    private final Wait wait = new Wait();
    private final ScrollintoView scrollintoView = new ScrollintoView();
    private final JavascriptExecutor jse = (JavascriptExecutor) driver;


    public WebElement valueXpathInTable(String id, String containsString) {

        WebElement element = driver.findElement(By.xpath(String.format
                (".//*[@id='%s']//td[contains(.,'%s')]", id, containsString)));
        return element;
    }

    public void clickTwoXpathConditionOnTable(String id, String firstString, String secondString) {


        driver.findElement(By.xpath(String.format
                (".//*[@id='%s']//td[contains(.,'%s')]// and td[contains(.,'%s')]",
                        id, firstString, secondString))).click();
    }

}
