@Regression
Feature: DHP-371: As a Patient i can differentiate between the values entered by my clinician and by me

  Scenario: 1a:  Enable PSA / Toggles ON health indicator
    Given the user is on configuration managers landing page
    When user clicks on settings menubar
    And user enables PSA toggle on info type settings page
    And user toggles on health indicator option on settings page

  @End
  Scenario: Close web browser

  Scenario: 1: Patient enters Health Indicator results
    Given the user is on PSA tab on my info page
    Then they see the Health Indicator graph

  @End
  Scenario: Close web browser
