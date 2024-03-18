package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.PageDriver;
import io.qameta.allure.Step;
import utils.CommonMethods;

public class myAccountPage extends CommonMethods {
	public myAccountPage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(css = "a[title='Sign out']")
	public WebElement signOutButton;
	
	@FindBy(css = "a[title='View my customer account'] span")
	public WebElement userName;
	

	@Step("Clicar no Botão Sign Out")
	public void clickSignOutButton() {
		signOutButton.click();

	}

}
