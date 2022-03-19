package co.com.sofka.runner.parabank;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/register.feature"},
        glue = "co.com.sofka.stepdefinition.parabankstep",
        tags = "@Reg."
)

public class RegisterRunnerCucumber {
}
