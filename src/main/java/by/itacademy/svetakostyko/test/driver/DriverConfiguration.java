package by.itacademy.svetakostyko.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfiguration {
    private static WebDriver driver;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
//        driver.navigate().to(BelbazarPage.URL);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
