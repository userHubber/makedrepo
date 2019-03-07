package kng.objects;

import kng.helpers.Roboto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import org.openqa.selenium.WebDriverException;

public class Obj_SmsService extends Waitings {

    private final Roboto ROBBY;
    private static int kngSmsFields;
//-----------------------------------------------------

    public Obj_SmsService(WebDriver wd) {
        super(wd);
        ROBBY = new Roboto();
        PageFactory.initElements(wd, this);
    }
//String-----------------------------------------------------------
    private static final String SMS_ONLINE_KUPIVIP_CODE = "//*[@id=\"chat2\"]//p[@class='nomer' and text()='KUPIVIP.RU']/following-sibling ::*";
    private static final String FIRST_PHONE = "//*[@id=\"telephone1\"]/option[1]";
    private static final String ONLINE_SERVICE = "//h1[@class='contact' and text()='Виртуальные номера']";

//By---------------------------------------------------------------    
    private final By $ONLINE_SERVICE = By.xpath(ONLINE_SERVICE);
    private final By $SMS_ONLINE_KUPIVIP_CODE = By.xpath(SMS_ONLINE_KUPIVIP_CODE);
//Find-----------------------------------------------------------
    @FindBy(xpath = SMS_ONLINE_KUPIVIP_CODE)
    private WebElement sms_online_kupivip_code;

    @FindBy(xpath = FIRST_PHONE)
    private WebElement first_phone;
//===================================================================

    public boolean w_controlAvailableService_visibility() {
        return super.visibility(7, $ONLINE_SERVICE);
    }

    public String getTextSms() {
        int k = kngSmsFields;
        int j;
        for (int i = 0; i < 12; i++) {
            ROBBY.rob.delay(3000);
            j = this.getAllKupivipSmsCount();
            if (j > k) {
                return sms_online_kupivip_code.getText().replaceAll("[^0-9]", "");
            }
        }
        return null;
    }

    public String getPhone() {
        kngSmsFields = this.getAllKupivipSmsCount();
        return first_phone.getText().replaceAll("[^0-9]", "").substring(1);
    }

    private int getAllKupivipSmsCount() {
        ArrayList<WebElement> allSmsKngFields = new ArrayList<>();
        try {
            allSmsKngFields.addAll(sms_online_kupivip_code.findElements($SMS_ONLINE_KUPIVIP_CODE));
            return allSmsKngFields.size();
        } catch (WebDriverException ignore) {
        }
        return 0;
    }

}
