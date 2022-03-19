package co.com.sofka.runner.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankLogInPage;
import co.com.sofka.page.parabank.ParabankRegister;
import co.com.sofka.stepdefinition.setup.WebUi;
import org.apache.log4j.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static co.com.sofka.util.Timer.SIX;

public class ParabankLogin extends WebUi {
    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(ParabankLogin.class);




    @BeforeEach
    public void setUpContactUs(){
        try{

            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();


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


            parabankModel.setUsernameLogin();
            parabankModel.setPasswordLogin();


            ParabankRegister parabankRegister =new ParabankRegister(driver, parabankModel, SIX.getValue());
            parabankRegister.fillRegisterPage();





        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Test
    public void parabankTestMandatoryFieldsContactUs(){
        try{
            ParabankLogInPage parabankLogInPage = new ParabankLogInPage(driver, parabankModel, SIX.getValue());
            parabankLogInPage.fillLogIn();


            Assertions.assertEquals(forSubmittedLogIn(), parabankLogInPage.isLogInDone());

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @AfterEach
    public void tearDownContactUs(){
        quiteDriver();
    }
    private  String forSubmittedLogIn(){
        String submitedLogIn;
        submitedLogIn = "*Balance includes deposits that may be subject to holds";
        return submitedLogIn;
    }
}
