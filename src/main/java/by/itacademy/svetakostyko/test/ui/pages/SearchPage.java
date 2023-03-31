package by.itacademy.svetakostyko.test.ui.pages;
import by.itacademy.svetakostyko.test.driver.DriverConfiguration;
import org.openqa.selenium.WebDriver;

public class SearchPage {

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
    private final static String TEXT_OF_SEARCHING = "Костюмы";

    private final static WebDriver driver = DriverConfiguration.getDriver();

    }

