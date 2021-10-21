package pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.github.javafaker.Faker;
import helpers.PopupWindow;
import helpers.WritePropertiesFile;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;


import step_definitions.BaseClass;

import static java.util.concurrent.TimeUnit.SECONDS;

//import com.sharepoint.qa.base.TestBase;

public class CreateNewBidPage extends BaseClass {

	private final Faker faker = new Faker();

//	WebConnnector con;

	@FindBy(xpath = "//a[@title='Bid List']")
	WebElement BidList;

	@FindBy(xpath = "//input[@title='Name Required Field']")
	WebElement Name;

	@FindBy(xpath = "//input[@title='Bid Title Required Field']")
	WebElement BidTitle;

	@FindBy(xpath = "//input[@title='Client Name Required Field']")
	WebElement ClientName;

	@FindBy(xpath = "//select[@title='Bid Event Type Required Field']")
	WebElement BidEventType;

	@FindBy(xpath = "//select[@id='DropdownNr1']")
	WebElement BidManager;

	@FindBy(xpath = "//select[@id='DropdownNr2']")
	WebElement SalesLead;

	@FindBy(xpath = "//input[@title='Submission Date Required Field']")
	WebElement SubmissonDate;

	@FindBy(xpath = "//select[@title='Sensitivity level Required Field']")
	WebElement SensitivityLevel;

	@FindBy(xpath = "//textarea[contains(@id,'Notes')]")  //"//textarea[@title='Notes']")
	WebElement Notes;

	@FindBy(xpath = "//textarea[contains(@id,'Security')]") //"//textarea[@title='Security clearance requirements Required Field']")
	WebElement SecurityClearanceRequirements;

	@FindBy(xpath = "//textarea[contains(@id,'Submission')]")//"//textarea[@title='Submission instructions Required Field']")
	WebElement SubmissionInstructions;

	//@FindBy(xpath = "//input[@title='CRM ID']")
	//WebElement CRMID;

	@FindBy(xpath = "//input[@title='CRM ID Required Field']")
	WebElement CRMID;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement Save;

	@FindBy(xpath = "//input[@value='Cancel']")
	WebElement Cancel;

	@FindBy(xpath = "//td[@valign='top']/../td[3]")
	List<WebElement> FinalBidValues;

	@FindBy(xpath =   "//iframe[contains(@src,'/_layouts/15/listform.aspx?')]" )    //"(//iframe)[1]")
	WebElement CreateBidFrame;

	@FindBy(xpath = "//*[@title='Upload a document from your computer to this library.']/span[1]")
	WebElement uploadBtn;

	@FindBy(xpath ="//*[@id='dialogTitleSpan']")
	WebElement addDocumentDialogBox;


	@FindBy(xpath = "//input[@value='Cancel']")
	WebElement addDocmentPageClose;

	@FindBy(xpath = "//iframe[@class='ms-dlgFrame']")
	WebElement uplaodFrame;

	@FindBy(xpath = "//input[@title='Choose a file']")
	WebElement uploadFilePath;

	@FindBy(xpath = "//*[@title='Version Comments']")
	WebElement versionComment;

	@FindBy(xpath = "//*[@value='OK']")
	WebElement okUploadBnt;

	@FindBy(xpath = "//*[text()='Sub Group']//following::input[@value='Check In']")
	WebElement checkInbtn;

	@FindBy(xpath = "//*[@title='Select files and download as a zip file']/span/img")
	WebElement zipFileBtn;

	@FindBy(xpath = "//*[@title='Click here for Final Submission']/span/img")
	WebElement finalSubmission;

	@FindBy(xpath = "//*[@class='ms-List-cell']")
	WebElement bidRecordsCnt;

	@FindBy(xpath = "(((//*[@class='ms-List-cell'])[1]//following::span[contains(@class,'FieldRenderer-NameRenderer-SignalField')])[1]//following::a)[1]")
	WebElement bidCreationBtn;

	@FindBy(xpath = "(//div[@role='checkbox'])[1]")
	WebElement bidAttachmentChkBox;


	@FindBy (xpath = "//iframe[contains(@src,'/FinalSubmission/FinalSubmission.aspx')]")
	WebElement finalSubmisionFrame;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement FinalSubmissionOk;

	@FindBy(xpath  ="//a[@id='ViewPropsLink']")
	WebElement viewAllPropertiesLink;

	@FindBy(xpath = "//a[contains(@name,'SPBookmark_Frameworks_')]//following::input[@value='Close']")
	WebElement CloseBtn;

	@FindBy(xpath  ="//a[@id='EditPropsLink']")
	WebElement EditPropertiesLink;

	@FindBy(xpath = "//input[@title='Bid Title Required Field']")
	WebElement  bidTitle;

	@FindBy(xpath = "//*[contains(@id,'Frameworks')]//following::input[@value='Save']")
	WebElement SaveBtn;

