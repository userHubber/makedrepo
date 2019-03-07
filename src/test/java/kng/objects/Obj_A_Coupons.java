package kng.objects;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import kng.helpers.Roboto;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_A_Coupons extends Waitings {

    private final WebDriver OBJECT_WD;
    private final Roboto ROBBY;

    public Obj_A_Coupons(WebDriver wd) {
        super(wd);
        OBJECT_WD = wd;
        ROBBY = new Roboto();
        PageFactory.initElements(wd, this);
    }
//====================================================================
//dinamyc-------------------------------------------------

    public ArrayList<String> getCreatedCouponTableContain() {
        ArrayList<WebElement> createdCouponTable = new ArrayList<>();
        ArrayList<String> containsTab = new ArrayList<>();
        createdCouponTable.addAll($CREATED_COUPON_TABLE.findElements(OBJECT_WD));
        for (WebElement tablelocks : createdCouponTable) {
            containsTab.add(tablelocks.getText());
        }
        return containsTab;
    }

//String-------------------------------------------------
    private static final String PAGE_ALL_CREATE_NEW_DISPOSABLE_COUPON_BUTTON = "//div[@class='btn-group']//a[text()='Новый одноразовый промокод']";
    private static final String PAGE_ALL_CREATE_NEW_REUSABLE_COUPON_BUTTON = "//div[@class='btn-group']//a[text()='Новый многоразовый промокод']";
    private static final String DISPOSABLE_COUPON_LIST_FIELD = "//*[@id=\"type\"]";
    private static final String REUSABLE_COUPON_LIST_FIELD = "//*[@id=\"couponType\"]";
    private static final String DISPOSABLE_COUPON_TYPE_DROP_LIST = "//*[@id=\"type\"]/option[@value]";
    private static final String REUSABLE_COUPON_TYPE_DROP_LIST = "//*[@id=\"couponType\"]/option[@value]";
    private static final String COST_CENTRE_LIST_FIELD = "//*[@id=\"costCentre\"]";
    private static final String COST_CENTRE_DROP_LIST = "//*[@id=\"costCentre\"]/option[@value]";
    private static final String TIME_START_INPUT = "//*[@id=\"start\"]";
    private static final String TIME_END_INPUT = "//*[@id=\"end\"]";
    private static final String COVERAGE_INPUT = "//*[@id=\"coverage\"]";
    private static final String DISPOSABLE_NOMINAL_INPUT = "//*[@id=\"initialValue\"]";
    private static final String REUSABLE_NOMINAL_INPUT = "//*[@id=\"bonusAmount\"]";
    private static final String USER_DESCRIPTION_INPUT = "//*[@id=\"description\"]";
    private static final String COMMENT_INPUT = "//*[@id=\"comment\"]";
    private static final String COUNT_INPUT = "//*[@id=\"count\"]";
    private static final String PREFIX_INPUT = "//*[@id=\"prefix\"]";
    private static final String SUFFIX_INPUT = "//*[@id=\"suffix\"]";
    private static final String LENGTH_INPUT = "//*[@id=\"length\"]";
    private static final String REUSABLE_PROMO_CODE_INPUT = "//*[@id=\"value\"]";
    private static final String CREATE_DISPOSABLE_COUPON_BUTTON = "//button[text()='Создать купоны с промокодами']";
    private static final String CREATE_REUSABLE_COUPON_BUTTON = "//button[text()='Создать промокод']";
    private static final String PREFIX_EMPTY_ERROR = "//p[text()='Длинна префикса не может быть менее 3 символов.']";
    private static final String PREFIX_INCORRECT_ERROR = "//p[text()='Префикс содержит некорректные символы.']";
    private static final String SUFFIX_INCORRECT_ERROR = "//p[text()='Суффикс содержит некорректные символы.']";
    private static final String CREATED_COUPON_TABLE = "//table//tbody//td";
//By--------------------------------------------------------------------
    private final By $DISPOSABLE_COUPON_TYPE_DROP_LIST = By.xpath(DISPOSABLE_COUPON_TYPE_DROP_LIST);
    private final By $REUSABLE_COUPON_TYPE_DROP_LIST = By.xpath(REUSABLE_COUPON_TYPE_DROP_LIST);
    private final By $COST_CENTRE_DROP_LIST = By.xpath(COST_CENTRE_DROP_LIST);
    private final By $PREFIX_EMPTY_ERROR = By.xpath(PREFIX_EMPTY_ERROR);
    private final By $PREFIX_INCORRECT_ERROR = By.xpath(PREFIX_INCORRECT_ERROR);
    private final By $SUFFIX_INCORRECT_ERROR = By.xpath(SUFFIX_INCORRECT_ERROR);
    private final By $CREATED_COUPON_TABLE = By.xpath(CREATED_COUPON_TABLE);

//Finding----------------------------------------------------------------
    @FindBy(xpath = PAGE_ALL_CREATE_NEW_DISPOSABLE_COUPON_BUTTON)
    private WebElement create_new_disposable_coupon_button;

    @FindBy(xpath = PAGE_ALL_CREATE_NEW_REUSABLE_COUPON_BUTTON)
    private WebElement page_all_create_new_reusable_coupon_button;

    @FindBy(xpath = DISPOSABLE_COUPON_TYPE_DROP_LIST)
    private WebElement disposable_coupon_type_drop_list;

    @FindBy(xpath = REUSABLE_COUPON_TYPE_DROP_LIST)
    private WebElement reusable_coupon_type_drop_list;

    @FindBy(xpath = DISPOSABLE_COUPON_LIST_FIELD)
    private WebElement disposable_coupon_list_field;

    @FindBy(xpath = REUSABLE_COUPON_LIST_FIELD)
    private WebElement reusable_coupon_list_field;

    @FindBy(xpath = COST_CENTRE_LIST_FIELD)
    private WebElement cost_centre_list_field;

    @FindBy(xpath = COST_CENTRE_DROP_LIST)
    private WebElement cost_centre_drop_list;

    @FindBy(xpath = TIME_START_INPUT)
    private WebElement time_start_input;

    @FindBy(xpath = TIME_END_INPUT)
    private WebElement time_end_input;

    @FindBy(xpath = COVERAGE_INPUT)
    private WebElement coverage_input;

    @FindBy(xpath = DISPOSABLE_NOMINAL_INPUT)
    private WebElement disposable_nominal_input;

    @FindBy(xpath = REUSABLE_NOMINAL_INPUT)
    private WebElement reusable_nominal_input;

    @FindBy(xpath = USER_DESCRIPTION_INPUT)
    private WebElement userDescription_input;

    @FindBy(xpath = COMMENT_INPUT)
    private WebElement comment_input;

    @FindBy(xpath = COUNT_INPUT)
    private WebElement count_input;

    @FindBy(xpath = PREFIX_INPUT)
    private WebElement prefix_input;

    @FindBy(xpath = LENGTH_INPUT)
    private WebElement length_input;

    @FindBy(xpath = SUFFIX_INPUT)
    private WebElement suffix_input;

    @FindBy(xpath = REUSABLE_PROMO_CODE_INPUT)
    private WebElement reusable_promo_code_input;

    @FindBy(xpath = CREATE_DISPOSABLE_COUPON_BUTTON)
    private WebElement create_disposable_coupon_button;

    @FindBy(xpath = CREATE_REUSABLE_COUPON_BUTTON)
    private WebElement create_reusable_coupon_button;

//===========================================================================
    public void clickCreateDisposableCouponButton() {
        create_disposable_coupon_button.click();
    }

    public void clickCreateReusableCouponButton() {
        create_reusable_coupon_button.click();
    }

    public void sendCouponSuffix(String suffix) {
        suffix_input.clear();
        suffix_input.sendKeys(suffix);
    }

    public void sendCouponPrefix(String prefix) {
        prefix_input.clear();
        prefix_input.sendKeys(prefix);
    }

    public void sendCouponLength(String length) {
        length_input.clear();
        length_input.sendKeys(length);
    }

    public void sendCouponCount(String number) {
        count_input.clear();
        count_input.sendKeys(number);
    }

    public void sendComment(String comment) {
        comment_input.clear();
        comment_input.sendKeys(comment);
    }

    public void sendUserDescription(String description) {
        userDescription_input.clear();
        userDescription_input.sendKeys(description);
    }

    public void sendNominalDisposableCoupon(String nominlValue) {
        disposable_nominal_input.clear();
        disposable_nominal_input.sendKeys(nominlValue);
    }

    public void sendNominalReusableCoupon(String nominlValue) {
        reusable_nominal_input.clear();
        reusable_nominal_input.sendKeys(nominlValue);
    }

    public void sendCoveragePercent(String percent) {
        coverage_input.clear();
        coverage_input.sendKeys(percent);
    }

    public void sendEndTime(String time) {
        time_end_input.click();
        time_end_input.sendKeys(time);
        ROBBY.rob.keyPress(KeyEvent.VK_TAB);
        ROBBY.rob.keyPress(KeyEvent.VK_0);
        ROBBY.rob.keyPress(KeyEvent.VK_TAB);
        ROBBY.rob.keyPress(KeyEvent.VK_0);
        ROBBY.rob.keyRelease(KeyEvent.VK_0);
    }

    public void sendStartTime(String time) {
        time_start_input.click();
        time_start_input.sendKeys(time);
        ROBBY.rob.keyPress(KeyEvent.VK_TAB);
        ROBBY.rob.keyPress(KeyEvent.VK_0);
        ROBBY.rob.keyPress(KeyEvent.VK_TAB);
        ROBBY.rob.keyPress(KeyEvent.VK_0);
        ROBBY.rob.keyRelease(KeyEvent.VK_0);
    }

    public void clickNewDisposableCouponButton() {
        create_new_disposable_coupon_button.click();
    }

    public void clickNewReusableCouponButton() {
        page_all_create_new_reusable_coupon_button.click();
    }

    public void selectReusableCouponType(String couponType) {
        reusable_coupon_list_field.click();
        ArrayList<WebElement> dropList = (ArrayList<WebElement>) reusable_coupon_type_drop_list.findElements($REUSABLE_COUPON_TYPE_DROP_LIST);
        for (WebElement type : dropList) {
            if (type.getText().equals(couponType)) {
                type.click();
            }
        }
    }

    public void selectDisposableCouponType(String couponType) {
        disposable_coupon_list_field.click();
        ArrayList<WebElement> dropList = (ArrayList<WebElement>) disposable_coupon_type_drop_list.findElements($DISPOSABLE_COUPON_TYPE_DROP_LIST);
        for (WebElement type : dropList) {
            if (type.getText().equals(couponType)) {
                type.click();
            }
        }
    }

    public void selectCostCentre(String costType) {
        cost_centre_list_field.click();
        ArrayList<WebElement> dropList = (ArrayList<WebElement>) cost_centre_drop_list.findElements($COST_CENTRE_DROP_LIST);
        for (WebElement type : dropList) {
            if (type.getText().equals(costType)) {
                type.click();
            }
        }
    }

    public void sendReusablePromoCodeToInput(String couponCode) {
        reusable_promo_code_input.clear();
        reusable_promo_code_input.sendKeys(couponCode);
    }

    public boolean w_PrefixEmptyError_visibility(int time) {
        return super.visibility(time, $PREFIX_EMPTY_ERROR);
    }

    public boolean w_PrefixIncorrectError_visibility(int time) {
        return super.visibility(time, $PREFIX_INCORRECT_ERROR);
    }

    public boolean w_SuffixIncorrectError_visibility(int time) {
        return super.visibility(time, $SUFFIX_INCORRECT_ERROR);
    }
}
