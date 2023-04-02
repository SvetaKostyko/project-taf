package by.itacademy.svetakostyko.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfiguration {
    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static WebDriver getDriver() {
        if(driver.get() == null){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("start-maximized");
            WebDriver webDriver = new ChromeDriver(chromeOptions);
            driver.set(webDriver);
        }
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().quit();
        driver.set(null);
    }
}
