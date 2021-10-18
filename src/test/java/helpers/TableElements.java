package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;

import java.util.List;


public class TableElements extends BaseClass{
    Wait wait = new Wait();
    private final ScrollintoView scrollintoView = new ScrollintoView();
    private final JavascriptExecutor jse = (JavascriptExecutor) driver;


    public void clickTwoConditionMet(String findByID, String firstCondition, String secondCondition){
        WebElement baseTable = driver.findElement(By.id(findByID));
//        wait.waitUntilPresent(driver, By.tagName("tr"));
        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
        for (WebElement table : tableRows) {
            if (table.getText().contains(firstCondition) && table.getText().contains(secondCondition)) {
                table.click();
                break;
            }
        }
    }

    public void clickAStringInTable(String containsString) throws InterruptedException {

        String cssPath = String.format("td[title='%s']", containsString);

        if (driver.findElement(By.cssSelector(cssPath)).isDisplayed()) {
            driver.findElement(By.cssSelector(cssPath)).click();
        } else {
            WebElement nextPage = driver.findElement(By.id("next_jqPager"));
            scrollintoView.scrollToView(nextPage);
            nextPage.click();
            wait.waitUntilGridSpinnersNotPresent();
            jse.executeScript("scroll(0, -250);");
            wait.waitAndClick(driver, By.cssSelector(cssPath));
        }
    }
}
