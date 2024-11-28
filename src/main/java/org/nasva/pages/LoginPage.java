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
    private final static SelenideElement LOGIN_MAIL = $("[data-qa = 'login-email'");
    private final static SelenideElement LOGIN_PASSWORD = $("[data-qa = 'login-password'");
    private final static SelenideElement LOGIN_BUTTON = $("[data-qa = 'login-button']");

    public LoginPage openPage() {
        open(Constant.urlsConfig.registerUrl());
        return this;
    }

    public LoginPage register(String name, String mail) {
        return this
                .setSignupName(name)
                .setSignupMail(mail)
                .clickSignupButton();
    }

    public LoginPage login(String mail, String password) {
        return this
                .setLoginMail(mail)
                .setLoginPassword(password)
                .clickLoginButton();
    }

    public LoginPage setSignupName(String name) {
        SIGNUP_NAME.setValue(name);
        return this;
    }

    public LoginPage setSignupMail(String mail) {
        SIGNUP_MAIL.setValue(mail);
        return this;
    }

    public LoginPage clickSignupButton() {
        SIGNUP_BUTTON.click();
        return this;
    }

    public void isLoginPage() {
        LOGIN_FORM.shouldHave(text(SIGNUP_STRING));
    }

    public LoginPage setLoginMail(String mail) {
        LOGIN_MAIL.setValue(mail);
        return this;
    }

    public LoginPage setLoginPassword(String password) {
        LOGIN_PASSWORD.setValue(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        LOGIN_BUTTON.click();
        return this;
    }
}
