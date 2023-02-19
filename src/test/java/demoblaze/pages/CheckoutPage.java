package demoblaze.pages;

import core.WaitElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;
    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;
    @FindBy(how = How.ID, using = "country")
    private WebElement countryField;
    @FindBy(how = How.ID, using = "city")
    private WebElement cityField;
    @FindBy(how = How.ID, using = "card")
    private WebElement creditCardField;
    @FindBy(how = How.ID, using = "month")
    private WebElement creditCardMonthField;
    @FindBy(how = How.ID, using = "year")
    private WebElement creditCardYearField;
    @FindBy(how = How.XPATH, using = "//button[text()='Purchase']")
    private WebElement purchaseBtn;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'sweet-alert')]")
    private WebElement purchaseConfirmationPopup;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'sweet-alert')]/h2")
    private WebElement purchaseConfirmationText;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'sweet-alert')]/div/div/button")
    private WebElement purchaseConfirmationBtn;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        WaitElement.toBeVisible(driver, nameField).sendKeys(name);
    }

    public void enterCountry(String country) {
        WaitElement.toBeVisible(driver, countryField).sendKeys(country);
    }

    public void enterCity(String city) {
        WaitElement.toBeVisible(driver, cityField).sendKeys(city);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryYear, String expiryMonth) {
        WaitElement.toBeVisible(driver, creditCardField).sendKeys(cardNumber);
        WaitElement.toBeVisible(driver, creditCardMonthField).sendKeys(expiryMonth);
        WaitElement.toBeVisible(driver, creditCardYearField).sendKeys(expiryYear);
    }

    public void clickPurchaseOrder() {
        WaitElement.toBeClickable(driver, purchaseBtn).click();
    }

    public boolean isConfirmationPopupDisplayed() {
        return WaitElement.toBeClickable(driver, purchaseConfirmationPopup).isDisplayed();
    }

    public String getConfirmationPopupText() {
        return WaitElement.toBeVisible(driver, purchaseConfirmationText).getText();
    }

    public void clickPurchaseConfirmationBtn() {
        WaitElement.toBeClickable(driver, purchaseConfirmationBtn).click();
    }

}
