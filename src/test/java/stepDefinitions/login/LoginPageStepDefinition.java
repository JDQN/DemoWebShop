package stepDefinitions.login;

import com.tricentis.demowebshop.pages.loginPage.LoginPage;
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

    //Esenario 03
    @Given("que el cliente entro al aplicativo DemoShop")
    public void queElClienteEntroAlAplicativoDemoShop() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetup();
            LoginPage loginPage = new LoginPage(driver, 3);
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
            loginPage.fillLoginFields();
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

}
