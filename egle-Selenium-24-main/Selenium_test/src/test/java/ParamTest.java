import com.github.javafaker.Faker;
import com.google.common.base.Strings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class ParamTest {
WebDriver driver = new FirefoxDriver();
Random rnd = new Random();
Faker faker = new Faker();

@BeforeEach
void setup()
{
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    driver.get("https://demo.opencart-extensions.co.uk/index.php?route=account/register");

}

    @ParameterizedTest
    @ValueSource(strings = {"a@a.lt", "b@b.lt", "c@c.lt", "d@d.lt", "f@f.lt"})
    void differentEmail(String email) {

        driver.findElement(By.cssSelector("#input-email")).sendKeys(email);

    }
    @AfterEach
    void close(){
        driver.quit();

    }
}
