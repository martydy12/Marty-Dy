@Regression
Feature: DHP-339: As a user i can see my preferred language set in the application.

  Scenario: 1:  language indicator (Language Bar)
    Given user is on homepage
    Then user sees preferred language set in the application

  @End
  Scenario: Close web browser
