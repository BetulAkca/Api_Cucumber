Feature: User profile operations

  Scenario: Retrieve All Profiles t01
    When The user sends a GET request and able to see all profiles
    Then The user verifies that status code is 200


  Scenario: Retrieve All Profiles t02
    When The user sends a GET request and able to see all profiles second way
    Then The user verifies that status code is 200


  Scenario Outline: Get User Profile with Path Param t03
    When The user sends a GET request with <id>
    Then The user verifies that status code is 200
    And The user verifies that user's info  name is "<name>" and company is "<company>" and location is "<location>" and email is "<email>"
    Examples:
      | id   | name        | company        | location | email                 |
      | 1903 | Jashua King | Eurotech       | Hamburg  | Jashua8@king.com      |
      | 1662 | bonucci     | Eurotech Study | Hamburg  | bonucci1@eurotech.com |
