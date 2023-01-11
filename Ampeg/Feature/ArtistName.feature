@tag
Feature: Clicking Artist should show artist name
  @tag1
  Scenario: User clicks artist page
    Given User launches index page
    And clicks artists page
    When user clicks on artist with id <id>
    Then artist name with id <id> should be <name>

    Examples:
    	 | id  | name             |
    	 | 101 | "Seye Adelekan"  |