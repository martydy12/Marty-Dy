@Regression
Feature: DHP-169: As a Patient, I don't want to see the progress bar in assessment if only one assessment is enabled by Config Manager

  Scenario: 1a:  Toggle ON Assessment / Toggle ON Needs / Toggle OFF Depression / Toggle OFF Anxiety / Toggle OFF Physical Activity
    Given the user is on configuration managers landing page
    When user clicks on settings menubar
    Then user toggles on Enable assessment option on settings page
    And user toggles on Enable needs option on settings page
    And user toggles off Enable depression option on settings page
    And user toggles off Enable anxiety option on settings page
    And user toggles off Enable physical activity option on settings page

  @End
  Scenario: Close web browser

  Scenario: 1b: When one assessment is enabled
    Given the user is on patient landing page
    When they click on the Assessment in the left menu bar
    And click on the Start Assessment button on the right top corner of the page
    Then no progress bar is displayed

  @End
  Scenario: Close web browser
