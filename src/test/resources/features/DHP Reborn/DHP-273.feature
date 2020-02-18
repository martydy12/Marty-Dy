@Regression
Feature: DHP-273: As a Patient, I want my Medicare No. validated so accurate information is stored in my profile

  Scenario: 1:  Medicare no. is not 10  characters
    Given the Patient is updating their profile
    And they enter their Medicare number is not ten characters
    When they click on the Save button
    Then the following message is displayed inline: "Medicare No. must be 10 digits"

  @End
  Scenario: Close web browser

  Scenario: 2:  Medicare no. is not 10  characters
    Given the Patient is updating their profile
    And they enter their Medicare number is not ten characters
    When they click on the Next button
    Then the following message is displayed inline: "Medicare No. must be 10 digits"

  @End
  Scenario: Close web browser
