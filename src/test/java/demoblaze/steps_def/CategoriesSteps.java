package demoblaze.steps_def;

import demoblaze.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CategoriesSteps {

    private WebDriver driver = Hooks.driver;
    private HomePage homePage = new HomePage(driver);

    @When("^User clicks on category (.*) link from homepage$")
    public void user_clicks_on_category_link_from_homepage(String category) {
        homePage.clickCategoryByName(category);
    }

    @Then("^User shows category (.*) items list$")
    public void user_shows_category_items_list(String category) {
        Assert.assertTrue("Category " + category + " has no items.", homePage.isCategoryHasItems());
    }

}
