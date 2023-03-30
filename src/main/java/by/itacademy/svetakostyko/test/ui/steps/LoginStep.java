package by.itacademy.svetakostyko.test.ui.steps;

import by.itacademy.svetakostyko.test.ui.pages.LoginPage;

public class LoginStep {

    private static final LoginPage loginPage = new LoginPage();

    public static void stepLoginUser(String email, String password) {
        loginPage.openLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogin();

    }

    public static void stepLoginUserWithEmailOnly(String email) {
        loginPage.openLogin();
        loginPage.inputEmail(email);
        loginPage.clickLogin();
    }

    public static void stepLoginUserWithPasswordOnly(String password) {
        loginPage.openLogin();
        loginPage.inputPassword(password);
        loginPage.clickLogin();
    }

    public static void stepLoginWithoutData() {
        loginPage.openLogin();
        loginPage.clickLogin();
    }

    public static void stepLogout(String email, String password) {
        stepLoginUser(email, password);
        loginPage.waitForProfileButtonAndClick();
        loginPage.clickLogout();
    }
}
