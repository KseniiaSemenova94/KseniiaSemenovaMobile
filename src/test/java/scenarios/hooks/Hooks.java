package scenarios.hooks;

import enums.PropertiesPath;
import org.testng.annotations.*;
import setup.Driver;
import setup.TestProperties;


/**
 * The class for tests precondition and postcondition
 */
public class Hooks {

    protected Driver driver = new Driver();

    /**
     * Loads properties and prepares driver for native test(s)
     * @throws Exception
     */
    @BeforeGroups(groups = {"native"}, description = "Prepare driver to run tests")
    public void setUpNative() throws Exception {
        TestProperties properties = new TestProperties(PropertiesPath.NATIVE_TEST_DATA);
        driver.setProperties(properties);
        driver.prepareDriver();

    }

    /**
     * Loads properties and prepares driver for web test(s)
     * @throws Exception
     */
    @BeforeGroups(groups = {"web"}, description = "Prepare driver to run tests")
    public void setUpWeb() throws Exception {
        TestProperties properties = new TestProperties(PropertiesPath.WEB_TEST_DATA);
        driver.setProperties(properties);
        driver.prepareDriver();

    }

    /**
     * Closes driver
     * @throws Exception
     */
    @AfterGroups(groups = {"web", "native"}, description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.getDriver().quit();
        driver.refreshDriver();
    }

}
