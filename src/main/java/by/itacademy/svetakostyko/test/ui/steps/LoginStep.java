package by.itacademy.svetakostyko.test.ui.steps;

import by.itacademy.svetakostyko.test.ui.pages.LoginPage;

public class LoginStep {

    public static void StepLoginUser(String email, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogin();

    }

    public static void stepLoginUserWithEmailOnly(String email) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLogin();
        loginPage.inputEmail(email);
        loginPage.clickLogin();
    }

    public static void stepLoginUserWithPasswordOnly(String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLogin();
        loginPage.inputPassword(password);
        loginPage.clickLogin();
    }
}
