package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.PageDriver;
import io.qameta.allure.Step;
import utils.CommonMethods;

public class cartPage extends CommonMethods {
    public cartPage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    @FindBy(xpath = "//span[@title='Continue shopping']//span[1]")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
    public WebElement proceedToCheckoutButton;

    @Step("Clicar em Proceed To Checkout Button")
    public void clickProceedToCheckout() {
        proceedToCheckoutButton.click();
    }

}
