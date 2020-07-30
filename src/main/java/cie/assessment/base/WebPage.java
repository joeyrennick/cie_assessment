package cie.assessment.base;

import cie.assessment.util.CommonUIElementHelpers;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebPage {

    protected final WebDriver driver;

    protected final String className;


    protected WebPage(WebDriver driver) {
        this.driver = driver;
        className = getClass().getSimpleName();
    }

    protected final void verifyNavigation(WebElement uniqueElement) {
        if (!CommonUIElementHelpers.isDisplayed(driver, uniqueElement)) {
            throw new InvalidElementStateException(String.format("%s.verifyNavigation: Could not verify navigation.", className));
        }
    }
}
