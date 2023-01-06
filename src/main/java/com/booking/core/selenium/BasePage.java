package com.booking.core.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(css = "#onetrust-accept-btn-handler")
    private WebElement acceptCookiesButton;

    public BasePage() {
        PageFactory.initElements(WebDriverProvider.getWebDriver(), this);
    }

    public void acceptCookies() {
        if (WaitHelper.hasCondition(d -> acceptCookiesButton.isDisplayed(), 1))
            acceptCookiesButton.click();
    }
}
