@Regression
Feature: DHP-57: As a patient, I want to see the updated list of specialities to reflect when adding a treatment info type to my timeline
	
	Scenario: 1a: Configuration manager enable speciality - treatment for patient
  Given the user is on configuration managers landing page
  And user navigate to Speciality List page
  When user enable default speciality treatment for patient
  Then enabled speciality treatment was displayed for patient
  
  @End
  Scenario: Close web browser
  
	Scenario: 1b: Patient views the request appointment success pop up
  Given the user is on patient landing page
  When user select treatment in the info type dropdown
  Then default treatment speciality is displayed in the treatment type dropdown

  @End
  Scenario: Close web browser