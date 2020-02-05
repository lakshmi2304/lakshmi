package in.srssprojects.kexim_bank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationPage {

	WebDriver driver;

	public RoleCreationPage(WebDriver driver) {
		this.driver = driver;
	}

	// role name field
	@FindBy(id = "txtRname")
	private WebElement txtRoleName;

	// role type select
	@FindBy(id = "lstRtypeN")
	private WebElement lstRoleType;

	// submit button
	@FindBy(id = "btninsert")
	private WebElement btnInsertRole;

	// reset button
	@FindBy(id = "Btn_Reset")
	private WebElement btnResetRole;

	// cancel button
	@FindBy(id = "Btn_cancel")
	private WebElement btnCancelRole;

	// select Role Name
	public void fillRoleName(String strRoleName) {
		this.txtRoleName.sendKeys(strRoleName);
	}

	// select Role type
	public void selectRoleType(String strRoleTypeValue) {
		new Select(this.lstRoleType).selectByVisibleText(strRoleTypeValue);
	}

	// click on Insert Role button
	public Alert clickInsertRoleButton() {
		this.btnInsertRole.click();
		return this.driver.switchTo().alert();
		
	}

	// click on Reset Role button
	public void clickResetRoleButton() {
		this.btnResetRole.click();
	}

	// click on Cancel Role button
	public RoleDetailsPage clickCancelRoleButton() {
		this.btnCancelRole.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	//fill Role creation details 
	public void fillformRoleCreation(String strRoleName,String strRoleType) {
	this.fillRoleName(strRoleName);
	this.selectRoleType(strRoleType);
	
	}
	
	
}
