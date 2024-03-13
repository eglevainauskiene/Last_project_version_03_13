import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogedInPage extends BasePage{
    @FindBy(css = "#input-email")
    private WebElement emailInput;
    @FindBy(css = "h2:nth-child(1)")
    private WebElement myAccount;

    public LogedInPage(WebDriver driver) {
        super(driver);
    }
    public String getMyAccountText() {
       return myAccount.getText();
           }
    public boolean myAccountIsDisplayed(){
        return myAccount.isDisplayed();
    }



}
