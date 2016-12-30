/**
 * Created by Tania Rimy on 11/29/2016.
 */

import org.junit.Test;
import org.openqa.selenium.*;

import java.util.concurrent.Delayed;

import static com.heliumhq.API.*;
import static org.junit.Assert.assertTrue;


public class Run_Test_from_Bulk_Action_Bar_Module_Test extends Shared implements webelement_repository{

    String click_test;
    masterTestSuite mts = new masterTestSuite();

    @Test
    public void  Run_Test_from_Bulk_Action_Bar_Module_Test() throws Exception{

//            setup_Launch_Browser();
        logIn();
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        print( "                                     Run Test from Bulk Action Bar Module Test                                                ");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
//            date_time();
        organization_Dashboard();
        create_Project();
//            Create_Report();
        runTest();
        checkTest();
        addModule("https://www.youtube.com/", 1);
        checkModule();
    }

    public void organization_Dashboard()
    {
        print("Navigating to the Target Organization.....");
        click_by_xpath(xpath_Organizations);
//        click(text_organization_name);
        mts.org();
        Delay(a);
        if(Text("001-Test-Organization Organization Dashboard").exists() == true)
            print("Navigation Successfully done!");
        Delay(a);
    }

    public void create_Project()
    {
        print("Creating Project.....");
        Delay(a);
        click("Create Project");
        Delay(a);
        write(text_project_name, into("Name"));
        click(text_make_it_happen);
        Delay(a);
        if(Text(text_project_name).exists() == true)
            print("Project Created Successfully!");
        print("Navigating to the Target Project.....");
        click(text_project_name);
        Delay(a);
        if(Text("001-Test-Project Project Dashboard").exists() == true)
            print("Navigation Successfully done!");
    }

//    public void Create_Report()
//    {
//        Delay(a);
//        System.out.println("Creating Report.....");
//        click("Create Report");
//        Delay(a);
//        write(text_report_name, into("Name"));
//        click(text_make_it_happen);
//        Delay(a);
//        if(Text(text_project_name).exists() == true)
//            System.out.println("Report Created Successfully!");
//    }

    public void runTest()
    {
        print("Navigating to the Test Page.....");
        print("Creating New Test.....");
        click_by_xpath("//span[contains(text(), 'Tests')]");
//        click($("#tests_tab_30026"));
        click("Create New Test");
        write(text_test_name, into($(id_test_name_field)));
        write(text_test_url, into($(id_url_field)));
//        click($("#browser"));
//        click_by_xpath(xpath_chrome);
        click(text_make_it_happen);
        wait_untill(xpath_test_action_header);
        click("Run Test");
        click_test = date_time().substring(0,14);
        wait_untill("//div[contains(text(),'Status: The Test has been run, and the following report has been generated:  ')]");
        if(check_Element("Status: The Test has been run, and the following report has been generated:", "") == true)
        {
            print("Test Run Successfully!");
            click(click_test);
            Delay(b);
        }
        print("Navigating to the New Generated Report Dashboard.....");
    }

    public void checkTest ()
    {
        if(getDriver().findElement(By.cssSelector("h1 > span")).getText().contains("Report Dashboard"))

        {
            print("Navigation done Successfully!");
        }
        print("Checking the Result of the Test.....");
        getDriver().navigate().refresh();
        String header = value("total_compliance_header");
        print("The Name of the Test is: "+header.substring(93));
        print("Total Compliance: "+value("total_compliance_container"));
    }

    public void checkModule()
    {
        wait_untill("//div[contains(text(),'Showing 1 to 2 of 2')]");
        print("Checking the Added Module.....");
        if(check_Element("Showing 1 to 2 of 2","https://www.youtube.com/") == true)
            print("Module Added Successfully!");
        print("Current Number of Module is:"+ value("dataTables_info").substring(17));
    }

}
