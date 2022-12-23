package stepDefinitions.contact;



import com.tricentis.demowebshop.pages.contactPage.ContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.runtime.model.PrivatePropertyDescriptor;
import runners.ContactRunner;
import stepDefinitions.setup.BaseTestPage;


public class ContactPageStepDefinition extends BaseTestPage {


    private static final Logger LOGGER = Logger.getLogger(ContactRunner.class);

    //Esenario 01
    @Given("que el cliente ingrese a la pagina Demo Web Shop y dar click en el campo Conatc Us")
    public void queElClienteIngreseALaPaginaDemoWebShopYDarClickEnElCampoConatcUs() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetup();
            ContactPage contactPage = new ContactPage(driver, 3);
            contactPage.clickOnContactUs();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @When("diligencia el formulario correctamente")
    public void diligenciaElFormularioCorrectamente() {
        try {
            ContactPage contactPage = new ContactPage(driver, 3);
            contactPage.fillContactFields();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }
    @Then("recibira un mensaje Your enquiry has been successfully sent to the store owner.")
    public void recibiraUnMensajeYourEnquiryHasBeenSuccessfullySentToTheStoreOwner() {
        try {
            ContactPage contactPage = new ContactPage(driver,3);
            Assertions.assertEquals(true,contactPage.searchMessage() );
            quiteDriver();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }


    //Esenario 02
    @When("diligencia el formulario Contact Us")
    public void diligenciaElFormularioContactUs() {
        try {
            ContactPage contactPage = new ContactPage(driver, 3);
            contactPage.CompleteformConatctUs();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @And("no ingresa un correo electronico")
    public void noIngresaUnCorreoElectronico() {
        try {
            ContactPage contactPage = new ContactPage(driver, 3);
            Thread.sleep(3000);
            contactPage.EmailEmpty();
        }catch (Exception exception){
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

    @Then("recibira un mensaje Enter email")
    public void recibiraUnMensajeEnterEmail() {
        try {
            ContactPage contactPage = new ContactPage(driver,3);
            Assertions.assertEquals(true,contactPage.MessageEnterEmail());
            quiteDriver();
        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
            quiteDriver();
        }
    }

}
