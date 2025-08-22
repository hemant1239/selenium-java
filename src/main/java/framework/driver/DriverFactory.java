package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver = null;

    private DriverFactory() {
    }

    public static WebDriver getDriver(String driverName) {
        if (driver == null) {
            if (driverName.equalsIgnoreCase("chrome"))
                driver = new ChromeDriver();
            else if (driverName.equalsIgnoreCase("firefox"))
                driver = new FirefoxDriver();
        }
        return driver;
    }
}
