package co.com.sofka.runner.parabank;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/customer_care.feature"},
        glue = "co.com.sofka.stepdefinition.parabankstep",
        tags = "@Contact"

)
public class ContactUsRunnerCucumber {
}
