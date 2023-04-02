package by.itacademy.svetakostyko.test.ui.steps;

import by.itacademy.svetakostyko.test.model.Product;
import by.itacademy.svetakostyko.test.ui.pages.CatalogPage;

public class CatalogStep {

    private final CatalogPage catalogPage;

    public CatalogStep() {
        catalogPage = new CatalogPage();
    }

    public Product putProductIntoBasket(String productCategory) {
        catalogPage.searchForProducts(productCategory);
        Product product = catalogPage.putFirstProductIntoBasket();
        return product;
    }

    public Product getProductFromBasket() {
        Product productInBasket = catalogPage.getFirstProductFromBasket();
        return productInBasket;
    }
}
