package in.srssprojects.kexim_bank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchDetialsPage {
	WebDriver driver;

	public BranchDetialsPage(WebDriver driver) {
		this.driver = driver;
	}

	// country select
	@FindBy(id = "lst_countryS")
	private WebElement lstCountry;

	// state select
	@FindBy(id = "lst_stateS")
	private WebElement lstState;

	// city select
	@FindBy(id = "lst_cityS")
	private WebElement lstCity;

	// search button
	@FindBy(id = "btn_search")
	private WebElement btnSearch;

	// clear button
	@FindBy(id = "btn_clsearch")
	private WebElement btnClSearch;

	// new branch button
	@FindBy(id = "BtnNewBR")
	private WebElement newBranchButton;

	// select Country
	public void selectCountry(String strCountryValue) {
		new Select(this.lstCountry).selectByVisibleText(strCountryValue);
	}

	// select State
	public void selectState(String strStateValue) {
		new Select(this.lstState).selectByVisibleText(strStateValue);
	}

	// select City
	public void selectCity(String strCityValue) {
		new Select(this.lstCity).selectByVisibleText(strCityValue);
	}

	// click on Search button
	public void clickSearchButton() {
		this.btnSearch.click();
	}

	// click on Clear button
	public void clickClearButton() {
		this.btnClSearch.click();
	}

	// click on new branch button
	public BranchCreationPage clickNewBranchButton() {
		this.newBranchButton.click();
		return PageFactory.initElements(driver, BranchCreationPage.class);
	}
	
	public boolean isNewBranchButtonDisplyed() {
		return this.newBranchButton.isDisplayed();
	}

}
