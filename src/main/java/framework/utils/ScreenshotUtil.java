package framework.utils;

import framework.constants.FrameworkConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String scDirPath = FrameworkConstants.SCREENSHOT_PATH + "/";
    private final WebDriver driver;
    public String commonPath = scDirPath + "screenshot_" + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()) + ".png";

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

    //To be used when screenshot is needed at some particular step and not in report
    public void getScreenShot() throws Exception {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(commonPath));
    }

    //Extent report screenshot
    public String getExtentScreenShot() {
        try {
            TakesScreenshot takeSc = (TakesScreenshot) driver;
            String sc = takeSc.getScreenshotAs(OutputType.BASE64);
            return "data:image/jpg;base64, " + sc;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}

