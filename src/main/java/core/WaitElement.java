package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitElement {

    private static Duration duration = Duration.ofSeconds(10);

    public static WebElement toBeVisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean toBeInvisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, duration).until(ExpectedConditions.invisibilityOf(element));
    }

    public static WebElement toBeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static Alert alertToPreset(WebDriver driver) {
        return new WebDriverWait(driver, duration).until(ExpectedConditions.alertIsPresent());
    }

}
