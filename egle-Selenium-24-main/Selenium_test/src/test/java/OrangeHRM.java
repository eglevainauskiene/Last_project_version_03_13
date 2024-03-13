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
import java.util.concurrent.TimeUnit;
public class OrangeHRM {
    WebDriver driver = new FirefoxDriver();
    @BeforeEach
    void setup()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @Test()
    void TestLogin() throws InterruptedException {
        String PageUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String ExpectedTitle="OrangeHRM";
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
        WebElement login = driver.findElement(By.cssSelector("button"));
        login.click();
        String text = "Dashboard";
        String CurrentUrl=driver.getCurrentUrl();
        String CurrentTitle=driver.getTitle();
        Assertions.assertEquals(PageUrl,CurrentUrl,"Your login is not successfully");
        Assertions.assertEquals(ExpectedTitle,CurrentTitle,"Your login is not successfully");
        String headerText = driver.findElement(By.cssSelector(".oxd-topbar-header-title")).getText();
        Assertions.assertEquals(text,headerText,"Your login is not successfully");
    }
    @Test()
    void TestLoginWithGivenCredentials() throws InterruptedException {
        String PageUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String ExpectedTitle="OrangeHRM";
        String UserName= driver.findElement(By.cssSelector("p.oxd-text:nth-child(1)")).getText();
        String[] trimmedText = UserName.split(": ");
        String UserNameTrimmed = trimmedText[1];
        String passw = driver.findElement(By.cssSelector("p.oxd-text:nth-child(2)")).getText();
        String[] trimmedTextPass = passw.split(": ");
        String passwTrimmed = trimmedTextPass[1];
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys(UserNameTrimmed);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(passwTrimmed);
        System.out.println(UserNameTrimmed);
        System.out.println(passwTrimmed);
        WebElement login = driver.findElement(By.cssSelector("button"));
        login.click();
        String text = "Dashboard";
        String CurrentUrl=driver.getCurrentUrl();
        String CurrentTitle=driver.getTitle();
        Assertions.assertEquals(PageUrl,CurrentUrl,"Your login is not successfully");
        Assertions.assertEquals(ExpectedTitle,CurrentTitle,"Your login is not successfully");
        String headerText = driver.findElement(By.cssSelector(".oxd-topbar-header-title")).getText();
        Assertions.assertEquals(text,headerText,"Your login is not successfully");
    }
    @Test
    void TestWithBadCredentials() throws InterruptedException {
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admintest");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin1234");
        WebElement login = driver.findElement(By.cssSelector("button"));
        login.click();
        boolean errorMsgDisplayed=driver.findElement(By.cssSelector(".oxd-alert-content--error")).isDisplayed();
       Assertions.assertTrue(errorMsgDisplayed,"Error message does not appear");
    }
    @AfterEach
    void close()
    {
driver.quit();
    }
}
