package setup;

import enums.PropertiesKey;
import enums.PropertiesPath;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

/**
 * The class for properties handling
 */
public class TestProperties {
    Properties currentProps;
    PropertiesPath propertyPath;

    public TestProperties(PropertiesPath path) {
        this.currentProps = new Properties();
        this.propertyPath = path;
    }

    /**
     * Gets property by key
     * @throws IOException
     */
    String getProp(PropertiesKey propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        return currentProps.getProperty(propKey.getName(), null);
    }

    /**
     * Gets current properties
     * @throws IOException
     */
    private Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(this.propertyPath.getName());
        currentProps.load(in);
        in.close();
        return currentProps;
    }
}
