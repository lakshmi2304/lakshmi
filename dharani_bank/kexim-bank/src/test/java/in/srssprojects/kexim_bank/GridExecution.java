package in.srssprojects.kexim_bank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import customexceptions.InvalidBrowserNameException;

public class GridExecution extends TestExecution {

	@BeforeClass(groups = { "employee", "create", "branch", "role", "cancel", "reset" })
	@Parameters({"url", "brName", "nodeUrl"})
	public void setup(String u, String br, String nodeUrl) {
		try {
			launchBrowser(br, u, true, nodeUrl);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		bankHomePageObj = new BankHomePage(driver);

	}

	@AfterClass(groups = { "employee", "create", "branch", "role", "cancel", "reset" })
	public void tearDown() {
		closeBrowser();
	}

}
