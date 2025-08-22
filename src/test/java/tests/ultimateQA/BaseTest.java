package tests.ultimateQA;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import framework.driver.DriverFactory;
import framework.utils.ConfigReader;
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

    @BeforeSuite
    public void setUpReport() {
        extent = ReportManager.getInstance();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, Method method) {
        String url = ConfigReader.get("url");
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        test = extent.createTest(method.getName());
        scUtil = new ScreenshotUtil(driver);
        driver.get(url);
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
    }

    @AfterSuite
    public void tearDownAndFlushReport() {
        if (driver != null) driver.quit();
        extent.flush();
    }
}
