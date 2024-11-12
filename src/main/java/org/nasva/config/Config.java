package org.nasva.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.nasva.constants.Constant;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class Config {
    public static void config(){
        Configuration.baseUrl = Constant.urlsConfig.baseUrl();
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote = System.getenv("SELENOID_REMOTE_URL");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
            "enableVNC", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}
