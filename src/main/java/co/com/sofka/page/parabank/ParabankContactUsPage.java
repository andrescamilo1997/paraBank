package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ParabankContactUsPage extends CommonActionsOnPage {
    private static final Logger LOGGER = Logger.getLogger(ParabankContactUsPage.class);
    private ParabankModel parabankModel;
    private static final String MODEL_NULL_MESSAGE = "No se encuentra la página buscada.";
    private final By ContactPageLocator = By.xpath("//*[@id=\"contactForm\"]/table");



    private final By btnContactUs= By.xpath("//*[@id=\"footerPanel\"]/ul[1]/li[8]/a");
    private final By nameContactUs= By.id("name");
    private final By emailContactUs= By.id("email");
    private final By phoneContactUs= By.id("phone");
    private final By messageContactUs= By.id("message");
    private final By sendToCostumerCare= By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input");


    //For Assertions Test Case.
    private final By assertionMessageNameContactUs = By.xpath("//*[@id=\"rightPanel\"]/p[1]");



    public ParabankContactUsPage(WebDriver driver, ParabankModel parabankModel) {
        super(driver);
        this.parabankModel = parabankModel;
    }

    //Funcionalidades del Page

    public void fillContactUs(){
        scrollOn(btnContactUs);
        clickOn(btnContactUs);

        if(isDisplayed(ContactPageLocator)) {

            scrollOn(nameContactUs);
            clearOn(nameContactUs);
            typeOn(nameContactUs, parabankModel.getNameContactUs());

            scrollOn(emailContactUs);
            clearOn(emailContactUs);
            typeOn(emailContactUs, parabankModel.getEmailContactUs());

            scrollOn(phoneContactUs);
            clearOn(phoneContactUs);
            typeOn(phoneContactUs, parabankModel.getPhoneContactUs());

            scrollOn(messageContactUs);
            clearOn(messageContactUs);
            typeOn(messageContactUs, parabankModel.getMessageContactUs());

            scrollOn(sendToCostumerCare);
            doSubmit(sendToCostumerCare);

        }else{
            LOGGER.warn(MODEL_NULL_MESSAGE);
        }

    }
    public String isContactUsDone(){
        String submitedsendToCostumerCare ;
        submitedsendToCostumerCare = getText(assertionMessageNameContactUs).trim();
        return submitedsendToCostumerCare;
    }

}
