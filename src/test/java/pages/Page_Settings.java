package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.Base;

public class Page_Settings extends Base {
	public Page_Settings() {
		PageFactory.initElements(webDriver, this);
	}

	// ################################################## Page Objects ##################################################
	@FindBy(xpath = "//div[text()='General']")
	private WebElement horizontaltab_General;
	@FindBy(xpath = "//div[text()='General' and @class ='tabs-header-item active']")
	private WebElement horizontaltab_GeneralDefault;
	@FindBy(xpath = "//div[text()='Speciality List']")
	private WebElement horizontaltab_SpecialityList;
	@FindBy(xpath = "//div[contains(text(),'Wellness Check')]")
	private WebElement horizontaltab_WellnessCheck;
	@FindBy(xpath = "//span[text()='Health Indicator']")
	private WebElement label_HealthIndicator;
	@FindBy(xpath = "//div[text()='Health Indicator Graph']")
	private WebElement option_HealthIndicatorGraph;
	@FindBy(xpath = "(//div[contains(@id,'ToggleButtonWrapper')])[1]")
	private WebElement toggle_HealthIndicator;
	@FindBy(xpath = "//input[contains(@id,'HealthIndicator') and @checked = 'checked']")
	private WebElement toggleON_HealthIndicator;
	@FindBy(xpath = "	//table[contains(@id,'InfoTypeTable')]")
	private WebElement infotable;
	@FindBy(xpath = "//input[contains(@id,'WellnessCheckSelectAll')]")
	private WebElement checkbox_WellnessCheckSelectAll;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[1]")
	private WebElement WellnessCheckQuestion1;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[2]")
	private WebElement WellnessCheckQuestion2;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[3]")
	private WebElement WellnessCheckQuestion3;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[4]")
	private WebElement WellnessCheckQuestion4;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[5]")
	private WebElement WellnessCheckQuestion5;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[1]//input[@type = 'checkbox']")
	private WebElement checkbox_WellnessCheckQuestion1;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[2]//input[@type = 'checkbox']")
	private WebElement checkbox_WellnessCheckQuestion2;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[3]//input[@type = 'checkbox']")
	private WebElement checkbox_WellnessCheckQuestion3;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[4]//input[@type = 'checkbox']")
	private WebElement checkbox_WellnessCheckQuestion4;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[5]//input[@type = 'checkbox']")
	private WebElement checkbox_WellnessCheckQuestion5;
	@FindBy(xpath = "//i[@class='fa fa-check']")
	private WebElement checkbox_WellnessCheck_CheckIcon;
	@FindBy(xpath = "//i[@class='fa fa-times']")
	private WebElement checkbox_WellnessCheck_XIcon;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[1]//input[contains(@id,'WellnessQuestion')]")
	private WebElement textbox_WellnessCheckQuestion1;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)[1]//input[contains(@id,'WellnessGraphLegend')]")
	private WebElement textbox_WellnessCheckGraphLegend1;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)//input[contains(@id,'WellnessQuestion') and @value='Edited question one']")
	private WebElement textbox_RevertWellnessCheckQuestion1;
	@FindBy(xpath = "(//table[contains(@id, 'WellnessCheckTable')]//tbody//tr)//input[contains(@id,'WellnessGraphLegend') and @value='Edited graph legend one']")
	private WebElement textbox_RevertWellnessCheckGraphLegend1;
	@FindBy(xpath = "//input[@value='PSA']/ancestor::tr//input[@type = 'checkbox']")
	private WebElement checkbox_PSA;
	@FindBy(xpath = "//span[text()='Timeline']")
	private WebElement label_Timeline;
	@FindBy(xpath = "//input[@value='PSA']")
	private WebElement field_PSA;

	// Appointment
	@FindBy(xpath = "//span[text()='Appointment']")
	private WebElement label_Appointment;
	// Video Conferencing
	@FindBy(xpath = "//div[text()='Enable Video Conferencing']")
	private WebElement option_VideoConferencing;
	@FindBy(xpath = "(//div[contains(@class,'toggle-button')])[3]")
	private WebElement toggle_VideoConferencing;
	@FindBy(xpath = "(//div[contains(@class,'toggle-button toggle-button-checked')])[3]")
	private WebElement toggle_DisableVideoConferencing;
	// Clinic Visit
	@FindBy(xpath = "//div[text()='Enable Clinic Visit']")
	private WebElement option_ClinicVisit;
	@FindBy(xpath = "//div[text() = 'Enable Clinic Visit']/parent::div//following-sibling::div//div[@class = 'toggle-button']")
	private WebElement toggle_EnableClinicVisit;
	@FindBy(xpath = "//div[text() = 'Enable Clinic Visit']/parent::div//following-sibling::div//div[contains(@class, 'toggle-button toggle-button-checked')]")
	private WebElement toggle_DisableClinicVisit;

	// Assessment
	@FindBy(xpath = "//span[contains(text(),'Assessment')]")
	private WebElement label_Assessment;
	@FindBy(xpath = "//div[text()='Enable Assessment']")
	private WebElement option_Assessment;
	@FindBy(xpath = "//div[text() = 'Enable Assessment']/parent::div//following-sibling::div//div[@class = 'toggle-button']")
	private WebElement toggle_Assessment;
	@FindBy(xpath = "//div[text() = 'Enable Assessment']/parent::div//following-sibling::div//div[contains(@class, 'toggle-button toggle-button-checked')]")
	private WebElement toggle_DisableAssessments;

	// Assessment - Needs
	@FindBy(xpath = "//div[text()='Enable Needs']")
	private WebElement option_Needs;
	@FindBy(xpath = "//div[text() = 'Enable Needs']/parent::div//following-sibling::div//div[@class = 'toggle-button']")
	private WebElement toggle_EnableNeeds;
	@FindBy(xpath = "//div[text() = 'Enable Needs']/parent::div//following-sibling::div//div[contains(@class, 'toggle-button toggle-button-checked')]")
	private WebElement toggle_DisableNeeds;
	@FindBy(xpath = "(//div[contains(@class,'toggle-button toggle-button-disabled')])[1]")
	private WebElement disable_Needs;

	// Assessment - Depression
	@FindBy(xpath = "//div[text()='Enable Depression']")
	private WebElement option_Depression;
	@FindBy(xpath = "(//div[contains(@class,'toggle-button')])[11]")
	private WebElement toggle_EnableDepression;
	@FindBy(xpath = "(//div[contains(@class,'toggle-button toggle-button-disabled')])[2]")
	private WebElement disable_Depression;

	// Assessment - Anxiety
	@FindBy(xpath = "//div[text()='Enable Anxiety']")
	private WebElement option_Anxiety;
	@FindBy(xpath = "//div[text() = 'Enable Anxiety']/parent::div//following-sibling::div//div[contains(@class, 'toggle-button toggle-button-checked')]")
	private WebElement toggle_EnableAnxiety;
	@FindBy(xpath = "//div[text() = 'Enable Anxiety']/parent::div//following-sibling::div//div[@class = 'toggle-button']")
	private WebElement toggle_DisabledAnxiety;
	@FindBy(xpath = "(//div[contains(@class,'toggle-button toggle-button-disabled')])[3]")
	private WebElement disable_Anxiety;

	// Assessment - Physical Activity
	@FindBy(xpath = "//div[text()='Enable Physical Activity']")
	private WebElement option_PhysicalActivity;
	@FindBy(xpath = "//div[text() = 'Enable Physical Activity']/parent::div//following-sibling::div//div[contains(@class, 'toggle-button toggle-button-checked')]")
	private WebElement toggle_EnablePhysicalActivity;
	@FindBy(xpath = "//div[text() = 'Enable Physical Activity']/parent::div//following-sibling::div//div[@class = 'toggle-button']")
	private WebElement toggle_DisablePhysicalActivity;
	@FindBy(xpath = "(//div[contains(@class,'toggle-button toggle-button-disabled')])[4]")
	private WebElement disable_PhysicalActivity;

	/* Welllness Section */
	@FindBy(xpath = "//input[contains(@id,'CheckBox_WellnessCheckSelectAll')]")
	private WebElement checkbox_WellnessSelectAll;

	@FindBy(xpath = "//input[contains(@value,'Save')]")
	private WebElement button_Save;
	@FindBy(xpath = "//input[contains(@value,'Cancel')]")
	private WebElement button_Cancel;

	@FindBy(xpath = "//span[contains(text(),'There are unsaved changes. Do you wish to proceed?')]")
	private WebElement popup_UnsavedChanges;
	@FindBy(xpath = "//input[contains(@value,'Yes')]")
	private WebElement popup_Yes;
	@FindBy(xpath = "(//input[contains(@value,'No')])[3]")
	private WebElement popup_No;

	@FindBy(xpath = "//input[contains(@value,'Upload Image')]")
	private WebElement button_UploadImage;

	@FindBy(xpath = "//span[contains(text(), 'Saved Successfully!')]")
	private WebElement message_Saved;

	@FindBy(xpath = "(//div[contains(@id,'ToggleButtonWrapper')])[5]")
	private WebElement toggle_Needs;
	@FindBy(xpath = "//div[text()='Enable Needs']/parent::div/following-sibling::div//div[@class='toggle-button toggle-button-checked']")
	private WebElement toggle_NeedsON;
	@FindBy(xpath = "(//div[contains(@id,'ToggleButtonWrapper')])[6]")
	private WebElement toggle_Depression;
	@FindBy(xpath = "//div[text()='Enable Depression']/parent::div/following-sibling::div//div[@class='toggle-button toggle-button-checked']")
	private WebElement toggle_DepressionON;
	@FindBy(xpath = "(//div[contains(@id,'ToggleButtonWrapper')])[7]")
	private WebElement toggle_Anxiety;
	@FindBy(xpath = "//div[text()='Enable Anxiety']/parent::div/following-sibling::div//div[@class='toggle-button toggle-button-checked']")
	private WebElement toggle_AnxietyON;
	@FindBy(xpath = "//div[text()='Enable Physical Activity']/parent::div/following-sibling::div//div[@class='toggle-button toggle-button-checked']")
	private WebElement toggle_PhysicalActivityON;
	@FindBy(xpath = "(//div[contains(@id,'ToggleButtonWrapper')])[8]")
	private WebElement toggle_PhysicalActivity;
	@FindBy(xpath = "//input[contains(@id,'OrgMultilingualCheckbox')]")
	private WebElement checkbox_Multilingual;
	@FindBy(xpath = "//input[contains(@id,'Multilingual') and @class='checkbox SmartInput SmartInput_Changed ReadOnly']")
	private WebElement checkbox_MultilingualUnChecked;
	@FindBy(xpath = "//input[contains(@id,'Multilingual') and @class='checkbox SmartInput ReadOnly']")
	private WebElement checkbox_MultilingualChecked;
	@FindBy(xpath = "//div[text()='Language']")
	private WebElement label_DefaultLanguage;
	@FindBy(xpath = "(//div[@class='dropdown-header select'])[3]")
	private WebElement dropdown_DefaultLanguage;
	//Start : DHP - 57 
		@FindBy(xpath = "//div[contains(@id,'CheckBox_TreatmentSelectAll')]//input[@type='checkbox' and @checked='checked']")
		private WebElement checkbox_TreatmentSpecialitySelectAllCheckbox;
		@FindBy(xpath = "//a[contains(@id,'SpecialityAppointmentTable2_AddRow')]")
		private WebElement link_AddAppointmentSpeciality;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_TreatmentSelectAll')]//input[@type='checkbox']")
		private WebElement checkbox_TreatmentSpecialityDeselectAllCheckbox;
		@FindBy(xpath = "//div[contains(@id,'SpecialityTreatment2')]//input[@value='Active Surveillance']")
		private WebElement label_SpecialityTreatment1;
		@FindBy(xpath = "//div[contains(@id,'SpecialityTreatment2')]//input[@value='Brachytherapy']")
		private WebElement label_SpecialityTreatment2;
		@FindBy(xpath = "//div[contains(@id,'SpecialityTreatment2')]//input[@value='Chemotherapy']")
		private WebElement label_SpecialityTreatment3;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityTreatment2')]//input[@value='Active Surveillance']//following::td//input[@userscheckboxid='CheckBox0'])[1]")
		private WebElement checkbox_SpecialityTreatment1;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityTreatment2')]//input[@value='Brachytherapy']//following::td//input[@userscheckboxid='CheckBox1'])[1]")
		private WebElement checkbox_SpecialityTreatment2;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityTreatment2')]//input[@value='Chemotherapy']//following::td//input[@userscheckboxid='CheckBox2'])[1]")
		private WebElement checkbox_SpecialityTreatment3;
		@FindBy(xpath = "//table[contains(@id,'SpecialityTreatmentTable')]//a[@class='SaveRowAction']")
		private WebElement button_SaveAddTreatmentSpeciality;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_TreatmentSelectAll')]//input[@type='checkbox']")
		private WebElement checkbox_SelectAllSpecialityTreatment;
		@FindBy(xpath = "//div[contains(@id,'Wait') and contains(@style,'display: none')]")
		private WebElement widget_LoadingVisible;
		@FindBy(xpath = "//div[contains(@id,'Wait') and contains(@style,'display: block')]")
		private WebElement widget_LoadingInvisible;
		//End : DHP - 57
		//Start: DHP - 99
		@FindBy(xpath = "//div[contains(@id,'SpecialityAppointment')]//span[contains(text(),'Speciality - Appointment')]")
		private WebElement table_SpecialityAppointment;
		@FindBy(xpath = "//div[contains(@id,'SpecialityAppointment')]//div[contains(text(),'Speciality Name')]")
		private WebElement label_AppointmentSpecialityNameColumn;
		@FindBy(xpath = "//div[contains(@id,'SpecialityAppointment')]//div[contains(text(),'Select All')]")
		private WebElement label_AppointmentSpecialitySelectAllColumn;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_AppointmentSelectAll')]//input[@type='checkbox' and @checked='checked']")
		private WebElement checkbox_AppointmentSpecialitySelectAllCheckbox;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_AppointmentSelectAll')]//input[@type='checkbox']")
		private WebElement checkbox_AppointmentSpecialityDeselectAllCheckbox;
		@FindBy(xpath = "//table[contains(@id,'SpecialityAppointmentTable2')]//a[@class='SaveRowAction']")
		private WebElement button_SaveAddAppointmentSpeciality;
		@FindBy(xpath = "//table[contains(@id,'SpecialityAppointmentTable2')]//a[@class='CancelRowAction']")
		private WebElement button_CancelAddAppointmentSpeciality;
		@FindBy(xpath = "//table[contains(@id,'SpecialityAppointmentTable2')]//input[contains(@id,'TextBox_Appointment') and contains(@class,'InEditMode') and contains(@name,'TextBox_Appointment')]")
		private WebElement field_SpecialityAppointment;
		@FindBy(xpath = "//table[contains(@id,'SpecialityAppointmentTable2')]//span[text()='This field cannot be blank']")
		private WebElement validation_AddSpecialityAppointment;
		@FindBy(xpath = "//div[contains(@id,'heckBox_AppointmentSelectAll')]//input[@type='checkbox']")
		private WebElement checkbox_SelectAllSpecialityAppointment;
		@FindBy(xpath = "//a[contains(@id,'SpecialityPMITable_AddRow')]")
		private WebElement link_AddPatientMedInfoSpeciality;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityAppointment')]//input[@value='Brain Surgeon']//following::td//input[@userscheckboxid='CheckBox0'])[1]")
		private WebElement checkbox_SpecialityAppointment1;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityAppointment')]//input[@value='Dental']//following::td//input[@userscheckboxid='CheckBox1'])[1]")
		private WebElement checkbox_SpecialityAppointment2;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityAppointment')]//input[@value='Dietitian']//following::td//input[@userscheckboxid='CheckBox2'])[1]")
		private WebElement checkbox_SpecialityAppointment3;
		@FindBy(xpath = "//div[contains(@id,'SpecialityAppointment')]//input[@value='Brain Surgeon']")
		private WebElement label_SpecialityAppointment1;
		@FindBy(xpath = "//div[contains(@id,'SpecialityAppointment')]//input[@value='Dental']")
		private WebElement label_SpecialityAppointment2;
		@FindBy(xpath = "//div[contains(@id,'SpecialityAppointment')]//input[@value='Dietitian']")
		private WebElement label_SpecialityAppointment3;
		//End: DHP - 99
		//Start: DHP - 104
		@FindBy(xpath = "//div[contains(@id,'SpecialityClinician')]//span[contains(text(),'Speciality - Clinician')]")
		private WebElement table_SpecialityClinician;
		@FindBy(xpath = "//div[contains(@id,'SpecialityClinician')]//div[contains(text(),'Speciality Name')]")
		private WebElement label_ClinicianSpecialityNameColumn;
		@FindBy(xpath = "//div[contains(@id,'SpecialityClinician')]//span[contains(text(),'Select All')]")
		private WebElement label_ClinicianSpecialitySelectAllColumn;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_UsersSelectAll')]//input[@type='checkbox' and @checked='checked']")
		private WebElement checkbox_ClinicianSpecialitySelectAllCheckbox;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_UsersSelectAll')]//input[@type='checkbox']")
		private WebElement checkbox_ClinicianSpecialityDeselectAllCheckbox;
		@FindBy(xpath = "//table[contains(@id,'SpecialityClinicianTable')]//a[@class='SaveRowAction']")
		private WebElement button_SaveAddClinicianSpeciality;
		@FindBy(xpath = "//table[contains(@id,'SpecialityClinicianTable')]//a[@class='CancelRowAction']")
		private WebElement button_CancelAddClinicianSpeciality;
		@FindBy(xpath = "//table[contains(@id,'SpecialityClinicianTable')]//input[contains(@id,'TextBox_Users') and contains(@class,'InEditMode') and contains(@name,'TextBox_Users')]")
		private WebElement field_SpecialityClinician;
		@FindBy(xpath = "//table[contains(@id,'SpecialityClinicianTable')]//span[text()='This field cannot be blank']")
		private WebElement validation_AddSpecialityClinician;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_UsersSelectAll')]//input[@type='checkbox']")
		private WebElement checkbox_SelectAllSpecialityClinician;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityClinician')]//input[@value='Exercise Physiologist']//following::td//input[@userscheckboxid='CheckBox0'])[1]")
		private WebElement checkbox_SpecialityClinician1;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityClinician')]//input[@value='General Practitioner (GP)']//following::td//input[@userscheckboxid='CheckBox1'])[1]")
		private WebElement checkbox_SpecialityClinician2;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityClinician')]//input[@value='Pathologist']//following::td//input[@userscheckboxid='CheckBox2'])[1]")
		private WebElement checkbox_SpecialityClinician3;
		@FindBy(xpath = "//div[contains(@id,'SpecialityClinician')]//input[@value='Exercise Physiologist']")
		private WebElement label_SpecialityClinician1;
		@FindBy(xpath = "//div[contains(@id,'SpecialityClinician')]//input[@value='General Practitioner (GP)']")
		private WebElement label_SpecialityClinician2;
		@FindBy(xpath = "//div[contains(@id,'SpecialityClinician')]//input[@value='Pathologist']")
		private WebElement label_SpecialityClinician3;
		//End: DHP - 104
		//Start: DHP - 110
		@FindBy(xpath = "//div[contains(@id,'SpecialityPMI')]//span[contains(text(),'Speciality - Patient Medical Info')]")
		private WebElement table_SpecialityPMI;
		@FindBy(xpath = "//div[contains(@id,'SpecialityPMI')]//div[contains(text(),'Speciality Name')]")
		private WebElement label_PMISpecialityNameColumn;
		@FindBy(xpath = "//div[contains(@id,'SpecialityPMI')]//span[contains(text(),'Select All')]")
		private WebElement label_PMISpecialitySelectAllColumn;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_PMISelectAll')]//input[@type='checkbox' and @checked='checked']")
		private WebElement checkbox_PMISpecialitySelectAllCheckbox;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_PMISelectAll')]//input[@type='checkbox']")
		private WebElement checkbox_PMISpecialityDeselectAllCheckbox;
		@FindBy(xpath = "//table[contains(@id,'SpecialityPMITable')]//a[@class='SaveRowAction']")
		private WebElement button_SaveAddPMISpeciality;
		@FindBy(xpath = "//table[contains(@id,'SpecialityPMITable')]//a[@class='CancelRowAction']")
		private WebElement button_CancelAddPMISpeciality;
		@FindBy(xpath = "//table[contains(@id,'SpecialityPMITable')]//input[contains(@id,'TextBox_PMI') and contains(@class,'InEditMode') and contains(@name,'TextBox_PMI')]")
		private WebElement field_SpecialityPMI;
		@FindBy(xpath = "//table[contains(@id,'SpecialityPMITable')]//span[text()='This field cannot be blank']")
		private WebElement validation_AddSpecialityPMI;
		@FindBy(xpath = "//div[contains(@id,'CheckBox_PMISelectAll')]//input[@type='checkbox']")
		private WebElement checkbox_SelectAllSpecialityPMI;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityPMI')]//input[@value='Cardiologist']//following::td//input[@userscheckboxid='CheckBox0'])[1]")
		private WebElement checkbox_SpecialityPMI1;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityPMI')]//input[@value='Endocrinologist']//following::td//input[@userscheckboxid='CheckBox1'])[1]")
		private WebElement checkbox_SpecialityPMI2;
		@FindBy(xpath = "(//div[contains(@id,'SpecialityPMI')]//input[@value='Medical Oncologist']//following::td//input[@userscheckboxid='CheckBox2'])[1]")
		private WebElement checkbox_SpecialityPMI3;
		@FindBy(xpath = "//div[contains(@id,'SpecialityPMI')]//input[@value='Cardiologist']")
		private WebElement label_SpecialityPMI1;
		@FindBy(xpath = "//div[contains(@id,'SpecialityPMI')]//input[@value='Endocrinologist']")
		private WebElement label_SpecialityPMI2;
		@FindBy(xpath = "//div[contains(@id,'SpecialityPMI')]//input[@value='Medical Oncologist']")
		private WebElement label_SpecialityPMI3;
		@FindBy(xpath = "//a[contains(@id,'SpecialityClinicianTable_AddRow')]")
		private WebElement link_AddClinicianSpeciality;
		//End: DHP - 110
		//Start: DHP - 119
		@FindBy(xpath = "(//div[contains(@id,'Appointment_Settings')]//div[contains(@id,'ToggleButtonWrapper') and @class='toggle-button'])[1]")
		private WebElement toggle_VideoConfeOFF;
		@FindBy(xpath = "(//div[contains(@id,'Appointment_Settings')]//div[contains(@id,'ToggleButtonWrapper') and @class='toggle-button toggle-button-checked'])[1]")
		private WebElement toggle_VideoConfeON;
		@FindBy(xpath = "(//div[contains(@id,'Appointment_Settings')]//div[contains(@id,'ToggleButtonWrapper') and @class='toggle-button'])[2]")
		private WebElement toggle_ClinicVisitOFF;
		@FindBy(xpath = "(//div[contains(@id,'Appointment_Settings')]//div[contains(@id,'ToggleButtonWrapper') and @class='toggle-button toggle-button-checked'])[2]")
		private WebElement toggle_ClinicVisitON;
		@FindBy(xpath = "(//div[contains(@id,'Appointment_Settings')]//div[contains(@id,'ToggleButtonWrapper')])[1]")
		private WebElement toggle_VideoConfe;
		@FindBy(xpath = "(//div[contains(@id,'Appointment_Settings')]//div[contains(@id,'ToggleButtonWrapper')])[2]")
		private WebElement toggle_ClinicVisit;
		//End: DHP - 119
	
		//Start: DHP - 104
		@FindBy(xpath = "//select[contains(@id,'Clinician_ClinicianSpeciality')]")
		private WebElement dropdown_ClinicianSpeciality;
		@FindBy(xpath = "//option[contains(text(),'General Practitioner (GP)')]")
		private WebElement option_GP;
		@FindBy(xpath = "//option[contains(text(),'Exercise Physiologist')]")
		private WebElement option_EP;
		@FindBy(xpath = "//option[contains(text(),'Pathologist')]")
		private WebElement option_Pathologist;
		@FindBy(xpath = "//div[contains(@id,'SpecialityClinician')]//input[@value='Plantologist']")
		private WebElement option_Plantologist;
		@FindBy(xpath = "//div[contains(@id,'SpecialityClinician')]//input[@value='Podiatrist']")
		private WebElement option_Podiatrist;
		@FindBy(xpath = "//div[contains(@id,'SpecialityClinician')]//input[@value='Zoologist']")
		private WebElement option_Zoologist;
		//End: DHP - 104
		//Start: DHP - 57
		public WebElement getTreatmentSpecialitySelectAllCheckbox() {
			return checkbox_TreatmentSpecialitySelectAllCheckbox;
		}
		public WebElement getAddAppointmentSpeciality() {
			return link_AddAppointmentSpeciality;
		}
		public WebElement getTreatmentSpecialityDeselectAllCheckbox() {
			return checkbox_TreatmentSpecialityDeselectAllCheckbox;
		}
		public WebElement getSpecialityTreatment1() {
			return label_SpecialityTreatment1;
		}
		public WebElement getSpecialityTreatment2() {
			return label_SpecialityTreatment2;
		}
		public WebElement getSpecialityTreatment3() {
			return label_SpecialityTreatment3;
		}
		public WebElement getSpecialityTreatmentCheckbox1() {
			return checkbox_SpecialityTreatment1;
		}
		public WebElement getSpecialityTreatmentCheckbox2() {
			return checkbox_SpecialityTreatment2;
		}
		public WebElement getSpecialityTreatmentCheckbox3() {
			return checkbox_SpecialityTreatment3;
		}
		public WebElement getSaveAddTreatmentSpeciality() {
			return button_SaveAddTreatmentSpeciality;
		}
		public WebElement getSelectAllSpecialityTreatment() {
			return checkbox_SelectAllSpecialityTreatment;
		}
		public WebElement getLoadingVisible() {
			return widget_LoadingVisible;
		}
		public WebElement getLoadingInvisible() {
			return widget_LoadingInvisible;
		}
		//End: DHP - 57
		//Start: DHP -99
		public WebElement getSpecialityAppointmentTable() {
			return table_SpecialityAppointment;
		}
		public WebElement getAppointmentSpecialityNameColumn() {
			return label_AppointmentSpecialityNameColumn;
		}
		public WebElement getAppointmentSpecialitySelectAllColumn() {
			return label_AppointmentSpecialitySelectAllColumn;
		}
		public WebElement getAppointmentSpecialitySelectAllCheckbox() {
			return checkbox_AppointmentSpecialitySelectAllCheckbox;
		}
		public WebElement getAppointmentSpecialityDeselectAllCheckbox() {
			return checkbox_AppointmentSpecialityDeselectAllCheckbox;
		}
		public WebElement getSaveAddAppointmentSpeciality() {
			return button_SaveAddAppointmentSpeciality;
		}
		public WebElement getCancelAddAppointmentSpeciality() {
			return button_CancelAddAppointmentSpeciality;
		}
		public WebElement getInputAppointmentSpeciality() {
			return field_SpecialityAppointment;
		}
		public WebElement getAddAppointmentSpecialityValidation() {
			return validation_AddSpecialityAppointment;
		}
		public WebElement getSelectAllSpecialityAppointment() {
			return checkbox_SelectAllSpecialityAppointment;
		}
		public WebElement getAddPatientMedInfoSpeciality() {
			return link_AddPatientMedInfoSpeciality;
		}
		public WebElement getSpecialityAppointmentCheckbox1() {
			return checkbox_SpecialityAppointment1;
		}
		public WebElement getSpecialityAppointmentCheckbox2() {
			return checkbox_SpecialityAppointment2;
		}
		public WebElement getSpecialityAppointmentCheckbox3() {
			return checkbox_SpecialityAppointment3;
		}
		public WebElement getSpecialityAppointment1() {
			return label_SpecialityAppointment1;
		}
		public WebElement getSpecialityAppointment2() {
			return label_SpecialityAppointment2;
		}
		public WebElement getSpecialityAppointment3() {
			return label_SpecialityAppointment3;
		}
		//End: DHP - 99
		//Start: DHP - 104
		public WebElement getSpecialityClinicianTable() {
			return table_SpecialityClinician;
		}
		public WebElement getClinicianSpecialityNameColumn() {
			return label_ClinicianSpecialityNameColumn;
		}
		public WebElement getClinicianSpecialitySelectAllColumn() {
			return label_ClinicianSpecialitySelectAllColumn;
		}
		public WebElement getClinicianSpecialitySelectAllCheckbox() {
			return checkbox_ClinicianSpecialitySelectAllCheckbox;
		}
		public WebElement getClinicianSpecialityDeselectAllCheckbox() {
			return checkbox_ClinicianSpecialityDeselectAllCheckbox;
		}
		public WebElement getSaveAddClinicianSpeciality() {
			return button_SaveAddClinicianSpeciality;
		}
		public WebElement getCancelAddClinicianSpeciality() {
			return button_CancelAddClinicianSpeciality;
		}
		public WebElement getInputClinicianSpeciality() {
			return field_SpecialityClinician;
		}
		public WebElement getAddClinicianSpecialityValidation() {
			return validation_AddSpecialityClinician;
		}
		public WebElement getSelectAllSpecialityClinician() {
			return checkbox_SelectAllSpecialityClinician;
		}
		public WebElement getSpecialityClinicianCheckbox1() {
			return checkbox_SpecialityClinician1;
		}
		public WebElement getSpecialityClinicianCheckbox2() {
			return checkbox_SpecialityClinician2;
		}
		public WebElement getSpecialityClinicianCheckbox3() {
			return checkbox_SpecialityClinician3;
		}
		public WebElement getSpecialityClinician1() {
			return label_SpecialityClinician1;
		}
		public WebElement getSpecialityClinician2() {
			return label_SpecialityClinician2;
		}
		public WebElement getSpecialityClinician3() {
			return label_SpecialityClinician3;
		}
		//End: DHP - 104
		//Start: DHP - 110
		public WebElement getSpecialityPMITable() {
			return table_SpecialityPMI;
		}
		public WebElement getPMISpecialityNameColumn() {
			return label_PMISpecialityNameColumn;
		}
		public WebElement getPMISpecialitySelectAllColumn() {
			return label_PMISpecialitySelectAllColumn;
		}
		public WebElement getPMISpecialitySelectAllCheckbox() {
			return checkbox_PMISpecialitySelectAllCheckbox;
		}
		public WebElement getPMISpecialityDeselectAllCheckbox() {
			return checkbox_PMISpecialityDeselectAllCheckbox;
		}
		public WebElement getSaveAddPMISpeciality() {
			return button_SaveAddPMISpeciality;
		}
		public WebElement getCancelAddPMISpeciality() {
			return button_CancelAddPMISpeciality;
		}
		public WebElement getInputPMISpeciality() {
			return field_SpecialityPMI;
		}
		public WebElement getAddPMISpecialityValidation() {
			return validation_AddSpecialityPMI;
		}
		public WebElement getSelectAllSpecialityPMI() {
			return checkbox_SelectAllSpecialityPMI;
		}
		public WebElement getAddClinicianSpeciality() {
			return link_AddClinicianSpeciality;
		}
		public WebElement getSpecialityPMICheckbox1() {
			return checkbox_SpecialityPMI1;
		}
		public WebElement getSpecialityPMICheckbox2() {
			return checkbox_SpecialityPMI2;
		}
		public WebElement getSpecialityPMICheckbox3() {
			return checkbox_SpecialityPMI3;
		}
		public WebElement getSpecialityPMI1() {
			return label_SpecialityPMI1;
		}
		public WebElement getSpecialityPMI2() {
			return label_SpecialityPMI2;
		}
		public WebElement getSpecialityPMI3() {
			return label_SpecialityPMI3;
		}
		//End: DHP - 110
	
		
		//Start: DHP - 57
		//Start: DHP - 119
		public WebElement getLabelHealthIndicator() {
			return label_HealthIndicator;
		}
		public WebElement getVCToggleOFF() {
			return toggle_VideoConfeOFF;
		}
		public WebElement getVCToggleON() {
			return toggle_VideoConfeON;
		}
		public WebElement getCVToggleOFF() {
			return toggle_ClinicVisitOFF;
		}
		public WebElement getCVToggleON() {
			return toggle_ClinicVisitON;
		}
		public WebElement getVCToggle() {
			return toggle_VideoConfe;
		}
		public WebElement getCVToggle() {
			return toggle_ClinicVisit;
		}
		
	
		
	public WebElement getDefaultLanguageDropdown() {
		return dropdown_DefaultLanguage;
	}

	public WebElement getDefaultLanguageLabel() {
		return label_DefaultLanguage;
	}

	public WebElement getMultilingualCheckbox() {
		return checkbox_Multilingual;
	}

	public WebElement getMultilingualOFFCheckbox() {
		return checkbox_MultilingualUnChecked;
	}
	public WebElement getMultilingualONCheckbox() {
		return checkbox_MultilingualChecked;
	}

	// ############################################## Return Page Objects ###############################################
	public WebElement getTimelineLabel() {
		return label_Timeline;
	}

	public WebElement getPSAfield() {
		return field_PSA;
	}

	public WebElement getPSACheckbox() {
		return checkbox_PSA;
	}

	public WebElement getRevertWellnessCheckQuestion1Textbox() {
		return textbox_RevertWellnessCheckQuestion1;
	}

	public WebElement getRevertWellnessCheckGraphLegend1Textbox() {
		return textbox_RevertWellnessCheckGraphLegend1;
	}

	public WebElement getWellnessCheckSelectAll() {
		return checkbox_WellnessCheckSelectAll;
	}

	public WebElement getWellnessCheckQuestion1Textbox() {
		return textbox_WellnessCheckQuestion1;
	}

	public WebElement getWellnessCheckGraphLegend1Textbox() {
		return textbox_WellnessCheckGraphLegend1;
	}

	public WebElement getWellnessCheckQuestion1() {
		return WellnessCheckQuestion1;
	}

	public WebElement getWellnessCheckQuestion2() {
		return WellnessCheckQuestion2;
	}

	public WebElement getWellnessCheckQuestion3() {
		return WellnessCheckQuestion3;
	}

	public WebElement getWellnessCheckQuestion4() {
		return WellnessCheckQuestion4;
	}

	public WebElement getWellnessCheckQuestion5() {
		return WellnessCheckQuestion5;
	}

	public WebElement getWellnessCheckQuestion1Checkbox() {
		return checkbox_WellnessCheckQuestion1;
	}

	public WebElement getWellnessCheckQuestion2Checkbox() {
		return checkbox_WellnessCheckQuestion2;
	}

	public WebElement getWellnessCheckQuestion3Checkbox() {
		return checkbox_WellnessCheckQuestion3;
	}

	public WebElement getWellnessCheckQuestion4Checkbox() {
		return checkbox_WellnessCheckQuestion4;
	}

	public WebElement getWellnessCheckQuestion5Checkbox() {
		return checkbox_WellnessCheckQuestion5;
	}

	public WebElement getWellnessCheckCheckIcon() {
		return checkbox_WellnessCheck_CheckIcon;
	}

	public WebElement getWellnessCheckXIcon() {
		return checkbox_WellnessCheck_XIcon;
	}

	public WebElement getToggleHealthIndicator() {
		return toggle_HealthIndicator;
	}

	public WebElement getInfoTable() {
		return infotable;
	}

	public WebElement getToggleONHealthIndicator() {
		return toggleON_HealthIndicator;
	}

	public WebElement getoptionHealthIndicatorGraph() {
		return option_HealthIndicatorGraph;
	}

	public WebElement getlabel_HealthIndicator() {
		return label_HealthIndicator;
	}

	public WebElement getHorizontaltabGeneral() {
		return horizontaltab_General;
	}

	public WebElement getHorizontaltabSpecialityList() {
		return horizontaltab_SpecialityList;
	}

	public WebElement getHorizontaltabWellnessCheck() {
		return horizontaltab_WellnessCheck;
	}

	public WebElement getHorizontaltabGeneralDefault() {
		return horizontaltab_GeneralDefault;
	}

	public WebElement getCheckboxWellnessSelectAll() {
		return checkbox_WellnessSelectAll;
	}

	public WebElement getButtonSave() {
		return button_Save;
	}

	public WebElement getButtonCancel() {
		return button_Cancel;

	}

	public WebElement getOptionVideoConferencing() {
		return option_VideoConferencing;
	}

	public WebElement getLabelAppointment() {
		return label_Appointment;
	}

	public WebElement getToggleVideo() {
		return toggle_VideoConferencing;
	}

	public WebElement getDisabledVideo() {
		return toggle_DisableVideoConferencing;
	}

	public WebElement getMsgUnsaved() {
		return popup_UnsavedChanges;
	}

	public WebElement getButtonYes() {
		return popup_Yes;
	}

	public WebElement getButtonNo() {
		return popup_No;
	}

	public WebElement getButtonUploadImage() {

		return button_UploadImage;
	}

	public WebElement getLabelAssessment() {
		return label_Assessment;
	}

	public WebElement getOptionAssessment() {
		return option_Assessment;
	}

	public WebElement getOptionNeed() {
		return option_Needs;
	}

	public WebElement getOptionDepression() {
		return option_Depression;
	}

	public WebElement getOptionAnxiety() {
		return option_Anxiety;
	}

	public WebElement getOptionPhysicalActivity() {
		return option_PhysicalActivity;
	}

	public WebElement getToggleAssessment() {
		return toggle_Assessment;
	}

	public WebElement getDisabledAssessment() {
		return toggle_DisableAssessments;
	}

	public WebElement getToggleEnabledNeeds() {
		return toggle_EnableNeeds;
	}

	public WebElement getToggleDisableNeeds() {
		return toggle_DisableNeeds;
	}

	public WebElement getDisabledNeeds() {
		return disable_Needs;
	}

	public WebElement getEnabledDepression() {
		return toggle_EnableDepression;
	}

	public WebElement getDisabledDepression() {
		return disable_Depression;
	}

	public WebElement getToggleAnxiety() {
		return toggle_EnableAnxiety;
	}

	public WebElement getToggleDisableAnxiety() {
		return toggle_DisabledAnxiety;
	}

	public WebElement getDisabledAnxiety() {
		return disable_Anxiety;
	}

	public WebElement getToggleEnableActivity() {
		return toggle_EnablePhysicalActivity;
	}

	public WebElement getToggleDisablePhysicalActivity() {
		return toggle_DisablePhysicalActivity;
	}

	public WebElement getDisabledPhysicalActivity() {
		return disable_PhysicalActivity;
	}

	public WebElement getMessageSave() {
		return message_Saved;
	}

	public WebElement getToggleEnableClinicVisit() {
		return toggle_EnableClinicVisit;
	}

	public WebElement getToggleDisableClinicVisit() {
		return toggle_DisableClinicVisit;
	}

	public WebElement getOptionClinicVisit() {
		return option_ClinicVisit;
	}

	public WebElement getPhysicalActivityOn() {
		return toggle_PhysicalActivityON;
	}

	public WebElement getNeedsToggle() {
		return toggle_Needs;
	}

	public WebElement getNeedsToggleON() {
		return toggle_NeedsON;
	}

	public WebElement getDepressionToggle() {
		return toggle_Depression;
	}

	public WebElement getDepressionToggleOn() {
		return toggle_DepressionON;
	}

	public WebElement getAnxietyToggle() {
		return toggle_Anxiety;
	}

	public WebElement getAnxietyToggleOn() {
		return toggle_AnxietyON;
	}

	public WebElement getPhysicalActivityToggle() {
		return toggle_PhysicalActivity;
	}

}
