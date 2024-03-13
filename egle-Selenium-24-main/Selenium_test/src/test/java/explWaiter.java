import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class explWaiter {
    WebDriver driver;
    @BeforeEach
    void setup() {
        driver = new FirefoxDriver();
        driver.get("https://testpages.herokuapp.com/styled/progress-bars-sync.html");
    }

    @AfterEach
    void close() {
   //     driver.quit();
    }

    @Test
    void test() {
//        Sukuriam
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebDriverWait waitStopped = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebDriverWait waitRunningInvisible = new WebDriverWait(driver,Duration.ofSeconds(10));
//        Naudojan
        wait1.until(ExpectedConditions.attributeToBe(
                driver.findElement(By.cssSelector("#progressbar0")), "value", "100")
        );
        wait2.until(ExpectedConditions.attributeToBe(driver.findElement(By.cssSelector("#progressbar1")),"value","100")
        );

        wait3.until(ExpectedConditions.attributeToBe(driver.findElement(By.cssSelector("#progressbar2")),"value","100"));

     //   waitStopped.until(ExpectedConditions.textToBe(By.cssSelector("#status"),"Stopped"));

        waitRunningInvisible.until(ExpectedConditions.textToBe(By.cssSelector("#status"),"Running")
        );
//        Webelement
//        wait1.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("#progressbar0")), "value", "100"));
//        wait2.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("#progressbar1")),"value","100"));
//        wait3.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("#progressbar2")),"value","100"));
//        waitStopped.until(ExpectedConditions.textToBe(By.cssSelector("#status"),"Stopped"));
//        By nebutinas
//        wait1.until(ExpectedConditions.attributeContains(By.cssSelector("#progressbar0"), "value", "100"));
//        wait2.until(ExpectedConditions.attributeContains(By.cssSelector("#progressbar1"),"value","100"));
//        wait3.until(ExpectedConditions.attributeContains(By.cssSelector("#progressbar2"),"value","100"));
//        waitStopped.until(ExpectedConditions.textToBe(By.cssSelector("#status"),"Stopped"));
    }
    }

