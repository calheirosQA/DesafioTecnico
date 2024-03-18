package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.PageDriver;
import io.qameta.allure.Step;
import utils.CommonMethods;
import utils.Take_Screenshot;

public class signInPage extends CommonMethods {
    public signInPage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    @FindBy(id = "email_create")
    public WebElement emailInputField;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(id = "email")
    public WebElement emailLoginField;

    @FindBy(id = "passwd")
    public WebElement passwordLoginField;

    @FindBy(id = "SubmitLogin")
    public WebElement signInButton;

    public String signinPageTitle = "Login - My Shop";

    @Step("Fornecer um novo email e clicar em iniciar um novo cadastro")
    public void createAccountWithEmail(String email) {
        sendText(emailInputField, email);
        createAccountButton.click();

    }

    @Step("Fornecer user e senha para Login")
    public void loginwithEmailPassword(String email, String password) {
        sendText(emailLoginField, email);
        sendText(passwordLoginField, password);
        // Taking a screenshot for reporting purpose
        Take_Screenshot.screenshotForAllure("Informações de Login");
        signInButton.click();

    }

}
