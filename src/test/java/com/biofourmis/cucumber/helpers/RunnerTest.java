package com.biofourmis.cucumber.helpers;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.Constants;

import org.junit.runner.JUnitCore;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


@RunWith(ExtendedCucumber.class)


@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        //usageReport = true,
        toPDF = true,
        //excludeCoverageTags = {"@flaky" },
        //includeCoverageTags = {"@login" },
        outputFolder = "target/cucumber/extend")

//@CucumberOptions(plugin = {"pretty", "html:target/cucumber/html",
//     "json:target/cucumber.json"
////,"usage:target/cucumber-usage.json"
//},


@CucumberOptions(plugin = {"pretty", "html:target/cucumber/html","json:target/cucumber.json"},
         tags = {"@SignUpUsers"},
                features = "classpath:cucumber/features",
                glue = "com.biofourmis.stepDefs")

public class RunnerTest {

    public static void main(String ar[]) {

        DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        System.out.println("SERVICE SUPPORT VERSI : 9.0.32");
        System.out.println("SERVICE UPDATING TO...: 9.0.62");
        System.out.println("-----SERVICE START UP TIME : " + dateFormat.format(new Date()));

        String sStartupCheck = "";

        if (!sStartupCheck.isEmpty()) {
            System.out.println("---->"+sStartupCheck);
            System.exit(0);
        } else {
        	System.out.println("Close WebDriver");
            JUnitCore.main("com.biofourmis.cucumber.helpers.RunnerTest");
            WebDriverInitializer wdi = new WebDriverInitializer();
            System.out.println("Inside WebDriverInitializer");
            wdi.cleanUp();
           //wdi.getDriver().quit();
            System.out.println("-----SERVICE END TIME :-----------" + dateFormat.format(new Date()));
        }

    }

}
