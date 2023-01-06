package com.booking.core.selenium;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitHelper {

    private WaitHelper() {
    }

    public static <T> boolean hasCondition(Function<WebDriver, T> condition, long timeoutInSeconds) {
        try {
            waitUntil(condition, timeoutInSeconds);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static <T> T waitUntil(Function<WebDriver, T> condition, long timeoutInSeconds) {
        return webDriverWait(timeoutInSeconds).until(condition);
    }

    private static WebDriverWait webDriverWait(long timeoutInSeconds) {
        try {
            WebDriverProvider.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            WebDriverWait wait = new WebDriverWait(WebDriverProvider.getWebDriver(), Duration.ofSeconds(timeoutInSeconds));
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(ElementNotInteractableException.class);
            return wait;
        }
        finally {
            WebDriverProvider.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }
}
