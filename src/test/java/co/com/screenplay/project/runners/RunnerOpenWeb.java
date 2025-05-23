package co.com.screenplay.project.runners;

import io.cucumber.junit.CucumberOptions;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/openweb.feature",
        glue = "co.com.screenplay.project.stepDefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@successful"


)
public class RunnerOpenWeb {

}
//todos los paquetes donde se encuentra el stepdefinition