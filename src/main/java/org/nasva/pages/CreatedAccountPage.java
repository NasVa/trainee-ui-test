package org.nasva.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CreatedAccountPage {
    private final SelenideElement continueButton = $("[data-qa = 'continue-button']");
    private final SelenideElement accountCreatedLabel = $("[data-qa = 'account-created']");
    private final String accountCreatedString = "Account Created!";
    public CreatedAccountPage clickContinueButton(){
        this.continueButton
                .click();
        return this;
    }

    public void isMainPageWithAccount(){
        this.accountCreatedLabel.shouldHave(text(accountCreatedString));
    }
}
