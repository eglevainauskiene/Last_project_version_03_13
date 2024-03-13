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
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.concurrent.TimeUnit;
public class ToDoList {
    WebDriver driver = new FirefoxDriver();
    @BeforeEach
    void setup() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://eviltester.github.io/simpletodolist/todolists.html");
    }
    @AfterEach
    void close(){

    }
    @Test()
            void ToDoList()
    {
        String itemText = "DONE!!!"; //can be random
        driver.findElement(By.cssSelector(".new-todo-list")).sendKeys(itemText + Keys.ENTER);

        boolean isItemDisplayed = driver.findElement(By.cssSelector("li[data-id='" + itemText + "']")).isDisplayed();
        assertTrue(isItemDisplayed);

        boolean isItemDisplayed2 = driver.findElement(By.xpath("//label[contains(text(), '" + itemText + "')]")).isDisplayed();
        assertTrue(isItemDisplayed2);

    }
}
