package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import step_definitions.BaseClass;


public class PageHelpers extends BaseClass{
    private final Wait wait = new Wait();

    public void checkPageIsReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Check the dom to see if the page load is complete
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page is fully loaded.");
            return;
        }

        // This loop will rotate for 25 times to check If page Is ready after every 1 second.
        for (int i = 0; i < 25; i++) {
            try {
                System.out.println("Page is not fully loaded, trying again in 10 second.");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }

            // Break out of loop when we see the ready state is complete
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
        throw new TimeoutException("DOM never returned readyState as complete after 25 tries.");
    }

    public String switchToiFrame(WebDriver driver, String frameName) throws InterruptedException {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilSubjectLoadingNotPresent();
        wait.waitUntilPresent(By.id(frameName));
        driver.switchTo().defaultContent(); // now outside of both frames
        driver.switchTo().frame(frameName);
        String thirdPartyNameFromIFrame = wait.waitAndGetText(driver, By.xpath("//h1[@class='ng-binding']"));
        System.out.println("The third party name is "+ thirdPartyNameFromIFrame);
        return thirdPartyNameFromIFrame;
    }
}
