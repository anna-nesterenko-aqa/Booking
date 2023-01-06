package com.booking.core.selenium;

public class NavigationHelper {

    private final BasePage page = new BasePage();

    public void openUrl(String url) {
        WebDriverProvider.getWebDriver().get(url);
        page.acceptCookies();
    }
}
