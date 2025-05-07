package co.com.screenplay.project.tasks;

import co.com.screenplay.project.ui.LoginPage;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.actions.UploadToField;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.targets.Target;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

import java.io.File;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.UploadToField.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillFormAndSave implements Task {

    private static final Target FIRST_NAME_FIELD = Target.the("First name field")
            .locatedBy("//input[@name='firstName']");
    private static final Target LAST_NAME_FIELD = Target.the("Last name field")
            .locatedBy("//input[@name='lastName']");
    private static final Target SAVE_BUTTON = Target.the("Save button")
            .locatedBy("//button[contains(@class, 'oxd-button') and text()='Save']");

    private final String firstName;
    private final String lastName;
    private final String textoOpcion;
    private final String correo;
    private final String telefono;
    private final String filetext;


    private final File archivo = Paths.get("src/test/resources/test.txt").toFile();



    public FillFormAndSave(String firstName, String lastName, String textoOpcion, String correo, String telefono, String txt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.textoOpcion = textoOpcion;
        this.correo= correo;
        this.telefono =telefono;
        this.filetext= txt;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Llenar los campos del formulario
        actor.attemptsTo(
                Enter.theValue(firstName).into(FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(LAST_NAME_FIELD),
                Click.on(LoginPage.SELECT_BOX),WaitUntil.the(
                        LoginPage.OPTION_BY_TEXT.of(textoOpcion),
                isVisible()).forNoMoreThan(5).seconds(),
        Click.on(LoginPage.OPTION_BY_TEXT.of(textoOpcion)),
                Enter.theValue(correo).into(LoginPage.INPUT_CORREO),
                Enter.theValue(telefono).into(LoginPage.INPUT_CONTACT_NUMBER),
            //    ExecuteJavaScript.on("document.querySelector('input[type=file]').style.display = 'block'"),
                Upload.theFile(archivo.toPath()).to(LoginPage.INPUT_SUBIR_ARCHIVO)


        );

        // Hacer clic en el botón Save
        actor.attemptsTo(Click.on(LoginPage.SUBMIT_BUTTON));
    }

    public static FillFormAndSave withData(String firstName, String lastName, String textoOpcion, String correo, String telefono, String archivo) {
        return instrumented(FillFormAndSave.class, firstName, lastName, textoOpcion, correo, telefono, archivo);
    }
}

