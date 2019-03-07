package kng.tests.loginAndRegistration.registration;

import kng.tests.loginAndRegistration.Steps_LoginAndReg;
import kng.navigation.URLs;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import kng.driver.DriverMethods;
import org.testng.annotations.BeforeTest;

public class Case extends DriverMethods {

    private Steps_LoginAndReg step;
    private Data user_info;
    private boolean b;

//================================================================  
    @BeforeTest(alwaysRun = true)
    public void preconditions() {
        System.out.println("РЕГИСТРАЦИЯ");
        super.wd = super.setUpChromDriver();
        step = new Steps_LoginAndReg(super.wd);
        b = true;
    }

    @BeforeMethod(alwaysRun = true)
    public void conditions() {
        if (b == true) {
            user_info = new Data();
            super.driverGet(URLs.MAINPAGE);
        }
    }

    @Test(priority = 1, groups = {"dev", "pre"})
    public void case_FirstStageNegativeRegistrationWithoutOferta() {
        System.out.println("Регистрация, первый этап, негатив сценарий, без подтверждения оферты");
        step.firstStageRegaValidWithoutOferta(user_info.VALIDMAIL, user_info.VALIDPASSWORD);
    }

    @Test(priority = 2, groups = {"dev", "pre"})
    public void case_FirstStageNegativeRegistrationEmptyFields() {
        System.out.println("Регистрация, первый этап, негатив сценарий, пустые поля");
        step.firstStageRegaNegative();
    }

    @Test(priority = 3, groups = {"dev", "pre"})
    public void case_FirstStageNegativeRegistrationBadMail() {
        System.out.println("Регистрация, первый этап, негатив сценарий, невалидные майл");
        step.firstStageRegaNegative(user_info.incorrectEmails, user_info.validPass);
    }

    @Test(priority = 4, groups = {"dev", "pre"})
    public void case_FirstStageNegativeRegistrationBadPass() {
        System.out.println("Регистрация, первый этап, негатив сценарий, невалидные пароли");
        step.firstStageRegaNegative(user_info.validEmail, user_info.incorrectPass);
    }

    @Test(priority = 5, groups = {"dev", "pre", "prod"})
    public void case_FirstStagePosistive() {
        System.out.println("Регистрация, первый этап, позитив");
        step.firstStageRega(user_info.VALIDMAIL, user_info.VALIDPASSWORD, true);
        super.driverGet(URLs.ACCOUNT_PERSONAL_DATA);
        step.accControlAfterRega(user_info.VALIDMAIL, user_info.RESPECTCLIENT, "");
    }

    @Test(priority = 6, groups = {"dev", "pre", "prod"})
    public void case_SecondStagePosistive() {
        System.out.println("Регистрация, второй этап, позитив");
        step.secondStageRega(user_info.VALIDMAIL, user_info.VALIDPASSWORD,
                user_info.FIRSTNAME, user_info.SECONDNAME, user_info.PHONE, false);
        super.driverGet(URLs.ACCOUNT_PERSONAL_DATA);
        step.accControlAfterRega(user_info.VALIDMAIL, user_info.SAVEDNAME, user_info.SAVEDPHONE);
        b = false;
    }

    @Test(dependsOnMethods = "case_SecondStagePosistive", groups = {"dev", "pre", "prod"})
    public void case_deleteAccount() {
        System.out.println("Удаление аккаунта юзером через ЛК");
        super.driverGet(URLs.ACCOUNT_PERSONAL_DATA);
        step.deleteAccount(user_info.VALIDMAIL);
    }

    @AfterMethod(alwaysRun = true)
    public void clearDriver() {
        if (b == true) {
            super.driverClear();
        }
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        super.driverCloseQuit();
    }
}
