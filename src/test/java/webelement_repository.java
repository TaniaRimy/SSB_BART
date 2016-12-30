/**
 * Created by Tania Sultana on 12/1/2016.
 */

public interface webelement_repository {

    Shared obj = new Shared();

    //Common
//    int browser = 0;
    String text_make_it_happen = "Make it happen";
    String text_test_url = "https://habibur.com/salat/districts/dhaka/";
    String xpath_run_status = "//div[contains(text(),'Status: The Test has been run, and the following report has been generated:  ')]";
    //Common


    //Organization
    String text_organization_name = "001-Test-Organization";
    //Organization


    //Run_test_on_Accessibility_Demand
    String classname_widget_add_button = ".fa-plus-circle";
    String id_add_widget_combo = "#add_widget";
    String xpath_option_Accessibility_on_Demand = "//option[contains(text(),'Accessibility on Demand')]";
    String id_add_widget_submit_button = "#ajax_submit";
    String id_url_field_dashboard = "#start_url_ae";
    //Run_test_on_Accessibility_Demand


    //Shared

    //Shared


    //User
    String fname = "Test";
    String lname = "User_165";
    String email = "TestUser@gmail.com";
    String pass = "123456";
    String xpath_administration = "//span[contains(text(), 'Administration')]";
    //User


    //Run_Test_from_Bulk_Action_Bar_Module_Test
    String xpath_Organizations = "//a[contains(text(),'Organizations')]";
    String text_project_name = "001-Test-Project";
    String text_report_name = "001-Test-Report";
    String xpath_chrome = "//option[contains(text(), 'Chrome')]";
//    String xpath_chrome = "//option[Starts-with(@value,'chrome') and contains(text(), 'Chrome')]";
//    String xpath_chrome = "//option[@value = 'chrome']";
    String xpath_test_action_header = "//div[@class = 'SSBWidget_Container linkbox']";
    String text_test_name = "001-Test";
    String id_test_name_field = "#testing_name";
    String id_url_field = "#start_url";
    String text_check_report_dashboard = "001-Test - Report Dashboard" ;
    //

    //Compliance_Count
    String xpath_dashboard = "//span[contains(text(), 'Dashboard')]";
    //Compliance_Count

    //Duration
    int a = 1000;
    int b = 2000;
    int c = 3000;
    int d = 4000;
    int compliance_value_reload_time = 100000;
    //Duration

}
