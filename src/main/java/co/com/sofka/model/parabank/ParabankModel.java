package co.com.sofka.model.parabank;

import co.com.sofka.util.MeesageGeneralContacts;

public class ParabankModel {

    private String nameContactUs ="";
    private String emailContactUs = "";
    private String phoneContactUs;
    private String messageContactUs;

    private String usernameLogin  ="";
    private String passwordLogin  ;

    private String firstNameRegister ;
    private String lastNameRegister = "";
    private String addressRegister= "";
    private String cityRegister;
    private String stateRegister;
    private String zipCodeRegister;
    private String phoneRegister;
    private String ssnRegister;
    private String usernameRegister;
    private String passwordRegister;
    private String confirmPassRegister;

    MeesageGeneralContacts meesageGeneralContacts = new MeesageGeneralContacts();

    public String getNameContactUs() {
        return nameContactUs;
    }

    public void setNameContactUs() {
        this.nameContactUs = meesageGeneralContacts.fullName();
    }

    public String getEmailContactUs() {
        return emailContactUs;
    }

    public void setEmailContactUs() {
        this.emailContactUs = meesageGeneralContacts.email();
    }

    public String getPhoneContactUs() {
        return phoneContactUs;
    }

    public void setPhoneContactUs() {
        this.phoneContactUs = meesageGeneralContacts.getPhone();
    }

    public String getMessageContactUs() {
        return messageContactUs;
    }

    public void setMessageContactUs() {
        this.messageContactUs = meesageGeneralContacts.toString();
    }

    public String getUsernameLogin() {
        return usernameLogin;
    }

    public void setUsernameLogin() {
        this.usernameLogin = meesageGeneralContacts.userNameRegister();
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin() {
         this.passwordLogin = meesageGeneralContacts.password();
    }

    public String getFirstNameRegister() {
        return firstNameRegister;
    }

    public void setFirstNameRegister() {
        this.firstNameRegister = meesageGeneralContacts.getFirstName();
    }

    public String getLastNameRegister() {
        return lastNameRegister;
    }

    public void setLastaNameRegister() {
        this.lastNameRegister = meesageGeneralContacts.getLastName();
    }

    public String getAddressRegister() {
        return addressRegister;
    }

    public void setAddressRegister() {
        this.addressRegister = meesageGeneralContacts.getAddress();
    }

    public String getCityRegister() {
        return cityRegister;
    }

    public void setCityRegister() {
        this.cityRegister = meesageGeneralContacts.getCity();
    }

    public String getStateRegister() {
        return stateRegister;
    }

    public void setStateRegister() {
        this.stateRegister = meesageGeneralContacts.getState();
    }

    public String getZipCodeRegister() {
        return zipCodeRegister;
    }

    public void setZipCodeRegister() {
        this.zipCodeRegister = meesageGeneralContacts.getzCode();
    }

    public String getPhoneRegister() {
        return phoneRegister;
    }

    public void setPhoneRegister() {
        this.phoneRegister = meesageGeneralContacts.getPhone();
    }

    public String getSsnRegister() {
        return ssnRegister;
    }

    public void setSsnRegister() {
        this.ssnRegister = meesageGeneralContacts.ssn();
    }

    public String getUsernameRegister() {
        return usernameRegister;
    }

    public void setUsernameRegister() {
        this.usernameRegister = meesageGeneralContacts.userNameRegister();
    }

    public String getPasswordRegister() {
        return passwordRegister;
    }

    public void setPasswordRegister() {
        this.passwordRegister = meesageGeneralContacts.password();
    }

    public String getConfirmPassRegister() {
        return confirmPassRegister;
    }

    public void setConfirmPassRegister() {
        this.confirmPassRegister = meesageGeneralContacts.password();
    }
}
