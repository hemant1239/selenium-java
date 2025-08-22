package tests.ultimateQA;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import framework.pages.UltimateQA.SignInPage;
import framework.utils.ConfigReader;
import framework.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UltimateQASignInTest extends BaseTest {

    SignInPage signInPage;
    private JsonNode messageConstants;

    @BeforeClass
    public void dataSetup() {
        messageConstants = JsonUtils.getJsonNode("src/test/resources/testdata/ultimateQA/messageConstants.json");
    }

    @Test
    public void validateInvalidCredentials() throws Exception {
        signInPage = new SignInPage(driver);
        signInPage.clickLoginLink();
        signInPage.enterEmail(ConfigReader.get("invalidUserName"));
        logger.info("Entered user name");
        signInPage.enterPassword(ConfigReader.get("invalidPassword"));
        logger.info("Entered password");
        test.info("Entered credentials");
        signInPage.clickSignIn();
        logger.info("Clicked on sign in button");
        Assert.assertEquals(signInPage.getSignInErrorMessage(), messageConstants.get("signInMessages").get("invalidCredentialsMessage").asText(), "Sign in invalid validation failed");
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(scUtil.getExtentScreenShot()).build());
    }
}
