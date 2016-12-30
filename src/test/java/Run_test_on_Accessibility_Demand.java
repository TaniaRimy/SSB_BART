/**
 * Created by Tania Rimy on 11/29/2016.
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.*;

import static com.heliumhq.API.*;
import static com.heliumhq.API.click;


public class Run_test_on_Accessibility_Demand extends Shared implements webelement_repository{


    @Test
    public void  Run_test_on_Accessibility_Demand() throws Exception{

//        setup_Launch_Browser();
        logIn();
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        print( "                                         Run an accessibility on demand test                                                  ");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        check_Accessibility_Demand_Widget();
        run_Test();
        check_Test();

    }

    public void check_Accessibility_Demand_Widget () {

        print("Checking the Accessibility Demand Widget.....");
        if(check_Element("Accessibility On Demand", "To get started, simply enter a URL and click ") == false)
        {
            print("Accessibility Demand Widget is not Present So Adding the Widget.....");
            click($(classname_widget_add_button));
            click($(id_add_widget_combo));
            click_by_xpath(xpath_option_Accessibility_on_Demand);
            click($(id_add_widget_submit_button));
            Delay(a);
            if(check_Element("Accessibility On Demand", "To get started, simply enter a URL and click ") == true)
                print("Accessibility Demand Widget is Added Successfully!");
        }
        else
        {
            Delay(a);
            print("Accessibility Demand Widget is Present!");
        }

    }

    public void run_Test () {

        print("Running the Test.....");
        write(text_test_url, into($(id_url_field_dashboard)));
        click(text_make_it_happen);
        obj.wait_untill(xpath_run_status);
        if(check_Element("Status: The Test has been run, and the following report has been generated: https://habibur.com/salat/districts/dhaka/ - ", "") == true)
        {
            print("Test Run Successfully!");
            click("Status: The Test has been run, and the following report has been generated: https://habibur.com/salat/districts/dhaka/ - ");
            Delay(c);
        }

    }

    public void check_Test () {

        print("Checking the Result of the Test.....");
        String header = value("total_compliance_header");
        print("The Name of the Test is: "+header.substring(93));
        print("Total Compliance: "+value("total_compliance_container"));

    }

}
