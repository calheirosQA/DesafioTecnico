package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.PageDriver;
import io.qameta.allure.Step;
import utils.CommonMethods;

public class homePage extends CommonMethods {
    public homePage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    @FindBy(css = "a[title='Log in to your customer account']")
    public WebElement signInButton;

    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    public WebElement dressesButton;

    @FindBy(xpath = "(//a[@title='Casual Dresses'])[2]")
    public WebElement CasualDressesButton;

    @FindBy(xpath = "(//a[@title='T-shirts'])[2]")
    public WebElement tShirtsButton;

    @Step("Clicar no botão Sign In")
    public void clickSignInButton() {
        signInButton.click();
    }

    @Step("Clicar em T-Shirts Menu")
    public void clickOnTShirtsButton() {
        tShirtsButton.click();
    }

}
