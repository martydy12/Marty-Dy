@Regression
Feature: DHP-119: As a patient, I want to be able to request In Clinic appointment with my clinician, so the appointment can be personalised
	
  Scenario: 1a: Configuration manager toggles off assessment in the general settings page
  Given the user is on configuration managers landing page
  When user clicks on settings menubar
  And user enable appointment settings
  Then appointment toggle was enabled

	@End
  Scenario: Close web browser

  Scenario: 1b: Patient views the 'Select Time & Date' page in an appointment request
  Given the user is on patient landing page
  When user request an appointment
  Then options to contact patient was displayed
  
  @End
  Scenario: Close web browser