import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#input-email")
    private WebElement emailInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(String email) {
        emailInput.sendKeys(email);
    }

    @FindBy(css = "#input-password")
    private WebElement password;

    public void sendPassword(String pass) {
        password.sendKeys(pass);
    }

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement btnSubmit;

    public void clickBtnSubmit() {
        btnSubmit.click();
    }

    @FindBy (css = "div.alert.alert-danger")
    private WebElement errorMsg;
    public boolean errorMsgIsDisplayed(){
        return errorMsg.isDisplayed();
    }

}