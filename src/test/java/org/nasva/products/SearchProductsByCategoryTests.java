package org.nasva.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nasva.AuthSteps;
import org.nasva.pages.HeaderMenu;
import org.nasva.pages.SearchProductsPage;


public class SearchProductsByCategoryTests {
    SearchProductsPage searchProductsPage = new SearchProductsPage();
    static HeaderMenu headerMenu = new HeaderMenu();

    @BeforeEach
    public void authorize() {
        AuthSteps.testAuthorization();
        headerMenu.clickProductsButton();
    }

    @Test
    public void openSearchProductsPage() {
        searchProductsPage.isAllProductsPage();
    }

    @Test
    public void openWomenCategory() {
        searchProductsPage.clickWomenCategoryButton()
                .clickDressCategoryButton();
    }

    @Test
    public void openDressCategory() {
        searchProductsPage.clickWomenCategoryButton()
                .clickDressCategoryButton()
                .isDressProduct();
    }

    @Test
    public void openTShirtCategory() {
        searchProductsPage.clickMenCategoryButton()
                .clickTShirtsCategoryButton()
                .isTShirts();
    }

    @Test
    public void openJeansCategory() {
        searchProductsPage.clickMenCategoryButton()
                .clickJeansCategoryButton()
                .isJeans();
    }

    @Test
    public void openKidsDressesCategory() {
        searchProductsPage.clickKidsCategoryButton()
                .clickKidsDressCategoryButton()
                .isKidsDresses();
    }
}
