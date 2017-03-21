package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by shebbar on 06/03/17.
 */
public class DriverFactory {


    public static AppiumDriver driver;

    @BeforeClass
    public static void initialiseAppiumDriverAndroid() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        setupDevice(capabilities);
    }

    private static void setupDevice(DesiredCapabilities capabilities) throws MalformedURLException {

        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","6.0.1");
        capabilities.setCapability("deviceName", "Nexus 5");
        capabilities.setCapability("appPackage","com.aconex.field.mobile.ota");
        capabilities.setCapability("appActivity","com.aconex.field.mobile.ota.FieldActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


//        capabilities.setCapability("automtionName", "Appium");
//        capabilities.setCapability("platformName", "XCUITest");
//        capabilities.setCapability("platformVersion","10.2.1");
//        capabilities.setCapability("deviceName", "Bangalore Field Team iPad Air2");
//        capabilities.setCapability("udid", "1e662c60d3b9df0372ea2cc8a82f9fc0e411ef63");
//        capabilities.setCapability("bundleId", "com.aconex.field.mobile.dev");
//        capabilities.setCapability("xcodeConfigFile", "~/appium.xcconfig");
//
//        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LoginPage());
    }

    public static void chageDriverContexToWeb(){
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("WEBVIEW"))
                driver.context(contextName);
        }
    }

//    public static AppiumDriver getDriver() throws Exception {
//        if (driver == null) {
//            return initialiseAppiumDriverAndroid();
//        } else
//            return driver;
//    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
