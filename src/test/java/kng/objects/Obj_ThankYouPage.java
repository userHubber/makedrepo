package kng.objects;

import kng.helpers.Waitings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_ThankYouPage extends Waitings {

    public Obj_ThankYouPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

//String-----------------------------------------------------------
    private static final String ORDER_PRICE = "*//div[@class='price']//span";
    private static final String CONTACT_INFO_IN_TABLE = "*//div[@class='block one']";
    private static final String TRANSITION_IN_ORDER_FROM_NUMBER_HREF = "*//div[@class='flex-item']//a";
    private static final String DATE_DELIVERY = "*//div[@class='flex-container delivery-info bordered']//*[@class='nowrap']";

//find--------------------------------------------------------------
    @FindBy(xpath = ORDER_PRICE)
    private WebElement order_price;

    @FindBy(xpath = CONTACT_INFO_IN_TABLE)
    private WebElement contact_Info_In_Table;

    @FindBy(xpath = TRANSITION_IN_ORDER_FROM_NUMBER_HREF)
    private WebElement order_number_to_transition_in_order;

    @FindBy(xpath = DATE_DELIVERY)
    private WebElement date_delivery;

//======================================================================
    public boolean w_ConfirmPage_acrossUrlMatches(int time) {
        return super.urlMatches(time, "[0-9]+");
    }

    public boolean w_ConfirmPage_urlContains(int time) {
        return super.urlMatches(time, "confirmation");
    }

    public String confirmContactInfoTableContain() {
        return contact_Info_In_Table.getText();
    }

    public int getOrderPriceConfirmPage() {
        return Integer.parseInt(order_price.getText().replaceAll("\\s+", ""));
    }

    public String transitionToOrderFromConfirm() {
        return order_number_to_transition_in_order.getAttribute("href");
    }

    public String getOrderDateDelivery() {
        return date_delivery.getText();
    }
}
