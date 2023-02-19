package demoblaze.steps_def;

import demoblaze.pages.LoginPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver = Hooks.driver;
    private LoginPage loginPage = new LoginPage(driver);

    @When("Login with username {string} and password {string}")
    public void login_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("Clicks login button")
    public void clicks_login_button() {
        loginPage.clickLoginBtn();
    }

}