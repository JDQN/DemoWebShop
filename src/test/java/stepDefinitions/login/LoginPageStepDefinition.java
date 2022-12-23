package stepDefinitions.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import runners.ContactRunner;
import runners.LoginRunner;
import stepDefinitions.setup.BaseTestPage;

public class LoginPageStepDefinition extends BaseTestPage {

    private static final Logger LOGGER = Logger.getLogger(LoginRunner.class);

    //Esenario 03
    @Given("que el cliente entro al aplicativo DemoShop")
    public void queElClienteEntroAlAplicativoDemoShop() {

    }
    @When("ingrese los datos Email y Password correctamente")
    public void ingreseLosDatosEmailYPasswordCorrectamente() {

    }
    @Then("entrara a la cuenta.")
    public void entraraALaCuenta() {

    }

    //Esenario 04
    @When("no ingrese los datos Email y Password correctamente")
    public void noIngreseLosDatosEmailYPasswordCorrectamente() {

    }
    @Then("recibira un mensaje Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect")
    public void recibiraUnMensajeLoginWasUnsuccessfulPleaseCorrectTheErrorsAndTryAgainTheCredentialsProvidedAreIncorrect() {

    }

}
