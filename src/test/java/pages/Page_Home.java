package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.Base;

public class Page_Home extends Base {
	public Page_Home() {
		PageFactory.initElements(webDriver, this);
	}

	// ################################################## Page Objects ##################################################
	@FindBy(xpath = "//span[text() = 'Home']//parent::a")
	private WebElement button_Home;

	@FindBy(xpath = "//a[text() = 'Logout']")
	private WebElement button_Logout;

	@FindBy(xpath = "//span[text() = 'Maintenance']//parent::a")
	private WebElement button_Maintenance;

	@FindBy(xpath = "//a[contains(@class, 'notification')]")
	private WebElement button_Notifications;

	@FindBy(xpath = "//span[text() = 'Projects']//parent::a")
	private WebElement button_Projects;

	@FindBy(xpath = "//span[text() = 'Reports']//parent::a")
	private WebElement button_Reports;

	@FindBy(xpath = "//span[text() = 'Time Sheets']//parent::a")
	private WebElement button_TimeSheets;

	@FindBy(xpath = "//span[text() = 'Users']//parent::a")
	private WebElement button_Users;

	// DHP Reborned
	@FindBy(xpath = "//input[contains(@id,'btnLogin')]")
	private WebElement button_LogIn;
	@FindBy(xpath = "//input[contains(@id,'btnRegister')]")
	private WebElement button_Register;
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement link_LogInOnFooter;

	@FindBy(xpath = "//div[text()='Welcome to PROSTMATE']")
	private WebElement header_HeroText;
	// @FindBy(xpath = "//div[text()='Quality Care that's all about You']")
	@FindBy(xpath = "//div[contains(text(),'Quality Care')]")
	private WebElement header_HeroSubText;
	@FindBy(xpath = "//div[contains(@id,'LanguageBar')]")
	private WebElement container_LanguageBar;
	@FindBy(xpath = "//img[contains(@src,'TH.png')]")
	private WebElement flag_Thailand;
	@FindBy(xpath = "//img[contains(@src,'US.png')]")
	private WebElement flag_US;
	@FindBy(xpath = "//div[text()='Thai']")
	private WebElement language_Thailand;
	@FindBy(xpath = "//div[text()='English']")
	private WebElement language_US;
	@FindBy(xpath = "//div[@class='dropdown-icon']")
	private WebElement dropdown_language;
	@FindBy(xpath = "//a[text()='Thai']")
	private WebElement dropdown_Thailand;
	@FindBy(xpath = "//a[text()='English']")
	private WebElement dropdown_US;
	
	
	
	

	// ############################################## Return Page Objects ###############################################
	public WebElement getLanguageThailandDropdown() {
		return dropdown_Thailand;
	}
	public WebElement getLanguageUSDropdown() {
		return dropdown_US;
	}
	public WebElement getLanguageDropdown() {
		return dropdown_language;
	}
	public WebElement getLanguageThailand() {
		return language_Thailand;
	}
	public WebElement getLanguageUS() {
		return language_US;
	}
	
	
	public WebElement getFlagThailand() {
		return flag_Thailand;
	}
	public WebElement getFlagUS() {
		return flag_US;
	}
	public WebElement getLanguageBarContainer() {
		return container_LanguageBar;
	}
	public WebElement getLogInLinkOnFooter() {
		return link_LogInOnFooter;
	}

	public WebElement getLogInButton() {
		return button_LogIn;
	}

	public WebElement getRegisterButton() {
		return button_Register;
	}

	public WebElement getButtonHome() {
		return button_Home;
	}

	public WebElement getButtonLogout() {
		return button_Logout;
	}

	public WebElement getButtonMaintenance() {
		return button_Maintenance;
	}

	public WebElement getButtonNotifications() {
		return button_Notifications;
	}

	public WebElement getButtonProjects() {
		return button_Projects;
	}

	public WebElement getButtonReports() {
		return button_Reports;
	}

	public WebElement getButtonTimeSheets() {
		return button_TimeSheets;
	}

	public WebElement getButtonUsers() {
		return button_Users;
	}

	public WebElement getHeaderHeroText() {
		return header_HeroText;
	}

	public WebElement getHeaderHeroSubText() {
		return header_HeroSubText;
	}
}