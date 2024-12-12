Feature: Searching for non-existent book
  If searching for a non-existent book, "no books found" text must show up
  Scenario: Searching non existent book
    Given the user is on the search page.
    When user presses SEARCH with empty input
    Then they can see failure message