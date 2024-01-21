package apiHelperExample;



import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * Base class for all the JUnit-based test classes
 */
public class JUnitTestBase {

    protected static String baseUrl;
    protected WebDriver driver;

    @BeforeAll
    public static void loadConfig() throws Throwable {
        SuiteConfiguration config = new SuiteConfiguration();
        RestAssured.baseURI = config.getProperty("github.url");
        RestAssured.basePath = config.getProperty("github.repositories.path");
        baseUrl = config.getProperty("site.url");
    }

    @SneakyThrows
    @BeforeEach
    public void initDriver()  {


//        String selenoidURL = "http://localhost:4444/wd/hub";
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName("chrome");
//        caps.setVersion("120.0");
//        caps.setCapability("enableVNC", true);
//        caps.setCapability("screenResolution", "1280x1024");
//
//
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();


//        String slenoidURL = "http://localhost:4444/wd/hub";
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName("chrome");
//        caps.setVersion("120.0");
//        caps.setCapability("enableVNC", true);
//        caps.setCapability("screenResolution", "1280x1024");
//        caps.setCapability("enableVideo", true);
//        caps.setCapability("enableLog", true);

//        driver = new RemoteWebDriver(new URL(slenoidURL), caps);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/google-chrome");
//        ChromeOptions options = new ChromeOptions();
//
//        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
//            /* How to add test badge */
//            put("name", "Test badge...");
//
//            /* How to set session timeout */
//            put("sessionTimeout", "15m");
//
//            /* How to set timezone */
//            put("env", new ArrayList<String>() {{
//                add("TZ=UTC");
//            }});
//
//            /* How to add "trash" button */
//            put("labels", new HashMap<String, Object>() {{
//                put("manual", "true");
//            }});
//
//            /* How to enable video recording */
//            put("enableVideo", true);
//        }});
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);



    }

    @AfterEach
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
