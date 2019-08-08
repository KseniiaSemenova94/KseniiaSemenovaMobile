package scenarios.nativeTests;

import enums.PropertiesPath;
import org.testng.annotations.Test;
import pages.nativeAppPages.contactManagerPages.AddContactPage;
import pages.nativeAppPages.contactManagerPages.MainPage;
import scenarios.hooks.Hooks;
import java.io.IOException;

import static setup.Driver.getDriver;

/**
 * Tests for native application
 */
@Test(groups = "native")
public class SimpleNativeTests extends Hooks {

    protected SimpleNativeTests() throws IOException {
        super(PropertiesPath.NATIVE_TEST_DATA);
    }

    /**
     * Opens "Add Contact" page and checks its elements
     * @throws Exception
     */
    @Test(description = "Clicks on button 'Add contact' and checks result")
    public void appContactManagerTest() throws Exception {
        new MainPage(getDriver()).clickAddButton();
        AddContactPage addContactPage = new AddContactPage(getDriver());
        addContactPage.checkTargetAccountFieldIsDisplayed();
        addContactPage.checkContactNameFieldIsDisplayed();
        addContactPage.checkContactPhoneFieldIsDisplayed();
        addContactPage.checkContactEmailFieldIsDisplayed();
        addContactPage.checkKeyboardIsVisible();
    }
}
