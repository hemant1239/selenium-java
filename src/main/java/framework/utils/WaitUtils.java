package framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static final int DEFAULT_TIMEOUT = 10;
    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait(int timeOut) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }

    public WebElement waitForElementVisible(By locator, int timeOut) {
        return getWait(timeOut).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementVisible(By locator) {
        return getWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementVisible(By locator, int timeOut, int poolingTime) {
        return getWait(timeOut).pollingEvery(Duration.ofMillis(poolingTime)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
