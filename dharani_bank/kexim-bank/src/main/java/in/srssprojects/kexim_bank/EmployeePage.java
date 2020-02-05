package in.srssprojects.kexim_bank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
	// new employee button
	WebDriver driver;
	public EmployeePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "BtnNew")
	private WebElement btnNewEmp;

	// click on New Employee button
	public EmployeeCreationPage clickNewEmpButton() {
		this.btnNewEmp.click();
		return PageFactory.initElements(driver, EmployeeCreationPage.class);
	}
}
