package demoblaze.steps_def;

import demoblaze.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomeSteps {

    private WebDriver driver = Hooks.driver;
    private HomePage homePage = new HomePage(driver);

    @When("User clicks login link from homepage")
    public void user_clicks_login_link_from_homepage() {
        homePage.clickLoginLink();
    }

    @When("User clicks SignUp link from homepage")
    public void user_clicks_sign_up_link_from_homepage() {
        homePage.clickSignUpLink();
    }

    @Then("User navigated to homepage as logged in")
    public void user_navigated_to_homepage_as_logged_in() {
        Assert.assertTrue("Unable to redirect user to homepage again, please check the error.", homePage.isLogoutLinkDisplayed());
    }

    @Then("User navigated to homepage")
    public void user_navigated_to_homepage() {
        Assert.assertTrue("User isn't navigated to homepage.", homePage.isUserBrowsingHomepage());
    }

}