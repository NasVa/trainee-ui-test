package org.nasva.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private final static SelenideElement NAME = $("[data-qa = 'name']");
    private final static SelenideElement PASSWORD = $("[data-qa = 'password']");
    private final static SelenideElement DAYS = $("[data-qa = 'days']");
    private final static SelenideElement MONTHS = $("[data-qa = 'months']");
    private final static SelenideElement YEARS = $("[data-qa = 'years']");
    private final static SelenideElement FIRST_NAME = $("[data-qa = 'first_name']");
    private final static SelenideElement LAST_NAME = $("[data-qa = 'last_name']");
    private final static SelenideElement COMPANY = $("[data-qa = 'company']");
    private final static SelenideElement ADDRESS = $("[data-qa = 'address']");
    private final static SelenideElement ADDRESS2 = $("[data-qa = 'address2']");
    private final static SelenideElement COUNTRY = $("[data-qa = 'country']");
    private final static SelenideElement STATE = $("[data-qa = 'state']");
    private final static SelenideElement CITY = $("[data-qa = 'city']");
    private final static SelenideElement ZIPCODE = $("[data-qa = 'zipcode']");
    private final static SelenideElement MOBILE_NUMBER = $("[data-qa = 'mobile_number']");
    private final static SelenideElement REGISTRATION_BUTTON = $("[data-qa = 'create-account']");
    private final static SelenideElement LOGIN_FORM = $(".login-form");
    private final static String REGISTRATION_STRING = "Enter Account Information";

    public RegistrationPage setName(String name){
        NAME.scrollTo()
            .setValue(name);
        return this;
    }

    public RegistrationPage setPassword(String password){
        PASSWORD.scrollTo()
                .setValue(password);
        return this;
    }

    public RegistrationPage setFirstName(String mail){
        FIRST_NAME.setValue(mail);
        return this;
    }

    public RegistrationPage setLastName(String lastName){
        LAST_NAME.setValue(lastName);
        return this;
    }

    public RegistrationPage setCompany(String company){
        COMPANY.setValue(company);
        return this;
    }

    public RegistrationPage setAddress(String address){
        ADDRESS.setValue(address);
        return this;
    }

    public RegistrationPage setAddress2(String address2){
        ADDRESS2.setValue(address2);
        return this;
    }

    public RegistrationPage setCountry(String country){
        COUNTRY.scrollTo()
                .click();
        COUNTRY.selectOption(country);
        return this;
    }

    public RegistrationPage setState(String state){
        STATE.setValue(state);
        return this;
    }

    public RegistrationPage setCity(String city){
        CITY.setValue(city);
        return this;
    }

    public RegistrationPage setZipcode(String zipcode){
        ZIPCODE.setValue(zipcode);
        return this;
    }

    public RegistrationPage setMobileNumber(String mobileNumber){
        MOBILE_NUMBER.setValue(mobileNumber);
        return this;
    }

    public RegistrationPage setDays(String days){
        DAYS.click();
        DAYS.selectOption(days);
        return this;
    }

    public RegistrationPage setMonths(int months){
        MONTHS.click();
        MONTHS.selectOption(months);
        return this;
    }

    public RegistrationPage setYears(String years){
        YEARS.click();
        YEARS.selectOption(years);
        return this;
    }

    public RegistrationPage clickRegistrationButton(){
        REGISTRATION_BUTTON
                .scrollTo()
                .click();
        return this;
    }

    public void isRegisterPage(){
        LOGIN_FORM.shouldHave(text(REGISTRATION_STRING));
    }
}
