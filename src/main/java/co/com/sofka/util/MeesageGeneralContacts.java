package co.com.sofka.util;

import com.github.javafaker.Faker;

public class MeesageGeneralContacts {
    //Atributos
    Faker   faker   = new Faker();
    protected String firstName;
    protected String lastName ;
    protected String address  ;
    protected String city     ;
    protected String state    ;
    protected String zCode    ;
    protected String phone    ;

    //Contructor
    public MeesageGeneralContacts() {
        this.firstName  = faker.name        ().firstName        ();
        this.lastName   = faker.name        ().lastName         ();
        this.address    = faker.address     ().secondaryAddress ();
        this.city       = faker.address     ().cityName         ();
        this.state      = faker.address     ().state            ();
        this.zCode      = faker.address     ().zipCode          ();
        this.phone      = faker.phoneNumber ().cellPhone        ();
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getzCode() {
        return zCode;
    }
    public String getPhone() {
        return phone;
    }

    //Method
    public String fullName(){
        return  firstName + " "+ lastName;
    }
    public String ssn(){
        return String.valueOf(faker.number().numberBetween(11111111,99999999));
    }
    public String email(){
        return firstName + "_" + lastName + "@gmail.com";
    }
    public String userNameRegister(){
        return firstName + "_" + lastName;
    }
    public String password(){
        return firstName + lastName + 1;
    }

    @Override
    public String toString() {
        email();
        return "Cordial saludo, me llamo " +
                firstName + lastName + " y mi correo es "+ email() +", me gustaria saber mayor informacion" +
                "sobre sus servios y demas, mil gracias por la atencion prestada."
                ;
    }


}
