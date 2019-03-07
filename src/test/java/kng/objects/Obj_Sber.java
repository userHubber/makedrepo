package kng.objects;

import kng.helpers.Roboto;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_Sber extends Waitings {

    private final Roboto ROBBY;

    public Obj_Sber(WebDriver wd) {
        super(wd);
        ROBBY = new Roboto();
        PageFactory.initElements(wd, this);
    }
    //String-----------------------------------------------------------------------------
    private static final String ORDER_NUMBER = "orderNumber";
    private static final String ORDER_AMOUNT = "amount";

    private static final String FIELD_CARD_NUMBER = "iPAN_sub";
    private static final String FIELD_CARD_VALIDATION = "year-validation";
    private static final String FIELD_CARD_NAME = "iTEXT";
    private static final String FIELD_CARD_CVC = "iCVC";

    //By-----------------------------------------------------------------------------
    private final By $FIELD_CARD_NUMBER = By.id(FIELD_CARD_NUMBER);//сумма заказа 
    private final By $FIELD_CARD_VALIDATION = By.id(FIELD_CARD_VALIDATION);//сумма заказа 
    private final By $FIELD_CARD_NAME = By.id(FIELD_CARD_NAME);//сумма заказа 
    private final By $FIELD_CARD_CVC = By.id(FIELD_CARD_CVC);//сумма заказа 

    //Find-----------------------------------------------------------------------------
    @FindBy(id = ORDER_NUMBER)
    private WebElement order_number;

    @FindBy(id = ORDER_AMOUNT)
    private WebElement order_amount;

//=================================================================================   
    public boolean w_FieldCardNumber_visibility(int time) {
        return super.visibility(time, $FIELD_CARD_NUMBER);
    }

    public boolean w_FieldCardValidation_visibility(int time) {
        return super.visibility(time, $FIELD_CARD_VALIDATION);
    }

    public boolean w_FieldCardName_visibility(int time) {
        return super.visibility(time, $FIELD_CARD_NAME);
    }

    public boolean w_FieldCardCvc_visibility(int time) {
        return super.visibility(time, $FIELD_CARD_CVC);
    }

    public String getOrderNumber() {

        String orderNumber = null;

        for (int i = 0; i < 100; i++) {
            orderNumber = order_number.getText();
            ROBBY.rob.delay(100);
            if (!orderNumber.contains("-")) {
                break;
            }
        }
        return orderNumber;
    }

    public String getOrderAmount() {
        String $order_amount = order_amount.getText();
        return $order_amount.substring(0, $order_amount.length() - 7);
    }

}
