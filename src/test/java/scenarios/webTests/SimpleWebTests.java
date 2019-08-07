package scenarios.webTests;

import enums.PropertiesPath;
import org.testng.annotations.Test;
import pages.webSitePages.ianaOrgPages.MainPage;
import scenarios.hooks.Hooks;
import java.io.IOException;

import static setup.Driver.*;

/**
 * Tests for web apps
 */
@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    protected SimpleWebTests() throws IOException {
        super(PropertiesPath.WEB_TEST_DATA);
    }

    /**
     * Opens website home page and checks result
     * @throws Exception
     */
   @Test(description = "Opens home page and checks title and status")
   public void siteIanaOrgTest() throws Exception {
       MainPage mainPage = new MainPage(getDriver());
       mainPage.openPage(SUT);
       mainPage.checkPageIsOpened(BROWSER_TITLE);
       mainPage.checkPageStatusCode(SUT);
    }
}
