package org.nasva.constants;

import org.aeonbits.owner.ConfigFactory;
import org.nasva.config.UrlsConfig;

import java.util.List;

public class Constant {
    public static final UrlsConfig urlsConfig = ConfigFactory.create(UrlsConfig.class, System.getProperties());

    public static final List<String> COUNTRIES = List.of(
            "India", "United States", "Canada", "Australia", "Israel", "New Zealand", "Singapore"
    );

    public static final String EXIST_MAIL = "test@mail.ru";

}
