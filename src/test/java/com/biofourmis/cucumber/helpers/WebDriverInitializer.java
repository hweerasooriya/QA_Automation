package com.biofourmis.cucumber.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebDriverInitializer {

	private static boolean initialized = false;
	private static WebDriver driver;

	@Before
	public void setUp() throws Exception {

		if (!initialized)

		{

			if (Constants.TEST_BROWSER_CHROME.equals("Y")) {

				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
				// set the download path
				//
				/*
				 * String downloadFilepath = Constants.FILE_DOWNLOAD_LOCATION;
				 * Map<String, Object> prefs = new HashMap<String, Object>();
				 * prefs.put("download.default_directory",
				 * System.getProperty("user.dir")+ File.separator +
				 * "externalFiles" + File.separator + "downloadFiles");
				 * ChromeOptions options = new ChromeOptions();
				 * options.setExperimentalOption("prefs", prefs); driver = new
				 * ChromeDriver(options);
				 */
				driver = new ChromeDriver();

				initialized = true;
				System.out.println(Constants.CHROME_DRIVER_PATH + " initialized   ");

			}

			else if (Constants.TEST_BROWSER_IE.equals("Y")) {

				System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_PATH);
				driver = new InternetExplorerDriver();

				initialized = true;

				System.out.println(Constants.IE_DRIVER_PATH + " initialized   ");

			}

			else if (Constants.TEST_BROWSER_EDGE.equals("Y")) {

				System.setProperty("webdriver.edge.driver", Constants.EDGE_DRIVER_PATH);
				driver = new EdgeDriver();

				initialized = true;
				System.out.println(Constants.EDGE_DRIVER_PATH + " initialized   ");

			}

			else if (Constants.TEST_BROWSER_FIRE_FOX.equals("Y")) {

				System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_PATH);
				driver = new FirefoxDriver();

				initialized = true;
				System.out.println(Constants.FIREFOX_DRIVER_PATH + " initialized   ");

			}

		}

	}
	
	@After
    public void cleanUp() {
        System.out.println("Into the cleanUp method of AccountStep...");
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

	public WebDriver getDriver() {
		if (!initialized) {
			System.out.println(" initializing   ");
			try {
				setUp();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return driver;
	}

}
