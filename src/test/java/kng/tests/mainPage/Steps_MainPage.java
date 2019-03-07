package kng.tests.mainPage;

import kng.objects.Obj_MainPage;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class Steps_MainPage {

    private final Obj_MainPage MAINPAGE;
//--------------------------------------------

    public Steps_MainPage(WebDriver wd) {
        MAINPAGE = new Obj_MainPage(wd);
    }
//===========================================================================

    public void footerContentControl(String currentFooterContent) {
        String actualfooterContent = MAINPAGE.getFooterText();
        assertEquals(actualfooterContent, currentFooterContent,
                "контент в футере -\n" + actualfooterContent + "\n-------------------------------------"
                + "\nвместо -\n" + currentFooterContent);
    }
}
