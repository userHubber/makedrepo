package kng.tests.loginAndRegistration;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import kng.objects.Obj_MainPage;
import kng.objects.Obj_RegLoginPopUp;
import kng.objects.Obj_AccPersonal;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class Steps_LoginAndReg {

    private final Obj_RegLoginPopUp LOGIN_MODAL;
    private final Obj_AccPersonal ACC_PERSON;
    private final Obj_MainPage HEADER;

    public Steps_LoginAndReg(WebDriver wd) {
        HEADER = new Obj_MainPage(wd);
        LOGIN_MODAL = new Obj_RegLoginPopUp(wd);
        ACC_PERSON = new Obj_AccPersonal(wd);
    }
//===========================================================================

    private void preconditionEnteredUserInfo() {
        HEADER.clickHeaderEnter();
        LOGIN_MODAL.clickInsertRegistration();
        LOGIN_MODAL.clickOferta();
    }

    private void sendUserInfoFirstStage(String mail, String pass) {
        LOGIN_MODAL.sendMailReg(mail);
        LOGIN_MODAL.sendPassReg(pass);
    }

    private void sendUserInfoSecondStage(String name, String secondName, String phone) {
        LOGIN_MODAL.sendName(name);
        LOGIN_MODAL.sendSecondName(secondName);
        LOGIN_MODAL.sendPhone(phone);
    }

//LOGIN
    public void writeCorrectLoginForm(String name, String pass) {
        HEADER.clickHeaderEnter();
        LOGIN_MODAL.sendMailLogin(name);
        LOGIN_MODAL.sendPassLogin(pass);
        LOGIN_MODAL.pressLoginButton();
        assertTrue(HEADER.w_HeaderEnter_invisibility(10), "не авторизовались под" + " " + name);
    }

    public void writeLoginFormIncorrectPass(String name, ArrayList<String> pass) {
        HEADER.clickHeaderEnter();

        for (String $pass : pass) {
            LOGIN_MODAL.sendMailLogin(name);
            LOGIN_MODAL.sendPassLogin($pass);
            LOGIN_MODAL.pressLoginButton();
            assertFalse(HEADER.w_HeaderEnter_invisibility(2), "авторизовались с кривым паролем " + "\"" + $pass + "\"");
        }
        assertTrue(LOGIN_MODAL.w_CaptchaError_visibility(5), "не найдена ошибка Captcha при превышении лимита попыток (3)");
    }

//REGA==========================================================================
    public void firstStageRegaValidWithoutOferta(String mail, String pass) {
        this.preconditionEnteredUserInfo();
        LOGIN_MODAL.clickOferta();
        this.sendUserInfoFirstStage(mail, pass);
        LOGIN_MODAL.pressButtonRegFirsStage();
        assertTrue(LOGIN_MODAL.w_RegSecondStageButton_invisibility(5),
                "перешли на второй этап без согласия с офертой");
        assertFalse(HEADER.w_HeaderEnter_invisibility(1),
                "регистрация без согласия с офертой");
    }

    public void firstStageRegaNegative() {
        this.preconditionEnteredUserInfo();
        LOGIN_MODAL.pressButtonRegFirsStage();
        assertTrue(LOGIN_MODAL.w_RegSecondStageButton_invisibility(5),
                "перешли на второй этап при пустых полях");
        assertFalse(HEADER.w_HeaderEnter_invisibility(1), "регистрация при пустых полях");
        LOGIN_MODAL.clickOferta();
        LOGIN_MODAL.pressButtonRegFirsStage();
        assertTrue(LOGIN_MODAL.w_RegSecondStageButton_invisibility(5),
                "перешли на второй этап при пустых полях");
        assertFalse(HEADER.w_HeaderEnter_invisibility(1), "регистрация при пустых полях");
    }

    public void firstStageRegaNegative(ArrayList<String> mail, ArrayList<String> pass) {
        this.preconditionEnteredUserInfo();
        for (String $mail : mail) {
            for (String $pass : pass) {
                this.sendUserInfoFirstStage($mail, $pass);
                LOGIN_MODAL.pressButtonRegFirsStage();
                assertTrue(LOGIN_MODAL.w_RegSecondStageButton_invisibility(5),
                        "перешли на второй этап при некорректных данных - " + $mail + "\t" + $pass);
                assertFalse(HEADER.w_HeaderEnter_invisibility(1),
                        "регистрация при некорректных данных - " + $mail + "\t" + $pass);
            }
        }
    }

    public void firstStageRega(String mail, String pass, boolean missingSecond) {
        this.preconditionEnteredUserInfo();
        this.sendUserInfoFirstStage(mail, pass);
        LOGIN_MODAL.pressButtonRegFirsStage();
        assertTrue(LOGIN_MODAL.w_RegSecondStageButton_visibility(10),
                "не перешли на второй этап под" + " " + mail);
        if (missingSecond) {
            LOGIN_MODAL.missSecondStage();
            assertTrue(HEADER.w_HeaderEnter_invisibility(10), "одним этапом не зарегались под" + " " + mail);
        }
    }

    public void secondStageRega(String mail, String pass, String name, String secondName, String phone, boolean missingSecond) {
        this.firstStageRega(mail, pass, missingSecond);
        if (!missingSecond) {
            this.sendUserInfoSecondStage(name, secondName, phone);
            LOGIN_MODAL.pressButtonRegSecondStage();
        }
        assertTrue(HEADER.w_HeaderEnter_invisibility(10), "не зарегались под" + " " + mail);
    }

    public void accControlAfterRega(String savedMail, String savedName, String savedPhone) {
        assertTrue(ACC_PERSON.w_Title_Personal_contains(10), "ЛК не перешли в личные данные");
        assertTrue(ACC_PERSON.w_AccountPersonalInputName_attrvalue(5, "value", savedName),
                "ЛК: не соответствует или не сохранено имя - "
                + ACC_PERSON.getSavedName() + " вместо " + savedName);
        if (!savedPhone.equals("")) {
            assertTrue(ACC_PERSON.w_AccountPersonalInputPhone_attrvalue(5, "value", savedPhone),
                    "ЛК: не соответствует или не сохранен телефон - "
                    + ACC_PERSON.getSavedPhone() + " вместо " + savedPhone);
        }
        assertTrue(ACC_PERSON.getSavedMail(savedMail), "ЛК: не соответствует или не сохранен е-майл");
    }

    public void deleteAccount(String mail) {
        ACC_PERSON.clickAccDelete();
        ACC_PERSON.clickButtonAccDelete();
        ACC_PERSON.clickConfirmButtonAccDeleteAndAlertAccept();
        assertTrue(HEADER.w_HeaderEnter_visibility(7), "не удален аккаунт - " + mail);
    }
}
