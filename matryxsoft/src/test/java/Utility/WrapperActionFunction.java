package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

public class WrapperActionFunction {

	//ApplicationUtility applicationutility = new ApplicationUtility();
	public String errmsg = null;
	public WebElement webelement;
	public WebDriver driver=null;
	private Wait<WebDriver> wait;
	private final static Logger LOGGER = Logger.getLogger(WrapperActionFunction.class.getName());

	public WebDriver InvokeBrowser(String sBrowserType) {
		//WebDriver driver = null;

		switch (sBrowserType.toLowerCase()) {
		case "chrome":

			// Set path for Chrome Driver executable
			System.setProperty("webdriver.chrome.driver", "D:/Selenium/lib/chromedriver.exe");

			driver = new ChromeDriver();

			break;

		case "ie":

			// Set path for IE Driver executable
			System.setProperty("webdriver.ie.driver", "D:/Selenium/lib/IEDriverServer.exe");

			// Launch InternetDriverServer
			driver = new InternetExplorerDriver();

			break;

		case "firefox":

			// Set path for firefox Driver executable
			System.setProperty("webdriver.gecko.driver", "D:/Selenium/lib/geckodriver.exe");

			driver = new FirefoxDriver();

			break;

		}
		return driver;

	}

	public void startBrowser(WebDriver driver, String url) throws Exception {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		if (isAlertPresent(driver)) {
			driver.switchTo().alert();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isElementPresent(WebDriver driver, String locator) throws Exception {
		List<WebElement> arrElements = findElements(driver, locator);
		if (arrElements.size() > 0) {
			return true;
		}
		return false;
	}

	public List<WebElement> findElements(WebDriver driver, String locator) {
		List<WebElement> webelements = null;
		if (locator != null) {
			String[] arrLocator = locator.split("==");
			String locatorTag = arrLocator[0].trim();
			String objectLocator = arrLocator[1].trim();

			if (locatorTag.equalsIgnoreCase("id")) {
				webelements = driver.findElements(By.id(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("name")) {
				webelements = driver.findElements(By.name(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("xpath")) {
				webelements = driver.findElements(By.xpath(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("linkText")) {
				webelements = driver.findElements(By.linkText(objectLocator));
			} else if (locatorTag.equalsIgnoreCase("class")) {
				webelements = driver.findElements(By.className(objectLocator));
			} else {
				System.out.println("Please Check the Locator Syntax Given :" + locator);
				// WrapperActions.logMessage("Please Check the Locator Syntax(Path) Given :
				// "+locator, "Element not found.","failed");
				String error = "Please Check the Locator Syntax Given :" + locator;
				error = error.replaceAll("'", "\"");
				// error = Report.getErrorMsg() + ";" + error;
				// Report.setErrorMsg(error);
				return null;
			}
		}
		return webelements;
	}

	public boolean isElementPresent(WebDriver driver, String message, String field) {
		try {
			WebElement element = null;
			element = findElement(driver, field);
			if (element != null && field != null) {
				//applicationutility.logMessage("Element found", message + " should be displayed.",
						//message + " is displayed.", "Pass");
				return true;
			} else {
				//applicationutility.logMessage("Element not found", message + " should be displayed.",
						//message + " is not displayed.", "fail");
				return false;
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception :", e);
			//applicationutility.logMessage("Exception caught", message + " should be displayed.",
				//	"Exception occurred.Exception : " + e.getMessage(), "fail");
			return false;
		}
	}

	public WebElement findElement(WebDriver driver, String locator) {
		WebElement webelement = null;
		if (locator != null) {
			String[] arrLocator = locator.split("==");
			String locatorTag = arrLocator[0].trim();
			String objectLocator = arrLocator[1].trim();
			try {
				if (locatorTag.equalsIgnoreCase("id")) {
					webelement = driver.findElement(By.id(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("name")) {
					webelement = driver.findElement(By.name(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("xpath")) {
					webelement = driver.findElement(By.xpath(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("linkText")) {
					webelement = driver.findElement(By.linkText(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("class")) {
					webelement = driver.findElement(By.className(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("value")) {
					webelement = driver.findElement(By.xpath(objectLocator));
				} else {
					String error = "Please Check the Given Locator Syntax :" + locator;
					error = error.replaceAll("'", "\"");
					// error = Report.getErrorMsg() + ";" + error;
					// Report.setErrorMsg(error);

					return null;
				}
			} catch (Exception exception) {
				// exception.printStackTrace();
				String error = "Please Check the Given Locator Syntax :" + locator;
				System.out.println("error==" + error);
				error = error.replaceAll("'", "\"");
				// error = Report.getErrorMsg() + ";" + error;
				// Report.setErrorMsg(error);
				return null;
			}
		}
		return webelement;
	}

	public String getText(WebDriver driver, String locator) {
		WebElement element;
		String text = "NO VALUE RETRIVED";
		try {
			element = findElement(driver, locator, true);
			if (element != null) {
				text = element.getText();
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception :", e);
		}
		element = null;
		return text;
	}

	public WebElement findElement(WebDriver driver, String locator, boolean val) {
		WebElement webelement = null;
		if (locator != null) {
			String[] arrLocator = locator.split("==");
			String locatorTag = arrLocator[0].trim();
			String objectLocator = arrLocator[1].trim();
			try {
				if (locatorTag.equalsIgnoreCase("id")) {
					webelement = driver.findElement(By.id(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("name")) {
					webelement = driver.findElement(By.name(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("xpath")) {
					webelement = driver.findElement(By.xpath(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("linkText")) {
					webelement = driver.findElement(By.linkText(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("class")) {
					webelement = driver.findElement(By.className(objectLocator));
				} else if (locatorTag.equalsIgnoreCase("tagname")) {
					webelement = driver.findElement(By.tagName(objectLocator));
				}
			} catch (Exception exception) {
				return null;
			}
		}
		return webelement;
	}

	public static void shutDownDriver(WebDriver driver) {
		if (driver != null)
			driver.quit();
	}

	public void click(WebDriver driver, String field) throws Exception {
		WebElement element = findElement(driver, field);
		element.click();
	}

	public void clearText(WebDriver driver, String field) {
		try {
			WebElement element = findElement(driver, field);
			element.clear();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception :", e);
		}
	}

	public void enterText(WebDriver driver, String field, String value) {

		try {
			WebElement element = findElement(driver, field);
			element.sendKeys(value);

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception :", e);
		}
	}

	public void waitInSeconds(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			LOGGER.log(Level.SEVERE, "Exception :", e);

		}
	}

	/********************************************************************************************
	 * @Function_Name : FindSysTimeExecution
	 * @Description : Find systime in specified format
	 * 
	 ***************************************************************************************/

	public static String FindSysTimeExecution() {

		SimpleDateFormat SysDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return SysDate.format(cal.getTime());

		// return SysDate;
	}

	public static String getCurrentTime(long tcStartTime) {
		String todayTime = "";
		SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("dd-MM-yyyy");
		String todayDate = DATE_FORMAT1.format(new Date());
		Date d1 = new Date(tcStartTime);
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh-mm-ss");
		String time = DATE_FORMAT.format(d1);
		todayTime = todayDate + "-" + time;

		return todayTime;
	}

	/************************* IBM Utility Functions *************************/

	/*
	 * Function Name : isElementEnabled () Description : Verifies whether the
	 * element is enabled Parameters : sTextToBeSelected, if so returns true Author
	 * & Date : Lokesh 02/04/2016 Modified Date :
	 */
	public boolean isElementEnabled(WebElement wObject) throws Exception {

		if (wObject.isEnabled()) {
			return true;
		}
		return false;
	}

	/*
	 * Function Name : selectFromDropDown Description : Selects required text from
	 * Dropdown Parameters : sTextToBeSelected Author & Date : Lokesh 02/04/2016
	 * Modified Date :
	 */
	public void selectFromDropDown(WebElement wObject, String sTextToBeSelected) {
		String sSelectedValue = null;
		String errmsg = null;
		try {
			System.out.println(sTextToBeSelected);
			Select selRequiredText = new Select(wObject);
			// sSelectedValue = selRequiredText.getFirstSelectedOption().getText();
			selRequiredText.selectByVisibleText(sTextToBeSelected);
			// System.out.println(sSelectedValue);

			/*
			 * if (sSelectedValue.equalsIgnoreCase(sTextToBeSelected)) {
			 * System.out.println("Expected and the selected text are the same"); } else {
			 * System.err.println("Expected Text is" +sTextToBeSelected +
			 * "and the actual text is" + sSelectedValue+ " are different"); }
			 */
		} catch (NoSuchElementException e) {
			errmsg = "Element" + sTextToBeSelected + "could not be found in the dropdownbox" + wObject.getText();
			System.err.println(errmsg);
		} catch (Exception e) {
			e.printStackTrace();
			errmsg = e.getMessage();
			if (errmsg.length() > 500) {
				errmsg = errmsg.substring(0, 500);
			}
			System.err.println(errmsg);
			Assert.assertTrue(false);
		}

	}

	/*
	 * Function Name : selectFromDropDownByIndex Description : Selects required text
	 * from Dropdown Parameters : sTextToBeSelected Author & Date : Lokesh
	 * 02/04/2016 Modified Date :
	 */
	public void selectFromDropDownByValue(WebElement wObject, String sValue) {

		String errmsg = null;
		try {
			Select selRequiredText = new Select(wObject);
			// sSelectedValue =
			// selRequiredText.getFirstSelectedOption().getAttribute("value");
			selRequiredText.selectByValue(sValue);
		} catch (NoSuchElementException e) {
			errmsg = "Element" + sValue + "could not be found in the dropdownbox" + wObject.getText();
			System.err.println(errmsg);
		} catch (Exception e) {
			e.printStackTrace();
			errmsg = e.getMessage();
			if (errmsg.length() > 500) {
				errmsg = errmsg.substring(0, 500);
			}
			System.err.println(errmsg);
			Assert.assertTrue(false);
		}

	}

	/*
	 * Function Name : selectFromDropDownByIndexFromDB Description : Selects
	 * required text from Dropdown Parameters : sTextToBeSelected Author & Date :
	 * Lokesh 02/04/2016 Modified Date :
	 */
	// public void selectFromDropDownByIndexFromDB (WebElement wObject, AppTestDTO
	// appDto)
	// {
	// String sSelectedValue = null;
	// String errmsg = null;
	// try
	// {
	// Select selRequiredText = new Select(wObject);
	// //sSelectedValue =
	// selRequiredText.getFirstSelectedOption().getAttribute("value");
	// selRequiredText.selectByIndex(Integer.parseInt(appDto.getI_HOST()));
	// }
	// catch (NoSuchElementException e)
	// {
	// errmsg = "Element"+ appDto.getI_HOST().toString() + "could not be found in
	// the dropdownbox" +wObject.getText();
	// System.err.println(errmsg);
	// }
	// catch (Exception e){
	// e.printStackTrace();
	// errmsg=e.getMessage();
	// if(errmsg.length() > 500){
	// errmsg=errmsg.substring(0,500);
	// }
	// System.err.println(errmsg);
	// Assert.assertTrue(false);
	// }
	//
	// }

	/*
	 * Function Name : selectFromDropDownByIndex Description : Selects required text
	 * from Dropdown Parameters : sTextToBeSelected Author & Date : Lokesh
	 * 02/04/2016 Modified Date :
	 */
	public void selectFromDropDownByIndex(WebElement wObject, Integer iIndex) {
		String sSelectedValue = null;
		String errmsg = null;
		try {
			Select selRequiredText = new Select(wObject);
			// sSelectedValue =
			// selRequiredText.getFirstSelectedOption().getAttribute("value");
			selRequiredText.selectByIndex(iIndex);
		} catch (NoSuchElementException e) {
			errmsg = "Element" + iIndex + "could not be found in the dropdownbox" + wObject.getText();
			System.err.println(errmsg);
		} catch (Exception e) {
			e.printStackTrace();
			errmsg = e.getMessage();
			if (errmsg.length() > 500) {
				errmsg = errmsg.substring(0, 500);
			}
			System.err.println(errmsg);
			Assert.assertTrue(false);
		}

	}

	/*
	 * Function Name : AddCookies Description : Add cookies to the given browser
	 * Parameters : wObject Author & Date : Lokesh 04/04/2016 Modified Date :
	 */

	/*
	 * Function Name : clickOnWebElement Description : click on any WebElement
	 * Parameters : wObject Author & Date : Lokesh 04/04/2016 Modified Date :
	 */
	public void clickOnWebElement(WebElement wObject) {
		try {
			if (wObject.isDisplayed()) {

				wObject.click();

				// System.out.println("Element "+ wObject.getAttribute("name") + " is clicked");
			}
		} catch (NoSuchElementException e) {
			errmsg = "Element" + wObject.getText() + "could not be found";
			System.err.println(errmsg);
		} catch (Exception e) {
			e.printStackTrace();
			String errmsg = e.getMessage();
			if (errmsg.length() > 500) {
				errmsg = errmsg.substring(0, 500);
			}
			System.err.println(errmsg);
			Assert.assertTrue(false);
		}

	}

	/*
	 * Function Name : clickOnWebElement Description : click on any WebElement
	 * Parameters : wObject Author & Date : Lokesh 04/04/2016 Modified Date :
	 */
	public String getTextFromWebElement(WebElement wObject) {
		String sText = null;
		try {
			if (wObject.isDisplayed()) {
				sText = wObject.getText();
				// System.out.println("Element "+ wObject.getAttribute("name") + " is clicked");
			}
		} catch (NoSuchElementException e) {
			errmsg = "Element" + wObject.getText() + "could not be found";
			System.err.println(errmsg);
		} catch (Exception e) {
			e.printStackTrace();
			String errmsg = e.getMessage();
			if (errmsg.length() > 500) {
				errmsg = errmsg.substring(0, 500);
			}
			System.err.println(errmsg);
			Assert.assertTrue(false);
		}
		return sText;
	}

	/*
	 * Function Name : isAlertPresent Description : checks if alert is present
	 * Parameters : Author & Date : Lokesh 26/04/2016 Modified Date :
	 */
	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (Exception e) {
			return false;
		} // catch
	}

	/*
	 * Function Name : getNextYear Description : Adds one year to the current year
	 * Parameters : NA Author & Date : Lokesh 04/04/2016 Modified Date :
	 */
	public String getNextYear() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR) + 1;
		return String.valueOf(year);
	}

	/*
	 * Function Name : waitForWebElementWithCondition Description : waits for the
	 * object to be visible Parameters : NA Author & Date : Lokesh 04/04/2016
	 * Modified Date :
	 */
	public void waitForWebElementWithCondition(WebDriver driver, final WebElement wObject) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(wObject));
	}

	/*
	 * Function Name : waitForWebElementFluently Description : waits for the object
	 * fluently Parameters : NA Author & Date : Lokesh 04/04/2016 Modified Date :
	 */
	/*public void waitForWebElementFluently(java.time.Duration iTimeout) {

		new FluentWait<WebElement>(wObject).withTimeout(iTimeout, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS).until(new Function<WebElement, Boolean>() {
					//@Override
					public Boolean apply(WebElement element) {
						return element.isEnabled();
					}
				});
	}*/

	/*
	 * Function Name : driverSetUp Description : driver set up done wrt browser type
	 * Parameters : appDto Author & Date : Lokesh 31/03/2016 Modified Date :
	 */
	public void driverSetUp(WebDriver driver, String sUrl) {
		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(sUrl);
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		} catch (Exception e) {
			e.printStackTrace();
			String errmsg = e.getMessage();
			if (errmsg.length() > 500) {
				errmsg = errmsg.substring(0, 500);
			}
			System.err.println(errmsg);
			Assert.assertTrue(false);
		}
	}

	/*
	 * Function Name : launchIEDriver Description : start IE driver with desired
	 * capabilities Parameters : appDto Author & Date : Lokesh 31/03/2016 Modified
	 * Date :
	 */
	/*public WebDriver launchIEDriver() {
		try {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IEDriverServer.exe");
			DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
			capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capab.setCapability("enablePersistentHover", true);
			capab.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			driver = new InternetExplorerDriver(capab);
		} catch (Exception e) {
			e.printStackTrace();
			String errmsg = e.getMessage();
			if (errmsg.length() > 500) {
				errmsg = errmsg.substring(0, 500);
			}
			System.err.println(errmsg);
			Assert.assertTrue(false); 
		}
		return driver;
	}*/

	/*
	 * Function Name : navigateToURL Description : navigates to the URL assigned
	 * Parameters : appDto Author & Date : Lokesh 31/03/2016 Modified Date :
	 */
	public void navigateToURL(WebDriver driver, String sURL) throws StaleElementReferenceException {
		driver.navigate().to(sURL);
		driver.manage().deleteAllCookies();
	}

	/*
	 * Function Name : switchToWindowByIndex Description : switches to a window by
	 * assigned index Parameters : appDto Author & Date : Lokesh 31/03/2016 Modified
	 * Date :
	 */
	public void switchToWindowByIndex(WebDriver driver, int iWindowToSwitch) throws StaleElementReferenceException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(iWindowToSwitch));
	}

	/*
	 * Function Name : switchToFrameByString Description : switches to a frame by
	 * assigned string Parameters : appDto Author & Date : Lokesh 31/03/2016
	 * Modified Date :
	 */
	public void switchToFrameByString(WebDriver driver, String sFrameName) throws StaleElementReferenceException {
		driver.switchTo().frame(sFrameName);
	}

	/*
	 * Function Name : switchToWindowByString Description : switches to a window by
	 * assigned string Parameters : appDto Author & Date : Lokesh 31/03/2016
	 * Modified Date :
	 */
	public boolean switchToWindowByString(WebDriver driver, String sWindowToSwitch)
			throws StaleElementReferenceException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		boolean bSwitchWindow = false;
		int a = 0;

		for (a = 0; a <= tabs.size() - 1; a++) {
			if (tabs.get(a).contains(sWindowToSwitch)) {
				driver.switchTo().window(tabs.get(a));
				bSwitchWindow = true;
				break;
			}
		}
		if (bSwitchWindow == true) {
			System.out.println("Driver is switched to the required url :" + tabs.get(a));
		} else {
			System.err.println("Driver is not switched to the required url, Expected :" + sWindowToSwitch + "actual :"
					+ tabs.get(a));
		}
		return bSwitchWindow;
	}

	/*
	 * Function Name : switchToFrameByIndex Description : switches to a frame by
	 * assigned index Parameters : appDto Author & Date : Lokesh 31/03/2016 Modified
	 * Date :
	 */
	public void switchToFrameByIndex(WebDriver driver, Integer iFrameNumber) throws StaleElementReferenceException {
		driver.switchTo().frame(iFrameNumber);
	}

	/*
	 * Function Name : pageFactorySetup Description : Initialize all PAgeFactory
	 * objects and Function wrt user Parameters : WebDriver, Wait<WebDriver> Author
	 * & Date : Lokesh 31/03/2016 Modified Date :
	 */
	/*public void pageFactorySetup(WebDriver driver, int timeout) {
		this.driver = driver;
		this.wait = new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.MILLISECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		PageFactory.initElements(driver, this);
	}*/

	/*
	 * Function Name : getCurrentdateTimeFormated Description : To get current date
	 * & time without special characters Parameters : NA Author & Date :
	 * Sreenivasulu YM 12/04/2016 Modified Date :
	 */
	public static String getCurrentdateTimeFormated() {
		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		Date dateobj = new Date();
		String sformatedDateTime = df.format(dateobj);

		return sformatedDateTime;
	}

	/*
	 * Function Name : removeDollarFromString Description : removes dollar character
	 * from string Parameters : NA Author & Date : Lokesh 14/04/2016 Modified Date :
	 */
	public String removeDollarFromString(String sDollarTobeRemoved) {
		String sTemp;
		sTemp = sDollarTobeRemoved.replace("$", "");
		return sTemp;
	}

	/*
	 * Function Name : isPageLoaded Description : Verifies the Webelement is loaded
	 * after page is loaded Parameters : wObject Author & Date : Lokesh 31/03/2016
	 * Modified Date :
	 */
	public boolean isPageLoaded(WebElement wObject) {
		Boolean bElementPresent = false;
		try {
			if (wObject.isDisplayed()) {
				bElementPresent = true;
				System.out.println("Element " + wObject.getAttribute("name") + " is loaded");
			}
		} catch (NoSuchElementException e) {
			errmsg = "Element" + wObject.getAttribute("name") + "could not be found";
			System.err.println(errmsg);
		}
		return bElementPresent;
	}

	public void rgbaToHex(String sBackgroundcolor) {
		String[] sRgbaValue = null;
		sRgbaValue = sBackgroundcolor.split(",");
		if (sRgbaValue.length != 4) {
			System.err.println("Color2Hex  r g b a is not valid");
		} else {
			int i = Integer.parseInt(sRgbaValue[0]);
			int j = Integer.parseInt(sRgbaValue[1]);
			int k = Integer.parseInt(sRgbaValue[2]);
			int l = Integer.parseInt(sRgbaValue[2]);
			Color c = new Color(i, j, k, l);
			System.out.println("hex: " + Integer.toHexString(c.getRGB() & 0x00ffffff));
		}
	}

	/*
	 * Function Name : getClipboardContents Description : To get the URL with
	 * respect to environment, country and Meeting Plan Paremreters : Webdriver,
	 * sEnvironment Author & Date : lokesh 30/04/2016 Modified Date
	 */
	public String getClipboardContents(String CopyTo) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection str = new StringSelection(CopyTo);
		clipboard.setContents(str, null);
		return CopyTo;
	}

	/*
	 * Function Name : getSubwindowHandler Description : Gets the subwindow handler
	 * Paremreters : Author & Date : lokesh 13/07/2016 Modified Date
	 */
	public String getSubwindowHandler(WebDriver driver) {
		String subWindowHandler = null;
		Set<String> windowHandler = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = windowHandler.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		return subWindowHandler;
	}

	// wait for jQuery to load
	final ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		//@Override
		public Boolean apply(final WebDriver driverbrowser) {
			final JavascriptExecutor jscript = (JavascriptExecutor) driverbrowser;
			return (Boolean) jscript.executeScript("return jQuery.active == 0");
		}
	};

	// wait for Javascript to load
	final ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
		//@Override
		public Boolean apply(final WebDriver driver) {
			return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		}
	};

}
