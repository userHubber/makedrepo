package kng.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Obj_A_Retail extends Waitings {

    public Obj_A_Retail(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

//String-----------------------------------------------------------
    private static final String INPUT_MAIL = "//input[@type='email']";//инпут майл
    private static final String INPUT_PHONE = "//input[@type='tel']";//инпут телефон
    private static final String CONFIRM_CHECKBOX = "//input[@type='checkbox']";//инпут чекбокс согласия
    private static final String REGA_BUTTON = "//button[@type='submit']";//кнопка регистрации в форме
    private static final String INPUT_CODE = "//input[@name='code']";//инпут для смс-кода в форме подтверждения
    private static final String CONFIRM_BUTTON = "//button[text()='Подтвердить']";//кнопка в форме подтверждения
    private static final String INCORRECT_CODE_MESSAGE = "//div[@class='error' and text()='Неверный код подтверждения']";//кнопка в форме подтверждения
    private static final String CONFIRM_MESSAGE = "//div[text()='Спасибо, теперь вы зарегистрированы на ']";

//By-----------------------------------------------------------
    private final By $INPUT_CODE = By.xpath(INPUT_CODE);//инпут для смс-кода в форме подтверждения
    //сообщение неверного когда подтверждения
    private final By $INCORRECT_CODE_MESSAGE = By.xpath(INCORRECT_CODE_MESSAGE);
//сообщение подтверждения регистрации
    private final By $CONFIRM_MESSAGE = By.xpath(CONFIRM_MESSAGE);
    //заголовок сервиса, для ожидания

    //Find-----------------------------------------------------------
    @FindBy(xpath = INPUT_MAIL)
    private WebElement input_mail;

    @FindBy(xpath = INPUT_PHONE)
    private WebElement input_phone;

    @FindBy(xpath = CONFIRM_CHECKBOX)
    private WebElement confirm_checkbox;

    @FindBy(xpath = REGA_BUTTON)
    private WebElement rega_button;

    @FindBy(xpath = INPUT_CODE)
    private WebElement input_code;

    @FindBy(xpath = CONFIRM_BUTTON)
    private WebElement confirm_button;
//=============================================================================

    public void sendMail(String mail) {
        input_mail.clear();
        input_mail.sendKeys(mail);
    }

    public void sendPhone(String phone) {
        input_phone.clear();
        input_phone.sendKeys(phone);
    }

    public void sendCode(String codeSms) {
        input_code.clear();
        input_code.sendKeys(codeSms);
    }

    public void clickConfirmCheckbox() {
        confirm_checkbox.click();
    }

    public void clickRegaButton() {
        rega_button.click();
    }

    public void clickConfirmButton() {
        confirm_button.click();
    }

    public boolean w_InputCode_visibility(int time) {
        return super.visibility(time, $INPUT_CODE);
    }

    public boolean w_IncorrectCodeMessage_visibility(int time) {
        return super.visibility(time, $INCORRECT_CODE_MESSAGE);
    }

    public boolean w_ConfirmMessage_visibility(int time) {
        return super.visibility(time, $CONFIRM_MESSAGE);
    }

}
