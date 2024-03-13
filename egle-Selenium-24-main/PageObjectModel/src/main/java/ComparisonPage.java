import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ComparisonPage extends BasePage{
    @FindBy (css = ".table tr td:nth-child(2) a")
    private WebElement firstProduct;
    public String getFirstProductText()
    {
       return firstProduct.getText();

    }

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

   @FindBy (css = ".table tr td:nth-child(3) a")
    private WebElement secondProduct;
    public String getSecondProductText()
    {
        return secondProduct.getText();

    }
}
