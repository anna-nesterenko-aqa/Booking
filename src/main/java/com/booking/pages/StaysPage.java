package com.booking.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.booking.core.selenium.WaitHelper;
import com.booking.core.selenium.BasePage;

public class StaysPage extends BasePage {

    @FindBy(css = "[name='ss']")
    private WebElement destinationInput;

    @FindBy(css = "[type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@data-testid='searchbox-dates-container' or @class='xp__dates-inner']/.//*[@type='button' or contains(@class, 'date-time')]")
    private WebElement checkInButton;

    @FindBy(xpath = "(//*[@role='grid' or @data-bui-ref='calendar-month'])[2]/.//*[@role='gridcell']")
    private List<WebElement> datesOfNextMonth;

    public void selectPlaceToGo(String placeToGo) {
        destinationInput.sendKeys(placeToGo);
    }

    public void expandCalendar() {
        checkInButton.click();
    }

    public void selectDate(int day) {
        WaitHelper.waitUntil(d -> !datesOfNextMonth.isEmpty(), 2);
        datesOfNextMonth.get(day - 1).click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
