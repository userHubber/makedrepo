package kng.objects;

import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import kng.helpers.Roboto;

public class Obj_AccBrands extends Waitings {

    private final Roboto ROBBY;

    public Obj_AccBrands(WebDriver wd) {
        super(wd);
        ROBBY = new Roboto();
        PageFactory.initElements(wd, this);
    }
    //==================================================================    

//String---------------------------------------------------------    
    private static final String SUBSCRIBED_LIST = "//tr[@class='list-brand']";
    private static final String UNSUBSCRIBED_BUTTON = "//a[@class='js-unsubscribe-brand']";
    private static final String NON_SUBSCRIBED_MESSAGE = "//span[text()='В настоящее время у вас нет подписки на бренды.']";

//By----------------------------------------------------------------
    private final By $SUBSCRIBED_LIST = By.xpath(SUBSCRIBED_LIST);
    private final By $UNSUBSCRIBED_BUTTON = By.xpath(UNSUBSCRIBED_BUTTON);
    private final By $NON_SUBSCRIBED_MESSAGE = By.xpath(NON_SUBSCRIBED_MESSAGE);

//find--------------------------------------------------------------
    @FindBy(xpath = SUBSCRIBED_LIST)
    private WebElement subscribed_list;

    @FindBy(xpath = UNSUBSCRIBED_BUTTON)
    private WebElement unsubscribed_button;

//------------------------------------------------------------------
    public int countSubscribedBrands() {
        return subscribed_list.findElements($SUBSCRIBED_LIST).size();
    }

    public void clickedAllSubscribedBrands() {
        ArrayList<WebElement> fav = new ArrayList<>();
        fav.addAll(unsubscribed_button.findElements($UNSUBSCRIBED_BUTTON));
        fav.forEach(($fav) -> {
            $fav.click();
            ROBBY.rob.delay(200);
        });
    }

    public boolean w_NonSubscribedMessage_visibility(int time) {
        return super.visibility(time, $NON_SUBSCRIBED_MESSAGE);
    }
}
