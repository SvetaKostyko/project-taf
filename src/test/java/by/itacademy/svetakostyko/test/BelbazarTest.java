package by.itacademy.svetakostyko.test;

import by.itacademy.svetakostyko.test.ui.KeysPage;
import by.itacademy.svetakostyko.test.ui.BelbazarPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BelbazarTest {
    WebDriver driver;

    @BeforeEach
    public void setUpBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
    /*    System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sveta\\chromedriver.exe");*/
        driver.manage().window().maximize();
        driver.navigate().to(BelbazarPage.URL);
    }

    @Test
    public void testLogInValidatedData() {
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.EMAIL_FIELD))
                .sendKeys(KeysPage.EMAIL);
        driver.findElement(By.xpath(BelbazarPage.PASSWORD_FIELD))
                .sendKeys(KeysPage.PASSWORD);
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
        String actualUserName = driver.findElement(By.xpath(BelbazarPage.LABEL_OF_USER)).getText();
        String actualLabelOfLogIn = driver.findElement(By.xpath(BelbazarPage.STATUS_OF_LOGIN))
                .getAttribute(KeysPage.ATTRIBUTE_OF_USER);
        Assertions.assertEquals(KeysPage.USER_NAME, actualUserName);
        Assertions.assertEquals(KeysPage.LABEL_OF_LOGIN, actualLabelOfLogIn);
    }

    @Test
    public void testLogInWithoutPassword() {
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.EMAIL_FIELD))
                .sendKeys(KeysPage.EMAIL);
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
        String errorMassage = new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(BelbazarPage.ERROR_MASSAGE))).getText();
        Assertions.assertEquals(KeysPage.TEXT_OF_ERROR_MASSAGE, errorMassage);
    }

    @Test
    public void testLogInWithoutEmail() {
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.PASSWORD_FIELD))
                .sendKeys(KeysPage.PASSWORD);
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
        String errorMassage = new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(BelbazarPage.ERROR_MASSAGE))).getText();
        Assertions.assertEquals(KeysPage.TEXT_OF_ERROR_MASSAGE, errorMassage);
    }

    @Test
    public void testLogInWithoutData() {
        driver.findElement(By.xpath(BelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(BelbazarPage.LOGIN_BUTTON)).click();
        String errorMassage = new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(BelbazarPage.ERROR_MASSAGE))).getText();
        Assertions.assertEquals(KeysPage.TEXT_OF_ERROR_MASSAGE, errorMassage);
    }

    @Test
    public void testSearchCostume() {
        driver.findElement(By.xpath(BelbazarPage.SEARCH_FIELD)).sendKeys(KeysPage.PRODUCT);
        driver.findElement(By.xpath(BelbazarPage.SEARCH_BUTTON)).click();
        String firstProductOnPageBrand = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions
                        .visibilityOfElementLocated((By.xpath((BelbazarPage.BRAND_NAME))))).getText();
        String firstProductOnPageCode = driver.findElement(By.xpath((BelbazarPage.CODE_OF_PRODUCT))).getText().substring(5, 9);
        driver.findElement(By.xpath(BelbazarPage.BASKET_BUTTON)).click();
        String sizeOfProduct = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(BelbazarPage.SIZE_BUTTON))).getText();
        driver.findElement(By.xpath(BelbazarPage.SIZE_BUTTON)).click();
        driver.findElement(By.xpath(BelbazarPage.BUTTON_TO_BASKET)).click();
        driver.findElement(By.xpath(BelbazarPage.TOP_BASKET)).click();
        String productInBasket = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(BelbazarPage.BRAND_IN_BASKET))).getText();
        String codeOfProductInBasket = driver.findElement(By.xpath(BelbazarPage.CODE_IN_BASKET)).getText();
        String sizeInBasket = driver.findElement(By.xpath(BelbazarPage.SIZE_OF_PRODUCT_IN_BASKET)).getText();
        Assertions.assertEquals(firstProductOnPageBrand, productInBasket);
        Assertions.assertEquals(firstProductOnPageCode, codeOfProductInBasket);
        Assertions.assertEquals(sizeOfProduct, sizeInBasket);
    }

    @Test
    public void testLogOut() {
        driver.findElement(By.xpath("//a[@class='top_block_link profile']")).click();
        driver.findElement(By.xpath("//input[@name='info[login]']"))
                .sendKeys("123tfh123@mail.ru");
        driver.findElement(By.xpath("//div[@class='auth_mode email']//input[@type='password']"))
                .sendKeys("bh123bh");
        driver.findElement(By.xpath("//div[@class='button blue'][contains(text(),'Войти')]")).click();
        driver.findElement(By.xpath("//a[@href='/profile/']")).click();
        driver.findElement(By.xpath("//div[@class='l_menu_3ur_item']//a[@href='/profile/exit/']")).click();
        String actualLabelOfLogIn = driver.findElement(By.xpath("//a[contains(@class,'top_block_link profile')]"))
                .getAttribute("onclick");
        Assertions.assertEquals("return show_object('auth');", actualLabelOfLogIn);
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }
}
