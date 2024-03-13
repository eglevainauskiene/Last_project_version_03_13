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
public class calculator {
    WebDriver driver = new FirefoxDriver();

    @BeforeEach
    void setup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://testpages.herokuapp.com/styled/calculator");
    }
    @AfterEach
    void close(){
     //   driver.quit();
    }
    @Test
    void TestMinus()
    {
        String number1 = "10";
        String operation = "minus";
        String number2 = "5";
        String expectedResult = "5";
        driver.findElement(By.cssSelector("#number1")).sendKeys(number1);
        Select drp = new Select(driver.findElement(By.cssSelector("#function")));
        drp.selectByVisibleText(operation);
        driver.findElement(By.cssSelector("#number2")).sendKeys(number2);
        WebElement button = driver.findElement(By.cssSelector("#calculate"));
        button.click();
        String Answer = driver.findElement(By.cssSelector("#answer")).getText();
       Assertions.assertEquals(expectedResult,Answer, "Answers do not match");
    }

    @Test
    void TestPlus()
    {
        String number1 = "10";
        String operation = "plus";
        String number2 = "5";
        String expectedResult = "15";
        driver.findElement(By.cssSelector("#number1")).sendKeys(number1);
        Select drp = new Select(driver.findElement(By.cssSelector("#function")));
        drp.selectByVisibleText(operation);
        driver.findElement(By.cssSelector("#number2")).sendKeys(number2);
        WebElement button = driver.findElement(By.cssSelector("#calculate"));
        button.click();
        String Answer = driver.findElement(By.cssSelector("#answer")).getText();
        Assertions.assertEquals(expectedResult,Answer, "Answers do not match");
    }

    @Test
    void TestDivide()
    {
        String number1 = "12";
        String operation = "divide";
        String number2 = "6";
        String expectedResult = "2";
        driver.findElement(By.cssSelector("#number1")).sendKeys(number1);
        Select drp = new Select(driver.findElement(By.cssSelector("#function")));
        drp.selectByVisibleText(operation);
        driver.findElement(By.cssSelector("#number2")).sendKeys(number2);
        WebElement button = driver.findElement(By.cssSelector("#calculate"));
        button.click();
        String Answer = driver.findElement(By.cssSelector("#answer")).getText();
        Assertions.assertEquals(expectedResult,Answer, "Answers do not match");
    }

    @Test
    void TestMultiply()
    {
        String number1 = "10";
        String operation = "times";
        String number2 = "5";
        String expectedResult = "50";
        driver.findElement(By.cssSelector("#number1")).sendKeys(number1);
        Select drp = new Select(driver.findElement(By.cssSelector("#function")));
        drp.selectByVisibleText(operation);
        driver.findElement(By.cssSelector("#number2")).sendKeys(number2);
        WebElement button = driver.findElement(By.cssSelector("#calculate"));
        button.click();
        String Answer = driver.findElement(By.cssSelector("#answer")).getText();
        Assertions.assertEquals(expectedResult,Answer, "Answers do not match");
    }
}

