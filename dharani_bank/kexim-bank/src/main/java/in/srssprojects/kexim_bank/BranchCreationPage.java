package in.srssprojects.kexim_bank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage {
	WebDriver driver;

	public BranchCreationPage(WebDriver driver) {
		this.driver = driver;
	}

	// branch name field

	@FindBy(id = "txtbName")
	private WebElement txtBranchName;

	// address 1 field
	@FindBy(id = "txtAdd1")
	private WebElement txtAdd1Value;

	// zip code field
	@FindBy(id = "txtZip")
	private WebElement txtZipValue;

	// country field
	@FindBy(id = "lst_counrtyU")
	private WebElement lstCountryUValue;

	// state filed
	@FindBy(id = "lst_stateI")
	private WebElement lstStateIValue;

	// city field
	@FindBy(id = "lst_cityI")
	private WebElement lstCityIValue;

	// submit button
	@FindBy(id = "btn_insert")
	private WebElement btnInsert;

	// reset button
	@FindBy(id = "Btn_Reset")
	private WebElement btnReset;

	// cancel button
	@FindBy(id = "Btn_cancel")
	private WebElement btnCancel;

	// fill branch name
	public void fillBranchName(String bname) {
		this.txtBranchName.sendKeys(bname);
	}

	// fill address1
	public void fillAddress1(String add1) {
		this.txtAdd1Value.sendKeys(add1);
	}

	// fill zipcode
	public void fillZipCode(String zipcode) {
		this.txtZipValue.sendKeys(zipcode);
	}

	// select Country
	public void selectCountry(String StrCountryUValue) {
		new Select(this.lstCountryUValue).selectByVisibleText(StrCountryUValue);
	}

	// select State
	public void selectState(String strStateIValue) {
		new Select(this.lstStateIValue).selectByVisibleText(strStateIValue);
	}

	// select City
	public void selectCity(String strCityIValue) {
		new Select(this.lstCityIValue).selectByVisibleText(strCityIValue);
	}

	// click on Insert button
	public Alert clickSubmitButton() {
		this.btnInsert.click();
		return driver.switchTo().alert();
	}

	// click on Clear button
	public String clickResetButton() {
		this.btnReset.click();
		return new Select(this.lstCountryUValue).getFirstSelectedOption().getText();
	}

	// click on new branch button
	public BranchDetialsPage clickCancelButton() {
		this.btnCancel.click();
		return PageFactory.initElements(driver, BranchDetialsPage.class);
	}

	// fill the branch creation form
	public void fillBranchCreationForm(String bname, String add1, String zipcode, String country, String state,
			String city) {
		this.fillBranchName(bname);
		this.fillAddress1(add1);
		this.fillZipCode(zipcode);
		this.selectCountry(country);
		this.selectState(state);
		this.selectCity(city);
	}

}
