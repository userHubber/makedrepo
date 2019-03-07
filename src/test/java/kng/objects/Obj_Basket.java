package kng.objects;

import java.util.ArrayList;
import kng.helpers.Roboto;
import kng.helpers.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Obj_Basket extends Waitings {

    private final Roboto ROBBY;

    public Obj_Basket(WebDriver wd) {
        super(wd);
        ROBBY = new Roboto();
        PageFactory.initElements(wd, this);
    }
//==================================================================    

//String---------------------------------------------------------    
//By----------------------------------------------------------------
//find--------------------------------------------------------------
    
//------------------------------------------------------------------
    public boolean w_basketUrl(int time) {
        return super.urlContains(time, "basket");
    }
}
