package stepDefinitions.signIn;

import com.tricentis.demowebshop.pages.contactPage.ContactPage;
import com.tricentis.demowebshop.pages.registerPage.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import runners.LoginRunner;
import stepDefinitions.setup.BaseTestPage;

public class SignInPageStepDefinition extends BaseTestPage {

    private static final Logger LOGGER = Logger.getLogger(LoginRunner.class);

    @Given("que el cliente entro a la pagina de registro")
    public void queElClienteEntroALaPaginaDeRegistro() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetup();
            RegisterPage registerPage = new RegisterPage(driver, 3);
            registerPage.clickOnRegister();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }
    @When("ingrese los datos del formulario correctamente")
    public void ingreseLosDatosDelFormularioCorrectamente() {
        try{
            RegisterPage registerPage = new RegisterPage(driver, 3);
            registerPage.completeformRegister();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }
    @And("recibira un mensaje Your registration completed")
    public void recibiraUnMensajeYourRegistrationCompleted() {
        try {
            RegisterPage registerPage = new RegisterPage(driver,3);
            Assertions.assertEquals(true,registerPage.searchMessageRegister());
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @Then("da click en el boton continuar")
    public void daClickEnElBotonContinuar() {
        try {
            RegisterPage registerPage = new RegisterPage(driver, 3);
            registerPage.clickOnContinueBtn();
            Thread.sleep(3000);
            quiteDriver();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }


    //Esenario 06
    @When("no ingresa los datos requeridos del formulario")
    public void noIngresaLosDatosRequeridosDelFormulario() {
        try{
            RegisterPage registerPage = new RegisterPage(driver, 3);
            registerPage.incompleteFormRegister();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }

    }
    @Then("recibira un mensaje required de los campos que hacen falta por diligenciar")
    public void recibiraUnMensajeRequiredDeLosCamposQueHacenFaltaPorDiligenciar() {

    }

}
