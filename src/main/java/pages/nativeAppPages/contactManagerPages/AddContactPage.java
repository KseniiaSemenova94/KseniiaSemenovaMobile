package pages.nativeAppPages.contactManagerPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * The class which represents "Add Contact" page in Contact Manager app
 */
public class AddContactPage {

    private AppiumDriver driver;


    @AndroidFindBy(id = "com.example.android.contactmanager:id/accountSpinner")
    @iOSFindBy()
    private MobileElement targetAccountField;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactNameEditText")
    private MobileElement contactNameField;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactPhoneEditText")
    private MobileElement contactPhoneField;

    @AndroidFindBy(id = "com.example.android.contactmanager:id/contactEmailEditText")
    private MobileElement contactEmailField;

    public AddContactPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Assert that "Target Account" field is visible
     */
    public void checkTargetAccountFieldIsDisplayed() {
        assertTrue(targetAccountField.isDisplayed());
    }

    /**
     * Assert that "Contact Name" field is visible
     */
    public void checkContactNameFieldIsDisplayed() {
        assertTrue(contactNameField.isDisplayed());
    }

    /**
     * Assert that "Contact Phone" field is visible
     */
    public void checkContactPhoneFieldIsDisplayed() {
        assertTrue(contactPhoneField.isDisplayed());
    }

    /**
     * Asserts that "Contact Email" field is visible
     */
    public void checkContactEmailFieldIsDisplayed() {
        assertTrue(contactEmailField.isDisplayed());
    }

    /**
     * Asserts that keyboard is displayed
     */
    public void checkKeyboardIsVisible() throws Exception {
        assertNotNull(driver.getKeyboard());
    }
}
