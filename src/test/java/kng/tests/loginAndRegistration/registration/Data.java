package kng.tests.loginAndRegistration.registration;

import kng.helpers.AdditionalData;
import java.util.ArrayList;

public class Data {

    private final AdditionalData SUPPLIER = new AdditionalData();

    final String VALIDMAIL = SUPPLIER.getGeneratedMail();
    final String VALIDPASSWORD = "121212";
    final String FIRSTNAME = "Карл";
    final String SECONDNAME = "Карлов";
    final String SAVEDNAME = "Карлов Карл";
    final String PHONE = SUPPLIER.getGeneratedPhone();
    final String SAVEDPHONE = SUPPLIER.getSavedPhone(PHONE);
    final String RESPECTCLIENT = "уважаемый клиент";

    ArrayList<String> incorrectEmails;
    ArrayList<String> validEmail;
    ArrayList<String> validPass;
    ArrayList<String> incorrectPass;

    public Data() {
        this.validEmail = new ArrayList<>();
        validEmail.add(0, VALIDMAIL);
        //
        this.validPass = new ArrayList<>();
        validPass.add(0, VALIDPASSWORD);
        //
        this.incorrectEmails = new ArrayList<>();
        incorrectEmails.add(0, "");
        incorrectEmails.add(1, "фыва");
        incorrectEmails.add(2, "JJJ");
        incorrectEmails.add(3, "12@incorrect");
        incorrectEmails.add(4, "incorrect@ mail.ru");
        incorrectEmails.add(5, "regonsystem@yopmail.com");//зарегистрирован в системе ранее    
        // 
        this.incorrectPass = new ArrayList<>();
        incorrectPass.add(0, "");
        incorrectPass.add(1, "123");
        incorrectPass.add(2, "фыва");
    }
}
