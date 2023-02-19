package demoblaze.pages;

import core.WaitElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "loginusername")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "loginpassword")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[text()='Log in']")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        WaitElement.toBeVisible(driver, this.usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitElement.toBeVisible(driver, this.passwordField).sendKeys(password);
    }

    public void clickLoginBtn() {
        WaitElement.toBeClickable(driver, loginBtn).click();
    }

}
