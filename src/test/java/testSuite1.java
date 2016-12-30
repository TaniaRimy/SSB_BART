/**
 * Created by Tania Rimy on 12/1/2016.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.heliumhq.API.getDriver;
import static com.heliumhq.API.setDriver;

@RunWith(Suite.class)

@SuiteClasses({ User.class, Run_test_on_Accessibility_Demand.class })
//@SuiteClasses({ Organization.class, User.class, Run_test_on_Accessibility_Demand.class, Run_Test_from_Bulk_Action_Bar_Module_Test.class, Compliance_Count.class, Organization.class, User.class, Run_test_on_Accessibility_Demand.class, Run_Test_from_Bulk_Action_Bar_Module_Test.class, Compliance_Count.class })
//@SuiteClasses({ User.class, Run_test_on_Accessibility_Demand.class, Run_Test_from_Bulk_Action_Bar_Module_Test.class, Compliance_Count.class})

public class testSuite1 {

}
