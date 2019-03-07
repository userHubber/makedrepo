package kng.tests.loginAndRegistration.login;

import kng.tests.loginAndRegistration.Steps_LoginAndReg;
import kng.navigation.URLs;
import kng.driver.DriverMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Case_Positive extends DriverMethods {

    private Steps_LoginAndReg step;
    private Data_Login user_info;
//========================================================================================

    @BeforeTest
    public void preconditions() {
        System.out.println("АВТОРИЗАЦИЯ, ПОЗИТИВНЫЙ СЦЕНАРИЙ");
        super.wd = super.setUpChromDriver();
        step = new Steps_LoginAndReg(super.wd);
        user_info = new Data_Login();
    }

    @BeforeMethod
    public void conditions() {
        super.driverGet(URLs.MAINPAGE);
    }

    @Test
    public void case_loginPositive() {
        step.writeCorrectLoginForm(user_info.REGISTRATEDMAIL, user_info.CORRECTPASSWORD);
    }

    @AfterTest
    public void closeBrowser() {
        super.driverCloseQuit();
    }
}
