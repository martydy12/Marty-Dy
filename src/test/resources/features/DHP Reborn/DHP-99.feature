@RegressionD
Feature: DHP-99: As a patient, I want to see the updated list of not disabled specialities to reflect when adding an appointment info type to my timeline

	Scenario: 1a: Configuration manager enable speciality - appointment for patient
  Given the user is on configuration managers landing page
  And user navigate to Speciality List page
  When user enable default speciality appointment for patient
  Then enabled speciality appointment was displayed for patient
  
  @End
  Scenario: Close web browser
  
	Scenario: 1b: Patient views the request appointment success pop up”
  Given the user is on patient landing page
  When user select appointment in the info type dropdown
  Then default appointment speciality is displayed in the appointment type dropdown
  
  @End
  Scenario: Close web browser