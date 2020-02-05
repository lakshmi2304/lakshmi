package in.srssprojects.kexim_bank;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(TestNgListener.class)
public class TestExecution extends BaseClass {
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchDetialsPage branchDetailsPageObj;
	BranchCreationPage branchCreationPageObj;
	Alert alert;
	RoleDetailsPage roleDetailsPageObj;
	RoleCreationPage roleCreationPageObj;
	EmployeePage empPageObj;
	EmployeeCreationPage empCreationPageObj;
	String alertText;

	@Test(priority = 0, groups = { "employee", "create", "branch", "role", "cancel", "reset" })
	public void loginTest() {
		bankHomePageObj.fillUserName("Admin");
		bankHomePageObj.fillPassword("Admin");
		adminHomePageObj = bankHomePageObj.clickLogin();
	}

	@Test(priority = 20, groups = { "employee", "create", "branch", "role", "cancel", "reset" })
	public void logoutTest() {
		adminHomePageObj.clickLogout();
	}

	@Test(priority = 2, groups = { "branch", "create" })
	public void branchCreation() {
		// click on branches button in admin home page
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		// click on new branch button in branch details page
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		// fill a form in branch creation page
		branchCreationPageObj.fillBranchCreationForm("branchNameBranch", "addresss", "43211", "INDIA", "GOA", "GOA");
		// click on submit in branch creation page
		alert = branchCreationPageObj.clickSubmitButton();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.toLowerCase().contains("successfully"));
	}

	@Test(priority = 3, groups = { "branch", "create" }, dependsOnMethods = { "branchCreation" })
	public void branchCreationWithDuplicatedata() {
		// click on branches button in admin home page
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		// click on new branch button in branch details page
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		// fill a form in branch creation page
		branchCreationPageObj.fillBranchCreationForm("branchNameBranch", "addresss", "43211", "INDIA", "GOA", "GOA");
		// click on submit in branch creation page
		alert = branchCreationPageObj.clickSubmitButton();
		alertText = alert.getText();
		alert.accept();
		Assert.assertTrue(alertText.toLowerCase().contains("already exists"));

	}

	@Test(priority = 4, groups = { "branch", "create" })
	public void branchCreationWithBlankData() {
		// click on branches button in admin home page
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		// click on new branch button in branch details page
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		// click on submit in branch creation page
		alert = branchCreationPageObj.clickSubmitButton();
		alert.accept();
	}

	@Test(priority = 5, groups = { "branch", "reset" })
	public void branchCreationReset() {
		// click on branches button in admin home page
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		// click on new branch button in branch details page
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		// fill a form in branch creation page
		branchCreationPageObj.fillBranchCreationForm("branchNameBranch", "addresss", "43211", "INDIA", "GOA", "GOA");
		// click on submit in branch creation page
		String actualOptionText = branchCreationPageObj.clickResetButton();
		Assert.assertEquals(actualOptionText, "Select");

	}

	@Test(priority = 6, groups = { "branch", "cancel" })
	public void branchCreationCancel() {
		// click on brnaches button in admin home page
		branchDetailsPageObj = adminHomePageObj.clickBranches();
		// click on new branch button in branch details page
		branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
		// fill a form in branch creation page
		branchCreationPageObj.fillBranchCreationForm("branchNameBranch", "addresss", "43211", "INDIA", "GOA", "GOA");
		// click on submit in branch creation page
		branchDetailsPageObj = branchCreationPageObj.clickCancelButton();
		Assert.assertTrue(branchDetailsPageObj.isNewBranchButtonDisplyed());
	}

	// For Role Creation page
	@Test(priority = 7, groups = { "role", "create" })
	public void roleCreation() {
		// click on Roles button in admin home page
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		// click on new role button in roles details page
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		// fill a form in Role creation page
		roleCreationPageObj.fillformRoleCreation("Rolenamew", "E");
		// click on submit in Role creation page
		alert = roleCreationPageObj.clickInsertRoleButton();
		alert.accept();
	}

	@Test(priority = 8, groups = { "role", "create" })
	public void roleCreationWithDuplicate() {
		// click on Roles button in admin home page
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		// click on new role button in roles details page
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		// fill a form in Role creation page
		roleCreationPageObj.fillformRoleCreation("Rolenamew", "E");
		// click on submit in Role creation page
		alert = roleCreationPageObj.clickInsertRoleButton();
		alert.accept();
	}

	@Test(priority = 9, groups = { "role", "create" })
	public void roleCreationWithBlank() {
		// click on Roles button in admin home page
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		// click on new role button in roles details page
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		// click on submit in Role creation page
		alert = roleCreationPageObj.clickInsertRoleButton();
		alert.accept();
	}

	@Test(priority = 10, groups = { "role", "reset" })
	public void roleCreationReset() {
		// click on Roles button in admin home page
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		// click on new role button in roles details page
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		// fill a form in Role creation page
		roleCreationPageObj.fillformRoleCreation("Rolenamew", "E");
		// click on reset in Role creation page
		roleCreationPageObj.clickResetRoleButton();

	}

	@Test(priority = 11, groups = { "role", "cancel" })
	public void roleCreationCancel() {
		// click on Roles button in admin home page
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		// click on new role button in roles details page
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		// fill a form in Role creation page
		roleCreationPageObj.fillformRoleCreation("Rolenamew", "E");
		// click cancel in Role creation page
		roleCreationPageObj.clickCancelRoleButton();

	}

	// for Employee creation

	@Test(priority = 12, groups = { "employee", "create" })
	public void empCreation() {
		// click on emp button in admin home page
		empPageObj = adminHomePageObj.clickEmployees();
		// click on new emp button in emp details page
		empCreationPageObj = empPageObj.clickNewEmpButton();
		// fill a form in emp creation page
		empCreationPageObj.fillEmployeeDetails("david", "password", "manager", "ABranch1");
		// click on submit in emp creation page
		alert = empCreationPageObj.clickSubmitEmpButton();
		alert.accept();
	}

	@Test(priority = 13, groups = { "employee", "create" })
	public void empCreationWithDuplicate() {
//		click on emp button in admin home page
		empPageObj = adminHomePageObj.clickEmployees();
//		click on new emp button in emp details page
		empCreationPageObj = empPageObj.clickNewEmpButton();
//		fill a form in emp creation page
		empCreationPageObj.fillEmployeeDetails("david", "password", "manager", "ABranch1");
//		click on submit in emp creation page
		alert = empCreationPageObj.clickSubmitEmpButton();
		alert.accept();

	}

	@Test(priority = 14, groups = { "employee", "create" })
	public void empCreationWithBlank() {
//		click on emp button in admin home page
		empPageObj = adminHomePageObj.clickEmployees();
//		click on new emp button in emp details page
		empCreationPageObj = empPageObj.clickNewEmpButton();
//		click on submit in emp creation page
		alert = empCreationPageObj.clickSubmitEmpButton();
		// handle alert
		alert.accept();
	}

	@Test(priority = 15, groups = { "employee", "reset" })
	public void empCreationReset() {
//		click on emp button in admin home page
		empPageObj = adminHomePageObj.clickEmployees();
//		click on new emp button in emp details page
		empCreationPageObj = empPageObj.clickNewEmpButton();
//			fill a form in emp creation page
		empCreationPageObj.fillEmployeeDetails("david", "password", "manager", "ABranch1");
//		click on reset in emp creation page
		empCreationPageObj.clickResetEmpButton();

	}

	@Test(priority = 16, groups = { "employee", "cancel" })
	public void empCreationCancel() {
//		click on emp button in admin home page
		empPageObj = adminHomePageObj.clickEmployees();
//		click on new emp button in emp details page
		empCreationPageObj = empPageObj.clickNewEmpButton();
//			fill a form in emp creation page
		empCreationPageObj.fillEmployeeDetails("david", "password", "manager", "ABranch1");
//		click on cancel in emp creation page
		empCreationPageObj.clickCancelEmpButton();

	}

	@Test(priority = 17, groups = { "branch", "create", "datadriven" })
	public void branchCreationWithMultipleDataWODP() {
		ExcelHelper.setExcel("resources", "testdata", "branchdata");
		int nor = ExcelHelper.getRowCount();
//		int noc = ExcelHelper.getCellCount();
		for (int i = 1; i < nor; i++) {
			String bname = ExcelHelper.readData(i, 0);
			String address1 = ExcelHelper.readData(i, 1);
			String zcode = ExcelHelper.readData(i, 2);
			String country = ExcelHelper.readData(i, 3);
			String state = ExcelHelper.readData(i, 4);
			String city = ExcelHelper.readData(i, 5);
			// click on branches button in admin home page
			branchDetailsPageObj = adminHomePageObj.clickBranches();
			// click on new branch button in branch details page
			branchCreationPageObj = branchDetailsPageObj.clickNewBranchButton();
			// fill a form in branch creation page
			branchCreationPageObj.fillBranchCreationForm(bname, address1, zcode,country, state, city );
			// click on submit in branch creation page
			alert = branchCreationPageObj.clickSubmitButton();
			alertText = alert.getText();
			alert.accept();
//			Assert.assertTrue(alertText.toLowerCase().contains("successfully"));
		}
	}
	
	@DataProvider(name = "roledata")
	public Object[][] getRoleData(){
		return ExcelHelper.getData("resources", "testdata", "roledata");
	}
	
	@Test(priority = 18, groups = { "role", "create" }, dataProvider="roledata")
	public void roleCreationWithMultipleData(String roleName, String roleType) {
		// click on Roles button in admin home page
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		// click on new role button in roles details page
		roleCreationPageObj = roleDetailsPageObj.clickNewRoleButton();
		// fill a form in Role creation page
		roleCreationPageObj.fillformRoleCreation(roleName, roleType);
		// click on submit in Role creation page
		alert = roleCreationPageObj.clickInsertRoleButton();
		alert.accept();
	}

}
