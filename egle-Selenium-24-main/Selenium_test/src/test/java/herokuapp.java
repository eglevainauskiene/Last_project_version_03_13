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
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class herokuapp {
    WebDriver driver = new FirefoxDriver();
    Random rnd = new Random();

    Faker faker = new Faker();
    @BeforeEach
    void setup()
    {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://testpages.herokuapp.com/styled/validation/input-validation.html");

    }

    @Test
    void Test() {
        String lastname = faker.name().lastName() + "aaaaaaaaaaaaaaaaaaa";
        String firstName = faker.name().firstName();
        String country = "Austria";
        String Age = "18";
        String Comment = "Comment TextArea";
        driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#surname")).sendKeys(lastname);
        driver.findElement(By.cssSelector("#age")).sendKeys(Age);
        Select drpCountry = new Select(driver.findElement(By.cssSelector("[name='country']")));
        drpCountry.selectByVisibleText(country);
        driver.findElement(By.cssSelector("#notes")).sendKeys(Comment);
        WebElement button = driver.findElement(By.cssSelector("[type='submit']"));
        button.click();
        String ActualLastName = driver.findElement(By.cssSelector("#surname-value")).getText();
        String ActualFirstName = driver.findElement(By.cssSelector("#firstname-value")).getText();
        String ActualAge = driver.findElement(By.cssSelector("#age-value")).getText();
        String ActualCountry = driver.findElement(By.cssSelector("#country-value")).getText();
        String ActualNotes = driver.findElement(By.cssSelector("#notes-value")).getText();
        Assertions.assertEquals(firstName, ActualFirstName, "Firstname does not match");
        Assertions.assertEquals(lastname, ActualLastName, "Surname does not match");
        Assertions.assertEquals(Age, ActualAge, "Age does not match");
        Assertions.assertEquals(country, ActualCountry, "Country does not match");
        Assertions.assertEquals(Comment, ActualNotes, "Notes do not match");
    }
    @AfterEach
    void close(){
        driver.quit();

    }
}


