package Datas;

import org.testng.annotations.DataProvider;
import java.util.UUID;

public class DataSet {

    @DataProvider(name = "registrationInfo")
    public static Object[][] registrationData() {
        Object[][] obj = {
                {
                        generateRandomEmail(), "Thiago", "Lima", "2024@testegbi", "12",
                        "7", "1997", "GBI TESTE", "15 GBI Teste", "1997 Gbi Teste",
                        "Kentucky", "6", "41002", "21", "Apenas na parte da tarde",
                        "774-280-1997", "606-402-5000", " Minha Casa"
                },
                {
                        generateRandomEmail(), "Thiago", "Tester", "2024@testegbi", "28",
                        "5", "1990", "GBI TESTE", "15 GBI Teste", "1997 Gbi Teste",
                        "Kentucky", "6", "41002", "21", "Apenas na parte da tarde",
                        "774-280-1997", "606-402-5000", " Minha Casa"
                }
        };
        return obj;
    }

    @DataProvider(name = "loginInfo")
    public static Object[][] loginData() {

        Object[][] obj = {
                {"18032024@teste.com", "testpass123@", "Parte da Tarde", "GBI", "60 Lima", "1997 Teste Rua",
                        "Kentucky", "6", "41002", "21", "Parte da Tarde",
                        "774-280-1997", "606-402-1997", " Minha Casa"},
                {"testegbi@teste.com", "2024@testegbi", "Parte da Tarde", "GBI", "12 Calheiros", "1998 Teste Rua",
                        "Kentucky", "8", "41002", "21", "Parte da Tarde",
                        "774-280-1900", "606-402-1880", " Minha Casa"}
        };
        return obj;

    }

    private static String generateRandomEmail() {
        // Gerando uma parte aleatória do e-mail usando UUID
        String randomEmailPart = UUID.randomUUID().toString().substring(0, 8);
        // Concatenando com um domínio de e-mail fictício
        return randomEmailPart + "@example.com";
    }

}
