/**
 * Created by Tania Rimy on 12/6/2016.
 */

import org.junit.Test;
import org.openqa.selenium.*;
import java.util.ArrayList;
import static com.heliumhq.API.*;

public class Compliance_Count extends Shared implements webelement_repository {

    String[] compliance = new String[50];
    int i;
    masterTestSuite mts = new masterTestSuite();

    @Test
    public void  Compliance_Count() throws Exception{

//        setup_Launch_Browser();
        logIn();
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        print( "                                                      Compliance Count                                                        ");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        i = 1;
        checkOverallCompliance();
        addModule("http://stackoverflow.com/questions/17624335/converting-milliseconds-to-minutes-and-seconds", 0);
        Delay(compliance_value_reload_time);
        i = 4;
        click_by_xpath(xpath_dashboard);
        checkOverallCompliance();
        removeModule();
        Delay(compliance_value_reload_time);
        i = 7;
        click_by_xpath(xpath_dashboard);
        checkOverallCompliance();
        printCompliance();
    }

    public void checkOverallCompliance()
    {
        print("Counting Organization Compliance.....");
        click_by_xpath(xpath_Organizations);
        click(text_organization_name);
//        mts.org();
//        getDriver().navigate().refresh();getDriver().navigate().refresh();
        compliance[i] = value("total_compliance_container");i++;print(compliance[i]);
        print("Counting Project Compliance.....");
        Delay(b);
        click(text_project_name);
//        click("tt");
        getDriver().navigate().refresh();
        compliance[i] = value("total_compliance_container");i++;print(compliance[i]);
        print("Counting Report Compliance.....");
        click(date_time().substring(0,9));
        getDriver().navigate().refresh();
        compliance[i] = value("total_compliance_container");print(compliance[i]);
    }

    public void removeModule()
    {
        click_by_xpath("//a[contains(text(),'Modules')]");
        Delay(b);
        click("Report Modules");
        Delay(a);
        click($(".select-checkbox"));
//        click_by_xpath("//input[@type = 'checkbox']");
        click("Delete");
        click(text_make_it_happen);
    }

    public void printCompliance()
    {
        for(int j = 1; j < 10 ; j++)
        {
            if(compliance[j].equals("0%*")){
                compliance[j] = "00%*";}
        }
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        print( "|           Compliance             |   Organization Compliance   |     Project Compliance     |     Report Compliance     |   ");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        print( "|      Before Adding Module        |            " + compliance[1] + "             |           " + compliance[2] + "             |            " + compliance[3] + "           |  ");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        print( "|      After Adding Module         |            " + compliance[4] + "             |           " + compliance[5] + "             |            " + compliance[6] + "           |  ");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
        print( "|     After Deleting Module        |            " + compliance[7] + "             |           " + compliance[8] + "             |            " + compliance[9] + "           |  ");
        print( "---------------------------------------------------------------------------------------------------------------------------   ");
    }

}
