package org.nasva.pages;

import com.codeborne.selenide.SelenideElement;
import org.nasva.constants.Constant;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final static SelenideElement SIGNUP_NAME = $("[data-qa = 'signup-name']");
    private final static SelenideElement SIGNUP_MAIL = $("[data-qa = 'signup-email']");
    private final static SelenideElement SIGNUP_BUTTON = $("[data-qa = 'signup-button']");
    private final static SelenideElement LOGIN_FORM = $(".signup-form");
    private final static String SIGNUP_STRING = "New User Signup!";

    public LoginPage openPage(){
        open(Constant.urlsConfig.registerUrl());
        return this;
    }

    public LoginPage register(String name, String mail){
        return this
            .setSignupName(name)
            .setSignupMail(mail)
            .clickSignupButton();
    }

    public LoginPage setSignupName(String name){
        SIGNUP_NAME.setValue(name);
        return this;
    }

    public LoginPage setSignupMail(String mail){
        SIGNUP_MAIL.setValue(mail);
        return this;
    }

    public LoginPage clickSignupButton(){
        SIGNUP_BUTTON.click();
        return this;
    }

    public void isLoginPage(){
        LOGIN_FORM.shouldHave(text(SIGNUP_STRING));
    }
}
