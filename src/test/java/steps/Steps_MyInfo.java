package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Base;
import pages.Pages;

public class Steps_MyInfo extends Base {
	Pages pages = new Pages();
	Steps steps = new Steps();

	// ################################################## Given Steps
	// ##################################################
	@Given("^the Patient is updating their profile$")
	public void the_Patient_is_updating_their_profile() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			Assert.assertTrue(getCurrentUrl().contains(properties.getProperty("url")));
			webElementClick(pages.getPageHome().getLogInButton());
			Thread.sleep(5000);
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("PatientEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("PatientPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
			waitUntilWebElementVisible(pages.getPageMyInfo().getProfileNamelabel());
			webElementClick(pages.getPageMyInfo().getProfileNamelabel());
			waitUntilWebElementVisible(pages.getPageMyInfo().getProfileNamelink());
			webElementClick(pages.getPageMyInfo().getProfileNamelink());
			waitUntilWebElementVisible(pages.getPageMyInfo().getBasicInformationlabel());
		} catch (AssertionError exception) {
			throw new AssertionError("Cannot proceed to patient profile page." + "\n" + exception.getMessage());
		}
	}

	@Given("^the user is on patient landing page$")
	public void the_user_is_on_patient_landing_page() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			Assert.assertTrue(getCurrentUrl().contains(properties.getProperty("url")));
			webElementClick(pages.getPageHome().getLogInButton());
			Thread.sleep(5000);
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("PatientEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("PatientPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());

		} catch (AssertionError exception) {
			throw new AssertionError("Cannot proceed to patient landing page." + "\n" + exception.getMessage());
		}
	}

	@Given("^a patient is on the appointments page$")
	public void a_patient_is_on_the_appointments_page() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			Assert.assertTrue(getCurrentUrl().contains(properties.getProperty("url")));
			webElementClick(pages.getPageHome().getLogInButton());
			Thread.sleep(5000);
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("PatientEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("PatientPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
			webElementClick(pages.getPageMyInfo().getAppointmentsMenubar());

		} catch (AssertionError exception) {
			throw new AssertionError("Cannot proceed to appointments page." + "\n" + exception.getMessage());

		}
	}

	@Given("^the user is on wellness check tab on my info page$")
	public void the_user_is_on_wellness_check_tab_on_my_info_page() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			Assert.assertTrue(getCurrentUrl().contains(properties.getProperty("url")));
			webElementClick(pages.getPageHome().getLogInButton());
			Thread.sleep(5000);
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("PatientEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("PatientPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
			webElementClick(pages.getPageMyInfo().getWellnessCheckTab());
			Thread.sleep(1000);
		} catch (AssertionError exception) {
			throw new AssertionError("Unable to proceed on wellness check tab." + "\n" + exception.getMessage());
		}

	}

	@Given("^the clinician is on patients profile page$")
	public void the_clinician_is_on_patients_profile_page() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			Assert.assertTrue(getCurrentUrl().contains(properties.getProperty("url")));
			webElementClick(pages.getPageHome().getLogInButton());
			Thread.sleep(5000);
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(),
					properties.getProperty("clinicia@doctor.com"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("PatientPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
			webElementClick(pages.getPageMyInfo().getDoctorPatientTab());
			Thread.sleep(1000);
		} catch (AssertionError exception) {
			throw new AssertionError("Unable to proceed on patients profile." + "\n" + exception.getMessage());
		}

	}

	@Given("^user is on timeline tab on my info page$")
	public void user_is_on_timeline_tab_on_my_info_page() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			Assert.assertTrue(getCurrentUrl().contains(properties.getProperty("url")));
			webElementClick(pages.getPageHome().getLogInButton());
			Thread.sleep(5000);
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("PatientEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("PatientPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
			webElementClick(pages.getPageMyInfo().getTimelineTab());
			Thread.sleep(1000);
		} catch (AssertionError exception) {
			throw new AssertionError("Unable to proceed on timeline tab." + "\n" + exception.getMessage());
		}
	}

	@Given("^that user logins with \"([^\"]*)\"$")
	public void that_user_logins_with(String arg1) throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			Assert.assertTrue(getCurrentUrl().contains(properties.getProperty("url")));
			webElementClick(pages.getPageHome().getLogInButton());
			waitUntilWebElementVisible(pages.getPageLogin().getButtonRegister());

			if (arg1.equals("Config Manager")) {
				webElementSendKeys(pages.getPageLogin().getInputEmailAddress(),
						properties.getProperty("ConfigManagerEmail"));
				webElementSendKeys(pages.getPageLogin().getInputUserPassword(),
						properties.getProperty("ConfigManagerPassword"));
				webElementClick(pages.getPageLogin().getButtonLogin());
			} else if (arg1.equals("Clinician Manager")) {
				webElementSendKeys(pages.getPageLogin().getInputEmailAddress(),
						properties.getProperty("ClinicianManagerEmail"));
				webElementSendKeys(pages.getPageLogin().getInputUserPassword(),
						properties.getProperty("ClinicianManagerPassword"));
				webElementClick(pages.getPageLogin().getButtonLogin());
			}

			else if (arg1.equals("Doctor")) {
				webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("DoctorEmail"));
				webElementSendKeys(pages.getPageLogin().getInputUserPassword(),
						properties.getProperty("DoctorPassword"));
				webElementClick(pages.getPageLogin().getButtonLogin());
			} else if (arg1.equals("Patient")) {
				webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("PatientEmail"));
				webElementSendKeys(pages.getPageLogin().getInputUserPassword(),
						properties.getProperty("PatientPassword"));
				webElementClick(pages.getPageLogin().getButtonLogin());
			}

		} catch (AssertionError exception) {
			throw new AssertionError("Incorrect user details" + "\n" + exception.getMessage());
		}
	}

	@Given("^the user has logged in with deactivated user$")
	public void the_user_has_logged_in_with_deactivated_user() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			getCurrentUrl().contains(properties.getProperty("url"));
			webElementClick(pages.getPageHome().getLogInButton());

			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("ClinicianMgr"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("ClinicianMgrPass"));
			webElementClick(pages.getPageLogin().getButtonLogin());

			webElementClear(pages.getPageLogin().getInputEmailAddress());
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("PatientEmail"));
			webElementClear(pages.getPageLogin().getInputUserPassword());
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("PatientPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
		} catch (AssertionError exception) {
			throw new AssertionError("Error into redirect to settings page" + "\n" + exception.getMessage());
		}
	}

	@Given("^graph legend for question number one on wellness check is successfully updated$")
	public void graph_legend_for_question_number_one_on_wellness_check_is_successfully_updated() throws Throwable {
		try {
			assertFalse(isXPathNotExisting("//div[text()='Edited graph legend one']"));
		} catch (AssertionError exception) {
			throw new AssertionError("Question 1 is not updated." + "\n" + exception.getMessage());
		}
	}

	// ################################################## When Steps
	// ###################################################
	@When("^they click on the Save button$")
	public void they_click_on_the_Save_button() throws Throwable {
		try {
			scrollToBottom();
			webElementClick(pages.getPageMyInfo().getSaveButton());

		} catch (Exception exception) {
			throw new Exception("Unable to click save button." + "\n" + exception.getMessage());
		}
	}

	@When("^they click on the Next button$")
	public void they_click_on_the_Next_button() throws Throwable {
		try {
			scrollToBottom();
			webElementClick(pages.getPageMyInfo().getNextButton());

		} catch (Exception exception) {
			throw new Exception("Unable to click next button." + "\n" + exception.getMessage());
		}
	}

	@When("^they enter their Medicare number is not ten characters$")
	public void they_enter_their_Medicare_number_is_not_ten_characters() throws Throwable {
		try {
			webElementClear(pages.getPageMyInfo().getMedicareNumberField());
			webElementSendKeys(pages.getPageMyInfo().getMedicareNumberField(), "123");
		} catch (Exception exception) {
			throw new Exception("Unable input medicare number." + "\n" + exception.getMessage());
		}
	}

	@When("^they click on the Assessment in the left menu bar$")
	public void they_click_on_the_Assessment_in_the_left_menu_bar() throws Throwable {

		try {
			webElementClick(pages.getPageMyInfo().getAssessmentMenubar());
			Thread.sleep(1000);
		} catch (Exception exception) {
			throw new Exception("Unable to click assessment menu bar." + "\n" + exception.getMessage());
		}
	}

	@When("^click on the Start Assessment button on the right top corner of the page$")
	public void click_on_the_Start_Assessment_button_on_the_right_top_corner_of_the_page() throws Throwable {

		try {
			webElementClick(pages.getPageMyInfo().getStartAssessmentTOPButton());
			Thread.sleep(1000);
		} catch (Exception exception) {
			throw new Exception("Unable to click start assessment button." + "\n" + exception.getMessage());
		}
	}

	@When("^user clicks on add info button on my info page$")
	public void user_clicks_on_add_info_button_on_my_info_page() throws Throwable {
		try {
			webElementClick(pages.getPageMyInfo().getButtonAddInfo());
			Thread.sleep(1000);
		} catch (Exception exception) {
			throw new Exception("Unable to click add info button." + "\n" + exception.getMessage());
		}
	}

	@When("^the user clicks on request appointment button$")
	public void the_user_clicks_on_request_appointment_button() throws Throwable {
		try {
			webElementClick(pages.getPageMyInfo().getRequestAppointmentButton());
			Thread.sleep(1000);
		} catch (Exception exception) {
			throw new Exception("Unable to click request appointment button." + "\n" + exception.getMessage());
		}
	}

	@When("^user clicks on start wellness check button$")
	public void user_clicks_on_start_wellness_check_button() throws Throwable {
		try {
			webElementClick(pages.getPageMyInfo().getStartWellnessCheckbutton());
			Thread.sleep(1000);
		} catch (Exception exception) {
			throw new Exception("Unable to proceed on patient landing page." + "\n" + exception.getMessage());
		}
	}

	// ################################################## Then Steps
	// ###################################################
	@Then("^no progress bar is displayed$")
	public void no_progress_bar_is_displayed() throws Throwable {
		try {
			assertEquals("Health Assessment", getPageTitle());
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getFirstPageNeeds()));
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getSecondPageDepression()));
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getThirdPageAnxiety()));
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getFourthPagePhysicalActivity()));
		} catch (AssertionError exception) {
			throw new AssertionError("Unable to locate anxiety progress bar." + "\n" + exception.getMessage());
		}
	}
	
	@Then("^they are taken to the Assessment questionnaire page with the anxiety progress bar$")
	public void they_are_taken_to_the_Assessment_questionnaire_page_with_the_anxiety_progress_bar() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageMyInfo().getProgressBar1());
			assertEquals("Health Assessment", getPageTitle());
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getAnxietyProgressBar()));
		} catch (AssertionError exception) {
			throw new AssertionError("Unable to locate anxiety progress bar." + "\n" + exception.getMessage());
		}
	}

	@Then("^they are taken to the Assessment questionnaire page with the anxiety progress bar hidden$")
	public void they_are_taken_to_the_Assessment_questionnaire_page_with_the_anxiety_progress_bar_hidden()
			throws Throwable {
		try {
			// waitUntilWebElementVisible(pages.getPageMyInfo().getProgressBar1());
			assertEquals("Health Assessment", getPageTitle());
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getAnxietyProgressBar()));
		} catch (AssertionError exception) {
			throw new AssertionError("Anxiety progress bar is not hidden." + "\n" + exception.getMessage());
		}
	}

	@Then("^inside the Assessment Results box, they see assessment results for anxiety and physical activity$")
	public void inside_the_Assessment_Results_box_they_see_assessment_results_for_anxiety_and_physical_activity()
			throws Throwable {

		try {
			waitUntilWebElementVisible(pages.getPageMyInfo().getAssessmentResultsLabel());
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getAnxietyCheckbox())); // GRAPH
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getAnxietyResultsLabel()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getPhysicalActivityResultsLabel()));
		} catch (AssertionError exception) {
			throw new AssertionError("Unable to locate some of the assessment result." + "\n" + exception.getMessage());
		}

	}

	@Then("^they are taken to the Assessment questionnaire with the following sections Needs \\(First page\\), Depression \\(Second page\\),Anxiety \\(Third page\\), Physical Activity \\(Fourth page\\)$")
	public void they_are_taken_to_the_Assessment_questionnaire_with_the_following_sections_Needs_First_page_Depression_Second_page_Anxiety_Third_page_Physical_Activity_Fourth_page()
			throws Throwable {
		try {
			assertEquals("Health Assessment", getPageTitle());
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getFirstPageNeeds()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getSecondPageDepression()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getThirdPageAnxiety()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getFourthPagePhysicalActivity()));
		} catch (AssertionError exception) {
			throw new AssertionError("Some assessment questions is missing." + "\n" + exception.getMessage());
		}

	}

	@Then("^they are taken to the Assessment page only display is Physical Activity$")
	public void they_are_taken_to_the_Assessment_page_only_display_is_Physical_Activity() throws Throwable {
		try {
			assertEquals("Health Assessment", getPageTitle());
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getFirstPageNeeds()));
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getSecondPageDepression()));
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getThirdPageAnxiety()));
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getFourthPagePhysicalActivity()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getPhysicalActivityQuestionsLabel()));
		} catch (AssertionError exception) {
			throw new AssertionError("Some questionaires is still displayed." + "\n" + exception.getMessage());
		}
	}

	@Then("^Physical Activity questionaire is hidden$")
	public void physical_Activity_questionaire_is_hidden() throws Throwable {
		try {
			assertEquals("Health Assessment", getPageTitle());
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getFourthPagePhysicalActivity()));
		} catch (AssertionError exception) {
			throw new AssertionError("Physical activity questionaire is not hidden." + "\n" + exception.getMessage());
		}
		;
	}

	@Then("^the following message is displayed inline: \"([^\"]*)\"$")
	public void the_following_message_is_displayed_inline(String arg1) throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageMyInfo().getMedicardNumberError());
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getMedicardNumberError()));

		} catch (AssertionError exception) {
			throw new AssertionError("Assessment question is not equal to 3." + "\n" + exception.getMessage());
		}
	}

	@Then("^they are taken to the Assessment questionnaire with the following sections Needs \\(First page\\), Depression \\(Second page\\),Anxiety \\(Third page\\)$")
	public void they_are_taken_to_the_Assessment_questionnaire_with_the_following_sections_Needs_First_page_Depression_Second_page_Anxiety_Third_page()
			throws Throwable {
		try {
			assertEquals("Health Assessment", getPageTitle());
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getFirstPageNeeds()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getSecondPageDepression()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getThirdPageAnxiety()));

		} catch (AssertionError exception) {
			throw new AssertionError("Assessment question is not equal to 3." + "\n" + exception.getMessage());
		}
	}
	//Start: DHP - 57
		@Then("^default treatment speciality is displayed in the treatment type dropdown$")
		public void default_treatment_speciality_is_displayed_in_the_treatment_type_dropdown() throws Throwable {
			try {
				
				assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getTreatmentOption1()));
				assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getTreatmentOption2()));
				assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getTreatmentOption3()));
				
				
			}
			catch (AssertionError exception) {
				throw new AssertionError("Treatment type option is not displayed." + "\n" + exception.getMessage());
			}
		
		}
		//End: DHP - 57
		
		//Start: DHP - 100
		@Then("^disabled treatment speciality is not displayed in the treatment type dropdown$")
		public void disabled_treatment_speciality_is_not_displayed_in_the_treatment_type_dropdown() throws Throwable {
			try {
				
				assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getTreatmentOption4()));
				assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getTreatmentOption5()));
				assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getTreatmentOption6()));
				
				
			}
			catch (AssertionError exception) {
				throw new AssertionError("Disbaled treatment type option was displayed." + "\n" + exception.getMessage());
			}
		
		}
		//End: DHP - 100
		//Start: DHP - 99
		@Then("^default appointment speciality is displayed in the appointment type dropdown$")
		public void default_appointment_speciality_is_displayed_in_the_appointment_type_dropdown() throws Throwable {
			try {
				
				assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getAppointmentOption1()));
				assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getAppointmentOption2()));
				assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getAppointmentOption3()));
			}
			catch (AssertionError exception) {
				throw new AssertionError("Appointment type option is not displayed." + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 99
		//Start: DHP - 110
		@Then("^enabled PMI speciality was displayed in the speciality dropdown$")
		public void enabled_PMI_speciality_was_displayed_in_the_speciality_dropdown() throws Throwable {
			try {
				
				assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getPMIOption1()));
				assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getPMIOption2()));
				assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getPMIOption3()));
			}
			catch (AssertionError exception) {
				throw new AssertionError("PMI speciality option is not displayed." + "\n" + exception.getMessage());
			}
		}
		
		@Then("^disabled PMI speciality is not displayed in the speciality dropdown$")
		public void disabled_PMI_speciality_is_not_displayed_in_the_speciality_dropdown() throws Throwable {
			try {
				
				assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getPMIOption4()));
				assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getPMIOption5()));
				
			}
			catch (AssertionError exception) {
				throw new AssertionError("PMI speciality option is displayed." + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 110
	@Then("^inside the Assessment Results box, they don't see assessment results for anxiety and physical activity$")
	public void inside_the_Assessment_Results_box_they_don_t_see_assessment_results_for_anxiety_and_physical_activity()
			throws Throwable {
		try {
			// waitUntilWebElementVisible(pages.getPageMyInfo().getAssessmentResultsLabel());
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getAnxietyCheckbox())); // GRAPH
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getAnxietyResultsLabel()));
			assertTrue(!isWebElementDisplayed(pages.getPageMyInfo().getPhysicalActivityResultsLabel()));
		} catch (AssertionError exception) {
			throw new AssertionError(
					"Some of the assessment results is still displayed." + "\n" + exception.getMessage());
		}
	}

	@Then("^they go on to the step of the requesting an appointment, 'Select Reason'$")
	public void they_go_on_to_the_step_of_the_requesting_an_appointment_Select_Reason() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageMyInfo().getButtonReason4());
			scrollToWebElement(pages.getPageMyInfo().getSelectReasonQuestion());
		} catch (Exception exception) {
			throw new Exception("Unable to locate Select Reason section." + "\n" + exception.getMessage());
		}
	}

	@Then("^PSA tab on my info page is not displayed$")
	public void psa_tab_on_my_info_page_is_not_displayed() throws Throwable {
		try {
			assertFalse(isWebElementDisplayed(pages.getPageMyInfo().getPSATabOnMyInfoPage()));
		} catch (AssertionError exception) {
			throw new AssertionError("PSA tab on my info page is still displayed." + "\n" + exception.getMessage());
		}
	}

	@Then("^the link to the assessments in the left menu bar should be hidden$")
	public void the_link_to_the_assessments_in_the_left_menu_bar_should_be_hidden() throws Throwable {
		try {
			assertFalse(isWebElementDisplayed(pages.getPageMyInfo().getAssessmentMenubar()));
		} catch (AssertionError exception) {
			throw new AssertionError("Assessment menu bar on the left is not hidden." + "\n" + exception.getMessage());
		}
	}

	@Then("^they see the following reason to select from:$")
	public void they_see_the_following_reason_to_select_from() throws Throwable {
		try {
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getButtonReason1()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getButtonReason2()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getButtonReason3()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getButtonReason4()));
		} catch (AssertionError exception) {
			throw new AssertionError("Select reasons is incomplete." + "\n" + exception.getMessage());
		}
	}

	@Then("^PSA tab on my info page is displayed$")
	public void psa_tab_on_my_info_page_is_displayed() throws Throwable {
		try {
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getPSATabOnMyInfoPage()));
		} catch (AssertionError exception) {
			throw new AssertionError("PSA tab on my info page is not displayed." + "\n" + exception.getMessage());
		}
	}

	@Then("^complete wellness check questions are displayed$")
	public void complete_wellness_check_questions_are_displayed() throws Throwable {
		try {
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getWellnessCheckQuestion1()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getWellnessCheckQuestion2()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getWellnessCheckQuestion3()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getWellnessCheckQuestion4()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getWellnessCheckQuestion5()));
			webDriver.quit();

		} catch (AssertionError exception) {
			throw new AssertionError("Wellness check questions is incomplete" + "\n" + exception.getMessage());
		}
	}

	@Then("^wellness check question one is not displayed$")
	public void wellness_check_question_one_is_not_displayed() throws Throwable {
		try {
			assertFalse(isWebElementDisplayed(pages.getPageMyInfo().getWellnessCheckQuestion1()));
			webDriver.quit();
		} catch (AssertionError exception) {
			throw new AssertionError("wellness check questions is incomplete" + "\n" + exception.getMessage());
		}
	}

	@Then("^user sees info type dropdown from my info page$")
	public void user_sees_info_type_dropdown_from_my_info_page() throws Throwable {
		try {
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getLabelInfoType()));
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getDropdownInfoType()));
		} catch (AssertionError exception) {
			throw new AssertionError("Unable to locate Info type dropdown." + "\n" + exception.getMessage());
		}
	}

	@Then("^info type dropdown options are complete$")
	public void info_type_dropdown_options_are_complete() throws Throwable {
		try {
			String infoTypes[] = { "Please select", "Appointments", "Decisions", "Journal", "PSA", "To Do", "Treatment",
					"Other" };
			checkWebElementDropdownOptions(pages.getPageMyInfo().getDropdownInfoType(), infoTypes);
		} catch (Exception exception) {
			throw new Exception("Info type dropdown options is incomplete." + "\n" + exception.getMessage());
		}
	}

	@Then("^PSA menu on info type dropdown is hidden$")
	public void psa_menu_on_info_type_dropdown_is_hidden() throws Throwable {
		try {
			String infoTypes[] = { "Please select", "Appointments", "Decisions", "Journal", "To Do", "Treatment",
					"Other" };
			checkWebElementDropdownOptions(pages.getPageMyInfo().getDropdownInfoType(), infoTypes);
		} catch (Exception exception) {
			throw new Exception("PSA menu is not hidden" + "\n" + exception.getMessage());
		}
	}

	@Then("^question number one on wellness check is successfully updated$")
	public void question_number_one_on_wellness_check_is_successfully_updated() throws Throwable {
		try {
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getWellnessCheckQuestion1Updated()));
			webDriver.quit();
		} catch (AssertionError exception) {
			throw new AssertionError("Question 1 is not updated." + "\n" + exception.getMessage());
		}
	}

	@Then("^checks the logo if it is displayed$")
	public void checks_the_logo_if_it_is_displayed() throws Throwable {
		try {
			Assert.assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getImageLogo()));
		} catch (AssertionError exception) {
			throw new AssertionError("Logo is not visible" + "\n" + exception.getMessage());
		}
	}

	@Then("^user clicks on Contact Us$")
	public void user_clicks_on_Contact_Us() throws Throwable {
		try {
			webElementClick(pages.getPageMyInfo().getLinkContactUs());
		} catch (Exception exception) {
			throw new Exception("Link is not accessible" + "\n" + exception.getMessage());
		}
	}

	@Given("^the user is on PSA tab on my info page$")
	public void the_user_is_on_PSA_tab_on_my_info_page() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			Assert.assertTrue(getCurrentUrl().contains(properties.getProperty("url")));
			webElementClick(pages.getPageHome().getLogInButton());
			Thread.sleep(5000);
			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(), properties.getProperty("PatientEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(), properties.getProperty("PatientPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());
			webElementClick(pages.getPageMyInfo().getPSATabOnMyInfoPage());
			waitUntilWebElementVisible(pages.getPageMyInfo().getPSAGraphContainer());

		} catch (AssertionError exception) {
			throw new AssertionError("Unable to proceed on PSA tab." + "\n" + exception.getMessage());
		}

	}

	@Then("^they see the Health Indicator graph$")
	public void they_see_the_Health_Indicator_graph() throws Throwable {
		try {
			assertTrue(isWebElementDisplayed(pages.getPageMyInfo().getPSAGraphContainer()));
		} catch (AssertionError exception) {
			throw new AssertionError("Cannot see health indicator graph." + "\n" + exception.getMessage());
		}
	}

}