/**
 * Created by Tania Rimy on 11/23/2016.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.heliumhq.API.*;

//date
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Shared implements webelement_repository {

    public WebDriver driver;
    public String baseUrl;
    long startTime, endTime, totalTime;
    public int browser;

    public void setup_Launch_Browser() throws Exception{

        System.setProperty("webdriver.gecko.driver", "C:\\G\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\S\\chromedriver.exe");
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        baseUrl = "https://trunk.ssbbartgroup.com/";
//        baseUrl = "https://trunk.ssbbartgroup.com/public/reporting/view_modules.php?report_id=192587";
        driver.get(baseUrl);
        setDriver(driver);
        getDriver();
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void logIn() {

//        WebElement email=getDriver().findElement(By.xpath("//input[@name = 'email']"));
//        email.sendKeys("tr@gmail.com");
        write("tr@gmail.com", into("Username"));
//        WebElement pass=getDriver().findElement(By.xpath("//input[@id = 'password']"));
//        pass.sendKeys("123456");
        write("123456", into("Password"));
        click("Make it happen");

    }

    public boolean check_Element(String element1, String element2) {

        if(Text(element1).exists() == true && Text(element2).exists() == true)
            return true;
        else
            return false;

    }

    public void click_by_xpath(String xpath)
    {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public void Delay(int duration) {
        try {
            Thread.sleep(duration);
        }catch(Exception e){}
    }

    public void wait_untill(String item) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(item)));
    }


    public String value(String text) {

        WebElement x = getDriver().findElement(By.className(text));
        String y = x.getText().toString();
        return y;
        print("rimy");
    }

    public String date_time() {

        Date today = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mma");
        df.setTimeZone(TimeZone.getTimeZone("PST"));
        String PST = df.format(today);
        print("Date in (GST) : " + PST);
        return PST;


//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        return dateFormat.format(date);
//        int currentDay = Integer.parseInt(day);

    }

    public void addModule(String url, int i)
    {
        print("Navigating to the Module Page.....");
        click_by_xpath("//a[contains(text(),'Modules')]");
        Delay(b);
        click("Report Modules");
        Delay(a);
        if(getDriver().findElement(By.cssSelector("h1 > span")).getText().contains("Report Modules"))
            print("Navigation Successfully done!");
        print("Adding a new Module.....");
        Delay(a);
        if(i == 1) System.out.println("Number of Module is:"+ value("dataTables_info").substring(17));
        click("Add Module");
        write(url,into($("#location")));
//        click($("#browser"));
//        click_by_xpath(xpath_chrome);
        click(text_make_it_happen);
        getDriver().navigate().refresh();
    }

    public void totalExecutionTime_Report(String item)
    {
        if(item == "start")
        {
            startTime = System.currentTimeMillis();
        }
        else
        {
            endTime   = System.currentTimeMillis();
            totalTime = (endTime - startTime);

            long s = totalTime % 60;
            long m = (totalTime / 60) % 60;

            print("");
            print( "****************************************************************************************************************************");
            print( "                                           All Tests Passed Successfully!!                                                  ");
            print( "                                                        Thank You                                                           ");
            print( "****************************************************************************************************************************");
        }
    }

    public void print(String item)
    {
        System.out.println(item);
    }

}
