/**
 * Created by Tania Rimy on 12/14/2016.
 */
import static com.heliumhq.API.*;

//process 1

//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//import org.junit.runners.Suite.SuiteClasses;
//import org.junit.*;
//import org.openqa.selenium.WebDriver;
//
//import static com.heliumhq.API.getDriver;
//import static com.heliumhq.API.setDriver;
//
//@RunWith(Suite.class)
//
//@SuiteClasses({ testSuite1.class, testSuite2.class})
//
//public class masterTestSuite {
//
//    public WebDriver driver;
//
//    @Test
//    public void masterClassSuite() {
//
////        setDriver(driver);
////        getDriver();
//    }
//}



//process 2

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.heliumhq.API.getDriver;
import static com.heliumhq.API.setDriver;

public class masterTestSuite extends Shared{

    public static int org;
//    public WebDriver driver;
//    public String baseUrl;

    @Test
    public void masterTestSuit(){

        //path for drivers
        System.setProperty("webdriver.gecko.driver", "C:\\G\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\S\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "C:\\I\\IEDriverServer.exe");

        // for CHROME browser

        for(int step = 1; step < 6 ; step ++) {

            //launch browser
            driver = new ChromeDriver();
            browser_setup();
            //launch browser

            if(step == 1 ) runClass(Organization.class, "Organization", "Chrome");
            if(step == 2 ) {org = 1; runClass(User.class, "User", "Chrome");}
            if(step == 3 ) runClass(Run_test_on_Accessibility_Demand.class, "Run_test_on_Accessibility_Demand", "Chrome");
            if(step == 4 ) {org = 1; runClass(Run_Test_from_Bulk_Action_Bar_Module_Test.class, "Run_Test_from_Bulk_Action_Bar_Module_Test", "Chrome");}
            if(step == 6 ) {org = 1; runClass(Compliance_Count.class, "Compliance_Count", "Chrome");}

        }


        //for FIREFOX browser

        for(int step = 1; step < 6 ; step ++) {

            //launch browser
            driver = new FirefoxDriver();
            browser_setup();
            //launch browser
//
            if(step == 1 ) runClass(Organization.class, "Organization", "Firefox");
            if(step == 2 ) {org = 2; runClass(User.class, "User", "Firefox");}
            if(step == 3 ) runClass(Run_test_on_Accessibility_Demand.class, "Run_test_on_Accessibility_Demand", "Firefox");
            if(step == 4 ) {org = 2; runClass(Run_Test_from_Bulk_Action_Bar_Module_Test.class, "Run_Test_from_Bulk_Action_Bar_Module_Test", "Firefox");}
            if(step == 5 ) {org = 2; runClass(Compliance_Count.class, "Compliance_Count", "Firefox");}

        }

    }

    public void runClass(Class className, String classPrint, String browserName)
    {
        Result result = JUnitCore.runClasses(className);
        for (Failure fail : result.getFailures()) {
            System.out.println(classPrint+" Class Failed for: \n" +fail.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println(classPrint+" Class Passed successfully in "+ browserName +"!!");
        }
    }

    public void browser_setup()
    {

        driver.manage().window().maximize();
        baseUrl = "https://trunk.ssbbartgroup.com";
        driver.get(baseUrl);
        setDriver(driver);
        getDriver();

    }


    public void org()
    {
//        System.out.println("value of ORG: "+org);
        if(org == 1) click("001-Test-Organization");
        if(org == 2) click("002-Test-Organization");
    }

    public void emailInput()
    {
//        System.out.println("value of ORG: "+org);
        if(org == 1) write("001testuser@gmail.com", into($("#email")));
        if(org == 2) write("002testuser@gmail.com", into($("#email")));
    }

}