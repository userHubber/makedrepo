package kng.tests.loginAndRegistration.login;

import java.util.ArrayList;

class Data_Login {

    final String CORRECTPASSWORD = "121212";
    final String REGISTRATEDMAIL = "regonsystem@yopmail.com";

    ArrayList<String> variantsPassForRega;
    ArrayList<String> variantsPassForNegativeLogin;

    Data_Login() {

        this.variantsPassForRega = new ArrayList<>();
        variantsPassForRega.add(0, "");
        variantsPassForRega.add(1, "123");
        variantsPassForRega.add(2, "фыва");
        variantsPassForRega.add(3, "1234567890");
        variantsPassForRega.add(4, "dghdfgh");

        this.variantsPassForNegativeLogin = new ArrayList<>();
        variantsPassForNegativeLogin.addAll(variantsPassForRega);
        variantsPassForNegativeLogin.remove(0);
    }
}
