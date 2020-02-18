@Regression
Feature: DHP-207: As a Clinician, I want to conduct a keyword search across patient's notes so that I can quickly find the relevant notes I need to review

  Scenario: 1: Clinician views a Patient's Notes
    Given the clinician is on the patient's profile page
    When user clicks on a specific patient
    And clicks on notes tab
    Then they see a Search field defaulted with 'Search Notes'
    And they see a 'Reset' button
    And they see a 'Search' button

  @End
  Scenario: Close web browser

  Scenario: 2: Search returns no matching results
    Given the Clinician is viewing a patient's notes
    And they have entered an invalid keyword in the 'Search' field
    When they click on the 'Search' button
    Then the tab is empty
    And the following message is displayed: No records found.

  @End
  Scenario: Close web browser

  Scenario: 3: Search returns matching results
    Given the Clinician is viewing a patient's notes
    And they have entered an valid keyword in the 'Search' field
    When they click on the 'Search' button
    And the following message is displayed: Total of Total no. of notes displayed of  Total no. of notes returned

  @End
  Scenario: Close web browser

  Scenario: 4: Clinician resets Search
    Given the Clinician is viewing a patient's notes
    And they have entered an valid keyword in the 'Search' field
    When they click on the 'Reset' button
    Then they see a Search field defaulted with 'Search Notes'

  @End
  Scenario: Close web browser
