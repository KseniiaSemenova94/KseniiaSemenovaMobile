package enums;

/**
 * The enum for possible properties
 */
public enum  PropertiesKey {
    AUT_KEY("aut"),
    SUT_KEY("sut"),
    BROWSER_TITLE_KEY("browserTitle"),
    DRIVER_KEY("driver"),
    PLATFORM_KEY("platform"),
    UDID_KEY("udid"),
    APP_ACTIVITY_KEY("appActivity"),
    APP_PACKAGE_KEY("appPackage");

    final String name;

    PropertiesKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
