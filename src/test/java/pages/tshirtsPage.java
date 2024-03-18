package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.PageDriver;
import io.qameta.allure.Step;
import utils.CommonMethods;

public class tshirtsPage extends CommonMethods {
    public tshirtsPage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'More')]")
    public WebElement ProductSelect;

    @FindBy(id = "group_1")
    public WebElement filterSize;

    @FindBy(id = "color_13")
    public WebElement filterColor;

    @FindBy(className = "product-container")
    public WebElement product;

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    public WebElement addToCartButton;

    public String t_ShirtsPageTitle = "T-shirts - My Shop";

    @Step("Click On Product")
    public void clickOnProduct() {
        scrollToElement(product);
        hover(product);
        ProductSelect.click();
    }

    @Step("Selecionar Tamanho")
    public void filterSize(String size) { selectitem(filterSize, size); }
    @Step("Selecionar Cor")
    public void filterColor() { filterColor.click();  }
    @Step("Scroll até o produto e clicar em AddCart")
    public void productAddToCart() {
        filterColor.click();
        addToCartButton.click();
    }


}
