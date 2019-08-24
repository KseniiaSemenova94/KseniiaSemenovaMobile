package scenarios.webTests;

import org.testng.annotations.Test;
import pages.webSitePages.ianaOrgPages.MainPage;
import scenarios.hooks.Hooks;

/**
 * Tests for web application
 */
public class SimpleWebTests extends Hooks {

    /**
     * Opens website home page and checks result
     * @throws Exception
     */
   @Test(groups = {"web"}, description = "Opens home page and checks title and status")
   public void siteIanaOrgTest() throws Exception {
       MainPage mainPage = new MainPage(driver.getDriver());
       mainPage.openPage(driver.SUT);
       mainPage.checkPageIsOpened(driver.BROWSER_TITLE);
       mainPage.checkPageStatusCode(driver.SUT);
    }
}
