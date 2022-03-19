package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankContactUsPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static co.com.sofka.util.Timer.SIX;
import org.junit.jupiter.api.Assertions;


public class ParabankContactUsStepDefinition extends WebUi {
    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(ParabankContactUsStepDefinition.class);
    private ParabankContactUsPage parabankContactUsPage;

    @Given("El cliente se encuentra en la seccion contact us de parabank")
    public void elClienteSeEncuentraEnLaSeccionContactUsDeParabank() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }
    @When("El cliente ingresa su nombre,email numero detelefono y mensaje")
    public void elClienteIngresaSuNombreEmailNumeroDeTelefonoYMensaje() {
        try{
            parabankModel = new ParabankModel();


            parabankModel.setNameContactUs   ();
            parabankModel.setEmailContactUs  ();
            parabankModel.setPhoneContactUs  ();
            parabankModel.setMessageContactUs();

            parabankContactUsPage = new ParabankContactUsPage(driver, parabankModel, SIX.getValue());
            parabankContactUsPage.fillContactUs();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }
    @When("El cliente ingresa su nombre, numero de telefono y mensaje")
    public void ElClienteIngresaSuNombreNumeroDeTelefonoMensaje(){
        try{
            parabankModel = new ParabankModel();

            parabankModel.setNameContactUs   ();
            parabankModel.setPhoneContactUs  ();
            parabankModel.setMessageContactUs();

            parabankContactUsPage = new ParabankContactUsPage(driver, parabankModel, SIX.getValue());
            parabankContactUsPage.fillContactUs();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Then("El cliente recibe un mensaje de confirmacion")
    public void elClienteRecibeUnMensajeDeConfirmacion() {

        Assertions.assertEquals(forSubmittedContactUs(),parabankContactUsPage.isContactUsDone());
        quiteDriver();
    }
    @Then("El cliente recibe un mensaje que es obligatorio poner el correo")
    public void ElClienteRecibeUnMensajeQueEsObligatorioPonerElCorreo(){

        Assertions.assertEquals(forSubmittedIfNoHaveEmailInContactUs(),parabankContactUsPage.isContactUsIsNotDone());
        quiteDriver();

    }

    private String forSubmittedContactUs(){
        String submitedsendToCostumerCare ;
        submitedsendToCostumerCare = "Thank you "+parabankModel.getNameContactUs();
        return submitedsendToCostumerCare;
    }

    private String forSubmittedIfNoHaveEmailInContactUs(){
        String submitedsendToCostumerCare ;
        submitedsendToCostumerCare = "Email is required.";
        return submitedsendToCostumerCare;
    }

}
