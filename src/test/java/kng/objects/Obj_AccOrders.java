package kng.objects;

import java.awt.event.KeyEvent;
import kng.helpers.Roboto;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_AccOrders extends Waitings {

    private final Actions ACTIONS;
    private final Roboto ROBBY;
    private final WebDriver OBJECTWD;

    public Obj_AccOrders(WebDriver wd) {
        super(wd);
        ACTIONS = new Actions(wd);
        ROBBY = new Roboto();
        OBJECTWD = wd;
        PageFactory.initElements(wd, this);
    }
//====================================================================
//dinamyc-------------------------------------------------

    private WebElement getOrderPriceInTable(String orderNumber, boolean firstOrder) {

        String orderPrice = null;

        if (firstOrder) {
            orderPrice = "//div[@data-order-id=" + orderNumber + "]//div[@class='order-sum nowrap']/span";
        } else {
            orderPrice = "//div[@data-order-id=" + orderNumber + "]//div[@class='nowrap']/span";
        }
        By $orderPrice = By.xpath(orderPrice);
        return $orderPrice.findElement(OBJECTWD);
    }

//-------------------------------------------------------------------   
    private static final String TITLE_ORDERS = "Заказы";

//String-------------------------------------------------
    private static final String DATE_DELIVERY = "//div[@data-elem='delivery-date-text']";//дата доставки заказа в таблице
    //статус заказа Отменен
    private static final String CANCELED_IN_TABLE = "*//span[@data-status-code='CANCELED' and text()='Отменен']";
    private static final String ORDER_TABLE_CONTAIN = "accounts-blocks";//блок со всеми данными заказа
    //Активные/Все заказы//
    private static final String ORDER_TABLE_HEAD_INSERTS = "//*[@id=\"orders-with-pagination\"]//ul[@class='orders-tabs']";
    private static final String ORDER_PAY_BUTTON = "ОПЛАТИТЬ";//кнопка Оплатиь заказ
    //кнопка Указать дополнительные данные
    private static final String USER_INFO_CLARIFY_BUTTON = "*//a[text()='Указать дополнительные данные']";
    //кнопка Выбрать другую дату
    private static final String ANOTHER_DELIVERY_BUTTON = "//div/button[text()='Изменить дату доставки']";
    //ЛК, заказ: дроп список доступных дат для доставки
    private static final String ANOTHER_DELIVERY_DROP = "//div[@class='delivery-intervals']//select[@data-elem='interval-value']";
    //кнопка Подтвердить выбранный новый интервал
    private static final String ANOTHER_DELIVERY_CONFIRM_BUTTON = "//button[text()='Сохранить']";
    private static final String ORDER_CANCEL_REASON = "cancelReason";//open Drop-list with cause cancel
    private static final String ORDER_CANCEL_CAUSE = "//*[@id=\"cancelReason\"]/option[@value='20_ДРУГОЕ']";//Другое in drop-list
    private static final String ORDER_CANCEL_CONFIRM_BUTTON = "//*[@id=\"order-cancel-form\"]//button[text()='Подтвердить отмену']";
    private static final String ORDER_RETURN_BUTTON = "//div[@class='status-block']//a[text()='ОФОРМИТЬ ВОЗВРАТ']";
    private static final String RETURN_CHECKBOX_ALL_PRODUCT = "//*[@id=\"return-items\"]//div[@class='checkbox']";//чекбокс для выбора всех товаров
    private static final String RETURN_CAUSE_RET_LIST = "cancelReasonSelect_0";//список причин возвр
    private static final String RETURN_INPUT_NAME = "fullName";//поле ФИО
    private static final String RETURN_INPUT_BANK_ACCOUNT = "recipientAccount1";//поле расчетный счет
    private static final String RETURN_INPUT_PRIVATE_ACCOUNT = "recipientAccount2";//поле расчетный счет
    private static final String RETURN_INPUT_CARD_NUM = "cardNumber";//поле номер карты
    private static final String RETURN_INPUT_BIC_BANK = "recipientBank";//поле бик
    private static final String RETURN_WRITE_FORM_BUTTON = "//button[@name='submitForm']";

//By--------------------------------------------------------------------
    private final By $ORDER_TABLE_HEAD_INSERTS = By.xpath(ORDER_TABLE_HEAD_INSERTS);
    //статус заказа Отменен
    private final By $CANCELED_IN_TABLE = By.xpath(CANCELED_IN_TABLE);
    private final By $ORDER_PAY_BUTTON = By.partialLinkText(ORDER_PAY_BUTTON);
    //кнопка Указать дополнительные данные
    private final By $USER_INFO_CLARIFY_BUTTON = By.xpath(USER_INFO_CLARIFY_BUTTON);
    //кнопка Выбрать другую дату
    private final By $ANOTHER_DELIVERY_BUTTON = By.xpath(ANOTHER_DELIVERY_BUTTON);
    //ЛК, заказ: дроп список доступных дат для доставки
    private final By $ANOTHER_DELIVERY_DROP = By.xpath(ANOTHER_DELIVERY_DROP);
    //кнопка Подтвердить выбранный новый интервал
    private final By $ANOTHER_DELIVERY_CONFIRM_BUTTON = By.xpath(ANOTHER_DELIVERY_CONFIRM_BUTTON);
    private final By $ORDER_CANCEL_REASON = By.id(ORDER_CANCEL_REASON);
    private final By $ORDER_CANCEL_CONFIRM_BUTTON = By.xpath(ORDER_CANCEL_CONFIRM_BUTTON);
    private final By $RETURN_CHECKBOX_ALL_PRODUCT = By.xpath(RETURN_CHECKBOX_ALL_PRODUCT);

    //Find---------------------------------------------------------------------------
    @FindBy(xpath = DATE_DELIVERY)
    private WebElement date_delivery;

    @FindBy(className = ORDER_TABLE_CONTAIN)
    private WebElement order_table_contain;

    @FindBy(xpath = ORDER_TABLE_HEAD_INSERTS)
    private WebElement order_table_head_inserts;

    @FindBy(partialLinkText = ORDER_PAY_BUTTON)
    private WebElement order_pay_button;

    @FindBy(xpath = USER_INFO_CLARIFY_BUTTON)
    private WebElement user_info_clarify_button;

    @FindBy(xpath = ANOTHER_DELIVERY_BUTTON)
    private WebElement another_delivery_button;

    @FindBy(xpath = ANOTHER_DELIVERY_DROP)
    private WebElement another_delivery_drop;

    @FindBy(xpath = ANOTHER_DELIVERY_CONFIRM_BUTTON)
    private WebElement another_delivery_confirm_button;

    @FindBy(xpath = ORDER_CANCEL_CONFIRM_BUTTON)
    private WebElement order_cancel_confirm_button;

    @FindBy(xpath = ORDER_CANCEL_CAUSE)
    private WebElement order_cancel_cause;

    @FindBy(id = ORDER_CANCEL_REASON)
    private WebElement order_cancel;

    @FindBy(xpath = ORDER_RETURN_BUTTON)
    private WebElement order_return_button;

    @FindBy(xpath = RETURN_CHECKBOX_ALL_PRODUCT)
    private WebElement return_checkbox_all_product;

    @FindBy(id = RETURN_CAUSE_RET_LIST)
    private WebElement return_cause_ret_list;

    @FindBy(xpath = RETURN_WRITE_FORM_BUTTON)
    private WebElement return_write_form_button;

    @FindBy(id = RETURN_INPUT_NAME)
    private WebElement return_input_name;

    @FindBy(id = RETURN_INPUT_BANK_ACCOUNT)
    private WebElement return_input_bank_account;

    @FindBy(id = RETURN_INPUT_PRIVATE_ACCOUNT)
    private WebElement return_input_private_account;

    @FindBy(id = RETURN_INPUT_CARD_NUM)
    private WebElement return_input_card_num;

    @FindBy(id = RETURN_INPUT_BIC_BANK)
    private WebElement return_input_bic_bank;

    //==================================================================
    public boolean w_Title_Orders_contains(int time) {
        return super.titleContains(time, TITLE_ORDERS);
    }

    public boolean w_ReturnCheckboxAllProduct_clickable(int time) {
        return super.clickable(time, $RETURN_CHECKBOX_ALL_PRODUCT);
    }

    public boolean w_OrderCancelConfirmButton_clickable(int time) {
        return super.clickable(time, $ORDER_CANCEL_CONFIRM_BUTTON);
    }

    public boolean w_OrderCancelReason_visibility(int time) {
        return super.visibility(time, $ORDER_CANCEL_REASON);
    }

    public boolean w_AnotherDeliveryConfirmButton_invisibility(int time) {
        return super.invisibility(time, $ANOTHER_DELIVERY_CONFIRM_BUTTON);
    }

    public boolean w_AnotherDeliveryDrop_visibility(int time) {
        return super.visibility(time, $ANOTHER_DELIVERY_DROP);
    }

    public boolean w_AnotherDeliveryButton_clickable(int time) {
        return super.clickable(time, $ANOTHER_DELIVERY_BUTTON);
    }

    public boolean w_UserInfoClarifyButton_clickable(int time) {
        return super.clickable(time, $USER_INFO_CLARIFY_BUTTON);
    }

    public boolean w_CanceledInTable_presence(int time) {
        return super.presence(time, $CANCELED_IN_TABLE);
    }

    public boolean w_OrderPayButton_visibility(int time) {
        return super.visibility(time, $ORDER_PAY_BUTTON);
    }

    public String getOrderTextContain() {
        return order_table_contain.getText();
    }

    public boolean getOrderHeadersPresence() {

        try {
            order_table_head_inserts.findElement($ORDER_TABLE_HEAD_INSERTS);
            return true;
        } catch (WebDriverException ignored) {
        }
        return false;
    }

    public int getOrderPrice(String orderNumber, boolean firstOrder) {
        int orderPrice = Integer.parseInt(getOrderPriceInTable(orderNumber, firstOrder).getText().replaceAll("\\s", ""));
        return orderPrice;
    }

    public void clickCanceOrder() {
        order_cancel.click();
    }

    public void chooseAnotherCauseCanceOrder() {
        ACTIONS.moveToElement(order_cancel_cause).build().perform();
        order_cancel_cause.click();
    }

    public void clickCanceOrderConfirmButton() {
        order_cancel_confirm_button.click();
    }

    public void clickClarifyButton() {
        user_info_clarify_button.click();
    }

    public String getOrderDateDelivery() {
        return date_delivery.getText();
    }

    public void getClickAnotherDeliveryButton() {
        another_delivery_button.click();
        ROBBY.rob.delay(500);
    }

    public void getAnotherDateFromDrop() {
        ACTIONS.clickAndHold(another_delivery_drop).perform();
        ROBBY.rob.keyPress(KeyEvent.VK_DOWN);
        ROBBY.rob.keyPress(KeyEvent.VK_DOWN);
        ROBBY.rob.keyPress(KeyEvent.VK_ENTER);
        ROBBY.rob.keyRelease(KeyEvent.VK_ENTER);
    }

    public void getClickAnotherDeliveryConfirmButton() {
        another_delivery_confirm_button.click();
    }

    public void getClickToOrderPayButtonButton() {
        order_pay_button.click();
    }

    public void getClickToOrderReturnButton() {
        order_return_button.click();
    }

    public void getClickToReturnCheckboxAllProducts() {
        return_checkbox_all_product.click();
    }

    public void getClickToReturnWriteFormButton() {
        return_write_form_button.click();
    }

    public void getReturnCauseBigSize() {
        ACTIONS.clickAndHold(return_cause_ret_list).perform();
        ROBBY.rob.keyPress(KeyEvent.VK_DOWN);
        ROBBY.rob.keyPress(KeyEvent.VK_ENTER);
        ROBBY.rob.keyRelease(KeyEvent.VK_ENTER);
    }

    public void getReturnCauseCrashProduct() {
        ACTIONS.clickAndHold(return_cause_ret_list).perform();
        for (int i = 0; i < 3; i++) {
            ROBBY.rob.keyPress(KeyEvent.VK_DOWN);
            ROBBY.rob.delay(50);
        }
        ROBBY.rob.keyPress(KeyEvent.VK_ENTER);
        ROBBY.rob.keyRelease(KeyEvent.VK_ENTER);
    }

    public void sendReturnName(String name) {
        return_input_name.clear();
        return_input_name.sendKeys(name);
    }

    public void sendBankAccount(String bankAccount) {
        return_input_bank_account.clear();
        return_input_bank_account.sendKeys(bankAccount);
    }

    public void sendPrivateAccount(String bankAccount) {
        return_input_private_account.clear();
        return_input_private_account.sendKeys(bankAccount);
    }

    public void sendCardNum(String card_num) {
        return_input_card_num.clear();
        return_input_card_num.sendKeys(card_num);
    }

    public void sendReturnBicBank(String bicBank) {
        return_input_bic_bank.clear();
        return_input_bic_bank.sendKeys(bicBank);
    }
}
