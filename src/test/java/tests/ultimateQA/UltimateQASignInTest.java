package tests.ultimateQA;

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
        messageConstants = JsonUtils.getJsonNode("src/test/resources/testdata/ultimateQA/messageConstants.json").get("signInMessages");
    }

    @Test
    public void validateInvalidCredentials() throws Exception {
        signInPage = new SignInPage(driver);
        signInPage.clickLoginLink();
        signInPage.enterEmail(ConfigReader.get("invalidUserName"));
        reportLogger.info("Entered user name");
        signInPage.enterPassword(ConfigReader.get("invalidPassword"));
        reportLogger.info("Entered password");
        signInPage.clickSignIn();
        reportLogger.info("Clicked on sign in button");
        Assert.assertEquals(signInPage.getSignInErrorMessage(), messageConstants.get("invalidCredentialsMessage").asText(), "Sign in invalid validation failed");
    }
}
