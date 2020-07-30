package cie.assessment;

import cie.assessment.base.BrowserPerClassTest;
import cie.assessment.pages.LandingPage;
import cie.assessment.pages.CieLoginPage;
import cie.assessment.util.CommonUIElementHelpers;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CieLoginTest extends BrowserPerClassTest {

    private static final String EMAIL = "hello@ciedigital.com";
    private static final String PASSWORD = "hello@ciedigital.com";

    @Test
    public void loginBasic() {
        WebDriver driver = getDriver();
        CieLoginPage cieLoginPage = new CieLoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);

        try {
            cieLoginPage.loginCie(EMAIL, PASSWORD);
        } catch (TimeoutException e) {
            Assert.fail("Timeout encountered while trying to login");
        }
        /*
        Here we want to assert that the landing page has been loaded
        To accomplish this we may want to use the "LandingPage" object.
        We would the return the Element that we are
        looking for and then use the CommonUIElementHelpers.isDisplayed() within the Assert
        to verify that the landing page has been loaded.
         */
        WebElement webElement = landingPage.getSomeElement();
        Assert.assertTrue(CommonUIElementHelpers.isDisplayed(driver, webElement), "Login was unsuccessful!");
    }
}