	@FindBy(xpath = "//*[text()='Copy Documents']")
	WebElement copyDocument;

	@FindBy(xpath = "//select[@id='crmIDList']")
	WebElement crmIdDropDown;

	@FindBy(xpath = "//input[@id='copyDoc']")
	WebElement copyBtn;

	@FindBy(xpath = "//p[@id='msgCopy']")
	WebElement CopySuccessFulMsg;

	@FindBy(xpath = "//iframe[contains(@id,'DlgFrame') and @class='ms-dlgFrame']")
	WebElement DlgFrame;

	@FindBy(xpath = "//a[@id='destBidUrl']")
	WebElement destinationBidLink;

	@FindBy(xpath = "//span[text()='Edit' and @class='CommandBarItem-commandText']")
	WebElement editMenu;

	@FindBy(xpath = "//span[text()='Delete' and @class='CommandBarItem-commandText']")
	WebElement deleteBidManager;

	@FindBy(xpath = "//span[text()='Delete' and @class='od-Button-label']")
	WebElement deleteConfirmBtn;

	@FindBy(xpath = "//*[contains(text(),'Deleted 1 item from ')]")
	WebElement deletedMsg;

	// new document added
	@FindBy(xpath = "//input[@value='SharePoint Test case (2)' and contains(@title,'Name Required Field')]")
	WebElement DocName;  // i want to take this xpath directly into script as value will get change

    @FindBy(xpath = "//select[contains(@title,'Bid Event Type Required') or @id='Bid']")
    WebElement bidEventType;

    @FindBy(xpath = "//select[contains(@title,'Document Group Required') or contains(@id,'Document')]")
	WebElement documentRequiredDropDown;

    @FindBy(xpath = "//select[contains(@title,'Sub Group Required') or contains(@id,'Sub')]")
	WebElement subgroup;

    @FindBy(xpath = "//span[@id='idDocsetName']")
	WebElement BidId;

    @FindBy(xpath = "//*[text()='More']/span[2]")
	WebElement moreBtn;

    @FindBy(xpath = "//a[@id='ID_AdvancedMenu']")
	WebElement advanceMenuOption;

	/*@FindBy(xpath = "//a[@id='ID_DeleteMenu']")
	WebElement deleteMenuOption;*/
	@FindBy(xpath = "//a[@id='ID_DeleteDocItem']")
	WebElement deleteMenuOption;

	@FindBy(xpath = "//a[@id='ID_Checkout' or @id='ID_Checkin']")
	WebElement checkInAndCheckOut;

	@FindBy(xpath = "//*[@id='CheckinDescription']")
	WebElement CheckInComments;

	@FindBy(xpath = "//input[@id='CheckinOk']")
	WebElement checkInBtnOk;

	@FindBy(xpath = "//input[@id='inplaceSearchDiv_WPQ7_lsinput']")
	WebElement insideBidCreation;

	@FindBy(xpath = "//div[@id='WebPartWPQ1']//input[1]")
	WebElement BidRecordKeyContent;

	@FindBy(id = "Result")
	public WebElement SearchContentBid;

	@FindBy(xpath = "//span[@id='inplaceSearchDiv_WPQ7_lsimgspan']")
	WebElement SearchMagnifierBtn;

	@FindBy(xpath = "//table[@summary='Bid List']/tbody")
	WebElement BidRecords;

	@FindBy(name = "Search")
	WebElement SearchAsKey;

	@FindBy(xpath = "//span[text()='Share']")
	WebElement shareBtnDispay;

	@FindBy(xpath = "//div[@id='selected-suggestion-alert']//following::input[1]")
	WebElement enterSenderName;

	@FindBy(xpath = "//div[contains(@id,'id__') and text()='Send']")
	WebElement  sendRecepientBtn;

	@FindBy(xpath = "//div[@class='od-ShareNotification-icon']")
	WebElement shareNotificatioDisplay;

	@FindBy(xpath = "//*[@class='ms-standardheader' and text()='CRM ID']//following::td[2]")
	WebElement getCRMID;




	public CreateNewBidPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isNameTextBoxDisplayed() {
		return (Name.isDisplayed());
	}

	public boolean isNameTextBoxEnabled() {
		return (Name.isEnabled());
	}
	public void switchToCreateNewBidFrame() throws InterruptedException {
		manageFluientWait(CreateBidFrame);
		Thread.sleep(20000);
		     driver.getTitle();
		     System.out.println(driver.getTitle());
		//driver.switchTo().defaultContent();
			driver.switchTo().frame(CreateBidFrame);
	}

	public void switchToDefaultWindow() {
		driver.switchTo().defaultContent();
	}

	public String bidIDNumber(){
		BidId.isDisplayed();
	    return BidId.getText().trim();
	}

