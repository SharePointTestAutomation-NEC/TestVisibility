package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import step_definitions.BaseClass;


public class Wrapers extends BaseClass {
    Wait wait = new Wait();

    public void findAndClick(WebDriver driver, By by) {
        driver.findElement(by).click();
    }

    public String getThirdPartyNameFromList() {
        String thirdParty = wait.waitAndGetText
                (driver, By.cssSelector("td[aria-describedby='jqGrid_E']"));
        return thirdParty;
    }
}


