package org.nasva.pages;

import com.codeborne.selenide.SelenideElement;
import org.nasva.constants.Constant;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement signupName = $("[data-qa = 'signup-name']");
    private final SelenideElement signupMail = $("[data-qa = 'signup-email']");
    private final SelenideElement signupButton = $("[data-qa = 'signup-button']");
    private final SelenideElement loginForm = $(".signup-form");
    private final String signupString = "New User Signup!";


    public LoginPage openPage(){
        open(Constant.Urls.REGISTER_URL);
        return this;
    }

    public LoginPage register(String name, String mail){
        return this.openPage()
            .setSignupName(name)
            .setSignupMail(mail)
            .clickSignupButton();
    }
    public LoginPage setSignupName(String name){
        signupName.setValue(name);
        return this;
    }
    public LoginPage setSignupMail(String mail){
        signupMail.setValue(mail);
        return this;
    }
    public LoginPage clickSignupButton(){
        signupButton.click();
        return this;
    }

    public void isLoginPage(){
        this.loginForm.shouldHave(text(signupString));
    }
}
