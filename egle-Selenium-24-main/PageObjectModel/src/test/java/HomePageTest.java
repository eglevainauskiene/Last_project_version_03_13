import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Waiters;

public class HomePageTest extends BaseTest{
    HomePage homePage;
    @Test
    void euroChangeCorrectly() {
        homePage = new HomePage(driver);
        homePage.clickCurrencyLink();
       homePage.clickEuroLink();
        Assertions.assertTrue(homePage.EuroTextIsDisplayed());
        Assertions.assertTrue(homePage.EuroText1IsDisplayed());
    }
    @Test
    void poundSterlingChangeCorrectly() {
        homePage = new HomePage(driver);
        homePage.clickCurrencyLink();
        homePage.clickPoundSterlingLink();
        Assertions.assertTrue(homePage.PoundSterlingTextIsDisplayed());
    }
    @Test
    void DolarChangeCorrectly() {
        homePage = new HomePage(driver);
        homePage.clickCurrencyLink();
        homePage.clickDolarLink();
        Assertions.assertTrue(homePage.DolarTextIsDisplayed());
    }

    @Test
    void checkProductAddToCart() {
        homePage = new HomePage(driver);
        homePage.clickAddToCart();
        Assertions.assertTrue(homePage.successMsgIsDisplayed());
        Assertions.assertEquals(homePage.getExpMsgText(),homePage.getMsgText(),"Produktai nesutampa");
        String[] trimmedCartText = homePage.getCartText().split(" ");
        String trimmedShopCartText = trimmedCartText[0];
        boolean isItemAdded = homePage.getCartText().startsWith("1");
        Assertions.assertTrue(isItemAdded);
       Assertions.assertEquals("1",trimmedShopCartText,"Prekių skaičius nesutampa");
    }


}
