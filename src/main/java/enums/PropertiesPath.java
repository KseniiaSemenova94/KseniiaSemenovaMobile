package enums;

/**
 * The enum for possible paths to properties file
 */
public enum PropertiesPath {
    NATIVE_TEST_DATA("./src/test/resources/nativeTestData.properties"),
    WEB_TEST_DATA("./src/test/resources/webTestData.properties");

    final String name;

   PropertiesPath(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
