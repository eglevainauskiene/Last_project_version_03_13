import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class FirstTest {
    @Test
    void firstTest() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.selenium.dev/");
    }

    @Test
    void secondTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.opencart-extensions.co.uk/index.php?route=account/register");
        driver.findElement(By.id("input-firstname")).sendKeys("Eglė");
        driver.findElement(By.id("input-lastname")).sendKeys("Vainauskienė");
        driver.findElement(By.id("input-email")).sendKeys("egle.vainauskiene@student.edon.lt");
        driver.findElement(By.id("input-telephone")).sendKeys("864545584");
        driver.findElement(By.id("input-company")).sendKeys("Edon");
        driver.findElement(By.id("input-address-1")).sendKeys("Donelaičio g. 60");
        driver.findElement(By.id("input-city")).sendKeys("Kaunas");
        driver.findElement(By.id("input-postcode")).sendKeys("06383");
        driver.findElement(By.id("input-password")).sendKeys("password123");
        driver.findElement(By.id("input-confirm")).sendKeys("password123");
        Select drpCountry = new Select(driver.findElement(By.name("country_id")));
        Select drpRegion = new Select(driver.findElement(By.name("zone_id")));
        drpCountry.selectByVisibleText("Lithuania");
        drpRegion.selectByVisibleText("Kaunas");
        WebElement agree = driver.findElement(By.name("agree"));
        agree.click();
        WebElement button = driver.findElement(By.className("btn-primary"));
        button.click();

    }

    @Test
    void TestCss() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.opencart-extensions.co.uk/index.php?route=account/register");
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Testas");
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Testukas");
        driver.findElement(By.cssSelector("#input-email")).sendKeys("testas.testukas@gmail.com");
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys("864545584");
        driver.findElement(By.cssSelector("#input-company")).sendKeys("Edon");
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys("Donelaičio g. 60");
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Vilnius");
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys("06383");
        driver.findElement(By.cssSelector("#input-password")).sendKeys("testukas123");
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys("testukas123");
        Select drpCountry = new Select(driver.findElement(By.name("country_id")));
        Select drpRegion = new Select(driver.findElement(By.name("zone_id")));
        drpCountry.selectByVisibleText("Lithuania");
        drpRegion.selectByVisibleText("Kaunas");
        WebElement agree = driver.findElement(By.name("agree"));
        agree.click();
        WebElement button = driver.findElement(By.cssSelector(".btn-primary"));
        button.click();

    }

    @Test
    void letCodeEdit() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://letcode.in/edit");
        driver.findElement(By.cssSelector(".fc-primary-button")).click();
        driver.findElement(By.id("fullName")).sendKeys("Egle Eglaite");
        driver.findElement(By.id("join")).sendKeys(" at testing");
        WebElement text = driver.findElement(By.id("getMe"));
        String val = text.getAttribute("value");
        System.out.println(val);
        driver.findElement(By.id("clearMe")).clear();
        boolean disabled = driver.findElement(By.id("noEdit")).isEnabled();
        System.out.println("Text field is enabled: " + disabled);
        WebElement element = driver.findElement(By.id("dontwrite"));
        System.out.println("Text field non-editable: " + element.getAttribute("readonly"));
    }

    @Test
    void letCode2test()  {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://letcode.in/buttons");
        driver.findElement(By.cssSelector(".fc-button-label")).click();
        WebElement button = driver.findElement(By.className("is-link"));
        button.click();
        driver.navigate().back();
        System.out.println(driver.findElement(By.id("position")).getLocation());
        WebElement button1 = driver.findElement(By.id("color"));
        System.out.println("Button bg-color: " + button1.getCssValue("background-color"));
        WebElement button3 = driver.findElement(By.id("property"));
        Dimension dim = button3.getSize();
        System.out.println("Button height and width " + dim);
        boolean disabledbtn = driver.findElement(By.id("isDisabled")).isEnabled();
        System.out.println("Text field is enabled: " + disabledbtn);
        WebElement clickandhold = driver.findElement(By.cssSelector("#isDisabled.is-primary"));
        new Actions(driver)
                .clickAndHold(clickandhold)
                .perform();
    }

    @Test
    void dropdowns() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://letcode.in/dropdowns");
        driver.findElement(By.cssSelector(".fc-primary-button")).click();
        Select drpFruit = new Select(driver.findElement(By.id("fruits")));
        drpFruit.selectByVisibleText("Orange");
        System.out.println(driver.findElement(By.className("subtitle")).getText());
        Select drpHero = new Select(driver.findElement(By.id("superheros")));
        drpHero.selectByVisibleText("Batman");
        System.out.println(driver.findElements(By.cssSelector(".subtitle")).get(1).getText());
        Select drpPLanguage = new Select(driver.findElement(By.id("lang")));
        drpPLanguage.selectByVisibleText("Python");
        String SV1 = drpPLanguage.getFirstSelectedOption().getText();
        System.out.println(SV1);
        Select drpCountry = new Select(driver.findElement(By.id("country")));
        drpCountry.selectByVisibleText("India");
        String SV2 = drpCountry.getFirstSelectedOption().getText();
        System.out.println(SV2);
    }
    @Test
    void alerts() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://letcode.in/alert");
        driver.findElement(By.cssSelector(".fc-primary-button")).click();
        WebElement button = driver.findElement(By.className("is-link"));
        button.click();
        driver.switchTo().alert().accept();
        WebElement btnConfirm = driver.findElement(By.id("confirm"));
        btnConfirm.click();
        driver.switchTo().alert().dismiss();
        WebElement btnPrompt = driver.findElement(By.id("prompt"));
        btnPrompt.click();
        driver.switchTo().alert().sendKeys("Eglė");
        driver.switchTo().alert().accept();
        driver.findElement(By.id("modern")).click();
        WebElement closeButton = driver.findElement((By.cssSelector(".modal-close")));
        closeButton.click();
    }
}