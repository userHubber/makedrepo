package kng.objects;

import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_AccPersonal extends Waitings {

    private final WebDriver OBJECTWD;

    public Obj_AccPersonal(WebDriver wd) {
        super(wd);
        OBJECTWD = wd;
        PageFactory.initElements(wd, this);
    }
//Title==============================================================
    private static final String TITLE_PERSONAL = "Личные данные";

//Strings==========================================================
    private static final String EMAIL = "//*[@id=\"personal-data-form\"]//label[@class='control-label']";//e-mail в личных данных аккаунта
    private static final String INPUTNAME = "personal-data__name";//input Ваше имя
    private static final String ACCOUNT_DELETE = "Удалить аккаунт";
    private static final String INPUT_BIRSTHDAY = "personal-data__birthday";//input birthday
    private static final String INPUT_PHONE = "personal-data__phone";//input phone
    private static final String CHECK_SEX_MALE = "//*[@id=\"personal-data-form\"]//label[class='form-group-sex__label']";
    private static final String ACC_DELETE_BUTTON = "//a[text()='Хочу удалить аккаунт с сайта']";
    private static final String ACC_DELETE_CONFIRM_BUTTON = "//button[text()='Подтверждаю полное удаление']";

//By==========================================================    
    private final By $ACCOUNT_PERSONAL_INPUTNAME = By.id(INPUTNAME);//input Ваше имя
    private final By $ACCOUNT_PERSONAL_INPUT_PHONE = By.id(INPUT_PHONE);//input phone

//Find=================================================================
    @FindBy(xpath = EMAIL)
    private WebElement email;

    @FindBy(id = INPUTNAME)
    private WebElement inputname;

    @FindBy(partialLinkText = ACCOUNT_DELETE)
    private WebElement account_delete;

    @FindBy(xpath = ACC_DELETE_BUTTON)
    private WebElement acc_delete_button;

    @FindBy(xpath = ACC_DELETE_CONFIRM_BUTTON)
    private WebElement acc_delete_confirm_button;

    @FindBy(id = INPUT_BIRSTHDAY)
    private WebElement input_birsthday;

    @FindBy(id = INPUT_PHONE)
    private WebElement input_phone;

    @FindBy(xpath = CHECK_SEX_MALE)
    private WebElement check_sex_male;

//=======================================================================
    public boolean w_Title_Personal_contains(int time) {
        return super.titleContains(time, TITLE_PERSONAL);
    }

    public boolean w_AccountPersonalInputPhone_attrvalue(int time, String attr, String value) {
        return super.attributeContains(time, attr, value, $ACCOUNT_PERSONAL_INPUT_PHONE);
    }

    public boolean w_AccountPersonalInputName_attrvalue(int time, String attr, String value) {
        return super.attributeContains(time, attr, value, $ACCOUNT_PERSONAL_INPUTNAME);
    }

    public boolean getSavedMail(String savedMail) {
        return email.getText().contains(savedMail);
    }

    public String getSavedName() {
        return inputname.getAttribute("value");
    }

    public String getSavedPhone() {
        return input_phone.getAttribute("value");
    }

    public void clickAccDelete() {
        account_delete.click();
    }

    public void clickButtonAccDelete() {
        acc_delete_button.click();
    }

    public void clickConfirmButtonAccDeleteAndAlertAccept() {
        acc_delete_confirm_button.click();
        OBJECTWD.switchTo().alert().accept();
    }

}
