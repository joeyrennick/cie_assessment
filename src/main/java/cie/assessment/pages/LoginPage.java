package cie.assessment.pages;

import cie.assessment.base.WebPage;
import cie.assessment.util.CommonUIElementHelpers;
import net.lightbody.bmp.proxy.jetty.log.LogImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends WebPage {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private static final String LOCATOR_LOGIN_FORM = "#login_form";

    @FindBy(css = LOCATOR_LOGIN_FORM)
    private WebElement loginForm;

    @FindBy(id = "login-email-field")
    private WebElement editboxEmail;

    @FindBy(id = "login-password-field")
    private WebElement editboxPassword;

    @FindBy(id = "login-login-button")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //We would want to have some sort of verification of navigation here
        //verifyNavigation(loginForm);
    }

    public LoginPage loginCie(String email, String password) {
        setEmail(driver, email);
        setPassword(driver, password);
        clickLogin(driver);
        return new LoginPage(driver);
    }

    /**
     * Public method that fills the editboxEmail editbox field. Intended for
     * future access by negative-tests of the login page.
     *
     * @param driver
     * @param email
     */
    public void setEmail(WebDriver driver, String email) {
        logger.trace("method: {}.setEmail", className);
        logger.trace("parameter: email = {}", email);

        CommonUIElementHelpers.setText(driver, editboxEmail, email);
    }

    /**
     * Public method that fills the password editbox field. Intended for future
     * access by negative-tests of the login page.
     *
     * @param driver
     * @param password
     */
    public void setPassword(WebDriver driver, String password) {
        logger.trace("method: {}.setPassword", className);
        logger.trace("parameter: password = {}", password);

        CommonUIElementHelpers.setText(driver, editboxPassword, password);
    }

    /**
     * Public method that clicks the 'Login' button. Intended for future access
     * by negative-tests of the login page.
     */
    public void clickLogin(WebDriver driver) {
        logger.trace("method: {}.clickLogin", className);
        CommonUIElementHelpers.click(driver, buttonLogin);
    }
}
