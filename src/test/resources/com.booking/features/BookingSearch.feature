Feature: Booking search

  Scenario: Search in Porto
    Given User opens 'https://www.booking.com' url
    When User selects place to go 'Porto'
    And User expands calendar
    And User selects check-in date '1' day of next month
    And User selects check-out date '7' day of next month
    And User clicks search button
    Then Print number of properties found
    And '1' day of next month is displayed as check-in date
    And '7' day of next month is displayed as check-out date
    And Print names of properties found on first page
