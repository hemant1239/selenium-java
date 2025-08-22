package framework.constants;

public class FrameworkConstants {

    private FrameworkConstants() {
        // private constructor to avoid instantiation
    }

    // Paths
    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    public static final String REPORT_PATH = System.getProperty("user.dir") + "/target/reports/ExtentReport.html";
    public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "/target/reports/screenshots";

}
