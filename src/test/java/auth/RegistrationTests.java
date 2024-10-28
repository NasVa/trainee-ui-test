package auth;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.nasva.constants.Constant;
import org.nasva.pages.CreatedAccountPage;
import org.nasva.pages.LoginPage;
import org.nasva.pages.RegistrationPage;
import org.nasva.services.LoginInfoEnter;
import org.nasva.services.RegistrationInfoEnter;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RegistrationTests {

    @BeforeAll
    public static void config() {
        Configuration.baseUrl = Constant.urlsConfig.baseUrl();
    }

    Faker faker = new Faker();
    private final LoginPage loginPage = new LoginPage();
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final CreatedAccountPage createdAccountPage = new CreatedAccountPage();

    @Test
    public void successRegistrationPageOpen() {
        LoginInfoEnter.getFilledOutLoginPage();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.isRegisterPage();
    }

    @Test
    public void loginRegistrationWithoutName() {
        loginPage.register("", faker.internet().emailAddress())
                .isLoginPage();
    }

    @Test
    public void loginRegistrationWithoutMail() {
        loginPage.register(faker.name().name(), "")
                .isLoginPage();
    }

    @Test
    public void loginRegistrationWithoutDomainName() {
        loginPage.register(faker.name().name(), faker.internet().emailAddress().split("@")[0])
                .isLoginPage();
    }

    @Test
    public void loginRegistrationWithoutMailSign() {
        String name = faker.name().name();
        loginPage.register(name, name)
                .isLoginPage();
    }

    @Test
    public void registrationWithExistMail() {
        loginPage.register(faker.name().firstName(), Constant.EXIST_MAIL)
                .isLoginPage();
    }

    @Test
    public void successRegistration() {
        LoginInfoEnter.getFilledOutLoginPage();
        RegistrationInfoEnter.getFilledOutRegistrationPage()
                .clickRegistrationButton();
        webdriver().shouldHave(url(Constant.urlsConfig.accountCreatedUrl()));
    }

    @Test
    public void registrationWithoutName() {
        LoginInfoEnter.getFilledOutLoginPage();
        RegistrationInfoEnter.getFilledOutRegistrationPage()
                .setName("")
                .clickRegistrationButton()
                .isRegisterPage();
    }

    @Test
    public void registrationWithoutPassword() {
        LoginInfoEnter.getFilledOutLoginPage();
        registrationPage
                .setPassword("")
                .clickRegistrationButton()
                .isRegisterPage();
    }

    @Test
    public void registrationWithoutFirstName() {
        LoginInfoEnter.getFilledOutLoginPage();
        RegistrationInfoEnter.getFilledOutRegistrationPage()
                .setFirstName("")
                .clickRegistrationButton()
                .isRegisterPage();
    }

    @Test
    public void registrationWithoutLastName() {
        LoginInfoEnter.getFilledOutLoginPage();
        registrationPage
                .setLastName("")
                .clickRegistrationButton()
                .isRegisterPage();
    }

    @Test
    public void registrationWithoutState() {
        LoginInfoEnter.getFilledOutLoginPage();
        registrationPage
                .setState("")
                .clickRegistrationButton()
                .isRegisterPage();
    }

    @Test
    public void registrationWithoutCity() {
        LoginInfoEnter.getFilledOutLoginPage();
        registrationPage
                .setCity("")
                .clickRegistrationButton()
                .isRegisterPage();
    }

    @Test
    public void registrationWithoutZipcode() {
        LoginInfoEnter.getFilledOutLoginPage();
        registrationPage
                .setZipcode("")
                .clickRegistrationButton()
                .isRegisterPage();
    }

    @Test
    public void registrationWithoutMobileNumber() {
        LoginInfoEnter.getFilledOutLoginPage();
        registrationPage
                .setMobileNumber("")
                .clickRegistrationButton()
                .isRegisterPage();
    }

    @Test
    public void registrationWithIncorrectMobileNumber() {
        Faker faker = new Faker();
        LoginInfoEnter.getFilledOutLoginPage();
        registrationPage
                .setMobileNumber(faker.phoneNumber().phoneNumber() + faker.name())
                .clickRegistrationButton()
                .isRegisterPage();
    }

    @Test
    public void successLoginAfterRegistration() {
        LoginInfoEnter.getFilledOutLoginPage();
        RegistrationInfoEnter.getFilledOutRegistrationPage()
                .clickRegistrationButton();
        createdAccountPage
                .clickContinueButton();

    }

}

