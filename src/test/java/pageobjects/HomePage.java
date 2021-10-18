package pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import step_definitions.BaseClass;

//import com.sharepoint.qa.base.TestBase;

public class HomePage extends BaseClass {



	@FindBy(xpath = "//a[@href='/Bid List/Forms/StandardSecurityView.aspx']")
	WebElement BidListMenu;

	@FindBy(xpath = "//*[@title='Home' or text()='Home']")
	WebElement HomeMenu;

	@FindBy(xpath = "//div[text()='Restricted bids']")
	WebElement restrictedBid;

	@FindBy(className = "CommandBarItem-commandText")
	List<WebElement> CommandBarItems;

	//@FindBy(xpath = "//span[contains(text(),'Create New Bid')]")   earlier xpath changed
	//WebElement CreateNewBid;

	@FindBy(xpath = "//span[contains(text(),'Create Bid')]")
	WebElement CreateBid;

	@FindBy(xpath = "//span[@class='CommandBarItem-commandText' and text()='New']")
	WebElement CreateNewBtn;



//	@FindBy(xpath = "//a[@title='Create New Bid']")
//	WebElement CreateNewBid = driver.findElement(By.xpath((String) BidOperationsPageprop.get("CreateNewBid")));

	@FindBy(xpath = "//iframe[@class='ms-dlgFrame']")
	WebElement CreateNewBidFrame;

	@FindBy(xpath = "//span[text()='Delete' and @class='CommandBarItem-commandText']")
	WebElement deleteBidManager;

	@FindBy(id = "WebPartWPQ7_ms-dnd-dropboxText")
	WebElement dragFilesArea;



	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickBidListMenu() throws InterruptedException {
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(BidListMenu));

