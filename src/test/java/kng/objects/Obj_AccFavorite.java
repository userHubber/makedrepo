package kng.objects;

import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import kng.helpers.Roboto;

public class Obj_AccFavorite extends Waitings {

    private final Roboto ROBBY;
    private final WebDriver OBJECTWD;

    public Obj_AccFavorite(WebDriver wd) {
        super(wd);
        OBJECTWD = wd;
        ROBBY = new Roboto();
        PageFactory.initElements(wd, this);
    }
//==================================================================    
//dinamyc-------------------------------------------------

    private WebElement getAviableSize(String size) {
        String intern = "//*[@id=\"item-0\"]/optgroup/option";
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
//String---------------------------------------------------------    
    private static final String FAVOR_ICON = "//button[@data-js='product-subscribe']";
    private static final String SIZES_DROP = "item-0";
    private static final String ADD_PRODUCT_TO_BASKET_BUTTON = "//button[@data-elem='add-to-basket']";

//By----------------------------------------------------------------
    private final By $FAVOR_ICON = By.xpath(FAVOR_ICON);

//find--------------------------------------------------------------
    @FindBy(xpath = FAVOR_ICON)
    private WebElement favor_icon;

    @FindBy(id = SIZES_DROP)
    private WebElement sizes_drop;

    @FindBy(xpath = ADD_PRODUCT_TO_BASKET_BUTTON)
    private WebElement add_product_to_basket_button;

//------------------------------------------------------------------
    public int countFavorProduct() {
        return favor_icon.findElements($FAVOR_ICON).size();
    }

    public void clickedAllFavorIcon() {
        ArrayList<WebElement> fav = new ArrayList<>();
        fav.addAll(favor_icon.findElements($FAVOR_ICON));
        fav.forEach(($fav) -> {
            $fav.click();
            ROBBY.rob.delay(200);
        });
    }

    public void clickAvaibleSize(String av_Size) {
        sizes_drop.click();
        this.getAviableSize(av_Size).click();
    }

    public void clickAddProductToBasketButton() {
        add_product_to_basket_button.click();
    }

}
