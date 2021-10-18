package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;


public class Title_URL_Meta extends BaseClass {

    public static String getTitle(WebDriver driver) throws Throwable {

        String Title = driver.getTitle();
        System.out.println(Title);
        return Title;
    }

    public static String getURL(WebDriver driver) throws Throwable {

        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        return URL;
    }


    public static String getMetaData(WebDriver driver) throws Throwable {

        WebElement Meta = driver.findElement(By.xpath("//meta[@name='description']"));
        String metaDescription = Meta.getAttribute("content");
        System.out.println("The metadata of this page: " + metaDescription);
        return metaDescription;
    }

}
