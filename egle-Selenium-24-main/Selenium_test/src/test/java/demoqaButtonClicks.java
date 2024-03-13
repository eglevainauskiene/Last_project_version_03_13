import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class demoqaButtonClicks {
    WebDriver driver;
    @BeforeEach
    void setup()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.cssSelector(".fc-button-label"));
        button.click();
    }
    @AfterEach
    void close()
    {
        driver.quit();
    }
    @Test
    void ButtonDoubleClick()
    {
        Actions act = new Actions((driver));
        WebElement button = driver.findElement(By.cssSelector("#doubleClickBtn"));
        act.doubleClick(button).perform();
        boolean MsgDisplayed=driver.findElement(By.cssSelector("#doubleClickMessage")).isDisplayed();
        Assertions.assertTrue(MsgDisplayed,"Message does not appear");
    }

    @Test
    void RightClick()
    {
        Actions act = new Actions((driver));
        WebElement button = driver.findElement(By.cssSelector("#rightClickBtn"));
        act.contextClick(button).perform();
        boolean MsgDisplayed=driver.findElement(By.cssSelector("#rightClickMessage")).isDisplayed();
        Assertions.assertTrue(MsgDisplayed,"Message does not appear");
    }

    @Test
    void ButtonClick()
    {
        WebElement button = driver.findElement(By.xpath("//*[text()='Click Me']"));
        button.click();
//        List<WebElement> buttons = driver.findElements(By.className("btn-primary"));
//        WebElement thirdButton = buttons.get(2);
//        thirdButton.click();
        boolean MsgDisplayed=driver.findElement(By.cssSelector("#dynamicClickMessage")).isDisplayed();
        Assertions.assertTrue(MsgDisplayed,"Message does not appear");
    }
}
