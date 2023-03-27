package by.itacademy.svetakostyko.test.ui;

public class BelbazarPage {
    public static String URL = "https://belbazar24.by/";
    public static String BUTTON_OF_PROFILE = "//a[@class='top_block_link profile']";
    public static String EMAIL_FIELD = "//input[@name='info[login]']";
    public static String PASSWORD_FIELD = "//div[@class='auth_mode email']//input[@type='password']";
    public static String LOGIN_BUTTON = "//div[@class='button blue'][contains(text(),'Войти')]";
    public static String LABEL_OF_USER = "//a[@href='/profile/']";
    public static String STATUS_OF_LOGIN = "//a[contains(@class,'top_block_link profile')]";
    public static String ERROR_MASSAGE = "//div[@class='auth_error_message'][contains(text(),'Ошибка!')]";
    public static String SEARCH_FIELD = "//input[@placeholder='Поиск товара']";
    public static String SEARCH_BUTTON = "//div[@class='top_search_button']";
    public static String BRAND_NAME = "(//div[@class='product_item_dop'])[1]";
    public static String CODE_OF_PRODUCT = "(//div[@class='product_item_art'])[1]";
    public static String BASKET_BUTTON = "(//div[@class='product_item_basket but'])[1]";
    public static String SIZE_BUTTON = "(//div[@class='prod_size_item'])[1]";
    public static String BUTTON_TO_BASKET = "//div[@class='button blue to_basket']";
    public static String TOP_BASKET = "//a[@class='top_block_link basket']";
    public static String BRAND_IN_BASKET = "//div[@class='basket_item_brand']";
    public static String CODE_IN_BASKET = "(//div[@class='param']//div[@class='rightText'])[2]";
    public static String SIZE_OF_PRODUCT_IN_BASKET = "//div[@class='basket_size_box']";
    public static String BUTTON_OF_LOGOUT = "//div[@class='l_menu_3ur_item']//a[@href='/profile/exit/']";


}
