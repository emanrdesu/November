@tag
Feature: User can sign up to mailing list.
  @tag1
  Scenario: User signs up to mailing list.
    Given User launches index page
    And clicks products page
    And clicks heritage page
    When user fills out mailing list form
    Then a successful sign up message should show