package demoblaze.pages;

import core.WaitElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;
    @FindBy(how = How.XPATH, using = "//button[text()='Place Order']")
    private WebElement placeOrderBtn;
    @FindBy(how = How.XPATH, using = "//*[@id='tbodyid']/tr[1]")
    @CacheLookup
    private WebElement cartProduct;
    @FindBy(how = How.XPATH, using = "//*[@id='tbodyid']/tr[1]/td[4]/a")
    private WebElement productDeleteBtn;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPlaceOrderBtnDisplayed() {
        return WaitElement.toBeVisible(driver, placeOrderBtn).isDisplayed();
    }

    public boolean isProductDisplayed() {
        return WaitElement.toBeVisible(driver, cartProduct).isDisplayed();
    }

    public boolean isCartProductDisplayed() {
        return WaitElement.toBeInvisible(driver, cartProduct);
    }

    public void clickProductDeleteBtn() {
        WaitElement.toBeClickable(driver, productDeleteBtn).click();
    }

    public void clickPlaceOrderBtn() {
        WaitElement.toBeClickable(driver, placeOrderBtn).click();
    }

}
