package demoblaze.pages;

import core.WaitElement;
import constants.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "signin2")
    private WebElement signUpLink;
    @FindBy(how = How.ID, using = "login2")
    private WebElement loginLink;
    @FindBy(how = How.ID, using = "cartur")
    private WebElement cartLink;
    @FindBy(how = How.ID, using = "logout2")
    private WebElement logoutLink;
    @FindBy(how = How.ID, using = "cat")
    private WebElement categoriesCategory;
    @FindBy(how = How.XPATH, using = "//a[text()='Phones']")
    private WebElement phonesCategory;
    @FindBy(how = How.XPATH, using = "//a[text()='Laptops']")
    private WebElement laptopsCategory;
    @FindBy(how = How.XPATH, using = "//a[text()='Monitors']")
    private WebElement monitorsCategory;
    @FindBy(how = How.ID, using = "tbodyid")
    private WebElement categoryItemsBody;
    @FindBy(how = How.XPATH, using = "//div[@id='tbodyid']/div")
    private List<WebElement> categoryItems;
    @FindBy(how = How.ID, using = "carouselExampleIndicators")
    private WebElement imageSlider;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignUpLink() {
        WaitElement.toBeClickable(this.driver, signUpLink).click();
    }

    public void clickLoginLink() {
        WaitElement.toBeClickable(this.driver, loginLink).click();
    }

    public void clickCartLink() {
        WaitElement.toBeClickable(this.driver, cartLink).click();
    }

    public boolean isLogoutLinkDisplayed() {
        return WaitElement.toBeVisible(driver, logoutLink).isDisplayed();
    }

    public boolean isUserBrowsingHomepage() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.equalsIgnoreCase(URL.homepage.getUrl()) || currentUrl.equalsIgnoreCase(URL.homepage.getAlias());
    }

    public void clickCategoryByName(String category) {
        WebElement element;
        switch (category.toLowerCase()) {
            case "phones": {
                element = phonesCategory;
                break;
            }
            case "laptops": {
                element = laptopsCategory;
                break;
            }
            case "monitors": {
                element = monitorsCategory;
                break;
            }
            default:
                element = categoriesCategory;
        }

        WaitElement.toBeClickable(driver, element).click();
        WaitElement.toBeVisible(driver, categoryItemsBody);
    }

    public boolean isCategoryHasItems() {
        WaitElement.toBeVisible(driver, categoryItemsBody);
        return categoryItems.size() != 0;
    }

    public boolean isImageSliderDisplayed() {
        return WaitElement.toBeVisible(driver, imageSlider).isDisplayed();
    }
}
