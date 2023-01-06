package com.booking.core.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class WebDriverProvider {

    private static WebDriver DRIVER;

    private WebDriverProvider() {
    }

    public static WebDriver getWebDriver() {
        if (DRIVER == null)
            DRIVER = initDriver();
        return DRIVER;
    }

    private static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
}
