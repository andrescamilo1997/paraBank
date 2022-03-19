package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class ParabankContactUsPage extends CommonActionsOnPage {
    private static final Logger LOGGER = Logger.getLogger(ParabankContactUsPage.class);
    private        final ParabankModel parabankModel;
    private static final String MODEL_NULL_MESSAGE = "No se encuentra la página buscada.";

    public ParabankContactUsPage(WebDriver driver, ParabankModel parabankModel, int Second) {
        super(driver,Second);
        pageFactoryInitElement(driver,this);
        this.parabankModel = parabankModel;
    }

    @CacheLookup
    @FindBy(xpath ="//*[@id=\"contactForm\"]/table")
    private WebElement contactPageLocator;

    @CacheLookup
    @FindBy(xpath ="//*[@id=\"footerPanel\"]/ul[1]/li[8]/a")
    private WebElement btnContactUs;

    @CacheLookup
    @FindBy(id ="name")
    private WebElement nameContactUs;

    @CacheLookup
    @FindBy(id ="email")
    private WebElement emailContactUs;

    @CacheLookup
    @FindBy(id ="phone")
    private WebElement phoneContactUs;

    @CacheLookup
    @FindBy(id ="message")
    private WebElement messageContactUs;

    @CacheLookup
    @FindBy(xpath ="//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input")
    private WebElement sendToCostumerCare;

    //For Assertions Test Case.
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p[1]")
    private WebElement assertionMessageNameContactUs;

    //In case you do not have contact Us ok
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"email.errors\"]")
    private WebElement doNotAssertionMessage;







    //Funcionalidades del Page

    public void fillContactUs(){
        scrollOn    (btnContactUs);
        clickOn     (btnContactUs);

        if(isDisplayed(contactPageLocator)) {

            scrollOn    (nameContactUs);
            clearOn     (nameContactUs);
            typeOn      (nameContactUs, parabankModel.getNameContactUs());

            scrollOn    (emailContactUs);
            clearOn     (emailContactUs);
            typeOn      (emailContactUs, parabankModel.getEmailContactUs());

            scrollOn    (phoneContactUs);
            clearOn     (phoneContactUs);
            typeOn      (phoneContactUs, parabankModel.getPhoneContactUs());

            scrollOn    (messageContactUs);
            clearOn     (messageContactUs);
            typeOn      (messageContactUs, parabankModel.getMessageContactUs());

            scrollOn    (sendToCostumerCare);
            doSubmit    (sendToCostumerCare);

        }else{
            LOGGER.warn(MODEL_NULL_MESSAGE);
        }

    }
    public String isContactUsDone(){
        String submitedsendToCostumerCare ;
            submitedsendToCostumerCare = assertionMessageNameContactUs.getText().trim();
        return submitedsendToCostumerCare;
    }
    public String isContactUsIsNotDone(){
        String submitedsendToCostumerCare ;
        submitedsendToCostumerCare = doNotAssertionMessage.getText().trim();
        return submitedsendToCostumerCare;
    }

}
