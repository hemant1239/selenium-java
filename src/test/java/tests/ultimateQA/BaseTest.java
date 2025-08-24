package tests.ultimateQA;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import framework.driver.DriverFactory;
import framework.utils.ConfigReader;
import framework.utils.ReportLogger;
import framework.utils.ReportManager;
import framework.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    protected static ExtentReports extent;
    protected WebDriver driver;
    protected ExtentTest test;
    protected ScreenshotUtil scUtil;
    protected ReportLogger reportLogger;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, Method method) {
        String testName = method.getName() + " [" + browser.toUpperCase() + "] ";
        ReportManager.createTest(testName);
        reportLogger = new ReportLogger(this.getClass(), ReportManager.getTest());
        reportLogger.info("STARTED TEST: " + method.getName());
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("ultimateQAUrl"));
        scUtil = new ScreenshotUtil(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        if (result.getStatus() == ITestResult.FAILURE) {
            reportLogger.fail("TEST FAILED:" + testName + " " + result.getThrowable(), scUtil.getExtentScreenShot());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            reportLogger.pass("TEST PASSED: " + testName, scUtil.getExtentScreenShot());
        } else if (result.getStatus() == ITestResult.SKIP) {
            reportLogger.skip("TEST SKIPPED: " + testName);
        }
        DriverFactory.quit();
    }

    @AfterSuite
    public void flushReport() {
        ReportManager.flushReports();
    }
}
