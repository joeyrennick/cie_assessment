package cie.assessment.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUIElementHelpers {

    public static int waitTime = 10;

    /**
     * @param driver
     * @param element
     *            WebElement object to be evaluated for visibility
     * @return WebElement object that is displayed
     */
    public static boolean isDisplayed(WebDriver driver, WebElement element) {
        // This try-catch block is necessary for correct recovery behavior
        try {
            WebElement we = new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(element));
            return we.isDisplayed();
        } catch (TimeoutException e) {
            // This is expected if the WebElement exists but is not displayed,
            return false;
        }  catch (NoSuchElementException e) {
            // or
            // if the WebElement does not exist
            return false;
        }
    }

    /**
     * @param driver
     *            is the Selenium Web Driver
     * @param element
     *            WebElement object on the page
     * @param value
     *            the desired text string
     */
    public static void setText(WebDriver driver, WebElement element, String value) {
        element = elementToBeClickable(driver, element, waitTime);
        element.clear();
        element.sendKeys(value);
    }

    public static WebElement elementToBeClickable(WebDriver driver, WebElement element, int intWait) {
        return new WebDriverWait(driver, intWait).until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Helper method that waits for a specific WebElement to become clickable,
     * then clicks the WebElement.
     *
     * @param driver
     * @param element
     *            WebElement object to be clicked
     */
    public static void click(WebDriver driver, WebElement element) {
        element = elementToBeClickable(driver, element, waitTime);
        element.click();
    }

}
