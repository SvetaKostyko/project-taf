package by.itacademy.svetakostyko.test;

import by.itacademy.svetakostyko.driver.DriverConfiguration;
import by.itacademy.svetakostyko.model.Product;
import by.itacademy.svetakostyko.ui.pages.BelbazarPage;
import by.itacademy.svetakostyko.ui.pages.CatalogPage;
import by.itacademy.svetakostyko.ui.steps.CatalogStep;
import by.itacademy.svetakostyko.ui.steps.LoginStep;
import by.itacademy.svetakostyko.ui.pages.UserData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

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
        loginStep.stepLoginUser(UserData.EMAIL, UserData.PASSWORD);
        Assertions.assertEquals(UserData.USER_NAME, loginStep.getUserName());
    }

    @Test
    @DisplayName("Авторизация без пароля")
    public void testLoginUserWithEmailOnly() {
        LoginStep loginStep = new LoginStep();
        loginStep.stepLoginUserWithEmailOnly(UserData.EMAIL);
        Assertions.assertTrue(loginStep.isErrorMessageValid());
    }

    @Test
    @DisplayName("Авторизация без e-mail")
    public void testLogInWithoutEmail() {
        LoginStep loginStep = new LoginStep();
        loginStep.stepLoginUserWithPasswordOnly(UserData.PASSWORD);
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
        Product expectedProduct = catalogStep.putProductIntoBasket("Костюмы");
        Product actualProduct = catalogStep.getProductFromBasket();
        Assertions.assertEquals(expectedProduct.toString(), actualProduct.toString());
    }

    @Test
    @DisplayName("Выход из учетной записи")
    public void testLogOut() {
        LoginStep loginStep = new LoginStep();
        loginStep.stepLoginUser(UserData.EMAIL, UserData.PASSWORD);
        loginStep.stepLogout();
        Assertions.assertTrue(loginStep.isUserEmpty());
    }

    @AfterEach
    void closeDriver() {
        DriverConfiguration.closeDriver();
    }
}
