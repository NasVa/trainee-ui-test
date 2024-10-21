package org.nasva.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private final SelenideElement name = $("[data-qa = 'name']");
    private final SelenideElement password = $("[data-qa = 'password']");
    private final SelenideElement days = $("[data-qa = 'days']");
    private final SelenideElement months = $("[data-qa = 'months']");
    private final SelenideElement years = $("[data-qa = 'years']");
    private final SelenideElement firstName = $("[data-qa = 'first_name']");
    private final SelenideElement lastName = $("[data-qa = 'last_name']");
    private final SelenideElement company = $("[data-qa = 'company']");
    private final SelenideElement address = $("[data-qa = 'address']");
    private final SelenideElement address2 = $("[data-qa = 'address2']");
    private final SelenideElement country = $("[data-qa = 'country']");
    private final SelenideElement state = $("[data-qa = 'state']");
    private final SelenideElement city = $("[data-qa = 'city']");
    private final SelenideElement zipcode = $("[data-qa = 'zipcode']");
    private final SelenideElement mobileNumber = $("[data-qa = 'mobile_number']");
    private final SelenideElement registrationButton = $("[data-qa = 'create-account']");
    private final SelenideElement loginForm = $(".login-form");
    private final String registrationString = "Enter Account Information";

    public RegistrationPage setName(String name){
        this.name
                .scrollTo()
                .setValue(name);
        return this;
    }
    public RegistrationPage setPassword(String password){
        this.password
                .scrollTo()
                .setValue(password);
        return this;
    }
    public RegistrationPage setFirstName(String mail){
        this.firstName.setValue(mail);
        return this;
    }
    public RegistrationPage setLastName(String lastName){
        this.lastName.setValue(lastName);
        return this;
    }
    public RegistrationPage setCompany(String company){
        this.company.setValue(company);
        return this;
    }
    public RegistrationPage setAddress(String address){
        this.address.setValue(address);
        return this;
    }
    public RegistrationPage setAddress2(String address2){
        this.address2.setValue(address2);
        return this;
    }

    public List<String> getCountries(){
        System.out.println(this.country.getOptions()
                .stream().map(SelenideElement::toString).collect(Collectors.toList()));
        return this.country.getOptions()
                .stream().map(SelenideElement::toString).collect(Collectors.toList());
    }
    public RegistrationPage setCountry(String country){
        this.country
                .scrollTo()
                .click();
        this.country.selectOption(country);
        return this;
    }
    public RegistrationPage setState(String state){
        this.state.setValue(state);
        return this;
    }
    public RegistrationPage setCity(String city){
        this.city.setValue(city);
        return this;
    }
    public RegistrationPage setZipcode(String zipcode){
        this.zipcode.setValue(zipcode);
        return this;
    }
    public RegistrationPage setMobileNumber(String mobileNumber){
        this.mobileNumber.setValue(mobileNumber);
        return this;
    }
    public RegistrationPage setDays(String days){
        this.days.click();
        this.days.selectOption(days);
        return this;
    }
    public RegistrationPage setMonths(int months){
        this.months.click();
        this.months.selectOption(months);
        return this;
    }
    public RegistrationPage setYears(String years){
        this.years.click();
        this.years.selectOption(years);
        return this;
    }
    public RegistrationPage clickRegistrationButton(){
        this.registrationButton
                .scrollTo()
                .click();
        return this;
    }

    public void isRegisterPage(){
        this.loginForm.shouldHave(text(registrationString));
    }
}
