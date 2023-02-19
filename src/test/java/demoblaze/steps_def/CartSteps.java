package demoblaze.steps_def;

import demoblaze.pages.CartPage;
import demoblaze.pages.HomePage;
import demoblaze.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartSteps {

    private WebDriver driver = Hooks.driver;
    private ProductPage productPage = new ProductPage(driver);
    private HomePage homePage = new HomePage(driver);
    private CartPage cartPage = new CartPage(driver);

    @Given("User visits a random product details page")
    public void user_visits_a_random_product_details_page() {
        Assert.assertTrue("Product not exists.", productPage.visitSamsungGalaxyS6());
    }

    @When("User clicks add to cart button")
    public void user_clicks_add_to_cart_button() {
        productPage.clickAddToCartBtn();
        Assert.assertTrue("Product isn't added to cart.", productPage.isProductAddedToCart());
        productPage.dismissAddedToCartAlert();
    }

    @When("User clicks cart link to be redirected to cart page")
    public void user_clicks_cart_link_to_be_redirected_to_cart_page() {
        homePage.clickCartLink();
        Assert.assertTrue("System doesn't redirect the user to cart page.", cartPage.isPlaceOrderBtnDisplayed());
    }

    @Then("User finds the product is added to cart")
    public void user_finds_the_product_is_added_to_cart() {
        Assert.assertTrue("Product isn't added to cart.", cartPage.isProductDisplayed());
    }

    @When("User deletes a product from cart")
    public void user_deletes_a_product_from_cart() {
        cartPage.clickProductDeleteBtn();
    }

    @Then("Product is removed from cart")
    public void product_is_removed_from_cart() {
        Assert.assertTrue("Product isn't removed from cart.", cartPage.isCartProductDisplayed());
    }

}
