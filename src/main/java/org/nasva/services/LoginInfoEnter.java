package org.nasva.services;

import com.github.javafaker.Faker;
import org.nasva.pages.LoginPage;

public class LoginInfoEnter {
    public static void getFilledOutLoginPage(){
        Faker faker = new Faker();
        LoginPage loginPage = new LoginPage();
        loginPage
            .openPage()
            .register(faker.name().firstName(), faker.internet().emailAddress());
    }
}
