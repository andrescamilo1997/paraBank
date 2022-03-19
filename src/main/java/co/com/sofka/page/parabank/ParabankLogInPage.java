package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ParabankLogInPage extends CommonActionsOnPage {
    private static final Logger LOGGER =  Logger.getLogger(ParabankLogInPage.class);
    private final ParabankModel parabankModel;
    private static final String MODEL_NULL_MESSAGE ="NO SE ENCONTRARON RESULTADOS ESPERADOS";




    //Campos
    @CacheLookup
    @FindBy(id = "leftPanel")
    private WebElement panel;

    @CacheLookup
    @FindBy(name = "username")
    private WebElement UserNamePageLogIn;

    @CacheLookup
    @FindBy(name = "password")
    private WebElement PassPageLogIn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement LogInPageLogIn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    private WebElement btnLogOut;

    //Resultado Esperado
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"accountTable\"]/tfoot/tr/td")
    private WebElement assertionMessageIsLogIn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private  WebElement assertionMessageIfNotHaveEmail;







    public ParabankLogInPage(WebDriver driver, ParabankModel parabankModel, int second) {
        super(driver, second);
        pageFactoryInitElement(driver, this);
        this.parabankModel = parabankModel;

    }

    //Funcionalidades Page LogIn

    public void fillLogIn(){
        scrollOn    (btnLogOut);
        clickOn     (btnLogOut);

        if(isDisplayed(panel)){
            scrollOn(UserNamePageLogIn);
            clearOn(UserNamePageLogIn);
            typeOn(UserNamePageLogIn, parabankModel.getUsernameLogin());

            scrollOn(PassPageLogIn);
            clickOn(PassPageLogIn);
            typeOn(PassPageLogIn, parabankModel.getPasswordLogin());

            scrollOn(LogInPageLogIn);
            clickOn(LogInPageLogIn);
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
