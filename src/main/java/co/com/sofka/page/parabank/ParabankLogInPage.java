package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ParabankLogInPage extends CommonActionsOnPage {
    private static  final Logger LOGGER =  Logger.getLogger(ParabankLogInPage.class);
    private         final ParabankModel parabankModel;
    private static  final String MODEL_NULL_MESSAGE ="NO SE ENCONTRARON RESULTADOS ESPERADOS";

    public ParabankLogInPage(WebDriver driver, ParabankModel parabankModel, int second) {
        super(driver, second);
        pageFactoryInitElement(driver, this);
        this.parabankModel = parabankModel;
    }

    @CacheLookup
    @FindBy(id = "leftPanel")
    private WebElement panel;

    @CacheLookup
    @FindBy(name = "username")
    private WebElement userNamePageLogIn;

    @CacheLookup
    @FindBy(name = "password")
    private WebElement passPageLogIn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement logInPageLogIn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    private WebElement btnLogOut;

    //Resultados Esperados
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"accountTable\"]/tfoot/tr/td")
    private WebElement assertionMessageIsLogIn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private  WebElement assertionMessageIfNotHaveEmail;



    //Funcionalidades Page LogIn
    public void fillLogIn(){
        scrollOn    (btnLogOut);
        clickOn     (btnLogOut);

        if(isDisplayed(panel)){
            scrollOn    (userNamePageLogIn);
            clearOn     (userNamePageLogIn);
            typeOn      (userNamePageLogIn, parabankModel.getUsernameLogin());

            scrollOn    (passPageLogIn);
            clickOn     (passPageLogIn);
            typeOn      (passPageLogIn, parabankModel.getPasswordLogin());

            scrollOn    (logInPageLogIn);
            doSubmit    (logInPageLogIn);
        }else {
            LOGGER.warn(MODEL_NULL_MESSAGE);
        }
    }
    public String isLogInDone(){
        String submittedSendToLogIn;
        submittedSendToLogIn = getText(assertionMessageIsLogIn);
        return submittedSendToLogIn;
    }
    public String isLogInDoneIfNotHaveEmail(){
        String submittedSendToLogIn;
        submittedSendToLogIn = getText(assertionMessageIfNotHaveEmail);
        return submittedSendToLogIn;
    }
}
