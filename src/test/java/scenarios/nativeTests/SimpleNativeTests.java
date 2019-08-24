package scenarios.nativeTests;

import org.testng.annotations.Test;
import pages.nativeAppPages.contactManagerPages.AddContactPage;
import pages.nativeAppPages.contactManagerPages.MainPage;
import scenarios.hooks.Hooks;

/**
 * Tests for native application
 */
public class SimpleNativeTests extends Hooks {

    /**
     * Opens "Add Contact" page and checks its elements
     * @throws Exception
     */
    @Test(groups = {"native"}, description = "Clicks on button 'Add contact' and checks result")
    public void appContactManagerTest() throws Exception {
        new MainPage(driver.getDriver()).clickAddButton();
        AddContactPage addContactPage = new AddContactPage(driver.getDriver());
        addContactPage.checkTargetAccountFieldIsDisplayed();
        addContactPage.checkContactNameFieldIsDisplayed();
        addContactPage.checkContactPhoneFieldIsDisplayed();
        addContactPage.checkContactEmailFieldIsDisplayed();
        addContactPage.checkKeyboardIsVisible();
    }
}
