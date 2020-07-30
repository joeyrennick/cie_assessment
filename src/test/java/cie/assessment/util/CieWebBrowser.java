package cie.assessment.util;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CieWebBrowser {


    private static final Logger logger = LoggerFactory.getLogger(CieWebBrowser.class);
    private String cieHost;
    private String webBrowserType;
    private WebDriver webDriver;


    public CieWebBrowser(String cieHost, String webBrowserType) {
        Validate.notEmpty(cieHost);
        this.cieHost = cieHost;
        logger.info("Creating Web Browser for host {{}} browser type {{}}", cieHost, "DEFAULT");

        this.webBrowserType = webBrowserType;
    }

    public void start() {
        logger.info("Starting Web Browser");
        webDriver = createWebDriver();
    }

    public void close() {
        if (webDriver != null) {
            logger.info("Closing Web Browser");
            webDriver.quit();
        }
    }

    private WebDriver createWebDriver() {
        WebDriver driver = WebDriverFactory.getDriver(cieHost, webBrowserType, true);
        return driver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
