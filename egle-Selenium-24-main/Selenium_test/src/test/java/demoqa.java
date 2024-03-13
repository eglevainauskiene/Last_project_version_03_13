import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class demoqa {
    WebDriver driver;
    @BeforeEach
    void setup()
    {
        driver = new FirefoxDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.cssSelector(".fc-button-label"));
        button.click();
    }
    @AfterEach
    void close()
    {
//driver.quit();
    }

    @Test
    void TestButonEnable()
    {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#enableAfter"))));
        driver.findElement(By.cssSelector("#enableAfter")).click();
    }

    @Test
    void TestButonColorChange()
    {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(By.cssSelector("#colorChange"),"class","text-danger"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".text-danger"))));
    }

    @Test
    void TestButonVisibleAfter()
    {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#visibleAfter")));
        driver.findElement(By.cssSelector("#visibleAfter")).click();
    }
}
