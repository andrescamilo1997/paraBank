package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ParabankRegister extends CommonActionsOnPage {

    private static  final Logger LOGGER = Logger.getLogger(ParabankRegister.class);
    private         final ParabankModel parabankModel;
    private static  final String MESSAGE_NULL_IN_REGISTER="No se pudo ejecutar la prueba a Registro";

    public ParabankRegister(WebDriver driver, ParabankModel parabankModel, int second) {
        super(driver, second);
        pageFactoryInitElement(driver,this);
        this.parabankModel = parabankModel;
    }

    @CacheLookup
    @FindBy(id="customerForm")
    private WebElement registerPageLocator;

    @CacheLookup
    @FindBy(xpath="//*[@id=\"loginPanel\"]/p[2]/a")
    private WebElement btnRegister;

    @CacheLookup
    @FindBy(id="customer.firstName")
    private WebElement firstNameRegister;

    @CacheLookup
    @FindBy(id="customer.lastName")
    private WebElement lastNameRegister;

    @CacheLookup
    @FindBy(id="customer.address.street")
    private WebElement addressRegister;

    @CacheLookup
    @FindBy(id="customer.address.city")
    private WebElement cityRegister;

    @CacheLookup
    @FindBy(id="customer.address.state")
    private WebElement stateRegister;

    @CacheLookup
    @FindBy(id="customer.address.zipCode")
    private WebElement zipCodeRegister;

    @CacheLookup
    @FindBy(id="customer.phoneNumber")
    private WebElement  phoneRegister ;

    @CacheLookup
    @FindBy(id="customer.ssn")
    private WebElement ssnRegister ;


    @FindBy(id="customer.username")
    private WebElement userNameRegister;

    @CacheLookup
    @FindBy(id="customer.password")
    private WebElement passRegister;

    @CacheLookup
    @FindBy(id="repeatedPassword")
    private WebElement passRepeatedRegister;

    @CacheLookup
    @FindBy(xpath="//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    private WebElement btnDoneRegister;


    //For Assertion
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/h1" )
    private WebElement assertionInRegister;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"customer.lastName.errors\"]")
    private WebElement assertionIfNotHaveLastName;

    //Functions Page
    public void fillRegisterPage(){
        scrollOn        (btnRegister);
        clickOn         (btnRegister);

        if(isDisplayed(registerPageLocator)){

            scrollOn    (firstNameRegister);
            clearOn     (firstNameRegister);
            typeOn      (firstNameRegister, parabankModel.getFirstNameRegister());

            scrollOn    (lastNameRegister);
            clearOn     (lastNameRegister);
            typeOn      (lastNameRegister, parabankModel.getLastNameRegister());

            scrollOn    (addressRegister);
            clearOn     (addressRegister);
            typeOn      (addressRegister, parabankModel.getAddressRegister());

            scrollOn    (cityRegister);
            clearOn     (cityRegister);
            typeOn      (cityRegister, parabankModel.getCityRegister());

            scrollOn    (stateRegister);
            clearOn     (stateRegister);
            typeOn      (stateRegister, parabankModel.getStateRegister());

            scrollOn    (zipCodeRegister);
            clearOn     (zipCodeRegister);
            typeOn      (zipCodeRegister, parabankModel.getZipCodeRegister());

            scrollOn    (phoneRegister);
            clearOn     (phoneRegister);
            typeOn      (phoneRegister, parabankModel.getPhoneRegister());

            scrollOn    (ssnRegister);
            clearOn     (ssnRegister);
            typeOn      (ssnRegister,parabankModel.getSsnRegister() );

            scrollOn    (userNameRegister);
            clearOn     (userNameRegister);
            typeOn      (userNameRegister,parabankModel.getUsernameRegister());

            scrollOn    (passRegister);
            clearOn     (passRegister);
            typeOn      (passRegister,parabankModel.getPasswordRegister());

            scrollOn    (passRepeatedRegister);
            clearOn     (passRepeatedRegister);
            typeOn      (passRepeatedRegister,parabankModel.getConfirmPassRegister());

            scrollOn    (btnDoneRegister);
            doSubmit    (btnDoneRegister);

           }else {
            LOGGER.warn(MESSAGE_NULL_IN_REGISTER);
        }

    }



    public String  isRegisterDone(){
        String isRegisterDoneMessage;
        isRegisterDoneMessage = getText(assertionInRegister).trim();
        return isRegisterDoneMessage;
    }
    public String  isRegisterDoneIfNotHaveLastName(){
        String isRegisterDoneMessage;
        isRegisterDoneMessage = getText(assertionIfNotHaveLastName).trim();
        return isRegisterDoneMessage;
    }
}
