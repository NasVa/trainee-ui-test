package org.nasva.services;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.nasva.constants.Constant;
import org.nasva.pages.RegistrationPage;

import java.util.Calendar;

public class RegistrationInfoEnter {
    public static RegistrationPage getFilledOutRegistrationPage(){
        Faker faker = new Faker();
        RegistrationPage registrationPage = new RegistrationPage();
        Calendar instance = Calendar.getInstance();
        instance.setTime(faker.date().birthday());
        Address address = faker.address();
        Address address2 = faker.address();
        return registrationPage
                .setPassword(faker.internet().password())
                .setDays(String.valueOf(instance.get(Calendar.DAY_OF_MONTH)))
                .setMonths(instance.get(Calendar.MONTH))
                .setYears(String.valueOf(instance.get(Calendar.YEAR)))
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setCompany(faker.company().name())
                .setAddress(address.fullAddress())
                .setAddress2(address2.fullAddress())
                .setCountry(Constant.COUNTRIES.getLast())
                .setState(address.state())
                .setCity(address.city())
                .setZipcode(address.zipCode())
                .setMobileNumber(faker.phoneNumber().phoneNumber());
    }
}
