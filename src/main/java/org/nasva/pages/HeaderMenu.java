package org.nasva.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderMenu {
    private final static SelenideElement PRODUCTS_BUTTON = $("ul.nav.navbar-nav li a[href='/products']");

    public void clickProductsButton() {
        PRODUCTS_BUTTON.click();
    }
}
