package com.booking.stepdefs;

import io.cucumber.java.After;
import com.booking.core.selenium.WebDriverProvider;

public class Hooks {

    @After
    public void tearDownDriver() {
        WebDriverProvider.getWebDriver().quit();
    }
}
