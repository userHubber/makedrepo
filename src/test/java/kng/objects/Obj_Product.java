package kng.objects;

import kng.helpers.Roboto;
import kng.helpers.Waitings;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_Product extends Waitings {

    private final WebDriver OBJECTWD;
    private final Roboto ROBBY;

    public Obj_Product(WebDriver wd) {
        super(wd);
        OBJECTWD = wd;
        ROBBY = new Roboto();
        PageFactory.initElements(wd, this);
    }
//=================================================================

//dinamyc-------------------------------------------------
    private WebElement getAviableSize(String size) {
        String intern = "//*[@id=\"sizes-block\"]//label[@for]";
        By $intern = By.xpath(intern);

        ArrayList<WebElement> sizesBlocks = new ArrayList<>();
        sizesBlocks.addAll($intern.findElements(OBJECTWD));

        for (WebElement $size : sizesBlocks) {
            if ($size.getText().contains(size)) {
                return $size;
            }
        }

        return null;
    }

//Strings==========================================================
    private static final String PRICE = "//div[@itemprop='offers']//span";
    private static final String BRAND_SUBSCRIBE = "//button[@data-js='brand-subscribe']";
    private static final String FAVOR_ICON = "//div[@class='product-cart']//button[@data-js='product-subscribe']";
    private static final String BRAND = "//a[@class='brand']";
    private static final String REVIEW_BUTTON_WRITE = "//div[@class='add-review-block']";
    private static final String REVIEW_BUTTON_ADD = "add-review";
    private static final String REVIEW_TEXTAREA = "review";
    private static final String REVIEW_RATING_EXELENT = "//*[@id=\"review-form\"]//div[@class='rating']/span[1][@class='star']";
    private static final String REVIEW_RATING_EXELENT_FILL = "//*[@id=\"review-form\"]//div[@class='rating']/span[1][@class='star fill']";
    private static final String REVIEW_RATING_BAD = "//*[@id=\"review-form\"]//div[@class='rating']/span[4][@class='star']";
    private static final String REVIEW_RATING_BAD_FILL = "//*[@id=\"review-form\"]//div[@class='rating']/span[4][@class='star fill']";
    private static final String REVIEW_RATING_BAD_REASON = "//label[@for='reason4']";
    private static final String REVIEW_THANKS_MESSAGE_SUCCES = "//div[text()='Спасибо за ваш отзыв!']";
    private static final String REVIEW_SHOT_TEXT_ERROR_RAITING_WITHOUT = "//span[@class='error'and text()='Укажите оценку. Также текст отзыва слишком короткий']";
    private static final String REVIEW_SHOT_TEXT_ERROR_RAITING_GOOD = "//span[@class='error'and text()='Слишком короткий текст']";
    private static final String REVIEW_SHOT_TEXT_ERROR_RAITING_BAD = "//span[@class='error'and text()='Слишком короткий текст. Tакже укажите причину низкой оценки']";
    private static final String REVIEW_CORRECT_TEXT_ERROR_RAITING_WITHOUT = "//span[@class='error'and text()='Укажите оценку (количество звёзд)']";
    private static final String ADD_TO_BASKET = "addToBasket";
    private static final String NO_COUPON_MESSAGE = "//span[text()='Действие купонов и промокодов на данную "
            + "акцию не распространяется, кроме персональных предложений.']";
    private static final String BASKET_POPUP = "//a[@data-id='basketURL']";

//By====================================================================
    private final By $BRANDS_SUBSCRIBE = By.xpath(BRAND_SUBSCRIBE);
    private final By $FAVOR_ICON = By.xpath(FAVOR_ICON);
    private final By $REVIEW_SHOT_TEXT_ERROR_RAITING_WITHOUT = By.xpath(REVIEW_SHOT_TEXT_ERROR_RAITING_WITHOUT);
    private final By $REVIEW_SHOT_TEXT_ERROR_RAITING_GOOD = By.xpath(REVIEW_SHOT_TEXT_ERROR_RAITING_GOOD);
    private final By $REVIEW_SHOT_TEXT_ERROR_RAITING_BAD = By.xpath(REVIEW_SHOT_TEXT_ERROR_RAITING_BAD);
    private final By $REVIEW_CORRECT_TEXT_ERROR_RAITING_WITHOUT = By.xpath(REVIEW_CORRECT_TEXT_ERROR_RAITING_WITHOUT);
    private final By $BRAND = By.xpath(BRAND);
    private final By $REVIEW_TEXTAREA = By.id(REVIEW_TEXTAREA);
    private final By $REVIEW_BUTTON_ADD = By.id(REVIEW_BUTTON_ADD);
    private final By $REVIEW_RATING_EXELENT_FILL = By.xpath(REVIEW_RATING_EXELENT_FILL);
    private final By $REVIEW_RATING_BAD_FILL = By.xpath(REVIEW_RATING_BAD_FILL);
    private final By $REVIEW_RATING_BAD_REASON = By.xpath(REVIEW_RATING_BAD_REASON);
    private final By $REVIEW_THANKS_MESSAGE_SUCCES = By.xpath(REVIEW_THANKS_MESSAGE_SUCCES);
    private final By $NO_COUPON_MESSAGE = By.xpath(NO_COUPON_MESSAGE);
    private final By $BASKET_POPUP = By.xpath(BASKET_POPUP);

//Find============================================================
    @FindBy(id = ADD_TO_BASKET)
    private WebElement add_to_basket;

    @FindBy(xpath = PRICE)
    private WebElement price;

    @FindBy(xpath = BASKET_POPUP)
    private WebElement basket_popup;

    @FindBy(xpath = BRAND_SUBSCRIBE)
    private WebElement brand_subscribe;

    @FindBy(xpath = FAVOR_ICON)
    private WebElement favor_icon;

    @FindBy(xpath = BRAND)
    private WebElement brand;

    @FindBy(xpath = REVIEW_BUTTON_WRITE)
    private WebElement review_button_write;

    @FindBy(id = REVIEW_TEXTAREA)
    private WebElement review_textarea;

    @FindBy(id = REVIEW_BUTTON_ADD)
    private WebElement review_button_add;

    @FindBy(xpath = REVIEW_RATING_EXELENT)
    private WebElement review_rating_exelent;

    @FindBy(xpath = REVIEW_RATING_BAD)
    private WebElement review_rating_bad;

    @FindBy(xpath = REVIEW_RATING_BAD_REASON)
    private WebElement review_rating_bad_reason;

//======================================================================
    public int getPrice() {
        return Integer.parseInt(price.getText().replaceAll("\\s+", "").replaceAll("[^0-9]", ""));
    }

    public void clickCheckBoxAnotherReason() {
        ROBBY.rob.delay(200);
        review_rating_bad_reason.click();
    }

    public void clickAddReviewButton() {
        review_button_add.click();
    }

    public void clickReviewButtonWrite() {
        review_button_write.click();
    }

    public void clickBrandSubscribe() {
        brand_subscribe.click();
    }

    public void clickFavorIcon() {
        favor_icon.click();
    }

    public boolean sendReviewBadRating() {
        ROBBY.rob.delay(500);
        review_rating_bad.click();
        return super.presence(5, $REVIEW_RATING_BAD_FILL);

    }

    public boolean sendReviewExelentRating() {
        ROBBY.rob.delay(500);
        review_rating_exelent.click();
        return super.presence(5, $REVIEW_RATING_EXELENT_FILL);
    }

    public void sendReviewToTextArea(String revier) {
        review_textarea.sendKeys(revier);
    }

    public boolean w_BrandSubscribeTrue_attr(int time) {
        return super.attributeContains(time, "data-subscribed", "true", $BRANDS_SUBSCRIBE);
    }

    public boolean w_BadRatingReasonAnother_visibility(int time) {
        return super.visibility(time, $REVIEW_RATING_BAD_REASON);
    }

    public boolean w_ReviewCorrectTextErrorRatingWithout_visibility(int time) {
        return super.visibility(time, $REVIEW_CORRECT_TEXT_ERROR_RAITING_WITHOUT);
    }

    public boolean w_ReviewThanksMessageSucces_visibility(int time) {
        return super.visibility(time, $REVIEW_THANKS_MESSAGE_SUCCES);
    }

    public boolean w_ReviewShotTextErrorRatingWithout_visibility(int time) {
        return super.visibility(time, $REVIEW_SHOT_TEXT_ERROR_RAITING_WITHOUT);
    }

    public boolean w_ReviewShotTextErrorRatingGood_visibility(int time) {
        return super.visibility(time, $REVIEW_SHOT_TEXT_ERROR_RAITING_GOOD);
    }

    public boolean w_ReviewShotTextErrorRatingBad_visibility(int time) {
        return super.visibility(time, $REVIEW_SHOT_TEXT_ERROR_RAITING_BAD);
    }

    public boolean w_ReviewButtonAdd_clickable(int time) {
        return super.clickable(time, $REVIEW_BUTTON_ADD);
    }

    public boolean w_ReviewTextarea_visibility(int time) {
        return super.visibility(time, $REVIEW_TEXTAREA);
    }

    public boolean w_FavorIcon_visibility(int time) {
        return super.visibility(time, $FAVOR_ICON);
    }

    public boolean w_BasketPopup_visibility(int time) {
        return super.visibility(time, $BASKET_POPUP);
    }

    public boolean w_NoCouponMessage_visibility(int time) {
        return super.visibility(time, $NO_COUPON_MESSAGE);
    }

    public void clickProductToBasketButton() {
        add_to_basket.click();
    }

    public String getBasketUrl() {
        return basket_popup.getAttribute("href");
    }

    public void clickAviableSize(String size) {
        this.getAviableSize(size).click();
        ROBBY.rob.delay(100);
    }
}
