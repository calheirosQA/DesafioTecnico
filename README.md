<h2 align="left"> Desafio Tecnico</h2>
<h3 align="left">Thiago Calheiros</h3>

## Arquitura das Pastas

📦src   
 ┗ 📂test   
 ┃ ┣ 📂java   
 ┃ ┃ ┗ 📂Driver   
 ┃ ┃ ┃ ┃📜BaseDriver.java 
 ┃ ┃ ┃ ┃📜PageDriver.java    
 ┃ ┃ ┗ 📂Datas   
 ┃ ┃ ┃ ┃📜DataSet.java
 ┃ ┃ ┗ 📂Pages   
 ┃ ┃ ┃ ┃📜cartPage.java
 ┃ ┃ ┃ ┃📜checkoutPage.java 
 ┃ ┃ ┃ ┃📜createAnAccountPage.java 
 ┃ ┃ ┃ ┃📜homePage.java 
 ┃ ┃ ┃ ┃📜myAccountPage.java   
 ┃ ┃ ┃ ┗📜signInPage.java   
 ┃ ┃ ┃ ┗📜tshirtsPage.java 
 ┃ ┃ ┗ 📂Util   
 ┃ ┃ ┃ ┃📜commonMethods.java
 ┃ ┃ ┃ ┗📜Take_ScreenShot.java  
 ┃ ┃ ┗ 📂Tests   
 ┃ ┃ ┃ ┃📜TC01_Criar_Nova_Conta.java
 ┃ ┃ ┃ ┗📜TC02_Login_E_Compra.java  
 ┃ ┃   
 ┃ ┗ README.md 
 ┗ .gitignore


## Atenção!
```java
    Projeto está configurado para rodar no Google Chrome browser. 
     -> Se quiser mudar de navegador, terá que mudar no ┃📜BaseDriver
     (Lines 27, 28 and 30)  
```
## Como Executar:
```java
    Acessar o diretorio (Raiz) e pelo terminal executar: ->>> mvn clean test <<<-
     -> Ou Abra o projeto pela IDE e execute o 📜TC01_Criar_Nova_Conta.java ou 📜TC02_Login_E_Compra.java diretamente.
```
## Relatório de execução:
```java
    Se você quiser consultar os relatórios de teste será necessário executar o commando  ->>> allure serve <<<-
     
```

## Tecnologias:

- [Java-OpenJDK 17.0.2](https://www.java.com/pt-BR/)
- [Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.8.0)
- [Webdrivermanager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.2)# Desafio-QA-DTI
