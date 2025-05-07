package co.com.screenplay.project.stepDefinition;

import co.com.screenplay.project.tasks.ClickAddButton;
import co.com.screenplay.project.tasks.FillFormAndSave;
import co.com.screenplay.project.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class OpenWebStep {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("ingresa con usuario {string} y contrasenia {string}")
    public void loginWithCredentials(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(username, password)
        );
        // Toma una captura después de realizar el login

    }

    @Then("visualizara el titulo de la pagina {string}")
    public void validatePageTitle(String expectedTitle) {
        OnStage.theActorInTheSpotlight().should(
                net.serenitybdd.screenplay.GivenWhenThen.seeThat(
                        net.serenitybdd.screenplay.questions.page.TheWebPage.title(),
                        org.hamcrest.Matchers.containsString(expectedTitle)
                )
        );
    }

    @When("{string} hace clic en el boton de aniadir")
    public void clickAddButton(String actorName) {
        OnStage.theActorCalled(actorName).attemptsTo(
                ClickAddButton.add()
        );
    }



    @And("{string} llena el formulario con nombre {string} y apellido {string} selecciona {string} con correo {string} con numero de contacto {string} y sube el archivo {string}")
    public void fillForm(String actorName, String firstName, String lastName, String textoOpcion, String correo, String telefono, String archivo) {
        OnStage.theActorCalled(actorName).attemptsTo(
                FillFormAndSave.withData(firstName, lastName, textoOpcion, correo, telefono, archivo)
        );}
}
