package setup;


import enums.BrowserName;
import enums.PlatformName;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static enums.PropertiesKey.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;

public class Driver {

    private static AppiumDriver driverSingle;
    private static WebDriverWait waitSingle;

    public static String SUT;
    public static String BROWSER_TITLE;
    private static String AUT;
    private static String TEST_PLATFORM;
    private static String DRIVER;
    private static String DEVICE;

    /**
     * Sets test properties
     *
     * @param properties
     * @throws IOException
     */
    public static void setProperties(TestProperties properties) throws IOException {
        AUT = properties.getProp(AUT_KEY);
        SUT = properties.getProp(SUT_KEY);
        TEST_PLATFORM = properties.getProp(PLATFORM_KEY);
        DRIVER = properties.getProp(DRIVER_KEY);
        DEVICE = properties.getProp(DEVICE_KEY);
        BROWSER_TITLE = properties.getProp(BROWSER_TITLE_KEY);
    }

    /**
     * Initializes driver for Appium server with necessary capabilities
     *
     * @throws Exception
     */
    public static void prepareDriver() throws Exception {
        DesiredCapabilities capabilities = getCapabilities();
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        if (waitSingle == null) waitSingle = new WebDriverWait(driverSingle, 10);
    }

    /**
     * Gets driver singleton instance
     *
     * @return driver
     * @throws Exception
     */
    public static AppiumDriver getDriver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    /**
     * Gets driver's wait singleton
     * @return waitSingle
     */
    public static WebDriverWait driverWait() {
        return waitSingle;
    }

    /**
     * Gets browser name depends on current platform
     *
     * @param platform - platform name
     * @throws Exception
     */
    private static String getBrowserName(String platform) throws Exception {
        switch (PlatformName.fromString(platform)) {
            case ANDROID:
                return BrowserName.CHROME.getName();
            case IOS:
                return BrowserName.SAFARI.getName();
            default:
                return "Unknown mobile platform";
        }
    }

    /**
     * Gets capabilities for driver
     *
     * @return capabilities
     * @throws Exception
     */
    private static DesiredCapabilities getCapabilities() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, TEST_PLATFORM);
        capabilities.setCapability(DEVICE_NAME, DEVICE);
        // Setup type of application: mobile, web (or hybrid)
        if (AUT != null && SUT == null) {
            //Native
            File app = new File(AUT);
            capabilities.setCapability(APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability(BROWSER_NAME, getBrowserName(TEST_PLATFORM));
        } else {
            throw new Exception("Unclear type of mobile app");
        }
        return capabilities;
    }
}

