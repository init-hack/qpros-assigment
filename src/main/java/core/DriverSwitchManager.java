package core;

import org.openqa.selenium.WebDriver;

public class DriverSwitchManager {

    public static String getAlertText(WebDriver driver) {
        String text = WaitElement.alertToPreset(driver).getText();
        return text;
    }

    public static boolean dismissAlert(WebDriver driver) {
        WaitElement.alertToPreset(driver).dismiss();
        driver.switchTo().defaultContent();
        return true;
    }

    public static boolean acceptAlert(WebDriver driver) {
        WaitElement.alertToPreset(driver).accept();
        driver.switchTo().defaultContent();
        return true;
    }

}
