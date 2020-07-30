package cie.assessment.base;
import cie.assessment.util.CieScreenShot;
import cie.assessment.util.CieWebBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BrowserPerClassTest {

    // Current thread's Web Browser
    private static ThreadLocal<CieWebBrowser> threadTestBrowser = new ThreadLocal<CieWebBrowser>();

    @BeforeClass(alwaysRun = true)
    protected final void beforeClassBrowserTest(ITestContext context) {
        threadTestBrowser.set(createAndStartWebBrowser());
    }

    @AfterClass(alwaysRun = true)
    protected final void afterClassBrowserTest() {
        if (threadTestBrowser != null) {
            closeWebBrowser(threadTestBrowser.get());
            threadTestBrowser.remove();
        }

    }

    @AfterMethod(alwaysRun = true)
    protected final void afterMethodBrowserTest(ITestResult result) {
        if (threadTestBrowser != null) {
            CieScreenShot.takeScreenShotOnFailure(result, threadTestBrowser.get().getWebDriver());
        }
    }

    protected CieWebBrowser createWebBrowser() {
        return new CieWebBrowser("http://www.google.com", "chrome");
    }
    protected CieWebBrowser createAndStartWebBrowser() {
        CieWebBrowser cieWebBrowser = createWebBrowser();
        cieWebBrowser.start();
        return cieWebBrowser;
    }

    protected void closeWebBrowser(CieWebBrowser cieWebBrowser) {
        if(cieWebBrowser != null) {
            cieWebBrowser.close();
        }
    }

    protected WebDriver getDriver() {
        WebDriver webDriver = null;

        if (threadTestBrowser.get() != null) {
            webDriver = threadTestBrowser.get().getWebDriver();
        }

        return webDriver;
    }
}
