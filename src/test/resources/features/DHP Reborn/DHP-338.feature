@Regression
Feature: DHP-338: As a user i can set my preferred language

  Scenario: 1:  Thai is the preferred language
    Given user is on homepage
    When user set language to Thai
    Then Thailand is set as preferred language on the language bar

  Scenario: 2:  English is the preferred language
    When user set language to English
    Then English is set as preferred language on the language bar

  @End
  Scenario: Close web browser
