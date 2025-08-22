package tests.ultimateQA;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import framework.driver.DriverFactory;
import framework.utils.ConfigReader;
import framework.utils.ReportManager;
import framework.utils.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    protected static ExtentReports extent;
    protected WebDriver driver;
    protected ExtentTest test;
    protected ScreenshotUtil scUtil;
    protected Logger logger;

    @BeforeSuite
    public void setUpReport() {
        extent = ReportManager.getInstance();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, Method method) {
        //Logs and screenshot setup
        test = extent.createTest(method.getName());
        logger = LogManager.getLogger(this.getClass());
        //Driver setup
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("ultimateQAUrl"));
        scUtil = new ScreenshotUtil(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed: " + testName)
                    .fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed: " + testName);
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped: " + testName);
        }
        DriverFactory.quit();
    }

    @AfterSuite
    public void tearDownAndFlushReport() {
        extent.flush();
    }
}
