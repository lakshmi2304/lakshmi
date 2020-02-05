package in.srssprojects.kexim_bank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoleDetailsPage {
	WebDriver driver;

	public RoleDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	// new role button
	@FindBy(id = "btnRoles")
	private WebElement btnCreateRole;

	// click on New Role button
	public RoleCreationPage clickNewRoleButton() {
		this.btnCreateRole.click();
		return PageFactory.initElements(driver, RoleCreationPage.class);
	}

}
