package by.itacademy.svetakostyko.test.ui.steps;

import by.itacademy.svetakostyko.test.ui.pages.LoginPage;

public class LoginStep {

    private final LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    public void stepLoginUser(String email, String password) {
        loginPage.openLogin();
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickLogin();

    }

    public void stepLoginUserWithEmailOnly(String email) {
        loginPage.openLogin();
        loginPage.inputEmail(email);
        loginPage.clickLogin();
    }

    public void stepLoginUserWithPasswordOnly(String password) {
        loginPage.openLogin();
        loginPage.inputPassword(password);
        loginPage.clickLogin();
    }

    public void stepLoginWithoutData() {
        loginPage.openLogin();
        loginPage.clickLogin();
    }

    public void stepLogout() {
        loginPage.waitForProfileButtonAndClick();
        loginPage.clickLogout();
    }

    public String getUserName() {
        return loginPage.getUserName();
    }

    public boolean isErrorMessageValid() {
        return loginPage.isErrorMessageValid();
    }

    public boolean isUserEmpty() {
        return loginPage.isUserEmpty();
    }
}
