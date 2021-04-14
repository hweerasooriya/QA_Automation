// -------------------------------------------@copyright_Harshani------------------------------------
// PROJECT        : Test Automation-Biofourmis
// PRODUCT        : Sample
// VERSION        : 1.0
// REMARKS        :
// -------------------------------------------------------------------------------

package com.biofourmis.cucumber.helpers;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.biofourmis.cucumber.pageObject.WebPageObject;

public class SetElements extends WebPageObject {

	static Logger log = Logger.getLogger("LOG");
	public static int iImageCounter = 1;

	public static void SelectDropDownByDescription(String get, String get0) {

		String xpath = ".//*[@id='" + get + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {

			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");

			force_to_wait();

			Select DropDown = new Select(driver.findElement(By.xpath(xpath))); // 2
			DropDown.selectByVisibleText(get0);

		}

		else {

			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(By.id(get)).getLocation().y + ")");
			SetElements.waitElementLoadingById(get, Constants.TIME_OUT_PERIOD);

			force_to_wait();
			Select DropDown = new Select(driver.findElement(By.id(get))); // 2
			DropDown.selectByVisibleText(get0);
		}

		
	}

	public SetElements(WebDriver driver) {
		super(driver);

	}

	public static void setElement(String sType, String sText, String sId) {

		String xpath = ".//*[@id='" + sId + "']";
		// String xpath=".//input[@name='"+sId+"']";
		String CSS = "#" + sId;

		if (!sType.equalsIgnoreCase("C")) {

			if (!Validation.isEmpty(sText)) {

				if (Constants.TYPE_TEXT.equalsIgnoreCase(sType)) {

					if (Constants.TEST_BROWSER_IE.equals("Y")) {

						SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
						((JavascriptExecutor) driver).executeScript(
								"window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");
						driver.findElement(By.xpath(xpath)).clear();

						force_to_wait();

						driver.findElement(By.xpath(xpath)).sendKeys(sText);

					}

					else {
						SetElements.waitElementLoadingById(sId, Constants.TIME_OUT_PERIOD);
						((JavascriptExecutor) driver).executeScript(
								"window.scrollTo(0," + driver.findElement(By.id(sId)).getLocation().y + ")");

						force_to_wait();

						driver.findElement(By.id(sId)).clear();
						driver.findElement(By.id(sId)).sendKeys(sText);

					}

				}

				if (Constants.TYPE_DROP_DOWN.equalsIgnoreCase(sType)) {

					if (Constants.TEST_BROWSER_IE.equals("Y")) {

						System.out.println("Asanka Debug Finding Element located xpath " + xpath);

						SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
						((JavascriptExecutor) driver).executeScript(
								"window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");

						force_to_wait();

						Select DropDown = new Select(driver.findElement(By.xpath(xpath))); // 2
						DropDown.selectByValue(sText);
						System.out
								.println(" Debug Find Element located Xpath " + xpath + "Select Value " + sText);

					}

					else {
						((JavascriptExecutor) driver).executeScript(
								"window.scrollTo(0," + driver.findElement(By.id(sId)).getLocation().y + ")");
						SetElements.waitElementLoadingById(sId, Constants.TIME_OUT_PERIOD);

						try {
							Select DropDown = new Select(driver.findElement(By.id(sId))); // 2

							force_to_wait();
							DropDown.selectByValue(sText);

						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				}

				if (Constants.TYPE_RADIO_BOX.equalsIgnoreCase(sType)) {

					if (Constants.TEST_BROWSER_IE.equals("Y")) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						List<WebElement> rdBtn = driver.findElements(By.xpath(xpath));
						int iSize = rdBtn.size();
						System.out.println("rdBtn.size() ================ " + iSize);
						String sValue = "";
						for (int i = 0; i < iSize; i++) {
							// Store the Check Box name to the string variable,
							// using 'Value' attribute
							sValue = rdBtn.get(i).getAttribute("value");
							System.out.println("sValue " + sValue);
							System.out.println("sText " + sText);
							// Select the Check Box it the value of the Check
							// Box is same what you are looking for

							force_to_wait();
							if (sValue.equalsIgnoreCase(sText)) {
								rdBtn.get(i).click();
								break;
							}

						}
					}

					// Start the loop from first Check Box to last Check Boxe

					else {
						List<WebElement> rdBtn = driver.findElements(By.id(sId));
						int iSize = rdBtn.size();
						System.out.println("rdBtn.size() ================ " + iSize);
						String sValue = "";

						// Start the loop from first Check Box to last Check
						// Boxe
						for (int i = 0; i < iSize; i++) {
							// Store the Check Box name to the string variable,
							// using 'Value' attribute
							sValue = rdBtn.get(i).getAttribute("value");
							System.out.println("sValue " + sValue);
							System.out.println("sText " + sText);
							// Select the Check Box it the value of the Check
							// Box is same what you are looking for
							force_to_wait();

							if (sValue.equalsIgnoreCase(sText)) {
								rdBtn.get(i).click();
								break;
							}

						}

					}
				}

			}

		} else if (Constants.TYPE_CHECK_BOX.equalsIgnoreCase(sType))

		{

			if (Constants.TEST_BROWSER_IE.equals("Y"))

			{

				SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
				((JavascriptExecutor) driver).executeScript(
						"window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");
				force_to_wait();
				driver.findElement(By.xpath(xpath)).click();
			}

			else {
				SetElements.waitElementLoadingById(sId, Constants.TIME_OUT_PERIOD);
				((JavascriptExecutor) driver)
						.executeScript("window.scrollTo(0," + driver.findElement(By.id(sId)).getLocation().y + ")");
				force_to_wait();
				driver.findElement(By.id(sId)).click();
			}

		}

		else if (Constants.TYPE_RADIO_BOX.equalsIgnoreCase(sType))

		{
			if (Constants.TEST_BROWSER_IE.equals("Y")) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<WebElement> rdBtn = driver.findElements(By.id(sId));
				int iSize = rdBtn.size();
				for (int i = 0; i < iSize; i++) {
					// Store the Check Box name to the string variable, using
					// 'Value' attribute
					String sValue = rdBtn.get(i).getAttribute("value");
					// Select the Check Box it the value of the Check Box is
					// same what you are looking for
					if (sValue.equalsIgnoreCase(sText)) {
						force_to_wait();
						rdBtn.get(i).click();
						break;
					}
				}
			}

			else {
				List<WebElement> rdBtn = driver.findElements(By.id(sId));
				int iSize = rdBtn.size();
				for (int i = 0; i < iSize; i++) {
					// Store the Check Box name to the string variable, using
					// 'Value' attribute
					String sValue = rdBtn.get(i).getAttribute("value");
					// Select the Check Box it the value of the Check Box is
					// same what you are looking for
					if (sValue.equalsIgnoreCase(sText)) {
						force_to_wait();
						rdBtn.get(i).click();
						break;
					}
				}
			}

			// Start the loop from first Check Box to last Check Boxe

			//
		}
	}

	private static void force_to_wait() {
		try {
			Thread.sleep(Constants.waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void setElementByVisibleText(String sType, String sText, String sId) {

		String xpath = ".//*[@id='" + sId + "']";

		if (!sType.equalsIgnoreCase("C")) {

			if (!Validation.isEmpty(sText)) {
				if (Constants.TYPE_DROP_DOWN.equalsIgnoreCase(sType)) {

					if (Constants.TEST_BROWSER_IE.equals("Y")) {

						SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
						Select DropDown = new Select(driver.findElement(By.xpath(xpath))); // 2
						force_to_wait();
						DropDown.selectByVisibleText(sText);
					}

					else {
						SetElements.waitElementLoadingById(sId, Constants.TIME_OUT_PERIOD);
						Select DropDown = new Select(driver.findElement(By.id(sId))); // 2
						force_to_wait();
						DropDown.selectByVisibleText(sText);
					}

				}
			}

		} else if (Constants.TYPE_CHECK_BOX.equalsIgnoreCase(sType))

		{

			if (Constants.TEST_BROWSER_IE.equals("Y"))

			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
				force_to_wait();
				driver.findElement(By.id(xpath)).click();
			}

			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			force_to_wait();
			driver.findElement(By.xpath(xpath)).click();

		} else if (Constants.TYPE_RADIO_BOX.equalsIgnoreCase(sType)) {

			if (Constants.TEST_BROWSER_IE.equals("Y")) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				List<WebElement> rdBtn = driver.findElements(By.xpath(xpath));
				int iSize = rdBtn.size();

				// Start the loop from first Check Box to last Check Boxe
				for (int i = 0; i < iSize; i++) {
					// Store the Check Box name to the string variable, using
					// 'Value' attribute
					String sValue = rdBtn.get(i).getAttribute("value");
					// Select the Check Box it the value of the Check Box is
					// same what you are looking for
					if (sValue.equalsIgnoreCase(sText)) {
						force_to_wait();
						rdBtn.get(i).click();
						break;
					}
				}
			}

			else {
				List<WebElement> rdBtn = driver.findElements(By.id(sId));
				int iSize = rdBtn.size();

				// Start the loop from first Check Box to last Check Boxe
				for (int i = 0; i < iSize; i++) {
					// Store the Check Box name to the string variable, using
					// 'Value' attribute
					String sValue = rdBtn.get(i).getAttribute("value");
					// Select the Check Box it the value of the Check Box is
					// same what you are looking for
					if (sValue.equalsIgnoreCase(sText)) {
						rdBtn.get(i).click();
						break;
					}
				}
			}

			//
		}

	}

	public static void setElementByName(String sType, String sText, String sId) {

		String xpath = ".//*[@name='" + sId + "']";

		if (!sType.equalsIgnoreCase("C")) {

			if (!Validation.isEmpty(sText)) {

				if (Constants.TYPE_TEXT.equalsIgnoreCase(sType)) {

					if (Constants.TEST_BROWSER_IE.equals("Y")) {

						SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
						driver.findElement(By.xpath(xpath)).clear();
						force_to_wait();
						driver.findElement(By.xpath(xpath)).sendKeys(sText);
					}

					else {
						SetElements.waitElementLoadingByName(sId, Constants.TIME_OUT_PERIOD);
						driver.findElement(By.name(sId)).clear();
						force_to_wait();
						driver.findElement(By.name(sId)).sendKeys(sText);
					}

				}

				if (Constants.TYPE_DROP_DOWN.equalsIgnoreCase(sType)) {

					if (Constants.TEST_BROWSER_IE.equals("Y")) {

						SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
						Select DropDown = new Select(driver.findElement(By.xpath(xpath))); // 2
						force_to_wait();
						DropDown.selectByValue(sText);
					}

					else {
						SetElements.waitElementLoadingByName(sId, Constants.TIME_OUT_PERIOD);
						Select DropDown = new Select(driver.findElement(By.name(sId))); // 2
						force_to_wait();
						DropDown.selectByValue(sText);
					}

				}

				if (Constants.TYPE_RADIO_BOX.equalsIgnoreCase(sType)) {

					if (Constants.TEST_BROWSER_IE.equals("Y")) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						List<WebElement> rdBtn = driver.findElements(By.xpath(xpath));
						int iSize = rdBtn.size();
						System.out.println("rdBtn.size() ================ " + iSize);
						// Start the loop from first Check Box to last Check
						// Boxe
						for (int i = 0; i < iSize; i++) {
							// Store the Check Box name to the string variable,
							// using 'Value' attribute
							String sValue = rdBtn.get(i).getAttribute("value");
							System.out.println("sValue " + sValue);
							System.out.println("sText " + sText);
							// Select the Check Box it the value of the Check
							// Box is same what you are looking for
							if (sValue.equalsIgnoreCase(sText)) {
								force_to_wait();
								rdBtn.get(i).click();

								break;
							}
						}
					}

					else {
						List<WebElement> rdBtn = driver.findElements(By.name(sId));
						int iSize = rdBtn.size();
						System.out.println("rdBtn.size() ================ " + iSize);
						// Start the loop from first Check Box to last Check
						// Boxe
						for (int i = 0; i < iSize; i++) {
							// Store the Check Box name to the string variable,
							// using 'Value' attribute
							String sValue = rdBtn.get(i).getAttribute("value");
							System.out.println("sValue " + sValue);
							System.out.println("sText " + sText);
							// Select the Check Box it the value of the Check
							// Box is same what you are looking for
							if (sValue.equalsIgnoreCase(sText)) {
								force_to_wait();
								rdBtn.get(i).click();
								break;
							}
						}
					}

				}

			}

		} else if (Constants.TYPE_CHECK_BOX.equalsIgnoreCase(sType))

		{

			if (Constants.TEST_BROWSER_IE.equals("Y")) {

				SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
				force_to_wait();
				driver.findElement(By.xpath(xpath)).click();
			}

			else {
				SetElements.waitElementLoadingByName(sId, Constants.TIME_OUT_PERIOD);
				force_to_wait();
				driver.findElement(By.name(sId)).click();
			}

		} else if (Constants.TYPE_RADIO_BOX.equalsIgnoreCase(sType)) {

			if (Constants.TEST_BROWSER_IE.equals("Y")) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				List<WebElement> rdBtn = driver.findElements(By.xpath(xpath));
				int iSize = rdBtn.size();
				System.out.println("rdBtn.size() ================ " + iSize);
				// Start the loop from first Check Box to last Check Boxe
				for (int i = 0; i < iSize; i++) {
					// Store the Check Box name to the string variable, using
					// 'Value' attribute
					String sValue = rdBtn.get(i).getAttribute("value");
					System.out.println("sValue " + sValue);
					System.out.println("sText " + sText);
					// Select the Check Box it the value of the Check Box is
					// same what you are looking for
					if (sValue.equalsIgnoreCase(sText)) {
						force_to_wait();

						rdBtn.get(i).click();
						break;
					}
				}
			}

			else {
				List<WebElement> rdBtn = driver.findElements(By.name(sId));
				int iSize = rdBtn.size();
				System.out.println("rdBtn.size() ================ " + iSize);
				// Start the loop from first Check Box to last Check Boxe
				for (int i = 0; i < iSize; i++) {
					// Store the Check Box name to the string variable, using
					// 'Value' attribute
					String sValue = rdBtn.get(i).getAttribute("value");
					System.out.println("sValue " + sValue);
					System.out.println("sText " + sText);
					// Select the Check Box it the value of the Check Box is
					// same what you are looking for
					if (sValue.equalsIgnoreCase(sText)) {
						force_to_wait();

						rdBtn.get(i).click();
						break;
					}
				}
			}

			//
		}

	}

	public static void waitElementLoadingById(String sId, long TimeOutSeconds) {

		String xpath = ".//*[@id='" + sId + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}

		else {
			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(sId)));
		}

	}

	public static void waitElementLoadingByName(String sName, long TimeOutSeconds) {

		String xpath = ".//*[@name='" + sName + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}

		else {
			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(sName)));
		}

	}

	public static void waitElementLoadingByLinkText(String sLinkText, long TimeOutSeconds) {

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(sLinkText)));
		}

		else {
			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(sLinkText)));
		}

	}

	public static void waitElementLoadingByXpath(String xPath, long TimeOutSeconds) {
		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));

		}

	}

	public static void waitElementLoadingByTagName(String sTagName, long TimeOutSeconds) {

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(sTagName)));
		}

	}

	public static void waitElementLoadingByCssSelector(String CssSelector, long TimeOutSeconds) {
		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CssSelector)));
		}
	}

	public static void waitElementLoadingByTextContains(String Text, long TimeOutSeconds) {
		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			WebDriverWait wait = new WebDriverWait(driver, TimeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Text)));
		}
	}

	public static void clickElementByName(String sName) {

		String xpath = ".//*[@name='" + sName + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			force_to_wait();
			driver.findElement(By.xpath(xpath)).click();
		}

		else {
			SetElements.waitElementLoadingByName(sName, Constants.TIME_OUT_PERIOD);
			force_to_wait();
			driver.findElement(By.name(sName)).click();
		}

	}

	public static void clickElementById(String sId) {
		String xpath = ".//*[@id='" + sId + "']";
		// String xpath=".//input[@type='"+sId+"']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");
			force_to_wait();
			driver.findElement(By.xpath(xpath)).click();
		}

		else {
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(By.id(sId)).getLocation().y + ")");
			SetElements.waitElementLoadingById(sId, Constants.TIME_OUT_PERIOD);

			force_to_wait();
			driver.findElement(By.id(sId)).click();
		}

	}

	public static void clickElementByLinkText(String sLinkText) {
		SetElements.waitElementLoadingByLinkText(sLinkText, Constants.TIME_OUT_PERIOD);
		force_to_wait();
		driver.findElement(By.linkText(sLinkText)).click();
	}

	public static void SetimageByID(String sId) {
		SetElements.waitElementLoadingById(sId, Constants.TIME_OUT_PERIOD);
		force_to_wait();
		driver.findElement(By.id(sId)).sendKeys("E:\\images1.jpg");
	}

	public static void clickElementByXpath(String xPath) {

		SetElements.waitElementLoadingByXpath(xPath, Constants.TIME_OUT_PERIOD);
		((JavascriptExecutor) driver)
				.executeScript("window.scrollTo(0," + driver.findElement(By.xpath(xPath)).getLocation().y + ")");
		force_to_wait();
		driver.findElement(By.xpath(xPath)).click();
	}

	public static void clickElementTageName(String sTagName) {
		SetElements.waitElementLoadingByTagName(sTagName, Constants.TIME_OUT_PERIOD);
		force_to_wait();
		driver.findElement(By.tagName(sTagName)).click();
	}

	public static void ClickElementCssSelector(String CssSelector) {
		SetElements.waitElementLoadingByCssSelector(CssSelector, Constants.TIME_OUT_PERIOD);
		force_to_wait();
		driver.findElement(By.cssSelector(CssSelector)).click();

	}

	public static String getElementTextById(String id) {
		String xpath = ".//*[@id='" + id + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			SetElements.waitElementLoadingById(id, Constants.TIME_OUT_PERIOD);
			return driver.findElement(By.id(id)).getText();
		}

		else {
			SetElements.waitElementLoadingById(id, Constants.TIME_OUT_PERIOD);
			return driver.findElement(By.id(id)).getText();
		}

	}

	public static String getElementTextByClass(String CssSelector) {
		SetElements.waitElementLoadingByCssSelector(CssSelector, Constants.TIME_OUT_PERIOD);
		force_to_wait();
		return driver.findElement(By.cssSelector(CssSelector)).getText();
	}

	public static void getElementClickContain(String Text) {
		String xpath = ".//*[contains(text(),'" + Text + "']";
		// *[contains(text(),'TAVR Swivel Floor TV Stand Mount for 32 to 65 inch
		// LCD LED Flat/Curved Screen TVs,Universal TV Mount Stand with
		// Adjustable Shelf,Tall Television Stand with Cable Management
		// ，Black')]
		SetElements.waitElementLoadingByTextContains(xpath, Constants.TIME_OUT_PERIOD);
		force_to_wait();
		driver.findElement(By.xpath(xpath)).click();
	}

	public static String getElementTextByXpath(String xPath) {
		SetElements.waitElementLoadingByXpath(xPath, Constants.TIME_OUT_PERIOD);
		return driver.findElement(By.xpath(xPath)).getText();

	}

	public static String getElementTextByTagName(String sTagName) {
		SetElements.waitElementLoadingByTagName(sTagName, Constants.TIME_OUT_PERIOD);
		return driver.findElement(By.tagName(sTagName)).getText();

	}

	public static void delayWebDriver(long Seconds) {
		driver.manage().timeouts().implicitlyWait(Seconds, TimeUnit.SECONDS);
	}

	public static boolean isCheckBoxSelected(String sId) {

		String xpath = ".//*[@id='" + sId + "']";
		boolean bCheck = false;

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			WebElement checkBox1 = driver.findElement(By.xpath(xpath));
			if (checkBox1.isSelected()) {
				bCheck = true;
			}

			return bCheck;
		}

		else {
			SetElements.waitElementLoadingById(sId, Constants.TIME_OUT_PERIOD);
			WebElement checkBox1 = driver.findElement(By.id(sId));
			if (checkBox1.isSelected()) {
				bCheck = true;
			}

			return bCheck;
		}

	}

	public static void SelectDropDownByIndex(String sId, int iIndex) {
		String xpath = ".//*[@id='" + sId + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.xpath(xpath))); // 2
			force_to_wait();
			DropDown.selectByIndex(iIndex);
		}

		else {
			SetElements.waitElementLoadingById(sId, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.id(sId))); // 2
			DropDown.selectByIndex(iIndex);
		}

	}

	public static void SelectDropDownByIndexAndXpath(String xpath, int iIndex) {

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.xpath(xpath))); // 2
			force_to_wait();
			DropDown.selectByIndex(iIndex);
		}

		else {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.xpath(xpath))); // 2
			force_to_wait();
			DropDown.selectByIndex(iIndex);
		}

	}

	/**
	 * Click first check box element out of check box list
	 */
	public static void clickFirstCheckBoxElement() {
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		if (!checkboxes.get(0).isSelected()) {
			force_to_wait();
			checkboxes.get(0).click();
		}
	}

	/**
	 * Click first Redio element out of check box list
	 */
	public static void clickFirstRedioElement() {
		List<WebElement> radio = driver.findElements(By.cssSelector("input[type='radio']"));
		force_to_wait();
		radio.get(0).click();
	}

	public static void clickFirstRadioElementById(String SId) {

		String xpath = ".//*[@id='" + SId + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			List<WebElement> radio = driver.findElements(By.xpath(xpath));
			force_to_wait();
			radio.get(0).click();
		}

		else {
			waitElementLoadingById(SId, Constants.TIME_OUT_PERIOD);
			List<WebElement> radio = driver.findElements(By.id(SId));
			force_to_wait();
			radio.get(0).click();
		}

	}

	/**
	 * Click first Detail link element out of detail link list
	 */
	public static void clickFirstDetailLink() {
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			if (link.getText().equals("Details")) {
				force_to_wait();
				link.click();
				break;
			}
		}
	}

	/**
	 * Click Detail link by parameter value out of detail link list :
	 * <a href="javascript://" onclick="submitformCard('2207')">Details</a>
	 */
	public static void clickDetailLinkByParam(String param) {
		driver.findElement(By.cssSelector("a[onclick*='submitformCard'][onclick*='" + param + "']")).click();
	}

	/**
	 * check for blank page
	 */
	public static void checkBlankPage() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.TIME_OUT_PERIOD);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("div")));
		} catch (Exception e) {
			e.printStackTrace();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			if (jse instanceof WebDriver) {
				jse.executeScript("window.history.go(-1)");
			} else {
				throw new IllegalStateException("This driver does not support JavaScript!");
			}
			assertTrue("Blank page", false);
		}
	}

	// --iCore
	// functions----------------------------------------------------------------------------------
	/**
	 * Click first element of List box
	 * 
	 */

	/*
	 * public static boolean clickSelectBoxItems(String tableName,String
	 * sTextToMatch ) { boolean bClicked=false; try { List<WebElement> listItems
	 * = driver.findElements(By.cssSelector("select[name='"+tableName+"']"));
	 * if(listItems.size()>0) {
	 * 
	 * SetElements.waitElementLoadingByName(sId, Constants.TIME_OUT_PERIOD);
	 * Select DropDown = new Select(driver.findElement(By.name(sId)));
	 * DropDown.selectByIndex(iIndex);
	 * 
	 * WebElement anchorlink = link.findElement(By.tagName("td"));
	 * sTemResult=anchorlink.getText(); if(sTemResult!=null &&
	 * sTemResult.contains(sMatchString.trim())) { bFound=true; break; }
	 * 
	 * for (int i = 0; i < listItems.size(); i++) //////////////// {
	 * 
	 * WebElement link = listItems.get(i);
	 * System.out.println("link.getText()"+link.getText());
	 * if(link.getText().contains(sTextToMatch)) { link.click(); bClicked=true;
	 * break; } } }else { bClicked=false; } }catch(Exception e){
	 * e.printStackTrace(); } return bClicked; }
	 */

	/**
	 * Click first tree element link matching the given link-text
	 * 
	 */
	public static void clickFirstTreeItem(String sLinkText) {
		waitElementLoadingByLinkText(sLinkText, Constants.TIME_OUT_PERIOD * 2);
		List<WebElement> listItems = driver.findElements(By.cssSelector("li[role='treeitem']"));

		for (WebElement link : listItems) {
			WebElement anchorlink = link.findElement(By.tagName("a"));
			if (anchorlink != null && sLinkText.equals(anchorlink.getText())) {
				force_to_wait();
				anchorlink.click();
				break;
			}
		}
	}

	/**
	 * Click first link matching the given link-text
	 * 
	 */
	public static void clickFirstDetailLink(String sLinkType) {
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			if (link.getText().equals(sLinkType)) {
				force_to_wait();
				link.click();
				break;
			}
		}
	}

	/**
	 * Click all links matching the given link-text
	 * 
	 */
	public static void clickAllDetailLinks(String sLinkType) {
		try {
			List<WebElement> links = driver.findElements(By.tagName("a"));

			for (WebElement link : links) {

				force_to_wait();
				clickFirstDetailLink(sLinkType);
				delayWebDriver(5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Click item from an drop down by selecting select element by name
	 * 
	 */
	public static void SelectNamedDropDownByIndex(String sId, int iIndex) {

		String xpath = ".//*[@name='" + sId + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.xpath(xpath)));
			force_to_wait();
			DropDown.selectByIndex(iIndex);
		}

		else {
			SetElements.waitElementLoadingByName(sId, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.name(sId)));
			force_to_wait();
			DropDown.selectByIndex(iIndex);
		}

	}

	public static void SelectNamedDropDownByVisibleText(String Text, String Sid) {
		String xpath = ".//*[@name='" + Sid + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.xpath(xpath)));
			force_to_wait();
			DropDown.selectByVisibleText(Text);
		}

		else {
			SetElements.waitElementLoadingByName(Sid, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.name(Sid)));
			force_to_wait();
			DropDown.selectByVisibleText(Text);
		}

	}

	public static void SelectNamedDropDownByValue(String Text, String Sid) {
		String xpath = ".//*[@name='" + Sid + "']";

		if (Constants.TEST_BROWSER_IE.equals("Y")) {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.xpath(xpath)));
			force_to_wait();
			DropDown.selectByValue(Text);
		}

		else {
			SetElements.waitElementLoadingByName(Sid, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.name(Sid)));
			force_to_wait();
			DropDown.selectByValue(Text);
		}

	}

	public static void ScrollHorizontally(WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(2500,0)", "");

	}

	/**
	 * Click item from an drop down by selecting select element by name
	 * 
	 */
	public static void clickSelectBoxItems(String sSelectBoxName, String sItemName) {
		if (Constants.TEST_BROWSER_IE.equals("Y")) {

			String xpath = ".//*[@name='" + sSelectBoxName + "']";

			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.xpath(xpath)));
			force_to_wait();
			DropDown.selectByVisibleText(sItemName);

		}

		else {
			SetElements.waitElementLoadingByName(sSelectBoxName, Constants.TIME_OUT_PERIOD);
			Select DropDown = new Select(driver.findElement(By.name(sSelectBoxName)));
			force_to_wait();
			DropDown.selectByVisibleText(sItemName);
		}

	}

	/**
	 * Extract a displayed output from web page(table) by matching the preceding
	 * text.
	 * 
	 */
	public static String extractValueFromMessageString(String sMatchString, String sLinkText) {
		delayWebDriver(5);
		String sResult = "";
		String sTemResult = "";
		try {
			List<WebElement> listItems = driver.findElements(By.cssSelector("ol[class='msg_list']"));

			for (WebElement link : listItems) {
				WebElement anchorlink = link.findElement(By.tagName("li"));
				sTemResult = anchorlink.getText();
				if (sTemResult != null && sTemResult.contains(sMatchString.trim())) {
					sResult = sTemResult.split(sMatchString)[1].trim();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sResult;
	}

	/**
	 * Check if a specific text is present in a table cell .
	 * 
	 */
	public static boolean extractMessageFromTable(String sMatchString) {
		delayWebDriver(5);
		boolean bFound = false;
		String sTemResult = "";
		try {
			List<WebElement> listItems = driver.findElements(By.cssSelector("div[class='main_content']"));

			for (WebElement link : listItems) {
				WebElement anchorlink = link.findElement(By.tagName("td"));
				sTemResult = anchorlink.getText();
				if (sTemResult != null && sTemResult.contains(sMatchString.trim())) {
					bFound = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFound;
	}

	/**
	 * Extract a displayed output from web page(list) by matching the preceding
	 * text.
	 * 
	 */
	public static boolean extractMessageFromListElement(String sMatchString) {
		delayWebDriver(5);
		String sTemResult = "";
		boolean bFound = false;
		try {
			List<WebElement> listItems = driver.findElements(By.cssSelector("ol[class='msg_list']"));

			for (WebElement link : listItems) {
				WebElement anchorlink = link.findElement(By.tagName("li"));
				sTemResult = anchorlink.getText();
				if (sTemResult != null && sTemResult.contains(sMatchString.trim())) {
					bFound = true;

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFound;
	}

	public static void setElementByXpath(String sType, String sText, String xpath) {

		if (!sType.equalsIgnoreCase("C")) {

			if (!Validation.isEmpty(sText)) {

				if (Constants.TYPE_TEXT.equalsIgnoreCase(sType)) {

					SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
					((JavascriptExecutor) driver).executeScript(
							"window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");
					driver.findElement(By.xpath(xpath)).clear();
					force_to_wait();
					driver.findElement(By.xpath(xpath)).sendKeys(sText);

				}

				if (Constants.TYPE_DROP_DOWN.equalsIgnoreCase(sType)) {

					System.out.println("Asanka Debug Finding Element located xpath " + xpath);

					SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
					((JavascriptExecutor) driver).executeScript(
							"window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");

					Select DropDown = new Select(driver.findElement(By.xpath(xpath))); // 2
					DropDown.selectByValue(sText);
					force_to_wait();
					System.out.println("Asanka Debug Find Element located Xpath " + xpath + "Select Value " + sText);

				}

				if (Constants.TYPE_RADIO_BOX.equalsIgnoreCase(sType)) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					List<WebElement> rdBtn = driver.findElements(By.xpath(xpath));
					int iSize = rdBtn.size();
					System.out.println("rdBtn.size() ================ " + iSize);
					String sValue = "";
					for (int i = 0; i < iSize; i++) {
						// Store the Check Box name to the string variable,
						// using 'Value' attribute
						sValue = rdBtn.get(i).getAttribute("value");
						System.out.println("sValue " + sValue);
						System.out.println("sText " + sText);
						// Select the Check Box it the value of the Check Box is
						// same what you are looking for
						if (sValue.equalsIgnoreCase(sText)) {
							force_to_wait();
							rdBtn.get(i).click();
							break;
						}

					}

					// Start the loop from first Check Box to last Check Boxe

				}

			}

		} else if (Constants.TYPE_CHECK_BOX.equalsIgnoreCase(sType))

		{

			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");
			force_to_wait();
			driver.findElement(By.xpath(xpath)).click();

		}

		else if (Constants.TYPE_RADIO_BOX.equalsIgnoreCase(sType))

		{

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> rdBtn = driver.findElements(By.xpath(xpath));
			int iSize = rdBtn.size();
			for (int i = 0; i < iSize; i++) {
				// Store the Check Box name to the string variable, using
				// 'Value' attribute
				String sValue = rdBtn.get(i).getAttribute("value");
				// Select the Check Box it the value of the Check Box is same
				// what you are looking for
				if (sValue.equalsIgnoreCase(sText)) {
					force_to_wait();
					rdBtn.get(i).click();
					break;
				}
			}

			// Start the loop from first Check Box to last Check Boxe

			//
		}
	}

	public static void ClickByXpath(String arg1, String arg2) {

		try {
			log.debug("Verify click the " + arg1 + " icon to " + arg2);
			SetElements.clickElementByXpath("//label[contains(text(),'" + arg1 + "')]");
			log.debug("Successfully clicked the " + arg1 + " icon to " + arg1);
			/*
			 * WebPageObject.getScreenShots(driver, iImageCounter++ + "_" +
			 * arg2, Constants.IMAGE_LOCATION,
			 * SetElements.setScreenShotPath(arg2)[0]);
			 */
		} catch (Exception e) {
			log.error("error:", e);
			e.printStackTrace();
		}
	}

	public static void ClickByName(String arg1, String arg2) {

		try {
			log.debug("Verify click the " + arg1 + " icon to " + arg2);
			SetElements.clickElementByName(arg1);
			log.debug("Successfully clicked the " + arg1 + " icon to " + arg1);
			/*
			 * WebPageObject.getScreenShots(driver, iImageCounter++ + "_" +
			 * arg2, Constants.IMAGE_LOCATION,
			 * SetElements.setScreenShotPath(arg2)[0]);
			 */
		} catch (Exception e) {
			log.error("error:", e);
			e.printStackTrace();
		}
	}

	public static void PageVerify(String arg1) {

		try {
			log.debug("Verify " + arg1 + " page is loading");
			SetElements.verifyPageLoad("//h1[contains(text(),'" + arg1 + "')]");
			log.debug("Successfully loaded " + arg1 + " page ");
			/*
			 * WebPageObject.getScreenShots(driver, iImageCounter++ + "_" +
			 * arg1, Constants.IMAGE_LOCATION,
			 * SetElements.setScreenShotPath(arg1)[0]);
			 */
		} catch (AssertionError e) {
			log.error("error:", e);
			Assert.fail();
		}
	}

	public static void verifyPageLoad(String xpath) {

		boolean accManaPagePresent;
		try {
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			accManaPagePresent = driver.findElement(By.xpath(xpath)).isDisplayed();

		} catch (Exception e) {
			accManaPagePresent = false;
			log.error("error:", e);
		}

		try {
			Assert.assertTrue(accManaPagePresent);
		} catch (AssertionError e) {
			log.error("error:", e);
			Assert.fail();
		}
	}

	public static boolean isPageLoad(String arg1) {
		boolean accManaPagePresent = false;
		try {
			SetElements.waitElementLoadingByXpath("//h1[contains(text(),'" + arg1 + "')]", Constants.TIME_OUT_PERIOD);
			accManaPagePresent = driver.findElement(By.xpath("//h1[contains(text(),'" + arg1 + "')]")).isDisplayed();

		} catch (Exception e) {
			accManaPagePresent = false;
			log.error("error:", e);
		}

		try {
			Assert.assertTrue(accManaPagePresent);
		} catch (AssertionError e) {
			log.error("error:", e);
			Assert.fail();
		}

		return accManaPagePresent;
	}

	// shavidya
	public static void isDisplayed_by_xpath(String xpath, String value) {

		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");

			assertTrue(value + " not displayed in the screen", element.isDisplayed());
		} catch (NoSuchElementException e) {

			Assert.fail(value + " not displayed in the screen");
		}

	}

	public static void mouseHoverEvent(String sId1, String xpath, String sub) {

		Actions actions = new Actions(driver);
		try {
			if (Constants.TEST_BROWSER_IE.equals("Y")) {

				// SetElements.waitElementLoadingByXpath(text1,
				// Constants.TIME_OUT_PERIOD);
				((JavascriptExecutor) driver).executeScript(
						"window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");
				WebElement menuOption = driver.findElement(By.xpath(xpath));
				WebElement subOption = driver.findElement(By.xpath(sub));
				actions.moveToElement(menuOption).moveToElement(subOption).click().build().perform();
				force_to_wait();
				// WebElement subMenuOption =
				// driver.findElement(By.xpath(sId2));
				// subMenuOption.click();
			}

			else {
				SetElements.waitElementLoadingByXpath(xpath, Constants.TIME_OUT_PERIOD);
				((JavascriptExecutor) driver).executeScript(
						"window.scrollTo(0," + driver.findElement(By.xpath(xpath)).getLocation().y + ")");
				WebElement menuOption = driver.findElement(By.xpath(xpath));
				force_to_wait();
				WebElement subOption = driver.findElement(By.xpath(sub));
				actions.moveToElement(menuOption).moveToElement(subOption).click().build().perform();
				subOption.click();
				// WebElement subMenuOption =
				// driver.findElement(By.xpath(sId2));
				// actions.moveToElement(subMenuOption).perform();
				// subMenuOption.click();
			}

		} catch (Exception e) {

			System.out.println(e);
			e.printStackTrace();
		}
	}

	// --End of Common Function----------------

}
