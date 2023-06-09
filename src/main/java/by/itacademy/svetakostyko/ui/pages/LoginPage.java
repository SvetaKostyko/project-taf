package by.itacademy.svetakostyko.ui.pages;

import by.itacademy.svetakostyko.driver.DriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final String BUTTON_OF_PROFILE = "//a[contains(@class,'top_block_link profile')]";
    private static final String EMAIL_FIELD = "info[login]";
    private static final String PASSWORD_FIELD = "//div[@class='auth_mode email']//input[@type='password']";
    private static final String LOGIN_BUTTON = "//div[@class='button blue'][contains(text(),'Войти')]";
    private static final String ERROR_MESSAGE = "//div[@class='auth_error_message'][contains(text(),'Ошибка!')]";
    private static final String TEXT_OF_EXPECTED_ERROR_MESSAGE = "Ошибка! Не правильно введен E-mail или Пароль.";
    private static final String LABEL_OF_USER = "//a[@href='/profile/']";
    private static final String BUTTON_OF_LOGOUT = "//div[@class='l_menu_3ur_item']//a[@href='/profile/exit/']";

    private final WebDriver driver;

    public LoginPage() {
        driver = DriverConfiguration.getDriver();
    }

    public void openLogin() {
        driver.findElement(By.xpath(BUTTON_OF_PROFILE)).click();
    }

    public String getUserName() {
        return driver.findElement(By.xpath(LABEL_OF_USER)).getText();
    }

    public boolean isErrorMessageValid() {
        String errorMessage = Util.waitForElementToBeVisibleByXPath(driver, ERROR_MESSAGE, 5).getText();
        return TEXT_OF_EXPECTED_ERROR_MESSAGE.equals(errorMessage);
    }

    public void inputEmail(String email) {
        driver.findElement(By.name(EMAIL_FIELD))
                .sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(By.xpath(PASSWORD_FIELD))
                .sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    public void clickLogout() {
        driver.findElement(By.xpath(BUTTON_OF_LOGOUT)).click();
    }

    public void waitForProfileButtonAndClick() {
        Util.waitForElementToBeClickable(driver, BUTTON_OF_PROFILE, 3).click();
    }

    public boolean isUserEmpty() {
        String actualLabelOfLogIn = driver.findElement(By.xpath(BUTTON_OF_PROFILE))
                .getText();
        return actualLabelOfLogIn.isEmpty();
    }
}
