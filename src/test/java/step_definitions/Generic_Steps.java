package step_definitions;

import base.TestBase;
import com.aventstack.extentreports.Status;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Fi;
import helpers.Dropdown;
import helpers.PopupWindow;
import helpers.WritePropertiesFile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageobjects.BidManagerCreationPage;
import pageobjects.CreateNewBidPage;
import pageobjects.HomePage;


import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class Generic_Steps extends BaseClass {
	CreateNewBidPage bidPage = new CreateNewBidPage();
	HomePage homepage = new HomePage();


	CreateNewBidPage createnewbidpage;
	public String SubmissonDate;

	SoftAssert sa;

	@And("I Create new bids with values (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*)")
	public void create_new_bids(String BidTitle, String ClientName, String BidEventType,
			String BidManager, String SalesLead, String SensitivityLevel, String Notes, String SecurityClearanceRequirements,
			String SubmissionInstructions) throws InterruptedException {
	//	System.out.println("Name = " + Name);
		System.out.println("BidTitle = " + BidTitle);
		System.out.println("ClientName = " + ClientName);
		System.out.println("BidEventType = " + BidEventType);
		System.out.println("BidManager = " + BidManager);
		System.out.println("SalesLead = " + SalesLead);
		System.out.println("Sensitivitylevel = " + SensitivityLevel);
		System.out.println("Notes = " + Notes);
		System.out.println("Securityclearancerequirements = " + SecurityClearanceRequirements);
		System.out.println("SubmissionInstructions = " + SubmissionInstructions);

		createnewbidpage = new CreateNewBidPage();
		createnewbidpage.switchToCreateNewBidFrame();

		createnewbidpage.setBidTitleTest(BidTitle);
		test.log(Status.INFO, "Expected BidTitle = " + BidTitle);

		Integer CRMID = createnewbidpage.setNameandCRMIDDynamic();
		test.log(Status.INFO, "Expected Name and CRMID = " + CRMID);
		
		createnewbidpage.setClientNameTest(ClientName);
		test.log(Status.INFO, "Expected ClientName = " + ClientName);
		
		createnewbidpage.setBidEventType(BidEventType);
		test.log(Status.INFO, "Expected BidEventType = " + BidEventType);
		
		createnewbidpage.setBidManager(BidManager);
		test.log(Status.INFO, "Expected BidManager = " + BidManager);
		
		createnewbidpage.setSalesLead(SalesLead);
		test.log(Status.INFO, "Expected SalesLead = " + SalesLead);
		
		 SubmissonDate = createnewbidpage.setSubmissonDate();
		test.log(Status.INFO, "Expected Submisson Date = " + SubmissonDate);
		
		createnewbidpage.setSensitivityLevel(SensitivityLevel);
		test.log(Status.INFO, "Expected SensitivityLevel = " + SensitivityLevel);
		
		createnewbidpage.setNotes(Notes);
		test.log(Status.INFO, "Expected Notes = " + Notes);
		
		createnewbidpage.setSecurityClearanceRequirements(SecurityClearanceRequirements);
		test.log(Status.INFO, "Expected SecurityClearanceRequirements = " + SecurityClearanceRequirements);
		
		createnewbidpage.setSubmissionInstructions(SubmissionInstructions);
		test.log(Status.INFO, "Expected SubmissionInstructions = " + SubmissionInstructions);

		createnewbidpage.clickSaveButton();
	}
	@Given("I have logged into sharepoint")
	public void i_have_logged_into_sharepoint() throws InterruptedException {
		//TestBase.initialization();
		navigateToSharePointProject();
		HomePage homepage = new HomePage();
		sa = new SoftAssert();
		test = rep.createTest("Testing...");
		String expectedtitle = "BidPortal - Bid Managers - All Items";
		String actualtitle = homepage.getPageTitle();
		System.out.println("actualtitle = " + actualtitle);
		sa.assertEquals(actualtitle, expectedtitle);
		test.log(Status.INFO, "Expected title = " + expectedtitle);
		test.log(Status.INFO, "Actual title = " + actualtitle);
		if (expectedtitle.equals(actualtitle)) {
			test.log(Status.PASS, "Expected and Actual title is a match");
		} else {
			test.log(Status.FAIL, "Expected and Actual title does NOT match");
		}
	}


	@And("I click on Create New bid button")
	public void i_click_on_button() throws InterruptedException {
		HomePage homepage = new HomePage();
		test.log(Status.INFO, "Browser used: " + "");
		homepage.clickCreateNewBidButton();
	}

	@Then("^Validate the required input Fields are visible and enabled in Create New Bid dialog$")
	public void validate_the_required_input_Fields_are_visible_and_enabled() {
		CreateNewBidPage createnewbidpage = new CreateNewBidPage();

		if (createnewbidpage.isNameTextBoxDisplayed()) {
			test.log(Status.PASS, "CRM ID TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "CRM ID TextBox is NOT Displayed");
		}
		if (createnewbidpage.isNameTextBoxEnabled()) {
			test.log(Status.PASS, "CRM ID TextBox is Enabled");
		} else {
			test.log(Status.FAIL, "CRM ID TextBox is NOT Enabled");
		}

		if (createnewbidpage.isBidTitleTextBoxDisplayed()) {
			test.log(Status.PASS, "Bid Title TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Title TextBox is NOT Displayed");
		}
		if (createnewbidpage.isBidTitleTextBoxEnabled()) {
			test.log(Status.PASS, "Bid Title TextBox is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Title TextBox is NOT Enabled");
		}

		if (createnewbidpage.isClientNameTextBoxDisplayed()) {
			test.log(Status.PASS, "Client Name TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "Client Name TextBox is NOT Displayed");
		}
		if (createnewbidpage.isClientNameTextBoxEnabled()) {
			test.log(Status.PASS, "Client Name TextBox is Enabled");
		} else {
			test.log(Status.FAIL, "Client Name TextBox is NOT Enabled");
		}

		if (createnewbidpage.isBidEventTypeDropDownBoxDisplayed()) {
			test.log(Status.PASS, "Bid Event Type is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Event Type is NOT Displayed");
		}
		if (createnewbidpage.isBidEventTypeDropDownBoxEnabled()) {
			test.log(Status.PASS, "Bid Event Type is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Event Type is NOT Enabled");
		}
		
		if (createnewbidpage.isBidManagerDropDownDisplayed()) {
			test.log(Status.PASS, "Bid Manager DropDown is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Manager DropDown is NOT Displayed");
		}
		if (createnewbidpage.isBidManagerDropDownEnabled()) {
			test.log(Status.PASS, "Bid Manager DropDown is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Manager DropDown is NOT Enabled");
		}
		
		if (createnewbidpage.isSalesLeadDropDownDisplayed()) {
			test.log(Status.PASS, "Sales Lead DropDown is Displayed");
		} else {
			test.log(Status.FAIL, "Sales Lead DropDown is NOT Displayed");
		}
		if (createnewbidpage.isSalesLeadDropDownEnabled()) {
			test.log(Status.PASS, "Sales Lead DropDown is Enabled");
		} else {
			test.log(Status.FAIL, "Sales Lead DropDown is NOT Enabled");
		}

		if (createnewbidpage.isSubmissionDateFieldDisplayed()) {
			test.log(Status.PASS, "Submission Date Field is Displayed");
		} else {
			test.log(Status.FAIL, "Submission Date Field is NOT Displayed");
		}
		if (createnewbidpage.isSubmissionDateFieldEnabled()) {
			test.log(Status.PASS, "Submission Date Field is Enabled");
		} else {
			test.log(Status.FAIL, "Submission Date Field is NOT Enabled");
		}

		if (createnewbidpage.isSensitivityLevelDropDownDisplayed()) {
			test.log(Status.PASS, "Sensitivity Level DropDown is Displayed");
		} else {
			test.log(Status.FAIL, "Sensitivity Level DropDown is NOT Displayed");
		}
		if (createnewbidpage.isSensitivityLevelDropDownEnabled()) {
			test.log(Status.PASS, "Sensitivity Level DropDown is Enabled");
		} else {
			test.log(Status.FAIL, "Sensitivity Level DropDown is NOT Enabled");
		}

		if (createnewbidpage.isNotesTextDisplayed()) {
			test.log(Status.PASS, "Notes Text is Displayed");
		} else {
			test.log(Status.FAIL, "Notes Text is NOT Displayed");
		}
		if (createnewbidpage.isNotesTextEnabled()) {
			test.log(Status.PASS, "Notes Text is Enabled");
		} else {
			test.log(Status.FAIL, "Notes Text is NOT Enabled");
		}

		if (createnewbidpage.isSecurityClearanceRequirementsTextDisplayed()) {
			test.log(Status.PASS, "Security Clearance Requirements Text is Displayed");
		} else {
			test.log(Status.FAIL, "Security Clearance Requirements Text is NOT Displayed");
		}
		if (createnewbidpage.isSecurityClearanceRequirementsTextEnabled()) {
			test.log(Status.PASS, "Security Clearance Requirements Text is Enabled");
		} else {
			test.log(Status.FAIL, "Security Clearance Requirements Text is NOT Enabled");
		}

		if (createnewbidpage.isSubmissionInstructionsTextDisplayed()) {
			test.log(Status.PASS, "Submission Instructions Text is Displayed");
		} else {
			test.log(Status.FAIL, "Submission Instructions Text is NOT Displayed");
		}
		if (createnewbidpage.isSubmissionInstructionsTextEnabled()) {
			test.log(Status.PASS, "Submission Instructions Text is Enabled");
		} else {
			test.log(Status.FAIL, "Submission Instructions Text is NOT Enabled");
		}

		if (createnewbidpage.isSaveButtonDisplayed()) {
			test.log(Status.PASS, "Save Button is Displayed");
		} else {
			test.log(Status.FAIL, "Save Button is NOT Displayed");
		}
		if (createnewbidpage.isSaveButtonEnabled()) {
			test.log(Status.PASS, "Save Button is Enabled");
		} else {
			test.log(Status.FAIL, "Save Button is NOT Enabled");
		}

		if (createnewbidpage.isCancelButtonDisplayed()) {
			test.log(Status.PASS, "Cancel Button is Displayed");
		} else {
			test.log(Status.FAIL, "Cancel Button is NOT Displayed");
		}
		if (createnewbidpage.isCancelButtonEnabled()) {
			test.log(Status.PASS, "Cancel Button is Enabled");
		} else {
			test.log(Status.FAIL, "Cancel Button is NOT Enabled");
		}

		sa.assertTrue(createnewbidpage.isNameTextBoxDisplayed());
		sa.assertTrue(createnewbidpage.isNameTextBoxEnabled());

		sa.assertTrue(createnewbidpage.isBidTitleTextBoxDisplayed());
		sa.assertTrue(createnewbidpage.isBidTitleTextBoxEnabled());

		sa.assertTrue(createnewbidpage.isClientNameTextBoxDisplayed());
		sa.assertTrue(createnewbidpage.isClientNameTextBoxEnabled());

		sa.assertTrue(createnewbidpage.isBidEventTypeDropDownBoxDisplayed());
		sa.assertTrue(createnewbidpage.isBidEventTypeDropDownBoxEnabled());

		sa.assertTrue(createnewbidpage.isBidManagerDropDownDisplayed());
		sa.assertTrue(createnewbidpage.isBidManagerDropDownEnabled());
		
		sa.assertTrue(createnewbidpage.isSalesLeadDropDownDisplayed());
		sa.assertTrue(createnewbidpage.isSalesLeadDropDownEnabled());
		
		sa.assertTrue(createnewbidpage.isSubmissionDateFieldDisplayed());
		sa.assertTrue(createnewbidpage.isSubmissionDateFieldEnabled());

		sa.assertTrue(createnewbidpage.isSensitivityLevelDropDownDisplayed());
		sa.assertTrue(createnewbidpage.isSensitivityLevelDropDownEnabled());

		sa.assertTrue(createnewbidpage.isNotesTextDisplayed());
		sa.assertTrue(createnewbidpage.isNotesTextEnabled());

		sa.assertTrue(createnewbidpage.isSecurityClearanceRequirementsTextDisplayed());
		sa.assertTrue(createnewbidpage.isSecurityClearanceRequirementsTextEnabled());

		sa.assertTrue(createnewbidpage.isSubmissionInstructionsTextDisplayed());
		sa.assertTrue(createnewbidpage.isSubmissionInstructionsTextEnabled());

		sa.assertTrue(createnewbidpage.isCRMIDTextDisplayed());
		sa.assertTrue(createnewbidpage.isCRMIDTextEnabled());
		
		sa.assertTrue(createnewbidpage.isSaveButtonDisplayed());
		sa.assertTrue(createnewbidpage.isSaveButtonEnabled());

		sa.assertTrue(createnewbidpage.isCancelButtonDisplayed());
		sa.assertTrue(createnewbidpage.isCancelButtonEnabled());

	}

	@Given("I click on Create New bid Manager button")
	public void CreateBidManager(){
		try {
			BidManagerCreationPage bidManager = new BidManagerCreationPage();
			test.log(Status.INFO, "Browser used: " + "");
			bidManager.clickNewBidManagerButton();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Then("^Validate the required input Fields are visible and enabled in Create New Bid Manager Page$")
	public void validateAndCreateBidManager() {
		CreateNewBidPage createnewbidpage = new CreateNewBidPage();

		if (createnewbidpage.isNameTextBoxDisplayed()) {
			test.log(Status.PASS, "CRM ID TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "CRM ID TextBox is NOT Displayed");
		}
		if (createnewbidpage.isNameTextBoxEnabled()) {
			test.log(Status.PASS, "CRM ID TextBox is Enabled");
		} else {
			test.log(Status.FAIL, "CRM ID TextBox is NOT Enabled");
		}

		if (createnewbidpage.isBidTitleTextBoxDisplayed()) {
			test.log(Status.PASS, "Bid Title TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Title TextBox is NOT Displayed");
		}
		if (createnewbidpage.isBidTitleTextBoxEnabled()) {
			test.log(Status.PASS, "Bid Title TextBox is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Title TextBox is NOT Enabled");
		}

		if (createnewbidpage.isClientNameTextBoxDisplayed()) {
			test.log(Status.PASS, "Client Name TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "Client Name TextBox is NOT Displayed");
		}
		if (createnewbidpage.isClientNameTextBoxEnabled()) {
			test.log(Status.PASS, "Client Name TextBox is Enabled");
		} else {
			test.log(Status.FAIL, "Client Name TextBox is NOT Enabled");
		}

		if (createnewbidpage.isBidEventTypeDropDownBoxDisplayed()) {
			test.log(Status.PASS, "Bid Event Type is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Event Type is NOT Displayed");
		}
		if (createnewbidpage.isBidEventTypeDropDownBoxEnabled()) {
			test.log(Status.PASS, "Bid Event Type is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Event Type is NOT Enabled");
		}

		if (createnewbidpage.isBidManagerDropDownDisplayed()) {
			test.log(Status.PASS, "Bid Manager DropDown is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Manager DropDown is NOT Displayed");
		}
		if (createnewbidpage.isBidManagerDropDownEnabled()) {
			test.log(Status.PASS, "Bid Manager DropDown is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Manager DropDown is NOT Enabled");
		}

		if (createnewbidpage.isSalesLeadDropDownDisplayed()) {
			test.log(Status.PASS, "Sales Lead DropDown is Displayed");
		} else {
			test.log(Status.FAIL, "Sales Lead DropDown is NOT Displayed");
		}
		if (createnewbidpage.isSalesLeadDropDownEnabled()) {
			test.log(Status.PASS, "Sales Lead DropDown is Enabled");
		} else {
			test.log(Status.FAIL, "Sales Lead DropDown is NOT Enabled");
		}

		if (createnewbidpage.isSubmissionDateFieldDisplayed()) {
			test.log(Status.PASS, "Submission Date Field is Displayed");
		} else {
			test.log(Status.FAIL, "Submission Date Field is NOT Displayed");
		}
		if (createnewbidpage.isSubmissionDateFieldEnabled()) {
			test.log(Status.PASS, "Submission Date Field is Enabled");
		} else {
			test.log(Status.FAIL, "Submission Date Field is NOT Enabled");
		}

		if (createnewbidpage.isSensitivityLevelDropDownDisplayed()) {
			test.log(Status.PASS, "Sensitivity Level DropDown is Displayed");
		} else {
			test.log(Status.FAIL, "Sensitivity Level DropDown is NOT Displayed");
		}
		if (createnewbidpage.isSensitivityLevelDropDownEnabled()) {
			test.log(Status.PASS, "Sensitivity Level DropDown is Enabled");
		} else {
			test.log(Status.FAIL, "Sensitivity Level DropDown is NOT Enabled");
		}

		if (createnewbidpage.isNotesTextDisplayed()) {
			test.log(Status.PASS, "Notes Text is Displayed");
		} else {
			test.log(Status.FAIL, "Notes Text is NOT Displayed");
		}
		if (createnewbidpage.isNotesTextEnabled()) {
			test.log(Status.PASS, "Notes Text is Enabled");
		} else {
			test.log(Status.FAIL, "Notes Text is NOT Enabled");
		}

		if (createnewbidpage.isSecurityClearanceRequirementsTextDisplayed()) {
			test.log(Status.PASS, "Security Clearance Requirements Text is Displayed");
		} else {
			test.log(Status.FAIL, "Security Clearance Requirements Text is NOT Displayed");
		}
		if (createnewbidpage.isSecurityClearanceRequirementsTextEnabled()) {
			test.log(Status.PASS, "Security Clearance Requirements Text is Enabled");
		} else {
			test.log(Status.FAIL, "Security Clearance Requirements Text is NOT Enabled");
		}

		if (createnewbidpage.isSubmissionInstructionsTextDisplayed()) {
			test.log(Status.PASS, "Submission Instructions Text is Displayed");
		} else {
			test.log(Status.FAIL, "Submission Instructions Text is NOT Displayed");
		}
		if (createnewbidpage.isSubmissionInstructionsTextEnabled()) {
			test.log(Status.PASS, "Submission Instructions Text is Enabled");
		} else {
			test.log(Status.FAIL, "Submission Instructions Text is NOT Enabled");
		}

		if (createnewbidpage.isSaveButtonDisplayed()) {
			test.log(Status.PASS, "Save Button is Displayed");
		} else {
			test.log(Status.FAIL, "Save Button is NOT Displayed");
		}
		if (createnewbidpage.isSaveButtonEnabled()) {
			test.log(Status.PASS, "Save Button is Enabled");
		} else {
			test.log(Status.FAIL, "Save Button is NOT Enabled");
		}

		if (createnewbidpage.isCancelButtonDisplayed()) {
			test.log(Status.PASS, "Cancel Button is Displayed");
		} else {
			test.log(Status.FAIL, "Cancel Button is NOT Displayed");
		}
		if (createnewbidpage.isCancelButtonEnabled()) {
			test.log(Status.PASS, "Cancel Button is Enabled");
		} else {
			test.log(Status.FAIL, "Cancel Button is NOT Enabled");
		}

		sa.assertTrue(createnewbidpage.isNameTextBoxDisplayed());
		sa.assertTrue(createnewbidpage.isNameTextBoxEnabled());

		sa.assertTrue(createnewbidpage.isBidTitleTextBoxDisplayed());
		sa.assertTrue(createnewbidpage.isBidTitleTextBoxEnabled());

		sa.assertTrue(createnewbidpage.isClientNameTextBoxDisplayed());
		sa.assertTrue(createnewbidpage.isClientNameTextBoxEnabled());

		sa.assertTrue(createnewbidpage.isBidEventTypeDropDownBoxDisplayed());
		sa.assertTrue(createnewbidpage.isBidEventTypeDropDownBoxEnabled());

		sa.assertTrue(createnewbidpage.isBidManagerDropDownDisplayed());
		sa.assertTrue(createnewbidpage.isBidManagerDropDownEnabled());

		sa.assertTrue(createnewbidpage.isSalesLeadDropDownDisplayed());
		sa.assertTrue(createnewbidpage.isSalesLeadDropDownEnabled());

		sa.assertTrue(createnewbidpage.isSubmissionDateFieldDisplayed());
		sa.assertTrue(createnewbidpage.isSubmissionDateFieldEnabled());

		sa.assertTrue(createnewbidpage.isSensitivityLevelDropDownDisplayed());
		sa.assertTrue(createnewbidpage.isSensitivityLevelDropDownEnabled());

		sa.assertTrue(createnewbidpage.isNotesTextDisplayed());
		sa.assertTrue(createnewbidpage.isNotesTextEnabled());

		sa.assertTrue(createnewbidpage.isSecurityClearanceRequirementsTextDisplayed());
		sa.assertTrue(createnewbidpage.isSecurityClearanceRequirementsTextEnabled());

		sa.assertTrue(createnewbidpage.isSubmissionInstructionsTextDisplayed());
		sa.assertTrue(createnewbidpage.isSubmissionInstructionsTextEnabled());

		sa.assertTrue(createnewbidpage.isCRMIDTextDisplayed());
		sa.assertTrue(createnewbidpage.isCRMIDTextEnabled());

		sa.assertTrue(createnewbidpage.isSaveButtonDisplayed());
		sa.assertTrue(createnewbidpage.isSaveButtonEnabled());

		sa.assertTrue(createnewbidpage.isCancelButtonDisplayed());
		sa.assertTrue(createnewbidpage.isCancelButtonEnabled());


	}

	@And("Validate the required input Fields are visible and enabled in Create New Bid Manager page")
	public void validateAndCreateBidManagers() {

		BidManagerCreationPage bidManager = new BidManagerCreationPage();
		bidManager.verifyBidManagerField();
		if (bidManager.isNewBtnEnabled()) {
			test.log(Status.PASS, "New Bid creation button Displayed");
		} else {
			test.log(Status.FAIL, "New Bid creation button Not Displayed");
		}
		if (bidManager.isNameTextBoxEnabled()) {
			test.log(Status.PASS, "Bid Manager TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Manager TextBox is not Displayed");
		}
		if (bidManager.isBidAccountNameDisplayed()) {
			test.log(Status.PASS, "Bid Account Name TextBox is Displayed");
		} else {
			test.log(Status.FAIL, "Bid Account Name TextBox is not Displayed");
		}
		if (bidManager.isBidManagerSavebtnEnabled()) {
			test.log(Status.PASS, "Bid Manager Save Button is Enabled");
		} else {
			test.log(Status.FAIL, "Bid Manager Save Button is not Enabled");
		}
		if (bidManager.isBidStatusDropDownEnabled()) {
			test.log(Status.PASS, "Bid Status drop down is Displayed");
		} else {
			test.log(Status.FAIL, "Bid status drop down is NOT Displayed");
		}
		sa.assertTrue(bidManager.isNewBtnEnabled());
		sa.assertTrue(bidManager.isNewBtnDispalyed());
		sa.assertTrue(bidManager.isNameTextBoxEnabled());
		sa.assertTrue(bidManager.isNameTextBoxDisplayed());
		sa.assertTrue(bidManager.isBidAccountNameDisplayed());
		sa.assertTrue(bidManager.isBidManagerSavebtnEnabled());
		sa.assertTrue(bidManager.isBidManagerSavebtnEnabled());
		sa.assertTrue(bidManager.isBidStatusDropDownEnabled());
		rep.flush();
		sa.assertAll();
	}

	@And("Create new bid Manager with values (.*) and (.*)")
	public void createNewBidManagerWithValuesBidNameAndAccountName(String BidName,String accountName) throws InterruptedException {
		BidManagerCreationPage bidManager = new BidManagerCreationPage();
		bidManager.setBidName(BidName);
		test.log(Status.INFO, "Expected BidName = " + BidName);
		bidManager.setAccountName(accountName);
		test.log(Status.INFO, "Expected AccountName = " + accountName);
		bidManager.clickStatusButton();
		bidManager.clickActiveOption();
		test.log(Status.INFO, "Expected Status = " + "ACTIVE");
		bidManager.clickSaveManagerButton();
	}


	@And("Verify the bid Manager successfully created")
	public void verifyTheBidManasgerSuccessfullyCreated() {

    System.out.println("Inprogress");

	}

	@And("^I click on Bid List Menu Item$")
	public void iClickOnBidListMenuItem() throws InterruptedException {
		HomePage homepage = new HomePage();
		test.log(Status.INFO, "Browser used: " + "");
		homepage.clickBidListMenu();
	}


	@Then("^I Verify the bid Creation successfully created with values of (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*)")
	public void verifyBidCreationExpectedData(String BidTitle, String ClientName, String BidEventType,
											  String BidManager, String SalesLead, String SensitivityLevel, String Notes, String SecurityClearanceRequirements,
											  String SubmissionInstructions) throws InterruptedException, IOException {
		Thread.sleep(20000);
		createnewbidpage.switchToDefaultWindow();

		ArrayList<String> FinalBidValues = createnewbidpage.getFinalBidValues();
		String ActualClientName = FinalBidValues.get(0);
		String ActualBidEventType= FinalBidValues.get(1);
		String ActualSubmissonDate = FinalBidValues.get(2);
		String ActualSensitivityLevel = FinalBidValues.get(3);
		String ActualNotes = FinalBidValues.get(4);
		String ActualSecurityClearanceRequirements = FinalBidValues.get(5);
		String ActualSubmissionInstructions = FinalBidValues.get(6);
		String id = createnewbidpage.bidIDNumber();
		WritePropertiesFile writePropertiesFile = new WritePropertiesFile();
		writePropertiesFile.WritePropertiesFile("BidId",id,System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties");


		/*Properties properties = new Properties();
		try(OutputStream outputStream = new FileOutputStream()){
			properties.setProperty("BidId", id);
			properties.store(outputStream, null);
			outputStream.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {


		}*/
		if (ActualClientName.equals(ClientName)) {
			test.log(Status.INFO, "Actual ClientName = " + ActualClientName);
			test.log(Status.PASS, "Expected and Actual Client Name matches");
		}else {
			test.log(Status.INFO, "Actual ClientName = " + ActualClientName);
			test.log(Status.FAIL, "Expected and Actual Client Name does not match");
		}
		if (ActualBidEventType.equals(BidEventType)) {
			test.log(Status.INFO, "Actual ActualBidEventType = " + ActualBidEventType);
			test.log(Status.PASS, "Expected and Actual BidEventType matches");
		}else {
			test.log(Status.INFO, "Actual ActualBidEventType = " + ActualBidEventType);
			test.log(Status.FAIL, "Expected and Actual BidEventType does not match");
		}
		if (ActualSubmissonDate.equals(SubmissonDate)) {
			test.log(Status.INFO, "Actual SubmissonDate = " + ActualSubmissonDate);
			test.log(Status.PASS, "Expected and Actual SubmissonDate matches");
		}else {
			test.log(Status.INFO, "Actual SubmissonDate = " + ActualSubmissonDate);
			test.log(Status.FAIL, "Expected and Actual SubmissonDate does not match");
		}
		if (ActualSensitivityLevel.equals(SensitivityLevel)) {
			test.log(Status.INFO, "Actual SensitivityLevel = " + ActualSensitivityLevel);
			test.log(Status.PASS, "Expected and Actual SensitivityLevel matches");
		}else {
			test.log(Status.INFO, "Actual SensitivityLevel = " + ActualSensitivityLevel);
			test.log(Status.FAIL, "Expected and Actual SensitivityLevel does not match");
		}
		if (ActualNotes.equals(Notes)) {
			test.log(Status.INFO, "Actual Notes = " + ActualNotes);
			test.log(Status.PASS, "Expected and Actual Notes matches");
		}else {
			test.log(Status.INFO, "Actual Notes = " + ActualNotes);
			test.log(Status.FAIL, "Expected and Actual Notes does not match");
		}
		if (ActualSecurityClearanceRequirements.equals(SecurityClearanceRequirements)) {
			test.log(Status.INFO, "Actual SecurityClearanceRequirements = " + ActualSecurityClearanceRequirements);
			test.log(Status.PASS, "Expected and Actual SecurityClearanceRequirements matches");
		}else {
			test.log(Status.INFO, "Actual SecurityClearanceRequirements = " + ActualSecurityClearanceRequirements);
			test.log(Status.FAIL, "Expected and Actual SecurityClearanceRequirements does not match");
		}
		if (ActualSubmissionInstructions.equals(SubmissionInstructions)) {
			test.log(Status.INFO, "Actual SubmissionInstructions = " + ActualSubmissionInstructions);
			test.log(Status.PASS, "Expected and Actual SubmissionInstructions matches");
		}else {
			test.log(Status.INFO, "Actual SubmissionInstructions = " + ActualSubmissionInstructions);
			test.log(Status.FAIL, "Expected and Actual SubmissionInstructions does not match");
		}

	}

	@And("^I Navigate to Upload the buttons$")
	public void iNavigateToUploadTheButtons() throws InterruptedException {
		bidPage.uploadBtnVeriy();
		bidPage.uploadFrameSwitch();
		bidPage.uploadFile();
		bidPage.versionCommits();
		bidPage.okUploadBnt();
	}

	@And("^I Navigate to Zip functionality$")
	public void iNavigateToZipFunctionality() throws InterruptedException {
		driver.switchTo().defaultContent();
		bidPage.zipBtnVerify();
		bidPage.alertPersentOrNot();
	}

	@And("^I Navigate to Final Submission$")
	public void iNavigateToFinalSubmission() throws InterruptedException {
		//bidPage.finalSubmissionVerify();
		//bidPage.alertPersentOrNot();
		bidPage.finalSubmissionFrame();
		bidPage.finalSubmissionOk();
	}


	@And("^I Navigate to exist Bid Created records$")
	public void iNavigateToExistBidCreatedRecords() throws InterruptedException {
		bidPage.checkExistBidCreation();
	}

	@And("^I Navigate and switch the window to Bid List Record$")
	public void iNavigateAndSwitchTheWindowToBidListRecord() throws InterruptedException {
		bidPage.switchWindow();
	}

	@And("^I click on the attachment for zip download purpose$")
	public void iClickOnTheAttachmentForZipDownloadPurpose() throws InterruptedException {
		bidPage.selectItemInBidList();
		bidPage.zipBtnVerify();
	}

	@And("^I select the attachment for making final Submission$")
	public void iSelectTheAttachmentForMakingFinalSubmission() throws InterruptedException {
		Thread.sleep(2000);
		//bidPage.selectItemInBidList();
		bidPage.finalSubmissionVerify();
	}

	@And("^I Navigate to View all properties link$")
	public void iNavigateToViewAllPropertiesLink() throws InterruptedException {
		bidPage.viewAllPropertiesLink();
		Thread.sleep(20000);
		bidPage.CloseBtn();
	}

	@And("^I Navigate to Edit properties link (.*)$")
	public void iNavigateToEditPropertiesLink(String name) throws InterruptedException {
		bidPage.EditPropertiesLink();
		Thread.sleep(10000);
		bidPage.UpdateTheBidTitle(name);
		bidPage.SaveBtn();
		Thread.sleep(10000);
	}

	@And("^I click on the attachment and Copy Documents in another CRMID$")
	public void iClickOnTheAttachmentAndCopyDocumentsInAnotherCRMID() throws InterruptedException {
		bidPage.selectItemInBidList();
		bidPage.copyDocument();
		bidPage.uploadFrameSwitch();

	}

	@And("^I select the dropDown as destination CRMID$")
	public void iSelectTheDropDownAsDestinationCRMIDIs() throws Throwable {
		bidPage.SelectCrmId();
	}

	@And("^I click on Copy and verify into respective CRMID$")
	public void iClickOnCopyAndVerifyIntoRespectiveCRMID() throws InterruptedException {
	     bidPage.CopyDocumentBtn();
	     bidPage.alertPersentOrNot();
		 //bidPage.alertPersentOrNot();
		 bidPage.waitTillMsgDisply();
	     bidPage.destinationLink();
	}

	@And("^I click on Zip button without selecting the attachment$")
	public void iClickOnZipButtonWithoutSelectingTheAttachment() throws InterruptedException {
		bidPage.zipBtnVerify();
		bidPage.alertPersentOrNot();

	}

	@And("^I click on final Submission button without selecting the attachment$")
	public void iClickOnFinalSubmissionButtonWithoutSelectingTheAttachment() throws InterruptedException {
		bidPage.finalSubmissionVerify();
		bidPage.alertPersentOrNot();
	}

	@And("^I click on Copy Document button without selecting the attachment$")
	public void iClickOnCopyDocumentButtonWithoutSelectingTheAttachment() throws InterruptedException {
		bidPage.CopyDocumentBtn();
		bidPage.alertPersentOrNot();
	}

	@Given("^I click on Bid Manager as \"([^\"]*)\"$")
	public void iClickOnBidManagerAs(String titleName) throws InterruptedException {
		bidPage.clickOnBIdMangerSelection(titleName);
	}

	@And("^I click on Edit bar menu for editing the Bid Manager title Name$")
	public void iClickOnEditBarMenuForEditingTheBidManagerTitleName()throws InterruptedException {
		bidPage.editMenuBar();
	}


	@And("^Verify the bid Manager successfully updated with titleName as (.*)$")
	public void verifyTheBidManagerSuccessfullyUpdatedWithTitleNameAsBidName(String bidName) throws InterruptedException {
		bidPage.verifyEditTitleName(bidName);
	}

	@And("^I click on Delete button for deleting the Bid Manager record$")
	public void iClickOnDeleteButtonForDeletingTheBidManagerRecord() throws InterruptedException {
		bidPage.deleteBidManager();
	}

	@And("^I click on delete confirmation button for deleting$")
	public void iClickOnDeleteConfirmationButtonForDeleting() throws InterruptedException {
		bidPage.deleteConfirmBtn();

	}
	@Then("^Verify the respective record got deleted$")
	public void verifyTheRespectiveRecordGotDeleted() throws InterruptedException {
		bidPage.confirmDeletMessage();
	}

	@And("^Verify Respective document status should get change$")
	public void verifyRespectiveDocumentStatusShouldGetChange() throws  InterruptedException {
		bidPage.VerifyDocumentStatus();
	}

	@And("^I click on Bid Created$")
	public void iClickOnBidCreatedAs() throws InterruptedException, IOException {
		bidPage.SelectAutoGeneratedBidID();
		// Write code here that turns the phrase above into concrete actions
	}

	@And("^I click on Restricted Bid Created$")
	public void iClickOnRestrictedBidCreatedAs() throws InterruptedException, IOException {
		bidPage.SelectRestrictedAutoGeneratedBidID();
		// Write code here that turns the phrase above into concrete actions
	}

	@And("^I Navigate to verify document and selection drop value as (.*) and (.*) and (.*) and (.*)")
	public void setReverifyDocAttachVal(String docName,String DocType,String docGrp,String subGrp) throws Exception {
	    bidPage.setDocumentVal(docName,docName);
		bidPage.setBidTypVerify(DocType);
		bidPage.setdocumentGroupVerify(docGrp);
		bidPage.setSubtGroupVerify(subGrp);
		bidPage.checkIn();
		bidPage.bidListViewDocSelect(docName);
	}

	@And("^Select the respective doc for ZipDownload and doc name is as (.*)")
	public void selectTheRespectiveDocForZipDownloadAndDocNameIsAsDocName(String docName) throws Exception {
		bidPage.bidListViewDocSelect(docName);
	}

	@And("^Select the respective doc not present after get deleted (.*)")
	public void selectTheRespectiveDocNotPresnt(String docName) {
		bidPage.bidListViewDocNotPresent(docName);
	}


	@Then("^I click on the zip button for and verify zip gets downloaded$")
	public void iClickOnTheZipButtonForAndVerifyZipGetsDownloaded() throws Exception {
		bidPage.zipBtnVerify();
		Thread.sleep(10000);
		bidPage.verifyZipGetsDownloaded();

	}

	@And("^I Navigate to click on earlier created Bid record$")
	public void iNavigateToClickOnEarlierCreatedBidRecord() throws IOException, InterruptedException {
		bidPage.clickOnBidRecord();
	}

	@Then("^I click on More menu and check the verify checkout popupWindow$")
	public void iClickOnPropertiesMenuAndCheckTheVerifyCheckoutPopupWindow() throws Exception {
		if(bidPage.isCheckOutVerify()) {
			test.log(Status.PASS, "More Header section button is getting enabled");
		}else{
			test.log(Status.FAIL, "More Header section button does not getting enabled");
		}
	
	}

	
	@And("^I click on advance option$")
	public void iClickOnPropertiesOption() throws Exception {
		bidPage.isAdvanceMenu();
	}

	@And("^I click on Delete option$")
	public void iClickOnDeleteOption() throws Exception {
		bidPage.isDeleteOption();
	}

	@Then("^Verify the check out popup window display or not$")
	public void veriyTheCheckOutPopupWindowDisplayOrNot() throws Exception {
		bidPage.uploadFrameSwitch();
		Assert.assertTrue(bidPage.isCheckInPopupIsExist(),"Check in Popup window displayed");
	}

	@Then("^Verify the alert popup window display or not$")
	public void veriyDeleteVerificationPopupExist() throws Exception {
		//dPage.uploadFrameSwitch();
		Assert.assertTrue(bidPage.isCheckOutExistOrNot(),"Alert is exist");
	}

	@And("^I click on CheckInAndOut option from Advance Menu$")
	public void iClickOnCheckInOptionFromAdvanceMenu() throws Exception {
		bidPage.isCheckInAndCheckOut();
	}

	@And("^I click on Search box and enter the search value$")
	public void iClickOnSearchBoxAndEnterTheSearchValue() throws Exception {
		bidPage.isSearchContentChecked();
		
	}
	@And("^I click on Search box and enter the Key as search value$")
	public void iClickOnSearchBoxAndEnterTheKey() throws Exception {
		bidPage.isSearchContentKey();

	}

	@And("^Verify the entered value gets return or not$")
	public void verifyTheEnteredValueGetsReturnOrNot() throws Exception {
		Assert.assertTrue(bidPage.BidReturnSearchContent(),"Search result returned with attachment");
	}

	@And("^I Navigate to click on Bid record who is having exist attachments$")
	public void iNavigateToClickOnBidRecordWhoIsHavingExistAttachments() throws IOException, InterruptedException {
		bidPage.clickOnBidForSearchAttachMentContent();
	}

	@Given("^I Click on Search box and entered the key for Search$")
	public void iClickOnSearchBoxAndEnteredTheKeyForSearch() throws Exception {
		Assert.assertTrue(bidPage.BidReturnAsKeyContent(),"Search result returned with attachment");

	}

	@And("^verify the key gets return sucessfully or not$")
	public void verifyTheKeyGetsReturnSucessfullyOrNot() throws Exception {
		Assert.assertTrue(bidPage.BidReturnAsKeyContent(),"Search result returned with attachment");

	}

	@And("^I click on Search box and enter the data as Advance Key$")
	public void iClickOnSearchBoxAndEnterTheDataAsAdvanceKey() throws Exception {
		bidPage.isSearchBidRecordKeyContent();

	}

	@And("^I click on BiDRecord checkbox which we want to share$")
	public void iClickOnBiDRecordCheckboxWhichWeWantToShare() throws IOException, InterruptedException {
		bidPage.clickOnBidRecordForShare();
	}

	@And("^Verify Share button is displayed or not$")
	public void verifyShareButtonIsDispalyedOrNot() throws Exception {
		Assert.assertTrue(bidPage.isSharebtnDisplay(),"Share button is enabled");
	}

	@And("^I click on Search button$")
	public void iClickOnSearchButton() {
		//todo;
	}

	@And("^I have enter the sender name as (.*)$")
	public void iHaveEnterTheSenderName(String accountName) throws Exception {
		bidPage.isAddSenderName(accountName);

	}

	@And("^I have click on Send button$")
	public void iHaveClickOnSendButton() throws Exception {
		Assert.assertTrue(bidPage.isSendBtn(),"Send button");
	}

	@Then("^Verify the share notification icon display or not$")
	public void verifyTheShareNotificationIconDisplayOrNot() throws Exception {
		Assert.assertTrue(bidPage.isShareNotification(), "Share Notification");
	}

	@Given("^I have logged in full permission user model (.*)$")
	public void iHaveLoggedInFullPermissionUserModel(String AdminRights) throws Exception {
		String permission= "AdminRights";
		try {
			if(permission.equals(AdminRights.trim())){
				String Url = bidPage.fullPermission();
				driver.get(Url);
//				driver.get("https://tc3-v-devsp05:8888/Lists/Bid%20Managers/AllItems.aspx");
				Thread.sleep(15000);
				System.out.println("============="+ "if conditon");
			}else {
				String Url = bidPage.TestUser();
				driver.get(Url);
//				driver.get("https://tc3-v-devsp05:8888/Lists/Bid%20Managers/AllItems.aspx");
				System.out.println("============="+ "else conditon");
			}
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			//Thread.sleep(10000);
			HomePage homepage = new HomePage();
			sa = new SoftAssert();
			test = rep.createTest("Testing...");
			String expectedtitle = "BidPortal - Bid Managers - All Items";
			String actualtitle = homepage.getPageTitle();
			System.out.println("actualtitle = " + actualtitle);
			sa.assertEquals(actualtitle, expectedtitle);
			test.log(Status.INFO, "Expected title = " + expectedtitle);
			test.log(Status.INFO, "Actual title = " + actualtitle);
			if (expectedtitle.equals(actualtitle)) {
				test.log(Status.PASS, "Expected and Actual title is a match");
			} else {
				test.log(Status.FAIL, "Expected and Actual title does NOT match");
			}
		}

	}

	@Given("^I have logged in Test User permission user model$")
	public void iHaveLoggedInTestUserPermissionUserModel() throws Exception {
		String Url = bidPage.TestUser();
		driver.get(Url);
	}

	@And("^I verified Create Bid button does not exist$")
	public void iAmVerifiedCreateBidButtonDoesNotExist() throws Exception {
		Assert.assertTrue(homepage.isCreateBidButtonDisplay(),"Create bid Button should not be presnt for this user");
	}

	@And("^I verify delete button does not exist$")
	public void iVerifyDeleteButtonDoesNotExist() throws Exception {
		Assert.assertTrue(homepage.isDeleteButtonDisplay(),"Delete Button should not be presnt for this user");

	}

	@And("^Verify the entered value gets return or not on AdvanceView Page$")
	public void verifyTheEnteredValueGetsReturnOrNotOnAdvanceViewPage() throws Exception {
		Assert.assertTrue(bidPage.SearchContentBidDisplay(),"Search result returned with attachment");

	}

	@Then("^I Verify the restrictd bid Creation successfully created with values of (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*)")
	public void verifyRestrictedBidCreationExpectedData(String BidTitle, String ClientName, String BidEventType,
											  String BidManager, String SalesLead, String SensitivityLevel, String Notes, String SecurityClearanceRequirements,
											  String SubmissionInstructions) throws InterruptedException, IOException {


	}

	@And("^I Verify the restricted bid Creation successfully created with values of (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*)")
	public void restrictedBidCreation(String BidTitle, String ClientName, String BidEventType,
									  String BidManager, String SalesLead, String SensitivityLevel, String Notes, String SecurityClearanceRequirements,
									  String SubmissionInstructions) throws InterruptedException, IOException {

		Thread.sleep(20000);
		createnewbidpage.switchToDefaultWindow();
		ArrayList<String> FinalBidValues = createnewbidpage.getFinalBidValues();
		String ActualClientName = FinalBidValues.get(0);
		String ActualBidEventType= FinalBidValues.get(1);
		String ActualSubmissonDate = FinalBidValues.get(2);
		String ActualSensitivityLevel = FinalBidValues.get(3);
		String ActualNotes = FinalBidValues.get(4);
		String ActualSecurityClearanceRequirements = FinalBidValues.get(5);
		String ActualSubmissionInstructions = FinalBidValues.get(6);
		String id = createnewbidpage.bidIDNumber();
		WritePropertiesFile writePropertiesFile = new WritePropertiesFile();
		writePropertiesFile.WritePropertiesFile("RestrcitedBidId",id,System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties");

		/*Properties properties = new Properties();
		try(OutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties")){
			properties.setProperty("RestrcitedBidId", id);
			properties.store(outputStream, null);
			outputStream.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {


		}*/
		if (ActualClientName.equals(ClientName)) {
			test.log(Status.INFO, "Actual ClientName = " + ActualClientName);
			test.log(Status.PASS, "Expected and Actual Client Name matches");
		}else {
			test.log(Status.INFO, "Actual ClientName = " + ActualClientName);
			test.log(Status.FAIL, "Expected and Actual Client Name does not match");
		}
		if (ActualBidEventType.equals(BidEventType)) {
			test.log(Status.INFO, "Actual ActualBidEventType = " + ActualBidEventType);
			test.log(Status.PASS, "Expected and Actual BidEventType matches");
		}else {
			test.log(Status.INFO, "Actual ActualBidEventType = " + ActualBidEventType);
			test.log(Status.FAIL, "Expected and Actual BidEventType does not match");
		}
		if (ActualSubmissonDate.equals(SubmissonDate)) {
			test.log(Status.INFO, "Actual SubmissonDate = " + ActualSubmissonDate);
			test.log(Status.PASS, "Expected and Actual SubmissonDate matches");
		}else {
			test.log(Status.INFO, "Actual SubmissonDate = " + ActualSubmissonDate);
			test.log(Status.FAIL, "Expected and Actual SubmissonDate does not match");
		}
		if (ActualSensitivityLevel.equals(SensitivityLevel)) {
			test.log(Status.INFO, "Actual SensitivityLevel = " + ActualSensitivityLevel);
			test.log(Status.PASS, "Expected and Actual SensitivityLevel matches");
		}else {
			test.log(Status.INFO, "Actual SensitivityLevel = " + ActualSensitivityLevel);
			test.log(Status.FAIL, "Expected and Actual SensitivityLevel does not match");
		}
		if (ActualNotes.equals(Notes)) {
			test.log(Status.INFO, "Actual Notes = " + ActualNotes);
			test.log(Status.PASS, "Expected and Actual Notes matches");
		}else {
			test.log(Status.INFO, "Actual Notes = " + ActualNotes);
			test.log(Status.FAIL, "Expected and Actual Notes does not match");
		}
		if (ActualSecurityClearanceRequirements.equals(SecurityClearanceRequirements)) {
			test.log(Status.INFO, "Actual SecurityClearanceRequirements = " + ActualSecurityClearanceRequirements);
			test.log(Status.PASS, "Expected and Actual SecurityClearanceRequirements matches");
		}else {
			test.log(Status.INFO, "Actual SecurityClearanceRequirements = " + ActualSecurityClearanceRequirements);
			test.log(Status.FAIL, "Expected and Actual SecurityClearanceRequirements does not match");
		}
		if (ActualSubmissionInstructions.equals(SubmissionInstructions)) {
			test.log(Status.INFO, "Actual SubmissionInstructions = " + ActualSubmissionInstructions);
			test.log(Status.PASS, "Expected and Actual SubmissionInstructions matches");
		}else {
			test.log(Status.INFO, "Actual SubmissionInstructions = " + ActualSubmissionInstructions);
			test.log(Status.FAIL, "Expected and Actual SubmissionInstructions does not match");
		}


	}

	@And("^I click on Home Page Menu left hand side bar$")
	public void iClickOnHomePageMenuLeftHandSideBar() throws Exception {
		Assert.assertTrue(homepage.HomeBtn(),"HOme button display");


	}

	@And("^I click on Restricted widget from DashBoard$")
	public void iClickOnRestrictedWidgetFromDashBoard() throws Exception {
		Assert.assertTrue(homepage.ResttrictedWidget(),"HOme button display");
	}



	@Then("^Verify the error Message of CRMID$")
	public void verifyTheErrorMessageOfCRMID() throws Exception {
		Assert.assertTrue(homepage.CRMIDErrorMessage(),"HOme button display");

	}

	@Then("^Verify the updated data (.*)$")
	public void verifyTheUpdatedData(String BidName) throws Exception {
		Assert.assertTrue(homepage.verifyBidNameUpdated(BidName),"BidName Updated");
	}

	@Then("^I drag the file from window component$")
	public void iDragTheFileFromWindowComponent() throws InterruptedException {

		homepage.VerifyDragAndDrop();
		Thread.sleep(20000);





	}

	@And("^I Verify the finalSubmission bid Creation successfully created with values of (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*) and (.*)")
	public void finalSubmissionBidCreation(String BidTitle, String ClientName, String BidEventType,
									  String BidManager, String SalesLead, String SensitivityLevel, String Notes, String SecurityClearanceRequirements,
									  String SubmissionInstructions) throws InterruptedException, IOException {

		Thread.sleep(20000);
		createnewbidpage.switchToDefaultWindow();
		ArrayList<String> FinalBidValues = createnewbidpage.getFinalBidValues();
		String ActualClientName = FinalBidValues.get(0);
		String ActualBidEventType= FinalBidValues.get(1);
		String ActualSubmissonDate = FinalBidValues.get(2);
		String ActualSensitivityLevel = FinalBidValues.get(3);
		String ActualNotes = FinalBidValues.get(4);
		String ActualSecurityClearanceRequirements = FinalBidValues.get(5);
		String ActualSubmissionInstructions = FinalBidValues.get(6);
		String id = createnewbidpage.bidIDNumber();
		WritePropertiesFile writePropertiesFile = new WritePropertiesFile();
		writePropertiesFile.WritePropertiesFile("BidFinalSubmission",id,System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties");

		/*Properties properties = new Properties();
		try(OutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties")){
			properties.setProperty("RestrcitedBidId", id);
			properties.store(outputStream, null);
			outputStream.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {


		}*/
		if (ActualClientName.equals(ClientName)) {
			test.log(Status.INFO, "Actual ClientName = " + ActualClientName);
			test.log(Status.PASS, "Expected and Actual Client Name matches");
		}else {
			test.log(Status.INFO, "Actual ClientName = " + ActualClientName);
			test.log(Status.FAIL, "Expected and Actual Client Name does not match");
		}
		if (ActualBidEventType.equals(BidEventType)) {
			test.log(Status.INFO, "Actual ActualBidEventType = " + ActualBidEventType);
			test.log(Status.PASS, "Expected and Actual BidEventType matches");
		}else {
			test.log(Status.INFO, "Actual ActualBidEventType = " + ActualBidEventType);
			test.log(Status.FAIL, "Expected and Actual BidEventType does not match");
		}
		if (ActualSubmissonDate.equals(SubmissonDate)) {
			test.log(Status.INFO, "Actual SubmissonDate = " + ActualSubmissonDate);
			test.log(Status.PASS, "Expected and Actual SubmissonDate matches");
		}else {
			test.log(Status.INFO, "Actual SubmissonDate = " + ActualSubmissonDate);
			test.log(Status.FAIL, "Expected and Actual SubmissonDate does not match");
		}
		if (ActualSensitivityLevel.equals(SensitivityLevel)) {
			test.log(Status.INFO, "Actual SensitivityLevel = " + ActualSensitivityLevel);
			test.log(Status.PASS, "Expected and Actual SensitivityLevel matches");
		}else {
			test.log(Status.INFO, "Actual SensitivityLevel = " + ActualSensitivityLevel);
			test.log(Status.FAIL, "Expected and Actual SensitivityLevel does not match");
		}
		if (ActualNotes.equals(Notes)) {
			test.log(Status.INFO, "Actual Notes = " + ActualNotes);
			test.log(Status.PASS, "Expected and Actual Notes matches");
		}else {
			test.log(Status.INFO, "Actual Notes = " + ActualNotes);
			test.log(Status.FAIL, "Expected and Actual Notes does not match");
		}
		if (ActualSecurityClearanceRequirements.equals(SecurityClearanceRequirements)) {
			test.log(Status.INFO, "Actual SecurityClearanceRequirements = " + ActualSecurityClearanceRequirements);
			test.log(Status.PASS, "Expected and Actual SecurityClearanceRequirements matches");
		}else {
			test.log(Status.INFO, "Actual SecurityClearanceRequirements = " + ActualSecurityClearanceRequirements);
			test.log(Status.FAIL, "Expected and Actual SecurityClearanceRequirements does not match");
		}
		if (ActualSubmissionInstructions.equals(SubmissionInstructions)) {
			test.log(Status.INFO, "Actual SubmissionInstructions = " + ActualSubmissionInstructions);
			test.log(Status.PASS, "Expected and Actual SubmissionInstructions matches");
		}else {
			test.log(Status.INFO, "Actual SubmissionInstructions = " + ActualSubmissionInstructions);
			test.log(Status.FAIL, "Expected and Actual SubmissionInstructions does not match");
		}


	}

	@And("^I click on Bid Created as \"([^\"]*)\"$")
	public void iClickOnBidCreatedAs(String arg0) throws Throwable {
		bidPage.SelectFinalBidSubmission();
	}



}
