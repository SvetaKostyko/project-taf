package by.itacademy.svetakostyko.test;

import by.itacademy.svetakostyko.test.driver.DriverConfiguration;
import by.itacademy.svetakostyko.test.ui.BelbazarPage;
import by.itacademy.svetakostyko.test.ui.TextPage;
import by.itacademy.svetakostyko.test.ui.UserPage;
import by.itacademy.svetakostyko.test.ui.Util;
import by.itacademy.svetakostyko.test.ui.pages.LoginPage;
import by.itacademy.svetakostyko.test.ui.steps.LoginStep;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static by.itacademy.svetakostyko.test.BelbazarProperties.*;

public class BelbazarTest {
    WebDriver driver = DriverConfiguration.getDriver();

    @BeforeEach
    public void setUpBrowser() {
        driver.navigate().to(BelbazarPage.URL);
    }

    @Test
    @DisplayName("Авторизация с корректными данными")
    public void testLoginUserWithValidData() {
        LoginStep.stepLoginUser(EMAIL, PASSWORD);
        Assertions.assertEquals(USER_NAME, LoginPage.getUserName());
    }

    @Test
    @DisplayName("Авторизация без пароля")
    public void testLoginUserWithEmailOnly() {
        LoginStep.stepLoginUserWithEmailOnly(EMAIL);
        Assertions.assertTrue(LoginPage.isErrorMessageValid());
    }

    @Test
    @DisplayName("Авторизация без e-mail")
    public void testLogInWithoutEmail() {
        LoginStep.stepLoginUserWithPasswordOnly(PASSWORD);
        Assertions.assertTrue(LoginPage.isErrorMessageValid());
    }

    @Test
    @DisplayName("Авторизация без e-mail и без пароля")
    public void testLogInWithoutData() {
        LoginStep.stepLoginWithoutData();
        Assertions.assertTrue(LoginPage.isErrorMessageValid());
    }

    @Test
    @DisplayName("Поиск товара")
    public void testSearchCostume() {
        driver.findElement(By.xpath(BelbazarPage.SEARCH_FIELD)).sendKeys(TextPage.PRODUCT);
        driver.findElement(By.xpath(BelbazarPage.SEARCH_BUTTON)).click();
        String firstProductOnPageBrand = Util
                .waitForElementToBeVisibleByXPath(driver, BelbazarPage.BRAND_NAME, 3).getText();
        String firstProductOnPageCode = driver.findElement(By.xpath((BelbazarPage.CODE_OF_PRODUCT))).getText().substring(5, 9);
        driver.findElement(By.xpath(BelbazarPage.BASKET_BUTTON)).click();
        String sizeOfProduct = Util
                .waitForElementToBeVisibleByXPath(driver, BelbazarPage.SIZE_BUTTON, 3).getText();
        driver.findElement(By.xpath(BelbazarPage.SIZE_BUTTON)).click();
        driver.findElement(By.xpath(BelbazarPage.BUTTON_TO_BASKET)).click();
        driver.findElement(By.xpath(BelbazarPage.TOP_BASKET)).click();
        String productInBasket = Util
                .waitForElementToBeVisibleByXPath(driver, BelbazarPage.BRAND_IN_BASKET, 3).getText();
        String codeOfProductInBasket = driver.findElement(By.xpath(BelbazarPage.CODE_IN_BASKET)).getText();
        String sizeInBasket = driver.findElement(By.xpath(BelbazarPage.SIZE_OF_PRODUCT_IN_BASKET)).getText();
        Assertions.assertEquals(firstProductOnPageBrand, productInBasket);
        Assertions.assertEquals(firstProductOnPageCode, codeOfProductInBasket);
        Assertions.assertEquals(sizeOfProduct, sizeInBasket);
    }

    @Test
    @DisplayName("Выход из учетной записи")
    public void testLogOut() {
        LoginStep.stepLogout(EMAIL, PASSWORD);
        Assertions.assertTrue(LoginPage.isUserEmpty());
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }
}
