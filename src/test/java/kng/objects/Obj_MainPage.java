package kng.objects;

import kng.helpers.Waitings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class Obj_MainPage extends Waitings {

    public Obj_MainPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

//String-----------------------------------------------------------
    //вход на хедере 
    private static final String HEADER_ENTER = "//*[@id=\"quick-menu\"]//span[text()='Вход']";
    private static final String HEADER_FAVORITE_ICON = "//*[@id=\"quick-menu\"]//a[@data-elem='favorites']";
    private static final String FOOTER = "//*[@data-elem='footer']";

//By----------------------------------------
    private final By $ENTER = By.xpath(HEADER_ENTER);
    private final By $FAVORITE_ICON = By.xpath(HEADER_FAVORITE_ICON);

//Finds------------------------------------------------------    
    @FindBy(xpath = HEADER_ENTER)
    private WebElement header_enter;

    @FindBy(xpath = HEADER_FAVORITE_ICON)
    private WebElement header_favorite_icon;

    @FindBy(xpath = FOOTER)
    private WebElement footer;
//==============================================================================

    public String getCountFromHeaderFavor() {
        return header_favorite_icon.getAttribute("data-num");
    }

    public boolean w_HeaderFavor_attrContain(int time, String value) {
        return super.attributeContains(time, "data-num", value, $FAVORITE_ICON);
    }

    public boolean w_HeaderEnter_invisibility(int time) {
        return super.invisibility(time, $ENTER);
    }
    
    public boolean w_HeaderEnter_visibility(int time) {
        return super.visibility(time, $ENTER);
    }

    public void clickHeaderEnter() {
        header_enter.click();
    }

    public String getFooterText() {
        return footer.getText();
    }

}
