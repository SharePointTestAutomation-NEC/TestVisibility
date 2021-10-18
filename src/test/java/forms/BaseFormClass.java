package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseFormClass {


    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "DBA")
    public WebElement alternateCompanyName;

    @FindBy(id = "TaxId.Anonymized")
    public WebElement taxID;

    @FindBy(name = "Address1")
    public WebElement address;

    @FindBy(id = "CountryId")
    public WebElement country;

    @FindBy(id = "RegionId")
    public WebElement regionOrState;

    @FindBy(id = "City")
    public WebElement city;

    @FindBy(id = "ZipCode")
    public WebElement zipCode;

    @FindBy(id = "CountryOfIncorporationId")
    public WebElement countryOfIncorporation;

    @FindBy(id = "Website")
    public WebElement website;

    public BaseFormClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
