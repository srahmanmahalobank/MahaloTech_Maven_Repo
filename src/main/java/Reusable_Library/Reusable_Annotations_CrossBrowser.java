package Reusable_Library;

import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Reusable_Annotations_CrossBrowser {
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @Parameters("Browser")
    @BeforeSuite
    public void SetDriverAndReport(String Browser){
        if(Browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if(Browser.equalsIgnoreCase("Chrome")) {
            //setup chrome driver
            WebDriverManager.chromedriver().setup();
            //declare and define the chrome options
            ChromeOptions options = new ChromeOptions();
            //declare all the arguments you need
            //to maximize my driver
            options.addArguments("start-maximized");
            //options.addArguments("fullscreen"); //for mac users
            //set as incognito mode
            options.addArguments("incognito");
            //set as headless(running the driver on background)
            //options.addArguments("headless");
            //define the web driver you are using
            driver = new ChromeDriver(options);
        }else if(Browser.equalsIgnoreCase("Safari")){
            WebDriverManager.safaridriver().setup();
            driver.manage().window().fullscreen();
        }
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report_"+ Reusable_Actions_Loggers.getDateTime()+".html",true);
    }//end of before suite

    @BeforeMethod
    public void captureTestName(Method methodName){
        logger = reports.startTest(methodName.getName());
    }//end of before method

    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void endOfTestSuite(){
        //driver.quit();
        reports.flush();
    }//end of after suite


}
