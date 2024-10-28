package org.nasva.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CreatedAccountPage {
    private final static SelenideElement CONTINUE_BUTTON = $("[data-qa = 'continue-button']");
    private final static SelenideElement ACCOUNT_CREATED_LABEL = $("[data-qa = 'account-created']");
    private final static String ACCOUNT_CREATED_STRING = "Account Created!";
    public void clickContinueButton(){
        CONTINUE_BUTTON.click();
    }

    public void isMainPageWithAccount(){
        ACCOUNT_CREATED_LABEL.shouldHave(text(ACCOUNT_CREATED_STRING));
    }
}
