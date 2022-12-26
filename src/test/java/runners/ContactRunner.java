package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


/*
* Con la class ContactRunner podemos correr
* Los test de la clase ContactPeage que tanbien estan asociados
* a la cloase ContactPageStepDefinitions
*/
@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/contact/contact.feature"},//Aqui llamamos la ruta del archivo feature
        glue = "stepDefinitions.contact",//Con la opcion glue llamamos la carpeta stepDefinitions.contact
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/ContactReports.html"}
        //plugin = {"pretty", "html:target/cucumber-reportsContactRunner.html"} // TODO con la option plugin podemos generar reportes HTML
)
public class ContactRunner {
}
