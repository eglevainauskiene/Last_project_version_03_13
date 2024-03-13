import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {
    HomePage homePage;
    SearchPage searchPage;

    @Test
    void userCanSearch() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        searchPage.sendSearch("IPhone");
        searchPage.searchBtnClick();
        Assertions.assertTrue(searchPage.searchHeaderIsDisplayed());
    }

}
