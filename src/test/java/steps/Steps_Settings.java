package steps;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Base;
import pages.Pages;

public class Steps_Settings extends Base {
	Pages pages = new Pages();
	Steps steps = new Steps();

	// ################################################## Given Steps
	// ##################################################

	@Given("^the config manager is on the configuration setting page$")
	public void the_config_manager_is_on_the_configuration_setting_page() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			getCurrentUrl().contains(properties.getProperty("url"));
			webElementClick(pages.getPageHome().getLogInButton());

			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(),
					properties.getProperty("ConfigManagerEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(),
					properties.getProperty("ConfigManagerPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());

			webElementClick(pages.pageConfigManagers().getMenubarSettings());
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getButtonUploadImage()));
		} catch (AssertionError exception) {
			throw new AssertionError("Error into redirect to settings page" + "\n" + exception.getMessage());
		}
	}

	@Given("^the assessment toggle option is enabled$")
	public void the_assessment_toggle_option_is_enabled() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getButtonSave()));
			webElementClick(pages.getPageSettings().getToggleAssessment());

			waitUntilWebElementVisible((pages.getPageSettings().getButtonSave()));
			// webElementClick(pages.getPageSettings().getButtonSave());

			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getButtonSave()));

		} catch (AssertionError exception) {
			throw new AssertionError("unable to find assessment toggle" + "\n" + exception.getMessage());
		}
	}

	@Given("^the config manager is viewing the assessment settings$")
	public void the_config_manager_is_viewing_the_assessment_settings() throws Throwable {
		try {
			Base.initialization();
			launchURL(properties.getProperty("url"));
			getCurrentUrl().contains(properties.getProperty("url"));
			webElementClick(pages.getPageHome().getLogInButton());

			webElementSendKeys(pages.getPageLogin().getInputEmailAddress(),
					properties.getProperty("ConfigManagerEmail"));
			webElementSendKeys(pages.getPageLogin().getInputUserPassword(),
					properties.getProperty("ConfigManagerPassword"));
			webElementClick(pages.getPageLogin().getButtonLogin());

			webElementClick(pages.pageConfigManagers().getMenubarSettings());
			scrollToBottom();
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getButtonSave()));
		} catch (AssertionError exception) {
			throw new AssertionError("Unable to show assessment settings page" + "\n" + exception.getMessage());
		}
	}

	// ################################################## When
	// Steps###################################################
	@When("^user clicks on general horizontal tab$")
	public void user_clicks_on_general_horizontal_tab() throws Throwable {
		try {
			webElementClick(pages.getPageSettings().getHorizontaltabGeneral());
			Thread.sleep(5000);
		} catch (Exception exception) {
			throw new Exception("Unable to locate General Horizontal tab." + "\n" + exception.getMessage());
		}
	}

	@When("^user clicks on wellness check horizontal tab$")
	public void user_clicks_on_wellness_check_horizontal_tab() throws Throwable {
		try {
			webElementClick(pages.getPageSettings().getHorizontaltabWellnessCheck());
			Thread.sleep(10000);
		} catch (Exception exception) {
			throw new Exception("Unable to locate Wellness check Horizontal tab." + "\n" + exception.getMessage());
		}
	}

	@When("^user clicks on select all checkbox inside the wellness check horizontal tab$")
	public void user_clicks_on_select_all_checkbox_inside_the_wellness_check_horizontal_tab() throws Throwable {
		try {
			if (isXPathNotExisting("//input[contains(@id,'WellnessCheckSelectAll') and @checked = 'checked']")) {
				webElementClick(pages.getPageSettings().getWellnessCheckSelectAll());
				Thread.sleep(5000);
			} else {
				Thread.sleep(100);
			}
		} catch (Exception exception) {
			throw new Exception(
					"Unable to click select all on Wellness check Horizontal tab." + "\n" + exception.getMessage());
		}
	}

	@When("^user disables question number one on wellness check$")
	public void user_disables_question_number_one_on_wellness_check() throws Throwable {
		try {
			if (isXPathNotExisting(
					"(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[1]//input[@type = 'checkbox' and @checked='checked']")) {
				Thread.sleep(100);
			} else {
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion1());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion1Checkbox());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			}
		} catch (Exception exception) {
			throw new Exception("Unable to disable question number one on wellness check settings page." + "\n"
					+ exception.getMessage());

		}

	}

	@Then("^user enables PSA toggle on info type settings page$")
	public void user_enables_PSA_toggle_on_info_type_settings_page() throws Throwable {
		try {
			if (isXPathNotExisting(
					"//input[@value='PSA']/ancestor::tr//input[@type = 'checkbox' and @checked='checked']")) {
				scrollToWebElement(pages.getPageSettings().getTimelineLabel());
				webElementClick(pages.getPageSettings().getPSAfield());
				waitUntilWebElementVisible(pages.getPageSettings().getWellnessCheckCheckIcon());
				webElementClick(pages.getPageSettings().getPSACheckbox());
				webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			}
		} catch (Exception exception) {
			throw new Exception("Unable to enable PSA." + "\n" + exception.getMessage());

		}
	}

	@Then("^user disables PSA toggle on info type settings page$")
	public void user_disables_PSA_toggle_on_info_type_settings_page() throws Throwable {
		try {
			if (!isXPathNotExisting(
					"//input[@value='PSA']/ancestor::tr//input[@type = 'checkbox' and @checked='checked']")) {
				scrollToWebElement(pages.getPageSettings().getTimelineLabel());
				webElementClick(pages.getPageSettings().getPSAfield());
				waitUntilWebElementVisible(pages.getPageSettings().getWellnessCheckCheckIcon());
				webElementClick(pages.getPageSettings().getPSACheckbox());
				webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			}
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			Thread.sleep(5000);
			webElementClick(pages.getPageSettings().getButtonSave());
			Thread.sleep(5000);
		} catch (Exception exception) {
			throw new Exception("Unable to enable PSA." + "\n" + exception.getMessage());

		}
	}

	@When("^user disables question number two on wellness check$")
	public void user_disables_question_number_two_on_wellness_check() throws Throwable {
		try {
			if (isXPathNotExisting(
					"(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[2]//input[@type = 'checkbox' and @checked='checked']")) {
				Thread.sleep(100);
			} else {
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion2());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion2Checkbox());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			}
		} catch (Exception exception) {
			throw new Exception("Unable to disable question number two on wellness check settings page." + "\n"
					+ exception.getMessage());
		}
	}

	@When("^user disables question number three on wellness check$")
	public void user_disables_question_number_three_on_wellness_check() throws Throwable {
		try {
			if (isXPathNotExisting(
					"(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[3]//input[@type = 'checkbox' and @checked='checked']")) {
				Thread.sleep(100);
			} else {
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion3());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion3Checkbox());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			}
		} catch (Exception exception) {
			throw new Exception("Unable to disable question number three on wellness check settings page." + "\n"
					+ exception.getMessage());
		}
	}

	@When("^user disables question number four on wellness check$")
	public void user_disables_question_number_four_on_wellness_check() throws Throwable {
		try {
			if (isXPathNotExisting(
					"(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[4]//input[@type = 'checkbox' and @checked='checked']")) {
				Thread.sleep(100);
			} else {
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion4());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion4Checkbox());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			}
		} catch (Exception exception) {
			throw new Exception("Unable to disable question number four on wellness check settings page." + "\n"
					+ exception.getMessage());
		}
	}

	@When("^user disables question number five on wellness check$")
	public void user_disables_question_number_five_on_wellness_check() throws Throwable {
		try {
			if (isXPathNotExisting(
					"(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[5]//input[@type = 'checkbox' and @checked='checked']")) {
				Thread.sleep(100);
			} else {
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion5());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckQuestion5Checkbox());
				Thread.sleep(500);
				webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			}
		} catch (Exception exception) {
			throw new Exception("Unable to disable question number five on wellness check settings page." + "\n"
					+ exception.getMessage());
		}
	}

	@When("^user toggles off health indicator option on settings page$")
	public void user_toggles_off_health_indicator_option_on_settings_page() throws Throwable {

		try {
			if (isXPathNotExisting(
					"//input[@value='PSA']/ancestor::tr//input[@type = 'checkbox' and @checked='checked']")) {
				scrollToWebElement(pages.getPageSettings().getTimelineLabel());
				webElementClick(pages.getPageSettings().getPSAfield());
				waitUntilWebElementVisible(pages.getPageSettings().getWellnessCheckCheckIcon());
				webElementClick(pages.getPageSettings().getPSACheckbox());
				webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
				Thread.sleep(5000);
			}
			Thread.sleep(5000);
			scrollToWebElement(pages.getPageSettings().getInfoTable());
			if (isXPathNotExisting("//input[contains(@id,'HealthIndicator') and @checked = 'checked']")) {
				scrollToWebElement(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			} else {
				webElementClick(pages.getPageSettings().getToggleHealthIndicator());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle on health indicator option" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles on health indicator option on settings page$")
	public void user_toggles_on_health_indicator_option_on_settings_page() throws Throwable {

		try {
			if (isXPathNotExisting(
					"//input[@value='PSA']/ancestor::tr//input[@type = 'checkbox' and @checked='checked']")) {
				scrollToWebElement(pages.getPageSettings().getTimelineLabel());
				webElementClick(pages.getPageSettings().getPSAfield());
				waitUntilWebElementVisible(pages.getPageSettings().getWellnessCheckCheckIcon());
				webElementClick(pages.getPageSettings().getPSACheckbox());
				webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			}
			Thread.sleep(5000);
			scrollToWebElement(pages.getPageSettings().getInfoTable());
			if (!isXPathNotExisting("//input[contains(@id,'HealthIndicator') and @checked = 'checked']")) {
				scrollToWebElement(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			} else {
				webElementClick(pages.getPageSettings().getToggleHealthIndicator());
				Thread.sleep(5000);
				scrollToWebElement(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle on health indicator option" + "\n" + exception.getMessage());
		}
	}

	@When("^the user switches assessment option off$")
	public void the_user_switches_assessment_option_off() throws Throwable {
		try {
			scrollToBottom();
			webElementClick(pages.getPageSettings().getDisabledAssessment());
			Thread.sleep(2000);
		} catch (Exception exception) {
			throw new Exception("unable to switch assessment option" + "\n" + exception.getMessage());
		}

	}

	@When("^user clicks on save without making any changes$")
	public void user_clicks_on_save_without_making_any_changes() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible(pages.getPageSettings().getButtonSave());
			webElementClick(pages.getPageSettings().getButtonSave());
		} catch (Exception exception) {
			throw new Exception("Unable to save changes" + "\n" + exception.getMessage());
		}
	}

	@When("^user clicks on confirm unsaved changes$")
	public void user_clicks_on_confirm_unsaved_changes() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible(pages.getPageSettings().getButtonCancel());
			webElementClick(pages.getPageSettings().getButtonCancel());
			waitUntilWebElementVisible(pages.getPageSettings().getMsgUnsaved());
			webElementClick(pages.getPageSettings().getButtonYes());
		} catch (Exception exception) {
			throw new Exception("Changes has been discarded" + "\n" + exception.getMessage());
		}
	}

	@When("^user clicks on cancel on unsaved changes$")
	public void user_clicks_on_cancel_on_unsaved_changes() throws Throwable {
		try {
			webElementClick(pages.getPageSettings().getButtonCancel());
			scrollToBottom();
			waitUntilWebElementVisible(pages.getPageSettings().getMsgUnsaved());
			webElementClick(pages.getPageSettings().getButtonNo());
		} catch (Exception exception) {
			throw new Exception("Changes have been saved" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles a button$")
	public void user_toggles_a_button() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getButtonSave()));

			webElementClick(pages.getPageSettings().getToggleVideo());
		} catch (Exception exception) {
			throw new Exception("Unable to click on video conferencing" + "\n" + exception.getMessage());
		}
	}

	@When("^user clicks an option to toggle$")
	public void user_clicks_an_option_to_toggle() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getOptionVideoConferencing()));

			if (isWebElementDisplayed(pages.getPageSettings().getDisabledVideo())) {
				webElementClick(pages.getPageSettings().getToggleVideo());
				webElementClick(pages.getPageSettings().getButtonSave());
			} else if (isWebElementDisplayed(pages.getPageSettings().getToggleVideo())) {
				webElementClick(pages.getPageSettings().getDisabledVideo());
				webElementClick(pages.getPageSettings().getButtonSave());
			}
		} catch (Exception exception) {
			throw new Exception("No option selected" + "\n" + exception.getMessage());
		}
	}

	@When("^the user switches anxiety option off$")
	public void the_user_switches_anxiety_option_off() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getToggleAnxiety()));
			webElementClick(pages.getPageSettings().getToggleAnxiety());
		} catch (Exception exception) {
			throw new Exception("Unable to disable anxiety option" + "\n" + exception.getMessage());
		}
	}

	@When("^the user switches physical activity option off$")
	public void the_user_switches_physical_activity_option_off() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getButtonSave()));

			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getToggleEnableActivity()));
			webElementClick(pages.getPageSettings().getToggleEnableActivity());
		} catch (Exception exception) {
			throw new Exception("Unable to disable physical activity option" + "\n" + exception.getMessage());
		}
	}

	@When("^user disables the video conferencing option$")
	public void user_disables_the_video_conferencing_option() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getButtonSave()));

			webElementClick(pages.getPageSettings().getToggleVideo());
			webElementClick(pages.getPageSettings().getButtonSave());

			scrollToBottom();

		} catch (Exception exception) {
			throw new Exception("unable to disable video conferencing option" + "\n" + exception.getMessage());
		}

	}

	@When("^user enables the video conferencing option$")
	public void user_enables_the_video_conferencing_option() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getButtonSave()));

			webElementClick(pages.getPageSettings().getToggleVideo());
			webElementClick(pages.getPageSettings().getButtonSave());

			scrollToBottom();

		} catch (Exception exception) {
			throw new Exception("unable to enable video conferencing option" + "\n" + exception.getMessage());
		}

	}

	@When("^user clicks on cancel with no changes$")
	public void user_clicks_on_cancel_with_no_changes() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible(pages.getPageSettings().getButtonCancel());
			webElementClick(pages.getPageSettings().getButtonCancel());
			waitUntilWebElementVisible(pages.getPageSettings().getButtonUploadImage());
		} catch (Exception exception) {
			throw new Exception("Unable to click cancel" + "\n" + exception.getMessage());
		}
	}

	@When("^user disables the clinic visit option$")
	public void user_disables_the_clinic_visit_option() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getButtonSave()));

			webElementClick(pages.getPageSettings().getToggleDisableClinicVisit());
			webElementClick(pages.getPageSettings().getButtonSave());

			scrollToBottom();

		} catch (Exception exception) {
			throw new Exception("unable to disables clinic visit option" + "\n" + exception.getMessage());
		}

	}

	@When("^user enables the clinic visit option$")
	public void user_enables_the_clinic_visit_option() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getButtonSave()));

			webElementClick(pages.getPageSettings().getToggleEnableClinicVisit());
			webElementClick(pages.getPageSettings().getButtonSave());

			scrollToBottom();

		} catch (Exception exception) {
			throw new Exception("unable to enables clinic visit option" + "\n" + exception.getMessage());
		}

	}

	@When("^user toggles on Enable assessment option on settings page$")
	public void user_toggles_on_Enable_assessment_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (!isXPathNotExisting("//input[contains(@id,'Chk_Assessment') and @checked='checked']")) {
				scrollToWebElement(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			} else {

				webElementClick(pages.getPageSettings().getToggleAssessment());
				Thread.sleep(5000);
				scrollToWebElement(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle on assessment option" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles on Enable needs option on settings page$")
	public void user_toggles_on_Enable_needs_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (!isWebElementDisplayed(pages.getPageSettings().getNeedsToggleON())) {
				webElementClick(pages.getPageSettings().getNeedsToggle());
				waitUntilWebElementVisible(pages.getPageSettings().getNeedsToggleON());
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle off anxiety option" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles off Enable needs option on settings page$")
	public void user_toggles_off_Enable_needs_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (isWebElementDisplayed(pages.getPageSettings().getNeedsToggleON())) {
				webElementClick(pages.getPageSettings().getNeedsToggle());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle off anxiety option" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles on Enable anxiety option on settings page$")
	public void user_toggles_on_Enable_anxiety_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (!isWebElementDisplayed(pages.getPageSettings().getAnxietyToggleOn())) {
				webElementClick(pages.getPageSettings().getAnxietyToggle());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle off anxiety option" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles on Enable depression option on settings page$")
	public void user_toggles_on_Enable_depression_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (!isWebElementDisplayed(pages.getPageSettings().getAnxietyToggleOn())) {
				webElementClick(pages.getPageSettings().getDepressionToggle());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle off anxiety option" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles off Enable depression option on settings page$")
	public void user_toggles_off_Enable_depression_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (isWebElementDisplayed(pages.getPageSettings().getAnxietyToggleOn())) {
				webElementClick(pages.getPageSettings().getDepressionToggle());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle off anxiety option" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles off Enable anxiety option on settings page$")
	public void user_toggles_off_Enable_anxiety_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (isWebElementDisplayed(pages.getPageSettings().getAnxietyToggleOn())) {
				webElementClick(pages.getPageSettings().getAnxietyToggle());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle off anxiety option" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles off Enable assessment option on settings page$")
	public void user_toggles_off_Enable_assessment_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (isXPathNotExisting("//input[contains(@id,'Chk_Assessment') and @checked='checked']")) {
				scrollToWebElement(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			} else {
				webElementClick(pages.getPageSettings().getToggleAssessment());
				Thread.sleep(5000);
				scrollToWebElement(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle off assessment option" + "\n" + exception.getMessage());
		}
	}

	@When("^user toggles off Enable physical activity option on settings page$")
	public void user_toggles_off_Enable_physical_activity_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (isWebElementDisplayed(pages.getPageSettings().getPhysicalActivityOn())) {
				webElementClick(pages.getPageSettings().getPhysicalActivityToggle());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle off physical activity option" + "\n" + exception.getMessage());
		}

	}

	@When("^user toggles on Enable physical activity option on settings page$")
	public void user_toggles_on_Enable_physical_activity_option_on_settings_page() throws Throwable {
		try {
			scrollToWebElement(pages.getPageSettings().getButtonSave());
			if (!isWebElementDisplayed(pages.getPageSettings().getPhysicalActivityOn())) {
				webElementClick(pages.getPageSettings().getPhysicalActivityToggle());
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getButtonSave());
				Thread.sleep(5000);
			}
		} catch (Exception exception) {
			throw new Exception("Unable to toggle off physical activity option" + "\n" + exception.getMessage());
		}
	}

	@When("^they disable or enable the needs assessment$")
	public void they_disable_or_enable_the_needs_assessment() throws Throwable {
		try {
			if (isWebElementDisplayed(pages.getPageSettings().getToggleDisableNeeds())) {
				webElementClick(pages.getPageSettings().getToggleDisableNeeds());
				webElementClick(pages.getPageSettings().getButtonSave());

			} else if (isWebElementDisplayed(pages.getPageSettings().getToggleEnabledNeeds())) {
				webElementClick(pages.getPageSettings().getToggleEnabledNeeds());
				webElementClick(pages.getPageSettings().getButtonSave());
			}
		} catch (Exception exception) {
			throw new Exception("unable to click needs assessment" + "\n" + exception.getMessage());
		}

	}

	@When("^they click disable the needs assessment$")
	public void they_click_disable_the_needs_assessment() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageSettings().getButtonSave());
			webElementClick(pages.getPageSettings().getToggleDisableNeeds());
			webElementClick(pages.getPageSettings().getButtonSave());

		} catch (Exception exception) {
			throw new Exception("unable to click needs assessment" + "\n" + exception.getMessage());
		}

	}

	@When("^they click enable the needs assessment$")
	public void they_click_enable_the_needs_assessment() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageSettings().getButtonSave());
			webElementClick(pages.getPageSettings().getToggleEnabledNeeds());
			webElementClick(pages.getPageSettings().getButtonSave());

		} catch (Exception exception) {
			throw new Exception("unable to click needs assessment" + "\n" + exception.getMessage());
		}

	}

	@When("^the user disables assessment option off$")
	public void the_user_disables_assessment_option_off() throws Throwable {
		try {
			scrollToBottom();
			webElementClick(pages.getPageSettings().getDisabledAssessment());
			webElementClick(pages.getPageSettings().getButtonSave());

		} catch (Exception exception) {
			throw new Exception("unable to disable assessment option" + "\n" + exception.getMessage());
		}

	}

	@When("^the user enables assessment option on$")
	public void the_user_enables_assessment_option_on() throws Throwable {
		try {
			scrollToBottom();
			webElementClick(pages.getPageSettings().getToggleAssessment());
			webElementClick(pages.getPageSettings().getButtonSave());

		} catch (Exception exception) {
			throw new Exception("unable to enable assessment option" + "\n" + exception.getMessage());
		}

	}

	@When("^user switches videoconferencing option$")
	public void user_switches_videoconferencing_option() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getButtonSave()));

			webElementClick(pages.getPageSettings().getToggleVideo());
		} catch (Exception exception) {
			throw new Exception("Unable to click on video conferencing" + "\n" + exception.getMessage());
		}
	}

	
	//Start : DHP - 51
		
		
		//Start: DHP - 57
	
		
		//End: DHP - 57
		
		//Start: DHP - 99
		@When("^user enable default speciality appointment for patient$")
		public void user_enable_default_speciality_appointment_for_patient() throws Throwable {
			try {
				scrollToWebElement(pages.getPageSettings().getAddPatientMedInfoSpeciality());
				if (isWebElementDisplayed(pages.getPageSettings().getAppointmentSpecialitySelectAllCheckbox())) {

					scrollToWebElement(pages.getPageSettings().getAddPatientMedInfoSpeciality());

					// click select all checkbox
					webElementClick(pages.getPageSettings().getSelectAllSpecialityAppointment());
					assertTrue(isWebElementDisplayed(pages.getPageSettings().getAppointmentSpecialityDeselectAllCheckbox()));
					Thread.sleep(2000);
					// check and select checkbox1
					webElementClick(pages.getPageSettings().getSpecialityAppointment1());
					webElementClick(pages.getPageSettings().getSpecialityAppointmentCheckbox1());
					webElementClick(pages.getPageSettings().getSaveAddAppointmentSpeciality());
					Thread.sleep(2000);
					// check and select checkbox2
					webElementClick(pages.getPageSettings().getSpecialityAppointment2());
					webElementClick(pages.getPageSettings().getSpecialityAppointmentCheckbox2());
					webElementClick(pages.getPageSettings().getSaveAddAppointmentSpeciality());
					Thread.sleep(2000);
					// check and select checkbox3
					webElementClick(pages.getPageSettings().getSpecialityAppointment3());
					webElementClick(pages.getPageSettings().getSpecialityAppointmentCheckbox3());
					webElementClick(pages.getPageSettings().getSaveAddAppointmentSpeciality());
					Thread.sleep(2000);
				}
				else if(isWebElementDisplayed(pages.getPageSettings().getAppointmentSpecialityDeselectAllCheckbox()))
				{
					webElementClick(pages.getPageSettings().getSelectAllSpecialityAppointment());
					//assertTrue(isWebElementDisplayed(pages.getPageSettings().getTreatmentSpecialitySelectAllCheckbox()));
					Thread.sleep(2000);
					webElementClick(pages.getPageSettings().getSelectAllSpecialityAppointment());
					//assertTrue(isWebElementDisplayed(pages.getPageSettings().getTreatmentSpecialityDeselectAllCheckbox()));
					Thread.sleep(2000);

					// check and select checkbox1
					webElementClick(pages.getPageSettings().getSpecialityAppointment1());
					webElementClick(pages.getPageSettings().getSpecialityAppointmentCheckbox1());
					webElementClick(pages.getPageSettings().getSaveAddAppointmentSpeciality());
					Thread.sleep(2000);
					// check and select checkbox2
					webElementClick(pages.getPageSettings().getSpecialityAppointment2());
					webElementClick(pages.getPageSettings().getSpecialityAppointmentCheckbox2());
					webElementClick(pages.getPageSettings().getSaveAddAppointmentSpeciality());
					Thread.sleep(2000);
					// check and select checkbox3
					webElementClick(pages.getPageSettings().getSpecialityAppointment3());
					webElementClick(pages.getPageSettings().getSpecialityAppointmentCheckbox3());
					webElementClick(pages.getPageSettings().getSaveAddAppointmentSpeciality());
					Thread.sleep(2000);
				}
			}
			catch (Exception exception) {
				throw new Exception("Unable to enable speciality for appointment." + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 99
		
		//Start: DHP - 104
		@When("^user enable default speciality clinician for clinician manager$")
		public void user_enable_default_speciality_clinician_for_clinician_manager() throws Throwable {
			try {

				if (isWebElementDisplayed(pages.getPageSettings().getClinicianSpecialitySelectAllCheckbox())) {

					// click select all checkbox
					webElementClick(pages.getPageSettings().getSelectAllSpecialityClinician());
					assertTrue(isWebElementDisplayed(pages.getPageSettings().getClinicianSpecialityDeselectAllCheckbox()));
					Thread.sleep(2000);
					// check and select checkbox1
					webElementClick(pages.getPageSettings().getSpecialityClinician1());
					webElementClick(pages.getPageSettings().getSpecialityClinicianCheckbox1());
					webElementClick(pages.getPageSettings().getSaveAddClinicianSpeciality());
					Thread.sleep(2000);
					// check and select checkbox2
					webElementClick(pages.getPageSettings().getSpecialityClinician2());
					webElementClick(pages.getPageSettings().getSpecialityClinicianCheckbox2());
					webElementClick(pages.getPageSettings().getSaveAddClinicianSpeciality());
					Thread.sleep(2000);
					// check and select checkbox3
					webElementClick(pages.getPageSettings().getSpecialityClinician3());
					webElementClick(pages.getPageSettings().getSpecialityClinicianCheckbox3());
					webElementClick(pages.getPageSettings().getSaveAddClinicianSpeciality());
					Thread.sleep(2000);
				}
				else if(isWebElementDisplayed(pages.getPageSettings().getClinicianSpecialityDeselectAllCheckbox()))
				{
					webElementClick(pages.getPageSettings().getSelectAllSpecialityClinician());
					//assertTrue(isWebElementDisplayed(pages.getPageSettings().getClinicianSpecialitySelectAllCheckbox()));
					Thread.sleep(2000);
					webElementClick(pages.getPageSettings().getSelectAllSpecialityClinician());
					//assertTrue(isWebElementDisplayed(pages.getPageSettings().getClinicianSpecialityDeselectAllCheckbox()));
					Thread.sleep(2000);

					// check and select checkbox1
					webElementClick(pages.getPageSettings().getSpecialityClinician1());
					webElementClick(pages.getPageSettings().getSpecialityClinicianCheckbox1());
					webElementClick(pages.getPageSettings().getSaveAddClinicianSpeciality());
					Thread.sleep(2000);
					// check and select checkbox2
					webElementClick(pages.getPageSettings().getSpecialityClinician2());
					webElementClick(pages.getPageSettings().getSpecialityClinicianCheckbox2());
					webElementClick(pages.getPageSettings().getSaveAddClinicianSpeciality());
					Thread.sleep(2000);
					// check and select checkbox3
					webElementClick(pages.getPageSettings().getSpecialityClinician3());
					webElementClick(pages.getPageSettings().getSpecialityClinicianCheckbox3());
					webElementClick(pages.getPageSettings().getSaveAddClinicianSpeciality());
					Thread.sleep(2000);

				}
			}
			catch (Exception exception) {
				throw new Exception("Unable to enable speciality for Clinician." + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 104
		
		//Start: DHP - 110
		@When("^user enable default speciality - patient medical info$")
		public void user_enable_default_speciality_patient_medical_info() throws Throwable {
				try {
					scrollToWebElement(pages.getPageSettings().getAddClinicianSpeciality());
					if (isWebElementDisplayed(pages.getPageSettings().getPMISpecialitySelectAllCheckbox())) {

						scrollToWebElement(pages.getPageSettings().getAddClinicianSpeciality());

						// click select all checkbox
						webElementClick(pages.getPageSettings().getSelectAllSpecialityPMI());
						assertTrue(isWebElementDisplayed(pages.getPageSettings().getPMISpecialityDeselectAllCheckbox()));
						Thread.sleep(2000);
						// check and select checkbox1
						webElementClick(pages.getPageSettings().getSpecialityPMI1());
						webElementClick(pages.getPageSettings().getSpecialityPMICheckbox1());
						webElementClick(pages.getPageSettings().getSaveAddPMISpeciality());
						Thread.sleep(2000);
						// check and select checkbox2
						webElementClick(pages.getPageSettings().getSpecialityPMI2());
						webElementClick(pages.getPageSettings().getSpecialityPMICheckbox2());
						webElementClick(pages.getPageSettings().getSaveAddPMISpeciality());
						Thread.sleep(2000);
						// check and select checkbox3
						webElementClick(pages.getPageSettings().getSpecialityPMI3());
						webElementClick(pages.getPageSettings().getSpecialityPMICheckbox3());
						webElementClick(pages.getPageSettings().getSaveAddPMISpeciality());
						Thread.sleep(2000);
					}
					else if(isWebElementDisplayed(pages.getPageSettings().getPMISpecialityDeselectAllCheckbox()))
					{
						webElementClick(pages.getPageSettings().getSelectAllSpecialityPMI());
						//assertTrue(isWebElementDisplayed(pages.getPageSettings().getPMISpecialitySelectAllCheckbox()));
						Thread.sleep(2000);
						webElementClick(pages.getPageSettings().getSelectAllSpecialityPMI());
						//assertTrue(isWebElementDisplayed(pages.getPageSettings().getPMISpecialityDeselectAllCheckbox()));
						Thread.sleep(2000);

						// check and select checkbox1
						webElementClick(pages.getPageSettings().getSpecialityPMI1());
						webElementClick(pages.getPageSettings().getSpecialityPMICheckbox1());
						webElementClick(pages.getPageSettings().getSaveAddPMISpeciality());
						Thread.sleep(2000);
						// check and select checkbox2
						webElementClick(pages.getPageSettings().getSpecialityPMI2());
						webElementClick(pages.getPageSettings().getSpecialityPMICheckbox2());
						webElementClick(pages.getPageSettings().getSaveAddPMISpeciality());
						Thread.sleep(2000);
						// check and select checkbox3
						webElementClick(pages.getPageSettings().getSpecialityPMI3());
						webElementClick(pages.getPageSettings().getSpecialityPMICheckbox3());
						webElementClick(pages.getPageSettings().getSaveAddPMISpeciality());
						Thread.sleep(2000);

					}
				}
				catch (Exception exception) {
					throw new Exception("Unable to enable speciality for PMI." + "\n" + exception.getMessage());
				}
			}
		//End: DHP - 110
		
		//Start: DHP - 57
		@Then("^enabled speciality treatment was displayed for patient$")
		public void enabled_speciality_treatment_was_displayed_for_patient() throws Throwable {
			try {

				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityTreatmentCheckbox1()));
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityTreatmentCheckbox2()));
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityTreatmentCheckbox3()));
				
			}
			catch (Exception exception) {
				throw new Exception("Enabled Treatment Speciality was not displayed" + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 57
		
		//Start : DHP - 51
		@Then("^assessment settings was disabled$")
		public void assessment_settings_was_disabled() throws Throwable {
			try {
				scrollToWebElement(pages.getPageSettings().getButtonSave());
				isXPathNotExisting("//input[contains(@id,'Chk_Assessment') and @checked='checked']");
				
			}
			catch (Exception exception) {
				throw new Exception("Unable to toggle off assessment option" + "\n" + exception.getMessage());
			}
		}
		//End : DHP - 51
		
		//Start: DHP - 99
		@Then("^enabled speciality appointment was displayed for patient$")
		public void enabled_speciality_appointment_was_displayed_for_patient() throws Throwable {
			try {

				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityAppointmentCheckbox1()));
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityAppointmentCheckbox2()));
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityAppointmentCheckbox3()));
				
			}
			catch (Exception exception) {
				throw new Exception("Enabled Appointment Speciality was not displayed" + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 99
		
		//Start: DHP - 104
		@Then("^enabled speciality clinician was displayed for clinician manager$")
		public void enabled_speciality_clinician_was_displayed_for_clinician_manager() throws Throwable {
			try {

				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityClinicianCheckbox1()));
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityClinicianCheckbox2()));
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityClinicianCheckbox3()));
				
			}
			catch (Exception exception) {
				throw new Exception("Enabled Clinician Speciality was not displayed" + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 104
		
		//Start: DHP - 110
		@Then("^enabled speciality - patient medical info was displayed for patient$")
		public void enabled_speciality_patient_medical_info_was_displayed_for_patient() throws Throwable {
			try {

				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityPMICheckbox1()));
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityPMICheckbox2()));
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getSpecialityPMICheckbox3()));
				
			}
			catch (Exception exception) {
				throw new Exception("Enabled PMI Speciality was not displayed" + "\n" + exception.getMessage());
			}
		}

		//End: DHP - 110

	// ################################################## Then Steps
	// ###################################################
	@Then("^user checks if horizontal tabs on settings page is complete$")
	public void user_checks_if_horizontal_tabs_on_settings_page_is_complete() throws Throwable {
		try {
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getHorizontaltabGeneral()));
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getHorizontaltabSpecialityList()));
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getHorizontaltabWellnessCheck()));
		} catch (AssertionError exception) {
			throw new AssertionError("Tabs are not displayed properly" + "\n" + exception.getMessage());
		}
	}

	@Then("^user inputs \"([^\"]*)\" as question and \"([^\"]*)\" as graph legend for question number one$")
	public void user_inputs_as_question_and_as_graph_legend_for_question_number_one(String arg1, String arg2)
			throws Throwable {
		try {
			webElementClick(pages.getPageSettings().getWellnessCheckQuestion1());
			Thread.sleep(500);
			webElementClear(pages.getPageSettings().getWellnessCheckQuestion1Textbox());
			webElementSendKeys(pages.getPageSettings().getWellnessCheckQuestion1Textbox(), arg1);
			Thread.sleep(500);
			webElementClear(pages.getPageSettings().getWellnessCheckGraphLegend1Textbox());
			webElementSendKeys(pages.getPageSettings().getWellnessCheckGraphLegend1Textbox(), arg2);
			Thread.sleep(500);
			webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			Thread.sleep(5000);
		} catch (Exception exception) {
			throw new Exception(
					"Unable to edit question one of the wellness check details." + "\n" + exception.getMessage());
		}
	}

	@Then("^user reverts back values \"([^\"]*)\" as question and \"([^\"]*)\" as graph legend for question number one$")
	public void user_reverts_back_values_as_question_and_as_graph_legend_for_question_number_one(String arg1,
			String arg2) throws Throwable {
		try {
			webElementClick(pages.getPageSettings().getRevertWellnessCheckQuestion1Textbox());
			Thread.sleep(500);
			webElementClear(pages.getPageSettings().getRevertWellnessCheckQuestion1Textbox());
			webElementSendKeys(pages.getPageSettings().getRevertWellnessCheckQuestion1Textbox(), arg1);
			Thread.sleep(500);
			webElementClear(pages.getPageSettings().getRevertWellnessCheckGraphLegend1Textbox());
			webElementSendKeys(pages.getPageSettings().getRevertWellnessCheckGraphLegend1Textbox(), arg2);
			Thread.sleep(500);
			webElementClick(pages.getPageSettings().getWellnessCheckCheckIcon());
			Thread.sleep(5000);
		} catch (Exception exception) {
			throw new Exception(
					"Unable to edit question one of the wellness check details." + "\n" + exception.getMessage());
		}
	}

	@Then("^horizontal tabs on settings page is complete$")
	public void horizontal_tabs_on_settings_page_is_complete() throws Throwable {
		try {
			assertTrue(isWebElementDisplayed(pages.getPageSettings().getHorizontaltabGeneral()));
			assertTrue(isWebElementDisplayed(pages.getPageSettings().getHorizontaltabSpecialityList()));
			assertTrue(isWebElementDisplayed(pages.getPageSettings().getHorizontaltabWellnessCheck()));
		} catch (AssertionError exception) {
			throw new AssertionError("Horizontal tabs on settings page is incomplete" + "\n" + exception.getMessage());
		}
	}

	@Then("^user checks if general horizontal tab is set to default$")
	public void user_checks_if_general_horizontal_tab_is_set_to_default() throws Throwable {
		try {
			assertTrue(isWebElementDisplayed(pages.getPageSettings().getHorizontaltabGeneralDefault()));

		} catch (AssertionError exception) {
			throw new AssertionError("General horizontal tabs is not set to default" + "\n" + exception.getMessage());
		}
	}

	@Then("^user sees health indicator option$")
	public void user_sees_health_indicator_option() throws Throwable {
		try {
			assertTrue(isWebElementDisplayed(pages.getPageSettings().getlabel_HealthIndicator()));
			assertTrue(isWebElementDisplayed(pages.getPageSettings().getoptionHealthIndicatorGraph()));
			assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleHealthIndicator()));
		} catch (AssertionError exception) {
			throw new AssertionError("Unable to locate health indicator" + "\n" + exception.getMessage());
		}

	}

	@Then("^sees button video conferencing option status$")
	public void sees_button_video_conferencing_option_status() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getOptionVideoConferencing()));

			if (isWebElementDisplayed(pages.getPageSettings().getToggleVideo())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleVideo()));
			} else if (!isWebElementDisplayed(pages.getPageSettings().getToggleVideo())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleVideo()));
			}

		} catch (Exception exception) {
			throw new Exception("Unable to locate video conferencing option" + "\n" + exception.getMessage());
		}
	}

	@Then("^sees the options under assessments$")
	public void sees_the_options_under_assessments() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getButtonCancel()));

			if (isWebElementDisplayed(pages.getPageSettings().getToggleAssessment())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleAssessment()));
			} else if (isWebElementDisplayed(pages.getPageSettings().getDisabledAssessment())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledAssessment()));
			} else if (isWebElementDisplayed(pages.getPageSettings().getToggleEnabledNeeds())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleEnabledNeeds()));
			} else if (isWebElementDisplayed(pages.getPageSettings().getDisabledNeeds())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledNeeds()));
			} else if (isWebElementDisplayed(pages.getPageSettings().getEnabledDepression())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getEnabledDepression()));
			} else if (isWebElementDisplayed(pages.getPageSettings().getDisabledDepression())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledDepression()));
			}

			else if (isWebElementDisplayed(pages.getPageSettings().getDisabledAnxiety())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledAnxiety()));
			}

			else if (isWebElementDisplayed(pages.getPageSettings().getDisabledPhysicalActivity())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledPhysicalActivity()));
			}

		} catch (Exception exception) {
			throw new Exception("Options are not displayed" + "\n" + exception.getMessage());
		}
	}

	@Then("^sees message that it is saved successfully$")
	public void sees_message_that_it_is_saved_successfully() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageSettings().getMessageSave());
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getMessageSave()));
		} catch (AssertionError exception) {
			throw new Exception("Confirmation messages is not displayed" + "\n" + exception.getMessage());
		}
	}

	@Then("^sees the other assessments disabled$")
	public void sees_the_other_assessments_disabled() throws Throwable {
		try {

			waitUntilWebElementVisible(pages.getPageSettings().getDisabledNeeds());
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledNeeds()));
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledDepression()));
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledAnxiety()));
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledPhysicalActivity()));
		} catch (AssertionError exception) {
			throw new Exception("Other assessment options are not disabled" + "\n" + exception.getMessage());
		}
	}

	@Then("^sees anxiety option is turned off$")
	public void sees_anxiety_option_is_turned_off() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageSettings().getToggleDisableAnxiety());
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleDisableAnxiety()));
		} catch (AssertionError exception) {
			throw new Exception("anxiety option is not turned off" + "\n" + exception.getMessage());
		}
	}

	@Then("^sees physical activity option is turned off$")
	public void sees_physical_activity_option_is_turned_off() throws Throwable {
		try {
			waitUntilWebElementVisible(pages.getPageSettings().getToggleDisablePhysicalActivity());
			Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleDisablePhysicalActivity()));
		} catch (AssertionError exception) {
			throw new Exception("anxiety option is not turned off" + "\n" + exception.getMessage());
		}
	}

	@Then("^sees button clinic visit option status$")
	public void sees_button_clinic_visit_option_status() throws Throwable {
		try {
			scrollToBottom();
			waitUntilWebElementVisible((pages.getPageSettings().getOptionVideoConferencing()));

			if (isWebElementDisplayed(pages.getPageSettings().getToggleVideo())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleVideo()));
			} else if (!isWebElementDisplayed(pages.getPageSettings().getToggleVideo())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleVideo()));
			}

		} catch (Exception exception) {
			throw new Exception("Unable to locate clinic visit option" + "\n" + exception.getMessage());
		}
	}

	@Then("^sees needs assessment option$")
	public void sees_needs_assessment_option() throws Throwable {
		try {

			if (isWebElementDisplayed(pages.getPageSettings().getDisabledAssessment())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getDisabledAssessment()));
			} else if (isWebElementDisplayed(pages.getPageSettings().getToggleEnabledNeeds())) {
				Assert.assertTrue(isWebElementDisplayed(pages.getPageSettings().getToggleEnabledNeeds()));
			}

		} catch (Exception exception) {
			throw new Exception("Unable to locate clinic visit option" + "\n" + exception.getMessage());
		}
	}
	//Start: DHP - 119
		@When("^user enable appointment settings$")
		public void user_enable_appointment_settings() throws Throwable {
			try {
//				scrollToWebElement(pages.getPageSettings().getLabelHealthIndicator());
				scrollToBottom();
				if (isWebElementDisplayed(pages.getPageSettings().getVCToggleOFF())) {
					webElementClick(pages.getPageSettings().getVCToggle());
					
				}
				if (isWebElementDisplayed(pages.getPageSettings().getCVToggleOFF())) {
					webElementClick(pages.getPageSettings().getCVToggle());
					
				}
				webElementClick(pages.getPageSettings().getButtonSave());
				
			}
			catch (Exception exception) {
				throw new Exception("Unable to enable appointments toggle." + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 119
		@When("^user disable assessment in the general settings page$")
		public void user_disable_assessment_in_the_general_settings_page() throws Throwable {
			try {
				scrollToWebElement(pages.getPageSettings().getButtonSave());
				if (isXPathNotExisting("//input[contains(@id,'Chk_Assessment') and @checked='checked']")) {
					scrollToWebElement(pages.getPageSettings().getButtonSave());
					Thread.sleep(5000);
					webElementClick(pages.getPageSettings().getButtonSave());
					Thread.sleep(5000);
				}
				else {
					webElementClick(pages.getPageSettings().getToggleAssessment());
					Thread.sleep(5000);
					scrollToWebElement(pages.getPageSettings().getButtonSave());
					Thread.sleep(5000);
					webElementClick(pages.getPageSettings().getButtonSave());
					Thread.sleep(5000);
				}
			}
			catch (Exception exception) {
				throw new Exception("Unable to toggle off assessment option" + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 51
		@When("^user enable default speciality treatment for patient$")
		public void user_enable_default_speciality_treatment_for_patient() throws Throwable {
			try {
				scrollToWebElement(pages.getPageSettings().getAddAppointmentSpeciality());
				if (isWebElementDisplayed(pages.getPageSettings().getTreatmentSpecialitySelectAllCheckbox())) {

					scrollToWebElement(pages.getPageSettings().getAddAppointmentSpeciality());

					// click select all checkbox
					webElementClick(pages.getPageSettings().getSelectAllSpecialityTreatment());
					assertTrue(isWebElementDisplayed(pages.getPageSettings().getTreatmentSpecialityDeselectAllCheckbox()));
					Thread.sleep(2000);
					// check and select checkbox1
					webElementClick(pages.getPageSettings().getSpecialityTreatment1());
					webElementClick(pages.getPageSettings().getSpecialityTreatmentCheckbox1());
					webElementClick(pages.getPageSettings().getSaveAddTreatmentSpeciality());
					Thread.sleep(2000);
					// check and select checkbox2
					webElementClick(pages.getPageSettings().getSpecialityTreatment2());
					webElementClick(pages.getPageSettings().getSpecialityTreatmentCheckbox2());
					webElementClick(pages.getPageSettings().getSaveAddTreatmentSpeciality());
					Thread.sleep(2000);
					// check and select checkbox3
					webElementClick(pages.getPageSettings().getSpecialityTreatment3());
					webElementClick(pages.getPageSettings().getSpecialityTreatmentCheckbox3());
					webElementClick(pages.getPageSettings().getSaveAddTreatmentSpeciality());
				}
				else if(isWebElementDisplayed(pages.getPageSettings().getTreatmentSpecialityDeselectAllCheckbox()))
				{
					webElementClick(pages.getPageSettings().getSelectAllSpecialityTreatment());
					//assertTrue(isWebElementDisplayed(pages.getPageSettings().getTreatmentSpecialitySelectAllCheckbox()));
					Thread.sleep(2000);
					webElementClick(pages.getPageSettings().getSelectAllSpecialityTreatment());
					//assertTrue(isWebElementDisplayed(pages.getPageSettings().getTreatmentSpecialityDeselectAllCheckbox()));
					Thread.sleep(2000);

					// check and select checkbox1
					webElementClick(pages.getPageSettings().getSpecialityTreatment1());
					webElementClick(pages.getPageSettings().getSpecialityTreatmentCheckbox1());
					webElementClick(pages.getPageSettings().getSaveAddTreatmentSpeciality());
					Thread.sleep(2000);
					// check and select checkbox2
					webElementClick(pages.getPageSettings().getSpecialityTreatment2());
					webElementClick(pages.getPageSettings().getSpecialityTreatmentCheckbox2());
					webElementClick(pages.getPageSettings().getSaveAddTreatmentSpeciality());
					Thread.sleep(2000);
					// check and select checkbox3
					webElementClick(pages.getPageSettings().getSpecialityTreatment3());
					webElementClick(pages.getPageSettings().getSpecialityTreatmentCheckbox3());
					webElementClick(pages.getPageSettings().getSaveAddTreatmentSpeciality());

				}
			}
			catch (Exception exception) {
				throw new Exception("Unable to enable speciality for treatment." + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 57
		
		//Start: DHP - 119
		@Then("^appointment toggle was enabled$")
		public void appointment_toggle_was_enabled() throws Throwable {
			try {
				scrollToBottom();
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getVCToggleON()));
				assertTrue(isWebElementDisplayed(pages.getPageSettings().getCVToggleON()));
				
			}
			catch (Exception exception) {
				throw new Exception("Appointment toggle was not enabled." + "\n" + exception.getMessage());
			}
		}
		//End: DHP - 119



	@When("^enables multilingual setting$")
	public void enables_multilingual_setting() throws Throwable {
		try {
			if (isXPathNotExisting(
					"//input[contains(@id,'Multilingual') and @class='checkbox SmartInput SmartInput_Changed ReadOnly']")) {
				// scrollToWebElement(pages.getPageSettings().getTimelineLabel());
				actionSendKeys(Keys.chord(Keys.PAGE_DOWN));
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getMultilingualCheckbox());
				Thread.sleep(5000);
				waitUntilWebElementVisible(pages.getPageSettings().getDefaultLanguageLabel());

			}

		} catch (Exception exception) {
			throw new Exception("Unable to enable multilingual." + "\n" + exception.getMessage());

		}
	}

	@When("^disables multilingual setting$")
	public void disables_multilingual_setting() throws Throwable {
		try {
			if (isXPathNotExisting("//input[contains(@id,'Multilingual') and @class='checkbox SmartInput ReadOnly']")) {
				// scrollToWebElement(pages.getPageSettings().getTimelineLabel());
				actionSendKeys(Keys.chord(Keys.PAGE_UP));
				Thread.sleep(5000);
				webElementClick(pages.getPageSettings().getMultilingualCheckbox());
				Thread.sleep(5000);
				// waitUntilWebElementVisible(pages.getPageSettings().getDefaultLanguageLabel());

			}

		} catch (Exception exception) {
			throw new Exception("Unable to disable multilingual." + "\n" + exception.getMessage());

		}
	}

	@Then("^user sees default language label and dropdown$")
	public void user_sees_default_language_label_and_dropdown() throws Throwable {
		assertTrue(isWebElementDisplayed(pages.getPageSettings().getDefaultLanguageLabel()));
		assertTrue(isWebElementDisplayed(pages.getPageSettings().getDefaultLanguageDropdown()));

	}


@Then("^default language label and dropdown is hidden$")
public void default_language_label_and_dropdown_is_hidden() throws Throwable {
	waitUntilWebElementInvisible(pages.getPageSettings().getDefaultLanguageLabel());
	waitUntilWebElementInvisible(pages.getPageSettings().getDefaultLanguageDropdown());
}
	}