import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://demo.opencart-extensions.co.uk/");
    }

    @AfterEach
    void close() {
    //    driver.quit();
    }
}