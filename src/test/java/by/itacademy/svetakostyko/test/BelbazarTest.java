package by.itacademy.svetakostyko.test;

import by.itacademy.svetakostyko.test.ui.KeysPage;
import by.itacademy.svetakostyko.test.ui.BelbazarPage;
import by.itacademy.svetakostyko.test.ui.UserPage;
import by.itacademy.svetakostyko.test.ui.Util;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

public class BelbazarTest {
    WebDriver driver;

    @BeforeEach
    public void setUpBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to(BelbazarPage.URL);
    }

    @Test
    @DisplayName("Авторизация с корректными данными")
    public void testLogInValidatedData() {
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.EMAIL_FIELD))
                .sendKeys(UserPage.EMAIL);
        driver.findElement(By.xpath(BelbazarPage.PASSWORD_FIELD))
                .sendKeys(UserPage.PASSWORD);
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
        String actualUserName = driver.findElement(By.xpath(BelbazarPage.LABEL_OF_USER)).getText();
        String actualLabelOfLogIn = driver.findElement(By.xpath(BelbazarPage.STATUS_OF_LOGIN))
                .getAttribute(UserPage.ATTRIBUTE_OF_USER);
        Assertions.assertEquals(UserPage.USER_NAME, actualUserName);
        Assertions.assertEquals(UserPage.LABEL_OF_LOGIN, actualLabelOfLogIn);
    }

    @Test
    @DisplayName("Авторизация без пароля")
    public void testLogInWithoutPassword() {
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.EMAIL_FIELD))
                .sendKeys(UserPage.EMAIL);
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
        String errorMassage = Util.waitForElementToBeVisibleByXPath(driver, BelbazarPage.ERROR_MASSAGE, 3);
        Assertions.assertEquals(KeysPage.TEXT_OF_ERROR_MASSAGE, errorMassage);
    }

    @Test
    @DisplayName("Авторизация без e-mail")
    public void testLogInWithoutEmail() {
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.PASSWORD_FIELD))
                .sendKeys(UserPage.PASSWORD);
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
        String errorMassage = Util.waitForElementToBeVisibleByXPath(driver, BelbazarPage.ERROR_MASSAGE, 3);
        Assertions.assertEquals(KeysPage.TEXT_OF_ERROR_MASSAGE, errorMassage);
    }

    @Test
    @DisplayName("Авторизация без e-mail и без пароля")
    public void testLogInWithoutData() {
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
        String errorMassage = Util.waitForElementToBeVisibleByXPath(driver, BelbazarPage.ERROR_MASSAGE, 3);
        Assertions.assertEquals(KeysPage.TEXT_OF_ERROR_MASSAGE, errorMassage);
    }

    @Test
    @DisplayName("Поиск товара")
    public void testSearchCostume() {
        driver.findElement(By.xpath(BelbazarPage.SEARCH_FIELD)).sendKeys(KeysPage.PRODUCT);
        driver.findElement(By.xpath(BelbazarPage.SEARCH_BUTTON)).click();
        String firstProductOnPageBrand = Util.waitForElementToBeVisibleByXPath(driver, BelbazarPage.BRAND_NAME, 3);
        String firstProductOnPageCode = driver.findElement(By.xpath((BelbazarPage.CODE_OF_PRODUCT))).getText().substring(5, 9);
        driver.findElement(By.xpath(BelbazarPage.BASKET_BUTTON)).click();
        String sizeOfProduct = Util.waitForElementToBeVisibleByXPath(driver, BelbazarPage.SIZE_BUTTON, 3);
        driver.findElement(By.xpath(BelbazarPage.SIZE_BUTTON)).click();
        driver.findElement(By.xpath(BelbazarPage.BUTTON_TO_BASKET)).click();
        driver.findElement(By.xpath(BelbazarPage.TOP_BASKET)).click();
        String productInBasket = Util.waitForElementToBeVisibleByXPath(driver, BelbazarPage.BRAND_IN_BASKET, 3);
        String codeOfProductInBasket = driver.findElement(By.xpath(BelbazarPage.CODE_IN_BASKET)).getText();
        String sizeInBasket = driver.findElement(By.xpath(BelbazarPage.SIZE_OF_PRODUCT_IN_BASKET)).getText();
        Assertions.assertEquals(firstProductOnPageBrand, productInBasket);
        Assertions.assertEquals(firstProductOnPageCode, codeOfProductInBasket);
        Assertions.assertEquals(sizeOfProduct, sizeInBasket);
    }

    @Test
    @DisplayName("Выход из учетной записи")
    public void testLogOut() {
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.EMAIL_FIELD))
                .sendKeys(UserPage.EMAIL);
        driver.findElement(By.xpath(BelbazarPage.PASSWORD_FIELD))
                .sendKeys(UserPage.PASSWORD);
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
        driver.findElement(By.xpath(BelbazarPage.LABEL_OF_USER)).click();
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_LOGOUT)).click();
        String actualLabelOfLogIn = driver.findElement(By.xpath(BelbazarPage.STATUS_OF_LOGIN))
                .getAttribute(UserPage.ATTRIBUTE_OF_USER);
        Assertions.assertEquals(UserPage.LABEL_OF_LOGOUT, actualLabelOfLogIn);
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }
}
