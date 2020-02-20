@Regression
Feature: DHP-100: As a patient, I don't want to see the disabled specialities  when adding a treatment info type to my timeline
	
	Scenario: 1a: Configuration manager enable speciality - treatment for patient
  Given the user is on configuration managers landing page
  And user navigate to Speciality List page
  When user enable default speciality treatment for patient
  Then enabled speciality treatment was displayed for patient
  
  @End
  Scenario: Close web browser
  
	Scenario: 1b: Patient views the request appointment success pop up”
  Given the user is on patient landing page
  When user select treatment in the info type dropdown
  Then disabled treatment speciality is not displayed in the treatment type dropdown

  @End
  Scenario: Close web browser