package cie.assessment.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;

public class CieScreenShot {

    private static final Logger logger = LoggerFactory.getLogger(CieScreenShot.class);
    public final static String SCREENSHOTS_PATH = "target/screenshots/";

    public static void takeScreenShotOnFailure(ITestResult result, WebDriver driver) {
        if (result.getStatus() == ITestResult.FAILURE && driver != null) {
            String timeStamp = new DateTime().toString().substring(0, 19);
            String fileName = String.format("%s.%s_[%s]_%s.png", result.getInstance().getClass().getSimpleName(), result.getMethod().getMethodName(),
                    Thread.currentThread().getName(), timeStamp);
            takeScreenshot(driver, SCREENSHOTS_PATH, fileName);
        }
    }

    public static void takeScreenshot(WebDriver driver, String filepath, String filename) {
        String filepathAndName = (filepath + filename);
        File scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrnshot, new File(filepathAndName));
        } catch (IOException e) {
            logger.error("Could not save snapshot to disk", e);
        }
    }

}
