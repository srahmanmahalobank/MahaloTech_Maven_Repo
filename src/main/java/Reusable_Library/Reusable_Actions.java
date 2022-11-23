package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.Option;

import java.util.List;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.title;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class Reusable_Actions {

    //create a reusable method for web driver and chrome options
    public static WebDriver setDriver(){
        //setting up the path for the driver
        WebDriverManager.chromedriver().setup();
        //adding arguments
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //calling the driver
        WebDriver driver = new ChromeDriver(options);


        return driver;
    }//end of webDriver method


    //creating void click method for any web element
        public static void clickMethod(WebDriver driver, String xpath , String elementName) {

            //declare local explicit method
            WebDriverWait wait = new WebDriverWait(driver, 15);
            //click on track
            System.out.println("Clicking on Element " + elementName);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
            } catch (Exception e) {
                System.out.println("Unable to click on " + elementName + "Error" + e);
            }

        }//end of void clicking method

    //creating sendkeys method
    public static void sendKeys(WebDriver driver, String xpath, String userData, String elementName){

        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("send on " + elementName);
        try {
          WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
          element.clear();
          element.sendKeys(userData);
        }catch(Exception e){
            System.out.println("Unable to send on " + elementName + "Error:" + e);
        }

    }//end of sendKeys method

    public static String getTextFunction(WebDriver driver, String xpath, String elementName){

        String text = null;

        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Capturing text on" + elementName);
       
        try {
         WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
         text = element.getText();
        }catch(Exception e){
            System.out.println("Unable to send on " + "Error:" + e);
        }

        return text;
    }


    //creating void submit method for any web element
    public static void submitMethod(WebDriver driver, String xpath, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Submitting on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + " Error:" + e);
        }
    }//end of submit method

    //Creating JavaScript Executor
    public static void ScrollingByPixel(WebDriver driver, String x,String y){
    //calling JavaScript command

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll("+x+","+y+")");

      //Scroll vertically down by  pixels


    }//end of JavaScript Executor Method

    //method to select a drop down value by visible text
    public static void selectByVisibleText(WebDriver driver ,String locator ,String input, String elementName) {

        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Selecting value by text " + elementName);

        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(input);
        }catch(Exception e){
            System.out.println("Unable to catch the dropdown element " + elementName + " " + e);
        }

    }//end of selectValue by visible text method

    //method to select a drop down value by Value
    public static void selectByValue(WebDriver driver ,String locator , String elementName) {

        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Selecting value by text " + elementName);

        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Select dropDown = new Select(element);
            dropDown.selectByValue("");
        }catch(Exception e){
            System.out.println("Unable to catch the dropdown element " + elementName + " " + e);
        }

    }//end of selectValue by visible text method


    //method to select a drop down-value by Value
    public static void selectByIndex(WebDriver driver ,String locator , String elementName) {

        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Selecting value by text " + elementName);

        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Select dropDown = new Select(element);
            dropDown.selectByIndex(0);
        }catch(Exception e){
            System.out.println("Unable to catch the dropdown element " + elementName + " " + e);
        }

    }//end of selectValue by visible text method

    //method for click by index
    public static void clickByIndex(WebDriver driver, String locator, int number, String elementName){

        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Clicking by index " + elementName);

        try{
            List <WebElement> element =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
            element.get(number).click();

        }catch(Exception e){
            System.out.println("Unable to click on By Index " + elementName + e);
        }


    }//end of clickbyindex method


    //Method to verifying pages title
    public static void getTitleMethod (WebDriver driver, String ExpectedTitle){

        String titleOfPage = driver.getTitle();
        if (titleOfPage.contains( ExpectedTitle)){
            System.out.println("Title Matches with: " + ExpectedTitle);
        }else{
            System.out.println("Title does not match with: " + titleOfPage);
        }



    }//end of getting title method


    //Method to verifying pages title
    public static Comparable<String> getTitleMethodsReturn (WebDriver driver, String title){

        String titleOfPage = driver.getTitle();
        if (titleOfPage.equals(title)){
            System.out.println("Title Matches with: " + title);
        }else{
            System.out.println("Title does not match with: " + titleOfPage);
        }

        return titleOfPage;

    }//end of getting title method

    //Method for pop up blocks

    public void popUpBlockMethod(WebDriver driver){

        ChromeOptions option = new ChromeOptions();


    }

    //creating void mouseHover method for any web element
    public static void mouseHover(WebDriver driver, String xpath , ExtentTest logger, String elementName) {

        //declare local explicit method
        WebDriverWait wait = new WebDriverWait(driver, 15);
        //click on track
        System.out.println("Clicking on Element " + elementName);
        logger.log(LogStatus.INFO,"Hovering on element " + elementName);
        try {
            Actions action = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            action.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + "Error" + e);
            logger.log(LogStatus.FAIL,"Unable to hover on " + elementName + " Error:" + e);
        }

    }//end of void clicking method



}//end of java class
