import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    String url = "https://www.zalando.nl/";
    int waitTime = 10;

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Eyes eyes;

    @BeforeMethod
    public void setUp() throws IOException {
        Properties properties = System.getProperties();
        properties.load(new FileInputStream(new File("src/main/resources/test.properties")));

        System.setProperty("webdriver.chrome.driver", System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, waitTime);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
        initiateEyes();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        eyes.abortIfNotClosed();
    }

    private static void initiateEyes() {
        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

    public void validateWindow() {
        eyes.open(driver, "Zalando Test", Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }
}
