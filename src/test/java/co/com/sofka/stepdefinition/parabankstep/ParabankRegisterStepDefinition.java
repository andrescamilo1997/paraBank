package co.com.sofka.stepdefinition.parabankstep;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankRegister;
import co.com.sofka.stepdefinition.setup.WebUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Timer.ONE;
import static co.com.sofka.util.Timer.SIX;

public class ParabankRegisterStepDefinition extends WebUi {
    private ParabankModel pbankModel;
    private static final Logger LOGGER = Logger.getLogger(ParabankRegisterStepDefinition.class);
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
            pbankModel = new ParabankModel();

            pbankModel.setFirstNameRegister  ();
            pbankModel.setLastaNameRegister  ();
            pbankModel.setAddressRegister    ();
            pbankModel.setCityRegister       ();
            pbankModel.setStateRegister      ();
            pbankModel.setZipCodeRegister    ();
            pbankModel.setPhoneRegister      ();
            pbankModel.setSsnRegister        ();
            pbankModel.setUsernameRegister();
            pbankModel.setPasswordRegister   ();
            pbankModel.setConfirmPassRegister();

            parabankRegister = new ParabankRegister(driver, pbankModel, ONE.getValue());
            parabankRegister.fillRegisterPage();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }

    @When("Se le solicitan los datos personales pero no ingresa el apellido, y direccion")
    public void SeLeSolicitanLosDatosPersonalesPeroNoIngresaElApellido() {
        pbankModel = new ParabankModel();

        pbankModel.setFirstNameRegister  ();
        pbankModel.setCityRegister       ();
        pbankModel.setStateRegister      ();
        pbankModel.setZipCodeRegister    ();
        pbankModel.setPhoneRegister      ();
        pbankModel.setSsnRegister        ();
        pbankModel.setUsernameRegister   ();
        pbankModel.setPasswordRegister   ();
        pbankModel.setConfirmPassRegister();

        parabankRegister =new ParabankRegister(driver, pbankModel, SIX.getValue());
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
        submittedRegister = "Welcome " + pbankModel.getUsernameRegister();
        return submittedRegister;
    }
    private  String forSubmittedIfNotHaveLastNameRegister(){
        String  submittedRegister;
        submittedRegister = "Last name is required.";
        return submittedRegister;
    }

}
