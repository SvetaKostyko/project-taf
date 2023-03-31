package by.itacademy.svetakostyko.test.ui.pages;

import by.itacademy.svetakostyko.test.driver.DriverConfiguration;
import by.itacademy.svetakostyko.test.model.Product;
import by.itacademy.svetakostyko.test.ui.BelbazarPage;
import by.itacademy.svetakostyko.test.ui.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {

    private final static String SEARCH_FIELD = "//input[@placeholder='Поиск товара']";
    private final static String SEARCH_BUTTON = "//div[@class='top_search_button']";
    private final static String BRAND_NAME = "(//div[@class='product_item_dop'])[1]";
    private final static String CODE_OF_PRODUCT = "(//div[@class='product_item_art'])[1]";
    private final static String BASKET_BUTTON = "(//div[@class='product_item_basket but'])[1]";
    private final static String SIZE_BUTTON = "(//div[@class='prod_size_item'])[1]";
    private final static String BUTTON_TO_BASKET = "//div[@class='button blue to_basket']";
    private final static String TOP_BASKET = "//a[@class='top_block_link basket']";
    private final static String BRAND_IN_BASKET = "//div[@class='basket_item_brand']";
    private final static String CODE_IN_BASKET = "(//div[@class='param']//div[@class='rightText'])[2]";
    private final static String SIZE_OF_PRODUCT_IN_BASKET = "//div[@class='basket_size_box']";
    private final static String PRICE_OF_PRODUCT = "(//div[@class='product_item_i']//span[@class='price'])[1]";
    private final static String PRICE_OF_PRODUCT_IN_BASKET = "//div[@class='oneParam noLine']//span[@class='priceOneProd']";
    public final static String TEXT_OF_SEARCHING = "Костюмы";

    private final static WebDriver driver = DriverConfiguration.getDriver();


    public void searchForProducts(String productCategory) {
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(TEXT_OF_SEARCHING);
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
    }

    public Product putFirstProductIntoBasket() {
        Product product = new Product();
        product.brand = Util
                .waitForElementToBeVisibleByXPath(driver, BRAND_NAME, 3).getText();
        product.code = driver.findElement(By.xpath((CODE_OF_PRODUCT))).getText().substring(6, 9);
        product.price = driver.findElement(By.xpath((PRICE_OF_PRODUCT))).getText();
        driver.findElement(By.xpath(BASKET_BUTTON)).click();
        product.size = Util
                .waitForElementToBeVisibleByXPath(driver, SIZE_BUTTON, 3).getText();
        driver.findElement(By.xpath(SIZE_BUTTON)).click();
        driver.findElement(By.xpath(BUTTON_TO_BASKET)).click();
        return product;
    }

    public Product getFirstProductFromBasket() {
        Product product = new Product();
        driver.findElement(By.xpath(TOP_BASKET)).click();
        product.brand = Util
                .waitForElementToBeVisibleByXPath(driver, BRAND_IN_BASKET, 3).getText();
        product.code = driver.findElement(By.xpath(CODE_IN_BASKET)).getText();
        product.size = driver.findElement(By.xpath(SIZE_OF_PRODUCT_IN_BASKET)).getText();
        product.price = driver.findElement(By.xpath(PRICE_OF_PRODUCT_IN_BASKET)).getText();
        return product;
    }
}
