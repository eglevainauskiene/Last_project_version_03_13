import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    @FindBy(css = "input[placeholder='Search']")
    private WebElement InputSearch;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void sendSearch(String search) {
        InputSearch.sendKeys(search);
    }
    @FindBy(css = "button[class='btn btn-default btn-lg']")
    private WebElement ButtonSearch;
    public void searchBtnClick() {
        ButtonSearch.click();
    }
    @FindBy (css = ".caption>h4>a")
    private WebElement SearchHeader;
    public boolean searchHeaderIsDisplayed(){
        return SearchHeader.isDisplayed();
    }

}
