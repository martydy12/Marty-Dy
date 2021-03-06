package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Base;
import pages.Pages;

public class Steps_Clinician extends Base {
	Pages pages = new Pages();
	Steps steps = new Steps();

	// ################################################## Given Steps ##################################################
	@Given("^the clinician is on the patient's profile page$")
	public void the_clinician_is_on_the_patient_s_profile_page() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			webElementClick(pages.getPageHome().getLogInButton());
			Thread.sleep(5000);
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("DoctorEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("DoctorPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
			webElementClick(pages.getPageClinician().getPatientsMenubar());

		} catch (AssertionError exception) {
			throw new AssertionError(
					"Clinician Cannot proceed to patient's profile page." + "\n" + exception.getMessage());
		}
	}
	
	@Given("^the Clinician is viewing a patient's notes$")
	public void the_Clinician_is_viewing_a_patient_s_notes() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			webElementClick(pages.getPageHome().getLogInButton());
			Thread.sleep(5000);
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("DoctorEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("DoctorPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
			webElementClick(pages.getPageClinician().getPatientsMenubar());
			waitUntilWebElementVisible(pages.getPageClinician().getPatientSearchField());
			webElementClick(pages.getPageClinician().getPatientSearchField());
			waitUntilWebElementVisible(pages.getPageClinician().getPatientSearchField());
			webElementSendKeys(pages.getPageClinician().getPatientSearchField(), properties.getProperty("PatientFirstName"));
			webElementClick(pages.getPageClinician().getSearchButton());
			Thread.sleep(5000);
			waitUntilWebElementVisible(pages.getPageClinician().getDemethPatientLink());
			webElementClick(pages.getPageClinician().getDemethPatientLink());
			waitUntilWebElementVisible(pages.getPageClinician().getPatientNameLabel());
			webElementClick(pages.getPageClinician().getNotesTab());

		} catch (AssertionError exception) {
			throw new AssertionError(
					"Clinician Cannot proceed to notes page of the patient's profile." + "\n" + exception.getMessage());
		}
	}

	@Given("^the clinicians manager is on clinicians page$")
	public void the_clinicians_manager_is_on_clinicians_page() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			getCurrentUrl().contains(properties.getProperty("url"));
			webElementClick(pages.getPageHome().getLogInButton());

			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(),
					properties.getProperty("ClinicianManagerEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(),
					properties.getProperty("ClinicianManagerPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
		} catch (Exception exception) {
			throw new AssertionError("Cannot proceed to clinicians manager landing page." + "\n" + exception.getMessage());
		}
	}
	
	// ################################################## When Steps ###################################################
	@Given("^they have entered an invalid keyword in the 'Search' field$")
	public void they_have_entered_an_invalid_keyword_in_the_Search_field() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAddNewNoteButton());
			
			webElementClear(pages.getPageClinician().getInputSearchField());
			webElementSendKeys(pages.getPageClinician().getInputSearchField(), "Wala"); //Empty record
		} catch (Exception exception) {
			throw new AssertionError("Unable to input keyword on search field." + "\n" + exception.getMessage());
		}

	}
	@Given("^they have entered an valid keyword in the 'Search' field$")
	public void they_have_entered_an_valid_keyword_in_the_Search_field() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAddNewNoteButton());
			webElementClear(pages.getPageClinician().getInputSearchField());
			webElementSendKeys(pages.getPageClinician().getInputSearchField(), "no");
		} catch (Exception exception) {
			throw new AssertionError("Unable to input keyword on search field." + "\n" + exception.getMessage());
		}

	}
	
	@When("^they click on the 'Search' button$")
	public void they_click_on_the_Search_button() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAddNewNoteButton());
			webElementClick(pages.getPageClinician().getSearchButton());
		} catch (Exception exception) {
			throw new AssertionError("Unable to click search button." + "\n" + exception.getMessage());
		}
	}
	@When("^they click on the 'Reset' button$")
	public void they_click_on_the_Reset_button() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAddNewNoteButton());
			webElementClick(pages.getPageClinician().getResetButton());
		} catch (Exception exception) {
			throw new AssertionError("Unable to click reset button." + "\n" + exception.getMessage());
		}
	}

	
	@When("^user is in the clinicians page$")
	public void user_is_in_the_clinicians_page() throws Throwable {
		try {
			// checks user if in the clinicians page
			waitUntilWebElementVisible(pages.getPageClinician().getCreateClinicianButton());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getClinicianHeader()));
		} catch (Exception exception) {
			throw new AssertionError("Wrong page redirection." + "\n" + exception.getMessage());
		}

	}

	@When("^user clicks on a specific patient$")
	public void user_clicks_on_a_specific_patient() throws Throwable {

		try {
			waitUntilWebElementVisible(pages.getPageClinician().getPatientSearchField());
			webElementClick(pages.getPageClinician().getPatientSearchField());
			waitUntilWebElementVisible(pages.getPageClinician().getPatientSearchField());
			webElementSendKeys(pages.getPageClinician().getPatientSearchField(), properties.getProperty("PatientFirstName"));
			webElementClick(pages.getPageClinician().getSearchButton());
			Thread.sleep(5000);
			waitUntilWebElementVisible(pages.getPageClinician().getDemethPatientLink());
			webElementClick(pages.getPageClinician().getDemethPatientLink());

		} catch (Exception exception) {
			throw new Exception("Clinician Cannot search a patient's profile page." + "\n" + exception.getMessage());
		}

	}

	@When("^clicks on appointments tab$")
	public void clicks_on_appointments_tab() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getPatientNameLabel());
			webElementClick(pages.getPageClinician().getAppointmentsTab());
		} catch (Exception exception) {
			throw new Exception("Unable to locate Appointments tab." + "\n" + exception.getMessage());
		}
	}
	@When("^clicks on notes tab$")
	public void clicks_on_notes_tab() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getPatientNameLabel());
			webElementClick(pages.getPageClinician().getNotesTab());
		} catch (Exception exception) {
			throw new Exception("Unable to locate notes tab." + "\n" + exception.getMessage());
		}
	}


	@When("^user inputs an empty clinician to the search field$")
	public void user_inputs_an_empty_clinician_to_the_search_field() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getInputSearchField());
			webElementSendKeys(pages.getPageClinician().getInputSearchField(), "All");
			webElementClick(pages.getPageClinician().getSearchButton());
			waitUntilWebElementVisible(pages.getPageClinician().getSearchButton());
		} catch (Exception exception) {
			throw new Exception("Error in searching clinician" + "\n" + exception.getMessage());
		}

	}

	@When("^they click on reset on search field$")
	public void they_click_on_reset_on_search_field() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getResetButton());
			webElementClick(pages.getPageClinician().getResetButton());
			waitUntilWebElementVisible(pages.getPageClinician().getSearchButton());
		} catch (Exception exception) {
			throw new Exception("Unable to reset search field" + "\n" + exception.getMessage());
		}

	}
	//Start: DHP - 104
		@When("^user clicks on create a clinician button$")
		public void user_clicks_on_create_a_clinician_button() throws Throwable {
			   try {
				   webElementClick(pages.getPageClinician().getCreateClinicianButton());
				   waitUntilWebElementVisible(pages.getPageClinician().getClinicianSpecialityDropdown());
				   webElementClick(pages.getPageClinician().getClinicianSpecialityDropdown());
				   	

				} catch (Exception exception) {
					throw new Exception(
							"Clinician speciality dropdown was not displayed." + "\n" + exception.getMessage());
				}
		}
		
		@When("^disabled clinician speciality is not displayed in the speciality dropdown$")
		public void disabled_clinician_speciality_is_not_displayed_in_the_speciality_dropdown() throws Throwable {
			try {
				assertTrue(!isWebElementDisplayed(pages.getPageClinician().getPodiatrist()));
				assertTrue(!isWebElementDisplayed(pages.getPageClinician().getPlantologist()));
				assertTrue(!isWebElementDisplayed(pages.getPageClinician().getZoologist()));
			} catch (AssertionError exception) {
			  throw new AssertionError("Horizontal tabs on settings page is incomplete" + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 104
		
		//Start: DHP - 104
		@Then("^default clinician speciality is displayed in the speciality dropdown$")
		public void default_clinician_speciality_is_displayed_in_the_speciality_dropdown() throws Throwable {
			try {
				assertTrue(isWebElementDisplayed(pages.getPageClinician().getOptionGP()));
				assertTrue(isWebElementDisplayed(pages.getPageClinician().getOptionEP()));
				assertTrue(isWebElementDisplayed(pages.getPageClinician().getPathologist()));
			} catch (AssertionError exception) {
			  throw new AssertionError("Horizontal tabs on settings page is incomplete" + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 104
	// ################################################## Then Steps ##################################################
	@Then("^the following message is displayed: No records found\\.$")
	public void the_following_message_is_displayed_No_records_found() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getNoItemsShowMessage());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getNoRecordFoundMessage()));
			
		} catch (AssertionError exception) {
			throw new AssertionError("A record is found" + "\n" + exception.getMessage());
		}
	}
	@When("^the following message is displayed: Total of Total no\\. of notes displayed of  Total no\\. of notes returned$")
	public void the_following_message_is_displayed_Total_of_Total_no_of_notes_displayed_of_Total_no_of_notes_returned() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getRecordFoundMessage());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getRecordFoundMessage()));
			
		} catch (AssertionError exception) {
			throw new AssertionError("No record/s found" + "\n" + exception.getMessage());
		}
	}

	@Then("^the tab is empty$")
	public void the_tab_is_empty() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getNoItemsShowMessage());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getNoItemsShowMessage()));
			
		} catch (AssertionError exception) {
			throw new AssertionError("Tab is not empty." + "\n" + exception.getMessage());
		}
	}
	@Then("^they see a Search field defaulted with 'Search Notes'$")
	public void they_see_a_Search_field_defaulted_with_Search_Notes() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getInputSearchFieldWithPlaceholder());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getInputSearchFieldWithPlaceholder()));
			
		} catch (AssertionError exception) {
			throw new AssertionError("Cannot find search field." + "\n" + exception.getMessage());
		}
	}
	@Then("^they see a 'Reset' button$")
	public void they_see_a_Reset_button() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAddNewNoteButton());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getResetButton()));
			
		} catch (AssertionError exception) {
			throw new AssertionError("Cannot find reset button." + "\n" + exception.getMessage());
		}
	}
	
	@Then("^they see a 'Search' button$")
	public void they_see_a_Search_button() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAddNewNoteButton());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getSearchButton()));
			
		} catch (AssertionError exception) {
			throw new AssertionError("Cannot find search button." + "\n" + exception.getMessage());
		}
	}

	
	@Then("^they see a Type column between the Clinician and Note Details columns$")
	public void they_see_a_Type_column_between_the_Clinician_and_Note_Details_columns() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAddNewNoteButton());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getTypeColumn()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getNoteDetailsColumn()));
			
		} catch (AssertionError exception) {
			throw new AssertionError("One column is missing, its either type or notes detail column." + "\n" + exception.getMessage());
		}
	}

	@Then("^inside the Assessment Results box, they see assessment results of the most recent assessment completed by that patient$")
	public void inside_the_Assessment_Results_box_they_see_assessment_results_of_the_most_recent_assessment_completed_by_that_patient()
			throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAssesstmentOnAppointmentsTabGraph());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAnxietyGraphRadioBtn()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getDepressionGraphRadioBtn()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getDistressGraphRadioBtn()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAnswersOfNeedsQuestionnaire()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAnswersOfDepressionQuestionnaire()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAnswersOfAnxietyQuestionnaire()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAnswersOfPhysicalActivityQuestionnaire()));
		} catch (AssertionError exception) {
			throw new AssertionError("Assessment results is incomplete." + "\n" + exception.getMessage());
		}
	}

	@Then("^inside the Assessment Results box, they see assessment results without physical activity table of the most recent assessment completed by that patient$")
	public void inside_the_Assessment_Results_box_they_see_assessment_results_without_physical_activity_table_of_the_most_recent_assessment_completed_by_that_patient()
			throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAssesstmentOnAppointmentsTabGraph());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAnxietyGraphRadioBtn()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getDepressionGraphRadioBtn()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getDistressGraphRadioBtn()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAnswersOfNeedsQuestionnaire()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAnswersOfDepressionQuestionnaire()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAnswersOfAnxietyQuestionnaire()));
			assertTrue(!isWebElementDisplayed(pages.getPageClinician().getAnswersOfPhysicalActivityQuestionnaire()));
		} catch (AssertionError exception) {
			throw new AssertionError("Assessment results is incomplete." + "\n" + exception.getMessage());
		}
	}

	@Then("^the following menu is displayed$")
	public void the_following_menu_is_displayed() throws Throwable {
		try {
			// checks links in the menu
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getClinicianMenuLink()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getClinicianResourcesLink()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getClinicianLogoutLink()));
		} catch (AssertionError exception) {
			throw new AssertionError("Menu is not displayed." + "\n" + exception.getMessage());
		}

	}

	@Then("^the clinician see the following four tabs under the patient's profile$")
	public void the_clinician_see_the_following_four_tabs_under_the_patient_s_profile() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getPatientNameLabel());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getDefaultTab()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getBasicInfoTab()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getMedicalInfoTab()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getPSATab()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAppointmentsTab()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getNotesTab()));

		} catch (AssertionError exception) {
			throw new AssertionError("Tabs under the patient's profile is incomplete." + "\n" + exception.getMessage());
		}
	}

	@Then("^the assesstment table on appointments tab is hidden$")
	public void the_assesstment_table_on_appointments_tab_is_hidden() throws Throwable {
		try {
			assertFalse(isWebElementDisplayed(pages.getPageClinician().getAssesstmentOnAppointmentsTabGraph()));

		} catch (AssertionError exception) {
			throw new AssertionError("Assesstment table on appointments tab is not hidden." + "\n" + exception.getMessage());
		}
	}

	@Then("^the clinician see the following three tabs under the patient's profile$")
	public void the_clinician_see_the_following_three_tabs_under_the_patient_s_profile() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getPatientNameLabel());
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getDefaultTab()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getBasicInfoTab()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getMedicalInfoTab()));
			assertFalse(isWebElementDisplayed(pages.getPageClinician().getPSATab()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getAppointmentsTab()));
			assertTrue(isWebElementDisplayed(pages.getPageClinician().getNotesTab()));

		} catch (AssertionError exception) {
			throw new AssertionError("Tabs under the patient's profile is incomplete." + "\n" + exception.getMessage());
		}
	}

	@Then("^sees the screen elements displayed$")
	public void sees_the_screen_elements_displayed() throws Throwable {
		try {
			Assert.assertTrue(isWebElementDisplayed(pages.getPageClinician().getPlaceHolderSelectClinician()));
			Assert.assertTrue(isWebElementDisplayed(pages.getPageClinician().getResetButton()));
			Assert.assertTrue(isWebElementDisplayed(pages.getPageClinician().getSearchButton()));
		} catch (AssertionError exception) {
			throw new Exception("Screen Element are not displayed" + "\n" + exception.getMessage());
		}

	}

	@Then("^check results of records found$")
	public void check_results_of_records_found() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAlertRecordFound());
			Assert.assertTrue(isWebElementDisplayed(pages.getPageClinician().getAlertRecordFound()));
			Assert.assertTrue(isWebElementDisplayed(pages.getPageClinician().getLabelRecordFound()));
		} catch (AssertionError exception) {
			throw new Exception("No records to shown" + "\n" + exception.getMessage());
		}

	}

	@Then("^checks result of no records found$")
	public void checks_result_of_no_records_found() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getAlertNoRecordFound());
			Assert.assertTrue(isWebElementDisplayed(pages.getPageClinician().getAlertNoRecordFound()));
			Assert.assertTrue(isWebElementDisplayed(pages.getPageClinician().getLabelNoRecordFound()));
		} catch (AssertionError exception) {
			throw new Exception("Unable to show records" + "\n" + exception.getMessage());
		}

	}

	@When("^user inputs a clinician to the search field$")
	public void user_inputs_a_clinician_to_the_search_field() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getInputSearchField());
			webElementSendKeys(pages.getPageClinician().getInputSearchField(), "User");
			webElementClick(pages.getPageClinician().getSearchButton());
			waitUntilWebElementVisible(pages.getPageClinician().getSearchButton());
		} catch (Exception exception) {
			throw new Exception("No Clinicians is displayed" + "\n" + exception.getMessage());
		}

	}

	@When("^clicks on PSA tab$")
	public void clicks_on_PSA_tab() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getPatientNameLabel());
			webElementClick(pages.getPageClinician().getPSATab());
		} catch (Exception exception) {
			throw new Exception("Unable to locate PSA tab." + "\n" + exception.getMessage());
		}
	}
	
	@When("^clicks on Enter a PSA level button$")
	public void clicks_on_Enter_a_PSA_level_button() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageClinician().getEnterPSALevelButton());
			webElementClick(pages.getPageClinician().getEnterPSALevelButton());
		} catch (Exception exception) {
			throw new Exception("Unable to click Enter a PSA level." + "\n" + exception.getMessage());
		}
	}
	
	@When("^type in the value in Health Indicator result then save$")
	public void type_in_the_value_in_Health_Indicator_result_then_save() throws Throwable {
		try {
			webElementSendKeys(pages.getPageClinician().getPSAResult(), "123");
			webElementSendKeys(pages.getPageClinician().getPSAResultComment(), "No Comment");
			webElementClick(pages.getPageClinician().getPSAResultSave());
			waitUntilWebElementVisible(pages.getPageClinician().getEnterPSALevelButton());
			
		} catch (Exception exception) {
			throw new Exception("Unable to input PSA level results." + "\n" + exception.getMessage());
		}
	}

}