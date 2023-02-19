package demoblaze.steps_def;

import constants.URL;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GeneralSteps {

    private WebDriver driver = Hooks.driver;

    @Given("User on website homepage")
    public void user_on_website_homepage() {
        driver.navigate().to(URL.homepage.getUrl());
    }

}