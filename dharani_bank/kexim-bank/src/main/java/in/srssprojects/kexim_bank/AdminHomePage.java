package in.srssprojects.kexim_bank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// this is implemented in page factory
public class AdminHomePage {
	WebDriver driver;

	// branches
	@FindBy(how = How.XPATH, using = "//a[@href='admin_banker_master.aspx']")
	private WebElement branches;

	// role
	@FindBy(how = How.XPATH, using = "//a[@href='Admin_Roles_details.aspx']")
	private WebElement roles;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// users
	@FindBy(how = How.XPATH, using = "//a[@href='userdetails.aspx']")
	private WebElement users;

	// employees
	@FindBy(how = How.XPATH, using = "//a[@href='Admin_Emp_details.aspx']")
	private WebElement employees;

	// home
	@FindBy(how = How.XPATH, using = "//a[@href='adminflow.aspx']")
	private WebElement home;

	// changepassword
	@FindBy(how = How.XPATH, using = "//a[@href='change_password1234.aspx']")
	private WebElement changePassword;

	// logout
	@FindBy(how = How.XPATH, using = "//a[@href='home.aspx']")
	private WebElement logout;

	// click on branches
	public BranchDetialsPage clickBranches() {
		this.branches.click();
		return PageFactory.initElements(driver, BranchDetialsPage.class);
	}

	// click on roles
	public RoleDetailsPage clickRoles() {
		this.roles.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	// click on users
	public void clickUsers() {
		this.users.click();

	}

	// click on employess
	public EmployeePage clickEmployees() {
		this.employees.click();
		return PageFactory.initElements(driver, EmployeePage.class);
	}

	// click on home
	public void clickHome() {
		this.home.click();
	}

	// click on change password
	public void clickChangePassword() {
		this.changePassword.click();
	}

	// click on logout
	public void clickLogout() {
		this.logout.click();
	}
}