	public void manageFluientWait(WebElement element){
		WebElement waitFluent=null;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(java.time.Duration.ofSeconds(300))
				.pollingEvery(Duration.ofMillis(50))
				.ignoring(NoSuchElementException.class);
		WebElement elements = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement elements = element;
				String getTextOnPage = elements.getText();
				if(elements.isDisplayed()){
					System.out.println(getTextOnPage);
					return element;
				}
				return elements;
			}
		});
	}
	public boolean isBidListRightSideOptionDisplayed() {
		return (BidList.isDisplayed());
	}

	public boolean isBidListRightSideOptionsEnabled() {
		return (BidList.isEnabled());
	}

	public boolean isBidTitleTextBoxDisplayed() {
		return (BidTitle.isDisplayed());
	}

	public boolean isBidTitleTextBoxEnabled() {
		return (BidTitle.isEnabled());
	}

	public boolean isClientNameTextBoxDisplayed() {
		return (ClientName.isDisplayed());
	}

	public boolean isClientNameTextBoxEnabled() {
		return (ClientName.isEnabled());
	}

	public boolean isBidEventTypeDropDownBoxDisplayed() {
		return (BidEventType.isDisplayed());
	}

	public boolean isBidEventTypeDropDownBoxEnabled() {
		return (BidEventType.isEnabled());
	}

	public boolean isBidManagerDropDownDisplayed() {
		return (BidManager.isDisplayed());
	}

	public boolean isBidManagerDropDownEnabled() {
		return (BidManager.isEnabled());
	}

	public boolean isSalesLeadDropDownDisplayed() {
		return (SalesLead.isDisplayed());
	}

	public boolean isSalesLeadDropDownEnabled() {
		return (SalesLead.isEnabled());
	}

	public boolean isSubmissionDateFieldDisplayed() {
		return (SubmissonDate.isDisplayed());
	}

	public boolean isSubmissionDateFieldEnabled() {
		return (SubmissonDate.isEnabled());
	}

	public boolean isSensitivityLevelDropDownDisplayed() {
		return (SensitivityLevel.isDisplayed());
	}

	public boolean isSensitivityLevelDropDownEnabled() {
		return (SensitivityLevel.isEnabled());
	}

	public boolean isNotesTextDisplayed() {
		return (Notes.isDisplayed());
	}

	public boolean isNotesTextEnabled() {
		return (Notes.isEnabled());
	}

	public boolean isSecurityClearanceRequirementsTextDisplayed() {
		return (SecurityClearanceRequirements.isDisplayed());
	}

	public boolean isSecurityClearanceRequirementsTextEnabled() {
		return (SecurityClearanceRequirements.isEnabled());
	}

	public boolean isSubmissionInstructionsTextDisplayed() {
		return (SubmissionInstructions.isDisplayed());
	}

	public boolean isSubmissionInstructionsTextEnabled() {
		return (SubmissionInstructions.isEnabled());
	}

	public boolean isCRMIDTextDisplayed() {
		return (CRMID.isDisplayed());
	}

	public boolean isCRMIDTextEnabled() {
		return (CRMID.isEnabled());
	}

	public boolean isSaveButtonDisplayed() {
		return (Save.isDisplayed());
	}

	public boolean isSaveButtonEnabled() {
		return (Save.isEnabled());
	}

	public boolean isCancelButtonDisplayed() {
		return (Cancel.isDisplayed());
	}

	public boolean isCancelButtonEnabled() {
		return (Cancel.isEnabled());
	}

	public void clickBidListRightHandSideOption() {
		try {
			BidList.click();
			WaitForSpecificTime();
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occured while clicking Ok button...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking Ok button...");
		}

	}

	public void clickSaveButton() {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", Save);
			//Save.click();
		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException occured while clicking Ok button...");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking Ok button...");
		}

	}

	public void clickCancelButton() {
		Cancel.click();
	}

	public void setName(String Name) throws InterruptedException {
		this.Name.sendKeys(Name);
		Thread.sleep(2000);
	}

	public void setBidTitle(String BidTitle) throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("BidTitle before typing = " + BidTitle);
		for (int i = 0; i < BidTitle.length(); i++) {
			char ch = BidTitle.charAt(i);
			this.BidTitle.sendKeys(String.valueOf(ch));
			Thread.sleep(500);
		}
