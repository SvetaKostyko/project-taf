package by.itacademy.svetakostyko.test;
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


public class TestSiteBelbazar {
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
        driver.navigate().to(TestSiteBelbazarPage.URL);
    }

    @Test
    public void testLogInValidatedData() {
        driver.findElement(By.xpath(TestSiteBelbazarPage.BUTTON_OF_PROFILE)).click();
        driver.findElement(By.xpath(TestSiteBelbazarPage.EMAIL_FIELD))
                .sendKeys(KeysPage.EMAIL);
        driver.findElement(By.xpath(TestSiteBelbazarPage.PASSWORD_FIELD))
                .sendKeys(KeysPage.PASSWORD);
        driver.findElement(By.xpath(TestSiteBelbazarPage.LOGIN_BUTTON)).click();
        String actualUserName = driver.findElement(By.xpath(TestSiteBelbazarPage.LABEL_OF_USER)).getText();
        String actualLabelOfLogIn = driver.findElement(By.xpath(TestSiteBelbazarPage.STATUS_OF_LOGIN))
                .getAttribute(KeysPage.ATTRIBUTE_OF_USER);
        Assertions.assertEquals( KeysPage.USER_NAME,actualUserName);
        Assertions.assertEquals(KeysPage.LABEL_OF_LOGIN, actualLabelOfLogIn);
     }

    @Test
    public void testLogInWithoutPassword() {
        driver.findElement(By.xpath("//a[@class='top_block_link profile']")).click();
        driver.findElement(By.xpath("//input[@name='info[login]']"))
                .sendKeys("123tfh123@mail.ru");
        driver.findElement(By.xpath("//div[@class='button blue'][contains(text(),'Войти')]")).click();
        String errorMassage = new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[@class='auth_error_message'][contains(text(),'Ошибка!')]"))).getText();
        Assertions.assertEquals("Ошибка! Не правильно введен E-mail или Пароль.", errorMassage);
    }

    @Test
    public void testLogInWithoutEmail() {
        driver.findElement(By.xpath("//a[@class='top_block_link profile']")).click();
        driver.findElement(By.xpath("//div[@class='auth_mode email']//input[@type='password']"))
                .sendKeys("bh123bh");
        driver.findElement(By.xpath("//div[@class='button blue'][contains(text(),'Войти')]")).click();
        String errorMassage = new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[@class='auth_error_message'][contains(text(),'Ошибка!')]"))).getText();
        Assertions.assertEquals("Ошибка! Не правильно введен E-mail или Пароль.", errorMassage);
    }

    @Test
    public void testLogInWithoutData() {
        driver.findElement(By.xpath("//a[@class='top_block_link profile']")).click();
        driver.findElement(By.xpath("//div[@class='button blue'][contains(text(),'Войти')]")).click();
        String errorMassage = new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[@class='auth_error_message'][contains(text(),'Ошибка!')]"))).getText();
        Assertions.assertEquals("Ошибка! Не правильно введен E-mail или Пароль.", errorMassage);
    }

    @Test
    public void testSearchCostume() {
        driver.findElement(By.xpath("//input[@placeholder='Поиск товара']")).sendKeys("Костюмы");
        driver.findElement(By.xpath("//div[@class='top_search_button']")).click();
        String firstProductOnPage = new WebDriverWait(driver,Duration.ofSeconds(3))
                .until(ExpectedConditions
                        .visibilityOfElementLocated((By.xpath("(//div[@class='product_item_dop'])[1]"))))
                .getText();
        driver.findElement(By.xpath("(//div[@class='product_item_basket but'])[1]")).click();
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@id='modal_check_par_911']"))).click();
        driver.findElement(By.xpath("//div[@class='button blue to_basket']")).click();
        driver.findElement(By.xpath("//a[@class='top_block_link basket']")).click();
        String productInBasket = driver.findElement(By.xpath("//div[@class='basket_item_brand']")).getText();
        Assertions.assertEquals(firstProductOnPage, productInBasket);
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
