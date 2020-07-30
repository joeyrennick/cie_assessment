package cie.assessment.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.commons.lang3.SystemUtils.OS_NAME;

/**
 * This class is used to create instances of the various WebDriver
 * implementations . Current available implementations<br>
 * <ul>
 * <li>ChromeDriver
 * </ul>
 */
public class WebDriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);

    private static final String CHROME = "chrome";
    private static final String MAC_OSX = "Mac OS X";

    private WebDriverFactory() {
    }

    /**
     * Public method used to return a browser specific implementation of the
     * WebDriver interface.
     *
     * @param page       - Initial page to navigate to (URL's String representation)
     * @param driverType - Driver type desired (i.e. FF, Chrome, IE, Safari)
     * @return WebDriver
     */
    public static WebDriver getDriver(String page, String driverType) {
        return getDriver(page, driverType, false);
    }

    public static WebDriver getDriver(String page, String driverType, boolean showConsole) {
        WebDriver driver = null;
        String driverBinary = "";
        logger.info("Getting OS");
        String operatingSystem = System.getProperty(OS_NAME);

        if (driverType == null || driverType.equalsIgnoreCase(CHROME) || driverType.equalsIgnoreCase("DEFAULT") || driverType.isEmpty()) {
            driverBinary = System.getProperty("user.dir") + "/src/test/drivers/chromedriver";
        }
        System.setProperty("webdriver.chrome.driver", driverBinary);

        try {
            driver = new ChromeDriver();
        } catch (WebDriverException wde) {
            logger.warn("Chrome browser launch attempt failed with error" + wde);
        }

        driver.get(page);

        return driver;
    }
}

