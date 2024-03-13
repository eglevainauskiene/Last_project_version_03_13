import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Selectors {
    @Test
    void TestCss() {
        WebDriver driver = new FirefoxDriver();
        Random rnd = new Random();
        driver.get("https://demo.opencart-extensions.co.uk/index.php?route=account/register");
        Faker faker = new Faker();
        int areaCode = rnd.nextInt(900) + 100;
        int firstThreeDigits = rnd.nextInt(900) + 100;
        int lastFourDigits = rnd.nextInt(9000) + 1000;

        String phoneNumber = String.format("(%d) %d-%d", areaCode, firstThreeDigits, lastFourDigits);

        String lastname = faker.name().lastName();
        String firstName = faker.name().firstName();
        String company = faker.company().toString();
        String post= faker.code().toString();
        String pass = faker.expression("a"+rnd.nextInt());
        String streetAddress = faker.address().streetAddress();
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys(lastname);
        driver.findElement(By.cssSelector("#input-email")).sendKeys("testas." + rnd.nextInt() +"@gmail.com");
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

    }

    @Test
    void TestXPath() {
        WebDriver driver = new FirefoxDriver();
        Random rnd = new Random();
        driver.get("https://demo.opencart-extensions.co.uk/index.php?route=account/register");
        Faker faker = new Faker();
        int areaCode = rnd.nextInt(900) + 100;
        int firstThreeDigits = rnd.nextInt(900) + 100;
        int lastFourDigits = rnd.nextInt(9000) + 1000;

        String phoneNumber = String.format("(%d) %d-%d", areaCode, firstThreeDigits, lastFourDigits);

        String lastname = faker.name().lastName();
        String firstName = faker.name().firstName();
        String company = faker.company().toString();
        String post= faker.code().toString();
        String pass = faker.expression("a"+rnd.nextInt());
        String streetAddress = faker.address().streetAddress();
        driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys(lastname);
        driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("aba." + rnd.nextInt() +"@gmail.com");
        driver.findElement(By.xpath("//*[@id='input-telephone']")).sendKeys(phoneNumber);
        driver.findElement(By.xpath("//*[@id='input-company']")).sendKeys(company);
        driver.findElement(By.xpath("//*[@id='input-address-1']")).sendKeys(streetAddress);
        driver.findElement(By.xpath("//*[@id='input-city']")).sendKeys("Utena");
        driver.findElement(By.xpath("//*[@id='input-postcode']")).sendKeys(post);
        driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id='input-confirm']")).sendKeys(pass);

        Select drpCountry = new Select(driver.findElement(By.xpath("//*[contains(@name,'country_id')]")));
        Select drpRegion = new Select(driver.findElement(By.xpath("//*[contains(@name,'zone_id')]")));
        drpCountry.selectByVisibleText("Lithuania");
        drpRegion.selectByVisibleText("Vilnius");
        WebElement agree = driver.findElement(By.xpath("//*[contains(@name,'agree')]"));
        agree.click();
        WebElement button = driver.findElement(By.xpath("//*[contains(@class,'btn-primary')]"));
        button.click();

    }
}
