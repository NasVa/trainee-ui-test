package org.nasva;

import org.nasva.constants.Constant;
import org.nasva.pages.LoginPage;

public class AuthSteps {
    public static LoginPage loginPage = new LoginPage();

    public static void testAuthorization() {
        loginPage.openPage();
        loginPage.login(Constant.TEST_MAIL, Constant.TEST_PASSWORD);
    }
}
