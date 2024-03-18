package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import driver.BaseDriver;
import io.qameta.allure.Description;
import pages.*;
import Datas.DataSet;
import utils.Take_Screenshot;

public class TC02_Login_E_Compra extends BaseDriver {

    @Test(description = "Fazer Login, Comprar, e Logout", dataProvider = "loginInfo", dataProviderClass = DataSet.class)
    @Description("Descrição do Teste: Dado que user está logado em automationpractice.com, "
            + "Entao adiciona um produto no carrinho e completa a compra no checkout "
            + "E User faz logout com sucesso")
    public void loginAndPurchase(String email, String password, String comment, String companyName, String addressone,
                                 String Addresstwo, String city, String statename, String zipCode, String countryname,
                                 String addiAddress, String homephone, String mobilephone, String alias) {

        homePage homepage = new homePage();
        signInPage signinpage = new signInPage();
        myAccountPage myaccountpage = new myAccountPage();
        tshirtsPage tshirtspage = new tshirtsPage();
        cartPage cartpage = new cartPage();
        createAnAccountPage register = new createAnAccountPage();
        checkoutPage checkoutpage = new checkoutPage();
        SoftAssert softassert = new SoftAssert();

        // Clica no login na home page
        homepage.clickSignInButton();

        // Aguarda pela página
        signinpage.waitForPageLoad();

        //Valida dados da página
        softassert.assertEquals(signinpage.getTitle(), signinpage.signinPageTitle);

        // Fonece info para login com email e senha
        signinpage.loginwithEmailPassword(email, password);

        // Screenshot para o relatório
        Take_Screenshot.screenshotForAllure("Página Após o login feito");

        // Click na opção de menu T-Shirts
        homepage.clickOnTShirtsButton();

        // Aguarda pela Página
        tshirtspage.waitForPageLoad();

        //Valida informações da página
        softassert.assertEquals(tshirtspage.getTitle(), tshirtspage.t_ShirtsPageTitle);

        // Clica no produto
        tshirtspage.clickOnProduct();

        //Seleciona tamanho (Exemplos: S:1 M:2 L:3)
        tshirtspage.filterSize("3");

        //Seleciona a cor disponivel
        tshirtspage.filterColor();

        // Adiciona no carrinho
        tshirtspage.productAddToCart();

        // Avança para o checkout
        cartpage.clickProceedToCheckout();

        // Aguarda a página de checkout
        checkoutpage.waitForPageLoad();

        // Valida Informações do checkout
        softassert.assertEquals(checkoutpage.getTitle(), checkoutpage.checkoutpageTitle);

        // Screenshot para o Allure
        Take_Screenshot.screenshotForAllure("Detalhes do Carrinho");

        // Avança para o Sumário
        checkoutpage.clickSummaryProceedToCheckout();

        // Avança ou preenche dados de endereço
        register.fillYourAddress(companyName, addressone, Addresstwo, city, statename, zipCode, countryname,
                addiAddress, homephone, mobilephone, alias);

        // Seleciona "Concordo" e avança com o Checkout
        checkoutpage.checkTOSAndProceedToCheckout();

        // Selecionar pagamento
        checkoutpage.clickPaybyCheque();

        // Clica em Confirmação da ordem
        checkoutpage.clickConfirmOrder();

        myaccountpage.clickSignOutButton();

        //Valida todas as informações inseridas
        softassert.assertAll();

    }

}
