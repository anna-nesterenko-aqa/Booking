package com.booking.stepdefs;

import org.junit.jupiter.api.Assertions;

import com.booking.core.utils.StringsHelper;

import io.cucumber.java.en.Then;
import com.booking.pages.SearchResultsPage;
import com.booking.core.utils.DateUtils;

public class SearchResultsPageSteps {

    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Then("^Print number of properties found$")
    public void printNumberOfPropertiesFound() {
        searchResultsPage.printNumberOfPropertiesFound();
    }

    @Then("^'(.*)' day of next month is displayed as check-in date$")
    public void checkInDateIsCorrect(int day) {
        assertDateFormat(day, searchResultsPage.checkInDateText());
    }

    @Then("^'(.*)' day of next month is displayed as check-out date$")
    public void checkOutDateIsCorrect(int day) {
        assertDateFormat(day, searchResultsPage.checkOutDateText());
    }

    @Then("^Print names of properties found on first page$")
    public void printNamesOfProperties() {
        searchResultsPage.printNamesOfProperties();
    }

    private void assertDateFormat(int day, String dateText) {
        String actualDate = StringsHelper.splitByNewLineAndGetLastElement(dateText);
        String expectedDate = DateUtils.nextMonthDateForDay(day, DateUtils.retrieveDateFormat(actualDate));
        Assertions.assertEquals(expectedDate, actualDate);
    }
}
