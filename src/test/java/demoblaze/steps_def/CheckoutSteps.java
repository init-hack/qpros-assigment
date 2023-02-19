package demoblaze.steps_def;

import demoblaze.pages.CartPage;
import demoblaze.pages.CheckoutPage;
import demoblaze.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {

    private WebDriver driver = Hooks.driver;
    private CartPage cartPage = new CartPage(driver);
    private CheckoutPage checkoutPage = new CheckoutPage(driver);
    private HomePage homePage = new HomePage(driver);

    @When("User clicks place order button")
    public void user_clicks_place_order_button() {
        cartPage.clickPlaceOrderBtn();
    }

    @When("User fills name {string}")
    public void user_fills_name(String name) {
        checkoutPage.enterName(name);
    }

    @When("User fills country, city with {string}, {string}")
    public void user_fills_country_city_with(String country, String city) {
        checkoutPage.enterCountry(country);
        checkoutPage.enterCity(city);
    }

    @When("User fills credit card number {string} year {string} month {string}")
    public void user_fills_credit_card_number_year_month(String cardNumber, String expiryYear, String expiryMonth) {
        checkoutPage.enterCreditCardDetails(cardNumber, expiryYear, expiryMonth);
    }

    @When("User clicks purchase button")
    public void user_clicks_purchase_button() {
        checkoutPage.clickPurchaseOrder();
    }

    @Then("System displays order purchased successfully text {string}")
    public void system_displays_order_purchased_successfully_text(String text) {
        Assert.assertTrue("Order Purchase unsuccessful.", checkoutPage.isConfirmationPopupDisplayed());
        Assert.assertEquals("Order Purchase message incorrect.", text, checkoutPage.getConfirmationPopupText());
    }

}
