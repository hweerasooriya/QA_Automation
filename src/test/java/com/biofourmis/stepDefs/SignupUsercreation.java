package com.biofourmis.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;

import com.biofourmis.cucumber.helpers.Constants;
import com.biofourmis.cucumber.helpers.ExcelReader;
import com.biofourmis.cucumber.helpers.SetElements;
import com.biofourmis.cucumber.helpers.WebDriverInitializer;
import com.biofourmis.cucumber.pageDto.LoginFormDto;
import com.biofourmis.cucumber.pageObject.WebPageObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignupUsercreation {
	
	private WebDriverInitializer webDriverInitializer;
	WebDriver driver = null;
	LoginFormDto loginForm = null;
	
	ExcelReader reader = new ExcelReader();
	
	
public SignupUsercreation(WebDriverInitializer webDriverInitializer) {
		
		this.webDriverInitializer = webDriverInitializer;
	}

	@Given("^User navigates to E Commerce application$")
	public void user_navigates_to_E_Commerce_application() throws Throwable {
	    
		driver = webDriverInitializer.getDriver();
		WebPageObject page = new WebPageObject(driver);
		loginForm=new LoginFormDto(driver);
		page.navigateToWebPage(Constants.LOGIN_PAGE);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebPageObject.getScreenShots(driver, "Home Page",Constants.IMAGE_LOCATION,Constants.HOME_PAGE);
	    
	}

	@Given("^User clicks on the \"([^\"]*)\" button$")
	public void user_clicks_on_the_button(String Signin) throws Throwable {
		 SetElements.clickElementByLinkText(Signin);
		//"//a[@class='login']"
	}

	@Given("^User inputs E-mail Address from the   given sheet \"([^\"]*)\" and rownumber (\\d+)$")
	public void user_inputs_E_mail_Address_from_the_given_sheet_and_rownumber(String sheetName, int rowNumber) throws Throwable {
	   
		List<Map<String,String>> testData = 
				reader.getData(Constants.EXCEL_FILE_PATH,sheetName);
	    
		String email = testData.get(rowNumber).get("Email");
		SetElements.setElement(Constants.TYPE_TEXT, email, "email_create");
		//driver.findElement(By.id("email_create")).sendKeys(email);
	    
	}
	
	@Given("^User click on the \"([^\"]*)\" button$")
	public void user_click_on_the_button(String SubmitCreate) throws Throwable {
		 SetElements.clickElementById(SubmitCreate);
	    
	}

	@When("^User inputs account details from the   given sheet \"([^\"]*)\" and rownumber (\\d+)$")
	public void user_inputs_account_details_from_the_given_sheet_and_rownumber(String sheetName, int rowNumber) throws Throwable {
	    
		List<Map<String,String>> testData = 
				reader.getData(Constants.EXCEL_FILE_PATH, sheetName);
	    
		String title = testData.get(rowNumber).get("Title");
		SetElements.clickElementById("uniform-id_gender2");
		
		//First Name
		String custFName = testData.get(rowNumber).get("custFName");
		SetElements.setElement(Constants.TYPE_TEXT, custFName,"customer_firstname");
		
		//Last Name
		String custLName = testData.get(rowNumber).get("custLName");
		SetElements.setElement(Constants.TYPE_TEXT, custLName,"customer_lastname");
		
		//Password
		String password = testData.get(rowNumber).get("password");
		SetElements.setElement(Constants.TYPE_TEXT, password,"passwd");
		
		//Days
		String day = testData.get(rowNumber).get("days");
		//SetElements.clickElementById(days);
		SetElements.SelectNamedDropDownByValue(day,"days");
		
		//Month
		String months = testData.get(rowNumber).get("months");
		SetElements.SelectNamedDropDownByValue(months,"months");
		
		//Year
		String years = testData.get(rowNumber).get("years");
		SetElements.SelectNamedDropDownByValue(years,"years");
		
		
		//company
		String company = testData.get(rowNumber).get("company");
		SetElements.setElement(Constants.TYPE_TEXT, company,"company");
		
		//adds1
		String adds1 = testData.get(rowNumber).get("adds1");
		SetElements.setElement(Constants.TYPE_TEXT, adds1,"address1");
		
		//adds2
		String adds2 = testData.get(rowNumber).get("adds2");
		SetElements.setElement(Constants.TYPE_TEXT, adds2,"address2");
		
		//city
		String cityOfAdd = testData.get(rowNumber).get("cityOfAdd");
		SetElements.setElement(Constants.TYPE_TEXT, cityOfAdd,"city");
		
		//State
		String cState = testData.get(rowNumber).get("cState");
		SetElements.SelectNamedDropDownByValue(cState, "id_state");
		
		//Zip/Postal Code
		String pCode = testData.get(rowNumber).get("pCode");
		SetElements.setElement(Constants.TYPE_TEXT, pCode,"postcode");
		
		//Country
		
		//Home phone
		String hPhone = testData.get(rowNumber).get("hPhone");
		SetElements.setElement(Constants.TYPE_TEXT, hPhone,"phone");
		
		//Mobile phone
		String pMobile = testData.get(rowNumber).get("pMobile");
		SetElements.setElement(Constants.TYPE_TEXT, pMobile,"phone_mobile");
		
		//Assign an address alias for future reference.
		
		String aliasEmail = testData.get(rowNumber).get("aliasEmail");
		SetElements.setElement(Constants.TYPE_TEXT, aliasEmail,"alias");
	}

	@Then("^User clicks on \"([^\"]*)\" Button$")
	public void user_clicks_on_Button(String arg1) throws Throwable {
		SetElements.clickElementById("submitAccount");
	    
	}

	@Then("^User navigates to the My Account Page$")
	public void user_navigates_to_the_My_Account_Page() throws Throwable {
		
		SetElements.isDisplayed_by_xpath("//span[@class='navigation_page']", "My account");
	    
	}

	@Then("^User clicks on the SignOut Button$")
	public void user_clicks_on_the_SignOut_Button() throws Throwable {
		SetElements.clickElementByLinkText("Sign out");
	}
	
}
