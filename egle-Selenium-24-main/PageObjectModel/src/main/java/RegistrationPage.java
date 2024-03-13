import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Waiters;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement InputfirstName;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void sendFirstName(String firstName) {
        InputfirstName.sendKeys(firstName);
    }

    @FindBy(css = "#input-lastname")
    private WebElement InputLastName;

    public void sendLastName(String lastName) {
        InputLastName.sendKeys(lastName);
    }

    @FindBy(css = "#input-email")
    private WebElement InputEmail;

    public void sendEmail(String email) {
        InputEmail.sendKeys(email);
    }

    @FindBy(css = "#input-telephone")
    private WebElement InputPhoneNumber;

    public void sendPhoneNumber(String phoneNumber) {
        InputPhoneNumber.sendKeys(phoneNumber);
    }

    @FindBy(css = "#input-company")
    private WebElement InputCompany;

    public void sendCompanyName(String CompanyName) {

        InputCompany.sendKeys(CompanyName);
    }

    @FindBy(css = "#input-address-1")
    private WebElement InputAddress;

    public void sendAddress(String Adress) {

        InputAddress.sendKeys(Adress);
    }

    @FindBy(css = "#input-city")
    private WebElement InputCity;

    public void sendCity(String City) {

        InputCity.sendKeys(City);
    }

    @FindBy(css = "#input-postcode")
    private WebElement InputPostCode;

    public void sendPostCode(String PostCode) {

        InputCity.sendKeys(PostCode);
    }

    @FindBy(css = "#input-country")
    private WebElement drpCountry;

    public void SelectCountry(String Country) {
        Select selectCountry = new Select(drpCountry);
        selectCountry.selectByVisibleText(Country);

    }
    @FindBy(css = "#input-zone")
    private WebElement drpZone;

    public void SelectZone(String Zone) {
        Waiters.waitForTextInElement(driver,drpZone,Zone);
        Select SelectZone = new Select(drpZone);
        SelectZone.selectByVisibleText(Zone);
    }
    @FindBy(css = "#input-password")
    private WebElement Inputpassword1;

    public void sendPassword(String password) {
        Inputpassword1.sendKeys(password);
    }
    @FindBy(css = "#input-confirm")
    private WebElement Inputpassword2;

    public void sendConfirmPassword(String password) {
        Inputpassword2.sendKeys(password);
    }
    @FindBy(css = "input[value='1'][name='agree']")
    private WebElement InputCheckBox;

    public void clickCheckBox() {
        InputCheckBox.click();
    }
    @FindBy(css = "input[value='Continue']")
    private WebElement btnContinue;

    public void clickBtnContinue() {
        btnContinue.click();
    }
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    private WebElement AccountCreated;

    public boolean checkAccountCreated()
    {
        return AccountCreated.isDisplayed();
    }
}