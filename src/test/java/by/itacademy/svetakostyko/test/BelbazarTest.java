package by.itacademy.svetakostyko.test;

import by.itacademy.svetakostyko.test.driver.DriverConfiguration;
import by.itacademy.svetakostyko.test.model.Product;
import by.itacademy.svetakostyko.test.ui.pages.BelbazarPage;
import by.itacademy.svetakostyko.test.ui.pages.CatalogPage;
import by.itacademy.svetakostyko.test.ui.pages.LoginPage;
import by.itacademy.svetakostyko.test.ui.steps.CatalogStep;
import by.itacademy.svetakostyko.test.ui.steps.LoginStep;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static by.itacademy.svetakostyko.test.ui.pages.UserData.*;

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
    @DisplayName("Добавление товара в корзину")
    public void testBasketItem() {
        Product expectedProduct = CatalogStep.putProductIntoBasket(CatalogPage.TEXT_OF_SEARCHING);
        Product actualProduct = CatalogStep.getProductFromBasket();
        Assertions.assertEquals(expectedProduct.toString(), actualProduct.toString());
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
