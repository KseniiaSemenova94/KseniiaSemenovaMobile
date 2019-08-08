package enums;

/**
 * The enum for possible browser names
 */
public enum BrowserName {

    CHROME("Chrome"),
    SAFARI("Safari");

    final String name;

    BrowserName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
