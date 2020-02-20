@Regression
Feature: DHP-110: As a patient, I want to see the updated list of specialty options when adding a specialist for my diagnosis 
	
	Scenario: 1a: Configuration manager enable speciality - patient medical info for patient
  Given the user is on configuration managers landing page
  And user navigate to Speciality List page
  When user enable default speciality - patient medical info
  Then enabled speciality - patient medical info was displayed for patient
  
  @End
  Scenario: Close web browser
  
	Scenario: 1b: Patient adds/edits details of their specialist when a default 'speciality - clinician' are enabled
  Given the user is on patient landing page
  And user navigate to profile - medical info
  When user clicks on speciality dropdown
  Then enabled PMI speciality was displayed in the speciality dropdown
  And disabled PMI speciality is not displayed in the speciality dropdown

  @End
  Scenario: Close web browser