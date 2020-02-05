package in.srssprojects.kexim_bank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import customexceptions.InvalidBrowserNameException;

public class BasicExecution extends TestExecution {

	@BeforeClass(groups = { "employee", "create", "branch", "role", "cancel", "reset" })
	public void setup() {
		try {
			launchBrowser("chrome", "http://srssprojects.in", true);
		} catch (InvalidBrowserNameException e) {
			System.out.println(e.getMessage());
		}
		bankHomePageObj = new BankHomePage(driver);

	}

	@AfterClass(groups = { "employee", "create", "branch", "role", "cancel", "reset" })
	public void tearDown() {
		closeBrowser();
	}

}
