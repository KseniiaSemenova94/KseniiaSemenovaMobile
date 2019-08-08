package pages.webSitePages.ianaOrgPages;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.http.HttpStatus;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static setup.Driver.driverWait;

/**
 * The class represents home page of website https://www.iana.org
 */
public class MainPage {

    private AppiumDriver driver;

    public MainPage(AppiumDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Opens home page of the website
     *
     * @param sut - website URL
     */
    public void openPage(String sut) {
        driver.get(sut);
        driverWait().until(ExpectedConditions.urlToBe(sut + "/"));
    }

    /**
     * Checks that browser title is correct
     *
     * @param browserTitle
     */
    public void checkPageIsOpened(String browserTitle) {
        assertEquals(driver.getTitle(), browserTitle, "Browser title is not correct");
    }

    /**
     * Checks that Status Code is OK (200)
     *
     * @param url - website URL
     */
    public void checkPageStatusCode(String url) {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }
}
