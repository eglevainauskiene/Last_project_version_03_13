import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Waiters;
public class ComparisonPageTest extends BaseTest{
    ComparisonPage comparisonPage;
    HomePage homePage;

    @Test
    void comparisionCorrectly() {
        homePage = new HomePage(driver);
        homePage.clickBtn1Compare();
        homePage.clickBtn2Compare();
        homePage.clickBtnCompare();
        comparisonPage = new ComparisonPage(driver);
        Assertions.assertEquals("iPhone", comparisonPage.getFirstProductText(),"Produkatai nesutampa");
        Assertions.assertEquals("iPod Classic", comparisonPage.getSecondProductText(),"Produktai nesutampa");

    }
}
