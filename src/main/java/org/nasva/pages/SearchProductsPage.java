package org.nasva.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.nasva.utils.ReferencesReader;

import java.util.List;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchProductsPage {
    private final static SelenideElement ALL_PRODUCTS_LABEL = $(".title.text-center");
    private final static String ALL_PRODUCTS_STRING = "All Products";
    private final static SelenideElement WOMEN_CATEGORY_BUTTON = $(".panel-heading a[href='#Women']");
    private final static SelenideElement MEN_CATEGORY_BUTTON = $(".panel-heading a[href='#Men']");
    private final static SelenideElement KIDS_CATEGORY_BUTTON = $(".panel-heading a[href='#Kids']");
    private final static SelenideElement DRESS_CATEGORY_BUTTON = $("#Women .panel-body ul li a[href='/category_products/1']");
    private final static SelenideElement T_SHIRTS_CATEGORY_BUTTON = $("#Men .panel-body ul li a[href='/category_products/3']");
    private final static SelenideElement JEANS_CATEGORY_BUTTON = $("#Men .panel-body ul li a[href='/category_products/6']");
    private final static SelenideElement KIDS_DRESS_CATEGORY_BUTTON = $("#Kids .panel-body ul li a[href='/category_products/4']");
    private final static ElementsCollection ALL_PRODUCTS = $$(".product-image-wrapper");
    private final static String T_SHIRT_REGULAR_EXPRESSION = "(?i)t[- ]?shirt";
    private final static String DRESS_REGULAR_EXPRESSION = "(?i)dress";
    private final static String JEANS_REGULAR_EXPRESSION = "(?i)jeans";

    public void isAllProductsPage() {
        ALL_PRODUCTS_LABEL.shouldHave(text(ALL_PRODUCTS_STRING));
    }

    public final List<String> KIDS_DRESSES = ReferencesReader.getKidsDresses(org.nasva.constants.Constant.REFERENCES_FILENAME);

    public SearchProductsPage clickWomenCategoryButton() {
        WOMEN_CATEGORY_BUTTON.scrollTo();
        WOMEN_CATEGORY_BUTTON.click();
        return this;
    }

    public SearchProductsPage clickMenCategoryButton() {
        MEN_CATEGORY_BUTTON.scrollTo();
        MEN_CATEGORY_BUTTON.click();
        return this;
    }

    public SearchProductsPage clickKidsCategoryButton() {
        KIDS_CATEGORY_BUTTON.scrollTo();
        KIDS_CATEGORY_BUTTON.click();
        return this;
    }

    public SearchProductsPage clickDressCategoryButton() {
        DRESS_CATEGORY_BUTTON.click();
        return this;
    }

    public SearchProductsPage clickKidsDressCategoryButton() {
        KIDS_DRESS_CATEGORY_BUTTON.click();
        return this;
    }

    public SearchProductsPage clickTShirtsCategoryButton() {
        T_SHIRTS_CATEGORY_BUTTON.click();
        return this;
    }

    public SearchProductsPage clickJeansCategoryButton() {
        JEANS_CATEGORY_BUTTON.click();
        return this;
    }

    public void isDressProduct() {
        ALL_PRODUCTS.first().shouldHave(matchText(DRESS_REGULAR_EXPRESSION));
    }

    public void isTShirts() {
        ALL_PRODUCTS.first().shouldHave(matchText(T_SHIRT_REGULAR_EXPRESSION));
    }

    public void isJeans() {
        ALL_PRODUCTS.first().shouldHave(matchText(JEANS_REGULAR_EXPRESSION));
    }

    public boolean isKidsDresses() {
        return ALL_PRODUCTS.stream()
                .allMatch(KIDS_DRESSES::contains);
    }
}
