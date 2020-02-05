package in.srssprojects.kexim_bank;

import java.awt.print.Pageable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

// this class is implemented in page object model
public class BankHomePage {
	WebDriver driver;

	public BankHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// user name
	public WebElement userName() {
		return driver.findElement(By.id("txtuId"));
	}

	// password
	public WebElement password() {
		return driver.findElement(By.id("txtPword"));
	}

	// login button
	public WebElement login() {
		return driver.findElement(By.id("login"));
	}
	
	//fill username
	public void fillUserName(String username) {
		this.userName().sendKeys(username);
	}
	
	public void fillPassword(String password) {
		this.password().sendKeys(password);
	}
	
	public AdminHomePage clickLogin() {
		this.login().click();
		return PageFactory.initElements(driver, AdminHomePage.class);
	}

}
