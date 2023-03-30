package by.itacademy.svetakostyko.test.ui.steps;

import by.itacademy.svetakostyko.test.ui.pages.LoginPage;

public class LoginStep {

    public static void loginUser(String email, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogin();

    }

    public static void loginUserWithEmailOnly(String email) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLogin();
        loginPage.inputEmail(email);
        loginPage.clickLogin();
    }
}
