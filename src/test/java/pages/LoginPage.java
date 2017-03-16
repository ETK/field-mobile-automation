package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

import static utils.DriverFactory.chageDriverContexToWeb;

/**
 * Created by shebbar on 06/03/17.
 */
public class LoginPage extends BasePage {


    @FindBy(css = ".uiButton.uxBorder.icon.ic-close")
    private static WebElement closeGuide;

    @FindBy(id = "fm-logon-username-field")
    private static WebElement userId;

    @FindBy(id ="fm-logon-password-field")
    private static WebElement password;


    public LoginPage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(driver),new HomePage());
    }

    public static void login() throws InterruptedException {
        chageDriverContexToWeb();
        closeGuide.click();
        userId.click();
        userId.sendKeys("mjenner");
        password.click();
        password.sendKeys("Auth3nt1c");

    }


}