//		this.BidTitle.sendKeys(BidTitle);
//		Thread.sleep(2000);
	}

	public void setBidTitleTest(String BidTitle) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(this.BidTitle));
		this.BidTitle.sendKeys(BidTitle);
		Thread.sleep(2000);
	}

	public void setClientName(String ClientName) throws InterruptedException {
		for (int i = 0; i < ClientName.length(); i++) {
			char ch = ClientName.charAt(i);
			this.ClientName.sendKeys(String.valueOf(ch));
			Thread.sleep(500);
		}
//		this.ClientName.sendKeys(ClientName);
//		Thread.sleep(2000);
	}


	public void setClientNameTest(String ClientName) throws InterruptedException {
		this.ClientName.sendKeys(ClientName);
	}

	public void setBidEventType(String BidEventType) throws InterruptedException {
		this.BidEventType.sendKeys(BidEventType);
		Thread.sleep(2000);
	}

	public void setBidManager(String BidManager) throws InterruptedException {
		Select bidmanager = new Select(this.BidManager);
		bidmanager.selectByVisibleText(BidManager);
		Thread.sleep(2000);
		// this.BidManager.sendKeys(BidManager);
	}

	public void setDocumentVal(String docName,String uploadedDoc) throws  InterruptedException{
		String docNam = driver.findElement(By.xpath("//input[@value='"+docName+"' and contains(@title,'Name Required Field')]")).getAttribute("value").trim();
		Assert.assertTrue("Documnet Name verify", docNam.equalsIgnoreCase(uploadedDoc));
	}

	public void setBidTypVerify(String bidTypeVal) throws InterruptedException{
		manageFluientWait(this.bidEventType);
		Select bidType = new Select(this.bidEventType);
		bidType.selectByVisibleText(bidTypeVal);
		Thread.sleep(2000);

	}

	public void setdocumentGroupVerify(String docGroupVal) throws InterruptedException{
		Select bidType = new Select(this.documentRequiredDropDown);
		bidType.selectByVisibleText(docGroupVal);
		Thread.sleep(2000);

	}

	public void setSubtGroupVerify(String subGroupVal) throws InterruptedException{
		Select bidType = new Select(this.subgroup);
		bidType.selectByVisibleText(subGroupVal);
		Thread.sleep(2000);

	}

	public void setSalesLead(String SalesLead) throws InterruptedException {
		Select saleslead = new Select(this.SalesLead);
		saleslead.selectByVisibleText(SalesLead);
		// this.SalesLead.sendKeys(SalesLead);
		Thread.sleep(2000);
	}

	public String setSubmissonDate() throws InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String formattedLocalDate = dtf.format(now);
		this.SubmissonDate.sendKeys(formattedLocalDate);
		Thread.sleep(2000);
		return formattedLocalDate;
	}

	public void setSensitivityLevel(String SensitivityLevel) throws InterruptedException {
		Select senstivitylevel = new Select(this.SensitivityLevel);
		senstivitylevel.selectByVisibleText(SensitivityLevel);
		// this.SensitivityLevel.sendKeys(SensitivityLevel);
		Thread.sleep(2000);
	}

	public void setNotes(String Notes) throws InterruptedException {
		this.Notes.sendKeys(Notes);
		Thread.sleep(2000);
	}

	public void setSecurityClearanceRequirements(String SecurityClearanceRequirements) throws InterruptedException {
		this.SecurityClearanceRequirements.sendKeys(SecurityClearanceRequirements);
		Thread.sleep(2000);
	}

	public void setSubmissionInstructions(String SubmissionInstructions) throws InterruptedException {
		this.SubmissionInstructions.sendKeys(SubmissionInstructions);
		Thread.sleep(2000);
	}

	public String setNameandCRMID() throws InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		String formattedLocalDateTime = dtf.format(now);
		this.CRMID.sendKeys(formattedLocalDateTime);
		this.Name.sendKeys(formattedLocalDateTime);
		Thread.sleep(2000);
		return formattedLocalDateTime;
	}

	public Integer setNameandCRMIDDynamic() throws InterruptedException {
		Thread.sleep(2000);
		String dynamicCRMID = String.valueOf(faker.hashCode());
		this.CRMID.sendKeys(dynamicCRMID);
		return Integer.valueOf(dynamicCRMID);
	}
	
	public ArrayList<String> getFinalBidValues() {
		ArrayList<String> temp = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FinalBidValues.get(1)));
		
		for (int i = 0; i < FinalBidValues.size(); i++) {
			temp.add(FinalBidValues.get(i).getText());
		}
		return temp;
	}

	public void WaitForSpecificTime() throws InterruptedException {
		Thread.sleep(20000);
	}

	public void uploadBtnVeriy()throws InterruptedException{
		try{
			//Thread.sleep(10000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(uploadBtn));
			uploadBtn.click();
			WaitForSpecificTime();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void uploadFile()throws InterruptedException{
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
			prop.load(ip);
			String docName = prop.getProperty("attachmentName");
			uploadFilePath.sendKeys( System.getProperty("user.dir")+"/Attachments/"+docName);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void versionCommits()throws InterruptedException{
		try{
			versionComment.sendKeys("Test Uplaod");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void addDocumentSpanWindow()throws InterruptedException{
		try{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", addDocumentDialogBox);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void okUploadBnt()throws InterruptedException{
		try{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", okUploadBnt);
			Thread.sleep(5000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void checkIn()throws InterruptedException{
		try{

			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", checkInbtn);
			Thread.sleep(20000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void uploadFrameSwitch()throws InterruptedException{
		try{
			//Thread.sleep(8000);
			waitForPageToLoad(uplaodFrame);
			driver.switchTo().frame(uplaodFrame);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void finalSubmissionFrame()throws InterruptedException{
		try{
			Thread.sleep(5000);
			driver.switchTo().frame(finalSubmisionFrame);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void finalSubmissionOk()throws InterruptedException{
		try{
			FinalSubmissionOk.click();
			driver.manage().timeouts().pageLoadTimeout(30, SECONDS);
			//Thread.sleep(20000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void zipBtnVerify()throws InterruptedException{
		System.out.println("JummmmmmmmmmmmmmmmmmmmmmmmmmmmmmPPPPPPPPing");
		driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", zipFileBtn);
		Thread.sleep(5000);

	}

	public void verifyZipGetsDownloaded() throws  Exception{
		Thread.sleep(20000);
		String crmId =getCRMID.getText().trim();
		System.out.println("sdjfkjdsfksdkfkdskf :" +crmId);
		String path = "C:\\Users\\Parmeshwar.Sakole\\Downloads";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File f = null;
		//Look for the file in the files
		// You should write smart REGEX according to the filename
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File " + listOfFile.getName());
				if (fileName.matches("CRMID_"+crmId+".zip")) {
					f = new File(fileName);
					found = true;
				}
			}
		}
		Assert.assertTrue("Downloaded document is not found",found);
		f.deleteOnExit();
		//if(Directory.Exist)
	}

	public  void finalSubmissionVerify()throws InterruptedException{
		try{
			Thread.sleep(2000);
			finalSubmission.click();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void alertPersentOrNot()throws InterruptedException{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30 /*timeout in seconds*/);
			if(wait.until(ExpectedConditions.alertIsPresent())!=null) {
				System.out.println("alert  present");
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(5000);
			}else{
				System.out.println("alert was present");
			}
		}catch (Exception e){

		}
	}
	public String getTitle="";
	public void checkExistBidCreation()throws InterruptedException{
		try{
			Thread.sleep(10000);
			List<WebElement> bidRecords =  driver.findElements(By.xpath("(//*[@class='ms-List-cell'])[1]//following::span[contains(@class,'FieldRenderer-NameRenderer-SignalField')]"));
			System.out.println("bidRecords count "+ bidRecords);
			if(!bidRecords.isEmpty()){
					getTitle=  bidCreationBtn.getText();
					System.out.println("---------*****"+getTitle);
						bidCreationBtn.click();
			}else{
					System.out.println("We don't have a bid creation records");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public boolean BidReturnSearchContent()throws  Exception{
		Boolean flag= false;
		try{
			Boolean tbodyExist = BidRecords.isDisplayed();
			if(tbodyExist){
				flag=true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean SearchContentBidDisplay()throws  Exception{
		Boolean flag= false;
		try{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(SearchContentBid));
			Boolean tbodyExist = SearchContentBid.isDisplayed();
			if(tbodyExist){
				flag=true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return flag;
	}


	public boolean BidReturnAsKeyContent()throws  Exception{
		Boolean flag= false;
		Thread.sleep(10000);
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
		prop.load(ip);
		try{

			String docName = prop.getProperty("BidListKey");
			Boolean tbodyExist = driver.findElement(By.xpath("//span[text()='"+docName+"']")).isDisplayed();
			if(tbodyExist){
				flag=true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			ip.close();
		}
		return flag;
	}

	public boolean  bidListViewDocSelect(String uploadedDocName) throws Exception{
		boolean docFlag=false;
		try{
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
			WebElement test = driver.findElement(By.xpath("(//a[text()='"+uploadedDocName+"']//preceding::div[@role='checkbox'and @aria-checked='false'])[1]"));
			driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
			System.out.println("**************************************************test Id one "+ test);
			test.click();
			Thread.sleep(2000);
			docFlag=true;
			/*
			WebDriverWait wait = new WebDriverWait(driver, 30 );
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@summary='Bid List']/thead/tr/th"))));
			List<WebElement> bidRecords =  driver.findElements(By.xpath("//table[@summary='Bid List']/thead/tr/th"));
			Lable1:
			for(int i=1;i<=bidRecords.size();i++)
			{
						String bidListHeaderName = driver.findElement(By.xpath("(//table[@summary='Bid List']/thead/tr/th)["+i+"]")).getText().trim();
						if(bidListHeaderName.equals("Name")){
							System.out.println("first Loop Success"+i);
							boolean tbody = driver.findElement(By.xpath("//table[@summary='Bid List']/tbody/tr")).isDisplayed();
							 if(tbody)
							 {
								 System.out.println("secod Loop Success");
								 List<WebElement> tblDocNameCnt = driver.findElements(By.xpath("(//table[@summary='Bid List']/tbody/tr/td["+i+"]/div/a)"));
									for(int j=1;j<=tblDocNameCnt.size();j++)
									{
										System.out.println("third Loop Success"+(i)+"("+j+")");
										String docName = driver.findElement(By.xpath("(//table[@summary='Bid List']/tbody/tr/td["+i+"]/div/a)["+j+"]")).getText().trim();
										if(docName.equals(uploadedDocName))
										{

											 driver.findElement(By.xpath("(//table[@summary='Bid List']/tbody/tr/td["+i+"]/div/a)["+j+"]//preceding::div[@role='checkbox'][1]")).click();
											*//*JavascriptExecutor js = (JavascriptExecutor)driver;
											js.executeScript("arguments[0].click();", chkbox);*//*
											System.out.println("Last Loop Success"+j);
											docFlag=true;
											System.out.println("break1");
											break;
										}
									}
							 }else {
							 	Assert.fail("Attachment not present for this bid");
							 }
							if(docFlag)
								System.out.println("break5");
								break;

						}
			}*/
		}catch (Exception e){
			e.printStackTrace();
		}
		return docFlag;
	}


	public boolean  bidListViewDocNotPresent(String uploadedDocName){
		boolean docFlag=false;
		try{
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
			WebElement test = driver.findElement(By.xpath("(//a[text()='"+uploadedDocName+"']//preceding::div[@role='checkbox'and @aria-checked='false'])[1]"));
			driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
			System.out.println("**************************************************test Id one "+ test);
			test.click();
			Thread.sleep(2000);
			docFlag=false;
		}catch (Exception e){
			docFlag=true;
		}
		return docFlag;
	}

	public void switchWindow() throws InterruptedException {
		PopupWindow window = new PopupWindow();
		window.getTitleOfNewPage(driver,getTitle);
	}
	public void selectItemInBidList()throws InterruptedException{
		try{
			driver.switchTo().defaultContent();
			bidAttachmentChkBox.click();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void viewAllPropertiesLink()throws InterruptedException{
		try{
			driver.switchTo().defaultContent();
			viewAllPropertiesLink.click();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void CloseBtn()throws InterruptedException{
			CloseBtn.click();
	}
	public void SaveBtn()throws InterruptedException{
			SaveBtn.click();
	}
	public void EditPropertiesLink()throws InterruptedException{
			driver.switchTo().defaultContent();
			EditPropertiesLink.click();
	}



	public void UpdateTheBidTitle(String changeTitleName){
		try{
			bidTitle.clear();
			bidTitle.sendKeys(changeTitleName);

		}catch (Exception e){
			e.printStackTrace();

		}
	}

	public void copyDocument()throws InterruptedException{
			copyDocument.click();
	}

	public void  SelectCrmId() throws InterruptedException, IOException {
		//Dropdown dropdown = new Dropdown();
		//dropdown.selectValueFromUnorderedList((WebElement) driver,val);
		Thread.sleep(20000);
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
		Properties prop = new Properties();
		prop.load(fileInputStream);
		String crmId = prop.getProperty("CRMID");
		Select bidmanager = new Select(this.crmIdDropDown);
		bidmanager.selectByVisibleText(crmId);
		Thread.sleep(5000);


	}

	public void CopyDocumentBtn()throws InterruptedException{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", copyBtn);
		    Thread.sleep(5000);

	}

	public void waitTillMsgDisply() throws InterruptedException {
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(DlgFrame);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(CopySuccessFulMsg));
		Thread.sleep(5000);
	}
	public void destinationLink()throws InterruptedException{
			/*JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", destinationBidLink);*/
		    destinationBidLink.click();
		    Thread.sleep(20000);
		    driver.switchTo().defaultContent();
	}

public void clickOnBIdMangerSelection(String titleName) throws InterruptedException {
			System.out.println("titleName......>"+titleName);
			driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
			WebElement slectCheckbox = driver.findElement(By.xpath("(//button[contains(@class,'ms-Link titleField') and @title='"+titleName+"'])[1]//preceding::div[contains(@class,'ms-Check root')][1]"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", slectCheckbox);
}

public void editMenuBar()throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(editMenu));
			editMenu.click();
}

	public void deleteBidManager()throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(deleteBidManager));
			deleteBidManager.click();

	}

	public void deleteConfirmBtn()throws InterruptedException{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(deleteConfirmBtn));
			deleteConfirmBtn.click();
	}

	public void confirmDeletMessage()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(deletedMsg));
	}

	public void verifyEditTitleName(String bidName)throws InterruptedException{
			Thread.sleep(5000);
			WebElement updatedElemnt = driver.findElement(By.xpath("//button[@title='"+bidName+"' and text()='"+bidName+"']"));
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(updatedElemnt));
			Assert.assertTrue(updatedElemnt.isDisplayed());

	}

	public void SelectBidCreated(String bidName)throws InterruptedException{
		Thread.sleep(5000);
		WebElement updatedElemnt = driver.findElement(By.xpath("//button[@title='"+bidName+"' and text()='"+bidName+"']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(updatedElemnt));
		Assert.assertTrue(updatedElemnt.isDisplayed());

	}


	public void VerifyDocumentStatus() throws  InterruptedException{
		driver.manage().timeouts().pageLoadTimeout(30, SECONDS);
		List<WebElement> tblHeader = driver.findElements(By.xpath("(//table//thead/tr/th)"));
		for(int i=0;i<tblHeader.size();i++){
			String status = tblHeader.get(i).getText().trim();
			System.out.println("status "+ status);
			if(status.equalsIgnoreCase("Document Group")){
				WebElement docuStatuswebElement = driver.findElement(By.xpath("(//table//thead//tr//th//following::tbody[1]/tr/td)["+(i+1)+"]"));
				String docstatus = docuStatuswebElement.getText().trim();
				System.out.println("docstatus "+ status);
				if(docstatus.equalsIgnoreCase("Final Submission")){
						Assert.assertTrue(docuStatuswebElement.isDisplayed());
						break;
					}else{
						Assert.fail("Document Status not in Final Status");
					}
			}
		}
}

	public void SelectAutoGeneratedBidID() throws InterruptedException, IOException {
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties");
		Properties prop = new Properties();
		prop.load(fileInputStream);
		String bidNumber = prop.getProperty("BidId");
		WebElement slectCheckbox = driver.findElement(By.xpath("//*[text()='"+bidNumber+"']//preceding::div[@role='checkbox' and @aria-checked='false' ][1]"));
		//slectCheckbox.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", slectCheckbox);
		Thread.sleep(2000);
	}

	public void SelectRestrictedAutoGeneratedBidID() throws InterruptedException, IOException {
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties");
		Properties prop = new Properties();
		prop.load(fileInputStream);
		String bidNumber = prop.getProperty("RestrcitedBidId");
		WebElement slectCheckbox = driver.findElement(By.xpath("//*[text()='"+bidNumber+"']//preceding::div[@role='checkbox' and @aria-checked='false' ][1]"));
		//slectCheckbox.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", slectCheckbox);
		Thread.sleep(2000);
	}

	public void SelectFinalBidSubmission() throws InterruptedException, IOException {
		Thread.sleep(10000);
		driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties");
		Properties prop = new Properties();
		prop.load(fileInputStream);
		String bidNumber = prop.getProperty("BidFinalSubmission");
		WebElement slectCheckbox = driver.findElement(By.xpath("//*[text()='"+bidNumber+"']//preceding::div[@role='checkbox' and @aria-checked='false' ][1]"));
		//slectCheckbox.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", slectCheckbox);

	}

	public void clickOnBidRecord() throws InterruptedException, IOException {
		try {
			Thread.sleep(10000);
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties");
			Properties prop = new Properties();
			prop.load(fileInputStream);
			String bidNumber = prop.getProperty("BidId");
			System.out.println("bid*************** "+bidNumber);
			fileInputStream.close();
			WebElement bidNumberExist = driver.findElement(By.xpath("//a[text()='"+ bidNumber +"']"));
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(bidNumberExist));
			bidNumberExist.click();
		}catch (Exception e){

			e.printStackTrace();
		}
	}

	public void clickOnBidForSearchAttachMentContent() throws InterruptedException, IOException {
		try {
			Thread.sleep(10000);
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
			Properties prop = new Properties();
			prop.load(fileInputStream);
			String bidNumber = prop.getProperty("BidNumberForSearch");
			System.out.println("bid*************** "+bidNumber);
			fileInputStream.close();
			WebElement bidNumberExist = driver.findElement(By.xpath("//a[text()='"+ bidNumber +"']"));
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(bidNumberExist));
			bidNumberExist.click();
		}catch (Exception e){

			e.printStackTrace();
		}
	}

	public boolean isCheckOutVerify() throws Exception{
		boolean moreBtnEnabled=false;
		try{
			  moreBtnEnabled = moreBtn.isEnabled();
			if(moreBtnEnabled){
				moreBtnEnabled=true;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", moreBtn);
				Thread.sleep(2000);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			return moreBtnEnabled;
		}
	}

	public boolean isAdvanceMenu() throws Exception{
		try {


			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", advanceMenuOption);
			//advanceMenuOption.click();
			Thread.sleep(5000);
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean isDeleteOption() throws Exception{
		try {
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", deleteMenuOption);
			Thread.sleep(2000);
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}


	public boolean isCheckInAndCheckOut() throws Exception{
		try {
			Thread.sleep(5000);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].click();", checkInAndCheckOut);
			checkInAndCheckOut.click();
			Thread.sleep(2000);
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public void isSearchContentChecked() throws Exception{
		try{
			Thread.sleep(5000);
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
			prop.load(ip);
			String docName = prop.getProperty("InsideBidContentSearch");
			insideBidCreation.sendKeys( docName);
			Thread.sleep(5000);
			insideBidCreation.sendKeys(Keys.ENTER);
			//SearchMagnifierBtn.click();
			Thread.sleep(5000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void isSearchBidRecordKeyContent() throws Exception{
		try{
			Thread.sleep(5000);
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
			prop.load(ip);
			String docName = prop.getProperty("InsideBidContentSearch");
			BidRecordKeyContent.sendKeys(docName);
			Thread.sleep(2000);
			BidRecordKeyContent.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}




	public void isSearchContentKey() throws Exception{
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
		prop.load(ip);
		try{
			Thread.sleep(5000);

			String docName = prop.getProperty("BidListKey");
			SearchAsKey.sendKeys( docName);
			SearchAsKey.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			ip.close();
		}
	}

	public boolean isSharebtnDisplay() throws Exception{
		boolean chkbtn=false;
		try{
			Thread.sleep(10000);
			shareBtnDispay.isDisplayed();
			shareBtnDispay.click();
			chkbtn=true;
			Thread.sleep(5000);
		}catch (Exception e){
			e.printStackTrace();
		}
		return chkbtn;
	}


	public void isAddSenderName(String Name) throws InterruptedException {
		this.enterSenderName.sendKeys(Name);
		Thread.sleep(5000);
		this.enterSenderName.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}

	public boolean isSendBtn() throws Exception{
		boolean sendBtnEnabled = false;
		try {
			 sendBtnEnabled=this.sendRecepientBtn.isDisplayed();
			 this.sendRecepientBtn.click();
		}catch (Exception e){
			e.printStackTrace();
		}
		return sendBtnEnabled;
	}

	public boolean isShareNotification() throws Exception{
		boolean shareNotifiaction = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(shareNotificatioDisplay));
			shareNotifiaction=this.shareNotificatioDisplay.isDisplayed();
		}catch (Exception e){
			e.printStackTrace();
		}
		return shareNotifiaction;
	}


	public boolean isCheckOutExistOrNot() throws Exception{
		Boolean CheckOutOption= false;
		try{
			WebDriverWait wait = new WebDriverWait(driver, 60 /*timeout in seconds*/);
			if(wait.until(ExpectedConditions.alertIsPresent())!=null) {
				System.out.println("alert  present");
				Alert alert = driver.switchTo().alert();
				String alertMsg =alert.getText();
				System.out.println("*************************************************"+alertMsg);
				alert.accept();
				CheckOutOption= true;
				Thread.sleep(10000);
			}else{
				System.out.println("alert was present");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return CheckOutOption;
	}

	public boolean isCheckInPopupIsExist() throws Exception{
		Boolean checkIn= false;
		try{
			Thread.sleep(2000);
			CheckInComments.sendKeys("TestCheckIn");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkInBtnOk);
			Thread.sleep(5000);
			checkIn=true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return checkIn;
	}

	public void clickOnBidRecordForShare() throws InterruptedException, IOException {
		try {
			Thread.sleep(10000);
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/RunTimeData.properties");
			Properties prop = new Properties();
			prop.load(fileInputStream);
			String bidNumber = prop.getProperty("BidId");
			System.out.println("bid*************** "+bidNumber);
			fileInputStream.close();
			WebElement bidNumberExist = driver.findElement(By.xpath("//a[text()='"+ bidNumber +"']//preceding::div[@role='checkbox'][1]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", bidNumberExist);
			//bidNumberExist.click();
		}catch (Exception e){

			e.printStackTrace();
		}
	}

	public String  fullPermission() throws Exception{
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
		prop.load(ip);
		String Username = prop.getProperty("fullPermissionUseName");
		String pwd  =  prop.getProperty("fullPermissionPwd");
		String url = prop.getProperty("url");
		String Url = "http://" + Username + ":" + pwd + "@" + url;
		System.out.println("URLS@@@@@@@@:==="+Url);
		//String url = "tc3-v-devsp05:8888/Bid%20List/Forms/Create%20New%20Bid/docsethomepage.aspx?ID=1586&FolderCTID=0x0120D52000AB2DF4A39E8CC84BA0A89A21CCB25A90007F5E2F2D8CB36146881852BD8BD2DFF9&List=2307072c-74f6-415f-ba02-f6878e18868b&RootFolder=%2FBid%20List%2FBID%2D1596136338424&RecSrc=%2FBid%20List%2FBID%2D1596136338424&InitialTabId=Ribbon%2ERead&VisibilityContext=WSSTabPersistence";
		//String Url = "http://tc3-v-devsp05:8888/Bid%20List/Forms/";
		return Url;
	}

	public String TestUser() throws  Exception{
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" + "/config/config.properties");
		prop.load(ip);
		String Username = prop.getProperty("testUsername");
		String pwd  =  prop.getProperty("testPwd");
		String url = prop.getProperty("url");
		String Url = "http://"+ Username + ":" + pwd + "@" + url;
		System.out.println("=============TestUser"+ Url.trim());
		return Url.trim();
	}



}
