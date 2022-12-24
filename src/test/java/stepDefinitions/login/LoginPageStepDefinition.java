package stepDefinitions.login;

import com.github.javafaker.Faker;
import com.tricentis.demowebshop.model.UserRegistre;
import com.tricentis.demowebshop.pages.loginPage.LoginPage;
import com.tricentis.demowebshop.pages.registerPage.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import runners.ContactRunner;
import runners.LoginRunner;
import stepDefinitions.setup.BaseTestPage;

public class LoginPageStepDefinition extends BaseTestPage {

    private static final Logger LOGGER = Logger.getLogger(LoginRunner.class);
    private UserRegistre userRegistre = new UserRegistre();

    //Esenario 03
    @Given("que el cliente entro al aplicativo DemoShop")
    public void queElClienteEntroAlAplicativoDemoShop() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetup();
            // Paso 1 Instanciamos las clases LogiPage Y registerPage
            LoginPage loginPage = new LoginPage(driver, 3);
            RegisterPage registerPage = new RegisterPage(driver, 3);

            /*
            * Paso 2 Generamos un metodo GenerateUserRegister dond eesta instanciado el
            * Faker y setiamos los datos
            */
            GenerateUserRegister();

            /*
            * Paso 3 utilizamos el metodo clickOnRegister para dar click en registrar
            */
            registerPage.clickOnRegister();

            /*
            * Paso 4 utilizamos el metodo completeformRegister donde octenemos los datos del
            * Modelo UserRegistre y creamos el objeto userRegistre que se lo pasamos por parametro
            * a registerPage.completeformRegister
            */
            registerPage.completeformRegister(userRegistre);

            /*
            * Paso 5 utilizamos los metodos clickOnLogOut y
            * clickOnLogin parta realizar un logIn y un logOut
            */
            loginPage.clickOnLogOut();
            loginPage.clickOnLogin();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }
    @When("ingrese los datos Email y Password correctamente")
    public void ingreseLosDatosEmailYPasswordCorrectamente() {
        try {
            LoginPage loginPage = new LoginPage(driver, 3);

            /*
            * Paso 6 utilizamos el objeto userRegistre y lo pasamos por
            * parametro a loginPage.fillLoginFields
            */
            loginPage.fillLoginFields(userRegistre);
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }
    @Then("entrara a la cuenta.")
    public void entraraALaCuenta() {
        try {
            LoginPage loginPage = new LoginPage(driver, 3);
            loginPage.titleWelcomeStore();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }


    //Esenario 04
    @When("no ingrese los datos Email y Password correctamente")
    public void noIngreseLosDatosEmailYPasswordCorrectamente() {
        try {
            LoginPage loginPage = new LoginPage(driver, 3);
            loginPage.fillLoginEmpty();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }


    @Then("recibira un mensaje Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect")
    public void recibiraUnMensajeLoginWasUnsuccessfulPleaseCorrectTheErrorsAndTryAgainTheCredentialsProvidedAreIncorrect() {
        try {
            LoginPage loginPage = new LoginPage(driver, 3);
            loginPage.fillLoginEmpty();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }


    /*
    * Aqui creamos el metodo GenerateUserRegister para
    * crear usuarios aleatorias
    */
    private void GenerateUserRegister(){
        Faker faker = new Faker();
        userRegistre = new UserRegistre();
        userRegistre.setFirstName(faker.name().firstName());
        userRegistre.setLastName(faker.name().lastName());
        userRegistre.setEmail(userRegistre.getFirstName()+userRegistre.getLastName()+"@gmail.com");
        userRegistre.setPassword("1234567");
    }


}
