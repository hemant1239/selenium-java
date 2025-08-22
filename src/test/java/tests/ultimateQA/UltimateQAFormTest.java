package tests.ultimateQA;

import com.aventstack.extentreports.MediaEntityBuilder;
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
        formTestData = JsonUtils.getJsonNode("src/test/resources/testdata/ultimateQA/formTestData.json");
        messageConstants = JsonUtils.getJsonNode("src/test/resources/testdata/ultimateQA/messageConstants.json");
    }

    @Test(priority = 1)
    public void shouldSubmitFormSuccessfully() throws Exception {
        formPage = new FormPage(driver);
        formPage.clickOnFormLink();
        test.info("Clicked on form link");
        formPage.enterName(formTestData.get("formFieldsTest").get("name").asText());
        formPage.enterMessage(formTestData.get("formFieldsTest").get("message").asText());
        test.info("Added details in text fields");
        formPage.clickOnSubmit();
        Assert.assertEquals(formPage.getSuccessMessage(), messageConstants.get("formMessages").get("formSuccess").asText(), "Success message is not as expected");
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(scUtil.getExtentScreenShot()).build());
    }

    @Test(priority = 2)
    public void validateEmptyCaptchaFieldMessage() throws Exception {
        formPage = new FormPage(driver);
        formPage.clickOnFormLink();
        test.info("Clicked on form link");
        formPage.enterNameCaptchaForm(formTestData.get("formFieldsTest").get("name").asText());
        formPage.enterMessageCaptchaForm(formTestData.get("formFieldsTest").get("message").asText());
        test.info("Added details in text fields");
        formPage.clickOnSubmitCaptchaForm();
        Assert.assertEquals(formPage.getEmptyFieldName(), messageConstants.get("formMessages").get("captcha").asText(), "Empty captcha message is not as expected");
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(scUtil.getExtentScreenShot()).build());
    }
}
