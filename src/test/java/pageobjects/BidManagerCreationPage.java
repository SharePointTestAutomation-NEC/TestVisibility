package pageobjects;

import helpers.Wait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.BaseClass;

public class BidManagerCreationPage extends BaseClass {

//	WebConnnector con;

	@FindBy(xpath = "//span[contains(@class,'CommandBarItem-commandText') and text()='New']")
	WebElement BidCreateNewBtn;
	
	@FindBy(xpath = "//input[@class='od-TextEditor-input od-TextField-field']")
	WebElement BidManagerName;
	//input[@class='od-TextEditor-input od-TextField-field']
	@FindBy(xpath = "//input[@id='PeoplePicker-textBox']")
	WebElement accountName;

	@FindBy(xpath = "//div[@class='od-ChoiceEditor']")
	WebElement BidStatus;

	@FindBy(xpath = "//a[@title='Active']")
	WebElement active;
	
	@FindBy(xpath= "//button[@data-automationid='clientFormSaveButton']")
	WebElement saveManagerBtn;
	
	
	public BidManagerCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isNewBtnEnabled() { return (BidCreateNewBtn.isEnabled()); }

	public boolean isNewBtnDispalyed() { return (BidCreateNewBtn.isDisplayed()); }

	public boolean isNameTextBoxEnabled() {
		return (BidManagerName.isEnabled());
	}

	public boolean isNameTextBoxDisplayed() {
		return (BidManagerName.isDisplayed());
	}

	public boolean isBidAccountNameEnabled() {
		return (accountName.isEnabled());
	}

	public boolean isBidAccountNameDisplayed() {
		return (accountName.isDisplayed());
	}

	public boolean isBidManagerSavebtnEnabled() {
		return (saveManagerBtn.isEnabled());
	}

	public boolean isBidStatusDropDownEnabled() {
		return (BidStatus.isEnabled());
	}


	public void clickNewBidManagerButton() {
		try {

			Wait wait = new Wait();
			wait.waitUntilPresent(BidCreateNewBtn);
			BidCreateNewBtn.click();
			WaitForSpecificTime();
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occured while clicking Ok button...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking Ok button...");
		}

	}

	public void verifyBidManagerField() {
		try {
			Wait wait = new Wait();
			wait.waitUntilPresent(BidManagerName);
			WaitForSpecificTime();
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occured while clicking Ok button...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking Ok button...");
		}

	}
	public void clickSaveManagerButton() {
		try {
			saveManagerBtn.click();
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occured while clicking Ok button...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking Ok button...");
		}

	}
	public void setBidName(String BidName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(BidManagerName));
		this.BidManagerName.sendKeys(BidName);
	}
	public void setAccountName(String Name) throws InterruptedException {
		this.accountName.sendKeys(Name);
		WaitForSpecificTime();
		this.accountName.sendKeys(Keys.ENTER);
	}
	public void clickStatusButton() {
		try {
			BidStatus.click();
			WaitForSpecificTime();
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occured while clicking Ok button...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking Ok button...");
		}

	}

	public void clickActiveOption() {
		try {
			active.click();
			WaitForSpecificTime();
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occured while clicking Ok button...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking Ok button...");
		}

	}

	public void WaitForSpecificTime() throws InterruptedException {
		Thread.sleep(2000);
	}








}




