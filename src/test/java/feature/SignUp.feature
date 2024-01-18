Feature: Testing dbankdemo SignUp feature

  Scenario: Testing SignUp
    Given User is on SignUp page
    When Check next button without any data
    Then Check next button with already registered data
    And Check next button with valid data
    Then Check Register button without any data
    And Check Register button with valid data