package kng.objects;

import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_Eurolanding extends Waitings {

    public Obj_Eurolanding(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }
//==========================================================================
//Title
    private final String TITLE_EUROLANDING = "Паспортные данные";

//String
    private static final String FIRSTNAME = "name";
    private static final String SECONDNAME = "surname";
    private static final String THIRDNAME = "patron";
    private static final String PASSNUM = "passnum";
    private static final String PASSDEPARTMENT = "passdepartment";
    private static final String PASSISSUEDATE = "passdate";
    private static final String BIRTHDAY = "birthday";
    private static final String INN = "inn";
    private static final String LANDING_INN_SUCCES = "//div[@class='success']";
    private static final String LANDING_SUB_BUTTON = "//button[@type='submit']";

//By
    private final By $LANDING_SUB_BUTTON = By.xpath(LANDING_SUB_BUTTON);
    private final By $LANDING_INN_SUCCES = By.xpath(LANDING_INN_SUCCES);

//Find
    @FindBy(id = FIRSTNAME)
    private WebElement firstname;

    @FindBy(id = SECONDNAME)
    private WebElement secondname;

    @FindBy(id = THIRDNAME)
    private WebElement thirdname;

    @FindBy(id = PASSNUM)
    private WebElement passnum;

    @FindBy(id = PASSDEPARTMENT)
    private WebElement passdepartment;

    @FindBy(id = PASSISSUEDATE)
    private WebElement passissuedate;

    @FindBy(id = BIRTHDAY)
    private WebElement birthday;

    @FindBy(id = INN)
    private WebElement inn;

    @FindBy(xpath = LANDING_SUB_BUTTON)
    private WebElement landing_sub_button;
//==================================================================================

    public boolean w_Title_Eurolanding_contains(int time) {
        return super.titleContains(time, TITLE_EUROLANDING);
    }

    public boolean w_LandingSubButton_clickable(int time) {
        return super.clickable(time, $LANDING_SUB_BUTTON);
    }

    public boolean w_LandingInnSucces_presence(int time) {
        return super.presence(time, $LANDING_INN_SUCCES);
    }

    public void sendFirstName(String firstName) {
        firstname.clear();
        firstname.sendKeys(firstName);
    }

    public void sendSecondName(String secondName) {
        secondname.clear();
        secondname.sendKeys(secondName);
    }

    public void sendThirdName(String thirdName) {
        thirdname.clear();
        thirdname.sendKeys(thirdName);
    }

    public void sendPassNum(String passNum) {
        passnum.clear();
        passnum.sendKeys(passNum);
    }

    public void sendPassDepartment(String passDepartment) {
        passdepartment.clear();
        passdepartment.sendKeys(passDepartment);
    }

    public void sendPassIssueDate(String passIssueDate) {
        passissuedate.clear();
        passissuedate.sendKeys(passIssueDate);
    }

    public void sendBirthday(String birthDay) {
        birthday.clear();
        birthday.sendKeys(birthDay);
    }

    public void sendInn(String _inn) {
        inn.clear();
        inn.sendKeys(_inn);
    }

    public void clickSubButton() {
        landing_sub_button.click();
    }
}
