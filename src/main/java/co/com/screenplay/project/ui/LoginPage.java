package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME_FIELD = Target.the("campo de usuario")
            .locatedBy("//input[@name='username']");
    public static final Target PASSWORD_FIELD = Target.the("campo de contraseña")
            .locatedBy("//input[@name='password']");
    public static final Target LOGIN_BUTTON = Target.the("botón de inicio de sesión")
            .locatedBy("//button[@type='submit']");
    public static final Target SELECT_BOX = Target.the("caja del select")
            .located(By.cssSelector(".oxd-select-wrapper"));
    public static final Target OPTION_BY_TEXT = Target.the("opcion por texto")
            .locatedBy("//div[@role='option']//span[text()='{0}']");
    public static final Target INPUT_CORREO= Target.the("campo de correo")
            .located(By.xpath("//label[contains(text(), 'Email')]/following::input[1]"));
    public static final Target INPUT_CONTACT_NUMBER= Target.the("campo de telefono")
            .located(By.xpath("//label[contains(text(), 'Contact Number')]/following::input[1]"));
    public static final Target INPUT_SUBIR_ARCHIVO= Target.the("campo para subir archivo")
            .locatedBy("//input[@type='file']");
    public static final Target SUBMIT_BUTTON = Target.the("boton de guardar")
            .locatedBy("//button[@type='submit']");
    public static final Target SHORLIST_BUTTON = Target.the("boton shortlist")
            .locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success']");
    public static final Target SCHEDULE_BUTTON = Target.the("boton shortlist")
            .locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success']");
    public static final Target INPUT_INTERVIEW = Target.the("campo de titulo de entrevista")
            .locatedBy("//input[@class='oxd-input oxd-input--active oxd-input--error'][1]");
    public static final Target INPUT_INTERVIEWER = Target.the("campo de entrevistador")
            .locatedBy("//input[@include-employees='onlyCurrent']");
    public static final Target INPUT_DATE = Target.the("campo de fecha")
            .locatedBy("//input[@class='oxd-input oxd-input--active oxd-input--error'][2]");

}
