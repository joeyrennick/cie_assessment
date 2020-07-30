package cie.assessment;

import cie.assessment.base.BrowserPerClassTest;
import cie.assessment.pages.LandingPage;
import cie.assessment.pages.LoginPage;
import cie.assessment.util.CommonUIElementHelpers;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BrowserPerClassTest {

    @Test
    public void loginBasic() {

        String email = "hello@ciedigital.com";
        String password = "Test 1234";

        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);

        try {
            loginPage.loginCie(email, password);
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
