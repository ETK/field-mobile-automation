package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * Created by shebbar on 07/03/17.
 */
public class HomePage extends BasePage{

    public HomePage() throws MalformedURLException {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void homeTest() {
        System.out.println("hello");
    }
}
