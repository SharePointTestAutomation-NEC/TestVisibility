package helpers;


import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.BaseClass;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertThat;


public class PopupWindow extends BaseClass {
    private final Wait wait = new Wait();
    private final Faker faker = new Faker();

    public Boolean checkIfPopupWindowClosed() {

        int windowCount = driver.getWindowHandles().size();

        if (windowCount > 1) {

        }

        try {
            return (new WebDriverWait(driver, 20)).
                    until(new ExpectedCondition<Boolean>() {

                              @Override
                              public Boolean apply(WebDriver d) {
                                  return d.getWindowHandles().size() < 1;
                              }
                          }
                    );
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void getTitleOfNewPage(WebDriver driver, String newPageTitle) throws InterruptedException {
        Thread.sleep(20000);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        String title = driver.getTitle();
        System.out.println("title check " +title);
        assertThat(title, CoreMatchers.containsString(newPageTitle));
    }

    public void ifPopupClickContinue() throws InterruptedException {
        if (driver.findElement(By.id("modalDialog")).isDisplayed()) {
            String winHandleBefore = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            driver.findElement(By.id("modalDialogConfirmButton")).click();
            Thread.sleep(2000);
        }
    }

    public void getTheHandleOf() {
        wait.waitUntilPresent(By.id("modalDialog"));
        driver.switchTo().activeElement();
    }

    public String editAnAffiliate() throws InterruptedException {
        Name name = faker.name();
        String fakeName = name.fullName();
        moveToNewFrame();
        Thread.sleep(3000);
        driver.findElement(By.id("Name")).clear();
        driver.findElement(By.id("Name")).sendKeys(fakeName);
        driver.findElement(By.id("modalDialogConfirmButton")).click();
        wait.waitUntilNotPresent(By.id("modalDialogConfirmButton"));
        return fakeName;
    }


    public void moveToNewWindow() {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void moveToNewTab() {
//        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
        Set handles = driver.getWindowHandles();
        Iterator i = handles.iterator();
        String parent=(String) i.next();
        String child=(String) i.next();
        driver.switchTo().window(child);

    }

    public void closeNewWindow() {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            driver.close();
        }
    }

    public void moveToNewFrame() {
        if (driver.findElement(By.id("modalDialog")).isDisplayed()) {
            String winHandleBefore = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
        }
    }
}

