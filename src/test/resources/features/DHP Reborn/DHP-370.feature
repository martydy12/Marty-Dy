@Regression
Feature: DHP-370: As a Clinician i can enter values in Lifeevent and it shows in the graph in a different color.

  Scenario: 1a:  Enable PSA / Toggles ON health indicator
    Given the user is on configuration managers landing page
    When user clicks on settings menubar
    And user enables PSA toggle on info type settings page
    And user toggles on health indicator option on settings page

  @End
  Scenario: Close web browser

  Scenario: 1: Clinician enters Health Indicator results
    Given the clinician is on the patient's profile page
    When user clicks on a specific patient
    And clicks on PSA tab
    And clicks on Enter a PSA level button
    And type in the value in Health Indicator result then save

  #Then they see the Health Indicator graph
  @End
  Scenario: Close web browser
