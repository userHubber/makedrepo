package kng.objects;

import kng.helpers.Roboto;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_OrderReview extends Waitings {

    private final Roboto ROBBY;

    public Obj_OrderReview(WebDriver wd) {
        super(wd);
        ROBBY = new Roboto();
        PageFactory.initElements(wd, this);
    }
//=================================================================
//Strings-------------------------------------------------------
    private static final String REVIEW_TEXTAREA_FOR_PRODUCT = "//div[@class='message big']//textarea";
    private static final String REVIEW_TEXTAREA_FOR_ORDER = "//div[@class='message']//textarea";
    private static final String CONFIRM_REVIEW_FOR_PRODUCT_BUTTON = "//div[@class='button-block']//div[@class='right']/input";
    private static final String REVIEW_RATING_EXELENT_FOR_PRODUCT = "//div[@class='reviews-block']//form[@enctype='multipart/form-data']//div[@class='rating']//span[1][@class='star']";
    private static final String PRODUCT_REVIEW_RATING_EXELENT_FILL = "//div[@class='reviews-block']//form[@enctype='multipart/form-data']//div[@class='rating']//span[1][@class='star fill']";
    private static final String REVIEW_THANKS_MESSAGE_SUCCES = "//p[text()='Спасибо большое! Отзыв принят на модерацию']";
    private static final String ORDER_REVIEW_FORM_EXPAND_BUTTON = "//div[@class='top-block']//a[@class='reviews-link']";
    private static final String CONFIRM_REVIEW_BUTTON_FOR_ORDER = "//form[@class='revieworder-form']//div[@class='button-block']/input";
    private static final String ERROR_ALL_RATING_EMPTY = "//div[text()='Нет ни одной оценки']";
    private static final String ERROR_CAUSE_EMPTY = "//div[text()='Нужно указать причину отмены']";
    private static final String ERROR_ACCURATE_CAUSE_EMPTY = "//div[text()='Уточните причину отмены']";
    private static final String ERROR_COMMENT_EMPTY = "//div[text()='Пожалуйста, оставьте комментарий']";
    private static final String REVIEW_THIRD_RATING_BAD_FOR_ORDER = "//div[@class='raiting-order']//div[3][@class='item']//div[@class='rating']//span[4][@class='star']";
    private static final String REVIEW_THIRD_RATING_BAD_FOR_ORDER_FILL = "//div[@class='raiting-order']//div[3][@class='item']//div[@class='rating']//span[4][@class='star fill']";
    private static final String REVIEW_FIRST_RATING_EXELENT_FOR_ORDER = "//div[@class='raiting-order']//div[1][@class='item']//div[@class='rating']//span[1][@class='star']";
    private static final String REVIEW_FIRST_RATING_EXELENT_FOR_ORDER_FILL = "//div[@class='raiting-order']//div[1][@class='item']//div[@class='rating']//span[1][@class='star fill']";
    private static final String REVIEW_SECOND_RATING_EXELENT_FOR_ORDER = "//div[@class='raiting-order']//div[2][@class='item']//div[@class='rating']//span[1][@class='star']";
    private static final String REVIEW_SECOND_RATING_EXELENT_FOR_ORDER_FILL = "//div[@class='raiting-order']//div[2][@class='item']//div[@class='rating']//span[1][@class='star fill']";
    private static final String REVIEW_THIRD_RATING_EXELENT_FOR_ORDER = "//div[@class='raiting-order']//div[3][@class='item']//div[@class='rating']//span[1][@class='star']";
    private static final String REVIEW_THIRD_RATING_EXELENT_FOR_ORDER_FILL = "//div[@class='raiting-order']//div[3][@class='item']//div[@class='rating']//span[1][@class='star fill']";
    private static final String REVIEW_SIZE_CAUSE_RADIO_FOR_ORDER = "//div[@class='radio']//label[text()='Проблема с размером']";
    private static final String REVIEW_SMALL_SIZE_CAUSE_RADIO_FOR_ORDER = "//div[@class='radio']//label[text()='Размер мал']";
//By====================================================================
    private final By $REVIEW_THANKS_MESSAGE_SUCCES = By.xpath(REVIEW_THANKS_MESSAGE_SUCCES);
    private final By $PRODUCT_REVIEW_RATING_EXELENT_FILL = By.xpath(PRODUCT_REVIEW_RATING_EXELENT_FILL);
    private final By $REVIEW_FIRST_RATING_EXELENT_FOR_ORDER_FILL = By.xpath(REVIEW_FIRST_RATING_EXELENT_FOR_ORDER_FILL);
    private final By $REVIEW_SECOND_RATING_EXELENT_FOR_ORDER_FILL = By.xpath(REVIEW_SECOND_RATING_EXELENT_FOR_ORDER_FILL);
    private final By $REVIEW_THIRD_RATING_EXELENT_FOR_ORDER_FILL = By.xpath(REVIEW_THIRD_RATING_EXELENT_FOR_ORDER_FILL);
    private final By $ERROR_ALL_RATING_EMPTY = By.xpath(ERROR_ALL_RATING_EMPTY);
    private final By $ERROR_CAUSE_EMPTY = By.xpath(ERROR_CAUSE_EMPTY);
    private final By $ERROR_ACCURATE_CAUSE_EMPTY = By.xpath(ERROR_ACCURATE_CAUSE_EMPTY);
    private final By $ERROR_COMMENT_EMPTY = By.xpath(ERROR_COMMENT_EMPTY);
    private final By $REVIEW_THIRD_RATING_BAD_FOR_ORDER_FILL = By.xpath(REVIEW_THIRD_RATING_BAD_FOR_ORDER_FILL);

//Find============================================================
    @FindBy(xpath = REVIEW_TEXTAREA_FOR_PRODUCT)
    private WebElement product_review_textarea;

    @FindBy(xpath = REVIEW_TEXTAREA_FOR_ORDER)
    private WebElement review_textarea_for_order;

    @FindBy(xpath = CONFIRM_REVIEW_FOR_PRODUCT_BUTTON)
    private WebElement product_add_review_button;

    @FindBy(xpath = REVIEW_RATING_EXELENT_FOR_PRODUCT)
    private WebElement product_review_rating_exelent;

    @FindBy(xpath = CONFIRM_REVIEW_BUTTON_FOR_ORDER)
    private WebElement confirm_review_for_order_button;

    @FindBy(xpath = ORDER_REVIEW_FORM_EXPAND_BUTTON)
    private WebElement order_review_form_expand_button;

    @FindBy(xpath = REVIEW_FIRST_RATING_EXELENT_FOR_ORDER)
    private WebElement review_first_rating_exelent_for_order;

    @FindBy(xpath = REVIEW_SECOND_RATING_EXELENT_FOR_ORDER)
    private WebElement review_second_rating_exelent_for_order;

    @FindBy(xpath = REVIEW_THIRD_RATING_EXELENT_FOR_ORDER)
    private WebElement review_third_rating_exelent_for_order;

    @FindBy(xpath = REVIEW_THIRD_RATING_BAD_FOR_ORDER)
    private WebElement review_third_rating_bad_for_order;

    @FindBy(xpath = REVIEW_SIZE_CAUSE_RADIO_FOR_ORDER)
    private WebElement review_size_cause_radio_for_order;

    @FindBy(xpath = REVIEW_SMALL_SIZE_CAUSE_RADIO_FOR_ORDER)
    private WebElement review_small_size_cause_radio_for_order;

//======================================================================
    public void sendReviewToTextAreaForProduct(String review) {
        product_review_textarea.clear();
        product_review_textarea.sendKeys(review);
    }

    public void sendReviewToTextAreaForOrder(String review) {
        review_textarea_for_order.clear();
        review_textarea_for_order.sendKeys(review);
    }

    public void clickAddReviewForProductButton() {
        product_add_review_button.click();
    }

    public void clickOrderReviewFormExpandButton() {
        order_review_form_expand_button.click();
    }

    public void clickOrderReviewConfirmButton() {
        ROBBY.rob.delay(300);
        confirm_review_for_order_button.click();
    }

    public boolean selectReviewExelentRatingForProduct() {
        ROBBY.rob.delay(300);
        product_review_rating_exelent.click();
        return super.presence(5, $PRODUCT_REVIEW_RATING_EXELENT_FILL);
    }

    public boolean selectReviewExelentFirstRatingForOrder() {
        ROBBY.rob.delay(300);
        review_first_rating_exelent_for_order.click();
        return super.presence(5, $REVIEW_FIRST_RATING_EXELENT_FOR_ORDER_FILL);
    }

    public boolean selectReviewExelentSecondRatingForOrder() {
        ROBBY.rob.delay(300);
        review_second_rating_exelent_for_order.click();
        return super.presence(5, $REVIEW_SECOND_RATING_EXELENT_FOR_ORDER_FILL);
    }

    public boolean selectReviewExelentThirdRatingForOrder() {
        ROBBY.rob.delay(300);
        review_third_rating_exelent_for_order.click();
        return super.presence(5, $REVIEW_THIRD_RATING_EXELENT_FOR_ORDER_FILL);
    }

    public boolean selectReviewBadThirdRatingForOrder() {
        ROBBY.rob.delay(300);
        review_third_rating_bad_for_order.click();
        return super.presence(5, $REVIEW_THIRD_RATING_BAD_FOR_ORDER_FILL);
    }

    public void selectSizeProblemCauseRadioForOrder() {
        ROBBY.rob.delay(300);
        review_size_cause_radio_for_order.click();
    }

    public void selectSmallSizeProblemCauseRadioForOrder() {
        ROBBY.rob.delay(300);
        review_small_size_cause_radio_for_order.click();
    }

    public boolean w_ReviewThanksMessageSucces_visibility(int time) {
        return super.visibility(time, $REVIEW_THANKS_MESSAGE_SUCCES);
    }

    public boolean w_OrderReviewAllEmptyRatingError_visibility(int time) {
        return super.visibility(time, $ERROR_ALL_RATING_EMPTY);
    }

    public boolean w_OrderReviewEmptyCauseError_visibility(int time) {
        return super.visibility(time, $ERROR_CAUSE_EMPTY);
    }

    public boolean w_OrderReviewEmptyAccurateCauseError_visibility(int time) {
        return super.visibility(time, $ERROR_ACCURATE_CAUSE_EMPTY);
    }

    public boolean w_OrderReviewEmptyCommentError_visibility(int time) {
        return super.visibility(time, $ERROR_COMMENT_EMPTY);
    }
}
