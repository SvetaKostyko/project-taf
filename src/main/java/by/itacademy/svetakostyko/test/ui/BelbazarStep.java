package by.itacademy.svetakostyko.test.ui;

import by.itacademy.svetakostyko.test.ui.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BelbazarStep {
    WebDriver driver;

    public BelbazarStep(WebDriver driver) {
        this.driver = driver;
    }

    public void stepTestLogInValidatedData() {
        new LoginPage()
                .setEmail()
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.EMAIL_FIELD))
                .sendKeys(UserPage.EMAIL);
        driver.findElement(By.xpath(BelbazarPage.PASSWORD_FIELD))
                .sendKeys(UserPage.PASSWORD);
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
    }
}
