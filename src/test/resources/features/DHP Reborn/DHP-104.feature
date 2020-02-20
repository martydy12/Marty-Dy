@Regression
Feature: DHP-104: As a Clinician Manager, I want to see the updated list of specialities when adding/editing a clinician profile
	
	Scenario: 1a: Configuration manager enable speciality - clinician for clinician manager
  Given the user is on configuration managers landing page
  And user navigate to Speciality List page
  When user enable default speciality clinician for clinician manager
  Then enabled speciality clinician was displayed for clinician manager

  @End
  Scenario: Close web browser
  
	Scenario: 1b: Clinician Manager adds/edits a user (clinician) profile when a speciality - user is  enabled
	Scenario: 2: Clinician Manager adds/edits a clinician profile when a default speciality - user is disabled
  Given the clinicians manager is on clinicians page
  When user clicks on create a clinician button
  And disabled clinician speciality is not displayed in the speciality dropdown
  Then default clinician speciality is displayed in the speciality dropdown

  @End
  Scenario: Close web browser
