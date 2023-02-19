package demoblaze.pages;

import core.DriverSwitchManager;
import core.WaitElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "sign-username")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "sign-password")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[text()='Sign up']")
    private WebElement registerBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        WaitElement.toBeVisible(driver, this.usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitElement.toBeVisible(driver, this.passwordField).sendKeys(password);
    }

    public void clickRegisterBtn() {
        WaitElement.toBeClickable(driver, registerBtn).click();
    }

    public boolean isAlertDisplayed() {
        return WaitElement.alertToPreset(driver) != null;
    }

    public String getRegistrationAlertText() {
        return DriverSwitchManager.getAlertText(driver);
    }

    public void closeRegistrationAlertPopUp() {
        WaitElement.alertToPreset(driver);
        DriverSwitchManager.dismissAlert(driver);
    }

}
