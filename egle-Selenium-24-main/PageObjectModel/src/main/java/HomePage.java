import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "a[title='My Account']")
    private WebElement myAccountLink;

    @FindBy (xpath = "//*[text()='Login']")
    private WebElement LoginLink;

    //@FindBy

    @FindBy (css = "a[href='https://demo.opencart-extensions.co.uk/index.php?route=account/register']")
    private WebElement registerLink;

    public void clickMyAccountLink(){
        myAccountLink.click();
    }

    public void clickLoginLink() {
    LoginLink.click();
    }

    public void clickRegisterLink(){registerLink.click();}

    @FindBy (css=".btn.btn-link.dropdown-toggle")
    private WebElement currencyLink;

    public void clickCurrencyLink()
    {
        currencyLink.click();
    }

    @FindBy (css="button[name='EUR']")
    private WebElement euroLink;

    public void clickEuroLink()
    {
        euroLink.click();
    }
    @FindBy (css="button[name='GBP']")
    private WebElement poundSterlingLink;

    public void clickPoundSterlingLink()
    {
        poundSterlingLink.click();
    }

    @FindBy (css="button[name='USD']")
    private WebElement DolarLink;

    public void clickDolarLink()
    {
        DolarLink.click();
    }
    @FindBy(xpath = "//p[contains(text(),'€')]")
    private WebElement eurotext;

    public boolean EuroTextIsDisplayed()
    {
        return eurotext.isDisplayed();
    }
    @FindBy(xpath = "//strong[contains(text(),'€')]")
    private WebElement eurotext1;
    public boolean EuroText1IsDisplayed()
    {
        return eurotext1.isDisplayed();
    }
    @FindBy(xpath = "//strong[normalize-space()='£']")
    private WebElement poundSterlingtext;

    public boolean PoundSterlingTextIsDisplayed()
    {
        return poundSterlingtext.isDisplayed();
    }

    @FindBy(xpath = "//strong[normalize-space()='$']")
    private WebElement Dolartext;

    public boolean DolarTextIsDisplayed()
    {
        return Dolartext.isDisplayed();
    }

    @FindBy(xpath = "//*[contains(text(),'Add to Cart')]")
    private WebElement BtnAddToCart;
    public void clickAddToCart()
    {
        BtnAddToCart.click();
    }
    @FindBy(css = ".alert.alert-success")
    private WebElement SuccessMsg;
    public boolean successMsgIsDisplayed()
   {
        return SuccessMsg.isDisplayed();
   }
    @FindBy(css = ".alert-success>a")
    private WebElement textMsg;
    public String getMsgText()
    {
        return textMsg.getText();
    }
    @FindBy(xpath = "//div[@class='caption']//a[normalize-space()='iPhone']")
    private WebElement expText;
    public String getExpMsgText()
    {
        return expText.getText();
    }
    @FindBy(css = "#cart-total")
    private WebElement cartText;
    public String getCartText()
    {
        return cartText.getText();
    }

    @FindBy(css = ".fa-exchange")
    private WebElement Btn1Compare;
    @FindBy(xpath = "(//*[contains(@class,'fa-exchange')])[2]")
    private WebElement Btn2Compare;

    @FindBy(css = "a[href='https://demo.opencart-extensions.co.uk/index.php?route=product/compare']")
    private WebElement BtnCompare;
    public void clickBtn1Compare()
    {
        Btn1Compare.click();

    }
    public void clickBtn2Compare()
    {
        Btn2Compare.click();
    }
    public void clickBtnCompare()
    {
        BtnCompare.click();
    }

    @FindBy(xpath = "//a[text()='iPod Classic']")
    private WebElement FirstProdText;
    public String getIPodText()
    {
      return FirstProdText.getText();

    }

}