import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Annotations {
    WebDriver driver = new FirefoxDriver();
    Random rnd = new Random();

    Faker faker = new Faker();
    @BeforeEach
            void setup()
    {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://demo.opencart-extensions.co.uk/index.php?route=account/register");

    }

    @Test
    void TestCss() {
        int areaCode = rnd.nextInt(900) + 100;
        int firstThreeDigits = rnd.nextInt(900) + 100;
        int lastFourDigits = rnd.nextInt(9000) + 1000;

        String phoneNumber = String.format("(%d) %d-%d", areaCode, firstThreeDigits, lastFourDigits);

        String lastname = faker.name().lastName();
        String firstName = faker.name().firstName();
        String company = faker.company().toString();
        String post = faker.code().toString();
        String pass = faker.expression("a" + rnd.nextInt());
        String streetAddress = faker.address().streetAddress();
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys(lastname);
        driver.findElement(By.cssSelector("#input-email")).sendKeys("testas." + rnd.nextInt() + "@gmail.com");
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys(phoneNumber);
        driver.findElement(By.cssSelector("#input-company")).sendKeys(company);
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys(streetAddress);
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Vilnius");
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys(post);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(pass);
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys(pass);
        Select drpCountry = new Select(driver.findElement(By.cssSelector("[name='country_id']")));
        Select drpRegion = new Select(driver.findElement(By.cssSelector("[name='zone_id']")));
        drpCountry.selectByVisibleText("Lithuania");
        drpRegion.selectByVisibleText("Vilnius");
        WebElement agree = driver.findElement(By.cssSelector("[name='agree']"));
        agree.click();
        WebElement button = driver.findElement(By.cssSelector(".btn-primary"));
        button.click();
        String text = "Your Account Has Been Created!";
        String title = driver.getTitle();
        String PageUrl = driver.getCurrentUrl();
        Assertions.assertEquals("Your Account Has Been Created!", title, "Your registration is not successfully");
        Assertions.assertEquals("https://demo.opencart-extensions.co.uk/index.php?route=account/success", PageUrl, "Your registration is not successfully");
        String h1Text = driver.findElement(By.cssSelector("h1")).getText();
        Assertions.assertTrue(h1Text.contains(text), "Text not found!");
        Assertions.assertEquals(text,h1Text,"Your registration is not successfully");
    }
    @AfterEach
    void close(){
      //  driver.quit();

    }
    }

