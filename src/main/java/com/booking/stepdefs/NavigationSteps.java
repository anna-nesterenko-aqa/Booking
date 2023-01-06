package com.booking.stepdefs;

import com.booking.core.selenium.NavigationHelper;
import io.cucumber.java.en.Given;

public class NavigationSteps {

        private final NavigationHelper navigationHelper = new NavigationHelper();

        @Given("^User opens '(.*)' url$")
        public void openUrl(String url) {
            navigationHelper.openUrl(url);
        }
}
