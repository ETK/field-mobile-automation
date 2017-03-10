package steps;

import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import pages.LoginPage;
import utils.DriverFactory;

import java.net.MalformedURLException;
import java.sql.Driver;

/**
 * Created by shebbar on 06/03/17.
 */
public class LoginSteps {

    @Test
    public void login() throws InterruptedException, MalformedURLException {
        DriverFactory.initialiseAppiumDriverAndroid();
        LoginPage.login();
    }

}
