package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static step_definitions.Hooks.driver;


public class ScrollintoView {

    private final JavascriptExecutor jse = (JavascriptExecutor) driver;


    public void scrollToView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void scrollUp(){
        jse.executeScript("scroll(0, -250);");

    }

    public void scrollDown(){
        jse.executeScript("scroll(0, 250);");
    }

    public void scrollToMiddle(){
        jse.executeScript("scroll(0, 125);");

    }
    public void scrollToViewAndClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element );
        element.click();
    }
}
