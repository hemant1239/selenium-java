package framework.pages.UltimateQA;

import framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;

public class SignInPage {
    private final WebDriver driver;
    private final WaitUtils wait;
    //Locators
    private final By loginAutomationLink = By.linkText("Login automation");
    private final By emailInput = By.cssSelector("input[id='user[email]']");
    private final By passwordInput = By.cssSelector("input[id='user[password]']");
    private final By signInButton = By.xpath("//button[contains(text(),'Sign in')]");
    private final By signInErrorText = By.cssSelector(".form-error__list-item");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public void clickLoginLink() {
        wait.waitForElementVisible(loginAutomationLink).click();
    }

    public void enterEmail(String email) {
        wait.waitForElementVisible(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignIn() {
        WebElement signIn = driver.findElement(signInButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signIn);
    }

    public Optional<String> getSignInErrorMessage() {
        try {
            return Optional.of(wait.waitForElementVisible(signInErrorText, 1).getText());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
