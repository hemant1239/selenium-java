package tests.ultimateQA;

import com.aventstack.extentreports.MediaEntityBuilder;
import framework.pages.UltimateQA.FormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UltimateQAFormTest extends BaseTest {

    FormPage formPage;

    @Test(priority = 1)
    public void validateFormSuccessMessage() throws Exception {
        formPage = new FormPage(driver);
        formPage.clickOnFormLink();
        test.info("Clicked on form link");
        formPage.enterName(FormPage.NAME);
        formPage.enterMessage(FormPage.MESSAGE);
        test.info("Added details in text fields");
        formPage.clickOnSubmit();
        Assert.assertEquals(formPage.getSuccessMessage(), FormPage.FORM_SUBMIT_SUCCESS);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(scUtil.getExtentScreenShot()).build());
    }

    @Test(priority = 2)
    public void validateEmptyCaptchaFieldMessage() throws Exception {
        formPage = new FormPage(driver);
        formPage.clickOnFormLink();
        test.info("Clicked on form link");
        formPage.enterNameCaptchaForm(FormPage.NAME);
        formPage.enterMessageCaptchaForm(FormPage.MESSAGE);
        test.info("Added details in text fields");
        formPage.clickOnSubmitCaptchaForm();
        Assert.assertEquals(formPage.getEmptyFieldName(), FormPage.CAPTCHA);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(scUtil.getExtentScreenShot()).build());
    }
}
