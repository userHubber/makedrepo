package kng.objects;

import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_AllBrandsPage extends Waitings {

    public Obj_AllBrandsPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

//String------------------------------------------------------------
    private static final String SUBSCRIBE_FLAG = "//button[@data-js='brand-subscribe']";
    private static final String BRAND_IN_TABLE = "//li[@class='brand-item']//a[@class='brand-name']";

//By-----------------------------------------------------------
    private final By $SUBSCRIBE_FLAG = By.xpath(SUBSCRIBE_FLAG);
    private final By $BRAND_IN_TABLE = By.xpath(BRAND_IN_TABLE);

//Find------------------------------------------------------------    
    @FindBy(xpath = SUBSCRIBE_FLAG)
    private WebElement subscribe_flag;

    @FindBy(xpath = BRAND_IN_TABLE)
    private WebElement brand_in_table;

//--------------------------------------------------------------
    public boolean w_BrandSubscribeTrue_attr(int time) {
        return super.attributeContains(time, "data-subscribed", "true", $SUBSCRIBE_FLAG);
    }

    public void clickBrandSubscribeFlag() {
        subscribe_flag.click();
    }
}
