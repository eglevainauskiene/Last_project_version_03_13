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

public class demoqaSubmitForm {
    WebDriver driver;
    @BeforeEach
    void setup()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://demoqa.com/text-box");
        WebElement button = driver.findElement(By.cssSelector(".fc-button-label"));
        button.click();

    }
    @AfterEach
    void close()
    {
   //     driver.close();
    }

    @Test
    void Submit() {
        Random rnd = new Random();
        Faker faker = new Faker();
        String userName = faker.name().fullName();
        String streetAddress = faker.address().streetAddress();
        String permanentAddress = faker.address().secondaryAddress();
        String ExpectedEmail = "testas" + rnd.nextInt() + "@gmail.com";
        driver.findElement(By.cssSelector("#userName")).sendKeys(userName);
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(ExpectedEmail);
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys(streetAddress);
        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys(permanentAddress);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement buttonSubmit = driver.findElement(By.cssSelector("#submit"));
        buttonSubmit.click();
        String UserFullName = driver.findElement(By.cssSelector("#name")).getText();
        String[] trimmedText = UserFullName.split(":");
        String UserFullNameTrimmed = trimmedText[1];
        System.out.println(UserFullNameTrimmed);
        Assertions.assertEquals(userName, UserFullNameTrimmed, "Full Name does not match");

        String Email = driver.findElement(By.cssSelector("#email")).getText();
        String[] trimmedEmailText = Email.split(":");
        String trimmedEmail = trimmedEmailText[1];
        System.out.println(trimmedEmail);
        Assertions.assertEquals(ExpectedEmail, trimmedEmail, "Email does not match");
        
        String CurrentAdress = driver.findElement(By.cssSelector("#currentAddress.mb-1")).getText();
        String[] trimmedAdressText = CurrentAdress.split(":");
        String trimmedAdress = trimmedAdressText[1];
        System.out.println(trimmedAdress);
        Assertions.assertEquals(streetAddress, trimmedAdress, "Adress does not match");

        String CurrentPermanentAdress = driver.findElement(By.cssSelector("#permanentAddress.mb-1")).getText();
        String[] trimmedPermanentAdressText = CurrentPermanentAdress.split(":");
        String trimmedPermanentAdress = trimmedPermanentAdressText[1];
        System.out.println(trimmedPermanentAdress);
        Assertions.assertEquals(permanentAddress, trimmedPermanentAdress, "Address does not match");

    }
}
