package scenarios.webTests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import scenarios.hooks.Hooks;
import setup.Driver;

import java.io.IOException;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {
    protected SimpleWebTests() throws IOException {
        super();
    }

    @Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get(SUT);
    // this always ends OK; it's a drawback.
        wait.until(ExpectedConditions.urlToBe(SUT+"/"));
        System.out.println("Site opening done");
    }

}
