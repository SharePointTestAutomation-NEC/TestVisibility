package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import step_definitions.BaseClass;

import java.util.List;
import java.util.Random;


public class SelectElements extends BaseClass{
    private final Random random = new Random();


    public void selectRandomValueDropdown(String ID){
        Select selectItem = new Select(driver.findElement(By.id(ID)));
        int optionIndex = random.nextInt(selectItem.getOptions().size() - 1);
        selectItem.selectByIndex(optionIndex++);
    }

    public void selectRandomOption(By by){
        Select oSelect = new Select(driver.findElement(by));
        List<WebElement> allProducts = oSelect.getOptions();
        int randomProduct = random.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
    }

    public void selectRandomOptionBesideFirst(By by){
        Select oSelect = new Select(driver.findElement(by));
        List<WebElement> allProducts = oSelect.getOptions();
        for (int i = 0; i < allProducts.size(); i++){

            int randomProduct = random.nextInt(allProducts.size());
            allProducts.get(randomProduct).click();
        }
    }
    public void selectByVisibleText(By by, String text){
       new Select(driver.findElement(by)).selectByVisibleText(text);
    }
    public void selectByVisibleText(WebElement element, String text){
        new Select(element).selectByVisibleText(text);
    }

    public void selectByIndexNumbert(By by, int indexNumber){
        new Select(driver.findElement(by)).selectByIndex(indexNumber);
    }
    public void selectByIndexNumbert(WebElement element, int indexNumber){
        new Select(element).selectByIndex(indexNumber);
    }

    public void selectJavaScriptItems(String selectID, String selectText) throws Exception {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript(String.format("$('#%s').attr('style','display:block;');", selectID));
            ((JavascriptExecutor) driver).executeScript(String.format("$('#%s option').attr('style','display:block;')", selectID));
        } else {
            throw new Exception("broken");
        }

        WebElement element = driver.findElement(By.id(selectID));
        Select select = new Select(element);
        select.selectByVisibleText(selectText);
    }

    public void selectRandombyElement(WebElement element) {
        Select oSelect = new Select(element);
        List<WebElement> allProducts = oSelect.getOptions();
        int randomProduct = random.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
    }
}
