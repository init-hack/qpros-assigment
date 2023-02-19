package demoblaze.pages;

import constants.URL;
import core.DriverSwitchManager;
import core.WaitElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;
    @FindBy(how = How.XPATH, using = "//h2")
    private WebElement productName;
    @FindBy(how = How.XPATH, using = "//a[text()='Add to cart']")
    private WebElement addToCartBtn;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean visitSamsungGalaxyS6() {
        driver.navigate().to(URL.homepage.getUrl() + "prod.html?idp_=1");
        return WaitElement.toBeVisible(driver, productName).isDisplayed();
    }

    public void clickAddToCartBtn() {
        WaitElement.toBeClickable(driver, addToCartBtn).click();
    }

    public boolean isProductAddedToCart() {
        String alertText = "Product added.";
        return DriverSwitchManager.getAlertText(driver).equalsIgnoreCase(alertText);
    }

    public boolean dismissAddedToCartAlert() {
        return DriverSwitchManager.dismissAlert(driver);
    }

}
