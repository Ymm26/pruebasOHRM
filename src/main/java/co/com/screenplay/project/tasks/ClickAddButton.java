package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickAddButton implements Task {

    // Localizador del tab Recruitment
    private static final Target BUTTON_RECRUITMENT = Target.the("Recruitment tab")
            .locatedBy("//span[text()='Recruitment']");

    // Localizador del botón Add
    private static final Target ADD_BUTTON = Target.the("Add button")
            .locatedBy("//div[@class='orangehrm-header-container']/button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Hacer clic en el tab de Recruitment
        actor.attemptsTo(Click.on(BUTTON_RECRUITMENT));

        try {
            Thread.sleep(2000); // Espera de 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restablece el estado de interrupción del hilo
        }
        // Hacer clic en el botón Add
        actor.attemptsTo(Click.on(ADD_BUTTON));
        try {
            Thread.sleep(5000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restablece el estado de interrupción del hilo
        }
    }

    public static ClickAddButton add() {
        return instrumented(ClickAddButton.class);
    }
}
