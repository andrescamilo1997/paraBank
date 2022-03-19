package co.com.sofka.stepdefinition.parabankstep;


import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankLogInPage;
import co.com.sofka.page.parabank.ParabankRegister;
import co.com.sofka.runner.parabank.ParabankLogin;
import co.com.sofka.stepdefinition.setup.WebUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import static co.com.sofka.util.Timer.SIX;


public class ParabankLogInStepDefinition extends WebUi {
    private ParabankModel parabankModel = new ParabankModel();
    private static final Logger LOGGER = Logger.getLogger(ParabankLogin.class);
    private ParabankLogInPage parabankLogInPage;


    @Given(":El cliente entra en la pagina se registra y va a la seccion de Login")
    public void elClienteEntraEnLaPaginaYVaALaSeccionDeLogin() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();


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


            ParabankRegister parabankRegister =new ParabankRegister(driver, parabankModel, SIX.getValue());
            parabankRegister.fillRegisterPage();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @When("El cliente ingresa a su perfil con sus credenciales")
    public void elClienteIngresaSuEmailYPassword() {
        try{

            parabankModel.setUsernameLogin();
            parabankModel.setPasswordLogin();

            parabankLogInPage = new ParabankLogInPage(driver, parabankModel, SIX.getValue());
            parabankLogInPage.fillLogIn();


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }
    @When("El cliente ingresa una contraceña asignada, pero no su correo")
    public void elClienteIngresaPassword() {
        try{
            parabankModel.setPasswordLogin();

            parabankLogInPage = new ParabankLogInPage(driver, parabankModel, SIX.getValue());
            parabankLogInPage.fillLogIn();


        } catch (Exception exception){

            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }


    @Then("El cliente entra a ver sus balace")
    public void elClienteEntraAVerSusBalace() {
        Assertions.assertEquals(forSubmittedLogIn(), parabankLogInPage.isLogInDone());
        quiteDriver();
    }
    @Then("Sale un error indicandole el ingreso de sus credenciales")
    public void saleUnErrorIndicandoleElIngresoDeSusCredenciales() {
        Assertions.assertEquals(forSubmittedLogInIfNotHaveEmail(), parabankLogInPage.isLogInDoneIfNotHaveEmail());
        quiteDriver();
    }


    private  String forSubmittedLogIn(){
        String submitedLogIn;
        submitedLogIn = "*Balance includes deposits that may be subject to holds";
        return submitedLogIn;
    }
    private  String forSubmittedLogInIfNotHaveEmail(){
        String submitedLogIn;
        submitedLogIn = "Please enter a username and password.";
        return submitedLogIn;
    }



}
