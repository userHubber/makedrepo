package kng.driver;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.Cookie;
import kng.helpers.Roboto;

public class DriverMethods extends DriverProperties {

    private final Roboto ROBBY;

    public DriverMethods() {
        ROBBY = new Roboto();
    }

    protected void driverClose() {
        wd.close();
    }

    protected void driverCloseQuit() {
        wd.close();
        wd.quit();
    }

    public void driverGet(String url) {
        wd.get(url);
    }

    protected void driverClear() {
        wd.manage().deleteAllCookies();
    }

    protected Set<Cookie> getAllCookies() {
        return wd.manage().getCookies();
    }

    protected String getUrl() {
        return wd.getCurrentUrl();
    }

    protected void refreshPage() {
        wd.navigate().refresh();
    }

    protected void openNewTab() {
        ROBBY.rob.keyPress(KeyEvent.VK_CONTROL);
        ROBBY.rob.keyPress(KeyEvent.VK_T);
        ROBBY.rob.keyRelease(KeyEvent.VK_CONTROL);
        ROBBY.rob.keyRelease(KeyEvent.VK_T);
        ROBBY.rob.delay(2000);
        ArrayList<String> newTab = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(newTab.get(1));
    }

    protected void focusFirstTab() {
        ArrayList<String> newTab = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(newTab.get(0));
    }

    protected void focusSecondTab() {
        ArrayList<String> newTab = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(newTab.get(1));
    }

    protected String getPageSource() {
        return wd.getPageSource();
    }

    protected void acceptAlert() {
        wd.switchTo().alert().accept();
    }
}
