@wip
Feature: Register User


  Scenario Outline: DevEx Register User t04
    When The user sends a POST request with "<email>" and "<password>" and "<name>" and "<google>" and "<facebook>" and "<github>"
    Then The user verifies that status code is <statusCode>
    And The user verifies that body contains "token"
    And The compiler gets the token
    Examples:
      | email                   | password | name       | google           | facebook       | github           | statusCode |
      | edindzeko3@eurotech.com | Test1234 | Edin Dzeko | dzeko@google.com | dzeko@face.com | dzeko@github.com | 200        |


  Scenario Outline: User can able to POST request and gets the token and save profile t05
    When The user sends a POST request with "<company>" and "<website>" and "<location>" and "<status>" and "<skills>" and "<githubusername>" and "<youtube>" and "<twitter>" and "<facebook>" and "<linkedin>" and "<instagram>"
    Then The user verifies that status code is <statusCode>
    And  The user verifies that name as "<name>" and email as "<email>"
    Examples:
      | company | website           | location | status    | skills      | githubusername | youtube     | twitter     | facebook    | linkedin        | instagram    | statusCode | name       | email                   |
      | FB      | edindzeko2@fb.com | Istanbul | Developer | Java,PHP,JS | edinDzeko24    | Dzeko24tube | Dzeko24twit | Dzeko24face | Dzeko24linkedin | Dzeko24insta | 200        | Edin Dzeko | edindzeko3@eurotech.com |