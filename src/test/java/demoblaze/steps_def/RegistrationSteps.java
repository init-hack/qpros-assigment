package demoblaze.steps_def;

import demoblaze.pages.RegistrationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegistrationSteps {

    private WebDriver driver = Hooks.driver;
    private RegistrationPage registrationPage = new RegistrationPage(driver);

    @When("Registers username {string} with password {string}")
    public void registers_username_with_password(String username, String password) {
        username = username.replace("[random]", RandomStringUtils.randomAlphanumeric(4, 8));
        registrationPage.enterUsername(username);
        registrationPage.enterPassword(password);
    }

    @When("Clicks Register button")
    public void clicks_register_button() {
        registrationPage.clickRegisterBtn();
    }

    @Then("User shows alert popup with text {string}")
    public void user_shows_alert_popup_with_text(String alertText) {
        Assert.assertTrue("Registration successful alert isn't presented.", registrationPage.isAlertDisplayed());
        Assert.assertEquals("Registration unsuccessful due to alert text isn't as expected.", alertText, registrationPage.getRegistrationAlertText());
    }

    @Then("User closes alert popup")
    public void user_closes_alert_popup() {
        registrationPage.closeRegistrationAlertPopUp();
    }

}
