@RegressionDD
Feature: DHP-339: As a user i can see my preferred language set in the application.

  Scenario: 1a:  Default language indicator
    Given user is on homepage
    Then user sees preferred language set in the application

  @End
  Scenario: Close web browser
