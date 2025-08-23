package tests.ultimateQA;

import com.fasterxml.jackson.databind.JsonNode;
import framework.pages.UltimateQA.FormPage;
import framework.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UltimateQAFormTest extends BaseTest {
    FormPage formPage;
    private JsonNode formTestData;
    private JsonNode messageConstants;

    @BeforeClass
    public void dataSetup() {
        formTestData = JsonUtils.getJsonNode("src/test/resources/testdata/ultimateQA/formTestData.json").get("formFieldsTest");
        messageConstants = JsonUtils.getJsonNode("src/test/resources/testdata/ultimateQA/messageConstants.json").get("formMessages");
    }

    @Test(priority = 1)
    public void shouldSubmitFormSuccessfully() throws Exception {
        formPage = new FormPage(driver);
        formPage.clickOnFormLink();
        reportLogger.info("Clicked on form link");
        formPage.enterName(formTestData.get("name").asText());
        formPage.enterMessage(formTestData.get("message").asText());
        reportLogger.info("Added details in text fields");
        formPage.clickOnSubmit();
        Assert.assertEquals(formPage.getSuccessMessage(), messageConstants.get("formSuccess").asText(), "Success message is not as expected");
    }

    @Test(priority = 2)
    public void validateEmptyCaptchaFieldMessage() throws Exception {
        formPage = new FormPage(driver);
        formPage.clickOnFormLink();
        reportLogger.info("Clicked on form link");
        formPage.enterNameCaptchaForm(formTestData.get("name").asText());
        formPage.enterMessageCaptchaForm(formTestData.get("message").asText());
        reportLogger.info("Added details in text fields");
        formPage.clickOnSubmitCaptchaForm();
        Assert.assertEquals(formPage.getEmptyFieldName(), messageConstants.get("captcha").asText(), "Empty captcha message is not as expected");
    }
}
