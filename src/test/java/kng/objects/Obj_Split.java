package kng.objects;

import kng.helpers.Roboto;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class Obj_Split extends Waitings {

    private final Roboto ROBBY;
    private final Actions ACTIONS;
    private ArrayList<WebElement> dateList;

    public Obj_Split(WebDriver wd) {
        super(wd);
        ROBBY = new Roboto();
        ACTIONS = new Actions(wd);
        PageFactory.initElements(wd, this);
    }
//String-----------------------------------------------------------    
    private static final String DATE_SELECT_DROP = "//div[@class='select-block']//select[@data-elem='interval-date']";
    private static final String DATE_DROP_LIST = "//div[@class='select-block']//select[@data-elem='interval-date']//option[@value]";
    private static final String SELECTED_WAREHOUSE_DATE = "//div[@class='button-block']//span[@data-elem='select-date']";
    private static final String CONFIRM_SPLIT_BUTTON = "confirm-split";

//By------------------------------------------------------------------
    private final By $DATE_DROP_LIST = By.xpath(DATE_DROP_LIST);
    private final By $SELECTED_WAREHOUSE_DATE = By.xpath(SELECTED_WAREHOUSE_DATE);
//find--------------------------------------------------------------
    @FindBy(xpath = DATE_SELECT_DROP)
    private WebElement high_table_contain;

    @FindBy(xpath = DATE_DROP_LIST)
    private WebElement date_drop_list;

    @FindBy(id = CONFIRM_SPLIT_BUTTON)
    private WebElement confirm_split_button;
//==========================================================

    public boolean w_SplitPage_urlContain(int time) {
        return super.urlContains(time, "split");
    }

    public void dropForSelectedDate() {
        ACTIONS.moveToElement(high_table_contain).click().build().perform();
    }

    public ArrayList<String> getDropDateList() {
        ArrayList<String> avaibleDate = new ArrayList<>();
        dateList = new ArrayList<>();
        dateList.addAll(date_drop_list.findElements($DATE_DROP_LIST));

        for (int i = 0; i < dateList.size(); i++) {
            avaibleDate.add(dateList.get(i).getText());
        }
        return avaibleDate;
    }

    public String getSecondAvailableDateFromDropListAndClick() {
        dateList.get(3).click();
        return dateList.get(3).getText();
    }

    public boolean w_selectedWarehoseDate_toBe(int time, String warehoseDate) {
        return super.textToBe(time, warehoseDate, $SELECTED_WAREHOUSE_DATE);
    }

    public void clickConfirmSplitButton() {
        confirm_split_button.click();
    }
}
