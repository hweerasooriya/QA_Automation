package com.biofourmis.stepDefs;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.biofourmis.cucumber.helpers.Constants;
import com.biofourmis.cucumber.helpers.ExcelReader;
import com.biofourmis.cucumber.helpers.SetElements;
import com.biofourmis.cucumber.helpers.WebDriverInitializer;
import com.biofourmis.cucumber.pageDto.LoginFormDto;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignIn_UserCheckout {

	private WebDriverInitializer webDriverInitializer;
	WebDriver driver = null;
	LoginFormDto loginForm = null;
	String aproduct;
	String aprice;
	String parent;

	ExcelReader reader = new ExcelReader();

	@Given("^User inputs userName and Password from the   given sheet \"([^\"]*)\" and rownumber (\\d+)$")
	public void user_inputs_userName_and_Password_from_the_given_sheet_and_rownumber(String sheetName, int rowNumber)
			throws Throwable {
		List<Map<String, String>> testData = reader.getData(Constants.EXCEL_FILE_PATH, sheetName);

		String email = testData.get(rowNumber).get("Email");
		SetElements.setElement(Constants.TYPE_TEXT, email, "email");
		String password = testData.get(rowNumber).get("password");
		SetElements.setElement(Constants.TYPE_TEXT, password, "passwd");
	}

	@Given("^User selects the \"([^\"]*)\" button$")
	public void user_selects_the_button(String arg1) throws Throwable {
		SetElements.clickElementById("SubmitLogin");
	}

	@Given("^User clicks on \"([^\"]*)\" Category section$")
	public void user_clicks_on_Category_section(String women) throws Throwable {

		String xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
		String submenuxpath = "//ul[@class='submenu-container clearfix first-in-line-xs']//li//ul[@style='display: none;']//li//a[contains(text(),'Casual Dresses')]";

		SetElements.mouseHoverEvent(women, xpath, submenuxpath);

		// SetElements.mouseHoverEvent("Casual Dresses",submenuxpath);
		// driver.findElement(By.xpath(submenuxpath)).click();

		// SetElements.clickElementByLinkText(women);

	}

	@Given("^User scrolls the Page$")
	public void user_scrolls_the_Page() throws Throwable {

		SetElements.clickElementByLinkText("Printed Dress");

	}

	@When("^User verifies the Price and the product name from the page$")
	public void user_verifies_the_Price_and_the_product_name_from_the_page() throws Throwable {

		// String actualProd =
		// driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
		// String actualPrice =
		// driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();

		// Assert.assertEquals("Printed Dress", actualProd);
		// Assert.assertEquals("$26.00", actualPrice);

	}

	@Then("^User clicks the add to cart button$")
	public void user_clicks_the_add_to_cart_button() throws Throwable {

		String xpath = "//p[@id='add_to_cart']//span[text()='Add to cart']";
		SetElements.clickElementByXpath(xpath);

		// parent = driver.getWindowHandle();
		// System.out.println("Parent : " + parent);
		//
		// Set<String> allWindows = driver.getWindowHandles();
		//
		// int count = allWindows.size();
		// System.out.println("Windoow Count is : " + count);
		//
		// for (String child : allWindows) {
		// System.out.println(child);
		//
		// if (!child.equalsIgnoreCase(parent)) {
		//
		// driver.switchTo().window(child);
		//
		// // Proceed To Checkout button
		// String xpathCheck = "//a[@class='btn btn-default button
		// button-medium']";
		// SetElements.clickElementByXpath(xpathCheck);
		//
		// }
	}

	@Then("^User performs the further checkout process$")
	public void user_performs_the_further_checkout_process() throws Throwable {

		parent = driver.getWindowHandle();
		System.out.println("Parent : " + parent);

		Set<String> allWindows = driver.getWindowHandles();

		int count = allWindows.size();
		System.out.println("Windoow Count is : " + count);

		for (String child : allWindows) {
			System.out.println(child);

			if (!child.equalsIgnoreCase(parent)) {

				driver.switchTo().window(child);
				// Proceed To Checkout button
				String xpathCheck = "//a[@class='btn btn-default button button-medium']";
				SetElements.clickElementByXpath(xpathCheck);
				driver.close();

			}

		}
		// Proceed Summary Checkout Page
		driver.switchTo().window(parent);
		SetElements.clickElementByXpath("//a[@class='button btn btn-default standard-checkout button-medium']");

		// Proceed Summary Tab
		SetElements.clickElementByXpath("//button[@type='submit']//span[contains(text(),'Proceed to checkout')]");

		// Terms of service Page check out
		SetElements.clickElementByXpath("//input[@id='cgv']");
		SetElements.clickElementByXpath("//button[@type='submit']//span[contains(text(),'Proceed to checkout')]");

		// Select Payment Method
		SetElements.clickElementByXpath("//a[@class='cheque']");

		// Comfirm Order
		SetElements.clickElementByXpath("//span[contains(text(),'I confirm my order')]");

		// Payment Order Completion
		String actual = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
		Assert.assertEquals("Your order on My Store is complete.", actual);
		
		

	}
}