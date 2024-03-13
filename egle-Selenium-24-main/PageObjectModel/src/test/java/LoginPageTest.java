import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.DataGenerator;

public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    LogedInPage logedinPage;

    @Test
    void cannotLoginWithWrongPassw()
    {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        logedinPage = new LogedInPage(driver);
        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.sendEmail("migle@gmail.com");
        loginPage.sendPassword("miglemiglaite");
        loginPage.clickBtnSubmit();
        Assertions.assertTrue(loginPage.errorMsgIsDisplayed());
    }

    @Test
    void cannotLoginWithWrongUser()
    {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        logedinPage = new LogedInPage(driver);
        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
        loginPage.sendEmail("migle@gmail.com");
        loginPage.sendPassword("miglemiglaite");
        loginPage.clickBtnSubmit();
        Assertions.assertTrue(loginPage.errorMsgIsDisplayed());
    }
    @Test
    void userCanLogin() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        logedinPage = new LogedInPage(driver);
        homePage.clickMyAccountLink();
        homePage.clickLoginLink();
       loginPage.sendEmail("migle.miglaite@gmail.com");
        loginPage.sendPassword("miglemiglaite");
        loginPage.clickBtnSubmit();
        Assertions.assertEquals("My Account",logedinPage.getMyAccountText());
        //Assertions.assertEquals("migle.miglaite@gmail.com",loginPage.getEmailText());
    }

}