import Reusable_Library.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import org.testng.annotations.Test;

public class PortalPay_LoanPayments extends Reusable_Annotations {

    @Test
    public void LoanPayments() throws InterruptedException {

        logger = reports.startTest("Use Portal Pay to make loan payments ");

        //Nav to
        driver.navigate().to("https://tlcu-web.mahalocloud.org/");

        //Enter username in Sign in field
        Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@id='username_field']","frankiiv5",logger,"User Name");

        //Enter PW in Sign in field
        Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@id='password_field']","Purple2018!",logger,"PassWord");

        Thread.sleep(2000);
        //CLick on Sign in Button
        Reusable_Actions_Loggers.clickMethod(driver,"//*[@id='signin_button']",logger,"Sign in button");





    }//end of test annotations







}//end of Java class
