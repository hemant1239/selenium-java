package framework.pages.UltimateQA;

import framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    private final WebDriver driver;
    private final WaitUtils wait;
    // Locators
    private final By fillFormLink = By.cssSelector("a[href='https://ultimateqa.com/filling-out-forms/']");
    private final By nameInput = By.cssSelector("#et_pb_contact_name_0");
    private final By nameCaptchaInput = By.cssSelector("#et_pb_contact_name_1");
    private final By messageInput = By.cssSelector("#et_pb_contact_message_0");
    private final By messageCaptchaInput = By.cssSelector("#et_pb_contact_message_1");
    private final By submitButton = By.xpath("//div[@id=\"et_pb_contact_form_0\"]//button");
    private final By submitCaptchaButton = By.xpath("//div[@id=\"et_pb_contact_form_1\"]//button");
    private final By successText = By.cssSelector("#et_pb_contact_form_0 > div > p");
    private final By emptyFieldsText = By.cssSelector("#et_pb_contact_form_1 > div > p");
    private final By emptyFieldsListText = By.cssSelector("#et_pb_contact_form_1 > div > ul > li");

    public FormPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public void clickOnFormLink() {
        wait.waitForElementVisible(fillFormLink).click();
    }

    public void enterName(String name) {
        wait.waitForElementVisible(nameInput, 10).sendKeys(name);
    }

    public void enterMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
    }

    public void clickOnSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return wait.waitForElementVisible(successText).getText();
    }

    public void enterNameCaptchaForm(String name) {
        wait.waitForElementVisible(nameCaptchaInput).sendKeys(name);
    }

    public void enterMessageCaptchaForm(String message) {
        driver.findElement(messageCaptchaInput).sendKeys(message);
    }

    public void clickOnSubmitCaptchaForm() {
        driver.findElement(submitCaptchaButton).click();
    }

    public String getEmptyFieldName() {
        return wait.waitForElementVisible(emptyFieldsListText).getText();
    }
}
