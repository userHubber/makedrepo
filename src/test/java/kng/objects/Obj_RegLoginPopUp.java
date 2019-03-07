package kng.objects;

import kng.helpers.Roboto;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_RegLoginPopUp extends Waitings {

    private final Roboto ROB;

    public Obj_RegLoginPopUp(WebDriver wd) {
        super(wd);
        ROB = new Roboto();
        PageFactory.initElements(wd, this);
    }
//Strings==========================================================
//modalForm--------------------------------------------    
    private static final String LOGIN_MODAL = "//*[@id=\"authorization-new\"]//div[@class='modal-content']";
    private static final String LOGIN_MODAL_FAVOR_MESSAGE = "//*[@id=\"login-pane\"]//div[text()="
            + "'Чтобы добавить товар в избранное, авторизуйтесь или зарегистрируйтесь']";
    private static final String LOGIN_MODAL_BRAND_SUBSCRIBE_MESSAGE = "//*[@id=\"login-pane\"]//div[text()="
            + "'Чтобы подписаться на бренд, авторизуйтесь или зарегистрируйтесь']";
    private static final String LOGIN_MODAL_REVIEW_MESSAGE = "//*[@id=\"login-pane\"]//div[text()="
            + "'Войдите или зарегистрируйтесь для того чтобы написать отзыв']";

//PopUpLogin-----------------------------------------------
    private static final String LOGIN_INPUT_MAIL = "user-name";
    private static final String LOGIN_INPUT_PASSWORD = "password";//поле пароль
    private static final String LOGIN_BUTTON = "login-submit";//кнопка войти 
    //recapcha ошибка превышения попыток
    private static final String LOGIN_CAPTCHA_ERROR = "//*[@id=\"login-pane\"]//div[contains(@class, 'error')"
            + "and normalize-space(text())='Превышен лимит попыток, введите reCAPTCHA']";
//PopUpRegFirstStage----------------------------------------  
    //вкладка регистрация 
    private static final String REG_FIRST_STAGE_INSERT_REGISTRATION = "//*[@id=\"authorization-new\"]//a[text()='Регистрация']";
    private static final String REG_FIRST_STAGE_CHECKBOX_AGREEMENT = "//*[@id=\"registration-pane\"]//input[@type='checkbox']";
    private static final String REG_FIRST_STAGE_BUTTON = "//*[@id=\"registration-pane\"]//button";
    private static final String REG_FIRST_STAGE_INPUTEMAIL = "email";
    private static final String REG_FIRST_STAGE_INPUTPASSWORD = "pw";
//PopUpRegSecondStage---------------------------------------
    private static final String REG_SECOND_STAGE_INPUT_NAME = "registration-step2-name";
    private static final String REG_SECOND_STAGE_INPUT_SECONDNAME = "registration-step2_lastname";
    private static final String REG_SECOND_STAGE_INPUT_PHONE = "registration-phone";
    private static final String REG_SECOND_STAGE_CHECKBOX_SEX_MALE = "//*[@id=\"registration2-pane\"]/div//label[@for='registration-sex1']";
    private static final String REG_SECOND_STAGE_BUTTON = "register-step2";
    //кнопка Пропустить в форме реги
    private static final String REG_SECOND_STAGE_MISSING_BUTTON = "//button[@class='button-inline'and text()='Пропустить']";
    private static final String REG_SECOND_STAGE_BIRTHLIST_DAY = "birth-day";//drop-down B.Day  
    private static final String REG_SECOND_STAGE_BIRTHLIST_MONTH = "birth-month";//drop-down B.Month    
    private static final String REG_SECOND_STAGE_BIRTHLIST_YEAR = "birth-year";//drop-down B.Year

//By=============================================================================
    private final By $LOGIN_MODAL = By.xpath(LOGIN_MODAL);
    private final By $LOGIN_MODAL_FAVOR_MESSAGE = By.xpath(LOGIN_MODAL_FAVOR_MESSAGE);
    private final By $LOGIN_MODAL_BRAND_SUBSCRIBE_MESSAGE = By.xpath(LOGIN_MODAL_BRAND_SUBSCRIBE_MESSAGE);
    private final By $LOGIN_MODAL_REVIEW_MESSAGE = By.xpath(LOGIN_MODAL_REVIEW_MESSAGE);
    private final By $LOGIN_CAPTCHA_ERROR = By.xpath(LOGIN_CAPTCHA_ERROR);
    private final By $REG_SECOND_STAGE_BUTTON = By.id(REG_SECOND_STAGE_BUTTON);

//Finds---------------------------------------------------------------------------------
//modalForm
    @FindBy(xpath = LOGIN_MODAL)
    private WebElement login_modal;

//login
    @FindBy(id = LOGIN_INPUT_MAIL)
    private WebElement login_input_mail;

    @FindBy(id = LOGIN_INPUT_PASSWORD)
    private WebElement login_input_password;

    @FindBy(id = LOGIN_BUTTON)
    private WebElement login_button;

    @FindBy(xpath = LOGIN_CAPTCHA_ERROR)
    private WebElement login_captcha_error;

//firstStage    
    @FindBy(xpath = REG_FIRST_STAGE_INSERT_REGISTRATION)
    private WebElement reg_first_stage_insert_registration;

    @FindBy(xpath = REG_FIRST_STAGE_CHECKBOX_AGREEMENT)
    private WebElement reg_first_stage_checkbox_agreement;

    @FindBy(xpath = REG_FIRST_STAGE_BUTTON)
    private WebElement reg_first_stage_button;

    @FindBy(id = REG_FIRST_STAGE_INPUTEMAIL)
    private WebElement reg_first_stage_inputemail;

    @FindBy(id = REG_FIRST_STAGE_INPUTPASSWORD)
    private WebElement reg_first_stage_inputpassword;

//secondStage
    @FindBy(id = REG_SECOND_STAGE_INPUT_NAME)
    private WebElement reg_second_stage_input_name;

    @FindBy(id = REG_SECOND_STAGE_INPUT_SECONDNAME)
    private WebElement reg_second_stage_input_secondname;

    @FindBy(id = REG_SECOND_STAGE_INPUT_PHONE)
    private WebElement reg_second_stage_input_phone;

    @FindBy(id = REG_SECOND_STAGE_CHECKBOX_SEX_MALE)
    private WebElement reg_second_stage_checkbox_sex_male;

    @FindBy(id = REG_SECOND_STAGE_BUTTON)
    private WebElement reg_second_stage_button;

    @FindBy(xpath = REG_SECOND_STAGE_MISSING_BUTTON)
    private WebElement reg_second_stage_missing_button;

    @FindBy(id = REG_SECOND_STAGE_BIRTHLIST_DAY)
    private WebElement reg_second_stage_birthlist_day;

    @FindBy(id = REG_SECOND_STAGE_BIRTHLIST_MONTH)
    private WebElement reg_second_stage_birthlist_month;

    @FindBy(id = REG_SECOND_STAGE_BIRTHLIST_YEAR)
    private WebElement reg_second_stage_birthlist_year;
//====================================================================================================

//Autorisation===================================================================================================
    public void pressLoginButton() {
        login_button.click();
    }

    public void sendMailLogin(String name) {
        login_input_mail.clear();
        login_input_mail.sendKeys(name);
    }

    public void sendPassLogin(String pass) {
        login_input_password.clear();
        login_input_password.sendKeys(pass);
    }

//Registration==============================================================================
    public boolean w_LoginModalReviewMessage_visibility(int time) {
        return super.visibility(time, $LOGIN_MODAL_REVIEW_MESSAGE);
    }

    public boolean w_LoginModalBrandSubscribeMessage_visibility(int time) {
        return super.visibility(time, $LOGIN_MODAL_BRAND_SUBSCRIBE_MESSAGE);
    }

    public boolean w_LoginModalFavorMessage_visibility(int time) {
        return super.visibility(time, $LOGIN_MODAL_FAVOR_MESSAGE);
    }

    public boolean w_LoginModal_visibility(int time) {
        return super.visibility(time, $LOGIN_MODAL);
    }

    public boolean w_RegSecondStageButton_visibility(int time) {
        return super.visibility(time, $REG_SECOND_STAGE_BUTTON);
    }
    
    public boolean w_CaptchaError_visibility(int time) {
        return super.visibility(time, $LOGIN_CAPTCHA_ERROR);
    }

    public boolean w_RegSecondStageButton_invisibility(int time) {
        return super.invisibility(time, $REG_SECOND_STAGE_BUTTON);
    }

    public void clickInsertRegistration() {
        reg_first_stage_insert_registration.click();
    }

    public void clickOferta() {
        reg_first_stage_checkbox_agreement.click();
    }

    public void pressButtonRegFirsStage() {
        reg_first_stage_button.click();
        ROB.rob.delay(500);
    }

    public void sendMailReg(String mail) {
        reg_first_stage_inputemail.clear();
        reg_first_stage_inputemail.sendKeys(mail);
    }

    public void sendPassReg(String pass) {
        reg_first_stage_inputpassword.clear();
        reg_first_stage_inputpassword.sendKeys(pass);
    }

    public void missSecondStage() {
        reg_second_stage_missing_button.click();
    }

    public void sendName(String name) {
        reg_second_stage_input_name.clear();
        reg_second_stage_input_name.sendKeys(name);
    }

    public void sendSecondName(String secondName) {
        reg_second_stage_input_secondname.clear();
        reg_second_stage_input_secondname.sendKeys(secondName);
    }

    public void sendPhone(String phone) {
        reg_second_stage_input_phone.clear();
        reg_second_stage_input_phone.sendKeys(phone);
    }

    public void pressButtonRegSecondStage() {
        reg_second_stage_button.click();
    }
}
