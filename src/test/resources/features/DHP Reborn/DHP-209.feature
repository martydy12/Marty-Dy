@Regression
Feature: DHP-209: As a Clinician, I want to see a 'Type' column when I view a Patient's notes so that I can differentiate general notes from notes associated to appointments

  Scenario: 1:  Clinician views Notes tab
    Given the clinician is on the patient's profile page
    When user clicks on a specific patient
    And clicks on notes tab
    Then they see a Type column between the Clinician and Note Details columns

  @End
  Scenario: Close web browser

  Scenario: 2: Clinician orders Notes #Will not automate sorting functions
