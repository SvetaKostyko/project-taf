package by.itacademy.svetakostyko.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {
    public static WebElement waitForElementToBeVisibleByXPath(WebDriver driver, String xpath, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, String xpath, int seconds) {
       return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }

}
