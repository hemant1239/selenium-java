package framework.pages.UltimateQA;

import framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private final WebDriver driver;
    private final WaitUtils wait;
    //Locators
    private final By loginAutomationLink = By.cssSelector("a[href='http://courses.ultimateqa.com/users/sign_in']");
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
        driver.findElement(signInButton).click();
    }

    public String getSignInErrorMessage() {
        try {
            wait.waitForElementVisible(signInErrorText, 1);
            return driver.findElement(signInErrorText).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
