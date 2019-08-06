package setup;


import enums.BrowserName;
import enums.PlatformName;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;

public class Driver extends TestProperties {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    protected DesiredCapabilities capabilities;

    protected String AUT;
    protected String SUT;
    protected String TEST_PLATFORM;
    protected String DRIVER;
    protected String DEVICE;

    // Constructor initializes properties on driver creation
    protected Driver() throws IOException {
        AUT = getProp("aut");
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE = getProp("device");
    }

    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;
        switch (PlatformName.fromString(TEST_PLATFORM)) {
            case ANDROID:
                capabilities.setCapability(DEVICE_NAME, DEVICE);
                browserName = BrowserName.CHROME.getName();
                break;
            case IOS:
                browserName = BrowserName.SAFARI.getName();
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, web (or hybrid)
        if (AUT != null && SUT == null) {
            //Native
            File app = new File(AUT);
            capabilities.setCapability(APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability(BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // Init driver for local Appium server with capabilities have been set
        driver = new AppiumDriver(new URL(DRIVER), capabilities);
        wait = new WebDriverWait(driver, 10);
    }
}

