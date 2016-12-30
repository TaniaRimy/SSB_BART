/**
 * Created by Tania Rimy on 11/25/2016.
 */

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import static com.heliumhq.API.*;

public class User extends Shared implements webelement_repository{

    masterTestSuite mts = new masterTestSuite();

    @Test
    public void User () throws Exception{

//        setup_Launch_Browser();
        logIn();
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        print( "                                                      Create user                                                             ");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        create_User();
        check_User();

    }

    public void create_User () {

        print("Creating User.....");
        click_by_xpath(xpath_Organizations);
        Delay(2000);
//        click(text_organization_name);
        mts.org();
        click_by_xpath(xpath_administration);
        click("Create User");
        write(fname, into($("#firstname")));
        write(lname, into($("#lastname")));
//        write(email, into($("#email")));
        mts.emailInput();
        write(pass, into($("#pass1")));
        write(pass, into($("#pass2")));

        click(text_make_it_happen);

    }

    public void check_User () {

        print("Checking User.....");
        click("View User");
        if(check_Element("Test User", email) == true)
            print("User Created Successfully!!");
        else
            print("User is not Created!");


    }

}
