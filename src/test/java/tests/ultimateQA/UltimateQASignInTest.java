package tests.ultimateQA;

import com.aventstack.extentreports.MediaEntityBuilder;
import framework.pages.UltimateQA.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UltimateQASignInTest extends BaseTest {

    SignInPage signInPage;

    @Test
    public void validateInvalidCredentials() throws Exception {
        signInPage = new SignInPage(driver);
        signInPage.clickLoginLink();
        signInPage.enterEmail(SignInPage.invalidUserName);
        signInPage.enterPassword(SignInPage.invalidPassword);
        test.info("Entered credentials");
        signInPage.clickSignIn();
        Assert.assertEquals(signInPage.getSignInErrorMessage(), SignInPage.signInErrorMessage);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(scUtil.getExtentScreenShot()).build());
    }
}
