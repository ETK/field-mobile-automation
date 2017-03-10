package pages;

import io.appium.java_client.AppiumDriver;
import utils.DriverFactory;

import java.net.MalformedURLException;

/**
 * Created by shebbar on 09/03/17.
 */
public class BasePage {

//    public static AppiumDriver driver;

    protected static AppiumDriver driver = DriverFactory.driver;


//    public BasePage() throws MalformedURLException {
//        driver = DriverFactory.initialiseAppiumDriverAndroid();
//    }
}
