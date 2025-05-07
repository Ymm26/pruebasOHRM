package co.com.screenplay.project.stepDefinition.hook;

import co.com.screenplay.project.hook.OpenWeb;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.Constants.TITLE;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

//crear un step definition que agregue la notación before
public class Hook {
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("{string} abre el sitio web de pruebas")
    public void openTheTestWebsite(String actor) {
        // Implementa la lógica aquí
        // System.out.println(actor + " está abriendo el sitio web de pruebas...");
    OnStage.theActorCalled(actor).attemptsTo(
            OpenWeb.browserURL()
    );
        waiting(TIME_SHORT);
        //el actor es el centro de atención y deberia
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE)
                )
        );
    }
}
