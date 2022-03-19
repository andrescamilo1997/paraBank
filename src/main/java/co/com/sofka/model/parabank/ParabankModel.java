package co.com.sofka.model.parabank;

import com.github.javafaker.Faker;
import co.com.sofka.util.Mensaje;

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

    Mensaje mensaje = new Mensaje();
    Faker   faker   = new Faker();

    String firstName    = faker.name().firstName();
    String lastName     = faker.name().lastName();
    String address      = faker.address().secondaryAddress();
    String city         = faker.address().cityName();
    String state        = faker.address().state();
    String zCode        = faker.address().zipCode();
    String phone        = faker.phoneNumber().cellPhone();
    String ssn          = String.valueOf(faker.number().numberBetween(11111111,99999999));
    String user         = firstName + phone + 1;
    String pass         = lastName + ssn;
    String email        = firstName + "_" + lastName + "@gmail.com";
    String Message      = mensaje.messageContactUs(firstName, lastName);



    public String getNameContactUs() {
        return nameContactUs;
    }

    public void setNameContactUs() {
        this.nameContactUs = firstName + " " + lastName;
    }

    public String getEmailContactUs() {
        return emailContactUs;
    }

    public void setEmailContactUs() {
        this.emailContactUs = email;
    }

    public String getPhoneContactUs() {
        return phoneContactUs;
    }

    public void setPhoneContactUs() {
        this.phoneContactUs = phone;
    }

    public String getMessageContactUs() {
        return messageContactUs;
    }

    public void setMessageContactUs() {
        this.messageContactUs = Message;
    }

    public String getUsernameLogin() {
        return usernameLogin;
    }

    public void setUsernameLogin() {
        this.usernameLogin = user;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin() {
         this.passwordLogin = pass;
    }

    public String getFirstNameRegister() {
        return firstNameRegister;
    }

    public void setFirstNameRegister() {
        this.firstNameRegister = firstName;
    }

    public String getLastNameRegister() {
        return lastNameRegister;
    }

    public void setLastaNameRegister() {
        this.lastNameRegister = lastName;
    }

    public String getAddressRegister() {
        return addressRegister;
    }

    public void setAddressRegister() {
        this.addressRegister = address;
    }

    public String getCityRegister() {
        return cityRegister;
    }

    public void setCityRegister() {
        this.cityRegister = city;
    }

    public String getStateRegister() {
        return stateRegister;
    }

    public void setStateRegister() {
        this.stateRegister = state;
    }

    public String getZipCodeRegister() {
        return zipCodeRegister;
    }

    public void setZipCodeRegister() {
        this.zipCodeRegister = zCode;
    }

    public String getPhoneRegister() {
        return phoneRegister;
    }

    public void setPhoneRegister() {
        this.phoneRegister = phone;
    }

    public String getSsnRegister() {
        return ssnRegister;
    }

    public void setSsnRegister() {
        this.ssnRegister = ssn;
    }

    public String getUsernameRegister() {
        return usernameRegister;
    }

    public void setUsernameRegister() {
        this.usernameRegister = user;
    }

    public String getPasswordRegister() {
        return passwordRegister;
    }

    public void setPasswordRegister() {
        this.passwordRegister = pass;
    }

    public String getConfirmPassRegister() {
        return confirmPassRegister;
    }

    public void setConfirmPassRegister() {
        this.confirmPassRegister = pass;
    }
}
