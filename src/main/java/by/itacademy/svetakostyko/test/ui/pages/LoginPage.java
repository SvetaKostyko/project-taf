package by.itacademy.svetakostyko.test.ui.pages;

import by.itacademy.svetakostyko.test.driver.DriverConfiguration;
import by.itacademy.svetakostyko.test.ui.BelbazarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final String BUTTON_OF_PROFILE = "//a[@class='top_block_link profile']";
    private static final String EMAIL_FIELD = "//input[@name='info[login]']";
    private static final String PASSWORD_FIELD = "//div[@class='auth_mode email']//input[@type='password']";
    private static final String LOGIN_BUTTON = "//div[@class='button blue'][contains(text(),'Войти')]";
    public static String LABEL_OF_USER = "//a[@href='/profile/']";
    private static final String ATTRIBUTE_OF_USER = "onclick";
    private static final String LABEL_OF_LOGIN = "return profile_menu();";
    private static final String LABEL_OF_LOGOUT = "return show_object('auth');";
    private final static WebDriver driver = DriverConfiguration.getDriver();

    public static String getUserName() {
        return driver.findElement(By.xpath(LABEL_OF_USER)).getText();
    }

    public void openLogin() {
        driver.findElement(By.xpath(BUTTON_OF_PROFILE)).click();
    }

    public void inputEmail(String email) {
        driver.findElement(By.xpath(EMAIL_FIELD))
                .sendKeys(email);
    }

    public void inputPassword(String password) {
        driver.findElement(By.xpath(PASSWORD_FIELD))
                .sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }
}
