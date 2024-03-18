package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.PageDriver;

public class CommonMethods {


    /**************************
     * Get Title para validar se o titulo da página corresponde
     * ************************
     */

    public String getTitle() {
        return PageDriver.getCurrentDriver().getTitle();
    }

    /**************************
     * Escrever no campo, esse método antes de escrever ele primeiramente limpa o campo.
     * ************************
     */

    public void sendText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    /******************************
     * Foi necessario criar esse metodo para clicar em alguns elementos que é necessário ter o mouse em hover sobre o elemento para que posssa ser clicado
     * ****************************
     */
    public void hover(WebElement element) {
        Actions actions = new Actions(PageDriver.getCurrentDriver());
        actions.clickAndHold(element).build().perform();
    }



    /*********************************************
     * Metodo para melhor manusear os Selects Options(dropdown)
     * *******************************************
     */

    public void selectitem(WebElement element, String value) {
        Select selectItems = new Select(element);
        selectItems.selectByValue(value);
    }



    /*********************************************
     * Criado para melhor manuear o Scroll até o elemento
     * *******************************************
     */

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }



    /****************************
     * Espera
     */
    WebDriverWait wait;


    /********************************************
     * Espera com timeout definido para os alerts
     * ******************************************
     */
    public Alert waitForAlert() {
        wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }



    /********************************************
     * Espera do carregamento da página
     * ******************************************
     */
    public void waitForPageLoad() {
        wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) wd -> {
            assert wd != null;
            return ((JavascriptExecutor) wd)
                    .executeScript("return document.readyState;")
                    .equals("complete");
        });
    }


}
