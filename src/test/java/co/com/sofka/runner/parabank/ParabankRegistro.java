package co.com.sofka.runner.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankRegister;
import co.com.sofka.stepdefinition.setup.WebUi;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static co.com.sofka.util.Timer.SIX;


public class ParabankRegistro extends WebUi {
    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(ParabankRegistro.class);

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




        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Test
    public void parabankTestMandatoryFieldsContactUs(){
        try{
            ParabankRegister parabankRegister =new ParabankRegister(driver, parabankModel, SIX.getValue());
            parabankRegister.fillRegisterPage();

            Assertions.assertEquals(forSubmittedRegister(), parabankRegister.isRegisterDone());
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



    private  String forSubmittedRegister(){
        String  submittedRegister;
        submittedRegister = "Welcome " + parabankModel.getUsernameRegister();
        return submittedRegister;
    }
}
