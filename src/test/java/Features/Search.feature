
Feature: Google Search | Steps

  Scenario Outline: Verify Google Search for "Testing"
    Given I am on the Google homepage
    When I enter <searchText> into the search bar
    And I click the search button
    Then I should see search results containing <expectedResult>
    Examples:
      | searchText | expectedResult |
      | "Testing"  | "Testing"      |
