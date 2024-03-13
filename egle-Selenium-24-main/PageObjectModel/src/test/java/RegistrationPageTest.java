import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.DataGenerator;

import java.util.Random;

public class RegistrationPageTest extends BaseTest{
    HomePage homePage;
    RegistrationPage registrationPage;

    @Test
    void userCanRegister()
    {
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        String InputEmail = DataGenerator.getRandomEmail();
        homePage.clickMyAccountLink();
        homePage.clickRegisterLink();
        String firstName = DataGenerator.getRandomFirstName();
        String lastName = DataGenerator.getRandomLastName();
        String phoneNumber = DataGenerator.getRandomPhoneNumber();
        String Company = DataGenerator.getRandomCompanyName();
        String streetAddress = DataGenerator.getRandomStreetAddress();
        String PostCode = DataGenerator.getRandomPostCode();
        String City = DataGenerator.getRandomCity();
        String Password = DataGenerator.getRandomPassword();
        registrationPage.sendFirstName(firstName);
        registrationPage.sendLastName(lastName);
        registrationPage.sendEmail(InputEmail);
        registrationPage.sendPhoneNumber(phoneNumber);
        registrationPage.sendCompanyName(Company);
        registrationPage.sendAddress(streetAddress);
        registrationPage.sendCity(City);
        registrationPage.sendPostCode(PostCode);
        registrationPage.SelectCountry("Lithuania");
        registrationPage.SelectZone("Kaunas");
        registrationPage.sendPassword(Password);
        registrationPage.sendConfirmPassword(Password);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnContinue();
        Assertions.assertTrue(registrationPage.checkAccountCreated());
    }
}
