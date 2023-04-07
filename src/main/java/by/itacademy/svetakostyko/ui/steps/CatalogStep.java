package by.itacademy.svetakostyko.ui.steps;

import by.itacademy.svetakostyko.model.Product;
import by.itacademy.svetakostyko.ui.pages.CatalogPage;

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
