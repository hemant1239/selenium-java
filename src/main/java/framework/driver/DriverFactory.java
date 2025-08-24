package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    public static WebDriver getDriver(String browser) {
        if (tl.get() == null) {
            tl.set(create(browser));
        }
        return tl.get();
    }

    private static WebDriver create(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
            default:
                ChromeOptions cOpts = new ChromeOptions();
                if (Boolean.getBoolean("headless")) {
                    cOpts.addArguments("--headless=new");
                    cOpts.addArguments("--window-size=1920,1080");
                }
                return new ChromeDriver(cOpts);
        }
    }

    public static void quit() {
        if (tl.get() != null) {
            tl.get().quit();
            tl.remove();
        }
    }
}
