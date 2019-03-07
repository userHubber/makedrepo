package kng.objects;

import kng.helpers.Roboto;
import java.awt.event.KeyEvent;
import kng.helpers.Waitings;
import kng.helpers.AdditionalData;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_Checkout extends Waitings {

    private final Roboto ROBBY;
    private final Actions ACTIONS;
    private final AdditionalData A_D;

    public Obj_Checkout(WebDriver wd) {
        super(wd);
        ROBBY = new Roboto();
        ACTIONS = new Actions(wd);
        A_D = new AdditionalData();
        PageFactory.initElements(wd, this);
    }

//String-----------------------------------------------------------------------------
    private static final String NAME = "username";//поле ФИО
    private static final String EMAIL = "emailField";//поле e-mail
    private static final String PHONE = "phoneField";//поле телефон
    private static final String ADRESS = "address_ru";//поле адрес
    private static final String CITY = "cityName";//поле город
    private static final String FLAT = "address-flat";//поле квартира
    private static final String COMMENT = "additionalAddressInfo";//поле комментария к заказу
    private static final String FLAT_PRIVATE = "//*[@id=\"deliveries\"]//label[@for='private-house']";//флаг Частный дом
    private static final String CARD_CHECKBOX = "//div[text()='Картой на сайте ']";//чекбокс оплаты безналом    
    private static final String PICKUP_CHECKBOX = "//*[@id=\"deliveries\"]//label[text()='Самовывоз']";//чекбокс Самовывоз
    private static final String BONUS_CHECKBOX = "//label[normalize-space (text())='Бонусные рубли']";//чекбокс Бонусные рубли
    private static final String BONUS_INPUT = "//input[@name='loyalAmount']";//поле Бонусные рубли    
    private static final String BONUS_BUTTON = "//li[@data-elem='discount-loyal']//button[@class='btn']";//Бонусные рубли, Кнопка применить    
    //Скидка по Бонусным рублям в итоговой таблице - 
    private static final String BONUS_AMOUNT = "//div[@data-field='typedDiscount']";
    //кнопка Магазины Купивип в блоке Самовывоз - 
    private static final String PICKUP_BUTTON_MARKETS = "//*[@id=\"deliveries\"]//label[text()='Все пункты']";
    //адрес выбранного ПВЗ в чекауте в блоке самовывоза -
    private static final String DELIVERY_INTERVAL = "//div[@name='intervals']//select";//интервалы в блоке доставки самовывозом  и летуаль
    private static final String DELIVERY_INTERVAL_DAY = "//div[@name='intervals']//select[@data-elem='interval-date']/option";
    private static final String BUTTON_CREATE_ORDER = "//button[@data-js='process']";//купить\оплатить заказ
    private static final String COUPON_INPUT = "//*[@id=\"form-OTHER\"]//input[@name='code']";//поле промокода
    private static final String COUPON_CHECKBOX = "//*[@id=\"form-OTHER\"]//li[@data-elem='discount-no']//span";
    private static final String ADD_COUPON_BUTTON = "//button[@data-js='promo-input']";//Промокод, Кнопка применить
    private static final String COUPONS_LIST = "//*[@id=\"form-OTHER\"]//select[@name='couponId']";//список активных купонов
    private static final String PRODUCT_PRICE_IN_TABLE = "//td[@class='prices-block']//div[@data-field='price']";//текущая стоимость товара в таблице
    private static final String PRODUCT_TOTAL_SUM = "//div[@data-field='itemsAmount']";//итоговая стоимость товаров под таблицей 
    private static final String ACCUMULATIVE_DISCOUNT = "//div[@data-field='accumulative-discount']";
    //не используется до полного включения KNG-13074 Уменьшить запутанность Итого на чакауте
    private static final String ACCUMULATIVE_AND_COUPON_DISCOUNT = "//div[@data-field='couponAndAccumulativeTotalAmount']";
    private static final String AMOUNT_ORDER = "//div[@data-field='totalAmount']";//Итого к оплате   
    private static final String COUPON_UNDER_INPUT = "//span[@data-field='couponDiscount']";//скидка по купону под полем купона
    private static final String COUPON_DISCOUNT = "//div[@data-field='coupon-discount']";//скидка по купону в таблице под товаром
    private static final String DELIVERY_AMOUNT_IN_FINAL_TABLE = "//div[@data-field='deliveryPrice']";//Стоимость доставки в итоговой таблице
    private static final String PICKUP_ADRESS_IN_DELIVERY_AREA = "//div[@class='checked-view']/p[1]";//выбранный адрес ПВЗ в блокe доставки
    private static final String PICKUP_STORAGE_CONDITION_DELIVERY_AREA = "//div[@class='checked-view']/p[2]";//срок хранения в ПВЗ
    private static final String NO_COUPON_MESSAGE_IN_TABLE = "//section[@class='container']//div[normalize-space (text())='На товары по этой акции купоны и промокоды неприменимы']";
    private static final String ACCUMULATIVE_DISCOUNT_PRODUCT_MESSAGE = "//span[text()='Персональная скидка не применима к этому товару']";
    private static final String ACCUMULATIVE_DISCOUNT_MESSAGE = "//div[text()='Персональная скидка не применима ни к одному из товаров']";
    private static final String BASIC_ERRORS_UNDER_COUPON_FIELD = "//[@data-elem='discounts']//div[@class='error']";
    private static final String ERROR_UNDER_PVZ_FIELD = "//div[normalize-space(text())='Пожалуйста, выберите пункт выдачи']";
    private static final String DELETE_PRODUCT_BUTTON = "//button[@data-js='basket-remove']";
    private static final String ERRORS_OF_REQUIRED_FIELDS = "//div[@class='error']";
    private static final String PRODUCT_INCREMENT_BUTTON = "//button[@data-js='increment']";
    private static final String PRODUCT_DECREMENT_BUTTON = "//button[@data-js='decrement']";
    private static final String PRODUCT_COUNT = "//span[@class='number-control']//input";
    private static final String EURO_MESSAGE_CHOKY_500 = "//p[@data-id='euroMessage']";

//By----------------------------------------------------------------------------------------------------
    private final By $BUTTON_CREATE_ORDER = By.xpath(BUTTON_CREATE_ORDER);
    private final By $ADD_COUPON_BUTTON = By.xpath(ADD_COUPON_BUTTON);
    private final By $COUPON_DISCOUNT = By.xpath(COUPON_DISCOUNT);
    private final By $PICKUP_CHECKBOX = By.xpath(PICKUP_CHECKBOX);
    private final By $ADRESS = By.id(ADRESS);
    private final By $DELIVERY_INTERVAL = By.xpath(DELIVERY_INTERVAL);
    private final By $DELIVERY_INTERVAL_DAY = By.xpath(DELIVERY_INTERVAL_DAY);
    private final By $PICKUP_ADRESS_IN_DELIVERY_AREA = By.xpath(PICKUP_ADRESS_IN_DELIVERY_AREA);
    private final By $PICKUP_STORAGE_CONDITION_DELIVERY_AREA = By.xpath(PICKUP_STORAGE_CONDITION_DELIVERY_AREA);
    private final By $CARD_CHECKBOX = By.xpath(CARD_CHECKBOX);
    private final By $BONUS_CHECKBOX = By.xpath(BONUS_CHECKBOX);
    private final By $BONUS_INPUT = By.xpath(BONUS_INPUT);
    private final By $BONUS_BUTTON = By.xpath(BONUS_BUTTON);
    private final By $BONUS_AMOUNT = By.xpath(BONUS_AMOUNT);
    private final By $ACCUMULATIVE_DISCOUNT = By.xpath(ACCUMULATIVE_DISCOUNT);
    private final By $NO_COUPON_MESSAGE_IN_TABLE = By.xpath(NO_COUPON_MESSAGE_IN_TABLE);
    private final By $BASIC_ERRORS_UNDER_COUPON_FIELD = By.xpath(BASIC_ERRORS_UNDER_COUPON_FIELD);
    private final By $ACCUMULATIVE_DISCOUNT_PRODUCT_MESSAGE = By.xpath(ACCUMULATIVE_DISCOUNT_PRODUCT_MESSAGE);
    private final By $ACCUMULATIVE_DISCOUNT_MESSAGE = By.xpath(ACCUMULATIVE_DISCOUNT_MESSAGE);
    private final By $ERRORS_OF_REQUIRED_FIELDS = By.xpath(ERRORS_OF_REQUIRED_FIELDS);
    private final By $PRODUCT_COUNT = By.xpath(PRODUCT_COUNT);
    private final By $ORDER_AMOUNT = By.xpath(AMOUNT_ORDER);
    private final By $PRODUCT_PRICE_IN_TABLE = By.xpath(PRODUCT_PRICE_IN_TABLE);
    private final By $EURO_MESSAGE_CHOKY_500 = By.xpath(EURO_MESSAGE_CHOKY_500);
    private final By $ERROR_UNDER_PVZ_FIELD = By.xpath(ERROR_UNDER_PVZ_FIELD);

//Find--------------------------------------------------------------------------------------------------
    @FindBy(id = NAME)
    private WebElement name;

    @FindBy(id = EMAIL)
    private WebElement email;

    @FindBy(id = PHONE)
    private WebElement phone;

    @FindBy(id = ADRESS)
    private WebElement adress;

    @FindBy(id = CITY)
    private WebElement city;

    @FindBy(id = FLAT)
    private WebElement flat;

    @FindBy(id = COMMENT)
    private WebElement comment;

    @FindBy(xpath = FLAT_PRIVATE)
    private WebElement flat_private;

    @FindBy(xpath = CARD_CHECKBOX)
    private WebElement card_checkbox;

    @FindBy(xpath = COUPON_CHECKBOX)
    private WebElement coupon_checkbox;

    @FindBy(xpath = PICKUP_CHECKBOX)
    private WebElement pickup_checkbox;

    @FindBy(xpath = BONUS_CHECKBOX)
    private WebElement bonus_checkbox;

    @FindBy(xpath = BONUS_INPUT)
    private WebElement bonus_input;

    @FindBy(xpath = BONUS_BUTTON)
    private WebElement bonus_button;

    @FindBy(xpath = BONUS_AMOUNT)
    private WebElement bonus_amount;

    @FindBy(xpath = ACCUMULATIVE_DISCOUNT)
    private WebElement accumulative_discount;

    @FindBy(xpath = PICKUP_BUTTON_MARKETS)
    private WebElement pickup_button_markets;

    @FindBy(xpath = DELIVERY_INTERVAL)
    private WebElement delivery_interval;

    @FindBy(xpath = DELIVERY_INTERVAL_DAY)
    private WebElement delivery_interval_day;

    @FindBy(xpath = BUTTON_CREATE_ORDER)
    private WebElement button_create_order;

    @FindBy(xpath = COUPON_INPUT)
    private WebElement coupon_input;

    @FindBy(xpath = ADD_COUPON_BUTTON)
    private WebElement add_coupon_button;

    @FindBy(xpath = COUPONS_LIST)
    private WebElement coupons_list;

    @FindBy(xpath = PRODUCT_PRICE_IN_TABLE)
    private WebElement product_price_in_table;

    @FindBy(xpath = PRODUCT_TOTAL_SUM)
    private WebElement product_total_sum;

    @FindBy(xpath = ACCUMULATIVE_AND_COUPON_DISCOUNT)
    private WebElement accumulative_and_coupon_discount;

    @FindBy(xpath = AMOUNT_ORDER)
    private WebElement amount_order;

    @FindBy(xpath = COUPON_UNDER_INPUT)
    private WebElement coupon_under_input;

    @FindBy(xpath = COUPON_DISCOUNT)
    private WebElement coupon_Discount;

    @FindBy(xpath = DELIVERY_AMOUNT_IN_FINAL_TABLE)
    private WebElement delivery_amount_in_final_table;

    @FindBy(xpath = DELETE_PRODUCT_BUTTON)
    private WebElement delete_product_button;

    @FindBy(xpath = ERRORS_OF_REQUIRED_FIELDS)
    private WebElement errors_of_required_fields;

    @FindBy(xpath = PRODUCT_INCREMENT_BUTTON)
    private WebElement product_increment_button;

    @FindBy(xpath = PRODUCT_DECREMENT_BUTTON)
    private WebElement product_decrement_button;

    @FindBy(xpath = PRODUCT_COUNT)
    private WebElement product_count;

//======================================================================
    private boolean enterInputForm(WebElement element, String userInfo) {
        for (int i = 0; i < 10; i++) {
            try {
                element.clear();
                element.sendKeys(userInfo);
                ROBBY.rob.delay(500);
                ROBBY.rob.keyPress(KeyEvent.VK_ENTER);
                ROBBY.rob.keyRelease(KeyEvent.VK_ENTER);
                ROBBY.rob.delay(500);
                return true;
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(1000);
            }
        }
        return false;
    }

//=========================================================================
    public boolean w_Adress_invisibility(int time) {
        return super.invisibility(time, $ADRESS);
    }

    public boolean w_CouponAmount_visibility(int time) {
        return super.visibility(time, $COUPON_DISCOUNT);
    }

    public boolean w_AccumulativeDiscountProductMessage_visibility(int time) {
        return super.visibility(time, $ACCUMULATIVE_DISCOUNT_PRODUCT_MESSAGE);
    }

    public boolean w_AccumulativeDiscountMessage_visibility(int time) {
        return super.visibility(time, $ACCUMULATIVE_DISCOUNT_MESSAGE);
    }

    public boolean w_BonusAmount_visibility(int time) {
        return super.visibility(time, $BONUS_AMOUNT);
    }

    public boolean w_BonusInput_visibility(int time) {
        return super.visibility(time, $BONUS_INPUT);
    }

    public boolean w_PickupAdressInDeliveryArea_visibility(int time) {
        return super.visibility(time, $PICKUP_ADRESS_IN_DELIVERY_AREA);
    }

    public boolean w_PickupStoragConditionInDeliveryArea_visibility(int time) {
        return super.visibility(time, $PICKUP_STORAGE_CONDITION_DELIVERY_AREA);
    }

    public boolean w_PickupCheckbox_clickable(int time) {
        return super.clickable(time, $PICKUP_CHECKBOX);
    }

    public boolean w_BonusButton_clickable(int time) {
        return super.clickable(time, $BONUS_BUTTON);
    }

    public boolean w_BonusCheckbox_clickable(int time) {
        return super.clickable(time, $BONUS_CHECKBOX);
    }

    public boolean w_CardCheckbox_clickable(int time) {
        return super.clickable(time, $CARD_CHECKBOX);
    }

    public boolean w_DeliveryInterval_clickable(int time) {
        return super.clickable(time, $DELIVERY_INTERVAL);
    }

    public boolean w_AddCouponButton_clickable(int time) {
        return super.clickable(time, $ADD_COUPON_BUTTON);
    }

    public boolean w_ButtonCreateOrder_clickable(int time) {
        return super.clickable(time, $BUTTON_CREATE_ORDER);
    }

    public boolean w_AccumulativeDiscount_invisibility(int time) {
        return super.invisibility(time, $ACCUMULATIVE_DISCOUNT);
    }

    public boolean w_NoCouponMessageInTable_visibility(int time) {
        return super.visibility(time, $NO_COUPON_MESSAGE_IN_TABLE);
    }

    public boolean w_CouponDiscount_invisibility(int time) {
        return super.invisibility(time, $COUPON_DISCOUNT);
    }

    public boolean w_BasicErrorsUnderCouponField_visibility(int time) {
        return super.visibility(time, $BASIC_ERRORS_UNDER_COUPON_FIELD);
    }

    public boolean w_EuroMessageChoky500_visibility(int time) {
        return super.visibility(time, $EURO_MESSAGE_CHOKY_500);
    }

    public boolean w_ErrorUnderPvzField_visibility(int time) {
        return super.visibility(time, $ERROR_UNDER_PVZ_FIELD);
    }

    public boolean w_AttributeProductCounting_value(int time, String value) {
        return super.attributeContains(time, "value", value, $PRODUCT_COUNT);
    }

    public boolean w_OrderAmount_toBe(int time, String value) {
        return super.textToBe(time, value, $ORDER_AMOUNT);
    }

    public boolean w_ProductPrice_toBe(int time, String value) {
        return super.textToBe(time, value, $PRODUCT_PRICE_IN_TABLE);
    }

    public boolean addName(String userName) {
        return enterInputForm(name, userName);
    }

    public boolean addMail(String userMail) {
        return enterInputForm(email, userMail);
    }

    public boolean addPhone(String userPhone) {
        return enterInputForm(phone, userPhone);
    }

    public boolean addCity(String userCity) {
        return enterInputForm(city, userCity);
    }

    public boolean addAdress(String userAdress) {
        return enterInputForm(adress, userAdress);
    }

    public boolean addFlat(String userFlat) {
        return enterInputForm(flat, userFlat);
    }

    public boolean addComment(String userComment) {
        return enterInputForm(comment, userComment);
    }

    public boolean addEmptyFlat() {
        for (int i = 0; i < 9; i++) {
            try {
                flat_private.click();
                return true;
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(1000);
            }
        }
        return false;
    }

    public void sendKeysCouponInInput(String coupon) {
        coupon_input.clear();
        coupon_input.sendKeys(coupon);
    }

    public int getCouponDiscount() {
        return Integer.parseInt(coupon_Discount.getText().replaceAll("\\s+", ""));
    }

    public void selectActivedCouponFromDropList(int couponArrangement) {
        coupons_list.click();
        ROBBY.rob.delay(200);
        for (int i = 0; i < couponArrangement; i++) {
            ROBBY.rob.keyPress(KeyEvent.VK_DOWN);
        }
        ROBBY.rob.keyPress(KeyEvent.VK_ENTER);
        ROBBY.rob.keyRelease(KeyEvent.VK_ENTER);
    }

    public int getAccumulativeDiscount() {
        return Integer.parseInt(accumulative_discount.getText().replaceAll("\\s+", ""));
    }

    public void clickAddCouponButton() {
        ROBBY.rob.delay(2000);
        add_coupon_button.click();
    }

    public void clickPickupCheckbox() {
        for (int i = 0; i < 9; i++) {
            try {
                pickup_checkbox.click();
            } catch (WebDriverException ignore) {
                ROBBY.rob.delay(1000);
            }
        }
    }

    public void clickCardCheckbox() {
        card_checkbox.click();
    }

    public void clickCouponCheckbox() {
        coupon_checkbox.click();
    }

    public void clickPickupButton() {
        ROBBY.rob.delay(1000);
        pickup_button_markets.click();
    }

    public void clickBonusCheckbox() {
        bonus_checkbox.click();
    }

    public void sendKeysToBonusInput(String bonusNominal) {
        bonus_input.sendKeys(bonusNominal);
    }

    public void clickBonusButtonConfirm() {
        ROBBY.rob.delay(2000);
        bonus_button.click();

    }

    public String getBonusDiscount() {
        return bonus_amount.getText();
    }

    public String getStringOrderTotalSum() {
        return amount_order.getText();
    }

    public int getOrderTotalSum() {
        return Integer.parseInt(amount_order.getText().replaceAll("\\s+", ""));
    }

    public int getDeliveryAmount() {
        return Integer.parseInt(delivery_amount_in_final_table.getText().replaceAll("\\s+", ""));
    }

    public void selectDeliveryInterval() {
        ACTIONS.clickAndHold(delivery_interval).perform();
        ROBBY.rob.keyPress(KeyEvent.VK_DOWN);
        ROBBY.rob.keyPress(KeyEvent.VK_DOWN);
        ROBBY.rob.keyPress(KeyEvent.VK_ENTER);
        ROBBY.rob.keyRelease(KeyEvent.VK_ENTER);
    }

    public String getRandomSelectedIntervalDateText() {

        ArrayList<WebElement> intervals = new ArrayList<>();
        intervals.addAll(delivery_interval_day.findElements($DELIVERY_INTERVAL_DAY));
        intervals.remove(0);//выберите дату
        int intervalNumber = A_D.getRandomNumeral(intervals.size() - 1);
        ACTIONS.clickAndHold(delivery_interval).perform();
        intervals.get(intervalNumber).click();
        return intervals.get(intervalNumber).getText();
    }

    public ArrayList<String> getIntervalDate() {
        ArrayList<WebElement> intervals = new ArrayList<>();
        ArrayList<String> $intervals = new ArrayList<>();
        intervals.addAll(delivery_interval_day.findElements($DELIVERY_INTERVAL_DAY));
        for (WebElement el : intervals) {
            $intervals.add(el.getText());

        }

        return $intervals;
    }

    public void clickCreateOrderButton() {
        button_create_order.click();
    }

    public void clickDeleteProductButton() {
        delete_product_button.click();
    }

    public void clickProductIncrementButton() {
        product_increment_button.click();
    }

    public void clickProductDecrementButton() {
        product_decrement_button.click();
    }

    public int getProductsTotalSum() {
        return Integer.parseInt(product_total_sum.getText().replaceAll("\\s+", ""));
    }

    public int getProductCount() {
        return Integer.parseInt(product_count.getAttribute("value"));
    }

    public int getProductPriceInTable() {
        return Integer.parseInt(product_price_in_table.getText().replaceAll("\\s", ""));
    }

    public ArrayList<String> getAllErrorsFromRequiredFields() {

        ArrayList<WebElement> error = new ArrayList<>();
        ArrayList<String> errorMes = new ArrayList<>();
        error.addAll(errors_of_required_fields.findElements($ERRORS_OF_REQUIRED_FIELDS));

        for (WebElement $error : error) {
            errorMes.add($error.getText());
        }
        return errorMes;
    }

    public String getAccumulativeAndCouponDiscount() {
        return accumulative_and_coupon_discount.getText();//не используется до полного включения KNG-13074 Уменьшить запутанность Итого на чакауте
    }
}
