Feature: Searching Book By Name
  As a user I want to be able to search a book by its name.
  Scenario: Searching for a book by its name
    Given user is on the search page
    When user enters "Här kommer Pippi Långstrump" into search field
    And clicks SEARCH button
    Then book titled "Här kommer Pippi Långstrump" listed
