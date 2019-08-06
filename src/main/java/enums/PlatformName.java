package enums;

public enum PlatformName {

    ANDROID("Android"),
    IOS("iOS");

    final String name;

    PlatformName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PlatformName fromString(String text) {
        for (PlatformName b : PlatformName.values()) {
            if (b.getName().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
