Feature: Compare UI and API Experiences
  @ui_api_e2e
  Scenario Outline: UI and API Experiences t06
    Given The user sends a POST request and login with "<email>" and "<password>"
    When The user sends a POST request for adding an experience with "<title>" "<company>" "<location>" "<from>" "<to>" "<current>" "<description>"
    Then The user verifies that status code is <statusCode>
    Examples:
      | email                   | password | title     | company | location | from       | to         | current | description          | statusCode |
      | edindzeko2@eurotech.com | Test1234 | Developer | Inter   | Milano   | 2022-01-01 | 2022-08-01 | false   | Full stack Developer | 201        |
