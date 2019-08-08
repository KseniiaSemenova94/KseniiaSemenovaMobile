package pages.nativeAppPages.contactManagerPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

/**
 * The class which represents start page in Contact Manager app
 */
public class MainPage {

    @AndroidFindBy(id = "com.example.android.contactmanager:id/addContactButton")
    private MobileElement addButton;

    public MainPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Asserts that "Add Contact" button is displayed and clicks on it
     */
    public void clickAddButton() throws Exception{
       assertTrue(addButton.isDisplayed());
       addButton.click();
    }
}
