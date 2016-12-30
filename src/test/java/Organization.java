/**
 * Created by Tania Rimy on 11/24/2016.
 */

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import static com.heliumhq.API.*;

public class Organization extends Shared implements webelement_repository{

    @Test
    public void Organization () throws Exception{

//        setup_Launch_Browser();
//        logIn();
        print( "***************************************************************************************************************************   ");
        print( "                                                  SSB BART Smoke Suite                                                        ");
        print( "***************************************************************************************************************************   ");
        print("");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        print( "                                                   Create organization                                                        ");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
//        create_Organization();
//        check_Organization();
    }

    public void create_Organization () {

        print("Creating Organization.....");
        click("AMP Administration");
        click("Create Organization");
        write(text_organization_name, into($("#name")));
        click(text_make_it_happen);

    }

    public void check_Organization () {

        print("Checking Organization.....");
        click("AMP Administration");
        click("List Organizations");
        if(check_Element(text_organization_name, "") == true)
            print("Organization Created Successfully!!");
        else
            print("Organization is not Created!!");

    }


}
