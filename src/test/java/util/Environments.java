package util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Hooks;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by titudatta on 5/13/16.
 */
public class Environments {

    public WebDriver driver;

    public Environments() {

        driver = Hooks.driver;
        String Env = System.getProperty("ENV");
        if (Env == null) {
            Env = "qa";
        }
        System.out.println("The test is running on " + Env.toUpperCase() + " environment");
        switch (Env.toLowerCase()) {
            case "dev":
            case "development":
                driver.get("");
                break;
            case "prod":
                driver.get("");
                break;
            case "qa":

                //driver.get(" http://tc3-v-devsp05:8888/Lists/Bid%20Managers/AllItems.aspx ");
              break;
            case "production":
                driver.get("");
                break;
            case "staging":
                driver.get("");
                break;
        }
    }


}
