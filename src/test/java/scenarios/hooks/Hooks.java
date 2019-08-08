package scenarios.hooks;

import enums.PropertiesPath;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.TestProperties;
import java.io.IOException;

import static setup.Driver.getDriver;
import static setup.Driver.prepareDriver;
import static setup.Driver.setProperties;

/**
 * The class for tests precondition and postcondition
 */
@Test(groups = {"native","web"})
public class Hooks {

    private PropertiesPath path;

    protected Hooks(PropertiesPath path) throws IOException {
        this.path = path;
    }

    /**
     * Loads properties and prepares driver
     * @throws Exception
     */
    @BeforeSuite(description = "Prepare driver to run tests")
    public void setUp() throws Exception {
        TestProperties properties = new TestProperties(path);
        setProperties(properties);
        prepareDriver();

    }

    /**
     * Closes driver
     * @throws Exception
     */
    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        try {
            getDriver().close();
        }
        catch (Exception e) {
            getDriver().closeApp();
        }
    }

}
