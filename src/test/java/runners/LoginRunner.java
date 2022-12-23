package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/login/login.feature"},
        glue = "stepDefinitions.contact",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class LoginRunner {

}
