package by.itacademy.svetakostyko.test.ui.steps;

import by.itacademy.svetakostyko.test.model.Product;
import by.itacademy.svetakostyko.test.ui.pages.CatalogPage;

public class CatalogStep {

    public static Product putProductIntoBasket(String productCategory) {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.searchForProducts(productCategory);
        Product product = catalogPage.putFirstProductIntoBasket();
        return product;
    }

    public static Product getProductFromBasket() {
        CatalogPage catalogPage = new CatalogPage();
        Product productInBasket = catalogPage.getFirstProductFromBasket();
        return productInBasket;
    }
}
