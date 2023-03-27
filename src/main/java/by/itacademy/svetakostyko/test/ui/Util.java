package by.itacademy.svetakostyko.test.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {
    public static void waitForElementToBeVisibleByXPath(WebDriver driver, String xpath, int seconds) {
            new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        }
}
