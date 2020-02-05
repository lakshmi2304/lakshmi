package in.srssprojects.kexim_bank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage {
	WebDriver driver;
	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
	}
	// employee name field
	@FindBy(id = "txtUname")
	private WebElement txtEmpName;

	// employee password field
	@FindBy(id = "txtLpwd")
	private WebElement txtLoginPsw;

	// role type select
	@FindBy(id = "lst_Roles")
	private WebElement lstRole;

	// branch name select
	@FindBy(id = "lst_Branch")
	private WebElement lstBranch;

	// submit button
	@FindBy(id = "BtnSubmit")
	private WebElement btnSubmitEmp;

	// reset button
	@FindBy(id = "btnreset")
	private WebElement btnResetEmp;

	// cancel button
	@FindBy(id = "btnCancel")
	private WebElement btnCancelEmp;

	// fill Employee name
	public void fillEmpName(String strEmpName) {
		this.txtEmpName.sendKeys(strEmpName);
	}

	// fill Employee password
	public void fillEmpPsw(String strEmpPsw) {
		this.txtLoginPsw.sendKeys(strEmpPsw);
	}

	// select Role type
	public void selectRoleType(String strRoleTypeValue) {
		new Select(this.lstRole).selectByVisibleText(strRoleTypeValue);
	}

	// select Branch
	public void selectBranch(String strBranchValue) {
		new Select(this.lstBranch).selectByVisibleText(strBranchValue);
	}

	// click on submit Employee button
	public Alert clickSubmitEmpButton() {
		this.btnSubmitEmp.click();
		return driver.switchTo().alert();
	}

	// click on Reset Emp button
	public void clickResetEmpButton() {
		this.btnResetEmp.click();
	}

	// click on Cancel Emp button
	public void clickCancelEmpButton() {
		this.btnCancelEmp.click();
	}
	//fill form details
	public void fillEmployeeDetails(String strEmpName, String strEmpPsw, String strRole, String strBranch) {
		this.fillEmpName(strEmpName);
		this.fillEmpPsw(strEmpPsw);
		this.selectRoleType(strRole);
		this.selectBranch(strBranch);
		
	}

}
