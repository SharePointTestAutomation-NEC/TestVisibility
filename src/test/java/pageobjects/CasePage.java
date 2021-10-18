package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class CasePage extends BaseClass{

    @FindBy(id = "OrderName")
    public WebElement caseName;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/form[2]/div[1]/div[2]/div/button")
    public WebElement statusDropdown;

    @FindBy (id = "OrderNumber")
    public WebElement orderNumber;
    
    @FindBy (id = "SubjectName")
    public WebElement subjectName;
    
    @FindBy (id = "AccountId")
    public WebElement accountName;
    
    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/form[2]/div[1]/div[6]/div/button")
    public WebElement jurisdictionDorpdown;
    
    @FindBy (id = "SearchButton")
    public WebElement searchButton;
    
    @FindBy (id = "ResetButton")
    public WebElement resetButton;

    @FindBy (xpath = "//*[@id=\"jqGrid\"]//tr[not(contains(@class,'jqgfirstrow'))][1]")
    public WebElement firstrow;

    @FindBy (xpath = ".//*[@id='SupervisorId']")
    public WebElement coredetails;

    @FindBy (partialLinkText = "Edit Core Details")
    public WebElement coredetailslink;

    @FindBy(name = "DueDate")
    public WebElement duedate;

    @FindBy(name = "InterimReportDueDate")
    public WebElement interimreportduedate;

    @FindBy(className = "interim-due-date-completed-checkbox-center")
    public WebElement interimreportcheckbox;

    @FindBy(id = "saveCaseCoreDetailsButton")
    public WebElement savecoredetails;
    
    public CasePage(){
        PageFactory.initElements(driver, this);
    }
}
