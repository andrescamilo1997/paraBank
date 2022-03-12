package co.com.sofka.runner.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ParabankContactUsPage;
import co.com.sofka.stepdefinition.setup.WebUi;
import org.apache.log4j.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParabankTest extends WebUi {
    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(ParabankTest.class);


    @BeforeEach
    public void setUpContactUs(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            parabankModel = new ParabankModel();
            parabankModel.setNameContactUs("Camilo Diaz");
            parabankModel.setEmailContactUs("andrescamilo@gmail.com");
            parabankModel.setPhoneContactUs("32165497");
            parabankModel.setMessageContactUs("Hola mundo si pude");

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Test
    public void parabankTestMandatoryFieldsContactUs(){
        try{
            ParabankContactUsPage parabankContactUsPage = new ParabankContactUsPage(driver, parabankModel);
            parabankContactUsPage.fillContactUs();

            Assertions.assertEquals(forSubmittedContactUs(),parabankContactUsPage.isContactUsDone());
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

    private String forSubmittedContactUs(){
        String submitedsendToCostumerCare ;
        submitedsendToCostumerCare = "Thank you "+parabankModel.getNameContactUs();
        return submitedsendToCostumerCare;
    }

}
