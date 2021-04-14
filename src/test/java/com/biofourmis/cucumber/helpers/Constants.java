// -------------------------------------------@copyright_Harshani------------------------------------
// PROJECT        : Test Automation-Biofourmis
// PRODUCT        : Sample
// VERSION        : 1.0
// REMARKS        :
// -------------------------------------------------------------------------------
package com.biofourmis.cucumber.helpers;

public class Constants {

	public final static String FOLDER_SEPERATOR = "\\";
	public final static String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

	public static String HOST_PAGE_LINK = "http://automationpractice.com/";

	public static String LOGIN_PAGE = HOST_PAGE_LINK + "index.php";

	public static final int waitTime = 0;

	public final static String IMAGE_EXTENSION = ".png";
	public final static String IMAGE_LOCATION = "target\\SCREENS_SHOTS\\";
	public final static String FILE_DOWNLOAD_LOCATION = "target\\downloads\\";
	public final static String TEST_BROWSER_FIRE_FOX = "N";
	public final static String TEST_BROWSER_CHROME = "Y";
	public final static String TEST_BROWSER_IE = "N";
	public final static String TEST_BROWSER_EDGE = "N";
	public final static String CHROME_DRIVER_PATH = "bin\\chromedriver.exe";
	public final static String IE_DRIVER_PATH = "bin\\IEDriverServer.exe";
	public final static String EDGE_DRIVER_PATH = "bin\\MicrosoftWebDriver.exe";
	public final static String FIREFOX_DRIVER_PATH = "bin\\geckodriver.exe";

	public final static String EXCEL_FILE_PATH = "F:\\Biofourmis\\EcommerceAutomation\\bin\\automationSignupusers.xlsx";

	public final static String FIRE_FOX_PROFILE_LOAD = "Y";
	public final static String iADMIN_NEW_USER_PROFILE = "Y";

	public static boolean failScenarioMessageAllow = false;
	public static String failScenarioMessageText = "";

	public final static String SUCCESS_MESSAGE = "success";
	public final static String ERROR_MESSAGE = "error";

	public final static String MAIN_ICARD_ICON_XPATH = "/html/body/div[2]/nav/div/a[2]/div/img";
	public final static String PRODUCT_CREATION_FINAL_RESULT_IMAGE_NAME = "Creation_result";
	public final static String COMMENT_APPROVE = "Approving BY cucumber Automation";

	// Types of elements
	public final static String TYPE_TEXT = "T";
	public final static String TYPE_DROP_DOWN = "D";
	public final static String TYPE_CHECK_BOX = "C";
	public final static String TYPE_RADIO_BOX = "R";

	public final static boolean GET_SCREEN_SHOTS = true;
	public final static boolean ADD_SUB_FOLDER_CREATION = true; // This will put
	// all images in
	// relevant sub
	// folders
	// according to
	// the module
	public final static String HOME_PAGE = "Home Page" + FOLDER_SEPERATOR;
	
	//// iadmin

	
	public final static long TIME_OUT_PERIOD = 20;

	// icore props
	
	// DB details

	

	// Settle related procedures running schema
	public final static String PROCEDURE_RUNNING_SCHEMA = "BKN";
	public final static String PROCEDURE_TYPE = "PROCEDURE";
	public final static String SELECT_TYPE = "SELECT";

}
