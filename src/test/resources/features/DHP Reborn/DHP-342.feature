@Regression
Feature: DHP-342: As a Configuration Manager, I want to set the default language for the application

  Scenario: 1a:  Default language indicator
    Given the user is on configuration managers landing page
    When user clicks on settings menubar
    And enables multilingual setting
    Then user sees default language label and dropdown
    When disables multilingual setting
    Then default language label and dropdown is hidden

  @End
  Scenario: Close web browser
