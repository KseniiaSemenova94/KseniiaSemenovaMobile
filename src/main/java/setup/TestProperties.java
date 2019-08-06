package setup;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class TestProperties {
    Properties currentProps = new Properties();

    Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/nativeTestData.properties");
        currentProps.load(in);
        in.close();
        return currentProps;
    }
        protected String getProp(String propKey) throws IOException {
        if(!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        // "default" form used to handle the absence of parameter
            return currentProps.getProperty(propKey, null);
    }
}
