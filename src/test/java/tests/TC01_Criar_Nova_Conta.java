package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import driver.BaseDriver;
import io.qameta.allure.Description;
import pages.homePage;
import pages.signInPage;
import pages.createAnAccountPage;
import pages.myAccountPage;
import Datas.DataSet;
import utils.Take_Screenshot;

public class TC01_Criar_Nova_Conta extends BaseDriver {

    @Test(description = "Realizar Cadastro de 2 Novas contas", dataProvider = "registrationInfo", dataProviderClass = DataSet.class)
    @Description("Descriçao do Teste: Dado que estou em automationpractice.com"
            + "Entao Relizo um novo cadastro de usuário "
            + "E Realizo Logout com sucesso ")
    public void registration(String email, String firstname, String lastname, String password,
                             String day, String month, String year, String companyName, String addressone,
                             String Addresstwo, String city, String statename, String zipCode, String countryname,
                             String addiAddress, String homephone, String mobilephone, String alias) {

        homePage homepage = new homePage();
        signInPage signinpage = new signInPage();
        createAnAccountPage register = new createAnAccountPage();
        myAccountPage myaccountpage = new myAccountPage();
        SoftAssert softassert = new SoftAssert();

        
        // Ir para a página de Login
        homepage.clickSignInButton();

        // Aguardar pela página de Login
        signinpage.waitForPageLoad();

        // Validar Detalhes da página
        softassert.assertEquals(signinpage.getTitle(), signinpage.signinPageTitle);

        // Fornecer e-mail para a nova conta e Iniciar cadastro
        signinpage.createAccountWithEmail(email);

        // Aguadar página de Cadastro
        register.waitForPageLoad();

        // Validar Detalhes da página
        softassert.assertEquals(register.pageSubHeading.getText(), register.pageSubHeadingText);

        // Fornecer Informações Pessoais
        register.fillPersonalInformation(firstname, lastname, password, day, month, year);

        // Fornecer Informações de Endereço
        register.fillYourAddress(companyName, addressone, Addresstwo, city, statename, zipCode, countryname,
                addiAddress, homephone, mobilephone, alias);

        // Aguardar pela pagina de validação de Informações
        myaccountpage.waitForPageLoad();

        // Validar informações pessoais
        String fullName = firstname + " " + lastname;
        softassert.assertEquals(myaccountpage.userName.getText(), fullName);

        // Screenshot para o report do Allure
        Take_Screenshot.screenshotForAllure("Conta Criada");

        // Deslogar
        myaccountpage.clickSignOutButton();

        // Validar Todas as Informações Inseridas
        softassert.assertAll();

    }

}
