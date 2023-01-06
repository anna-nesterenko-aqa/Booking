package com.booking.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.booking.core.selenium.BasePage;

public class SearchResultsPage extends BasePage {

    @FindBy(css = "#right h1")
    private WebElement searchResultsLabel;

    @FindBy(css = "[data-testid='title']")
    private List<WebElement> propertiesTitles;

    @FindBy(css = "[data-testid='date-display-field-start']")
    private WebElement checkInDateLabel;

    @FindBy(css = "[data-testid='date-display-field-end']")
    private WebElement checkOutDateLabel;

    public void printNumberOfPropertiesFound() {
        System.out.println(StringUtils.getDigits(searchResultsLabel.getText()));
    }

    public String checkInDateText() {
        return checkInDateLabel.getText();
    }

    public String checkOutDateText() {
        return checkOutDateLabel.getText();
    }

    public void printNamesOfProperties() {
        propertiesTitles.forEach(name -> System.out.println(name.getText()));
    }
}
