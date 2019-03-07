package kng.objects;

import java.util.ArrayList;
import kng.helpers.Roboto;
import kng.helpers.Waitings;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_Ymap extends Waitings {

    private final Roboto ROBBY;
    private final Actions ACTIONS;

    public Obj_Ymap(WebDriver wd) {
        super(wd);
        ROBBY = new Roboto();
        ACTIONS = new Actions(wd);
        PageFactory.initElements(wd, this);
    }

    //String-----------------------------------------------------------------------------
    private static final String YMAPS_MODAL = "modal-dialog";//модалка с картой яндекс 
    private static final String MARKET_BUBBLE_BUTTON = "*//button[text()='Выбрать']";//Кнопка Выбрать в Бабле магазина 
    private static final String SEARCH_PANEL = "*//input[@placeholder='Адрес или объект']";
    private static final String SEARCH_PANEL_BUTTON = "*//ymaps[text()='Найти']";
    private static final String PVZ_IN_FILTERS = "//img[@class='img-icon']/parent::ymaps";

    //By--------------------------------------------------------------------------------- 
    private final By $YMAPS_MODAL = By.className(YMAPS_MODAL);
    private final By $MARKET_BUBBLE_BUTTON = By.xpath(MARKET_BUBBLE_BUTTON);
    private final By $SEARCH_PANEL = By.xpath(SEARCH_PANEL);
    private final By $PVZ_IN_FILTERS = By.xpath(PVZ_IN_FILTERS);

    //Find--------------------------------------------------------------------------------- 
    @FindBy(className = YMAPS_MODAL)
    private WebElement ymaps_modal;

    @FindBy(xpath = MARKET_BUBBLE_BUTTON)
    private WebElement market_bubble_button;

    @FindBy(xpath = SEARCH_PANEL)
    private WebElement search_panel;

    @FindBy(xpath = SEARCH_PANEL_BUTTON)
    private WebElement search_panel_button;

    @FindBy(xpath = PVZ_IN_FILTERS)
    private WebElement pvz_in_filters;

    //-------------------------------------------------------------------------------------
    public boolean w_YmapsModal_visibility(int time) {
        return super.visibility(time, $YMAPS_MODAL);
    }

    public boolean w_SearchPanel_visibility(int time) {
        return super.visibility(time, $SEARCH_PANEL);
    }

    public boolean w_MarketBubbleButton_visibility(int time) {
        return super.visibility(time, $MARKET_BUBBLE_BUTTON);
    }

    public void sendKeysToSearchPanelYm(String marketAdress) {
        search_panel.sendKeys(marketAdress);
    }

    public void clickSearchPanelButton() {
        ROBBY.rob.delay(500);
        search_panel_button.click();
    }

    public void clickToCenterModalMap() {
        ROBBY.rob.delay(2000);
        int y = (ymaps_modal.getSize().height) / 2;
        int x = (ymaps_modal.getSize().width) / 2;
        ACTIONS.moveToElement(ymaps_modal, x, y).click().build().perform();
    }

    public void clickMarketBubbleButton() {
        market_bubble_button.click();
    }

    public ArrayList<String> listPvzFromFilter() {
        ArrayList<WebElement> pvz = new ArrayList<>();
        ArrayList<String> pvzNames = new ArrayList<>();
        pvz.addAll(pvz_in_filters.findElements($PVZ_IN_FILTERS));
        for (WebElement pvzName : pvz) {
            pvzNames.add(pvzName.getText());
        }
        return pvzNames;
    }
}
