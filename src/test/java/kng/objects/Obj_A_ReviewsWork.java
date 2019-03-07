package kng.objects;

import java.util.ArrayList;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Obj_A_ReviewsWork extends Waitings {

    private final WebDriver OBJECT_WD;

    public Obj_A_ReviewsWork(WebDriver wd) {
        super(wd);
        OBJECT_WD = wd;
        PageFactory.initElements(wd, this);
    }
//====================================================================
//dinamyc-------------------------------------------------

    private WebElement getReviewElement(String review) {

        ArrayList<WebElement> reviewBlocks = new ArrayList<>();
        reviewBlocks.addAll($REVIEWS_BLOCKS.findElements(OBJECT_WD));
        for (WebElement $reviewBlocks : reviewBlocks) {
            if ($reviewBlocks.getText().contains(review)) {
                return $reviewBlocks;
            }
        }
        return null;
    }

//String-------------------------------------------------
    private static final String REVIEWS_BLOCKS = "//tr[@data-id]";

//By--------------------------------------------------------------------
    private final By $REVIEWS_BLOCKS = By.xpath(REVIEWS_BLOCKS);

//===========================================================================
    public boolean getFindingReview(String review) {
        if (getReviewElement(review) != null) {
            return true;
        }
        return false;
    }

}
