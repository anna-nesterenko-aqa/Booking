package com.booking.stepdefs;

import com.booking.pages.StaysPage;

import io.cucumber.java.en.When;

public class StaysPageSteps {

    private final StaysPage staysPage = new StaysPage();

    @When("^User selects place to go '(.*)'$")
    public void selectPlaceToGo(String placeToGo) {
        staysPage.selectPlaceToGo(placeToGo);
    }

    @When("^User expands calendar$")
    public void expandCalendar() {
        staysPage.expandCalendar();
    }

    @When("^User selects check-(?:in|out) date '(\\d+)' day of next month$")
    public void selectDate(int day) {
        staysPage.selectDate(day);
    }

    @When("^User clicks search button$")
    public void clickSearchButton() {
        staysPage.clickSearchButton();
    }
}
