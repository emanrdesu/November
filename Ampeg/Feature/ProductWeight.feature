@tag
Feature: User can see product's weight
  @tag1
  Scenario: User wants to see product weight 
    Given User launches index page
    And clicks products page
    And clicks proneo series page
    When user clicks on PN410LF product page
    Then user can see product's weight is "64 lb (29 kg)"