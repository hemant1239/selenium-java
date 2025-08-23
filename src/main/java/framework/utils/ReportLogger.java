package framework.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReportLogger {
    private final Logger logger;
    private final ExtentTest extentTest;

    public ReportLogger(Class<?> clazz, ExtentTest extentTest) {
        this.logger = LogManager.getLogger(clazz);
        this.extentTest = extentTest;
    }

    public void info(String message) {
        logger.info(message);
        extentTest.info(message);
    }

    public void error(String message, Throwable t) {
        logger.error(message, t);
        extentTest.fail(message + " | Exception: " + t.getMessage());
    }

    public void pass(String message, String sc) {
        logger.info("{}", message);
        extentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(sc).build());
    }

    public void fail(String message, String sc) {
        logger.error("{}", message);
        extentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(sc).build());
    }

    public void skip(String message) {
        logger.info("{}", message);
        extentTest.skip(message);
    }
}
