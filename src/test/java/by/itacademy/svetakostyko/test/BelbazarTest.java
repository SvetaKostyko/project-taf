package by.itacademy.svetakostyko.test;

import by.itacademy.svetakostyko.test.driver.DriverConfiguration;
import by.itacademy.svetakostyko.test.model.Product;
import by.itacademy.svetakostyko.test.ui.pages.BelbazarPage;
import by.itacademy.svetakostyko.test.ui.pages.CatalogPage;
import by.itacademy.svetakostyko.test.ui.steps.CatalogStep;
import by.itacademy.svetakostyko.test.ui.steps.LoginStep;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static by.itacademy.svetakostyko.test.ui.pages.UserData.*;

public class BelbazarTest {
    WebDriver driver;

    @BeforeEach
    public void setUpBrowser() {
        driver = DriverConfiguration.getDriver();
        driver.navigate().to(BelbazarPage.URL);
    }

    @Test
    @DisplayName("Авторизация с корректными данными")
    public void testLoginUserWithValidData() {
        LoginStep loginStep = new LoginStep();
        loginStep.stepLoginUser(EMAIL, PASSWORD);
        Assertions.assertEquals(USER_NAME, loginStep.getUserName());
    }

    @Test
    @DisplayName("Авторизация без пароля")
    public void testLoginUserWithEmailOnly() {
        LoginStep loginStep = new LoginStep();
        loginStep.stepLoginUserWithEmailOnly(EMAIL);
        Assertions.assertTrue(loginStep.isErrorMessageValid());
    }

    @Test
    @DisplayName("Авторизация без e-mail")
    public void testLogInWithoutEmail() {
        LoginStep loginStep = new LoginStep();
        loginStep.stepLoginUserWithPasswordOnly(PASSWORD);
        Assertions.assertTrue(loginStep.isErrorMessageValid());
    }

    @Test
    @DisplayName("Авторизация без e-mail и без пароля")
    public void testLogInWithoutData() {
        LoginStep loginStep = new LoginStep();
        loginStep.stepLoginWithoutData();
        Assertions.assertTrue(loginStep.isErrorMessageValid());
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    public void testBasketItem() {
        CatalogStep catalogStep = new CatalogStep();
        Product expectedProduct = catalogStep.putProductIntoBasket(CatalogPage.TEXT_OF_SEARCHING);
        Product actualProduct = catalogStep.getProductFromBasket();
        Assertions.assertEquals(expectedProduct.toString(), actualProduct.toString());
    }

    @Test
    @DisplayName("Выход из учетной записи")
    public void testLogOut() {
        LoginStep loginStep = new LoginStep();
        loginStep.stepLoginUser(EMAIL, PASSWORD);
        loginStep.stepLogout();
        Assertions.assertTrue(loginStep.isUserEmpty());
    }

    @AfterEach
    void closeDriver() {
        DriverConfiguration.closeDriver();
    }
}
