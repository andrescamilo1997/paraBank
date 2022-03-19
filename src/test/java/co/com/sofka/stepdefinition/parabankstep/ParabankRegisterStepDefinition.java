package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankRegister;
import co.com.sofka.runner.parabank.ParabankRegistro;
import co.com.sofka.stepdefinition.setup.WebUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import static co.com.sofka.util.Timer.SIX;

public class ParabankRegisterStepDefinition extends WebUi {
    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(ParabankRegistro.class);
    private ParabankRegister parabankRegister;
    @Given(": Que el cliente entra en la plataforma, seccion registro")
    public void queElClienteEntraEnLaPlataformaSeccionRegistro() {
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
    @When("ingresa se le solicitan los datos personales")
    public void ingresaSeLeSolicitanLosDatosPersonales() {
        try{
            parabankModel = new ParabankModel();

            parabankModel.setFirstNameRegister  ();
            parabankModel.setLastaNameRegister  ();
            parabankModel.setAddressRegister    ();
            parabankModel.setCityRegister       ();
            parabankModel.setStateRegister      ();
            parabankModel.setZipCodeRegister    ();
            parabankModel.setPhoneRegister      ();
            parabankModel.setSsnRegister        ();
            parabankModel.setUsernameRegister   ();
            parabankModel.setPasswordRegister   ();
            parabankModel.setConfirmPassRegister();

            parabankRegister =new ParabankRegister(driver, parabankModel, SIX.getValue());
            parabankRegister.fillRegisterPage();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }

    @When("Se le solicitan los datos personales pero no ingresa el apellido, y direccion")
    public void SeLeSolicitanLosDatosPersonalesPeroNoIngresaElApellido() {
        parabankModel = new ParabankModel();

        parabankModel.setFirstNameRegister  ();
        parabankModel.setCityRegister       ();
        parabankModel.setStateRegister      ();
        parabankModel.setZipCodeRegister    ();
        parabankModel.setPhoneRegister      ();
        parabankModel.setSsnRegister        ();
        parabankModel.setUsernameRegister   ();
        parabankModel.setPasswordRegister   ();
        parabankModel.setConfirmPassRegister();

        parabankRegister =new ParabankRegister(driver, parabankModel, SIX.getValue());
        parabankRegister.fillRegisterPage();
    }

    @Then("recibe un mensaje de bienvenda junto con su nombre")
    public void recibeUnMensajeDeBienvendaJuntoConSuNombre() {
        Assertions.assertEquals(forSubmittedRegister(), parabankRegister.isRegisterDone());
        quiteDriver();
    }
    @Then("recibe un mensaje para poner el apelido")
    public void recibeUnMensajeParaPonerElApelido() {
        Assertions.assertEquals(forSubmittedIfNotHaveLastNameRegister(), parabankRegister.isRegisterDoneIfNotHaveLastName());
        quiteDriver();
    }

    private  String forSubmittedRegister(){
        String  submittedRegister;
        submittedRegister = "Welcome " + parabankModel.getUsernameRegister();
        return submittedRegister;
    }
    private  String forSubmittedIfNotHaveLastNameRegister(){
        String  submittedRegister;
        submittedRegister = "Last name is required.";
        return submittedRegister;
    }

}