		// Fluent wait
		// Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30,
		// TimeUnit.SECONDS).pollingEvery(1,
		// TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		try {
			BidListMenu.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickNew() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(CommandBarItems.get(5)));
		} catch (TimeoutException excep) {
			excep.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*for (int i = 0; i < CommandBarItems.size(); i++) {
			System.out.println("i = " + i + " text = " + CommandBarItems.get(i).getText());
			if(CommandBarItems.get(i).getText().trim().equals("Create Bid")) {
				//CommandBarItems.get(i).click();
				System.out.println("Tested");
			}
		}*/
	}

	public void clickCreateNewBidButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(CreateBid));
		//CreateNewBtn.click();
		Thread.sleep(20000);
			CreateBid.click();
			driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	}

	public void switchToCreateNewBidFrame() {
		driver.switchTo().frame(CreateNewBidFrame);
	}

	public String getPageTitle() {
		return (driver.getTitle().trim());
	}

	public boolean isCreateBidButtonDisplay() throws Exception{
		boolean checkIn= false;
		try{
			try {
				WebDriverWait wait = new WebDriverWait(driver, 60);
				checkIn = wait.until(ExpectedConditions.visibilityOf(CreateBid)).isDisplayed();
			}catch (Exception e){
				checkIn=false;
			}
			finally {
				if(checkIn==false){
					checkIn=true;
					System.out.println("if: "+ checkIn);
				}else{
					checkIn=false;
					System.out.println("else: "+ checkIn);
				}
			}
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}catch (Exception e){
			e.printStackTrace();
		}
		return checkIn;
	}

	public boolean isDeleteButtonDisplay() throws Exception{
		boolean checkIn= false;
		try{
			try {
				WebDriverWait wait = new WebDriverWait(driver, 60);
				checkIn = wait.until(ExpectedConditions.visibilityOf(deleteBidManager)).isDisplayed();
			}catch (Exception e){
				checkIn=false;
			}
			finally {
				checkIn= checkIn == false;
			}
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}catch (Exception e){
			e.printStackTrace();
		}
		return checkIn;
	}


	public boolean HomeBtn() throws Exception{
		boolean homeBtn= false;
		try {
			 homeBtn= HomeMenu.isDisplayed();
			if(homeBtn) {
				HomeMenu.click();
				homeBtn=true;
				Thread.sleep(20000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return homeBtn;
	}

	public boolean ResttrictedWidget() throws Exception{
		boolean homeBtn= false;
		try {
			driver.navigate().refresh();
			Thread.sleep(20000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(20000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(restrictedBid)).isDisplayed();
			homeBtn= restrictedBid.isDisplayed();
			if(homeBtn) {
				restrictedBid.click();
				homeBtn=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return homeBtn;
	}

	public boolean CRMIDErrorMessage() throws Exception{
		boolean homeBtn= false;
		try {
			homeBtn= HomeMenu.isDisplayed();
			if(homeBtn) {
				HomeMenu.click();
				homeBtn=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return homeBtn;
	}


	public boolean verifyBidNameUpdated(String BidName) throws Exception{
		boolean homeBtn= false;
		try {
			homeBtn= driver.findElement(By.xpath("(//*[text()='"+BidName+"'])[1]")).isDisplayed();
			homeBtn= homeBtn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return homeBtn;
	}



	public void VerifyDragAndDrop(){
		try{
         // locate the drop area
// drop the file
			//DropFile(new File("D:\\Doc\\TestOne1.odt"), dragFilesArea, 0, 0);
			Thread.sleep(10000);

			WebElement mainMenu = driver.findElement(By.xpath("//*[text()='Drag files here to upload']"));
			WebElement filePath = driver.findElement(By.xpath("//a[text()='TestOne1' and @class='ms-listlink ms-draggable']"));
			//Create object 'action' of an Actions class
			//To mouseover on main menu
			Actions builder = new Actions(driver);
			Actions dragAndDrop = (Actions) builder.clickAndHold(filePath)
					.moveToElement(filePath)
					.release(mainMenu).build();

			dragAndDrop.perform();

			boolean element = driver.findElement(By.xpath("//span[@id='WebPartWPQ7_ms-dnd-dropboxText']")).isEnabled();
			if(element){
				System.out.println("TrueTrueTrueTrueTrueTrueTrue");
			}else {

				System.out.println("falsefalsefalsefalsefalsefalse");
			}
			Thread.sleep(10000);


/*


			WebElement element = driver.findElement(By.xpath("//span[@id='WebPartWPQ7_ms-dnd-dropboxText']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
// Setting value for "style" attribute to make textbox visible
			js.executeScript("arguments[0].style.display='block';", element);
			element.sendKeys("D:\\Doc\\TestOne1.odt");
			Thread.sleep(10000);
*/






		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {

		//if(!filePath.exists())
			/*throw new WebDriverException("File not found: " + filePath.toString());
		 WebDriver driver =
		 System.out.println("+------------------>>"+ driver);
		//Main Menus
		WebElement mainMenu = driver.findElement(By.xpath("//span[@id='WebPartWPQ7_ms-dnd-dropboxText']"));
		//Create object 'action' of an Actions class
		Actions actions = new Actions(driver);
		//To mouseover on main menu
		actions.moveToElement(mainMenu);


		if(WrapsElement.class.isAssignableFrom(target.getClass()))
			driver = (RemoteWebDriver) ((WrapsDriver)((WrapsElement)target).getWrappedElement()).getWrappedDriver();
		else
			driver = (RemoteWebDriver) ((WrapsDriver)target).getWrappedDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String JS_DROP_FILE =
				"var target = arguments[0]," +
						"    offsetX = arguments[1]," +
						"    offsetY = arguments[2]," +
						"    document = target.ownerDocument || document," +
						"    window = document.defaultView || window;" +
						"" +
						"var input = document.createElement('INPUT');" +
						"input.type = 'file';" +
						"input.style.display = 'none';" +
						"input.onchange = function () {" +
						"  var rect = target.getBoundingClientRect()," +
						"      x = rect.left + (offsetX || (rect.width >> 1))," +
						"      y = rect.top + (offsetY || (rect.height >> 1))," +
						"      dataTransfer = { files: this.files };" +
						"" +
						"  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
						"    var evt = document.createEvent('MouseEvent');" +
						"    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
						"    evt.dataTransfer = dataTransfer;" +
						"    target.dispatchEvent(evt);" +
						"  });" +
						"" +
						"  setTimeout(function () { document.body.removeChild(input); }, 25);" +
						"};" +
						"document.body.appendChild(input);" +
						"return input;";

		WebElement input =  (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
		//Sub Menu
		WebElement subMenu = driver.findElement(By.xpath("//div[@id='ms-dnd-dropbox']"));
		//To mouseover on sub menu
		actions.moveToElement(subMenu);
		//build() method is used to compile all the actions into a single step
		actions.click().build().perform();
		input.sendKeys(filePath.getAbsoluteFile().toString());
		wait.until(ExpectedConditions.stalenessOf(input));
		System.out.println("working this block of code");*/





	}


}
